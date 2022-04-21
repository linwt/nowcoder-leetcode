// 74. 和为S的连续正数序列


public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 1; i < sum; i++) {
            int num = i;
            for (int j = i + 1; j < sum; j++) {
                num += j;
                if (num < sum) {
                    continue;
                } else if (num == sum) {
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int k = i; k <= j; k++) {
                        list.add(k);
                    }
                    res.add(list);
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
