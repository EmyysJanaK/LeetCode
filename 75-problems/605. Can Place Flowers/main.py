class Solution(object):
    def canPlaceFlowers(self, flowerbed, n):
        """
        :type flowerbed: List[int]
        :type n: int
        :rtype: bool
        """
        # Early return if no flowers need to be placed
        if n == 0:
            return True
        
        length = len(flowerbed)
        for i in range(length):
            if flowerbed[i] == 0:
                empty_left = (i == 0) or (flowerbed[i - 1] == 0)
                empty_right = (i == length - 1) or (flowerbed[i + 1] == 0)
                
                # print(f"Index {i}: empty_left={empty_left}, empty_right={empty_right}, n={n}")
                
                if empty_left and empty_right:
                    flowerbed[i] = 1
                    n -= 1
                    # print(f"Placed flower at index {i}, updated flowerbed: {flowerbed}, remaining n={n}")
                    if n == 0:
                        return True
                
        return n == 0  # Ensure return False only if n flowers could not be placed

# Test case
# print(Solution().canPlaceFlowers([1, 0, 0, 0, 1], 0))
