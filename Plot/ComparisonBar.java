package Plot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComparisonBar extends JPanel {
    // Instance variables for custom datasets
    private String[] categories;
    private int[] arrayListTimes;
    private int[] linkedListTimes;

    int margin = 60; // Margins for the graph
    int barWidth = 50; // Width of the bars

    // Constructor to accept custom datasets
    public ComparisonBar(String[] categories, int[] arrayListTimes, int[] linkedListTimes) {
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
            int duplicateBarHeight = (int) (arrayListTimes[i] * yScale);
            graph.setPaint(Color.GRAY);
            graph.fillRect(x, height - margin - duplicateBarHeight, barWidth, duplicateBarHeight);

            // Bar height for non-duplicate times
            int nonDuplicateBarHeight = (int) (linkedListTimes[i] * yScale);
            graph.setPaint(Color.ORANGE);
            graph.fillRect(x + barWidth + 10, height - margin - nonDuplicateBarHeight, barWidth, nonDuplicateBarHeight);

            // Draw category labels
            graph.setPaint(Color.BLACK);
            graph.drawString(categories[i], x, height - margin + 20);

            // Draw values above bars
            graph.drawString(String.valueOf(arrayListTimes[i]), x, height - margin - duplicateBarHeight - 5);
            graph.drawString(String.valueOf(linkedListTimes[i]), x + barWidth + 10, height - margin - nonDuplicateBarHeight - 5);
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
        graph.drawString("ArrayList", legendX + 30, legendY + 22);
        graph.drawString("LinkedList", legendX + 30, legendY + 47);
    }

    // Get the maximum time value to scale the bars
    private int getMaxTime() {
        int max = Integer.MIN_VALUE;
        for (int time : arrayListTimes) {
            if (time > max) max = time;
        }
        for (int time : linkedListTimes) {
            if (time > max) max = time;
        }
        return max;
    }

    // Function to create a new window for each graph
    public static void createWindow(String title, String[] categories, int[] duplicateTimes, int[] nonDuplicateTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only the current window
        frame.setSize(600, 400);
        frame.add(new ComparisonBar(categories, duplicateTimes, nonDuplicateTimes));
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true); // Make the frame visible
    }

    // Main method to create multiple windows for different datasets
    public static void main(String[] args) {

        // Comparison across 4 algorithms
        String[] algorithms = {"Selection Sort", "Merge Sort", "Comb Sort", "Counting Sort"};
        int[] arrayListData = {1381530, 206, 405, 76};   // ArrayList times for Selection, Merge, Comb, Counting sort
        int[] linkedListData = {759447, 183, 1257, 183};   // LinkedList times for Selection, Merge, Comb, Counting sort


        // Create windows for the datasets
        createWindow("Graph for Comparison", algorithms, arrayListData, linkedListData); 
    }
}
