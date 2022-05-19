import java.util.Arrays;

/*
Принцип работы

Массив со входными данными представляет собой 2 отсортированных участка
поделив массив по полам мы получим 2 подмассива один из них должен быть отсортирован
и если искомый элемент находится в границах отсортированного массива мы можем найти его бинарным поиском,
а если искомого элемента в границах отсортированного массива нет, то вызываем функцию поиска на не отсортированном участке

Временная сложность O(logN) так как с каждым рекурсивным вызовом функции пространство для поиска уменьшается в 2 раза
а на оставшемся участке бинарный поиск так же отработает за O(logN)

Пространственная сложность O(logN) так как каждый рекурсивный вызов будет добавлять параметры в стек

https://contest.yandex.ru/contest/23815/run-report/66225401/
*/

public class BrokenSearchSolution {


    public static int brokenSearch(int[] arr, int k) {
        return splitArray(arr, k, 0, arr.length - 1);
    }

    public static int splitArray(int[] arr, int k, int left, int right) {
        int midIndex = getMiddle(left, right);

        if (left == right || left == right - 1) {
            if (arr[left]==k){
                return left;
            }
            if (arr[right]==k){
                return right;
            }
            return -1;
        }

        if (arr[midIndex] >= arr[left]) {
            if (k >= arr[left] && k <= arr[midIndex]) {
                return binarySearch(arr, k, left, midIndex);
            }
        }
        if (arr[midIndex] <= arr[right]) {
            if (k >= arr[midIndex] && k <= arr[right]) {
                return binarySearch(arr, k, midIndex, right);
            }
        }

        if (arr[midIndex] < arr[left]) {
            return splitArray(arr, k, left, midIndex);
        }

        if (arr[midIndex] > arr[right]) {
            return splitArray(arr, k, midIndex, right);
        }

        return -1;
    }

    public static int binarySearch(int[] arr, int k, int left, int right) {

        int midIndex = getMiddle(left, right);

        while (right != left){
            if (k < arr[midIndex]) {
                right = midIndex;
            }
            if (k > arr[midIndex]) {
                left = midIndex;
            }
            if (k == arr[midIndex]) {
                return midIndex;
            }
            midIndex = getMiddle(left, right);
            if (left == right || left == right - 1) {
                if (arr[left]==k){
                    return left;
                }
                if (arr[right]==k){
                    return right;
                }
                return -1;
            }
        }

        return -1;
    }

    public static int getMiddle(int left, int right) {
        return Math.floorDiv(left + right, 2);
    }
}
