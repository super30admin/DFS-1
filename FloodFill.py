class Solution:
    
    def __init__(self):
        self.color=None
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image==None or image[sr][sc]==newColor:
            return image
        self.color=image[sr][sc]
        self.dfs(image,sr,sc,newColor)
        return image
    
    def dfs(self,image,sr,sc,newColor):
        #base
        if sr<0 or sr>=len(image) or sc<0 or sc>=len(image[0]) or image[sr][sc]!=self.color:
            return
        dirs=[[0,1],[0,-1],[-1,0],[1,0]]
        image[sr][sc]=newColor
        for dir in dirs:
            r=dir[0]+sr
            c=dir[1]+sc
            self.dfs(image,r,c,newColor)
            
Time complexity is O(mn)
Space complexit is O(mn)
