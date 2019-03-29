public class offer4_ReConstructBT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int len = pre.length;
        if (len == 0) return null;
        int root = pre[0];
        int p = 0;
        for (int i = 0; i < len; i++) {
            if (in[i] == root) {
                p = i;
                break;
            }
        }
        TreeNode ans = new TreeNode(root);
        ans.left = reConstructBinaryTree(cutList(pre, 1, p), cutList(in, 0, p - 1));
        ans.right = reConstructBinaryTree(cutList(pre, p + 1, len - 1), cutList(in, p + 1, len - 1));
        return ans;
    }

    private int[] cutList(int[] list, int start, int end) {
        System.out.println(start + ' ' + end);
        int[] tmp = new int[end - start + 1];
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (i >= start && i <= end) {
                tmp[count] = list[i];
                count++;
            }
        }
        return tmp;
    }
}
