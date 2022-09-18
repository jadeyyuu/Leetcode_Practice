package CarlPractice;
import java.awt.image.*;
import java.util.Arrays;
public class carlArray {}
/**
 * 	704. 二分查找
 * 	Link: https://leetcode.cn/problems/binary-search/
 */

class search704{
	// 方法一： 左闭右开 [ )
	public static int search(int[] nums, int target) {
		int left = 0, right = nums.length;
		while(left < right) {
			int mid = left + ((right - left) >> 2);
			if (nums[mid] < target) {
				left = mid + 1;
			}
			else if (nums[mid] > target) {
				right = mid;
			} else {
				return mid;
			}
		}
		return -1;
	}

	// 方法二： 左闭右闭 [ ]
	public static int search2(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) >> 2);
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else return mid;
		}
		return -1;
	}

		}

/**
 * 	27. 移除元素
 * 	Link: https://leetcode.cn/problems/remove-element/
 */

class removeElement27 {
	// 双指针
	public static int removeElement(int[] nums, int val) {
		int slow = 0;
		for (int fast = 0; fast < nums.length; fast ++) {
			if (nums[fast] != val) {
				nums[slow] = nums [fast];
				slow ++;
			}
		}
		return slow;
	}
}

/**
 * 977.有序数组的平方
 * Link: https://leetcode.cn/problems/squares-of-a-sorted-array/
 */
class sortedSquares977 {
	public static void main(String[] args) {

		//		// 704. 二分查找
		//		int nums1 []= {-1,0, 3, 5, 9, 12};
		//		int result1 = search(nums1, 9);
		//		System.out.println("二分查找1: " + (result1 == 4));
		//		int result2 = search2(nums1, 9);
		//		System.out.println("二分查找2: " + (result2 == 4));
		//
		//
		//
		//		// 27. 移除元素
		//		int nums2 [] = {3,2,2,3};
		//		int result = removeElement(nums2, 3);
		//		System.out.println(result);
		//
		// 977.有序数组的平方
		int nums3 [] = {-4,-1,0,3,10};
		int trueAnw [] = {0,1,9,16,100};
		int [] result3 = sortedSquares(nums3);
		System.out.println("有序数组的平方: " + Arrays.equals(result3, trueAnw));

	}
	public static int[] sortedSquares(int[] nums) {
		int [] result = new int [nums.length];
		int k = nums.length - 1;
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			if (nums[left] * nums[left] < nums[right] * nums[right]) {
				result[k--] = nums[right] * nums[right];
				-- right;
			}
			else {
				result[k--] = nums[left] * nums[left];
				++ left;
			}
		}
		return result;
	}
}



