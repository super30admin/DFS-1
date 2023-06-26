# Time Complexity : O(nxm)
# Space Complexity : O(nxm)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to fill the new color if its not original color using depth first traversal method by starting from given index.

class Solution:

    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        orig = image[sr][sc]
        if(image == None or len(image) ==0):
            return 
        if(orig == color):
            return image
        self.dfs(image, sr,sc, orig, color)
        return image

    def dfs(self, image, r, c , orig, color):
        if(r<0 or r==len(image) or c<0 or c==len(image[0]) or image[r][c]!= orig):
            return
        image[r][c]=color
        dirs=[[-1,0], [0,-1], [1,0],[0,1]]
        for dir in dirs:
            nr=r+dir[0]
            nc=c+dir[1]
            self.dfs(image, nr,nc, orig, color)
