package yangminxing.leetcode.LongestSubstringWithoutRepeatingCharacters;

import yangminxing.leetcode.util.CommonUtil;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();

        String testCase = "dvdf";

        System.out.println(s.dp(testCase.toCharArray(), testCase.length()));
    }

    public int lengthOfLongestSubstring(String s) {
        return dp(s.toCharArray(), s.length());
    }

    public int dp(char[] strArrays, int length){
        int[] dp = new int[length];
        Set<Character> repeatSet = new HashSet<>();
        for(int i=0;i<length;i++){
            Character currentChar = strArrays[i];
            if(!repeatSet.contains(currentChar)){
                if(i==0){
                    dp[i]=1;
                }else{
                    dp[i]=dp[i-1]+1;
                }
                repeatSet.add(currentChar);
            }else{
                dp[i]=1;
                repeatSet.clear();
                repeatSet.add(currentChar);
            }
        }

        CommonUtil.printArray(dp);

        int max = 0;
        for(int i=0;i<length;i++){
            if(i==0){
                max =1;
            }else{
                max = max(max,dp[i]);
            }
        }
        return max;
    }

    public int max(int a, int b){
        if(a<b){
            return b;
        }
        return a;
    }
}
