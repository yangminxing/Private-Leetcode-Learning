package yangminxing.leetcode.TwoSum;

public class TwoSum {

    public static void main(String[] args) {

        int[] testCaseInts = new int[]{1,5,3,2,5,3,222,6,7,6,8,9};

        TwoSum testCaseObject = new TwoSum();
        int[] result = testCaseObject.twoSum(testCaseInts, 17);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0]=i;
                    result[1]=j;
                    break;
                }
            }
        }
        return result;
    }

}
