def findStringAnagrams(str1, pattern):
    result = []
    pattCount = {}
    match = 0
    start = 0
    for letter in pattern:
        pattCount[letter] = pattCount.get(letter, 0)+1
    for end in range(len(str1)):
        nextChar = str1[end]
        if nextChar in pattCount:
            pattCount[nextChar] -= 1
            if pattCount[nextChar] == 0:
                match += 1
                if match == len(pattCount):
                    result.append(start)

        if end >= len(pattern)-1:
            firstChar = str1[start]
            start += 1
            if firstChar in pattCount:
                if pattCount[firstChar] == 0:
                    match -= 1
                pattCount[firstChar] += 1

    return result


print(findStringAnagrams("ppqp", "pq"))
print(findStringAnagrams("abbcabc", "abc"))
