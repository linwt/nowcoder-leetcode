// 38. 字符串的排列


public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() != 0) {
            TreeSet<String> set = new TreeSet<>();
            backtrack(str.toCharArray(), 0, set);
            list.addAll(set);
        }
        return list;
    }

    private void backtrack(char[] array, int begin, TreeSet<String> set) {
        if (begin == array.length - 1) {
            set.add(String.valueOf(array));
        } else {
            for (int i = begin; i < array.length; i++) {
                swap(array, begin, i);
                backtrack(array, begin + 1, set);
                swap(array, begin, i);
            }
        }
    }

    private void swap(char[] array, int x, int y) {
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
