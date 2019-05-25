package yangminxing.leetcode.EditDistance;

import yangminxing.leetcode.util.CommonUtil;

public class EditDistance {

    public static void main(String[] args) {

        EditDistance solution = new EditDistance();
        String a = "abaa";
        String b = "a";

        System.out.println(solution.minDistance(a, b));

    }

    public int minDistance(String word1, String word2) {
        char[] xArrays = word1.toCharArray();
        char[] yArrays = word2.toCharArray();

        if(xArrays.length==0){
            return yArrays.length;
        }

        if(yArrays.length==0){
            return xArrays.length;
        }

        return dpCore(xArrays, yArrays);
    }

    public int dpCore(char[] xArrays, char[] yArrays){
        int[][] dpMatrix = new int[yArrays.length][xArrays.length];

        if(yArrays[0] == xArrays[0]){
            dpMatrix[0][0] =0;
        }else{
            dpMatrix[0][0]=1;
        }

//        for(int i=1;i<xArrays.length;i++){
//            if(yArrays[0]!=xArrays[i]){
//                dpMatrix[0][i] = dpMatrix[0][i-1]
//            }
//            else{
//                dpMatrix[0][i] = xIndex;
//            }
//        }
//
//        for(int i=1;i<yArrays.length;i++){
//            if(yArrays[i]!=xArrays[0]){
//                yIndex++;
//                dpMatrix[i][0] = yIndex;
//            }else{
//                dpMatrix[i][0] = yIndex;
//            }
//        }


        for(int i=1;i<xArrays.length;i++){
            for(int j=1;j<yArrays.length;j++){
                if(yArrays[j]!=xArrays[i]){
                    dpMatrix[j][i] = min(dpMatrix[j-1][i]+1, dpMatrix[j-1][i-1]+1, dpMatrix[j][i-1]+1);
                }

                if(yArrays[j]==xArrays[i]){
                    dpMatrix[j][i] = min(dpMatrix[j-1][i], dpMatrix[j-1][i-1], dpMatrix[j][i-1]);
                }
            }
        }

        CommonUtil.printArray(dpMatrix);

        return dpMatrix[yArrays.length-1][xArrays.length-1];
    }

    public int min(int a, int b, int c){
        int c1= min(a, b);
        return min(c1, c);
    }

    public int min(int a, int b){
        if(a<=b){
            return a;
        }
        return b;
    }
}
