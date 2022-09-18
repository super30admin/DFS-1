class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, new_color: int) -> List[List[int]]:
        if not image or image[sr][sc]==new_color:
            return image
        
        #Getting basic data
        rows=len(image)
        cols=len(image[0])
        directions=[[1,0],[-1,0],[0,-1],[0,1]]
        #Storing the initial color in a variable
        initial_color=image[sr][sc]
        
        self.dfs(image,sr,sc,new_color,rows,cols,directions,initial_color)
        return image
    
    def dfs(self,image,sr,sc,new_color,rows,cols,directions,initial_color):
        #base
        if(sr<0 or sc<0 or sr==rows or sc==cols or image[sr][sc]!=initial_color):
            return
        
        
        #logic
        image[sr][sc]=new_color
        for d in directions:
            nr=sr+d[0]
            nc=sc+d[1]
            self.dfs(image,nr,nc,new_color,rows,cols,directions,initial_color)
        