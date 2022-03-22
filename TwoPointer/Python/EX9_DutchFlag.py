# Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
# hence, we can’t count 0s, 1s, and 2s to recreate the array.
#
# The flag of the Netherlands consists of three colors: red, white and blue; and since our input array also consists
# of three different numbers that is why it is called Dutch National Flag problem.
#
# Example 1:
#
# Input: [1, 0, 2, 1, 0]
# Output: [0 0 1 1 2]
# Example 2:
#
# Input: [2, 2, 0, 1, 2, 0]
# Output: [0 0 1 2 2 2 ]

def dutchFlag(arr):
    l = 0
    r = 0
    i = 0
    while i <= r:
        if arr[i] < 1:
            temp = arr[l]
            arr[l] = arr[i]
            arr[i] = temp
            l += 1
            i += 1
        elif arr[i] > 1:
            temp = arr[i]
            arr[r] = arr[i]
            arr[i] = temp
            r -= 1
        else:
            i += 1


def main():
    arr = [1, 0, 2, 1, 0]
    dutchFlag(arr)
    print(arr)

    arr = [2, 2, 0, 1, 2, 0]
    dutchFlag(arr)
    print(arr)


main()
