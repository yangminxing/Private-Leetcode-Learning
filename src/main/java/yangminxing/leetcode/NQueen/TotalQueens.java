package yangminxing.leetcode.NQueen;

public class TotalQueens {

    public int totalNQueens(int n) {
        SQUARE_LENGTH = n;
        findRowQueen(new int[n][n], 0);
        return resultCount;
    }

    public int SQUARE_LENGTH = 0;

    /**
     * Record the final answer
     */
    public int resultCount = 0;

    /**
     * Define a temp cursor for recording current row index.
     */
    public int rowCursor = 0;

    /**
     * Recursive finding queen in a row
     * <p>
     * return 1  exist a good position for queen in this row
     * 0  no suitable position in this row
     * -1 Happy Ending for finding a solution
     */
    public int findRowQueen(int[][] oriArrays, int row) {
        // check Happy Ending
        if (!checkSpareRowEnd()) {

            // then back row index
            moveBackRow(oriArrays, row);
            resultCount++;
            return -1;
        }

        boolean sameRowFindFlag = false;
        for (int i = 0; i < SQUARE_LENGTH; i++) {
            // check same row situation
            if (checkPos(oriArrays, row, i)) {
                // place a queen
                oriArrays[row][i] = 1;

                // move row index forward
                moveNextRow();
                int findResult = findRowQueen(oriArrays, retireveCurrentRowCur());

                // if the next row has no suitable position, then we must need clear current row queen place.
                if (findResult == 0) {
                    oriArrays[row][i] = 0;
                    continue;
                }

                // if the next row has found a solution. continue finding.
                if (findResult == -1) {
                    continue;
                }
                sameRowFindFlag = true;
            }
        }

        if (!sameRowFindFlag) {
            moveBackRow(oriArrays, row);
            return 0;
        }

        moveBackRow(oriArrays, row);
        return 1;
    }

    /**
     * Check current position is suitable for a queen.
     */
    public boolean checkPos(int[][] oriArrays, int curRow, int curCol) {
        int leftUpCol = curCol - 1;
        int rightUpCol = curCol + 1;

        for (int i = 0; i < SQUARE_LENGTH; i++) {
            if (i == curCol) {
                continue;
            }
            if (oriArrays[curRow][i] == 1) {
                return false;
            }
        }

        for (int i = curRow - 1; i >= 0; i--) {

            if (leftUpCol >= 0 && leftUpCol < SQUARE_LENGTH) {
                if (oriArrays[i][leftUpCol] == 1) {
                    return false;
                }
            }

            if (rightUpCol >= 0 && rightUpCol < SQUARE_LENGTH) {
                if (oriArrays[i][rightUpCol] == 1) {
                    return false;
                }
            }

            if (oriArrays[i][curCol] == 1) {
                return false;
            }

            leftUpCol--;
            rightUpCol++;
        }
        return true;
    }

    /**
     * Retrieve current row cursor
     */
    public int retireveCurrentRowCur() {
        return rowCursor;
    }

    /**
     * Move row index forward
     */
    public void moveNextRow() {
        rowCursor++;
    }

    /**
     * Move row index back, then clear the row queen suitable places.
     */
    public void moveBackRow(int[][] oriArrays, int clearRow) {
        // clear other queen
        if (clearRow < SQUARE_LENGTH) {
            for (int i = 0; i < oriArrays[clearRow].length; i++) {
                oriArrays[clearRow][i] = 0;
            }
        }

        rowCursor--;
    }

    /**
     * Current row index is equal to SQUARE_LENGTH, it means we find a solution.
     */
    public boolean checkSpareRowEnd() {
        if (rowCursor >= SQUARE_LENGTH) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TotalQueens totalQueens = new TotalQueens();
        int r = totalQueens.totalNQueens(11);
        System.out.println(r);
    }
}
