def findLengthMaxFruit(arr):
    start = 0
    maxFruit = 0
    counter = {}

    for end in range(0, len(arr)):
        nextChar = arr[end]
        counter[nextChar] = counter.get(nextChar, 0) + 1

        while len(counter) >2:
            firstChar = arr[start]
            counter[firstChar] = counter.get(firstChar) - 1

            if counter.get(firstChar) == 0:
                del counter[firstChar]
            start += 1
        maxFruit = max(maxFruit, end - start + 1)
    return maxFruit


print("Maximum number of fruits: " + str(findLengthMaxFruit(['A', 'B', 'C', 'A', 'C'])))
print("Maximum number of fruits: " + str(findLengthMaxFruit(['A', 'B', 'C', 'B', 'B', 'C'])))
