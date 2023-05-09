package CodeWarriors.MatrixDeterminant;

public class MatrixDeterminant {
    public static void main(String[] args) {
        System.out.println(determinant(new int[][]{{1}})); // exp 1
        System.out.println(determinant(new int[][]{{1, 3}, {2, 5}})); // exp -1
        System.out.println(determinant(new int[][]{{2, 5, 3}, {1, -2, -1}, {1, 3, 4}})); // exp -20
    }

    public static int determinant(int[][] matrix) {
        int result = 0;
        if (matrix == null) return result;
        if (matrix.length == 1) return matrix[0][0];
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                result += matrix[0][i] * determinant(makeMinor(matrix, i));
            } else result -= matrix[0][i] * determinant(makeMinor(matrix, i));
        }
        return result;
    }

    public static int[][] makeMinor(int[][] matrix, int skipIndex) {
        if (matrix.length < 2) {
            return matrix;
        }
        int[][] result = new int[matrix.length - 1][matrix.length - 1];
        for (int y = 1, i, j; y < matrix.length; y++) {
            i = y - 1;
            j = 0;
            for (int x = 0; x < matrix.length; x++) {
                if (x == skipIndex) continue;
                result[i][j] = matrix[y][x];
                j++;
            }
        }
        return result;
    }
}
