"""
Time - O(m * n)
Space - O(m * n)
"""
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or not image[0]:
            return image
        
        m, n = len(image), len(image[0])
        initcolor = image[sr][sc]
        if initcolor == color:
            return image
        
        def dfs(r: int, c: int):
            if r < 0 or r >= m or c < 0 or c >= n:
                return
            if image[r][c] != initcolor:
                return

            image[r][c] = color

            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        dfs(sr, sc)
        return image
