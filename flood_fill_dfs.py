# Time Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Space Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def __init__(self):
        self.oldColor = None
        self.dirs = [(0,1), (1,0), (-1,0), (0, -1)]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        ROWS, COLS = len(image), len(image[0])
        if ROWS == 0 or image[sr][sc] == newColor:
            return image
        self.oldColor = image[sr][sc]
        self.dfs(image, sr, sc, ROWS, COLS, newColor)
        
        return image 

    def dfs(self, image, r, c, ROWS, COLS, newColor):
        #Base
        if r < 0 or c < 0 or r == ROWS or c == COLS or image[r][c] != self.oldColor:
            return
        
        #Logic
        image[r][c] = newColor
        
        for d in self.dirs:
            nr = r + d[0]
            nc = c + d[1]
            self.dfs(image, nr, nc, ROWS, COLS, newColor)