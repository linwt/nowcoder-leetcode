package HOT100;

import java.util.*;

// 三数之和
public class Solution015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] == 0) {
                    set.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
