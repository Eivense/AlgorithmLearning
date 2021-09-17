package leetcode.leetcode348;

/**
 *
 * 348. 设计井字棋
 * https://leetcode-cn.com/problems/design-tic-tac-toe/
 *
 * @author Eivense
 * @date 2021/9/11 2:07 下午
 */
public class TicTacToe {

    private int n;
    // 行
    private int[][] rows;
    // 列
    private int[][] cols;
    // 对角线
    private int[][] diagonals;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n][3];
        cols = new int[n][3];
        diagonals = new int[2][3];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // 行
        if (++rows[row][player] == n) {
            return player;
        }

        // 列
        if (++cols[col][player] == n) {
            return player;
        }

        // 对角线 左上到右下
        if (row == col && ++diagonals[0][player] == n) {
            return player;
        }

        // 对角线 右上到左下
        if (row + col == n - 1 && ++diagonals[1][player] == n) {
            return player;
        }
        return 0;
    }


}
