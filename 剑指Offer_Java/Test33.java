package offer;

// 丑数
public class Test33 {
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) {
            return 0;
        }
        int[] array = new int[index];
        array[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0, count = 0;
        while (count < index - 1) {
            int num = Math.min(Math.min(array[t2] * 2, array[t3] * 3), array[t5] * 5);
            array[++count] = num;
            if (num % 2 == 0) {
                t2++;
            }
            if (num % 3 == 0) {
                t3++;
            }
            if (num % 5 == 0) {
                t5++;
            }
        }
        return array[index - 1];
    }
}
