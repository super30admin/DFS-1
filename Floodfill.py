// Time Complexity : o(mn)
// Space Complexity :o(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        row=len(image)
        col=len(image[0])
        if ((image==None) or (row==0) or(image[sr][sc]==newColor)):
            return image
        q=[]
        color=image[sr][sc]
        image[sr][sc]=newColor
        q.append((sr,sc))
        dir={(0,-1),(-1,0),(0,1),(1,0)}
        while q:
            node=q.pop()
            for d in dir:
                r=node[0]+d[0]
                c=node[1]+d[1]
                if((r>=0) and(r<row) and (c>=0) and (c<col) and (image[r][c]==color)):
                    image[r][c]=newColor
                    q.append((r,c))
        return image
                
   ///DFS SOLUTION
   class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        row=len(image)
        col=len(image[0])
        if ((image==None) or (row==0) or(image[sr][sc]==newColor)):
            return image
        self.color=image[sr][sc]
        self.dir={(0,-1),(-1,0),(0,1),(1,0)}
        self.dfs(image,sr,sc,newColor)
        return image
        
        
        
        
    def dfs(self,image,r,c,newColor):
        #base
        if((r<0) or (r>=len(image)) or(c<0) or(c>=len(image[0])) or (image[r][c]!=self.color)):
                return
        
        
        
        #logic
        image[r][c]=newColor
        for d in self.dir:
            i=r+d[0]
            j=c+d[1]
            self.dfs(image,i,j,newColor)
