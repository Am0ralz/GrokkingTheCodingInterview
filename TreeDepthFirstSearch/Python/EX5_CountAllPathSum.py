class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def count_paths(root, S):
    return count_paths_recursive(root, S, [])


def count_paths_recursive(node, S, arr):
    # we return 0 if node is empty or we went past a leaf
    if node is None:
        return 0
    # We add the current node to the path
    arr.append(node.val)
    # create two variables. One for the current node and the other for the total sum
    curr_sum = 0
    path_sum = 0

    # we add all the values fromn this point back to the root
    for n in range(len(arr) - 1, -1, -1):
        curr_sum += arr[n]
        if curr_sum == S:
            path_sum += 1
    # we add the path from the left side
    path_sum += count_paths_recursive(node.left, S, arr)
    # we do the same for the right
    path_sum += count_paths_recursive(node.right, S, arr)
    # we take out the element from the arr
    del arr[-1]
    #return the final value
    return path_sum


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    print("Tree has paths: " + str(count_paths(root, 11)))


main()
