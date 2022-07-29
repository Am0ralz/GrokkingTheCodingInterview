package TreeDepthFirstSearch;
//Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
//        Find the total sum of all the numbers represented by all paths.

public class EX3_SumPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {
        //returns the sum
        return sumOfPath( root, 0);
    }

    public static int sumOfPath( TreeNode curr, int sum){
        //if the root is null then return 0
        if (curr == null){
            return 0;
        }
        // Move the last to the right and multiply by 10 and then add the sum
        sum = sum * 10 + curr.val;
        // return the number from the path
        if(curr.left == null && curr.right == null){
            return sum;
        }
        //add the number from both sides to each other
        return sumOfPath(curr.right, sum) + sumOfPath(curr.left, sum);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " +
               findSumOfPathNumbers(root));
    }
}
