"""
Time Complexity -->O(m*n)
Space complexity ---> 0(m*n) [recursive stack]

"""

class Solution_floodFill_dfs:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image)==0 or image[sr][sc]==newColor:
            return image
        
        self.color=image[sr][sc]
        self.dfs(sr,sc,newColor,image)
        return image
        
    def dfs(self,i,j,newcolor,image):
        #base:
        if(i < 0 or j < 0 or i >= len(image) or j >= len(image[0]) or image[i][j] !=self.color):
            return
        #logic
        image[i][j]=newcolor
        dirs=[[1,0 ],[0,1],[0,-1],[-1,0]]
        for dir in dirs:
            r=dir[0]+i
            c=dir[1]+j
            self.dfs(r,c,newcolor,image)