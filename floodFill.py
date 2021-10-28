class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # color=image[sr][sc]
        if image[sr][sc]==newColor:
            return image
        
        self.dfs(image,sr,sc,newColor,image[sr][sc])
        return image
        
    def dfs(self,image, sr,sc, newColor, color):
        #Check length and color value of the image
        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc]!=color:
            return
        image[sr][sc]=newColor

        dirs=[[0,1],[1,0],[-1,0],[0,-1]]

        for dir in dirs:
            r=sr+dir[0]
            c=sc+dir[1]
            self.dfs(image,r,c,newColor,color)
            
        