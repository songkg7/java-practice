package leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        return search(root, new ArrayList<>());
    }

    public List<Integer> search(TreeNode node, List<Integer> output) {
        if (node == null) {
            return output;
        }
        // 좌측 탐색
        search(node.left, output);
        // 좌측 탐색이 종료되면 부모 노드의 값을 넣는다
        output.add(node.val);
        // 우측 탐색
        search(node.right, output);
        return output;
    }
}
