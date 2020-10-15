# Flood Fill


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        color = image[sr][sc]
        if color!=newColor:
            self.dfs_helper(image,sr,sc,color,newColor)
        return image
    
    def dfs_helper(self,image,r,c,color,newColor):
        if image[r][c]==color:
            image[r][c]=newColor
            if (r>=1):
                self.dfs_helper(image,r-1,c,color,newColor)
            if (r+1<len(image)):
                self.dfs_helper(image,r+1,c,color,newColor)
            if (c>=1):
                self.dfs_helper(image,r,c-1,color,newColor)
            if (c+1<len(image[0])):
                self.dfs_helper(image,r,c+1,color,newColor)
            
        return image
            
 # Space Complexity : O(n) for stack
 # Time Complexity: O(m*n)   
        
    
            
        
        
        
        
        
