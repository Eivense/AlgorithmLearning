package leetcode.leetcode1028;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1028. 从先序遍历还原二叉树
 * <p>
 * 我们从二叉树的根节点 root 开始进行深度优先搜索。
 * <p>
 * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。（如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
 * <p>
 * 如果节点只有一个子节点，那么保证该子节点为左子节点。
 * <p>
 * 给出遍历输出 S，还原树并返回其根节点 root。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3--4-5--6--7"
 * 输出：[1,2,5,3,4,6,7]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入："1-2--3---4-5--6---7"
 * 输出：[1,2,5,3,null,6,null,4,null,7]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入："1-401--349---90--88"
 * 输出：[1,401,null,349,88,90]
 *  
 * <p>
 * 提示：
 * <p>
 * 原始树中的节点数介于 1 和 1000 之间。
 * 每个节点的值介于 1 和 10 ^ 9 之间。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

//    迭代版本
//
//    public TreeNode recoverFromPreorder(String S) {
//        if (S == null) {
//            return null;
//        }
//
//        int n = S.length();
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        // 当前处理到字符的位置
//        int i = 0;
//        // 层数
//        while (i < n) {
//            int deep = 0;
//            while (i<n&&S.charAt(i) == '-') {
//                i++;
//                deep++;
//            }
//            int val = 0;
//            while (i<n&&S.charAt(i) != '-') {
//                val = val * 10 + Integer.valueOf(S.charAt(i)-'0');
//                i++;
//            }
//            i--;
//            // 构建当前节点
//            TreeNode node = new TreeNode(val);
//            // 为空即node为root
//            if (stack.isEmpty()) {
//                stack.push(node);
//
//            }else{
//                // 若当前节点深度小于栈的大小
//                while (deep <stack.size()) {
//                    stack.pop();
//                }
//                TreeNode parent = stack.peek();
//                if (parent.left == null) {
//                    parent.left = node;
//                } else {
//                    parent.right = node;
//                }
//                stack.push(node);
//            }
//            i++;
//        }
//        return stack.pop();
//    }


    int i=0;
    public TreeNode recoverFromPreorder(String s) {
        return buildTree(s, 0);
    }

    public TreeNode buildTree(String s, int level) {
        int deep=0;
        while (i < s.length() && s.charAt(i) == '-') {
            i++;
            deep++;
        }
        if (deep < level) {
            i -= deep;
            return null;
        }
        int val=0;
        while (i < s.length() && s.charAt(i) != '-') {
            val = val * 10 + Integer.valueOf(s.charAt(i)-'0');
            i++;
        }
        TreeNode node = new TreeNode(val);
        node.left = buildTree(s, deep + 1);
        node.right = buildTree(s, deep + 1);

        return node;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.recoverFromPreorder("1-2--3--4-5--6--7");
    }

}
