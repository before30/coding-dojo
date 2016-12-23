package cc.before30.leetcode.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * User: before30 
 * Date: 2016. 12. 23.
 * Time: 오후 12:25
 */

public class Solution {
	public static void main(String[] args) {
		//{1, 7, 11, 15}, 9 => 하나만 있다고 가정 되어있음
		// o(n^2)
		Solution s = new Solution();
		int[] nums = {3, 2, 4};
		int[] result = s.twoSum2(nums, 6);
		System.out.println("[" + result[0] + "," + result[1] + "]");
	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i=0; i<nums.length-1; i++) {
			for (int j=i+1; j<nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					result[0] = i;
					result[1] = j;
				}
			}
		}

		return result;
	}


	public int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> idxMap = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			idxMap.put(nums[i], i);
		}

		for (int i=0; i<nums.length; i++) {
			if (idxMap.containsKey(target - nums[i])) {
				if ( i != idxMap.get(target - nums[i])) {
					result[0] = i;
					result[1] = idxMap.get(target - nums[i]);
					break;
				}
			}
		}

		return result;
	}
}
