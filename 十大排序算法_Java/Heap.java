package sort;

/*
1、堆：堆本质上就是一棵完全二叉树，它的每一个节点都必须大于等于或者小于等于其子节点
2、最大堆：每个节点都大于等于子树所有节点的堆称为最大堆
   最小堆：每个节点都小于等于子树所有节点的堆称为最小堆
3、数组存储堆，节点的索引关系如下
  索引角度：起始索引为0，某个节点在数组中的索引为i，则其（直接看索引，好记）
  1）父节点索引：(i-1)/2
  2）左子节点索引：2i+1
  3）右子节点索引：2i+2
  位置角度：起始位置为1，某个节点在数组中的位置为j，则其（换算了一遍，不好记）
  1）父节点索引：((j-1)-1)/2 = j/2-1
  2）左子节点索引：2(j-1)+1 = 2j-1
  3）右子节点索引：2(j-1)+2 = 2j
 */


// 堆排序
/*
最大堆排序思路：
1、先将普通数组调整成最大堆数组
2、堆顶元素就是最大值，将堆顶元素交换到数组尾部，重新调整剩余数组元素为最大堆
3、循环处理第2步，最终数组升序排序
 */
public class Heap {
    private int n;

    public int[] heapSort(int[] nums) {
        n = nums.length;
        // 堆的构造需要跟子节点比较，所以从 最后一个非叶子结点(最后一个节点的父节点) 开始向上构造最大堆
        // 必须从下往上逐层调整，每一层小值向下浮动，大值交换上去，最终最大值会升到根节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i);
        }
        // 在最大堆的基础上，只改变了一个元素，重新调整为最大堆只需进行一次小值向下浮动即可
        while (n > 0) {
            // 根节点与最后一个节点交换，最终形成升序排序
            swap(nums, 0, n - 1);
            // n控制着剩余可调整的数组元素范围，即堆顶元素交换到数组尾部后就不参与堆调整了
            n--;
            // 交换完重新调整成最大堆，父子两两交换，把小值往下换，把最大值升到根节点
            maxHeapify(nums, 0);
        }
        return nums;
    }

    // 方法作用：将小值向下浮动。即父节点与子节点较大者交换，并递归处理
    private void maxHeapify(int[] nums, int root) {
        int maxIndex = root;
        // 索引从0开始
        int left = root * 2 + 1, right = root * 2 + 2;
        // 如果有左孩子，且左孩子大于父节点，则将最大指针指向左孩子
        if (left < n && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        // 如果有右孩子，且右孩子大于父节点和左孩子，则将最大指针指向右孩子
        if (right < n && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        // 如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置
        if (maxIndex != root) {
            swap(nums, maxIndex, root);
            maxHeapify(nums, maxIndex);
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
        for (int num : nums) {
            System.out.println(num);
        }
    }
}


// 最大堆，升序排序，去注释
public class Heap {
    private int n;

    public int[] heapSort(int[] nums) {
        n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, i);
        }
        while (n > 0) {
            swap(nums, 0, n - 1);
            n--;
            maxHeapify(nums, 0);
        }
        return nums;
    }

    private void maxHeapify(int[] nums, int root) {
        int maxIndex = root;
        int left = root * 2 + 1, right = root * 2 + 2;
        if (left < n && nums[left] > nums[maxIndex]) {
            maxIndex = left;
        }
        if (right < n && nums[right] > nums[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != root) {
            swap(nums, maxIndex, root);
            maxHeapify(nums, maxIndex);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}


/*
最小堆排序思路：
1、先将普通数组调整成最小堆数组
2、堆顶元素就是最小值，将堆顶元素交换到数组尾部，重新调整剩余数组元素为最小堆
3、循环处理第2步，最终数组降序排序
 */
// 最小堆，降序排序，去注释
public class Heap {
    private int n;

    public int[] heapSort(int[] nums) {
        n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(nums, i);
        }
        while (n > 0) {
            swap(nums, 0, n - 1);
            n--;
            minHeapify(nums, 0);
        }
        return nums;
    }

    private void minHeapify(int[] nums, int root) {
        int minIndex = root;
        int left = root * 2 + 1, right = root * 2 + 2;
        if (left < n && nums[left] < nums[minIndex]) {
            minIndex = left;
        }
        if (right < n && nums[right] < nums[minIndex]) {
            minIndex = right;
        }
        if (minIndex != root) {
            swap(nums, minIndex, root);
            minHeapify(nums, minIndex);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
