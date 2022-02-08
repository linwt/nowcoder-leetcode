// 多数元素


/*
排序：先排序，不管元素个数是奇数还是偶数，众数元素一定在中间位置
 */
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


/*
哈希表：使用哈希表存放每个元素的出现次数，遍历哈希表获取出现次数最多的元素
 */
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        int res = nums[0];
        int maxCount = 0;
        for (int num : map.keySet()) {
            if (map.get(num) > maxCount) {
                maxCount = map.get(num);
                res = num;
            }
        }
        return res;
    }
}


/*
投票：
res表示临时众数，count表示该临时众数拥有的票数
遍历数组，票数为0时，替换上一届的临时众数，将当前元素设为临时众数
计算票数，如果当前元素与临时众数一样，则投赞成票，否则投反对票
由于实际众数人多力量大，最后赞成票最多
 */
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                res = num;
            }
            count += num == res ? 1 : -1;
        }
        return res;
    }
}


/*
计数：遍历数组元素，统计该元素出现次数，如果大于一半数组长度，则为众数
 */
class Solution {
    public int majorityElement(int[] nums) {
        int maxCount = nums.length / 2;
        int res = nums[0];
        for (int num : nums) {
            if (count(nums, num) > maxCount) {
                res = num;
                break;
            }
        }
        return res;
    }

    private int count(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }
}


/*
分治：数组对半拆分成多部分，两两统计比较谁出现次数更多，最后得到出现次数最多的众数
 */
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }

    private int majorityElementRec(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, high);
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);
        return leftCount > rightCount ? left : right;
    }

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

}