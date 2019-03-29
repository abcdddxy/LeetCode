public class offer57_SerializeAndDeserialize {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    private StringBuilder sb = new StringBuilder();
    private int idx = -1;

    public String Serialize(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        else sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        idx++;
        String[] strs = str.split(",");
        if (strs[idx].equals("#")) return null;
        TreeNode ans = new TreeNode(Integer.valueOf(strs[idx]));
        ans.left = Deserialize(str);
        ans.right = Deserialize(str);
        return ans;
    }
}
