def gcd_of_strings(str1: str, str2: str) -> str:
    def gcd(a: int, b: int) -> int:
        while b:
           a, b = b, a % b
        return a

    if str1 + str2 != str2 + str1:
        return ""
    
    gcd_length = gcd(len(str1), len(str2))
    return str1[:gcd_length] 

# Example usage:
str1 = "ABCABC"
str2 = "ABC"
print(gcd_of_strings(str1, str2))  # Output: "ABC"

str1 = "ABABAB"
str2 = "ABAB"
print(gcd_of_strings(str1, str2))  # Output: "AB"

str1 = "LEET"
str2 = "CODE"
print(gcd_of_strings(str1, str2))  # Output: ""