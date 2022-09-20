package HandoverCampus22;
import java.util.*;


// 美团笔试 赛码 2022/09/03 10AM-12AM
class meiTuan0903 {
}
/*
01 乒乓球
乒乓球，被称为中国的“国球”，是一种世界流行的球类体育项目。一局比赛的获胜规则如下：
当一方赢得至少11分，并且超过对方2分及以上时，获得该局的胜利。
按照上述规则，小美和小团正在进行一局比赛，当前比赛尚未结束，此时小美的得分为a，小团的得分为b。小美想知道，在最理想的情况下，她至少还要得多少分才可以赢下这场比赛。
输入两个整数a、b。a表示当前小美获得的分数，b表示小团的分数。
输出一个整数，表示小美至少还要得多少分才能获得这局比赛的胜利。
 */
class pingPang01 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int maxVal = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) continue;
            maxVal = i;
        }
        System.out.println(maxVal);
    }
}
/*
02 字母树
时间限制： 3000MS
内存限制： 589824KB
题目描述：
给定一棵有n个节点的树，节点用1,2, …, n编号。1号节点为树的根节点，每个节点上有一个用大写字母表示的标记。求每个节点的子树中出现的字母标记种类数。
注：子树的定义：设T是有根树，a是T中的一个顶点，由a以及a的所有后裔（后代）导出的子图称为有根树T的子树。
第一行输入一个正整数n, 表示树的节点数量。
第二行输入n-1个正整数，第i个整数表示第i+1号节点的父亲节点。
第三行输入长度为n的由大写字母组成的字符串s1s2…sn，第i个字符si表示第i号节点的标记。
3 ≤ n ≤ 50000。
数据保证形成一棵合法的树，字符串由大写字母组成。
输出:
输出n个整数，相邻两个数之间用空格隔开，第i个整数表示第i号节点的子树中出现不同的字母种类数

例子
    输入
    6
    1 2 2 1 4
    ABCCAD

    输出
    4 3 1 2 1 1

提示
1号节点的子树有节点{1,2,3,4,5,6}，出现了A, B, C, D四种字母。
2号节点的子树有节点{2,3,4,6}，出现了B, C, D三种字母。
3号节点的子树有节点{3}，出现了C一种字母。
4号节点的子树有节点{4, 6}， 出现了C，D两种字母。
5号节点的子树有节点{5}，出现了A一种字母。
6号节点的子树有节点{6}，出现了D一种字母。
*/

class tree03 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
           ar[i] = sc.nextInt();
           max = Math.max(ar[i], max);
       }
       int[] dp = new int[max+1];
       dp[0] = 0;
       dp[1] = 0;
       for (int i = 2; i < dp.length; i++) {
           int minProduct = Integer.MAX_VALUE;
           for (int j = 2; j < i/2;j++) {
               if (i % j == 0) {
                   minProduct = Math.min(dp[j] + dp[i/j], minProduct);
               }
               if (j*j > i) break;
           }
           dp[i] = Math.min(dp[i-1],minProduct)+1;
       }
       int sum = 0;
       for (int i = 0; i < ar.length;i++) {
           sum += dp[ar[i]];
       }
       System.out.println(sum);
    }

}

// 0920 面试题
/**
 * 输入：head  = [1,2,3,4,5] k = 2, 输出：[4,5,1,2,3]
 * 输入：head = [0,1,2], k = 4, 输出[2,0,1]
 */
class rotateRight {
    public static void main(String[] args) {
        //ex1
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        ListNode node13 = new ListNode(4);
        ListNode node14 = new ListNode(5);

        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        //ex2
        ListNode head2 = new ListNode(0);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        head2.next = node21;
        node21.next = node22;

        // output
        ListNode result = rotateRight(head2, 4);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    // Wrong Answer
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode pre = head;
        ListNode cur = null;
        int len = 1;

        while (pre.next != null) {
            pre = pre.next;
            len ++;
        }

        pre.next = head;
        int pos = len - k % len + 1;

        while (pos-- > 0) {
            pre = pre.next;
        }

        cur = pre;
        while (len -- >= 0) {
            pre = pre.next;
        }
        pre.next = null;
        return cur;
    }

    // Correct Answer
    public static ListNode rotateRight2(ListNode head, int k) {
        ListNode temp = head;
        ListNode cur = null;
        ListNode prev = null;
        int len = 1;

        while (temp.next != null) {
            temp = temp.next;
            len ++;
        }

        temp.next = head;
        int pos = len - k % len + 1;
        cur = temp; // 记录原链表的tail

        while (pos-- > 0) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = null;
        return cur;
    }

}

// 相似题 数组
/**
 * 189. 轮转数组
 * Link： https://leetcode.cn/problems/rotate-array/
 */

class rotate189 {
    public static void main(String [] args) {
        int [] nums = {1,2,3,4,5,6,7};
        rotate(nums, 12);
        for (int num: nums) {
            System.out.println(num);
        }
    }
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        System.out.println("k:" + k);
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }
}