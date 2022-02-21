# Given an array of positive numbers and a positive number ‘k,’
#  find the maximum sum of any contiguous subarray of size ‘k’.
# Example 1:
#         Input: [2, 1, 5, 1, 3, 2], k=3
#         Output: 9
#         Explanation: Subarray with maximum sum is [5, 1, 3].
# Example 2:
#
#         Input: [2, 3, 4, 1, 5], k=2
#         Output: 7
#         Explanation: Subarray with maximum sum is [3, 4].


def findMaxSumSubArray(k, arr):
    start = 0
    end = 0
    total = 0
    # the smallest number possible
    maxAverage = float('-inf')
    while end < len(arr):
        total += arr[end]
        if end >= k - 1:
            maxAverage = max(maxAverage, total)
            total -= arr[start]
            start += 1
        end += 1
    return maxAverage


print(findMaxSumSubArray(3, [2, 1, 5, 1, 3, 2]))
