public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode l, TreeNode r) {
        this.val = val;
        left = l;
        right = r;
    }
}