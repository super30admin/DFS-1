'''
Time Complexity: O(m * n)
Space Complexity: O(m * n)
Run on Leetcode: YES
'''
from ast import List


class Solution:
    def dfs(self, image, oldColor, color, m, n, sr, sc, direction):
        #base
        if (sr < 0 or sc < 0 or sr == m or sc == n or image[sr][sc] != oldColor):
            return
        #logic
        image[sr][sc] = color
        for direct in direction:
            nr = direct[0] + sr
            nc = direct[1] + sc
            self.dfs(image, oldColor, color, m, n, nr, nc, direction)
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])
        oldColor = image[sr][sc]
        direction = [[-1,0], [0,1], [1,0], [0,-1]]
        self.dfs(image, oldColor, color, m, n, sr, sc, direction)
        return image