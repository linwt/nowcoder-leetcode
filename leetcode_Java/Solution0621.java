// 621. 任务调度器


/*
桶填充：
1、统计每个任务的数量，以最大任务数为桶的数量，一行为一个桶
2、冷却为n，以n+1为桶的容量，因为执行同样的任务时间间隔为n+1，冷却时间内可以执行其他任务
3、任务填桶，当桶存在空闲空间时，即桶没有填满。不是最后一个桶则存在等待时间，最后一个桶则不存在等待时间，因为任务要结束了。
   所以“总排队时间t1 = (桶个数 - 1) * (n + 1) + 最后一桶的任务数”
4、当桶不存在空闲空间时，即桶填满了，所有任务都依次不断地在单位时间内执行完成，所以“总排队时间t2 = 任务总数”
5、存在空闲空间时 t1 比较大，不存在空闲空间时 t2 比较大，所以完成所有任务所需要的最短时间为 max(t1, t2)

A  B  C
A  B  C
A  B
A  B
=========
A  B  C  D
A  B  C  E
A  B  C  F
A  B  D
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        int maxTask = 0, rest = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > maxTask) {
                maxTask = count[i];
                rest = 1;
            } else if (count[i] == maxTask) {
                rest += 1;
            }
        }
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + rest);
    }
}