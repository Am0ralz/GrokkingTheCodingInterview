def length_of_longest_substring(str1, k):
    # TODO: Write your code here
    start = 0
    maxLen = 0
    maxRep = 0
    counter = {}

    for end in range(0, len(str1)):
        lastChar = str1[end]
        counter[lastChar] = counter.get(lastChar, 0) + 1
        maxRep = max(maxRep, counter.get(lastChar))
        if end - start + 1 - maxRep > k:
            firstChar = str1[start]
            counter.get(firstChar) - 1
            start += 1
        maxLen = max(maxLen, end - start + 1)
    return maxLen


print(length_of_longest_substring("aabccbb", 2))
print(length_of_longest_substring("abbcb", 1))
print(length_of_longest_substring("abccde", 1))
