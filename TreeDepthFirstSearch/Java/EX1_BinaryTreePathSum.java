package TreeDepthFirstSearch;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
};
public class EX1_BinaryTreePathSum {
    // we check if node is null if it we return null. this will be sa stopping point
    //then we check to see if sum = root.val and its a leaf that mean the route meets the sum
    //we subtract the sum with the value as we pass each node
    public static boolean hasPath(TreeNode root, int sum) {
        //either the root node is null or we passed a leaf or end of the route
        if(root == null){
            return false;
        }
        // we are checking is sum is equal to the root val if it means the val-sum == 0 and we also check to see if the
        // node is a leaf
        if(sum == root.val && root.right == null && root.left == null){
            return true;
        }
        // we are checking if any of the route is has total equaling the sum if it does then it returns true to the top
        // of the tree
        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum -root.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + hasPath(root, 23));
        System.out.println("Tree has path: " + hasPath(root, 16));
    }
}
