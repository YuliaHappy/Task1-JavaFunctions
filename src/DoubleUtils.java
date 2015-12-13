import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.min;

public class DoubleUtils {
    public final static double EPSILON = 2.220446049250313e-016;

    /**
     * Метод, возвращающий пересечение двух массивов double
     * @param firstArray - первый массив double
     * @param secondArray - второй массив double
     * @return - пересечение массивов
     */
    public static double[] intersectionArray(double[] firstArray, double[] secondArray) {
        if (firstArray == null || firstArray.length == 0 || secondArray == null || secondArray.length == 0) {
            return new double[]{};
        }
        double[] arrayIntersection = new double[min(firstArray.length, secondArray.length)];
        int count = 0;
        for (double item1 : firstArray) {
            for (double item2 : secondArray) {
                if (isEqually(item1, item2)) {
                    count = addUniqueItemInArray(arrayIntersection, item1, count);
                    break;
                }
            }
        }
        double[] result = new double[count];
        System.arraycopy(arrayIntersection, 0, result, 0, count);
        return result;
    }

    public static boolean isEqually(double value1, double value2) {
        if(Math.abs(value1 - value2) <= EPSILON) return true;
        return false;
    }

    /**
     * Метод, который проверяет эквивалентны ли 2 массива без учета порядка
     * @param firstArray
     * @param secondArray
     * @return
     */
    public static boolean equal(double[] firstArray, double[] secondArray) {
        if (firstArray.length != secondArray.length) {
            return false;
        }
        double[] array1 = firstArray;
        Arrays.sort(array1);
        double[] array2 = secondArray;
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if (!isEqually(array1[i], array2[i]))
                return false;
        }
        return true;
    }

    private static int addUniqueItemInArray(double[] array, double item, int count) {
        boolean isRep = false;
        for (double itemArray : array) {
            if (isEqually(item, itemArray)) {
                isRep = true;
                break;
            }
        }
        if (!isRep) {
            array[count++] = item;
        }
        return count;
    }
}
