package TreeBreadthFirstSearch;

import java.util.*;
//Given a binary tree, populate an array to represent the averages of all of its levels.
public class EX4_FindLevelAverages {
    /*Algorithm
    1. add root node to queue
    2. while queue is not empty
    3. for size of que
      3a. poll next item in quen
      3b. add val to sum
      3c. add left and right to queue
     4. add sum to results
     5. return results when queue is empty
     */

    public static List<Double> findLevelAverages(TreeNode root){
        List<Double> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double sum;
        int size;
        while(!queue.isEmpty()){
          sum = 0;
          size = queue.size();
            for (int i = 0; i < size ; i++) {
                TreeNode curr = queue.poll();
                sum += curr.val;
                if (curr.right != null){
                    queue.offer(curr.right);
                }
                if (curr.left != null){
                    queue.offer(curr.left);
                }
            }
            results.add(sum/size);
        }
        return results;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
