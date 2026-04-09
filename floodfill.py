# Time Complexity : O(m * n)
# Space Complexity : O(m * n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use DFS.
# Start from the given cell (sr, sc) and store its original color.
# If the original color is same as new color, return early.
# Recursively visit all 4-directionally connected cells having the same original color.
# Change their color to the new color during traversal.

class Solution:
    def floodFill(self, image, sr, sc, color):
        rows, cols = len(image), len(image[0])
        original = image[sr][sc]
        
        if original == color:
            return image
        
        def dfs(r, c):
            if r < 0 or c < 0 or r >= rows or c >= cols:
                return
            if image[r][c] != original:
                return
            
            image[r][c] = color
            
            dfs(r+1, c)
            dfs(r-1, c)
            dfs(r, c+1)
            dfs(r, c-1)
        
        dfs(sr, sc)
        return image