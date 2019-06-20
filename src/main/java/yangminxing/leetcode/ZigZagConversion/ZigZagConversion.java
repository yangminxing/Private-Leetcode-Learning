package yangminxing.leetcode.ZigZagConversion;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {
    public String convert(String s, int numRows) {

        String result = "";
        Map<Integer, StringBuilder> sbMap = new HashMap<>();
        for(int i=0;i<numRows;i++){
            sbMap.put(i, new StringBuilder());
        }
        
        int offset =0;
        while(true){
            int i = offset*numRows;
            int f = (offset+1)*numRows;
            rep(sbMap, 0, i, f, s);
            offset++;
        }
    }

    public void rep(Map<Integer, StringBuilder> sbMap, int floor, int prev, int next, String s) {
        if(next>=s.length()){
           return;
        }
        if(prev == next){
            if(prev>=s.length()){
           return;
        }
            sbMap.get(floor).append(s.charAt(prev));
            return;
        }
        if(next>=s.length()){
           return;
        }
        sbMap.get(floor).append(s.charAt(prev));
        if(floor!=0) {
            sbMap.get(floor).append(s.charAt(next));
        }
        rep(sbMap, floor+1, prev+1, next-1, s);
    }
}
