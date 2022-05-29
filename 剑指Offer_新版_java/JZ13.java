// 13. 机器人的运动范围


public class Solution {
    ArrayList<String> list = new ArrayList<>();

    public int movingCount(int threshold, int rows, int cols) {
        return stat(threshold, rows, cols, 0, 0);
    }

    private int stat(int threshold, int rows, int cols, int row, int col) {
        if (row % 10 + row / 10 + col % 10 + col / 10 > threshold) {
            return 0;
        }
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        String key = row + " " + col;
        if (list.contains(key)) {
            return 0;
        } else {
            list.add(key);
        }
        return 1 +
                stat(threshold, rows, cols, row + 1, col) +
                stat(threshold, rows, cols, row - 1, col) +
                stat(threshold, rows, cols, row, col + 1) +
                stat(threshold, rows, cols, row, col - 1);
    }
}