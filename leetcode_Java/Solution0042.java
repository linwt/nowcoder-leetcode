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
双指针：
1、变量含义
    leftMax：左边的最大值，它是从左往右遍历找到的
    rightMax：右边的最大值，它是从右往左遍历找到的
    left：从左往右处理的当前下标
    right：从右往左处理的当前下标
2、双指针left、right的作用是 从两端向中间遍历整个数组，记录左右最大值，并计算每个位置的雨水
3、在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个，与当前位置的高度差
4、在某个位置i处，它左边最大值一定是leftMax，右边最大值大于等于rightMax
   所以如果 leftMax <= rightMax，那么 左边最大值 <= 右边最大值，那么位置i的 左右最大值 较小者就是 leftMax
   所以当 leftMax <= rightMax 时，就去处理left下标，反之就去处理right下标
 */
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int sum = 0;
        while (left <= right) {
            if (leftMax <= rightMax) {
                sum += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                sum += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return sum;
    }
}


/*
单调递减栈：
1、单调递减栈，height元素作为右柱依次入栈，出现入栈元素（右柱）比栈顶大时，说明在右柱左侧形成了低洼处
2、栈不为空，且当前元素（右柱）比栈顶（右柱的左侧）大，说明形成低洼处了
3、低洼处出栈后，栈如果为空，说明没有左柱，不能接雨水
4、否则，获取低洼处、左柱、右柱的高度，计算雨水。
  积攒的水 = 距离 * 高度差
         = (右柱位置-左柱位置-1) * (min(右柱高度, 左柱高度)-低洼处高度)
5、循环结算完雨水后，右柱入栈，保证了栈内元素单调递减
 */
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for (int right = 0; right < height.length; right++) {
            while (!stack.empty() && height[right] > height[stack.peek()]) {
                int bottom = stack.pop();
                if (stack.empty()) {
                    break;
                }
                int left = stack.peek();
                int bottomHeight = height[bottom];
                int leftHeight = height[left];
                int rightHeight = height[right];
                sum += (right - left - 1) * (Math.min(leftHeight, rightHeight) - bottomHeight);
            }
            stack.push(right);
        }
        return sum;
    }
}