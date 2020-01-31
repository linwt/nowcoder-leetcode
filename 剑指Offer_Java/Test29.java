package offer;

import java.util.ArrayList;
import java.util.Arrays;

// 最小的K个数
public class Test29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length) {
            return list;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}
