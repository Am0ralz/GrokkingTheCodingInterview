# Problem Statement
#
# Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted
# order.
#
#         Example 1:
#
#         Input: [-2, -1, 0, 2, 3]
#         Output: [0, 1, 4, 4, 9]
#         Example 2:
#
#         Input: [-3, -1, 0, 1, 2]
#         Output: [0, 1, 1, 4, 9]

# Since the numbers at both ends can give us the largest square, an alternate approach could be to use two pointers
# starting at both ends of the input array. At any step, whichever pointer gives us the bigger square, we add it to
# the result array and move to the next/previous number according to the pointer.

def make_squares(arr):
    n = len(arr)
    squares = [0 for x in range(n)]
    highestSquareIdx = n - 1
    left, right = 0, n - 1
    while left <= right:
        leftSquare = arr[left] * arr[left]
        rightSquare = arr[right] * arr[right]
        if leftSquare > rightSquare:
            squares[highestSquareIdx] = leftSquare
            left += 1
        else:
            squares[highestSquareIdx] = rightSquare
            right -= 1
        highestSquareIdx -= 1

    return squares

def main():

  print("Squares: " + str(make_squares([-2, -1, 0, 2, 3])))
  print("Squares: " + str(make_squares([-3, -1, 0, 1, 2])))


main()