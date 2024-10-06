class Solution(object):
    def mergeAlternately(self, word1, word2):
        """
        :type word1: str
        :type word2: str
        :rtype: str
        """
        merged_string = []
        n, m = len(word1), len(word2)
        for i in range(max(n, m)):
            if i < n:
                merged_string.append(word1[i])
            if i < m:
                merged_string.append(word2[i])
        return ''.join(merged_string)
