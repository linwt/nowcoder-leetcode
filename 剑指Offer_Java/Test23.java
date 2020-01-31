package offer;

import java.util.Arrays;

// 二叉搜索树的后序遍历序列
public class Test23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        int len = sequence.length;
        if (len == 0) {
            return false;
        }
        if (len == 1) {
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
        return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, left)) || VerifySquenceOfBST(Arrays.copyOfRange(sequence, left, len - 1));
    }
}
