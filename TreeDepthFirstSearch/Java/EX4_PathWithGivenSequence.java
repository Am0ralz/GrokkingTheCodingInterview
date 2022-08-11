package TreeDepthFirstSearch;

public class EX4_PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
        //return true only if the sequence and tree are empty
        if (root == null)
            return sequence.length == 0;
        // return true if the sequence was found in the tree
        return findPathRecursive(root, sequence, 0);
    }

    public static boolean findPathRecursive(TreeNode root, int[] sequence, int index){
        if (root == null){
            return false;
        }
        // return false if the value of the node doesnt match the sequence
        if (root.val != sequence[index]){
            return false;
        }
        // return true if reach a leaf node and the end of the sequence
        if(root.left == null && root.right == null && sequence.length -1 == index){
            return true;
        }
        // check to see if one of the branches is true
        return findPathRecursive(root.left, sequence, index + 1) ||  findPathRecursive(root.right, sequence, index + 1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " +
                findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " +
                findPath(root, new int[] { 1, 1, 6 }));
    }
}
