#m*n,h

class Solution:
    def __init__(self):
        self.dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        self.clr=0
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        
        self.clr=image[sr][sc]
        self.dfs(sr,sc,newColor,image)
        return image
    def dfs(self,row,col,color,image):
        #base
        #logic
        image[row][col]=color
        for i in self.dirs:
            x=row+i[0]
            y=col+i[1]
            if x>=0 and x<len(image) and y>=0 and y<len(image[0]) and image[x][y]==self.clr and image[x][y]!=color:
                self.dfs(x,y,color,image)
        
            
        