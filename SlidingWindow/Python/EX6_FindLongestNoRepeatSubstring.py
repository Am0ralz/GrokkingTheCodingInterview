def findLength(str1):
    start = 0
    maxLen = 0
    counter = {}

    for end in range(0, len(str1)):
        nextChar = str1[end]
        counter[nextChar] = counter.get(nextChar, 0) + 1
        while counter.get(nextChar) > 1:
            firstChar = str1[start]
            counter[firstChar] = counter.get(firstChar) - 1

            if counter.get(firstChar) == 0:
                del counter[firstChar]

            start += 1
        maxLen = max(maxLen, end - start + 1)
    return maxLen


print("Length of the longest substring: " + str(findLength("aabccbb")))
print("Length of the longest substring: " + str(findLength("abbbb")))
print("Length of the longest substring: " + str(findLength("abccde")))
