package leetcodehot100_0309.第39题对称二叉树;

import java.util.Collections;
import java.util.List;

public class Solve {
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }
    public static boolean helper(TreeNode left, TreeNode right){
      if(left == null && right != null) return false;
      if(left != null && right == null) return false;
      if(left == null && right == null) return true;
      return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
    public static void main(String[] args) {

    }
}
