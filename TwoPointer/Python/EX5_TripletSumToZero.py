# Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
#
#         Example 1:
#
#        Input: [-3, 0, 1, 2, -1, 1, -2]
#         Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
#        Explanation: There are four unique triplets whose sum is equal to zero.
#        Example 2:
#        Input: [-5, 2, -1, -2, 3]
#      Output: [[-5, 2, 3], [-2, -1, 3]]
#        Explanation: There are two unique triplets whose sum is equal to zero.

def searchTriplets(arr):
    arr = sorted(arr)
    result = []
    for i in range(len(arr)):
        l = i + 1
        r = len(arr) - 1
        while l < r:
            if arr[l] + arr[r] < abs(arr[i]):
                l += 1
            elif arr[l] + arr[r] > abs(arr[i]):
                r -= 1
            else:
                result.append([arr[i], arr[l], arr[r]])
                l += 1
                r -= 1
                while arr[l] == arr[l - 1]:
                    l += 1
                while arr[r] == arr[r + 1]:
                    r += 1
    return result


def main():
    print(searchTriplets([-3, 0, 1, 2, -1, 1, -2]))
    print(searchTriplets([-5, 2, -1, -2, 3]))


main()
