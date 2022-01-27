# Time Complexity - O(mn)
# Space Complexity - O(mn)
from collections import deque
class Solution:
    #DFS
    init = -1
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image)==0 or image[sr][sc]==newColor:
            return image
        self.init = image[sr][sc]
        self.dfs(image,sr,sc,newColor)
        return image
    
    def dfs(self,image,r,c,newColor):
        #base
        if image[r][c]!=self.init:
            return
        #logic
        image[r][c]=newColor
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        for dir1 in dirs:
            nr = r+dir1[0]
            nc = c+dir1[1]
            if nr>=0 and nr<len(image) and nc>=0 and nc<len(image[0]):
                if image[nr][nc]==self.init:
                    self.dfs(image,nr,nc,newColor)
    
    '''BFS
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if len(image)==0 or image[sr][sc]==newColor:
            return image
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        m=len(image)
        n=len(image[0])
        color = image[sr][sc]
        q = deque()
        q.append((sr,sc))
        image[sr][sc]=newColor
        while q:
            curr=q.popleft()
            for dir1 in dirs:
                nr = curr[0]+dir1[0]
                nc = curr[1]+dir1[1]
                if nr>=0 and nr<m and nc>=0 and nc<n and image[nr][nc]==color:
                    q.append((nr,nc))
                    image[nr][nc]=newColor
        return image
