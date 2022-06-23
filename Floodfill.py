#Time complexity : O(M*N)
#Space complexity : O(M*N)
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        originalColor = image[sr][sc]
        
        self.dfs(sr, sc, image, newColor, originalColor)
        return image
        
    def dfs(self, row, col, image, newColor, originalColor):
        
        if(row >= 0 and col >= 0 and row < len(image) and col < len(image[0]) and newColor != image[row][col] and image[row][col] == originalColor):
            image[row][col] = newColor
        else:
            return
        self.dfs(row+1, col,image, newColor, originalColor)
        self.dfs(row, col+1,image, newColor, originalColor)
        self.dfs(row-1, col,image, newColor, originalColor)
        self.dfs(row, col-1,image, newColor, originalColor)
