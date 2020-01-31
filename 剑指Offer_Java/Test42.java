package offer;

import java.util.ArrayList;

// 和为S的两个数字
public class Test42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        int left = 0, right = array.length-1;
        while (left < right) {
            if (array[left] + array[right] > sum) {
                right--;
            } else if (array[left] + array[right] < sum) {
                left++;
            } else {
                list.add(array[left]);
                list.add(array[right]);
                return list;
            }
        }
        return list;
    }
}
