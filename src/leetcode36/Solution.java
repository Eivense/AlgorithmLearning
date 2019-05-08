package leetcode36;

/**
 * 36. Valid Sudoku
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 *
 * Example 1:
 *
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 *
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row[][]=new int[9][9];
        int col[][]=new int[9][9];
        int box[][]=new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int num=board[i][j]-'0'-1;
                    int k = i / 3 * 3 + j / 3;
                    if(row[i][num]==1||col[j][num]==1||box[k][num]==1){
                        return false;
                    }else{
                        row[i][num]=1;
                        col[j][num]=1;
                        box[k][num]=1;
                    }

                }
            }
        }

        return true;
    }
}
