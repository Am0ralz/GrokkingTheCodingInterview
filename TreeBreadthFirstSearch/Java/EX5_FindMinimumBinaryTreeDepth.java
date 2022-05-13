package TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
//Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the shortest path
// from the root node to the nearest leaf node.
public class EX5_FindMinimumBinaryTreeDepth {

    /*Algorithms
    1. check if root is null
    2. add root to queue
    3. add 1 lvl
    4. while queue is not empty
        4a.go through queue add children
        4b. if not children stop
     5. return lvl
     */
    public static int findDepth( TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int lvl = 0;

        while(!queue.isEmpty()){
            lvl++;
           int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {

                    return lvl;
                }
                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }

            }
        }
        return lvl;

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
    }
}
