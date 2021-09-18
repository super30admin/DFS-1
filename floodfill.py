# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def __init__(self):
        self.dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        self.color=0
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        self.image=image
        self.color=image[sr][sc]
        if self.color == newColor:
            return self.image
        self.dfs(sr,sc,newColor)
        return self.image
    def dfs(self,sr,sc,newColor):
        #base
        
        if(sr<0 or sc<0 or sr==len(self.image) or sc==len(self.image[0]) or (self.image[sr][sc] is not self.color)):
            
            return
        #logic
        self.image[sr][sc]=newColor
        print(self.image)
        for i in self.dirs:
            print(i)
            r=sr+i[0]
            c=sc+i[1]
            print(r)
            print(c)
            

            self.dfs(r,c,newColor)
        
        