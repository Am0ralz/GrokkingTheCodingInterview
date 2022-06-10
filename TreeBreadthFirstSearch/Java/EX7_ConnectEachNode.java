package TreeBreadthFirstSearch;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode1 {
    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1 next;

    TreeNode1(int x) {
        val = x;
        left = right = next = null;
    }

    // tree traversal using 'next' pointer
    public void printTree() {
        TreeNode1 current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
};
public class EX7_ConnectEachNode {
    //Create a queue
    // add node to queue
    //for loop to go through the size of the queue
    //connect the node to previous quee
    //add left and right node of the current nodes to the queue
    //contiunue until queue is empty
    public static void connect(TreeNode1 root){
        if (root == null)
            return;

        Queue<TreeNode1> queue= new LinkedList<>();
        queue.offer(root);
        TreeNode1 currentNode = null, previousNode = null;
        while(!queue.isEmpty()){
            currentNode = queue.poll();
            if(previousNode != null){
                previousNode.next=currentNode;
            }
            previousNode = currentNode;

            if (currentNode.left != null){
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null){
                queue.offer(currentNode.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode1 root = new TreeNode1(12);
        root.left = new TreeNode1(7);
        root.right = new TreeNode1(1);
        root.left.left = new TreeNode1(9);
        root.right.left = new TreeNode1(10);
        root.right.right = new TreeNode1(5);
        connect(root);
        root.printTree();
    }
}
