package Plot;

import java.awt.*;
import javax.swing.*;

public class SingleVerticalBarGraph extends JPanel {
    // Instance variables for custom datasets
    private String[] categories;
    private double[] elapsedTimes;

    int margin = 60; // Margins for the graph
    int barWidth = 50; // Width of the bars

    // Constructor to accept custom datasets
    public SingleVerticalBarGraph(String[] categories, double[] elapsedTimes) {
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
        double yScale = (double) (height - 2 * margin) / maxTime;
        int xScale = (width - 2 * margin) / categories.length;

        // Draw x and y axis
        graph.drawLine(margin, margin, margin, height - margin); // Y-axis
        graph.drawLine(margin, height - margin, width - margin, height - margin); // X-axis

        // Set font for axis labels
        graph.setFont(new Font("Arial", Font.BOLD, 14));

        // Draw the bars
        for (int i = 0; i < categories.length; i++) {
            // Calculate x position for the bars in each category
            int x = margin + i * xScale + xScale / 4;

            // Bar height for elapsed times
            int barHeight = (int) (elapsedTimes[i] * yScale);
            graph.setPaint(Color.ORANGE);
            graph.fillRect(x, height - margin - barHeight, barWidth, barHeight);

            // Draw category labels
            graph.setPaint(Color.BLACK);
            graph.drawString(categories[i], x, height - margin + 20);

            // Draw values above bars
            graph.drawString(String.valueOf((int)elapsedTimes[i]), x, height - margin - barHeight - 5);
        }

        // Label y-axis (Elapsed Time)
        graph.rotate(-Math.PI / 2);
        graph.drawString("Elapsed Time (ms)", -height / 2, margin / 3);
        graph.rotate(Math.PI / 2);  // Rotate back
    }

    // Get the maximum time value to scale the bars
    private double getMaxTime() {
        double max = Double.MIN_VALUE;
        for (double time : elapsedTimes) {
            if (time > max) max = time;
        }
        return max;
    }

    // Function to create a new window for the graph
    public static void createWindow(String title, String[] categories, double[] elapsedTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only the current window
        frame.setSize(600, 400);
        frame.add(new SingleVerticalBarGraph(categories, elapsedTimes));
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }

    // Main method to create the graph window for the dataset
    public static void main(String[] args) {
        // Sorting algorithms
        String[] algorithms = {"Selection Sort", "Merge Sort", "Comb Sort", "Counting Sort"};
        
        // Elapsed times for ArrayList (Word) - 10k
        double[] elapsedTimes = {104112, 24, 69, 32};   

        // Create the graph window for elapsed times
        createWindow("Sorting Algorithm Elapsed Times (ArrayList Word - 10k)", algorithms, elapsedTimes);
    }
}

