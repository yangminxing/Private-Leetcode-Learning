package yangminxing.leetcode.EditDistance;

import yangminxing.leetcode.util.CommonUtil;

public class EditDistance {

    public static void main(String[] args) {

        EditDistance solution = new EditDistance();
        String a = "loolo" ;
        String b = "ros";

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

        int xIndex =1;
        boolean findFlag = false;
        for(int i=0;i<xArrays.length;i++){
            if(!findFlag & yArrays[0]==xArrays[i]) {
                xIndex--;
                findFlag = true;
            }
            dpMatrix[0][i] = xIndex;
            xIndex++;
        }

        findFlag = false;
        int yIndex =1;
        for(int i=0;i<yArrays.length;i++){
            if(!findFlag & yArrays[i]==xArrays[0]) {
                yIndex--;
                findFlag = true;
            }
            dpMatrix[i][0] = yIndex;
            yIndex++;
        }


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
