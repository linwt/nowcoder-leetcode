// 496. 下一个更大元素 I


/*
暴力：
1、初始化结果数组为-1，表示不存在的情况
2、两个for循环遍历数组，flag标记表示找到了nums1的x在nums2的位置，再往后遍历时比x大就记录该值
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    flag = true;
                }
                if (flag && nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }
}


/*
单调递减栈：
1、从右到左遍历nums2数组，获取每个元素的下一个更大元素
  1）栈不为空 且 当前元素大于等于栈顶元素，则栈顶元素出栈，循环处理，直到当前元素小于栈顶元素，那么栈顶元素就是当前元素的下一个更大元素
  2）记录当前元素的下一个更大元素到map中，当前元素入栈
2、遍历nums1数组，直接从map中获取当前元素的下一个更大元素，存入结果数组，返回结果
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        int n = nums1.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}