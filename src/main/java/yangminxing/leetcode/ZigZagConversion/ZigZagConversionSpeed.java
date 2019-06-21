package yangminxing.leetcode.ZigZagConversion;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversionSpeed {

    public static void main(String[] args) {
        ZigZagConversionSpeed speend =new ZigZagConversionSpeed();
        System.out.println(speend.convert("A", 3));
    }

    public String convert(String s, int numRows) {

        if(numRows<=1){
            return s;
        }

        Map<Integer, StringBuilder> map = new HashMap<>();
        for(int i=0;i<numRows;i++){
            map.put(i, new StringBuilder());
        }

        int loop = (numRows-1)*2;
        for(int i=0;i<s.length();i++){
            int a= i%loop;
            if(a>=numRows){
                a=numRows - (a%(numRows -1 )) -1;
            }
            map.get(a).append(s.charAt(i));
        }

        String result = "";
        for(int i=0;i<numRows;i++){
            result += map.get(i).toString();
        }
        return result;
    }
}
