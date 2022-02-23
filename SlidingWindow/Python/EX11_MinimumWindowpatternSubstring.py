# Smallest Window containing Substring (hard)#
# Given a string and a pattern, find the smallest substring in the given string which has all the character occurrences of the given pattern.
#
# Example 1:
#
# Input: String="aabdec", Pattern="abc"
# Output: "abdec"
# Explanation: The smallest substring having all characters of the pattern is "abdec"
# Example 2:
#
# Input: String="aabdec", Pattern="abac"
# Output: "aabdec"
# Explanation: The smallest substring having all character occurrences of the pattern is "aabdec"
# Example 3:
#
# Input: String="abdbca", Pattern="abc"
# Output: "bca"
# Explanation: The smallest substring having all characters of the pattern is "bca".
# Example 4:
#
# Input: String="adcad", Pattern="abc"
# Output: ""
# Explanation: No substring in the given string has all characters of the pattern.


def findSubstring(str1, patten):
    pattCount = {}
    start = 0
    match = 0
    rstart = 0
    mxLen = len(str1) + 1

    for letter in patten:
        pattCount[letter] = pattCount.get(letter, 0) + 1

    for end in range(len(str1)):
        nextChar = str1[end]

        if nextChar in pattCount:
            pattCount[nextChar] -= 1
            if pattCount[nextChar] == 0:
                match += 1

        while match == len(pattCount):

            if mxLen > end - start + 1:
                mxLen = end - start + 1
                rstart = start

            firstChar = str1[start]
            start += 1
            if firstChar in pattCount:
                if pattCount[firstChar] == 0:
                    match -= 1
                pattCount[firstChar] += 1

    return "" if mxLen > len(str1) else str1[rstart: rstart + mxLen]


print(findSubstring("aabdec", "abc"))
print(findSubstring("aabdec", "abac"))
print(findSubstring("abdbca", "abc"))
print(findSubstring("adcad", "abc"))
