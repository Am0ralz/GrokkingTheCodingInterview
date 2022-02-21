def findPermutation(word, pattern):
    start = 0
    match = 0
    pattDict = {}

    for letter in pattern:
        pattDict[letter] = pattDict.get(letter, 0) + 1

    for end in range(0, len(word)):
        nextChar = word[end]
        if nextChar in pattDict:
            pattDict[nextChar] -= 1
            if pattDict.get(nextChar) == 0:
                match += 1

        if match == len(pattDict):
            return True

        if end >= len(pattern) - 1:
            firstChar = word[start]
            start += 1
            if firstChar in pattDict:
                if pattDict[firstChar] == 0:
                    match -= 1
                pattDict[firstChar] += 1

    return False


print('Permutation exist: ' + str(findPermutation("oidbcaf", "abc")))
print('Permutation exist: ' + str(findPermutation("odicf", "dc")))
print('Permutation exist: ' + str(findPermutation("bcdxabcdy", "bcdyabcdx")))
print('Permutation exist: ' + str(findPermutation("aaacb", "abc")))
