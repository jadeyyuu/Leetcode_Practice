package CarlPractice;
import java.awt.*;
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
//		for (int i: result) {
//			System.out.println(i);	
//		}
		
		String s1 = "abccc", s2 = "aab";
		boolean re = canConstruct(s1, s2);
	}
	
	// 242. 有效的字母异位词
	// Link: https://leetcode.cn/problems/valid-anagram/
	// 需要把字符映射到数组也就是哈希表的索引下标上,因为字符a到字符z的ASCII是26个连续的数值，所以字符a映射为下标0，相应的字符z映射为下标25。
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
	
	// 383. 赎金信
	// Link: https://leetcode.cn/problems/ransom-note/submissions/
	public static boolean canConstruct(String ransomNote, String magazine) {
		int [] records = new int [26];
		
		for (char c: ransomNote.toCharArray()) {
			records[c - 'a'] += 1;
		}
		
		for (char c: magazine.toCharArray()) {
			records[c - 'a'] -= 1;
		}
		
		for (int i: records) {
			if (i < 0) return false;
		}
		
		return true;
	}
	
	// 349. 两个数组的交集
	// Link: https://leetcode.cn/problems/intersection-of-two-arrays/
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
	
	
	// 第202题. 快乐数
	// Link: https://leetcode.cn/problems/happy-number/
	
	public boolean isHappy(int n) {
		Set<Integer> record = new HashSet<>();
		// 如果n出现则已陷入无限循环，return false；
		while (n != 1 && !record.contains(n)) {
			record.add(n);
			n = getNextNumber(n);
		}
		return n == 1;
	}
	
	public int getNextNumber(int n) {
		int res = 0;
		while (n > 0) {
			int temp = n % 10; //个位数
			res += temp * temp;
			n = n /10;
		}
		return res;
	}
	
	// 1. 两数之和
	// Link：https://leetcode.cn/problems/two-sum/
	// Notes: 
	// 1.为什么会想到用哈希表? - 
	// 2.哈希表为什么用map
	// 3.本题map是用来存什么的
	// 4.map中的key和value用来存什么的 - map中key用来存
	public int[] twoSum(int[] nums, int target) {
		// 初始化两位数的数组为最后的结果
		// 首先考虑不合规的情况
		int [] res = new int [2];
		if (nums == null || nums.length == 0) {
			return res;
		}
		
		Map<Integer,Integer> map = new HashMap<>();
		for (int i =0; i < nums.length; i++) {
			int s = target - nums[i];
			if (map.containsKey(s)){
				res[1] = i;
				res[0] = map.get(s);
			}
			map.put(nums[i], i);
		}
		return res;
		
	}
	
	
	// 454. 四数相加 II
	// Link: https://leetcode.cn/problems/4sum-ii/
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer,Integer> map = new HashMap<>();
		int count = 0;
		//统计前两个数组中的元素之和，同时统计出现的次数，放入map
		for (int a: nums1) {
			for (int b: nums2) {
				int temp = a + b;
				if (map.containsKey(temp)) {
					map.put(temp, map.get(temp) + 1);
				} else {
					map.put(temp, 1);
				}
			}
		}
		for (int c: nums3) {
			for (int d: nums4) {
				int target = 0 - (c + d);
				if (map.containsKey(target)) {
					count += map.get(target);
				}
			}
		}
		return count;
	}
	

	
	// 15. 三数之和
	// Link: https://leetcode.cn/problems/3sum/
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		// 找出a + b + c = 0
		// a = nums[i], b = nums[left], c = nums[right]
		for (int i; i < nums.length; i++) {
			// 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
			if (nums[i] > 0) return ans;
			
			// 错误去重a方法，将会漏掉-1,-1,2 这种情况
			/*
			if (nums[i] == nums[i + 1]) continue;
			*/
			// 正确去重a方法
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int left = i + 1;
			int right = nums.length - 1;
			
			while (left < right) {
				// 去重复逻辑如果放在这里，0，0，0 的情况，可能直接导致 right<=left 了，从而漏掉了 0,0,0 这种三元组
				/*
				while (right > left && nums[right] == nums[right - 1]) right--;
				while (right > left && nums[left] == nums[left + 1]) left++;
				*/
				if (nums[i] + nums[left] + nums[right] > 0) right--;
				else if (nums[i] + nums[left] + nums[right] < 0) left++;
				else {
					ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// 去重逻辑应该放在找到一个三元组之后，对b 和 c去重
					while (right > left && nums[right] == nums[right - 1]) right--;
					while (right > left && nums[left] == nums[left + 1]) left++;
					
					// 找到答案时，双指针同时收缩
					right--;
					left++;
				}
			}
			
		}
		return ans;
	}
	
	// 第18题. 四数之和
	// Link: https://leetcode.cn/problems/4sum/
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>(0);
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length; i ++) {
			
			// nums[i] > target 直接返回, 剪枝操作
			if (nums[i] > 0 && nums[i] > target) {
				return result;
			}
			
			// 对nums[k]去重
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			// 二级操作
			for (int j = i + 1; j < nums.length; j ++) {
				// 对nums[j]去重
				if (j > i + 1 && nums[j - 1] == nums[j]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (right > left) {
					// nums[k] + nums[i] + nums[left] + nums[right] > target 会溢出
					long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
					if (sum > target) {
						right--;
					} else if (sum < target) {
						left++;
					} else {
						result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						// 对nums[left]和nums[right]去重
						while (right > left && nums[right] == nums[right - 1]) right--;
						while (right > left && nums[left] == nums[left + 1]) left++;
						
						// 找到答案时，双指针同时收缩
						left++;
						right--;
					}
				}
			}
		}
		
		return result;
		
	}
	
} 