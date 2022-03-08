# // Time Complexity : O(n) where n is number of pixels
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No

class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        
        R, C = len(image), len(image[0])
        color = image[sr][sc]
        if color == newColor: return image
        def dfs(r, c):
            if image[r][c] == color:
                image[r][c] = newColor
                
                # check the adjecent cells and floodfill recursively
                if r >= 1: dfs(r-1, c)
                if r+1 < R: dfs(r+1, c)
                if c >= 1: dfs(r, c-1)
                if c+1 < C: dfs(r, c+1)

        dfs(sr, sc)
        return image