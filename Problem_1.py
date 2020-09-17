# 733. Flood Fill

# Code:

# Approach:

# if the val at the given source is equal to the new color, just return.
# If not, do a DFS from the source and traverse through the connected 4 directions and modify the color


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image:
            return []
        
        color = image[sr][sc]
        
        if color == newColor:
            return image
        
        self.DFS_helper(image, sr,sc, newColor, color)
        
        return image
    
    def DFS_helper(self,image, i, j, newColor, color):
        if i<0 or j<0 or i>=len(image) or j>=len(image[0]):
            return 
        
        if image[i][j] == color:
            image[i][j] = newColor
        
            self.DFS_helper(image, i+1, j, newColor, color)
            self.DFS_helper(image, i-1, j, newColor, color)
            self.DFS_helper(image, i, j+1, newColor, color)
            self.DFS_helper(image, i, j-1, newColor, color)
        
        return

# Time Complexity: O(n*m)
# Space Complexity: O(1)
# Accepted on Leetcode: Yes