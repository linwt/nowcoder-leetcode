// 560. 和为 K 的子数组


/*
暴力破解：两层for循环遍历判断所有子数组
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int end = 0; end < n; end++) {
            int sum = 0;
            for (int start = end; start >= 0; start--) {
                sum += nums[start];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}


/*
前缀和 + 暴力破解
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length, count = 0;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        for (int end = 1; end <= n; end++) {
            for (int start = 0; start < end; start++) {
                if (preSum[end] - preSum[start] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}


/*
前缀和 + 哈希表：
1、使用HashMap存放 <前缀和, 出现次数>
2、由于前缀和通过HashMap获取，不用在数组中获取，因此用一个变量记录当前前缀和即可
3、由于 pre[end] - pre[start - 1] = k 则 pre[end] - k = pre[start - 1]
  遍历数组，边累加计算当前前缀和，并判断另一个预期的前缀和是否出现在HashMap中，以及出现次数，可以构成和为 k 的连续子数组，累加个数
4、累加记录当前前缀和及次数到HashMap中
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curPreSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            curPreSum += nums[i];
            if (map.containsKey(curPreSum - k)) {
                count += map.get(curPreSum - k);
            }
            map.put(curPreSum, map.getOrDefault(curPreSum, 0) + 1);
        }
        return count;
    }
}