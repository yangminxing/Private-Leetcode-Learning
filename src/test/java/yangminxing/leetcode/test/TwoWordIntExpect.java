package yangminxing.leetcode.test;

import yangminxing.leetcode.EditDistance.EditDistance;

public class TwoWordIntExpect {

    public static void main(String[] args) {

    }

    public void testEditDistance(){
        EditDistance solve = new EditDistance();
        int result = solve.minDistance("", "");
        new TwoWordInTestCase("", "", 0);
    }

    public void test(TwoWordInTestCase caseObject){

    }
}

/**
 * Define test case
 */
class TwoWordInTestCase{
    private String word1;

    private String word2;

    private int expectWord;

    public TwoWordInTestCase(String word1, String word2, int expectWord) {
        this.word1 = word1;
        this.word2 = word2;
        this.expectWord = expectWord;
    }

    public String getWord1() {
        return word1;
    }

    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public String getWord2() {
        return word2;
    }

    public void setWord2(String word2) {
        this.word2 = word2;
    }

    public int getExpectWord() {
        return expectWord;
    }

    public void setExpectWord(int expectWord) {
        this.expectWord = expectWord;
    }
}
