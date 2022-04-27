// 347. 前 K 个高频元素
// 主要思路同“215. 数组中的第K个最大元素”

/*
优先级队列，最小堆：
1、统计元素的出现频率保存在map中
2、优先级队列按照元素的频率 对元素升序排序，即小元素在队头，队列只保存最多k个元素
3、遍历map，如果队列小于k，则直接将元素存入队列。否则跟队头元素比较频率，队头元素频率低则出栈，新元素入栈
4、最终队列保存了前K个高频元素，转化成数组返回
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(Integer num : map.keySet()) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (map.get(num) > map.get(queue.peek())) {
                queue.remove();
                queue.add(num);
            }
        }
        int n = queue.size();
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}


/*
快速排序
1、统计元素的出现频率保存在numToCountMap中，即 {元素：频率}
2、将频率对应的元素保存在countToNumMap中，即 {频率：[元素1,元素2]}
3、将频率保存在频率数组countArray中，对数组进行快速排序，得到频率第k大的索引
4、遍历topk频率，找到对应的元素，加入结果数组中。要保证同一频率的元素优先取尽，且只取k个，结果数组不越界

与“215. 数组中的第K个最大元素”区别：
1、本题需要对数组元素、频率处理。215题不需要
2、本题排序方法返回的是第k大的元素的索引，再通过索引取前k个高频元素。215题排序方法直接返回第K个最大元素
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : nums) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, ArrayList<Integer>> countToNumMap = new HashMap<>();
        int n = numToCountMap.size();
        int index = 0;
        int[] countArray = new int[n];
        for (int num : numToCountMap.keySet()) {
            int count = numToCountMap.get(num);
            ArrayList<Integer> list = countToNumMap.getOrDefault(count, new ArrayList<Integer>());
            list.add(num);
            countToNumMap.put(count, list);
            countArray[index++] = count;
        }

        int topkIndex = mainSort(countArray, 0, n - 1, n - k);
        int[] res = new int[k];
        index = 0;
        for (int i = topkIndex; i < n; i++) {
            ArrayList<Integer> list = countToNumMap.get(countArray[i]);
            while (list.size() > 0 && index < k) {
                res[index++] = list.get(0);
                list.remove(0);
            }
        }
        return res;
    }

    private int mainSort(int[] nums, int left, int right, int target) {
        if (left == right) {
            return left;
        }
        int res;
        int mid = partition(nums, left, right);
        if (mid == target) {
            res = mid;
        } else if (mid > target) {
            res = mainSort(nums, left, mid - 1, target);
        } else {
            res = mainSort(nums, mid + 1, right, target);
        }
        return res;
    }

    private int partition(int[] nums, int left, int right) {
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (nums[i] < nums[left]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, left, index - 1);
        return index - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


/*
最大堆排序：思路同上，排序方法不同
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (int num : nums) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, ArrayList<Integer>> countToNumMap = new HashMap<>();
        int n = numToCountMap.size();
        int index = 0;
        int[] countArray = new int[n];
        for (int num : numToCountMap.keySet()) {
            int count = numToCountMap.get(num);
            ArrayList<Integer> list = countToNumMap.getOrDefault(count, new ArrayList<Integer>());
            list.add(num);
            countToNumMap.put(count, list);
            countArray[index++] = count;
        }

        int topkIndex = mainSort(countArray, k);
        int[] res = new int[k];
        index = 0;
        for (int i = topkIndex; i < n; i++) {
            ArrayList<Integer> list = countToNumMap.get(countArray[i]);
            while (list.size() > 0 && index < k) {
                res[index++] = list.get(0);
                list.remove(0);
            }
        }
        return res;
    }

    public int mainSort(int[] nums, int k) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i, n);
        }
        while (n > 0 && k > 0) {
            swap(nums, 0, n - 1);
            n--;
            k--;
            maxHeapify(nums, 0, n);
        }
        return n;
    }

    private void maxHeapify(int[] nums, int root, int n) {
        int maxIndex = root;
        int left = root * 2 + 1, right = root * 2 + 2;
        if (left < n && nums[left] > nums[maxIndex])
            maxIndex = left;
        if (right < n && nums[right] > nums[maxIndex])
            maxIndex = right;
        if (maxIndex != root) {
            swap(nums, maxIndex, root);
            maxHeapify(nums, maxIndex, n);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}