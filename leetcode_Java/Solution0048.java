// 48. 旋转图像


/*
翻转：
1、对角线翻转：对角线元素交换
2、水平翻转：左右两侧元素交换

1 2 3     1 4 7     7 4 1
4 5 6  →  2 5 8  →  8 5 2
7 8 9     3 6 9     9 6 3
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}


/*
原地旋转：
1、箭头横向是行，纵向是列
2、确定旋转位置，定位一个点，推算出旋转后在对应四个位置上的索引，每次遍历都是交换这四个点的位置
   1）赋值方向：(i, j) → (j, n-1-i) → (n-1-i, n-1-j) → (n-1-j, i) → (i, j)
   2）索引变化规律：
     ① 当前点的列 直接变成 下一点的行  ( ,x) → (x, )
     ② 当前点的行 转化变成 下一点的列  (x, ) → ( ,n-1-x)  (n-1-x, ) → ( ,x)
     ③ 确定下一选择位置的索引，直接根据以上两个规律写出坐标
3、确定遍历范围，每次遍历都是操作四个点，所以只需要遍历 n²/4 个格子即可，对n为偶数和奇数的情况将格子四等分，推算出统一的遍历范围
   0 <= i < n/2
   0 <= j < (n+1)/2

             j
             ↓
    i →  1   2   3   4   5
         6   7   8   9  10
        11  12  13  14  15
        16  17  18  19  20
        21  22  23  24  25

                        n-1-i
                         ↓
         1   2   3   4   5
         6   7   8   9  10  ← j
        11  12  13  14  15
        16  17  18  19  20
        21  22  23  24  25

         1   2   3   4   5
         6   7   8   9  10
        11  12  13  14  15
        16  17  18  19  20
        21  22  23  24  25 ← n-1-i
                    ↑
                   n-1-j

         1   2   3   4   5
         6   7   8   9  10
        11  12  13  14  15
n-1-j → 16  17  18  19  20
        21  22  23  24  25
        ↑
        i

 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int row = n / 2, col = (n + 1) / 2;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}