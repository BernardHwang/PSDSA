package Plot;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Arrays;

public class TwoLinesGraph extends JPanel {
    // Arrays to hold data for ArrayList and LinkedList
    private double[] arrayListTimes;
    private double[] linkedListTimes;
    private int[] dataSizes;

    int margin = 100; // Margins for the graph

    // Constructor to pass custom datasets
    public TwoLinesGraph(int[] dataSizes, double[] arrayListTimes, double[] linkedListTimes) {
        this.dataSizes = dataSizes;
        this.arrayListTimes = arrayListTimes;
        this.linkedListTimes = linkedListTimes;
    }

    @Override
    protected void paintComponent(Graphics grf) {
        super.paintComponent(grf);
        Graphics2D graph = (Graphics2D) grf;

        // Enable antialiasing for smoother lines
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Get panel width and height
        int width = getWidth();
        int height = getHeight();

        // Draw x and y axis
        graph.draw(new Line2D.Double(margin, margin, margin, height - margin)); // Y-axis
        graph.draw(new Line2D.Double(margin, height - margin, width - margin, height - margin)); // X-axis

        // Calculate x and y scaling factors
        double xScale = (double) (width - 2 * margin) / (dataSizes.length - 1);
        double yScale = (double) (height - 2 * margin) / getMaxElapsedTime();

        // Plot for ArrayList (blue)
        graph.setPaint(Color.BLUE);
        plotData(graph, arrayListTimes, xScale, yScale, height, "ArrayList");

        // Plot for LinkedList (red)
        graph.setPaint(Color.RED);
        plotData(graph, linkedListTimes, xScale, yScale, height, "LinkedList");

        // Set font for the axis titles
        graph.setFont(new Font("Arial", Font.BOLD, 14));

        // Draw x-axis title
        graph.drawString("Size (Million)", (width - margin) / 2, height - margin / 4);

        // Draw y-axis title (rotated 90 degrees)
        graph.rotate(-Math.PI / 2);
        graph.drawString("Elapsed Time (ms)", -height / 2, margin / 3);
        graph.rotate(Math.PI / 2);  // Rotate back

        // Set font for the axis labels
        graph.setFont(new Font("Arial", Font.PLAIN, 12));

        // Label x-axis (Data Sizes)
        for (int i = 0; i < dataSizes.length; i++) {
            int x = margin + (int) (i * xScale);
            String label = String.valueOf(dataSizes[i] * 1000000);  // Converting million to actual number
            graph.drawString(label, x - 10, height - margin + 20);
        }

        // Label y-axis (Elapsed Times)
        for (int i = 0; i <= getMaxElapsedTime(); i += 10000) { // Adjust step size for elapsed time labels
            int y = height - margin - (int) (i * yScale);
            String label = String.valueOf(i);
            graph.drawString(label, margin - 50, y + 5);
        }
    }

    // Function to plot the data points and lines
    private void plotData(Graphics2D graph, double[] times, double xScale, double yScale, int height, String label) {
        for (int i = 0; i < times.length; i++) {
            double x = margin + i * xScale;
            double y = height - margin - yScale * times[i];

            // Draw the point
            graph.fill(new Ellipse2D.Double(x - 2, y - 2, 4, 4));

            // Draw a line connecting each point
            if (i > 0) {
                double xPrev = margin + (i - 1) * xScale;
                double yPrev = height - margin - yScale * times[i - 1];
                graph.draw(new Line2D.Double(xPrev, yPrev, x, y));
            }
        }
    }

    // Find the maximum elapsed time for scaling the y-axis
    private double getMaxElapsedTime() {
        return Math.max(Arrays.stream(arrayListTimes).max().orElse(0), Arrays.stream(linkedListTimes).max().orElse(0));
    }

    // Function to create a new JFrame for each graph window
    public static void createWindow(String title, int[] dataSizes, double[] arrayListTimes, double[] linkedListTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only this window on exit
        frame.setSize(800, 600);  // Set frame size
        frame.add(new TwoLinesGraph(dataSizes, arrayListTimes, linkedListTimes));  // Add the graph to the frame
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);  // Make frame visible
    }

    // Main method to create multiple windows for different datasets
    public static void main(String[] args) {
        // First dataset (Data Sizes and Elapsed Times)
        int[] dataSizes1 = {1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20};  // Data sizes in millions
        double[] arrayListTimes1 = {405, 1555, 3883, 6063, 9115, 11466, 14474, 17677, 20597, 21813, 25318}; // ArrayList times
        double[] linkedListTimes1 = {1257, 3104, 8024, 15503, 22951, 26361, 34380, 41375, 46893, 49961, 56633}; // LinkedList times

        // Second dataset (You can add more datasets here)
        int[] dataSizes2 = {1, 2, 3, 4, 5};  // A smaller dataset
        double[] arrayListTimes2 = {500, 1200, 2400, 3800, 5000}; // Sample ArrayList times for second dataset
        double[] linkedListTimes2 = {1000, 2200, 5000, 7600, 10200}; // Sample LinkedList times for second dataset

        // Create multiple windows for different datasets
        createWindow("Graph for Dataset 1", dataSizes1, arrayListTimes1, linkedListTimes1);  // First window
        createWindow("Graph for Dataset 2", dataSizes2, arrayListTimes2, linkedListTimes2);  // Second window
    }
}
