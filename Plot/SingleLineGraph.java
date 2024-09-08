package Plot;

import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.Arrays;

public class SingleLineGraph extends JPanel {
    private double[] elapsedTimes;  // Elapsed times (ms) for each data set
    private int[] dataSizes;        // Data sizes in millions
    private int margin = 50;        // Reduced margins for the graph
    private int yAxisLabelOffset = 20; // Move the y-axis label closer to the graph

    // Constructor to accept custom dataset
    public SingleLineGraph(int[] dataSizes2, double[] elapsedTimes) {
        this.dataSizes = dataSizes2;
        this.elapsedTimes = elapsedTimes;
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

        // Plot the data points and lines
        graph.setPaint(Color.BLUE);
        plotData(graph, elapsedTimes, dataSizes, xScale, yScale, height);

        // Set font for the axis titles
        graph.setFont(new Font("Arial", Font.BOLD, 14));

        // Draw x-axis title
        graph.drawString("Size (Million)", (width - margin) / 2, height - margin / 6); // Moved closer

        // Draw y-axis title (rotated 90 degrees), move it closer using `yAxisLabelOffset`
        graph.rotate(-Math.PI / 2);
        graph.drawString("Elapsed Time (ms)", -height / 2, margin / 4);  // Reduced the offset to move it closer
        graph.rotate(Math.PI / 2);  // Rotate back

        // Set font for the axis labels
        graph.setFont(new Font("Arial", Font.PLAIN, 12));

        // Label x-axis (Data Sizes)
        for (int i = 0; i < dataSizes.length; i++) {
            int x = margin + (int) (i * xScale);
            String label = String.valueOf(dataSizes[i]);
            graph.drawString(label, x - 10, height - margin + 20);
        }

        // Label y-axis (Elapsed Times) with dynamic step size
        double maxElapsedTime = getMaxElapsedTime();
        double yStep = calculateYStep(maxElapsedTime); // Use a dynamic step size based on data range

        for (double i = 0; i <= maxElapsedTime; i += yStep) { // Adjust step size for elapsed time labels
            int y = height - margin - (int) (i * yScale);
            String label = String.format("%.0f", i); // Format to remove decimals
            graph.drawString(label, margin - 30, y + 5);  // Moved y-axis labels closer by adjusting `-30`
        }
    }

    // Function to plot the data points and lines
    private void plotData(Graphics2D graph, double[] times, int[] dataSizes2, double xScale, double yScale, int height) {
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

    // Calculate dynamic y-axis step size based on max value
    private double calculateYStep(double maxElapsedTime) {
        double[] steps = {10, 50, 100, 500, 1000, 5000, 10000, 50000};
        for (double step : steps) {
            if (maxElapsedTime / step <= 10) {
                return step;
            }
        }
        return 10000; // Fallback step size if the maxElapsedTime is too large
    }

    // Function to create a new JFrame for each graph window
    public static void createWindow(String title, int[] dataSizes2, double[] elapsedTimes) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close only this window on exit
        frame.setSize(800, 600);  // Set frame size
        frame.add(new SingleLineGraph(dataSizes2, elapsedTimes));  // Add the graph to the frame
        frame.setLocationRelativeTo(null);  // Center the frame
        frame.setVisible(true);  // Make frame visible
    }

    // Main method to create separate windows for different datasets
    public static void main(String[] args) {
        // Selection sort
        int[] dataSizes1 = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
        double[] elapsedTimes1 = {161, 752, 1786, 3253, 5300, 7634, 10443, 13940, 17473, 22107}; // Elapsed times

        // Merge sort
        int[] dataSizes2 = {100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000};
        double[] elapsedTimes2 = {24, 50, 111, 154, 186, 233, 285, 349, 378, 415}; 

        // Comb Sort
        double[] elapsedTimes3 = {69, 179, 423, 629, 908, 1153, 1611, 1784, 2226, 2386};

        // Counting Sort
        double[] elapsedTimes4 = {54, 106, 296, 560, 754, 939, 1148, 1415, 1483, 1629};

        // Create multiple windows for different datasets
        createWindow("Sorting 100k Words - Selection Sort", dataSizes1, elapsedTimes1);  // First window
        createWindow("Sample Dataset - Merge Sort", dataSizes2, elapsedTimes2);  // Second window
        createWindow("Sorting 100k Words - Comb Sort", dataSizes2, elapsedTimes3);
        createWindow("Sorting 100k Words - Counting Sort", dataSizes2, elapsedTimes4);
    }
}
