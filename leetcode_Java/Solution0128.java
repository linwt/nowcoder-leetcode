// 128. 最长连续序列


/*
集合：
1、集合存放去重元素
2、遍历元素
  1）元素前值存在集合中则跳过，因为当前元素会被前值计算统计出更长的长度，即只从序列的起点开始计算才是最长的
  2）记录当前元素和当前长度，当元素后值存在集合中，则更新当前元素和当前长度
  3）比较比记录最长长度
  4）优化，最长长度大于数组长度一半时，后面的元素就不用判断了
    因为如果剩余元素不属于这个序列那么长度小于数组长度一半
    如果属于这个序列，那么序列起点已经计算了，当前就是最长了

  √：计算长度  x：跳过
  100  4  200  1  3  2
   √   x   √   √  x  x
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int curNum = num;
            int curLen = 1;
            while (set.contains(curNum + 1)) {
                curNum += 1;
                curLen += 1;
            }
            res = Math.max(res, curLen);
            if (res > n / 2) {
                break;
            }
        }
        return res;
    }
}


/*
排序：
1、数组排序
2、遍历统计连续序列长度，记录最长长度
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int res = 1, curLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                curLen += 1;
                res = Math.max(res, curLen);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                curLen = 1;
            }
        }
        return res;
    }
}