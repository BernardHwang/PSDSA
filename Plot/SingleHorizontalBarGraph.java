package Plot;

import java.awt.*;
import javax.swing.*;

public class SingleHorizontalBarGraph extends JPanel {
    // Data for the horizontal bar graph
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

    double[] elapsedTimes = {49, 68, 71.16667, 80.5, 79.5, 76.5, 42, 114};  // Elapsed times for each case

    int leftMargin = 350; // Increase left margin for category labels to prevent overlap
    int barHeight = 15; // Height of each bar
    int categorySpacing = 30; // Spacing between categories
    int topMargin = 50; // Top margin to reduce blank space
    int bottomMargin = 100; // Bottom margin for x-axis label

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

    // Main method to display the graph
    public static void main(String[] args) {
        JFrame frame = new JFrame("Horizontal Bar Graph for Sorting 100k Words");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);  // Set frame size, increased for better layout
        frame.add(new SingleHorizontalBarGraph());
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make frame visible
    }
}
