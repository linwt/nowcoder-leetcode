// 盛最多水的容器


/*
双指针：初始化左右指针，面积 = 柱子距离 * 矮柱子高度，然后矮柱子指针向中间移动一步，争取更高的高度，继续计算面积，记录最大面积
 */
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}