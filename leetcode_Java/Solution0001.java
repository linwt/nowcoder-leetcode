// 两数之和


/*
思路：
1、中间数据使用HashMap存放，记录值和索引。结果数据使用整型数组存放
2、输入的数组使用for循环遍历，通过目标值相减的方式获取输入数组中和HashMap中满足条件的两个整数，获取其索引存入结果数组
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}
