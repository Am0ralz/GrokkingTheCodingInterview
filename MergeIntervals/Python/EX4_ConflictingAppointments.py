def canAttendAllAppointments(intervals):
    intervals.sort(key=lambda x: x[0])

    for i in range(0, len(intervals)-1):
        if intervals[i][1] > intervals[i + 1][0]:
            return False
    return True


def main():
    arr = [[1, 4], [2, 5], [7, 9]]
    arr2 = [[6, 7], [2, 4], [8, 12]]
    arr3 = [[4, 5], [2, 3], [3, 6]]

    print(canAttendAllAppointments(arr))
    print(canAttendAllAppointments(arr2))
    print(canAttendAllAppointments(arr3))


main()
