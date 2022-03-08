// 136. 只出现一次的数字


/*
思路：使用HashMap记录每个数出现的次数，遍历HashMap查找只出现一次的数字
 */
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;
    }
}


/*
思路：使用列表存放数字。没有出现过则存入，出现过则移除，最后剩下一个只出现一次的数字
 */
class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            Integer numObj = num;
            if (list.contains(numObj)) {
                list.remove(numObj);
            } else {
                list.add(numObj);
            }
        }
        return list.get(0);
    }
}


/*
思路：
既满足时间复杂度又满足空间复杂度，就要提到位运算中的异或运算 XOR，主要因为异或运算有以下几个特点：
一个数和 0 做 XOR 运算等于本身：a⊕0 = a
一个数和其本身做 XOR 运算等于 0：a⊕a = 0
XOR 运算满足交换律和结合律：a⊕b⊕a = (a⊕a)⊕b = 0⊕b = b
故而在以上的基础条件上，将所有数字按照顺序做异或运算，最后剩下的结果即为唯一的数字
 */
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}