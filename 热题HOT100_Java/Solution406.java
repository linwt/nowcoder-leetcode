package HOT100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 根据身高重建队列
public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0)
            return new int[0][0];

        // 身高降序，K升序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        // K为索引插入
        List<int[]> list = new ArrayList<>();
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        return list.toArray(new int[list.size()][]);
    }
}
