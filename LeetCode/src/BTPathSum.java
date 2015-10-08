import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Rohith Vallu on 10/7/2015.
 */
public class BTPathSum {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

    }
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        current.add(root.val);

        dfsAppr(result,current,root,sum-root.val);
        return result;
    }

    public void dfsAppr(List<List<Integer>> result, List<Integer> current, TreeNode root,int sum){
        if(root.right == null && root.left ==null && sum==0){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.addAll(current);
            result.add(temp);
        }
        if(root.left!=null){
            current.add(root.left.val);
            dfsAppr(result,current,root.left,sum-root.left.val);
            current.remove(current.size()-1);
        }
        if(root.right!=null){
            current.add(root.right.val);
            dfsAppr(result,current,root.right,sum-root.right.val);
            current.remove(current.size()-1);
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        if(root.val == sum && (root.left == null && root.right == null))
            return true;
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }


    public static void main(String[] args) {
        BTPathSum myTree = new BTPathSum();
        myTree.root = myTree.new TreeNode(1);
        myTree.root.left = myTree.new TreeNode(2);
        myTree.root.right = myTree.new TreeNode(3);

        System.out.print(myTree.pathSum(myTree.root, 4));
    }
}
