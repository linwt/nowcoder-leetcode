// 470. 用 Rand7() 实现 Rand10()


/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */


/*
拒绝采样：
(rand7()-1)*7 等概率产生 0 7 14 21 28 35 42
rand7()-1 等概率产生 0 1 2 3 4 5 6。这里减1目的是缩小产生数字范围，减少拒绝采样量，增大命中率
两者相加则等概率产生 0-42，在大的等概率空间中取小范围的数，拒绝采样40-42，剩下 0-39 数量上刚好为 10 的倍数，除以10取余加1就可以得到随机数[1,10]
0-9、10-19、20-29、30-39
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7() - 1;
            if (num < 40) {
                return num % 10 + 1;
            }
        }
    }
}


/*
拒绝采样：
1、去掉最后的1-9，剩下的数都是1-10等概率产生
2、return公式理解：错误公式 ((a - 1) * 7 + b) % 10，假如刚好是2行3列的10，则会返回0，但最终要求返回[1,10]，所以要先b-1，最后再+1

   b  1  2  3  4  5  6  7
 a
 1    1  2  3  4  5  6  7
 2    8  9 10  1  2  3  4
 3    5  6  7  8  9 10  1
 4    2  3  4  5  6  7  8
 5    9 10  1  2  3  4  5
 6    6  7  8  9 10  1  2
 7    3  4  5  6  7  8  9
 */
class Solution extends SolBase {
    public int rand10() {
        while (true) {
            int a = rand7(), b = rand7();
            if ((a == 6 && b < 6) || a < 6) {
                return ((a - 1) * 7 + b - 1) % 10 + 1;
            }
        }
    }
}