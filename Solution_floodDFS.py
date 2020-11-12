"""
Time Complexity 0(V+E) -->O(N)
Space complexity 0(V+E)---> 0(N) [recursive stack]

"""


class Solution_floodDFS:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        self.image=image
        if self.image is None or len(self.image)==0:
            return []
        
        scolor=self.image[sr][sc]
        if scolor==newColor:
            return self.image
        self.dfs(sr,sc,newColor,scolor)
        return self.image
        
    def dfs(self,r,c,newcolor,color):
        if self.image[r][c]== color:
            self.image[r][c]=newcolor
            if r>=1:
                self.dfs(r-1,c,newcolor,color)
            if r+1<len(self.image):
                self.dfs(r+1,c,newcolor,color)
            if c>=1:
                self.dfs(r,c-1,newcolor,color)
            if c+1<len(self.image[0]):
                self.dfs(r,c+1,newcolor,color)