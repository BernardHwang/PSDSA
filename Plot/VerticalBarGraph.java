package Plot;

import java.awt.*;
import javax.swing.*;

public class VerticalBarGraph extends JPanel {
    // Instance variables for custom datasets
    private String[] categories;
    private int[] duplicateTimes;
    private int[] nonDuplicateTimes;

    int margin = 60; // Margins for the graph
    int barWidth = 50; // Width of the bars

    // Constructor to accept custom datasets
    public VerticalBarGraph(String[] categories, int[] duplicateTimes, int[] nonDuplicateTimes) {
        this.categories = categories;
        this.duplicateTimes = duplicateTimes;
        this.nonDuplicateTimes = nonDuplicateTimes;
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
        int maxTime = getMaxTime();
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

            // Bar height for duplicate times
            int duplicateBarHeight = (int) (duplicateTimes[i] * yScale);
            graph.setPaint(Color.GRAY);
            graph.fillRect(x, height - margin - duplicateBarHeight, barWidth, duplicateBarHeight);

            // Bar height for non-duplicate times
            int nonDuplicateBarHeight = (int) (nonDuplicateTimes[i] * yScale);
            graph.setPaint(Color.ORANGE);
            graph.fillRect(x + barWidth + 10, height - margin - nonDuplicateBarHeight, barWidth, nonDuplicateBarHeight);

            // Draw category labels
            graph.setPaint(Color.BLACK);
            graph.drawString(categories[i], x, height - margin + 20);

            // Draw values above bars
            graph.drawString(String.valueOf(duplicateTimes[i]), x, height - margin - duplicateBarHeight - 5);
            graph.drawString(String.valueOf(nonDuplicateTimes[i]), x + barWidth + 10, height - margin - nonDuplicateBarHeight - 5);
        }

        // Label y-axis (Elapsed Time)
        graph.rotate(-Math.PI / 2);
        graph.drawString("Elapsed Time (ms)", -height / 2, margin / 3);
        graph.rotate(Math.PI / 2);  // Rotate back

        // Draw the legend (top-right corner)
        drawLegend(graph, width, height);
    }

    // Function to draw the legend in the top-right corner
    private void drawLegend(Graphics2D graph, int width, int height) {
        int legendX = width - 150;
        int legendY = margin;

        // Draw legend background
        graph.setPaint(Color.LIGHT_GRAY);
        graph.fillRect(legendX, legendY, 130, 60);

        // Draw legend border
        graph.setPaint(Color.BLACK);
        graph.drawRect(legendX, legendY, 130, 60);

        // Draw gray box for "duplicate"
        graph.setPaint(Color.GRAY);
        graph.fillRect(legendX + 10, legendY + 10, 15, 15);

        // Draw orange box for "non-duplicate"
        graph.setPaint(Color.ORANGE);
        graph.fillRect(legendX + 10, legendY + 35, 15, 15);

        // Add text labels
        graph.setPaint(Color.BLACK);
        graph.setFont(new Font("Arial", Font.PLAIN, 12));
        graph.drawString("Duplicate", legendX + 30, legendY + 22);
        graph.drawString("Non-duplicate", legendX + 30, legendY + 47);
    }

    // Get the maximum time value to scale the bars
    private int getMaxTime() {
        int max = Integer.MIN_VALUE;
        for (int time : duplicateTimes) {
            if (time > max) max = time;
        }
        for (int time : nonDuplicateTimes) {
            if (time > max) max = time;
        }
        return max;
    }

    // Function to create a new window for each graph
    public static void createWindow(String title, String[] categories, int[] duplicateTimes, int[] nonDuplicateTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only the current window
        frame.setSize(600, 400);
        frame.add(new VerticalBarGraph(categories, duplicateTimes, nonDuplicateTimes));
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }

    // Main method to create multiple windows for different datasets
    public static void main(String[] args) {
        // Selection Sort
        String[] categories = {"Number ArrayList", "Number LinkedList", "Words ArrayList"};
        int[] duplicateTimes1 = {22924, 6482, 25144};       // Duplicate times
        int[] nonDuplicateTimes1 = {7156, 6430, 42286};    // Non-duplicate times

        // Merge Sort
        int[] duplicateTimes2 = {798, 521, 30};       // Duplicate times
        int[] nonDuplicateTimes2 = {896, 971, 46};    // Non-duplicate times

        // Comb Sort
        int[] duplicateTimes3 = {6406, 12320, 81};       
        int[] nonDuplicateTimes3 = {9544, 15603, 118};

        // Counting Sort
        int[] duplicateTimes4= {570, 464, 32};       // Duplicate times
        int[] nonDuplicateTimes4 = {742, 494, 57};    // Non-duplicate times


        // Create windows for the datasets
        createWindow("Graph for Selection Sort", categories, duplicateTimes1, nonDuplicateTimes1); // First graph window
        createWindow("Graph for Merge Sort", categories, duplicateTimes2, nonDuplicateTimes2); // Second graph window
        createWindow("Graph for Comb Sort", categories, duplicateTimes3, nonDuplicateTimes3); // First graph window
        createWindow("Graph for Counting Sort", categories, duplicateTimes4, nonDuplicateTimes4); 
    }
}
