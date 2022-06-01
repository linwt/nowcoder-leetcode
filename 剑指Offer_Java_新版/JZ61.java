// 60. 扑克牌顺子


public class Solution {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length < 5) {
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int minNum = 99, maxNum = -1;
        for (int i = 0; i < 5; i++) {
            Integer num = numbers[i];
            // 去掉0
            if (num != 0) {
                // 牌重复
                if (list.contains(num)) {
                    return false;
                }
                list.add(num);
                // 记录最小和最大的牌
                if (num < minNum) {
                    minNum = num;
                }
                if (num > maxNum) {
                    maxNum = num;
                }
            }
        }
        // 相差小于5就是顺子
        if (maxNum - minNum < 5) {
            return true;
        }
        return false;
    }
}
