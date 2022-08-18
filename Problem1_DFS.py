# Time complexity : O(m*n)
# Space complexity : O(m*n)
# Leetcode : Solved and submitted

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        # put directions in 4 directions as tuple
        self.dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        
        # if the image is empty or the color is same as the color to be changes, then 
        # return the image list as it is
        if not image or image[sr][sc] == color:
            #print(image[sr][cs], color)
            return image
        
        # find the rows and cols of the matrix, store the old color
        rows = len(image)
        cols = len(image[0])
        old_color = image[sr][sc]
        
        # call the dfs function with the starting pixel
        self.dfs(image, sr, sc, color, old_color, rows, cols)
        return image
        
    def dfs(self, image, r, c, color, old_color, rows, cols):
        # check for boundary conditions and also if the color is not the old color, then we simply return
        if(r < 0 or r == rows or c < 0 or c == cols or image[r][c] != old_color):
            return
        # if color matches, then we change the color to new
        if image[r][c] == old_color:
            image[r][c] = color
        # recursively do it for all the neighbors
        for di in self.dirs:
            ro = r + di[0]
            co = c + di[1]
            self.dfs(image, ro, co, color, old_color, rows, cols)
        
        
