package CarlPractice;

import java.util.*;

class carlHashTable {
	public static void main(String[] args) {
		
//		// 242. 有效的字母异位词
//		String s = "anagram";
//		String t = "nagaram";
//		boolean result = isAnagram(s, t);
//		System.out.println(result);
		
		// 349. 两个数组的交集
		int [] nums1 = {1,2,2,1};
		int [] nums2 = {2,2};
		
		int [] result = intersection(nums1, nums2);
		for (int i: result) {
			System.out.println(i);	
		}
	}
	
	// 242. 有效的字母异位词
	// 需要把字符映射到数组也就是哈希表的索引下标上，  因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下标0，相应的字符z映射为下标25。
	// 时间复杂度：O(n)，
	// 空间复杂度：O(1)，空间上因为定义是的一个常量大小的辅助数组
	public static boolean isAnagram(String s, String t) {
		int [] record = new int [26];
		
		for (char c: s.toCharArray()) {
			record[c - 'a'] ++;
		}
	
		for (char c: t.toCharArray()) {
			record[c - 'a'] --;
		}
	
		for (int i: record)
			if (i != 0) {
				return false;
			}
		return true;
	}
	
	// 349. 两个数组的交集
	// 1 <= nums1.length, nums2.length <= 1000
	// 0 <= nums1[i], nums2[i] <= 1000
	// 用数组: 数组都是1000以内
	// 结果使用unordered_set 读写效率是最高的，并不需要对数据进行排序，而且还不要让数据重复
	public static int[] intersection(int[] nums1, int[] nums2) {
		// 先判断合法性
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		
		int [] hash = new int [1005];
		Set<Integer> result = new HashSet<>();
		
		for (int i: nums1) {
			hash[i] = 1;
		}
		
		for (int i: nums2) {
			if (hash[i] == 1) {
				result.add(i);
			}
		}
		return result.stream().mapToInt(x -> x).toArray();
	}
	
	//用Set：当题目没有限制数值的大小
	public static int[] intersection2(int[] nums1, int[] nums2) {
		// 先判断合法性
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		
		Set<Integer> result = new HashSet<>();
		Set<Integer> set1 = new HashSet<>();
		
		//遍历数组1
		for (int i : nums1) {
			set1.add(i);
		}
		//遍历数组2的过程中判断哈希表中是否存在该元素
		for (int i : nums2) {
			if (set1.contains(i)) {
				result.add(i);
			}
		}
		
		//将结果几何转为数组
		return result.stream().mapToInt(x -> x).toArray();
	}
} 