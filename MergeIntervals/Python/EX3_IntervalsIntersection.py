# Given two lists of intervals, find the intersection of these two lists. Each list consists of disjoint intervals
# sorted on their start time.
#
# Example 1:
#
# Input: arr1=[[1, 3], [5, 6], [7, 9]], arr2=[[2, 3], [5, 7]]
# Output: [2, 3], [5, 6], [7, 7]
# Explanation: The output list contains the common intervals between the two lists.
# Example 2:
#
# Input: arr1=[[1, 3], [5, 7], [9, 12]], arr2=[[5, 10]]
# Output: [5, 7], [9, 10]
# Explanation: The output list contains the common intervals between the two lists.

def merge(arr1, arr2):
    results = []
    i = 0
    j = 0

    while i < len(arr1) and j < len(arr2):
        if arr1[i][1] > arr2[j][0] and arr1[i][0] <= arr2[j][1]:

            a = max(arr1[i][0], arr2[j][0])
            b = min(arr1[i][1], arr2[j][1])
            results.append([a, b])
            i += 1
        elif arr1[i][1] < arr2[j][0]:
            i += 1
        else:
            j += 1
    return results


def main():
    print(merge([[1, 3], [5, 6], [7, 9]], [[2, 3], [5, 7]]))
    print(merge([[1, 3], [5, 7], [9, 12]], [[5, 10]]))


main()
