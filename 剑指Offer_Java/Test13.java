package offer;

// 调整数组顺序使奇数位于偶数前面
public class Test13 {
    public void reOrderArray(int[] array) {
        int len = array.length, l = 0, r = array.length - 1;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            // 逆序获取偶数，从后往前放入新数组
            if (array[len - i - 1] % 2 == 0) {
                res[r] = array[len - i - 1];
                r--;
            }
            // 顺序获取奇数，从前往后放入新数组
            if (array[i] % 2 == 1) {
                res[l] = array[i];
                l++;
            }
        }
        for (int i = 0; i < len; i++) {
            array[i] = res[i];
        }
    }
}
