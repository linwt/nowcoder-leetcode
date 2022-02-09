// 找到所有数组中消失的数字


// 利用好元素和索引的对应关系
/*
数组统计个数：
数组存放每个数出现的次数，再遍历数组获取出现次数为0的数，直接用索引表示对应的数更直观简便
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] count = new int[n + 1];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}


/*
集合过滤出现数字：
1、先把数都存入Set集合中
2、再遍历[1,n]的数字，如果能加入集合则返回true，否则返回false
3、加入集合说明该数字不存在于数组中，将该数字添加到结果列表
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (set.add(i)) {
                list.add(i);
            }
        }
        return list;
    }
}


/*
原地交换，查找不对应的数字：
1、遍历数组每个元素，将该元素交换到对应的正确的索引位置上，遇到待交换的两个元素一样时则跳过继续
2、遍历数组找出元素跟索引不对应的位置，将丢失的数字添加到结果列表中
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int index = 0;
        while (index < n) {
            if (nums[index] == index + 1) {
                index++;
            } else {
                int targetIndex = nums[index] - 1;
                if (nums[index] == nums[targetIndex]) {
                    index++;
                    continue;
                }
                int temp = nums[index];
                nums[index] = nums[targetIndex];
                nums[targetIndex] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }
}