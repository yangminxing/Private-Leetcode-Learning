package yangminxing.leetcode.IntegerToRoman;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {

    public static void main(String[] args) {
        IntegerToRoman sol = new IntegerToRoman();
        System.out.println(sol.intToRoman(1994));
    }

    public String intToRoman(int num) {
        String result = "";
        int[] stand = new int[]{1000, 500, 100, 50, 10 , 5, 1};
        Map<Integer, String> standMap = new HashMap<>();
        standMap.put(1000, "M");
        standMap.put(500, "D");
        standMap.put(100, "C");
        standMap.put(50, "L");
        standMap.put(10, "X");
        standMap.put(5, "V");
        standMap.put(1, "I");

        for(int i=0;i<stand.length;i++){
            int count = num / stand[i];
            if(count==0){
                continue;
            }
            num = num - count * stand[i];
            while(count>0){
                String alpha = standMap.get(stand[i]);
                result = result + alpha;
                count--;
            }
        }

        result = result.replace("DCCCC","CM");
        result = result.replace("CCCC","CD");
        result = result.replace("LXXXX","XC");
        result = result.replace("XXXX","XL");
        result = result.replace("VIIII","IX");
        result = result.replace("IIII","IV");
        return result;
    }
}
