# Problem1 (https://leetcode.com/problems/flood-fill/)
# Time Complexity: O(m x n)
# Space Complexity: O(m x n)
# Approach:
# We use DFS starting from the given pixel to fill all connected pixels of the same original color.
# We paint a pixel with the new color and then recurse on its four neighbors, stopping when we hit an edge or a pixel that does not match the original color.
# Painting a pixel makes it stop matching the old color, which naturally prevents us from visiting it again.

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        directions = [[0,-1],[0,1],[1,0],[-1,0]]   # the four ways to move: left, right, down, up as [row change, column change]
        self.m = len(image)                        # number of rows in the grid
        self.n = len(image[0])                     # number of columns in the grid

        old_color = image[sr][sc]                  # save the starting pixel's color before we change anything
        if old_color == color:                     # if it is already the target color, filling would change nothing
            return image                           # return early so the recursion does not loop forever
        
        def dfs(i,j):
            # stop if we walked off any edge, or this pixel is not the original color we are filling
            if i<0 or j<0 or i == self.m or j == self.n or image[i][j]!=old_color:
                return
            
            image[i][j]= color                     # paint this pixel, which also stops it matching old_color so we never revisit it

            for dir in directions:                 # try to spread into each of the four neighbors
                row = dir[0]+i                      # neighbor's row after applying the row change
                column = dir[1]+j                   # neighbor's column after applying the column change
                dfs(row,column)                     # recurse on that neighbor, its own base case handles invalid spots
        
        dfs(sr,sc)                                 # kick off the fill at the starting pixel
        return image                               # return the modified grid once the fill is done