package TreeDepthFirstSearch;

public class EX6_TreeDiameter {
    private static int treeDiameter = 0;
    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }
    private static int calculateHeight(TreeNode currentNode) {
        // returns 0 if we reahc the end of the node
        if (currentNode == null){
            return 0;
        }
        //gets the height of the left and right of the tree
        int leftHeight = calculateHeight(currentNode.left);
        int rightHeight = calculateHeight(currentNode.right);

        //to caculate the diameter we need a left and right branch
        if (leftHeight != 0 && rightHeight != 0) {

            int diameter = leftHeight + rightHeight + 1;

            treeDiameter = Math.max(treeDiameter, diameter);
        }
        return Math.max(leftHeight, rightHeight) +1;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + findDiameter(root));
    }
}
