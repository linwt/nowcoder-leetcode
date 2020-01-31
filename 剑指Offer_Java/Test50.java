package offer;

import java.util.ArrayList;

// 数组中重复的数字
public class Test50 {
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (list.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
            list.add(numbers[i]);
        }
        return false;
    }
}
