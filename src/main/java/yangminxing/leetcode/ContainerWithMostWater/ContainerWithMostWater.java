package yangminxing.leetcode.ContainerWithMostWater;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int[] test= new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(test));
    }

    public int maxArea(int[] height) {
        if(height.length==0 || height.length==1){
            return 0;
        }
        return k(height, height.length);
    }

    public int k(int[] arrays, int length){
        int maxResult = 0;
        for(int row=0;row<length;row++){
            int offset =0;
            for(int col=row;col<length;col++){

                maxResult = max(maxResult,  offset * min(arrays[row], arrays[col]));

                offset++;
            }
        }
        return maxResult;
    }

    public int max(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }

    public int min(int a, int b){
        if(a<b){
            return a;
        }
        return b;
    }
}
