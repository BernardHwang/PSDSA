package Plot;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Arrays;

public class SingleLineGraph extends JPanel {
    // Data for Words ArrayList
    double[] elapsedTimes = {69, 179, 423, 629, 908, 1153, 1611, 1784, 2226, 2386}; // Elapsed times (ms)
    double[] dataSizes = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1}; // Data sizes in millions

    int margin = 60; // Margins for the graph

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

        // Plot the data points and lines
        graph.setPaint(Color.BLUE);
        plotData(graph, elapsedTimes, dataSizes, xScale, yScale, height);

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
            String label = String.valueOf(dataSizes[i]);
            graph.drawString(label, x - 10, height - margin + 20);
        }

        // Label y-axis (Elapsed Times)
        for (int i = 0; i <= getMaxElapsedTime(); i += 500) { // Adjust step size for elapsed time labels
            int y = height - margin - (int) (i * yScale);
            String label = String.valueOf(i);
            graph.drawString(label, margin - 50, y + 5);
        }
    }

    // Function to plot the data points and lines
    private void plotData(Graphics2D graph, double[] times, double[] dataSizes, double xScale, double yScale, int height) {
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
        return Arrays.stream(elapsedTimes).max().orElse(0);
    }

    // Main method to run the graph
    public static void main(String[] args) {
        // Create an instance of JFrame
        JFrame frame = new JFrame();

        // Add the graph panel to the frame
        frame.add(new SingleLineGraph());

        // Set frame properties
        frame.setSize(800, 600); // Width and height of the frame
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
        frame.setVisible(true); // Make frame visible
    }
}