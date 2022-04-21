// 45. 把数组排成最小的数


public class Solution {
    public String PrintMinNumber(int[] numbers) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            // 返回负数则第一个参数放在前面，正数或零则第一个参数放在后面
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = o1 + "" + o2;
                String str2 = o2 + "" + o1;
                return str1.compareTo(str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }
        return sb.toString();
    }
}
