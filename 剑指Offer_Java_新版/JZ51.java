// 	51. 数组中的逆序对


public class Solution {
    private int count;

    public int InversePairs(int[] array) {
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (arr[p1] <= arr[p2]) {
                temp[index++] = arr[p1++];
            } else {
                temp[index++] = arr[p2++];
                count = (count + (mid - p1 + 1)) % 1000000007;
            }
        }
        while (p1 <= mid) {
            temp[index++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[index++] = arr[p2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }
}
