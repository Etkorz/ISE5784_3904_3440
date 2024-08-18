package renderer;

/**
 * Represents a pixel in an image with its row and column indices.
 * Manages pixel processing and printing progress updates.
 */
public record Pixel(int row, int col) {
    // Static variables to manage pixel processing and printing
    private static int maxRows = 0; // Maximum number of rows in the pixel grid
    private static int maxCols = 0; // Maximum number of columns in the pixel grid
    private static long totalPixels = 0L; // Total number of pixels in the pixel grid
    private static volatile int cRow = 0; // Current row being processed (thread-safe)
    private static volatile int cCol = -1; // Current column being processed (thread-safe)
    private static volatile long pixels = 0L; // Number of pixels processed so far (thread-safe)
    private static volatile int lastPrinted = 0; // Last progress percentage printed (thread-safe)
    private static boolean print = false; // Flag to indicate whether progress should be printed
    private static long printInterval = 100L; // Interval between progress updates (in tenths of a percent)
    private static final String PRINT_FORMAT = "%5.1f%%\r"; // Format string for printing progress updates
    private static Object mutexNext = new Object(); // Mutex for synchronizing pixel retrieval
    private static Object mutexPixels = new Object(); // Mutex for synchronizing pixel count updates

    /**
     * Initializes the Pixel processing settings.
     *
     * @param maxRows The total number of rows in the image.
     * @param maxCols The total number of columns in the image.
     * @param interval The interval (in percentage) for printing progress updates.
     */
    static void initialize(int maxRows, int maxCols, double interval) {
        Pixel.maxRows = maxRows; // Set the maximum rows in the grid
        Pixel.maxCols = maxCols; // Set the maximum columns in the grid
        Pixel.totalPixels = (long) maxRows * maxCols; // Calculate total number of pixels
        printInterval = (int) (interval * 10); // Convert interval percentage to tenths of a percent

        // Determine if progress printing is needed and print initial progress
        if (print = printInterval != 0) System.out.printf(PRINT_FORMAT, 0d);
    }

    /**
     * Retrieves the next pixel to process in a raster scan order (left to right, top to bottom).
     * It handles synchronization to ensure thread safety when multiple threads access shared state.
     * @return the next Pixel object, or null if all pixels have been processed
     */
    static Pixel nextPixel() {
        synchronized (mutexNext) {
            // Check if we've processed all rows
            if (cRow == maxRows)
                return null;
            // Move to the next column
            ++cCol;
            // If we're still within the current row, return the new pixel
            if (cCol < maxCols)
                return new Pixel(cRow, cCol);
            // If we've reached the end of the row, move to the next row
            cCol = 0;
            ++cRow;
            // If we're still within the grid, return the new pixel
            if (cRow < maxRows)
                return new Pixel(cRow, cCol);
        }
        // If we've processed all pixels, return null
        return null;
    }

    /**
     * updates the count of processed pixels and optionally prints
     * the progress percentage based on the specified interval.
     */
    static void pixelDone() {
        boolean flag = false; // Flag to determine if progress should be printed
        int percentage = 0; // Variable to store the progress percentage

        synchronized (mutexPixels) { // Synchronize access to the pixel count
            ++pixels; // Increment the count of processed pixels

            if (print) { // Check if progress printing is enabled
                percentage = (int) (1000L * pixels / totalPixels); // Calculate progress percentage (in tenths of a percent)
                if (percentage - lastPrinted >= printInterval) { // Check if enough pixels have been processed to update progress
                    lastPrinted = percentage; // Update the last printed percentage
                    flag = true; // Set flag to print progress
                }
            }
        }

        if (flag) System.out.printf(PRINT_FORMAT, percentage / 10d); // Print progress if needed
    }
}
