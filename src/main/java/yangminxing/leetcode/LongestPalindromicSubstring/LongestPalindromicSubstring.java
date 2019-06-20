package yangminxing.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome("abac"));
    }

    public String longestPalindrome(String str) {
        String longStrResult = "";

        for (int i = 0; i < str.length(); i++) {
            longStrResult = max(
                    longStrResult,
                    once(i, i, str),
                    once(i,i + 1, str));
        }
        return longStrResult;
    }

    public String once(int prevIndex, int nextIndex, String str) {
        String longStrResult="";
        while (prevIndex >= 0 && nextIndex < str.length()) {

            if (str.charAt(prevIndex) == str.charAt(nextIndex)) {
                if (nextIndex - prevIndex >= longStrResult.length()) {
                    longStrResult = str.substring(prevIndex, nextIndex + 1);
                }
                prevIndex--;
                nextIndex++;
            } else {
                break;
            }
        }
        return longStrResult;
    }

    public String max(String str1, String str2, String str3) {
        String a=max(str1, str2);
        return max(a, str3);
    }

    public String max(String str1, String str2){
        if(str1.length()>str2.length()){
            return str1;
        }
        return str2;
    }
}

