package leetcode.leetcode863;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * @author Eivense
 * @date 2021/7/28 10:32 下午
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


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Set<Integer> result = new HashSet<>();
        if (k == 0) {
            result.add(target.val);
        }else{
            // true为右
            boolean flag=findNode(root.right, target);
            // 往下寻找
            dfs(target,target,k, result);
            // 根到target的距离
            int distance = depth(root, target, 0);
            // 往上寻找
            k = k - distance;
            if (k == 0) {
                result.add(root.val);
            }
            // 在root的另一边
            else if (k >0) {
                if (flag) {
                    dfs(root.left,target,k-1, result);
                }else{
                    dfs(root.right,target,k-1,result);

                }
            }
            // 在root的同一边
            else{
                k = Math.abs(k);
                if(flag){
                    dfs(root.right, target, k - 1, result);
                }else{
                    dfs(root.left, target, k - 1, result);
                }
            }
        }
        return new ArrayList<>(result);
    }

    public boolean findNode(TreeNode root, TreeNode target) {
        if (root == null) {
            return false;
        }
        if (root == target) {
            return true;
        }
        return findNode(root.left, target)||findNode(root.right,target);
    }
    // 往下
    public int depth(TreeNode node, TreeNode target,int value) {
        if (node == target) {
            return value;
        } else if (node == null) {
            return 0;
        } else {
            int left = depth(node.left, target, value + 1);
            int right = depth(node.right, target, value + 1);
            return left == 0 ? right : left;
        }
    }

    public void dfs(TreeNode node,TreeNode target, int k, Set<Integer> result) {
        if (node == null) {
            return;
        }
        if (k == 0&&node!=target) {
            result.add(node.val);
            return;
        }
        k = k - 1;
        dfs(node.left,target, k, result);
        dfs(node.right, target,k, result);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode.left = treeNode2;
        treeNode.right=treeNode1;
        treeNode1.left=treeNode3;


        Solution solution = new Solution();
        solution.distanceK(treeNode, treeNode3, 3);
    }
}
