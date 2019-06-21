package yangminxing.leetcode.ZigZagConversion;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

    public static void main(String[] args) {
        ZigZagConversion conversion = new ZigZagConversion();
        System.out.println(conversion.convert("A", 1));

    }

    public String convert(String s, int numRows) {

        if(numRows==0||numRows==1){
            return s;
        }

        String result = "";
        Map<Integer, StringBuilder> sbMap = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            sbMap.put(i, new StringBuilder());
        }

        int offset = 0;
        while (true) {
            int move = (numRows-1)*2;
            int i = offset * move;
            int f = (offset + 1) * move;

            if(i>s.length()-1){
                break;
            }

            rep(sbMap, 0, i, f, s);
            offset++;
        }

        for(int i=0;i<numRows;i++){
            result += sbMap.get(i).toString();
        }
        return result;
    }

    public void rep(Map<Integer, StringBuilder> sbMap, int floor, int prev, int next, String s) {
        if (prev == next) {
            if (prev >= s.length()) {
                return;
            }

            sbMap.get(floor).append(s.charAt(prev));
            return;
        }
        if(prev<s.length()) {
            sbMap.get(floor).append(s.charAt(prev));
        }
        if (next<s.length() && floor != 0) {
            sbMap.get(floor).append(s.charAt(next));
        }
        rep(sbMap, floor + 1, prev + 1, next - 1, s);
    }
}
