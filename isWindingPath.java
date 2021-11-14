public class Main {
    
    /* isWindingPath takes a two-dimensional array of double as input and returns a boolean. Think of the array as a 
    map or a grid (but do not assume every array is the same length). Think of a tiny person walking on this "map". The
    person starts in a cell (an entry of the array) and at each step can move one cell up, down, left or right. If the
    person starts at the smallest value of the array, and if they always move to the adjacent cell with the smallest 
    value larger than the cell they are in (so as they walk, the value they are on always increases), do they eventually
    reach every cell of the map? */
    public static boolean isWindingPath(double[][] matrix) {
        
        // Count the number of cells in the matrix
        int cellCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                cellCount++;
            }
        }

        // Create three arrays of size cellCount
        double[] allNumbers = new double[cellCount];
        int[] xValues = new int[cellCount];
        int[] yValues = new int[cellCount];

        // Copy the numbers from the matrix to allNumbers and the indices for that value into xValues and yValues
        int currentIndex = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                allNumbers[currentIndex] = matrix[i][j];
                yValues[currentIndex] = i;
                xValues[currentIndex] = j;
                currentIndex++;
            }
        }

        // Sort allNumbers, xValues, and yValues according to allNumbers
        for (int i = 0; i < allNumbers.length; i++) {
            for (int j = i + 1; j < allNumbers.length; j++) {
                if (allNumbers[i] > allNumbers[j]) {
                    double tempNumber = allNumbers[i];
                    allNumbers[i] = allNumbers[j];
                    allNumbers[j] = tempNumber;
                    int tempX = xValues[i];
                    xValues[i] = xValues[j];
                    xValues[j] = tempX;
                    int tempY = yValues[i];
                    yValues[i] = yValues[j];
                    yValues[j] = tempY;
                }
            }
        }

        // Check to make sure that the distance to the next step is exactly 1 away from the previous step
        for (int i = 0; i < allNumbers.length - 1; i++) {
            int xDistance = xValues[i] - xValues[i+1];
            if (xDistance < 0) {
                xDistance = -xDistance;
            }
            int yDistance = yValues[i] - yValues[i+1];
            if (yDistance < 0) {
                yDistance = -yDistance;
            }
            if (xDistance + yDistance != 1) {
                return false;
            }
        }
        
        return true;
    }
}
