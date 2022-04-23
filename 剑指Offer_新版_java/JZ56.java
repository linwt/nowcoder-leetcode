// 56. 数组中只出现一次的两个数字


/*
集合：用HashSet存放元素，存在则移除，不存在则添加，最终只剩下出现一次的数字，遍历集合元素加到数组，最后数组排序
 */
public class Solution {
    public int[] FindNumsAppearOnce (int[] array) {
        int[] res = new int[2];
        Set<Integer> set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        int i = 0;
        for (Integer num : set) {
            res[i++] = num;
        }
        Arrays.sort(res);
        return res;
    }
}


/*
异或运算：
1、异或公式
  1）一个数和 0 做 XOR 运算等于本身：a⊕0 = a
  2）一个数和其本身做 XOR 运算等于 0：a⊕a = 0
  3）XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
2、先将整个数组元素进行异或运算，结果是 只出现一次的两个数字的异或运算结果
3、对两个数字的异或结果进行1的与运算，从最低位开始找，找到二进制位首个两者不同的位置
4、对所有数进行分组并异或运算，最终得到两个数字
5、存入结果数组，并排序
 */
public class Solution {
    public int[] FindNumsAppearOnce (int[] array) {
        int temp = 0;
        for (int num : array) {
            temp ^= num;
        }
        int mask = 1;
        while ((temp & mask) == 0) {
            mask <<= 1;
        }
        int x = 0, y = 0;
        for (int num : array) {
            if ((num & mask) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        int[] res = new int[2];
        res[0] = x;
        res[1] = y;
        Arrays.sort(res);
        return res;
    }
}