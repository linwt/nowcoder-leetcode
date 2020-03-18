package sort;

// 堆排序
public class Heap {
    private int n;

    public int[] heapSort(int[] nums) {
        n = nums.length;
        // 堆的构造需要跟子节点比较，所以从最后一个非叶子结点开始向上构造最大堆
        for (int i = (n - 1) / 2; i >= 0; i--)
            max_heapify(nums, i);
        while (n > 0) {
            // 根节点与最后一个节点交换
            swap(nums, 0, n - 1);
            n--;
            // 交换完调整最大堆，父子两两交换，把小值往下换，把最大值升到根节点
            max_heapify(nums, 0);
        }
        return nums;
    }

    // 堆调整的逻辑：父节点与子节点较大者交换，最终最大值会升到根节点
    private void max_heapify(int[] nums, int root) {
        int maxIndex = root;
        int left = root * 2, right = root * 2 + 1;
        // 如果有左孩子，且左孩子大于父节点，则将最大指针指向左孩子
        if (left < n && nums[left] > nums[maxIndex])
            maxIndex = left;
        // 如果有右孩子，且右孩子大于父节点和左孩子，则将最大指针指向右孩子
        if (right < n && nums[right] > nums[maxIndex] && nums[right] > nums[left])
            maxIndex = right;
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != root) {
            swap(nums, maxIndex, root);
            max_heapify(nums, maxIndex);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 3, 8, 7, 5, 9};
        Heap heap = new Heap();
        nums = heap.heapSort(nums);
        for (int num : nums)
            System.out.println(num);
    }
}
