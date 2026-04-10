package 平衡二叉树.solve;


class TreeNode{

    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(){

    }
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val,TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solve{
    public static boolean solve(TreeNode root){
        if(root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left - right > 1 || left - right < -1){
            return false;
        }
        return solve(root.left) && solve(root.right);
    }
    public static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return Math.max(left, right) + 1;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(8);
//        root.right.right.left.left = new TreeNode(8);
        boolean result = solve(root);
        System.out.println(result);
    }
}
