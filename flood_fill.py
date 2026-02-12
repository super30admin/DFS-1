"""
complexity: O(m*n) where m and n are the dimensions of the image
space complexity: O(m*n) in the worst case when all the pixels are of the same color and we have to change them all

DFS approach: we start from the given pixel and change its color to the new color. 
Then we check its 4 neighbors and if they are of the same color as the original color, we call the helper function recursively on them. 
We keep doing this until we have changed all the pixels that are connected to the original pixel and have the same color.
"""
from typing import List

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        self.true_color = image[sr][sc]
        self.color = color
        if self.color == self.true_color:
            return image
        self.helper(image, sr, sc)
        return image
    
    def helper(self, image, row, col):
        image[row][col] = self.color
        directions = [[-1,0],[1,0],[0,1],[0,-1]]
        for d in directions:
            if 0 <= row+d[0] < len(image) and 0 <= col+d[1] < len(image[0]) and image[row+d[0]][col+d[1]]==self.true_color:
                self.helper(image, row+d[0],col+d[1])
        

        