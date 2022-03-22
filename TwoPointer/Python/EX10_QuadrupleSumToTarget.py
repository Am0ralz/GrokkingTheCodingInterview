# Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to
# the target number.
#
# Example 1:
#
# Input: [4, 1, 2, -1, 1, -3], target=1
# Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
# Explanation: Both the quadruplets add up to the target.
# Example 2:
#
# Input: [2, 0, -1, 1, -2, 2], target=2
# Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
# Explanation: Both the quadruplets add up to the target.


def searchQuadruplets(arr, target):
    arr.sort()
    result = []
    for i in range(len(arr) - 3):
        for j in range(i + 1, len(arr) - 2):
            l = j+1
            r = len(arr)-1
            while l < r:

                if arr[i] + arr[j] + arr[l] + arr[r] < target:
                    l += 1
                elif arr[i] + arr[j] + arr[l] + arr[r] > target:
                    r -= 1
                else:
                    result.append([arr[i], arr[j], arr[l], arr[r]])
                    l += 1
                    r -= 1
                    while l < r and arr[l] == arr[l - 1]:
                        l += 1
                    while l < r and arr[r] == arr[r + 1]:
                        r -= 1
    return result


def main():
    print(searchQuadruplets([4, 1, 2, -1, 1, -3], 1))
    print(searchQuadruplets([2, 0, -1, 1, -2, 2], 2))


main()
