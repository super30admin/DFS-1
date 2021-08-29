"""
Time Complexity : O(mxn) m is no. of row and n is no. of cols
Space Complexity : O(mxn) m is no. of row and n is no. of cols
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image) == 0 or image[sr][sc] == newColor:
            return image
        self.m = len(image)
        self.n = len(image[0])
        self.dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        # Store the current starting point color
        self.color = image[sr][sc]
        self.dfs(image, sr, sc, newColor)
        return image
    def dfs(self, image, r, c, newColor):
        # Base
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or image[r][c] != self.color:
            return
        # Logic
        # Change color if equal to starting point
        image[r][c] = newColor
        # Traverse through dirs list and find the pixel with original color and               # change it
        for item in self.dirs:
            nr = r + item[0]
            nc = c + item[1]
            self.dfs(image, nr, nc, newColor)