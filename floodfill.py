#Time Complexity: O(mn)
#Space Complexity: O(mn)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        color = image[sr][sc]
        m = len(image)
        n = len(image[0])
        if color == newColor:
            return image
        
        self.dfs(image,sr,sc,newColor,color,dirs)
        return image
        
        
    def dfs(self,image,sr,sc,newColor,color,dirs):
        
        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc] != color:
            return
        
        image[sr][sc] = newColor
    
            
        for dirn in dirs:
            nr = sr+dirn[0]
            nc = sc + dirn[1]
            self.dfs(image,nr,nc,newColor,color,dirs)