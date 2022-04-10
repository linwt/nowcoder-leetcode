// 41. 缺失的第一个正数


/*
置换：
1、求缺失的第一个正数，所以要找的数一定在[1,n+1]
2、遍历数组，在i位置上，将i位置的元素x交换到x-1的位置上，即元素值与索引对应。循环交换i位置的元素，直到不满足条件
3、遍历数组，如果i位置上的元素值不是i+1，说明缺失的第一个正数是i+1
4、数组元素和索引都对应了，则缺失的第一个正数是n+1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}


/*
排序：
1、数组升序排序
2、遍历数组，索引走到对应值为正数位置
3、索引走完即没有正数，或者第一个正数不是1，那么直接返回缺失的第一个正数为1
4、遍历上一步索引开始的剩余数组，如果下一个数不是 相等或连续，说明缺失正数，返回缺失的正数
5、如果遍历完没有缺失，则缺失的第一个正数是最后一个数加1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int index = 0;
        while (index < n && nums[index] < 1) {
            index++;
        }
        if (index == n || nums[index] != 1) {
            return 1;
        }
        for (int i = index; i < n - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums[n - 1] + 1;
    }
}


/*
集合：
1、遍历数组将元素存入集合
2、求缺失的第一个正数，所以要找的数一定在[1,n+1]，如果该数字没有在集合中，说明该数字是缺失的第一个正数，否则缺失的第一个正数是最后一个数加1
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return n + 1;
    }
}