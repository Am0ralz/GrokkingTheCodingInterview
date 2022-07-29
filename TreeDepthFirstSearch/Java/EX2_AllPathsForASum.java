package TreeDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

//Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of
// each path equals ‘S’.
public class EX2_AllPathsForASum {
    // we create one array to hold the path that equal the sum
    //we creat another array to hold the current path
    //we run recursive function that will add the arrays in to all paths
    // then we return all paths

    public static List<List<Integer>> findPathsForSum(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        findAllPaths(root, sum, currPath, allPaths);
        return allPaths;
    }

    public static void findAllPaths(TreeNode currNode, int sum, List<Integer> currPath, List<List<Integer>> allPaths){

        if (currNode == null){
            return;
        }

        currPath.add(currNode.val);

        if(currNode.val == sum && currNode.left == null && currNode.right == null){
            allPaths.add(new ArrayList<>(currPath));
        }
        // we go through the left and right side
        findAllPaths(currNode.left , sum - currNode.val, currPath, allPaths);
        findAllPaths(currNode.right,sum - currNode.val, currPath, allPaths);
        // we take out the node as we go back up the tree
        currPath.remove(currPath.size()-1);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result =findPathsForSum(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
