package offer;

// 	二维数组中的查找
public class Test01 {
    public boolean Find(int target, int[][] array) {
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col <= array[0].length - 1) {
            if (array[row][col] > target) {
                row--;
            } else if (array[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}
