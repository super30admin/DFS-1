#time-m*n,space-m*n
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        q=deque()
        clr=image[sr][sc]
        image[sr][sc]=newColor
        q.append((sr,sc))
        while q:
            
            curr=q.popleft()
            
            for i in dirs:
                x=curr[0]+i[0]
                y=curr[1]+i[1]
                if x>=0 and x<len(image) and y>=0 and y<len(image[0]) and image[x][y]==clr and image[x][y]!=newColor:
                    
                    image[x][y]=newColor
                    q.append((x,y))
        return image
            
            
        