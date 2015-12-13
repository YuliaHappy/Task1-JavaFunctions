public class StringUtils {

    /**
     * Функция, которая определяет количество вхождений символа в строку
     * @param symbol
     * @param originLine
     * @return
     */
    public static int countEntrySymbol(char symbol, String originLine) {
        int numberEntry = 0;
        for (char character: originLine.toCharArray()) {
            if (symbol == character) {
                numberEntry++;
            }
        }
        return numberEntry;
    }

    /**
     * Метод определяет есть ли в массиве строк одинаковые элементы.
     * @param arrayLine - массив строк
     * @return - true(если есть повторяющиеся элементы) false(иначе)
     */
    public static boolean isEqualElements(String[] arrayLine) {
        if(arrayLine == null) {
            return false;
        }
        for (int i = 0; i < arrayLine.length; i++) {
            for (int j = i + 1; j < arrayLine.length; j++) {
                if (arrayLine[i].equals(arrayLine[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
