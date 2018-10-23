public class lee105_ConstBiTree_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归构建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return preInBiTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode preInBiTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart | inEnd < inStart) return null;
        TreeNode treeNode = new TreeNode(preorder[preStart]);
        int split = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) split = i;
        }
        treeNode.left = preInBiTree(preorder, preStart + 1, preStart - inStart + split, inorder, inStart, split - 1);
        treeNode.right = preInBiTree(preorder, preEnd - inEnd + split + 1, preEnd, inorder, split + 1, inEnd);
        return treeNode;
    }
}
