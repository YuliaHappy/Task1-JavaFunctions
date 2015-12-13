public class MatrixUtils {
    /**
     * Метод, который перемножает 2 целочисленные матрицы
     * @param firstMultiplier - первая матрица
     * @param secondMultiplier - вторая матрица
     * @return - результат перемножения
     */
    public static int[][] multiplicationMatrix(int[][] firstMultiplier, int[][] secondMultiplier) {
        if(firstMultiplier.length == 0 || secondMultiplier.length == 0 || firstMultiplier[0].length != secondMultiplier.length ||
                firstMultiplier == null || secondMultiplier == null) {
            return new int[][]{};
        }
        int[][] result = new int[firstMultiplier.length][secondMultiplier[0].length];
        for(int row = 0; row < firstMultiplier.length; row++) {
            for(int column = 0; column < secondMultiplier[0].length; column++) {
                for(int otherColumn = 0; otherColumn < firstMultiplier[0].length; otherColumn++) {
                    result[row][column] += firstMultiplier[row][otherColumn]*secondMultiplier[otherColumn][column];
                }
            }
        }
        return result;
    }

    public static boolean isEqually(int[][] value1, int[][] value2) {
        if(value1.length == 0 && value2.length == 0) {
            return true;
        }
        if (value1.length == value2.length && value1[0].length == value2[0].length) {
            for (int i = 0; i < value1.length; i++) {
                for (int j = 0; j < value1[0].length; j++) {
                    if (value1[i][j] != value2[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
