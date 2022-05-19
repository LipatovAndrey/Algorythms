import java.util.Arrays;

public class Solution1 {

    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] result = new int[arr.length];
        int first = left;
        int second = mid;
        int i = left;

        while (i < result.length) {
            if (first >= mid) {
                while (i < arr.length) {
                    result[i] = arr[second];
                    second++;
                    i++;
                }

            }
            if (second > right) {
                while (i < arr.length) {
                    result[i] = arr[first];
                    first++;
                    i++;
                }
            }
            if (i < result.length && arr[first] <= arr[second]) {
                result[i] = arr[first];
                i++;
                first++;
            }
            if (i < result.length && arr[second] <= arr[first]) {
                result[i] = arr[second];
                i++;
                second++;
            }

        }

        return result;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid+1, right);
        int[] res= merge(arr, left, mid, right);
        for (int i = 0; i <res.length ; i++) {
            arr[i] = res[i];
        }
    }

    public static void main(String[] args) {

        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}