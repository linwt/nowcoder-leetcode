package HOT100;

// 盛最多水的容器
public class Solution011 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, res = 0;
        while (l < r) {
            if (height[l] <= height[r]) {
                res = Math.max(res, height[l] * (r - l));
                l++;
            } else {
                res = Math.max(res, height[r] * (r - l));
                r--;
            }
        }
        return res;
    }
}
