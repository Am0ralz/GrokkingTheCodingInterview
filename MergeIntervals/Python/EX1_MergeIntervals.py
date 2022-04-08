# Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive
# intervals.
#
# Example 1:
#
# Intervals: [[1,4], [2,5], [7,9]]
# Output: [[1,5], [7,9]]
# Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
# one [1,5].
def merge(intervals):
    intervals.sort(key=lambda x: x[0])

    merged = []
    for interval in intervals:
        # if the list of merged intervals is empty or if the current
        # interval does not overlap with the previous, simply append it.
        if not merged or merged[-1][1] < interval[0]:
            merged.append(interval)
        else:
            # otherwise, there is overlap, so we merge the current and previous
            # intervals.
            merged[-1][1] = max(merged[-1][1], interval[1])

    return merged


def main():
    print(merge([[1, 4], [2, 5], [7, 9]]))
    print(merge([[6, 7], [2, 4], [5, 9]]))
    print(merge([[1, 4], [2, 6], [3, 5]]))


main()
