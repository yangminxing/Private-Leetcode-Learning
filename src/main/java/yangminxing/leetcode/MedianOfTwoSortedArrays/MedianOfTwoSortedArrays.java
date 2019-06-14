package yangminxing.leetcode.MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{0,0,4};
        int[] num2 = new int[]{0,1,1};

        MedianOfTwoSortedArrays sol = new MedianOfTwoSortedArrays();
        System.out.println(sol.findMedianSortedArrays(num1, num2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return me(nums1, nums2);
    }

    public double me(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int checkIndex1 = 0;
        int checkIndex2 = 0;
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int medianIndex = (num1Length + num2Length) / 2 ;
        boolean divideFlag = (num1Length + num2Length) % 2 == 0 ? true : false;

        int prevNum = 0;

        while (true) {

            if (checkIndex1== medianIndex) {
                int curValue;
                if (checkIndex1 > num1Length - 1) {
                    curValue = nums2[checkIndex2];
                } else {
                    curValue = nums1[checkIndex1];
                }
                if (divideFlag) {
                    return (((double)curValue + (double)prevNum) / 2);
                }
                return nums1[checkIndex1];
            }

            if (checkIndex2 == medianIndex) {
                int curValue;
                if (checkIndex2 > num2Length - 1) {
                    curValue = nums1[checkIndex1];
                } else {
                    curValue = nums2[checkIndex2];
                }
                if (divideFlag) {
                    return (((double)curValue + (double)prevNum) / 2);
                }
                return nums2[checkIndex2];
            }

            if (checkIndex1 == num1Length) {
                prevNum = nums2[checkIndex2];
                checkIndex2++;
                continue;
            }

            if (checkIndex2 == num2Length) {
                prevNum = nums1[checkIndex1];
                checkIndex1++;
                continue;
            }

            if (nums1[checkIndex1] <= nums2[checkIndex2]) {
                prevNum = nums1[checkIndex1];
                checkIndex1++;
                continue;
            }

            if (nums1[checkIndex1] > nums2[checkIndex2]) {
                prevNum = nums2[checkIndex2];
                checkIndex2++;
                continue;
            }

        }
    }
}
