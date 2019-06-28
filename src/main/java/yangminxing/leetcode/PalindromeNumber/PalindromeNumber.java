package yangminxing.leetcode.PalindromeNumber;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(1551));
    }

    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp = x;

        long rev = 0;
        while(x!=0){
            rev = rev*10 + x%10;
            x = x/10;
        }
        if(rev == Long.valueOf(temp)){
            return true;
        }
        return false;
    }
}
