#Flood Fill

# Time -> O(mXn)
# Space -> O(mXn) -> Stack space
# Logic -> On the 

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        oldColor = image[sr][sc]
        newColor = color
        if oldColor == newColor:
            return image
        
        dirs = [(-1,0), (0,1), (1,0), (0,-1)]

        self.dfs(image, sr, sc, oldColor, newColor, dirs)

        return image
    
    def dfs(self, image, i, j, oldColor, newColor, dirs):

        if i<0 or j< 0 or i==len(image) or j==len(image[0]) or image[i][j]!=oldColor:
            return 
        
        image[i][j] = newColor
        for r, c in dirs:
            self.dfs(image, r+i, c+j, oldColor, newColor, dirs)

        return 