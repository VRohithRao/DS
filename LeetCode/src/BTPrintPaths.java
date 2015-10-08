import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rohith Vallu on 10/8/2015.
 */
public class BTPrintPaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

    }
    TreeNode root;
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if(root == null){
            return ret;
        }
        dfs(root, new StringBuilder(), ret);
        return ret;
    }

    public void dfs(TreeNode root, StringBuilder sb, List<String> ret){
        if(root.left == null && root.right == null){
            sb.append(root.val);
            ret.add(sb.toString());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        if(root.left != null){
            dfs(root.left, new StringBuilder(sb), ret);
        }
        if(root.right != null){
            dfs(root.right, new StringBuilder(sb), ret);
        }
    }

    public static void main(String[] args) {
        BTPrintPaths myTree = new BTPrintPaths();
        myTree.root = myTree.new TreeNode(1);
        myTree.root.left = myTree.new TreeNode(2);
        myTree.root.left.left = myTree.new TreeNode(3);

        System.out.print(myTree.binaryTreePaths(myTree.root));
    }
}
