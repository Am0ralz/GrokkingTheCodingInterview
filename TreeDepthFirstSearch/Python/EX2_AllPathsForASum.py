class TreeNode:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def find_paths(root, required_sum):
    result = []
    curr_path = []
    all_Paths(root, required_sum, curr_path, result)
    return result


def all_Paths(curr, total, curr_path, result):
    if curr is None:
        return

    curr_path.append(curr.val)

    if curr.val == total and curr.right is None and curr.left is None:
        result.append(list(curr_path))
    else:
        all_Paths(curr.left, total - curr.val, curr_path, result)
        all_Paths(curr.right, total - curr.val, curr_path, result)

    del curr_path[-1]


def main():
    root = TreeNode(12)
    root.left = TreeNode(7)
    root.right = TreeNode(1)
    root.left.left = TreeNode(4)
    root.right.left = TreeNode(10)
    root.right.right = TreeNode(5)
    required_sum = 23
    print("Tree paths with required_sum " + str(required_sum) +
          ": " + str(find_paths(root, required_sum)))


main()
