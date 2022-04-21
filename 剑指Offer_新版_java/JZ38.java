// 38. 字符串的排列


public class Solution {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str.length() != 0) {
            TreeSet<String> set = new TreeSet<>();
            Permutation(str.toCharArray(), 0, set);
            list.addAll(set);
        }
        return list;
    }

    private void Permutation(char[] chars, int begin, TreeSet<String> set) {
        if (begin == chars.length - 1) {
            set.add(String.valueOf(chars));
        } else {
            for (int i = begin; i < chars.length; i++) {
                swap(chars, begin, i);
                Permutation(chars, begin + 1, set);
                swap(chars, begin, i);
            }
        }
    }

    private void swap(char[] x, int a, int b) {
        char t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
