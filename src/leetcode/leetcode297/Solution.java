package leetcode.leetcode297;

import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author Eivense
 * @date 2021/8/30 9:52 下午
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.add("null");
                }else{
                    result.add(String.valueOf(node.val));
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        // 去除末尾的null
        for (int i = result.size() - 1; i >= 0; i--) {
            if (result.get(i).equals("null")) {
                result.remove(i);
            }else{
                break;
            }
        }
        return result.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String temp = data.replace("[", "");
        String temp1 = temp.replace("]", "");
        if (temp1.equals("")) {
            return null;
        }
        String[] strings=temp1.split(",");
        return deserializeTree(strings);
    }

    public TreeNode deserializeTree(String[] strings) {
        if (strings.length == 0) {
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(strings[index++].trim()));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 节点数量 包括null
        int nodeNum = strings.length;
        while (!queue.isEmpty()) {
            // 每一层节点数量
            int size = queue.size();
            while (size-- > 0) {
                if (index == nodeNum) {
                    queue.clear();
                    break;
                }
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                node.left = strings[index].equals("null") ? null : new TreeNode(Integer.parseInt(strings[index]));
                index++;
                queue.add(node.left);
                if (index == nodeNum) {
                    queue.clear();
                    break;
                }
                node.right = strings[index].equals("null") ? null : new TreeNode(Integer.parseInt(strings[index]));
                index++;
                queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();


        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right = node4;

        System.out.println(solution.serialize(root));
        TreeNode root1 = solution.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(root1);

    }
}
