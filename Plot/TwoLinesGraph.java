package Plot;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Arrays;

public class TwoLinesGraph extends JPanel {
    // Data arrays for ArrayList and LinkedList
    double[] arrayListTimes = {405, 1555, 3883, 6063, 9115, 11466, 14474, 17677, 20597, 21813, 25318};  // ArrayList times
    double[] linkedListTimes = {1257, 3104, 8024, 15503, 22951, 26361, 34380, 41375, 46893, 49961, 56633}; // LinkedList times
    int[] dataSizes = {1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20}; // Data sizes in millions

    int margin = 100; // Margins for the graph

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

    // Main method to run the graph
    public static void main(String[] args) {
        // Create an instance of JFrame
        JFrame frame = new JFrame();

        // Add the graph panel to the frame
        frame.add(new TwoLinesGraph());

        // Set frame properties
        frame.setSize(800, 600); // Width and height of the frame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        frame.setVisible(true); // Make frame visible
    }
}
