# //Given a binary tree, populate an array to represent the averages of all of its levels.
from collections import deque


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


# Algorithm
#     1. add root node to queue
#     2. while queue is not empty
#     3. for size of que
#       3a. poll next item in queue
#       3b. add val to sum
#       3c. add left and right to queue
#      4. add sum to results
#      5. return results when queue is empty

def find_level_averages(root):
    results = []
    queue = deque()
    queue.append(root)
    while queue:
        total = 0
        size = len(queue)
        for i in range(size):
            curr = queue.popleft()
            total += curr.val
            if curr.left:
                queue.append(curr.left)
            if curr.right:
                queue.append(curr.right)
        results.append(sum)
    return results


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(9)
    root.left.right = TreeNode(2)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    print("Level averages are: " + str(find_level_averages(root)))


main()
