package Plot;

import java.awt.*;
import javax.swing.*;

public class SingleHorizontalBarGraph extends JPanel {
    private String[] categories;   // Categories for the graph
    private double[] elapsedTimes; // Data (elapsed times) for each category
    private int leftMargin = 350;  // Left margin for category labels
    private int barHeight = 15;    // Height of each bar
    private int categorySpacing = 30; // Spacing between categories
    private int topMargin = 50;    // Top margin to reduce blank space
    private int bottomMargin = 100; // Bottom margin for x-axis label

    // Constructor to accept custom dataset
    public SingleHorizontalBarGraph(String[] categories, double[] elapsedTimes) {
        this.categories = categories;
        this.elapsedTimes = elapsedTimes;
    }

    @Override
    protected void paintComponent(Graphics grf) {
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D) grf;

        // Enable antialiasing for smoother graphics
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get panel dimensions
        int width = getWidth();
        int height = getHeight();

        // Calculate scaling factors for the graph
        double maxTime = getMaxTime();
        double xScale = (double) (width - leftMargin - 150) / maxTime; // Adjust the width scale

        // Determine the total height occupied by all bars and calculate vertical centering
        int totalBarsHeight = (barHeight + categorySpacing) * categories.length;
        int yStart = (height - totalBarsHeight - bottomMargin) / 2 + topMargin; // Centered start position for the bars

        // Set font for axis labels
        graph.setFont(new Font("Arial", Font.BOLD, 12));

        // Plot the bars for each category
        for (int i = 0; i < categories.length; i++) {
            int y = yStart + i * (barHeight + categorySpacing); // Y position for each bar

            // Bar width for elapsed times
            int barWidth = (int) (elapsedTimes[i] * xScale);
            graph.setPaint(new Color(100, 149, 237));  // Cornflower blue color for the bars
            graph.fillRect(leftMargin, y, barWidth, barHeight);

            // Draw category labels (aligned to the left)
            graph.setPaint(Color.BLACK);
            graph.drawString(categories[i], leftMargin - 230, y + barHeight / 2 + 5); // Adjust for more space

            // Draw values inside bars
            graph.setPaint(Color.WHITE);
            graph.drawString(String.valueOf(elapsedTimes[i]), leftMargin + 5, y + barHeight / 2 + 5);
        }

        // Draw x-axis label
        graph.setPaint(Color.BLACK);
        graph.drawString("Elapsed Time (ms)", width / 2 - 50, height - bottomMargin);
    }

    // Get the maximum time value to scale the bars
    private double getMaxTime() {
        double max = Double.MIN_VALUE;
        for (double time : elapsedTimes) {
            if (time > max) max = time;
        }
        return max;
    }

    // Function to create a new JFrame for each graph window
    public static void createWindow(String title, String[] categories, double[] elapsedTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only this window on exit
        frame.setSize(1000, 600);  // Set frame size
        frame.add(new SingleHorizontalBarGraph(categories, elapsedTimes));  // Add the graph to the frame
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);  // Make frame visible
    }

    // Main method to create separate windows for different datasets
    public static void main(String[] args) {
        // First dataset (Sorting 1M Numbers)
        String[] categories = {
            "25% sorted (4 partition sorted)",
            "25% sorted (3 partition sorted)",
            "25% sorted (2 partition sorted)",
            "25% sorted (1 partition sorted)",
            "50% sorted",
            "75% sorted",
            "100% sorted",
            "Reverse-ordered sorted"
        };
        // Selection Sort
        double[] elapsedTimes1 = {52026, 57761.75, 73724.33333, 81862.75, 77600, 66765.5, 45770, 85280}; 

        // Merge Sort
        double[] elapsedTimes2 = {16, 18.75, 21.66666667, 24.25, 21.5, 16.5, 13, 31}; 

        // Comb Sort
        double[] elapsedTimes3 = {49, 68, 71.16667, 80.5, 79.5, 76.5, 42, 114}; 

        //Counting Sort
        double[] elapsedTimes4 = {33, 33.25, 34, 35.75, 54, 57, 33, 80};  // Elapsed times for the new dataset

        // Create multiple windows for different datasets
        createWindow("Sorting Selection Sort", categories, elapsedTimes1);
        createWindow("Sorting Merge Sort", categories, elapsedTimes2);
        createWindow("Sorting Comb Sort", categories, elapsedTimes3);
        createWindow("Sorting Counting Sort", categories, elapsedTimes4);
    }
}
