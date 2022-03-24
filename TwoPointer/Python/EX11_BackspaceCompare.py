# Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
#
# Example 1:
#
# Input: str1="xy#z", str2="xzz#"
# Output: true
# Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
#
# Example 2:
#
# Input: str1="xy#z", str2="xyz#"
# Output: false
# Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
# Example 3:
#
# Input: str1="xp#", str2="xyz##"
# Output: true
# Explanation: After applying backspaces the strings become "x" and "x" respectively.
# In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
# Example 4:
#
# Input: str1="xywrrmp", str2="xywrrmu#p"
# Output: true
# Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.

def compare(str1, str2):
    a = len(str1) - 1
    b = len(str2) - 1

    while a >= 0 or b >= 0:
        backtrack = 0
        while str1[a] == "#":
            backtrack += 1
            a -= 1
        a -= backtrack
        backtrack = 0
        while str2[b] == "#":
            backtrack += 1
            b -= 1
        b -= backtrack

        if b < 0 and a < 0:
            return True
        if (a < 0 or b < 0) or str1[a] != str2[b]:
            return False
        b -= 1
        a -= 1
    return True


# def backspace_compare(str1, str2):
#   # use two pointer approach to compare the strings
#   index1 = len(str1) - 1
#   index2 = len(str2) - 1
#   while (index1 >= 0 or index2 >= 0):
#     i1 = get_next_valid_char_index(str1, index1)
#     i2 = get_next_valid_char_index(str2, index2)
#     if i1 < 0 and i2 < 0:  # reached the end of both the strings
#       return True
#     if i1 < 0 or i2 < 0:  # reached the end of one of the strings
#       return False
#     if str1[i1] != str2[i2]:  # check if the characters are equal
#       return False
#
#     index1 = i1 - 1
#     index2 = i2 - 1
#
#   return True
#
#
# def get_next_valid_char_index(str, index):
#   backspace_count = 0
#   while (index >= 0):
#     if str[index] == '#':  # found a backspace character
#       backspace_count += 1
#     elif backspace_count > 0:  # a non-backspace character
#       backspace_count -= 1
#     else:
#       break
#
#     index -= 1  # skip a backspace or a valid character
#
#   return index

def main():
    print(compare("xy#z", "xzz#"))
    print(compare("xy#z", "xyz#"))
    print(compare("xp#", "xyz##"))
    print(compare("xywrrmp", "xywrrmu#p"))


main()
