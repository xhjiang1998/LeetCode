package xhjiang.leetcode.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三数之和
 * @author: xhjiang
 * @date: 2025/2/12 10:10
 */
public class execrise15 {
    //从整数数组中找出三个不同的下标的数，使得加起来为0，返回二维数组
    public List<List<Integer>> threeSum(int[] nums){
    //思路：固定一个数，用双指针去找其他两数之和是否为该数负值即可
        List<List<Integer>> sumList= new ArrayList<>();
        //先快排，变有序
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            // 跳过重复的值(因为此处已经有序了，所以只需要判断和下一个是否相同，相同的话，三数之和为0，那么第三个值肯定也是一样的
            // 直接下一次循环)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            checkAdd(nums,i,sumList);
        }
        return sumList;
    }

    // 双指针，这里必须要先对数组进行排序，才能用双指针进行比较
    private void checkAdd(int[] nums, int i, List<List<Integer>> sumList) {
        //由于数组有序+已固定一个数nums[i]，那么其他两个数就是left和right，所以left和right的初始值分别为i+1和nums.length-1
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];

            if (sum == 0) {
                // 找到一个三元组
                sumList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                // 跳过重复的值
                while (left < right && nums[left] == nums[left + 1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right - 1]) {
                    right--;
                }

                // 移动指针
                left++;
                right--;
            } else if (sum < 0) {
                // 如果和小于0，移动左指针
                left++;
            } else {
                // 如果和大于0，移动右指针
                right--;
            }
        }
    }

    public void quickSort(int[] nums,int left,int right){
        if (left<right) {
            int pivotIndex=partition(nums,left,right);
            quickSort(nums,left,pivotIndex-1);
            quickSort(nums,pivotIndex+1,right);
        }
    }

    // 快速排序的比较和交换
    private int partition(int[] nums,int left,int right){
        int pivot=nums[left];
        int i=left;
        int j=right;
        while(i<j){
            while(i<j&&nums[j]>=pivot){
                j--;
            }
            while(i<j&&nums[i]<=pivot){
                i++;
            }
            if (i<j){
                swap(nums,i,j);
            }
        }
        swap(nums,left,i);
        return i;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


    public static void main(String[] args) {
        execrise15 execrise15=new execrise15();
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = execrise15.threeSum(nums);
        System.out.println(lists);
    }
}
