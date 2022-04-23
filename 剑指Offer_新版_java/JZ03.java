// 3. 数组中重复的数字


/*
原地哈希：把数字交换到正确的位置上
1、由于数字都在0到n-1的范围内，所以数字和索引可以一一对应，不对应时说明重复了
2、遍历数组，如果索引与数字相同，说明该数字已经排序好了，继续下一个数字判断
3、如果索引与数字不同，则将数字交换到正确的位置上
4、当第二次碰到重复数字时，由于在正确的位置上已经有该值了，则返回该重复数字

元素：3 1 2 3 4
索引：0 1 2 3 4
 */
public class Solution {
    public int duplicate (int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers[i]) {
                continue;
            }
            if (numbers[i] == numbers[numbers[i]]) {
                return numbers[i];
            }
            swap(numbers, i, numbers[i]);
        }
        return -1;
    }

    private void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }
}


/*
集合：用HashSet存放元素，存在则返回，不存在则添加，遍历完没找到则返回-1
 */
public class Solution {
    public int duplicate (int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int num : numbers) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }
        return -1;
    }
}


/*
排序：排序后判断当前数字与前一数字是否相同，相同则返回
 */
public class Solution {
    public int duplicate (int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                return numbers[i];
            }
        }
        return -1;
    }
}