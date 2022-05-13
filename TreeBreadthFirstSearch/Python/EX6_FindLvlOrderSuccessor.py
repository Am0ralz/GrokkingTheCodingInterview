# Given a binary tree and a node, find the level order successor of the given node in the tree. The level order
#  successor is the node that appears right after the given node in the level order traversal.
#    Algorithm
#   1.add root to queue
#   2.take node form queue
#   3. add children to queue
#   4. check curr node to given node
#   5. if equals then return next node
#   6. else continue
from collections import deque


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


def find_Lvl_Order_Successor(root, given):
    if root is None:
        return None
    queue = deque()
    queue.append(root)
    while queue:
        size = len(queue)
        for i in range(size):
            curr = queue.popleft()
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)

            if curr.val == given:
                return queue.popleft()

    return None


def main():
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)

    result = find_Lvl_Order_Successor(root, 3)
    if result:
        print(result.val)

    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(9)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)

    result = find_Lvl_Order_Successor(root, 9)
    if result:
        print(result.val)

    result = find_Lvl_Order_Successor(root, 12)
    if result:
        print(result.val)


main()
