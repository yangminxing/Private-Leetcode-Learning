package yangminxing.leetcode.util;

/**
 * Provide some common useful method
 * 
 */
public class CommonUtil {

    public static void printArray(int[] source){
        for(int i=0;i<source.length;i++){
            System.out.print(source[i] +", ");
        }
        System.out.println();
    }

    public static void printArray(int[][] source){
        for(int i=0;i<source.length;i++){
            printArray(source[i]);
            System.out.println();
        }
    }

}
