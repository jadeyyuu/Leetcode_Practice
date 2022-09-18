package HandoverCampus22;

public class frontendCamp2022 {
}

/**
 * 2114. 句子中的最多单词数
 * 1st Date: 2022/09/13
 * Link: https://leetcode.cn/problems/maximum-number-of-words-found-in-sentences/
 */
class mostWordsFound2114 {
    public int mostWordsFound(String[] sentences) {
        int maxCount = 0;
        for(String sentence: sentences) {
            int count = 1;
            for (char ch: sentence.toCharArray()) {
                if (ch == ' ') {
                    count ++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}

/**
 * 1450. 在既定时间做作业的学生人数
 * 1st Date: 2022/09/13
 * Link: https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 */

class busyStudent1450 {
    public static void main(String [] args) {
        System.out.println(busyStudent(new int [] {1,2,3}, new int [] {3, 2, 7}, 4));
    }
    // 枚举法
    // 时间复杂度：O(n)O(n)，其中 nn 为 数组的长度。只需遍历一遍数组即可。
    // 空间复杂度：O(1)O(1)。
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count ++;
            }
        }
        return count;
    }
}
