# Time Complexity : O(N)
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes.. I thought four directions 
# meant vertical, horizontal, and two diagonals. Also had small boundary issues to fix



# Your code here along with comments explaining your approach

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if not image:
            return []
        
        originalColor = image[sr][sc]
        
        self.dfs(image, sr, sc, newColor, originalColor)
        
        return image
    
    
    def dfs(self, image, i, j, newColor, originalColor):
        
        if image[i][j] == newColor or image[i][j] != originalColor:
            return 
        
        image[i][j] = newColor
        
        dirs = [[0,1],
                [-1,0],
               [0,-1],
               [1,0]]
               #[-1,-1],
               #[-1, 1],
               #[1, -1],
               #[1,1]]
        for direction in dirs:
            row = direction[0] + i
            col = direction[1] + j
            
            if row >= 0 and row < len(image) and col >= 0 and col < len(image[0]) and image[row][col] == originalColor:
                #image[i][j] = newColor
                self.dfs(image, row, col, newColor, originalColor)
            