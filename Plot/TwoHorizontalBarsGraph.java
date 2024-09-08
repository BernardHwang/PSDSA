package Plot;

import java.awt.*;
import javax.swing.*;

public class TwoHorizontalBarsGraph extends JPanel {
    // Instance variables for custom datasets
    private String[] categories;
    private double[] arrayListTimes;
    private double[] linkedListTimes;

    int leftMargin = 300; // Left margin for category labels
    int barHeight = 15; // Height of each bar
    int categorySpacing = 30; // Spacing between categories
    int barSpacing = 5; // Spacing between ArrayList and LinkedList bars
    int topMargin = 50; // Top margin to reduce blank space
    int bottomMargin = 100; // Bottom margin for x-axis label

    // Constructor to accept custom datasets
    public TwoHorizontalBarsGraph(String[] categories, double[] arrayListTimes, double[] linkedListTimes) {
        this.categories = categories;
        this.arrayListTimes = arrayListTimes;
        this.linkedListTimes = linkedListTimes;
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
        int totalBarsHeight = (2 * barHeight + categorySpacing) * categories.length;
        int yStart = (height - totalBarsHeight - bottomMargin) / 2 + topMargin; // Centered start position for the bars

        // Set font for axis labels
        graph.setFont(new Font("Arial", Font.BOLD, 12));

        // Plot the bars top and bottom for each category
        for (int i = 0; i < categories.length; i++) {
            int y = yStart + i * (2 * barHeight + categorySpacing); // Y position for the two bars

            // Bar width for ArrayList times (blue)
            int arrayListBarWidth = (int) (arrayListTimes[i] * xScale);
            graph.setPaint(new Color(41, 128, 185));  // Blue color for ArrayList
            graph.fillRect(leftMargin, y, arrayListBarWidth, barHeight);

            // Bar width for LinkedList times (orange), drawn below the ArrayList bar
            int linkedListBarWidth = (int) (linkedListTimes[i] * xScale);
            graph.setPaint(new Color(243, 156, 18));  // Orange color for LinkedList
            graph.fillRect(leftMargin, y + barHeight + barSpacing, linkedListBarWidth, barHeight);

            // Draw category labels (aligned to the left)
            graph.setPaint(Color.BLACK);
            graph.drawString(categories[i], leftMargin - 250, y + barHeight / 2 + 5); 

            // Draw values inside bars
            graph.setPaint(Color.WHITE);
            graph.drawString(String.valueOf(arrayListTimes[i]), leftMargin + 5, y + barHeight / 2 + 5);
            graph.drawString(String.valueOf(linkedListTimes[i]), leftMargin + 5, y + barHeight + barSpacing + barHeight / 2 + 5);
        }

        // Draw x-axis label
        graph.setPaint(Color.BLACK);
        graph.drawString("Elapsed Time (ms)", width / 2 - 50, height - bottomMargin);

        // Draw the legend at the top-right corner
        drawLegend(graph, width, height);
    }

    // Function to draw the legend
    private void drawLegend(Graphics2D graph, int width, int height) {
        int legendX = width - 200;
        int legendY = 30;

        // Draw legend background
        graph.setPaint(Color.LIGHT_GRAY);
        graph.fillRect(legendX, legendY, 150, 50);

        // Draw legend border
        graph.setPaint(Color.BLACK);
        graph.drawRect(legendX, legendY, 150, 50);

        // Draw blue box for "ArrayList"
        graph.setPaint(new Color(41, 128, 185));
        graph.fillRect(legendX + 10, legendY + 10, 15, 15);

        // Draw orange box for "LinkedList"
        graph.setPaint(new Color(243, 156, 18));
        graph.fillRect(legendX + 10, legendY + 30, 15, 15);

        // Add text labels
        graph.setPaint(Color.BLACK);
        graph.setFont(new Font("Arial", Font.PLAIN, 12));
        graph.drawString("ArrayList", legendX + 30, legendY + 22);
        graph.drawString("LinkedList", legendX + 30, legendY + 42);
    }

    // Get the maximum time value to scale the bars
    private double getMaxTime() {
        double max = Double.MIN_VALUE;
        for (double time : arrayListTimes) {
            if (time > max) max = time;
        }
        for (double time : linkedListTimes) {
            if (time > max) max = time;
        }
        return max;
    }

    // Function to create a new window for each graph
    public static void createWindow(String title, String[] categories, double[] arrayListTimes, double[] linkedListTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only the current window
        frame.setSize(1200, 800); // Increase frame height to avoid cut-off
        frame.add(new TwoHorizontalBarsGraph(categories, arrayListTimes, linkedListTimes));
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }

    // Main method to create multiple windows for different datasets
    public static void main(String[] args) {
        // First dataset
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

        double[] arrayListTimes1 = {274, 379.75, 433.1667, 388, 382.5, 374, 223, 992};  // Number ArrayList times for first dataset
        double[] linkedListTimes1 = {703, 1190.75, 1450.5, 1668.5, 1873, 1498.5, 387, 2266};  // Number LinkedList times for first dataset

        // Second dataset (example, you can add more datasets)
        double[] arrayListTimes2 = {200, 400, 600};     // ArrayList times for second dataset
        double[] linkedListTimes2 = {300, 500, 700};    // LinkedList times for second dataset

        // Comb Sort
        double[] arrayListTimes3 = {274, 379.75, 433.1667, 388, 382.5, 374, 223, 992};  // Number ArrayList times for first dataset
        double[] linkedListTimes3 = {703, 1190.75, 1450.5, 1668.5, 1873, 1498.5, 387, 2266};  // Number LinkedList times for first dataset

        // Counting Sort
        double[] arrayListTimes4 = {274, 379.75, 433.1667, 388, 382.5, 374, 223, 992};  // Number ArrayList times for first dataset
        double[] linkedListTimes4 = {703, 1190.75, 1450.5, 1668.5, 1873, 1498.5, 387, 2266};  // Number LinkedList times for first dataset

        // Create windows for the datasets
        createWindow("Graph for Dataset 1", categories, arrayListTimes1, linkedListTimes1); // First graph window
        createWindow("Graph for Dataset 2", categories, arrayListTimes2, linkedListTimes2); // Second graph window
        createWindow("Graph for Comb Sort", categories, arrayListTimes3, linkedListTimes3); // First graph window
        createWindow("Graph for Dataset 2", categories, arrayListTimes4, linkedListTimes4); // Second graph window
    }
}
