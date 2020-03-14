package leetcode.leetcode230;


/**
 * 230. 二叉搜索树中第K小的元素
 *
 *给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 *
 *
 *
 *
 *
 *
 * 二叉排序树的中序是升序
 *
 *
 * 两种解法
 * 1.中序遍历遍历到第k个节点返回
 * 2.计算节点左子树的节点个数，小于k-1说明在节点的右子树，等于k-1说明当前节点就是第k个，如果大于k-1所有在节点的左子树
 *
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

// 中序遍历
//
//    private int k;
//    private int result;
//
//    public int kthSmallest(TreeNode root, int k) {
//        this.k=k;
//        dfs(root);
//        return result;
//    }
//
//    public void dfs(TreeNode root){
//        if(root==null){
//            return ;
//        }
//        dfs(root.left);
//        k--;
//        if(k==0){
//            result = root.val;
//        }
//        dfs(root.right);
//    }


    // 统计左子树节点个数

    public int kthSmallest(TreeNode root, int k) {
        int left = countNode(root.left);
        if(left+1==k){
            return root.val;
        }
        // 在右子树
        else if(left+1<k){
            return kthSmallest(root.right, k - left - 1);
        }
        // 在左子树
        else{
            return kthSmallest(root.left, k);
        }
    }

    public int countNode(TreeNode root){
        if(root==null){
            return 0;
        }
        return countNode(root.left) + countNode(root.right)+1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(6);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(1);
        root.left=a;
        root.right=b;
        a.left=c;
        a.right=d;
        c.left=e;

        Solution solution = new Solution();
        solution.kthSmallest(root,3);
    }
}
