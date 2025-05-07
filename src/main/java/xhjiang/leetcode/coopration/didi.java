package xhjiang.leetcode.coopration;

/**
 * @description: 滴滴
 * @author: xhjiang
 * @date: 2025/5/6 20:56
 *
 *
 */
public class didi {
    public static int[] twoSum(int[] nums,int target) {
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int sum=nums[left]+nums[right];
            if(sum==target){
                return new int[]{right,left};
            }else if(sum<target){
                left++;
            }else{
                right--;
            }
        }
        return null;
    }
}
