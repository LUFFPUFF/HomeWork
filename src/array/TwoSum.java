package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoSum {
    public static void main(String[] args) {
       testTimeAndResult();
    }

    /**
     * Метод для нахождения индексов элементов в сумме равные target
     * Данный метод не самый эффективный, так как работает за время O(n^2), что может
     * быть не удобным с большим кол-вом элементов
     * @param nums - принимаей массив
     * @param target - число равное сумме индексов
     * @return - если такие числа не найдены то 0
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    /**
     * Метод для нахождения индексов элементов в сумме равные target
     * Данный метод уже поэффективнее, так как работает за время O(n), что значительно
     * увеличивает время работы
     * @param arr - принимаей массив
     * @param target - число равное сумме индексов
     * @return - если такие числа не найдены то 0
     */
    public static int[] twoSum2(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int com = target - arr[i];
            if (map.containsKey(com)) {
                return new int[]{map.get(com), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{0};
    }

    /**
     * Метод для нахождения индексов элементов в сумме равные target
     * Данный метод самый эффективный, так как работает за время O(n) и вместо
     * цикла for имеет более эффективный опреатор while
     * @param arr - принимаей массив
     * @param target - число равное сумме индексов
     * @return - если такие числа не найдены то 0
     */
    public static int[] twoSum3(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < arr.length) {
            int com = target - arr[i];
            if (map.containsKey(com)) {
                return new int[]{map.get(com), i};
            }
            map.put(arr[i], i);
            i++;
        }
        return new int[]{0};
    }

    /**
     * Метод для вывода резлуьтата и проверки времени работы алгоритмов
     */
    public static void testTimeAndResult() {
        int[] arr = new int[1_000_000];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        int target = 9;

        long startTime1 = System.currentTimeMillis();
        twoSum(arr, target);
        long endTime1 = System.currentTimeMillis();
        long executionTime1 = endTime1 - startTime1;
        System.out.println("Method Result twoSum3: " + Arrays.toString(twoSum(arr, target)));

        long startTime2 = System.currentTimeMillis();
        twoSum2(arr, target);
        long endTime2 = System.currentTimeMillis();
        long executionTime2 = startTime2 - endTime2;
        System.out.println("Method Result twoSum2: " + Arrays.toString(twoSum2(arr, target)));

        long startTime3 = System.currentTimeMillis();
        twoSum3(arr, target);
        long endTime3 = System.currentTimeMillis();
        long executionTime3 = startTime3 - endTime3;
        System.out.println("Method Result twoSum3: " + Arrays.toString(twoSum3(arr, target)));

        System.out.println("----------------------------------------------------");

        System.out.println("twoSum Execution Time: " + executionTime1 + " ms");
        System.out.println("twoSum2 Execution Time: " + executionTime2 + " ms");
        System.out.println("twoSum3 Execution Time: " + executionTime3 + " ms");
    }
}
