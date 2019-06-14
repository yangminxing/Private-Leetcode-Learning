package yangminxing.leetcode.MedianOfTwoSortedArrays;

import java.util.Calendar;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 4};
        int[] num2 = new int[]{3, 6};

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
        int medianIndex = (num1Length + num2Length) / 2 +1;
        boolean divideFlag = (num1Length + num2Length) % 2 == 0 ? true : false;

        int prevNum = 0;

        while (true) {
            int curValue =0 ;
            boolean d=false;
            if (checkIndex1 == num1Length) {
                curValue = nums2[checkIndex2];
                checkIndex2++;
                d=true;
            }
            else if (checkIndex2 == num2Length) {
                curValue = nums1[checkIndex1];
                checkIndex1++;
                d=true;
            }


            if (!d && (nums1[checkIndex1] <= nums2[checkIndex2])) {
                curValue = nums1[checkIndex1];
                checkIndex1++;
            }
            else if (!d && (nums1[checkIndex1] > nums2[checkIndex2])) {
                curValue = nums2[checkIndex2];
                checkIndex2++;
            }

            if (checkIndex1 + checkIndex2 == medianIndex) {
                if (divideFlag) {
                    return (((double) curValue + (double) prevNum) / 2);
                }
                return curValue;
            }

            prevNum = curValue;
        }
    }
}
