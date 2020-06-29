"""
// Time Complexity : o(m*n)
// Space Complexity : o(m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def dfs(self, sr, sc, n_color):
        #base
        if sr < 0 or sr >= len(self.img) or sc < 0 or sc >= len(self.img[0]) or self.img[sr][sc] != self.color: #if the cell is out of bounds or already colored with the new color or 0
            return 
        #logic
        self.img[sr][sc] = n_color #change the color
        
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        
        for d in dirs: # go to all neighbours
            r = sr + d[0]
            c = sc + d[1]
            self.dfs(r,c,n_color)
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.img = image
        self.color = image[sr][sc] #original color
        
        if self.color == newColor: 
            return image
        
        self.dfs(sr, sc, newColor)#dfs from source cell
        
        return self.img