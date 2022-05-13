package TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

public class EX6_FindLvlOrderSuccessor {
//    Given a binary tree and a node, find the level order successor of the given node in the tree. The level order
//    successor is the node that appears right after the given node in the level order traversal.
    /* Algorithm
    1.add root to queue
    2.take node form queue
    3. add children to queue
    4. check curr node to given node
    5. if equals then return next node
    6. else continue
     */
    public static TreeNode findLvlOrderSuccessor(TreeNode root, int given){
        if (root == null){
            return null;
        }

        Queue<TreeNode> queue =new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if (curr.right != null){
                    queue.offer(curr.right);
                }
                if (curr.val == given){
                    return queue.poll();
                }

            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode result = findLvlOrderSuccessor(root, 3);
        if (result != null)
            System.out.println(result.val + " ");

        root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        result = findLvlOrderSuccessor(root, 9);
        if (result != null)
            System.out.println(result.val + " ");

        result = findLvlOrderSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
    }

}
