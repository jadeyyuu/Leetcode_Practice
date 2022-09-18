package HandoverCampus22;

import java.util.*;

public class jingDong0903 {
}

/**
 * 01. 赝品
 题目描述：小红筆到了n个物品，每个物品的品质为ai。这n个物品中至少有一个真品。
 已知所有真品的品质都是相同的，但赝品的品质比真品低。小红想知道这n个物品中最多有多少赝品。
 输入描述：第一行输入一个正整数n，代表小红拿到的物品数量。第二行输入n个正整数ai，代表每个物品的品质。
 1 ≤ n ≤ 10^5
 1 ≤ ai ≤ 10^5
 输出描述：一个整数，代表赝品的数量。
 示例 1
 输入：
 1
 5
 输出：
 0
 说明：只有一个物品，显然是真品。
 示例 2
 输入：
 5
 2 3 1 3 3
 输出：
 2
 说明：所有品质为3的都是真品，所以第一个物品和第三个物品都是赝品。
 */
class fakeCount01 {
    public static void main (String[] args){

    }
    public static int fakeCount (int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) continue;
            count = i;
        }
        return count;
    }
}

/** 02. 小红的因子
 * 题目描述：小红拿到了一个正整数n，她希望找到n的一个最小因子p，满足p*p＞n。你能帮帮她吗？  一共有t组询问。
 * 输入描述：第一行输入一个正整数t，代表询问的次数。接下来的t行，每行输入一个正整数n/
 1 ≤ t ≤ 10
 2 ≤ n ≤ 10^12
 * 输出描述: 满足条件的最小因子
 * 示例1：
 输入
 2
 36
 37
 输出：
 9
 37
 */
class smallestFactor02{
    public static void main (String[] args) {

    }

    static int smallestFactor(long[] nums) {
        int num = 0;
        return num;
    }
}
/** 03. 小红的元素分裂
 * 题目描述：小红拿到了一个数组，她每次可以进行如下操作之一：
 •选择一个元素x，将其公裂为1和x-1.
 •选择一个元素x，将其分裂为a和b，需要保证a*b=x
 小红希望用最少的操作次数，将所有数组的所有元素全部变成1。你能帮帮她吗？
 * 输入描述：第一行输入一个正整数n，代表数组的长度。第二行输入n个正整数ai,代表小红拿到的数组。
 1 ≤ n, ai ≤ 10^5
 * 输出描述：一个整数，代表最小的操作次数。
 * 示例1：
 输入
 2
 2 6
 输出
 5
 说明：第一次，对第一个元态进行第一个操作，数组变成[1,1,6]。
 第二次，对第三个元素进行第二个操作,数组变成[1,1,2,3]。
 第三次，对第三个元素进行第一个操作，数组变成[1,1,1,1,3]。
 第四次，对第五个元素进行第一个操作，数组变成[1,1,1,1,2,1]。
 第五次，对第五个元素进行第一个操作，数组变成[1,1.1.1.1.1,1]。

 */
class factorization03 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
    }
    int factorization(){
        return 0;
    }
}
