// 33. 二叉搜索树的后序遍历序列


/*
递归：
1、初始数组为空时，需要返回false
2、递归校验中，数组为空时，需要返回true，所以要拆分成两个方法
 */
public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return verify(sequence);
    }

    public boolean verify(int[] sequence) {
        int len = sequence.length;
        if (len < 2) {
            return true;
        }
        int left = 0;
        int root = sequence[len - 1];
        while (sequence[left] < root) {
            left++;
        }
        for (int right = left; right < len; right++) {
            if (sequence[right] < root) {
                return false;
            }
        }
        return verify(Arrays.copyOfRange(sequence, 0, left)) && verify(Arrays.copyOfRange(sequence, left, len - 1));
    }
}
