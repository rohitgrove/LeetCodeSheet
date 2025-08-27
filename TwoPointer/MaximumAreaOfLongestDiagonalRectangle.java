public class MaximumAreaOfLongestDiagonalRectangle {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        int result = 0;

        double maxDiagonal = Double.MIN_VALUE;
        for (int[] dimension : dimensions) {
            int length = dimension[0];
            int width = dimension[1];
            double diagonal = Math.sqrt(length * length + width * width);
            int area = length * width;
            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                result = area;
            } else if (diagonal == maxDiagonal) {
                result = Math.max(result, area);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int dimensions1[][] = { { 9, 3 }, { 8, 6 } };
        System.out.println(areaOfMaxDiagonal(dimensions1));
        int dimensions2[][] = { { 3, 4 }, { 4, 3 } };
        System.out.println(areaOfMaxDiagonal(dimensions2));
    }
}
