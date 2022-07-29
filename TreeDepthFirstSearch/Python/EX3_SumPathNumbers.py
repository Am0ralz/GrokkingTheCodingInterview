class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def find_root_to_leaf_path_numbers(curr, path_sum):
    if curr is None:
        return 0

    path_sum = path_sum * 10 + curr.val

    if curr.left is None and curr.right is None:
        return path_sum

    return find_root_to_leaf_path_numbers(curr.left, path_sum) + find_root_to_leaf_path_numbers(curr.right, path_sum)


def find_sum_of_path_numbers(root):
    return find_root_to_leaf_path_numbers(root, 0)


def main():
    root = TreeNode(1)
    root.left = TreeNode(0)
    root.right = TreeNode(1)
    root.left.left = TreeNode(1)
    root.right.left = TreeNode(6)
    root.right.right = TreeNode(5)
    print("Total Sum of Path Numbers: " + str(find_sum_of_path_numbers(root)))


main()
