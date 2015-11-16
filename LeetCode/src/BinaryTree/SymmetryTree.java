package BinaryTree;

/**
 * Created by Rohith Vallu on 11/15/2015.
 */
public class SymmetryTree {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (r == null || l == null) {
            return false;
        }

        if (l.val != r.val)
            return false;

        if (!isSymmetric(l.left, r.right))
            return false;
        if (!isSymmetric(l.right, r.left))
            return false;

        return true;
    }

    public static void main(String[] args) {
        SymmetryTree myTree = new SymmetryTree();
        myTree.root = myTree.new TreeNode(1);
        myTree.root.left = myTree.new TreeNode(2);
        myTree.root.right = myTree.new TreeNode(2);

        System.out.print(myTree.isSymmetric(myTree.root));
    }
}
