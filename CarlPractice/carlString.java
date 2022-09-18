package CarlPractice;

public class carlString {
}

/**
 * 344. 反转字符串
 * Link：https://leetcode.cn/problems/reverse-string/
 * 541. 反转字符串 II
 * Link: https://leetcode.cn/problems/reverse-string-ii/
 */
class reverseStr{
    public static void main(String[] args) {

        System.out.println(reverseStr("abcdefg", 2));
    }

    // 344. 反转字符串
    // Link：https://leetcode.cn/problems/reverse-string/
    public static void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            // char temp = s[l];
            // s[l] = s[r];
            // s[r] = temp;
            s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
            s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
            s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
            l ++;
            r --;
        }
    }

    // 541. 反转字符串 II
    // Link: https://leetcode.cn/problems/reverse-string-ii/
    public static String reverseStr(String s, int k) {
        char [] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i += 2 * k) {
            int start = i;
            //题目的意思其实概括为 每隔2k个反转前k个，尾数不够k个时候全部反转
            int end = Math.min(ch.length - 1, start + k -1);
            while (start < end) {
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
    // 解法2：
    public static String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i< ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverse(ch, i, i + k -1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(ch, i, ch.length - 1);
        }
        return  new String(ch);

    }
    // 定义翻转函数
    public static void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }

}

/**
 * 剑指 Offer 05. 替换空格
 * Link: https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 */
class replaceSpaceOffer05{
    public static void main (String [] args) {
        System.out.println(replaceSpace("We are happy."));
    }
    // 暴力解法：
    public static String replaceSpace(String s) {
        char [] ch = s.toCharArray();
        String result = "";
        for(int i = 0; i < ch.length; i++) {
            if (Character.isWhitespace(ch[i])) {
                result += "%20";
                continue;
            }
            result += ch[i];
        }
        return result;
    }
    // 优化代码 方法一：扩充空间
    // String对象的不可变性会带来效率问题，为String对象重载“+”操作符时，都会自动生成一个新的String对象。
    // 因此，String在上述的问题中已经会自动引入StringBuilder来解决效率问题
    public static String replaceSpace1(String s) {
        // 判断合法性
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        //使用 sb 逐个复制 str ，碰到空格则替换，否则直接复制
        for (int i = 0; i < s.length(); i++) {
            //str.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
            //if (" ".equals(String.valueOf(str.charAt(i)))){
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // 优化代码 方法二：双指针
    public static String replaceSpace2(String s) {
        // 判断合法性
        if (s == null || s.length() == 0) {
            return s;
        }

        //扩充数组到每个空格替换成"%20"之后的大小
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        //若是没有空格直接返回
        if(str.length() == 0){
            return s;
        }
        //有空格情况 定义两个指针
        int left = s.length() - 1;//左指针：指向原始字符串最后一个位置
        s += str.toString();
        int right = s.length()-1;//右指针：指向扩展字符串的最后一个位置
        char[] chars = s.toCharArray();
        while(left>=0){
            if(chars[left] == ' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);

    }
}

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 * Link: https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
class reverseLeftWordsOffer58{
    public static void main (String [] args) {
        System.out.println(reverseLeftWords("abcdefg", 2));
    }

    public static String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb,0,n-1);
        System.out.println(sb);
        reverseString(sb,n,len-1);
        System.out.println(sb);
        //reverse() 通过反转字符序列来反转该字符序列。
        return sb.reverse().toString();
    }

    public static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}

/**
 * 151.翻转字符串里的单词
 * Link: https://leetcode.cn/problems/reverse-words-in-a-string/
 */

class  reverseWords151{
    public static void main(String[] args) {
        // System.out.println(reverseWords3("the sky is blue"));
        System.out.println(reverseWords3("  hello world  "));
    }
    // 解法一：不使用Java内置方法实现
    public static String reverseWords1(String s) {
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }
    private static StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    // 反转字符串指定区间[start, end]的字符
    public static void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    //反转各个单词里的字母
    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

    // 解法二： 解法二：创建新字符数组填充。时间复杂度O(n)
    public static String reverseWords2(String s) {
        //源字符数组
        char[] initialArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initialArr.length+1];//下面循环添加"单词 "，最终末尾的空格不会返回
        int newArrPos = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = initialArr.length-1;
        while(i >= 0){
            while(i >= 0 && initialArr[i] == ' ') {i--;}  //跳过空格
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            int right = i;
            while(i >= 0 && initialArr[i] != ' ') {i--;}
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i+1; j <= right; j++) {
                newArr[newArrPos++] = initialArr[j];
                if(j == right){
                    newArr[newArrPos++] = ' ';//空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if(newArrPos == 0){
            return "";
        } else{
            return new String(newArr,0,newArrPos-1);
        }
    }

    // 解法三：双反转+移位，在原始数组上进行反转。空间复杂度O(1)
    public static String reverseWords3(String s) {

        //步骤1：字符串整体反转（此时其中的单词也都反转了）
        char [] initialArr = s.toCharArray();
        reverse(initialArr, 0, s.length() - 1);
        System.out.println("第一次反转" + new String(initialArr));
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果是空格 直接跳过
            if (initialArr[i] == ' ') {
                continue;
            }
            int tempCur = i;  // 单词的首字母
            //
            while (i < initialArr.length && initialArr[i] != ' ') {
                i++; // 单词的尾字母
            }

            // 在一个单词中
            for (int j = tempCur; j < i; j++) {
                if (j == tempCur) { //步骤二：二次反转
                    reverse(initialArr, tempCur, i - 1); //对指定范围字符串进行反转，不反转从后往前遍历一个个填充有问题
                    System.out.println("第二次反转" + new String(initialArr));
                }
                //步骤三：移动操作
                initialArr[k++] = initialArr[j]; //放进去单词的第一个字母
                if (j == i - 1) {
                    //避免越界情况，例如=> "asdasd df f"，不加判断最后就会数组越界
                    if (k < initialArr.length) {
                        initialArr[k++] = ' '; //在单词的结尾处加上空格
                    }
                }
            }
        }
        if (k == 0) {
            return "";
        } else {
            //参数三：以防出现如"asdasd df f"=>"f df asdasd"正好凑满不需要省略空格情况
            // return new String(initialArr, 0, (k == initialArr.length) && (initialArr[k - 1] != ' ') ? k : k - 1);
            return new String(initialArr);
        }
    }

    public static void reverse(char[] chars, int begin, int end) {
        for (int i = begin, j = end; i < j; i++, j--) {
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }
    }
}

/**
 *
 */
