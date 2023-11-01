import java.util.Arrays;
import java.util.Comparator;

public class SortByBits {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] arr2 = {1024,512,256,128,64,32,16,8,4,2,1};
        System.out.println(Arrays.toString(sortByBits(arr2)));
    }

    /**
     * Метод для сортировки массива по возрастанию их кол-ва единиц
     * в двочином представлении
     * @param arr -  принимаемый массив
     * @return - arr
     */
    public static int[] sortByBits(int[] arr) {
        //Создаем компаратор для сравнения их в двочном представлении
        Comparator<Integer> bitCountComparator = (a, b) -> {
            //получем их двочиное представление
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            // сравниваем их, если двочиное пресдтавление равно, то просто сравниаем их
            if (countA == countB) {
                return a - b;
                // иначе сравниваем их по двоичном представлению
            } else {
                return countA - countB;
            }
        };

        // копируем наш массив в Integer представление
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < integerArr.length; i++) {
            integerArr[i] = arr[i];
        }

        // сортируем два наших массива
        Arrays.sort(integerArr, bitCountComparator);

        // обратно копируем их в int представление массива
        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerArr[i];
        }
        return arr; // возвраащем наш отсртированный массив
    }
}
