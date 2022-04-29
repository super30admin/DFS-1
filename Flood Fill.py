class Solution:
    m,n,color=0,0,0
    dirs=[]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if(image==None or len(image)==0 or image[sr][sc]==newColor):
            return image
        self.m=len(image)
        self.n=len(image[0])
        self.dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        self.color=image[sr][sc]
        self.dfs(sr,sc,newColor,image)
        return image
    def dfs(self,sr,sc,newColor,image):
        if(sr<0 or sc<0 or sr==self.m or sc==self.n or image[sr][sc]!=self.color):return
        image[sr][sc]=newColor
        for dir1 in self.dirs:
            r=sr+dir1[0]
            c=sc+dir1[1]
            self.dfs(r,c,newColor,image)
        