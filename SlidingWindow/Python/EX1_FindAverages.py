# brute force solution
# def findAverages(k, arr):
#     ans = []
#     for i in range(0, len(arr)-k+1):
#         print(i)
#         total = 0
#         for j in range(i, i + k):
#             total += arr[j]
#         ans.append(total/5)
#     return ans

# sliding window solution
# Step 1: we have add all the number until we get k numbers added
# STep 2: then we save teh numbers to the array
# STep 3: then we we subtract the first number
# Step 4:add the next number
# Step 5: repeat 2- 4 until end is equal to the last number


def findAverages(k, arr):
    ans = []
    start = 0
    end = 0
    total = 0
    while end < len(arr):
        total += arr[end]
        if end >= k - 1:
            ans.append(total / k)
            total -= arr[start]
            start += 1
        end += 1
    return ans


print(findAverages(5, [1, 3, 2, 6, -1, 4, 1, 8, 2]))
