#733. Flood Fill
"""
Time Complexity : O()
Space Complexity : O()
"""
class Solution:
    dirs = [[1,0], [-1,0], [0,-1], [0,1]]
     #         R      L       U      D 
        
    def dfs(self, image, r, c, oldColor, color):
        #base
        if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]) or  image[r][c] != oldColor :
            #not moving forward if its the old color
            return
        
        #logic
        image[r][c] = color #changing old to new color
        for d in self.dirs:
            nr = r + d[0]
            nc = c + d[1]
            
            self.dfs(image, nr, nc, oldColor, color)
        
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        oldColor = image[sr][sc]
        
        if oldColor == color :
            return image
        
        self.dfs(image, sr, sc, oldColor, color)
        return image
        
