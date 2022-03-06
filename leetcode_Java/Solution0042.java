// 接雨水


/*
逐行累加雨水：
1、start标志表示是否碰到柱子，碰到则开始计算，避免左侧没有柱子时错误计算
2、tempSum表示两根柱子中间的雨水，遍历时碰到雨水就收集，碰柱子就将柱子间的雨水加入总和，清空当前柱子间的雨水，准备计算下一处柱子间的雨水
3、要碰到柱子才将雨水加入总和，避免左边有柱子，右边没有柱子，这种情况没有雨水
 */
class Solution {
    public int trap(int[] height) {
        int max = Arrays.stream(height).max().getAsInt();
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            boolean start = false;
            int tempSum = 0;
            for (int j = 0; j < height.length; j++) {
                if (start && height[j] < i) {
                    tempSum++;
                }
                if (height[j] >= i) {
                    sum += tempSum;
                    tempSum = 0;
                    start = true;
                }
            }
        }
        return sum;
    }
}


/*
逐列累加雨水：
1、遍历数组，首尾不用，因为首尾那一列左右柱子不足，不能接雨水
2、遍历到某一位置时，求该位置 左边最高柱子的高度 和 右边最高柱子的高度，两个最高取较低者，较低者高于当前位置则可以接高度差的雨水，否则不能接雨水
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftMax = getMax(height, 0, i - 1);
            int rightMax = getMax(height, i + 1, n - 1);
            int minVal = Math.min(leftMax, rightMax);
            sum += (minVal > height[i]) ? minVal - height[i] : 0;
        }
        return sum;
    }

    private int getMax(int[] height, int start, int end) {
        int maxVal = 0;
        for (int i = start; i <= end; i++) {
            maxVal = Math.max(height[i], maxVal);
        }
        return maxVal;
    }
}


/*
逐列累加雨水，动态规划，时间复杂度优化，空间换时间：
1、为避免重复遍历计算某位置的左右最高柱子，使用dp数组存放最高柱子
2、dpLeft[i]表示i位置左边最高柱子的高度，dpRight[i]表示i位置右边最高柱子的高度
3、状态转移方程：
   dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
   dpRight[i] = Math.max(dpRight[i + 1], height[i + 1]);
4、遍历顺序：求 左边最高柱子的高度 则 从左往右 遍历，求 右边最高柱子的高度 则 从右往左 遍历
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        int[] dpLeft = new int[n];
        int[] dpRight = new int[n];
        for (int i = 1; i < n - 1; i++) {
            dpLeft[i] = Math.max(dpLeft[i - 1], height[i - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dpRight[i] = Math.max(dpRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            int minVal = Math.min(dpLeft[i], dpRight[i]);
            sum += (minVal > height[i]) ? minVal - height[i] : 0;
        }
        return sum;
    }
}


/*
双指针
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        int leftMax = 0, rightMax = 0;
        int left = 1, right = n - 2;
        for (int i = 1; i < n - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                leftMax = Math.max(leftMax, height[left - 1]);
                sum += (leftMax > height[left]) ? leftMax - height[left] : 0;
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right + 1]);
                sum += (rightMax > height[right]) ? rightMax - height[right] : 0;
                right--;
            }
        }
        return sum;
    }
}


/*
栈
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < height.length) {
            while (!stack.empty() && height[index] > height[stack.peek()]) {
                int outVal = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = index - stack.peek() - 1;
                int minVal = Math.min(height[stack.peek()], height[index]);
                sum += distance * (minVal - outVal);
            }
            stack.push(index);
            index++;
        }
        return sum;
    }
}