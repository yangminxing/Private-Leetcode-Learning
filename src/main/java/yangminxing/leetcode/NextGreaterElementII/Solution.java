package yangminxing.leetcode.NextGreaterElementII;

import yangminxing.leetcode.TwoSum.TwoSum;

public class Solution {

    public static void main(String[] args) {
        // realAnswer = [8,222,222,-1,222,1111111,-1,1]
        int[] testCaseInts = new int[]{1,8,-1,-100,-1,222,1111111,-111111};

        Solution solution = new Solution();
        int[] result = solution.nextGreaterElements(testCaseInts);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            result[i]=-1;
        }

        for(int i=0; i<nums.length;i++){

            boolean findBehind =false;
            // i start to find behind
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    result[i]=nums[j];
                    findBehind =true;
                    break;
                }
            }

            // if not find behind, find front
            if(!findBehind){
                for(int f=0;f<i;f++){
                    if(nums[f]>nums[i]){
                        result[i]=nums[f];
                        break;
                    }
                }
            }
        }

        return result;
    }

}
