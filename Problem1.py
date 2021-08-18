# 733. Flood Fill

class Solution:
    
    def dfs(self, image, row, col, newColor, oldColor):
        
        # base case
        
        if row < 0 or row > len(image)-1 or col < 0 or col > len(image[0])-1 or image[row][col]!=oldColor or image[row][col]==newColor:
            return 
        image[row][col] = newColor

        # logic case
        
        dirs = [[-1,0],[0,1],[1,0],[0,-1]]
        print(row, col)
        for direc in dirs:
            new_row = row + direc[0]
            new_col = col + direc[1]
            
            self.dfs(image, new_row, new_col, newColor, oldColor)
        
        
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        self.dfs(image, sr, sc, newColor, image[sr][sc])
        return image
        
        