from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        if image is None or len(image)==0:
            return image
        
        if image[sr][sc]==newColor:
            return image
        
        que= deque()
        que.append((sr,sc))
        m = len(image)
        n = len(image[0])
        
        directions = [[-1,0],[0,-1],[1,0],[0,1]]
        srcColor = image[sr][sc]
        image[sr][sc]=newColor
    
        while que:
            cur=que.popleft()
            for di in directions:
                row=cur[0]+di[0]
                col=cur[1]+di[1]
                
                if row>=0 and row<m and col>=0 and col<n and image[row][col]==srcColor:
                    image[row][col]=newColor
                    que.append((row,col))
        
        return image
                