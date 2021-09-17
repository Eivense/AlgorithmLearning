package leetcode.leetcode79;

/**
 * 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 *
 * @author Eivense
 * @date 2021/9/11 1:28 下午
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = dfs(0, word, board, i, j, new boolean[board.length][board[0].length]);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, String word, char[][] board,int x,int y,boolean[][] b) {
        // 超出边界 直接结束
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        char c = word.charAt(i);
        // 该节点还没被使用
        if (!b[x][y]) {
            // 当前字符匹配则搜索下一个字符
            if (board[x][y] == c) {
                // 标记该位置已经被使用了
                b[x][y] = true;
                // 如果已经匹配道路字符串的最后则 存在
                if (i == word.length() - 1) {
                    return true;
                }
                // 往上
                boolean temp= dfs(i+1,word,board,x-1,y,b)||
                // 往下
                dfs(i+1,word,board,x+1,y,b)||
                // 往左
                dfs(i+1,word,board,x,y-1,b)||
                // 往右
                dfs(i+1,word,board,x,y+1,b);

                if (temp) {
                    return true;
                }else{
                    b[x][y]=false;
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS");
    }
}
