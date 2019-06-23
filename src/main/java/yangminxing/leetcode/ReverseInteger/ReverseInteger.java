package yangminxing.leetcode.ReverseInteger;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483643));
    }

    public int reverse(int x) {
        String t = String.valueOf(x);
        String result = "";
        boolean negetiveFlag =false;
        for(int i=t.length()-1;i>=0;i--){
            if(t.charAt(i)=='-'){
                negetiveFlag = true;
                continue;
            }
            result +=t.charAt(i);
        }

        Double bigNum = Double.valueOf(result);
        if(bigNum<-2147483648.0 || bigNum> 2147483647.0){
            return 0;
        }

        return Integer.valueOf(negetiveFlag?"-"+result:result);
    }

}
