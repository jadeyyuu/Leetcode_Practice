package HandoverCampus22;

import java.util.*;

// 小红书笔试 赛码 2022/09/04 4PM-6PM
public class xiaoHongShu0904 {
}

/**
 * 01 镜像序列
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 已知一个序列的生成方式如下：
 *
 * • 序列生成需要一个基础序列A，这个序列由n个 不大于100的数字组成，同时给定镜像复制次数m。
 *
 * • 然后对于A进行m次镜像复制，例如序列A={1，2，3}，则一次镜像复制后得到的序列是{1，2，3，3，2，1}，两次镜像复制得到的序列是B={1，2，3，3，2，1，1，2，3，3，2，1} 。
 *
 * 现在给出你生成一个序列所需要的参数，请你计算该序列的第k位是多少。
 *
 *
 *
 * 输入描述
 * 输入第一行包含三个整数n，m，k，含义如题所示。(1<=n<=100,1<=m<=60,1<=k<=1e18，部分数据k<10000)
 *
 * 输入第二行包含n个正整数，每个正整数都不大于100，表示基础序列A。
 *
 * 数字间有空格隔开
 *
 * 输出描述
 * 输出仅包含一个正整数，即序列第k位的数字。
 *
 *
 * 样例输入
 * 3 3 10
 * 1 2 3
 * 样例输出
 * 3
 */
class ListNode {
    int val;
    ListNode next;

    public ListNode(){
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
class mirrorOrder{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        // 读取数组
        int [] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // 存进链表
        ListNode root = arrayToListNode(nums);



        if (m > 1) {
            reverseList(root);
        }

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }


    }

    //数组转换成链表
    public static ListNode arrayToListNode(int[] s) {
        ListNode root = new ListNode(s[0]);
        ListNode other = root;
        for (int i = 1; i < s.length; i++) {
            ListNode temp = new ListNode(s[i]);
            other.next = temp;
            other = temp;
        }
        return root;
    }


    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if (head.next == null) return head;
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }



}

/**
 * 02 乘积为7
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 给定n个整数a1, a2, a3 … an。每次操作可以选择其中一个数，并将这个数加上1或者减去1。小红非常喜欢7这个数，他想知道至少需要多少次操作可以使这n个数的乘积为7？
 *
 *
 *
 * 输入描述
 * 第一行输入一个正整数n，表示整数的个数。
 *
 * 第二行输入n个整数a1, a2, a3 … an，其中ai 表示第i个数。
 *
 * 输出描述
 * 输出一个整数，表示将所有数的乘积变为7最少需要的操作次数。
 *
 *
 * 样例输入
 * 5
 * -6 0 2 -2 3
 * 样例输出
 * 6
 *
 * 提示
 * 1 ≤ n ≤ 30000，-109  ≤ ai ≤ 109
 *
 * 样例说明
 *
 * 一种可能的操作方式如下：
 *
 * 第一次操作将a1减1，得到[-7,0,2,-2,3]
 *
 * 第二次操作将a4加1，得到[-7,0,2,-1,3]
 *
 * 第三次操作将a3减1，得到[-7,0,1,-1,3]
 *
 * 第四次操作将a5减1，得到[-7,0,1,-1,2]
 *
 * 第五次操作将a5减1，得到[-7,0,1,-1,1]
 *
 * 第六次操作将a2加1，得到[-7,1,1,-1,1]，此时所有数的乘积为7
 */
// import java.io.*;
//         import java.util.*;
// class Solution {
//     public int multiAnswer(int[] nums) {
//         int res = 0;
//         for (int i = 0; i< nums.length; i++) {
//             int temp = Math.abs(nums[i] % 7);
//             int mod = temp % 7;
//             if (mod > 3) {
//                 res += 7 - mod;
//             } else if (mod >= 2) {
//                 res += mod - 1;
//             } else if (mod == 0 && temp == 0) {
//                 res += 1;
//             }
//         }
//         return res;
//     }
// }
// public class Main
// {
//     public static void main(String args[])
//     {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int [] nums = new int[n];
//         for (int i = 0; i < n; i++) {
//             nums[i] = sc.nextInt();
//         }
//         Solution s = new Solution();
//         int c = s.multiAnswer(nums);
//         System.out.println(c);
//     }
//
// }

/**
 * 最小过路费用
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小明的旅途中需要经过一个国家。这个国家有n个城市，编号为1到n。小明会从1号城市进入，目标是从n号城市出去（即要从1号城市到达n号城市）。有m条双向道路连接这n个城市，每条道路的长度都是1，并且都有一个过路费（是[1,100000]之间的整数）。当小明在一号城市时，他可以预先花费X的费用办一张特权卡，他可以获得所有过路费不超过X的道路的通行权（而其他道路无法通过）。小明一天最多只能走k长度的路，他想知道如果他想在一天之内从1号城市走到n号城市，他最少需要花费多少来办特权卡，即求X的最小值？
 *
 *
 *
 * 输入描述
 * 第一行是3个整数n，m，k，分别表示城市数，道路数和小明一天最多能走的长度。
 *
 * 第二行m个整数，分别为u1, u2, …, um，分别表示第i条道路的一个端点。
 *
 * 第三行m个整数，分别为v1, v2, …, vm，分别表示第i条道路的另一个端点。
 *
 * 第四行m个整数，分别为w1, w2, …, wm，分别表示第i条道路的过路费。
 *
 * 数字间两两有空格隔开。数据保证一定存在解。
 *
 * 输出描述
 * 一行一个整数，表示X的最小值。
 *
 *
 * 样例输入
 * 5 6 3
 * 1 1 2 3 3 4
 * 2 5 3 4 5 5
 * 1 3 1 2 1 1
 * 样例输出
 * 1
 *
 * 提示
 * n<=100000，m<=200000，1<=w<=100000。
 */