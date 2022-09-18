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