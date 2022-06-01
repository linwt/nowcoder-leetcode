// 66. 构建乘积数组


public class Solution {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        Arrays.fill(B, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
