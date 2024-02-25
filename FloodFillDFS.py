'''
TC: O(m*n) - m and n are the ROWS and COLS of the matrix
SC: O(h) - h being m*n (height of the tree) 
            if all entries are 1 and need to make it 2 (Worst Case)
'''
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        ROWS, COLS = len(image), len(image[0])
        oldColor = image[sr][sc]

        def dfs(r,c):
            if r<0 or c<0 or r==ROWS or c==COLS or image[r][c] == color or image[r][c] != oldColor:
                return
            image[r][c] = color
            dfs(r+1,c)
            dfs(r-1,c)
            dfs(r,c+1)
            dfs(r,c-1)
        
        dfs(sr,sc)
        return image
s = Solution()
print(s.floodFill([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2))
print(s.floodFill([[0,0,0],[0,0,0]], 0, 0, 0))