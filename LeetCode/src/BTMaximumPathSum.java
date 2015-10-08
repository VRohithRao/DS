/**
 * Created by Rohith Vallu on 10/7/2015.
 */
public class BTMaximumPathSum {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }

    }
//    public int maxPathSum(TreeNode root) {
//        int total = 0;
//        if(root != null)
//           total = root.val;
//
//        if(root.left !=null)
//        {
//            int leftTotal = maxPathSum(root.left);
//            if(leftTotal < 0)
//                total = Math.max(root.left.val,total);
//            else
//                total = Math.max(root.left.val,Math.max(leftTotal + total,leftTotal));
//        }
//        if(root.right !=null)
//        {
//            int rightTotal = maxPathSum(root.right);
//            if(rightTotal < 0)
//                total = Math.max(root.right.val,total);
//            else
//                total = Math.max(root.right.val,Math.max(rightTotal + total,rightTotal));
//        }
//        return total;
//    }
    public int maxPathSum(TreeNode root) {
        int [] max = {Integer.MIN_VALUE};         // because in Java is pass by value so the use of an array of pass!
        computeMaxPath(root, max);
        return  max[0];
    }

    public int computeMaxPath(TreeNode root,int[] max){
        if (root ==  null ) {
            return  0 ;
        }

        int  leftSubtreeMaxSum = computeMaxPath(root.left, max);         // left subtree of the largest and
        int  rightSubtreeMaxSum = computeMaxPath(root.right, max);       // right subtree of the largest and
        int  arch = leftSubtreeMaxSum + root.val + rightSubtreeMaxSum;        // left subtree of the largest and through root to the right subtree

        // Represents the maximum can go and this value by the root of the root node as a parent to return the object back to the calling parent function
        // Only in the case of 3: 1 to the left sub-tree root and then parent
        // 2 the right to sub-tree root and then parent
        // 3 from the root to the parent directly
        // Note that it is impossible to walk that road arch parent, because the road has been root, unless fold repetition go back! But this is not allowed
        int  maxPathAcrossRootToParent = Math.max(root.val, Math.max(leftSubtreeMaxSum, rightSubtreeMaxSum) + root.val);

        // max [0] is stored in all the recursive process, then also consider arch Probable Maximum
        max[0] = Math.max(max[0], Math.max(arch, maxPathAcrossRootToParent));

        return  maxPathAcrossRootToParent;
    }

    public static void main(String[] args) {
        BTMaximumPathSum myTree = new BTMaximumPathSum();
        myTree.root = myTree.new TreeNode(2);
        myTree.root.left = myTree.new TreeNode(-1);
//        myTree.root.right = myTree.new TreeNode(3);

//        myTree.root.left.left = myTree.new TreeNode(3);
//        myTree.root.left.left.left = myTree.new TreeNode(4);
//        myTree.root.left.left.left.left = myTree.new TreeNode(5);

//        myTree.root.left.left = myTree.new TreeNode(20);
         System.out.print(myTree.maxPathSum(myTree.root));
    }
}
