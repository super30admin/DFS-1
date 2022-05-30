#Time complexity: O(mn)
#Space complexity: O(mn)
from collections import deque


class Solution:
    def floodFill(self, image, sr: int, sc: int, newColor: int):
        dirs=[(0,1),(0,-1),(1,0),(-1,0)]
        color=image[sr][sc]
        if color==newColor:
            return image
        q=deque()
        image[sr][sc]=newColor
        q.append((sr,sc))
        while q:
            for i in range(len(q)):
                r,c=q.popleft()
                for d in dirs:
                    row=r+d[0]
                    col=c+d[1]
                    if row>=0 and row<len(image) and col>=0 and col<len(image[0]) and image[row][col]==color:
                        image[row][col]=newColor
                        q.append((row,col))
        return image
                    
        
        
