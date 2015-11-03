import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.min;

public class DoubleUtils {
    private final static double EPSILON = 2.220446049250313e-016;

    /**
     * Метод, возвращающий пересечение двух массивов double
     * @param firstArray - первый массив double
     * @param secondArray - второй массив double
     * @return - пересечение массивов
     */
    public static double[] intersectionArray(double[] firstArray, double[] secondArray) {
        if (firstArray.length != 0 && secondArray.length != 0) {
            double[] arrayIntersection = new double[min(firstArray.length, secondArray.length)];
            int count = 0;
            boolean isRep;
            for (double item1 : firstArray) {
                for (double item2 : secondArray) {
                    if (isEqually(item1, item2)) {
                        isRep = false;
                        for (double itemIntersection : arrayIntersection) {
                            if (isEqually(item1, itemIntersection)) {
                                isRep = true;
                                break;
                            }
                        }
                        if (!isRep) {
                            arrayIntersection[count++] = item1;
                        }
                        break;
                    }
                }
            }
            double[] result = new double[count];
            System.arraycopy(arrayIntersection, 0, result, 0, count);
            return result;
        }
        return new double[]{};
    }

    public static boolean isEqually(double value1, double value2) {
        if(Math.abs(value1 - value2) <= EPSILON) return true;
        return false;
    }

    /**
     * Метод, который проверяет эквивалентны ли 2 массива без учета порядка
     * @param value1
     * @param value2
     * @return
     */
    public static boolean isEquallyArray(double[] value1, double[] value2) {    //TODO
        if (value1.length != value2.length) {
            return false;
        }
        double[] firstArray = value1;
        Arrays.sort(firstArray);
        double[] secondArray = value2;
        Arrays.sort(secondArray);
        for (int i = 0; i < firstArray.length; i++) {
            if (!isEqually(firstArray[i], secondArray[i]))
                return false;
        }
        return true;
    }
}
