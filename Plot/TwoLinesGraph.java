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
            String label = String.valueOf(dataSizes[i]);  // Converting million to actual number
            graph.drawString(label, x - 10, height - margin + 20);
        }

        // Label y-axis (Elapsed Times) with dynamic step size
        double maxElapsedTime = getMaxElapsedTime();
        int yStep = (int) (maxElapsedTime / 10); // Dynamic step size (adjust as needed)
        
        for (int i = 0; i <= maxElapsedTime; i += yStep) { // Adjust step size for elapsed time labels
            int y = height - margin - (int) (i * yScale);
            String label = String.valueOf(i);
            graph.drawString(label, margin - 50, y + 5);
        }

        drawLegend(graph, width, height);
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

    // Draw the legend with lines instead of boxes
    private void drawLegend(Graphics2D graph, int width, int height) {
        int legendX = width - 150;  // Position for legend
        int legendY = 50;

        // Draw line for "ArrayList" (blue)
        graph.setPaint(Color.BLUE);
        graph.drawLine(legendX + 10, legendY + 10, legendX + 40, legendY + 10);  // Draw blue line
        graph.drawString("ArrayList", legendX + 50, legendY + 12);  // Label for ArrayList

        // Draw line for "LinkedList" (red)
        graph.setPaint(Color.RED);
        graph.drawLine(legendX + 10, legendY + 30, legendX + 40, legendY + 30);  // Draw red line
        graph.drawString("LinkedList", legendX + 50, legendY + 32);  // Label for LinkedList
    }


    // Find the maximum elapsed time for scaling the y-axis
    private double getMaxElapsedTime() {
        return Math.max(Arrays.stream(arrayListTimes).max().orElse(0), Arrays.stream(linkedListTimes).max().orElse(0));
    }

    // Function to create a new JFrame for each graph window
    public static void createWindow(String title, int[] dataSizes1, double[] arrayListTimes, double[] linkedListTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only this window on exit
        frame.setSize(800, 600);  // Set frame size
        frame.add(new TwoLinesGraph(dataSizes1, arrayListTimes, linkedListTimes));  // Add the graph to the frame
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);  // Make frame visible
    }

    // Main method to create multiple windows for different datasets
    public static void main(String[] args) {
        // Selection Sort
        int[] dataSizes1 = {100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000};
        double[] arrayListTimes1 = {6603, 26500, 59054, 126284, 180360, 262625, 462926, 575877, 987318, 1381530}; // ArrayList times
        double[] linkedListTimes1 = {6482, 26272, 60933, 105289, 168740, 248888, 346984, 460327, 606931, 759447}; // LinkedList times

        // Merge Sort
        int[] dataSizes2 = {1000000, 2000000, 4000000, 6000000, 8000000, 10000000, 12000000, 14000000, 16000000, 18000000, 20000000};  
        double[] arrayListTimes2 = {206, 468, 1158, 1758, 2120, 2662, 3112, 3641, 4132, 4357, 4649}; // ArrayList times
        double[] linkedListTimes2 = {183, 494, 1488, 2553, 3667, 5504, 6096, 8539, 11208, 13215, 14281}; // LinkedList times

        // Comb Sort
        double[] arrayListTimes3 = {405, 1555, 3883, 6063, 9115, 11466, 14474, 17677, 20597, 21813, 25318}; // ArrayList times
        double[] linkedListTimes3 = {1257, 3104, 8024, 15503, 22951, 26361, 34380, 41375, 46893, 49961, 56633}; // LinkedList times

        // Counting Sort
        double[] arrayListTimes4 = {76, 128, 293, 437, 568, 603, 803, 958, 995, 1154, 1205}; // ArrayList times
        double[] linkedListTimes4 = {183, 354, 727, 1036, 1413, 1277, 1972, 2159, 2191, 2212, 3326}; // LinkedList times

        // Counting Sort Range of Values
        int[] dataSizes = {100, 10000, 1000000, 9999999};  // Data sizes
        double[] arrayListTimes5 = {136, 310, 561, 572};    // ArrayList times
        double[] linkedListTimes5 = {273, 421, 1034, 1475}; // LinkedList times


        // Create multiple windows for different datasets
        createWindow("Graph for Selection Sort", dataSizes1, arrayListTimes1, linkedListTimes1);  
        createWindow("Graph for Merge Sort", dataSizes2, arrayListTimes2, linkedListTimes2);  
        createWindow("Graph for Comb Sort", dataSizes2, arrayListTimes3, linkedListTimes3);  
        createWindow("Graph for Counting Sort", dataSizes2, arrayListTimes4, linkedListTimes4);
        createWindow("Graph for Counting Sort", dataSizes, arrayListTimes5, linkedListTimes5);
    }
}
