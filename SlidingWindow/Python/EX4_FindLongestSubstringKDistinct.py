def findLength(k, str1):
    start = 0
    longLen = float("-inf")
    counter = {}
    for end in range(0, len(str1)):
        nextChar = str1[end]
        counter[nextChar] = counter.get(nextChar, 0) + 1
        while len(counter) > k:
            firstChar = str1[start]
            counter[start] = counter.get(firstChar) - 1
            if counter[start] == 0:
                del counter[start]
        start += 1
        longLen = max(longLen, end - start + 1)

    return longLen
