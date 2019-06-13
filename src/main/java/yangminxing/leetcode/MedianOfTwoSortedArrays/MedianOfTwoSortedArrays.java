package yangminxing.leetcode.MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};

        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        System.out.println(sol.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return me(nums1, nums2);
    }

    public double me(int[] nums1, int[] nums2){
        int checkIndex1 = 0;
        int checkIndex2 = 0;
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int medianIndex = (num1Length+num2Length)/2-1 ;
        boolean divideFlag = (num1Length + num2Length)%2==0?true:false;
        int prevNum = 0;

        while(true){

            if(checkIndex1 == medianIndex){
                if(divideFlag){
                    return (double) ((nums1[checkIndex1] + prevNum)/2);
                }
                return nums1[checkIndex1];
            }

            if(checkIndex2 == medianIndex){
                if(divideFlag){
                    return (double) ((nums2[checkIndex1] + prevNum)/2);
                }
                return nums2[checkIndex1];
            }

            if(checkIndex1==num1Length-1){
                prevNum = nums2[checkIndex2];
                checkIndex2 ++;
                continue;
            }

            if(checkIndex2==num2Length-1){
                prevNum = nums1[checkIndex1];
                checkIndex1 ++;
                continue;
            }

            if(nums1[checkIndex1]<=nums2[checkIndex2]){
                prevNum = nums1[checkIndex1];
                checkIndex1 ++;
                continue;
            }

            if(nums1[checkIndex1]>nums2[checkIndex2]){
                prevNum = nums2[checkIndex2];
                checkIndex2 ++;
                continue;
            }


        }
    }

}
