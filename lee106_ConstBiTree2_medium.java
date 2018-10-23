public class lee106_ConstBiTree2_medium {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归构建二叉树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return inPosBiTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode inPosBiTree(int[] inorder, int inStart, int inEnd, int[] postorder, int posStart, int posEnd) {
        if (posEnd < posStart | inEnd < inStart) return null;
        TreeNode treeNode = new TreeNode(postorder[posEnd]);
        int split = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == postorder[posEnd]) split = i;
        }
        treeNode.left = inPosBiTree(inorder, inStart, split - 1, postorder, posStart, posStart + split - 1 - inStart);
        treeNode.right = inPosBiTree(inorder, split + 1, inEnd, postorder, posStart + split - inStart, posEnd - 1);
        return treeNode;
    }
}
