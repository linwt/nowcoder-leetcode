package offer;

import java.util.ArrayList;

// 数组中只出现一次的数字
public class Test40 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (list.contains(array[i] + "")) {
                list.remove(array[i] + "");
            } else {
                list.add(array[i] + "");
            }
        }
        num1[0] = Integer.parseInt(list.get(0));
        num2[0] = Integer.parseInt(list.get(1));
    }
}
