import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Traverse {
    public static void main(String[] args) {
        TreeNode root = initTree();
        System.out.println(preorder(root));
        System.out.println(inorder(root));
        System.out.println(postorderV1(root));
        System.out.println(postorderV2(root));
    }

    public static List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        while(!s.isEmpty() || root != null) {
            while(root != null) {
                res.add(root.val);
                s.push(root);
                root = root.left;
            }
            root = s.pop().right;
        }
        return res;
    }

    public static List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        while(!s.isEmpty() || root != null) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            TreeNode n = s.pop();
            res.add(n.val);
            root = n.right;
        }
        return res;
    }

    public static List<Integer> postorderV1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        while(!s.isEmpty() || root != null) {
            while(root != null) {
                res.add(0, root.val);
                s.push(root);
                root = root.right;
            }
            root = s.pop().left;
        }
        return res;
    }

    public static List<Integer> postorderV2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        LinkedList<TreeNode> s = new LinkedList<>();
        TreeNode pre = null;
        while(!s.isEmpty() || root != null) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            TreeNode n = s.peek();
            if(n.right == null || pre == n.right) {
                root = s.pop();
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                root = n.right;
            }
        }
        return res;
    }

    private static TreeNode initTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = new TreeNode(6);
        return n1;
    }
}