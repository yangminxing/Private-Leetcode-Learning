package yangminxing.leetcode.UncrossedLines;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = new int[]{2, 5, 1, 2, 5};
        int[] b = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(solution.max(solution.move(a, b), solution.move(b, a)));
    }


    public int move(int[] f, int[] b){
        int maxOffset = f.length;
        for(int i=0;i<maxOffset;i++){

            int coincideIndex = checkCoincide(f, b, i);

            // find coincide num
            if(coincideIndex != -1){
                int[] newF = cutArray(f, coincideIndex +1);
                int[] newB = cutArray(b, coincideIndex + 1);
                if(newF.length==0 || newB.length==0){
                    return 0;
                }

                return move(newF, newB) + 1;
            }
        }
        return 0;
    }

    /**
     * find the index for coincide between two array after b array offset moved.
     *
     * if could not find a index return -1
     */
    public int checkCoincide(int[] f, int[] b, int offset){

        for(int i=offset;i<f.length;i++){
            int bCur =0;
            for(int j=i;j<f.length;j++){
                if(f[i]==b[bCur]){
                    return j;
                }
                bCur++;
            }
        }
        return  -1;
    }

    /**
     *
     */
    public int[] cutArray(int[] array, int cutIndex){
        if(array.length<cutIndex){
            return new int[]{};
        }

        int[] result = new int[array.length - cutIndex];
        int resultCur=0;
        for(int i=cutIndex;i<array.length;i++){
            result[resultCur] = array[i];
            resultCur++;
        }
        return result;
    }

    public int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}
