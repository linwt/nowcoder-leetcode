// 287. 寻找重复数


/*
哈希表：记录遍历过的数，如果当前数已存在于哈希表中，则该数是重复数
 */
class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.getOrDefault(num, false)) {
                return num;
            }
            map.put(num, true);
        }
        return -1;
    }
}


/*
快慢指针，思路同“142.环形链表II”
1、如果数组中有重复的数，以数组 [1,3,4,2,2] 为例,我们将数组索引 n 和数 nums[n] 建立一个映射关系 f(n)，其映射关系 n->f(n) 为：
    元素： 1  3  4  2  2
    索引： 0  1  2  3  4
    0->1  1->3  2->4  3->2  4->2
2、我们从索引为 0 出发，根据 f(n) 计算出一个值，以这个值为新的索引，再用这个函数计算，以此类推产生一个类似链表一样的索引序列
    0  →  1  →  3  →  2  →  4
                      ↑_____↓
3、将问题转化成环形链表
  1）数组中有一个重复的整数 <==> 链表中存在环
  2）找到数组中的重复整数 <==> 找到链表的环入口
4、快慢指针走法
  1）慢指针走一步 slow = slow.next <==>  slow = nums[slow]
  2）快指针走两步 fast = fast.next.next <==>  fast = nums[nums[fast]]
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        int pre = 0;
        while (slow != pre) {
            slow = nums[slow];
            pre = nums[pre];
        }
        return slow;
    }
}


/*
二分查找：
1、数字在[1,n]范围内，初始化left为1，right为n。所有计算都是用数字，没用到索引
2、找中间数mid，计算数组中小于等于mid的元素数量，如果数量大于mid说明重复元素在区间[left,mid]，否则重复元素在区间[mid+1,right]
3、循环二分查找，直到找到重复元素

数组：[1,3,2,5,2,4]
  1   2   3   4   5
left     mid    right
count=4 > mid=3
======================
  1   2   3   4   5
left mid right
count=3 > mid=2
======================
    1      2   3   4   5
left/mid right
count=1 !> mid=1
======================
  1      2      3   4   5
     left/right
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}


/*
位运算：将 原数组 与 [1,n]数字 转化成二进制后，统计对应每一位1的个数，原数组比范围数组 位上多出来的1 是重复元素位上的1，找到重复元素所有位上的1后 转化得到重复元素值
nums = [1,3,4,2,2]

1 3 4 2 2 写成二进制
 1 [0 0 1]
 3 [0 1 1]
 4 [1 0 0]
 2 [0 1 0]
 2 [0 1 0]
 x  1 3 2

把 1 到 n，也就是 1 2 3 4 也写成二进制
 1 [0 0 1]
 2 [0 1 0]
 3 [0 1 1]
 4 [1 0 0]
 y  1 2 2

res 0 1 0
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int res = 0, n = nums.length;
        int maxBit = 31;
        while (((n - 1) >> maxBit) == 0) {
            maxBit--;
        }
        for (int i = 0; i <= maxBit; i++) {
            int x = 0, y = 0;
            int mask = (1 << i);
            for (int j = 0; j < n; j++) {
                if ((nums[j] & mask) > 0) {
                    x++;
                }
                if ((j & mask) > 0) {
                    y++;
                }
            }
            if (x > y) {
                res |= mask;
            }
        }
        return res;
    }
}