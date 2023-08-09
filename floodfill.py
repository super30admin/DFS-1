# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


#DFS
from collections import deque

class Solution:
    def dfs(self, image, sr, sc, color, old, direction):
        #base

        #logic
        for i in direction:
            nr=sr+i[0]
            nc=sc+i[1]
            if(nr<len(image) and nr>=0 and nc<len(image[0]) and nc>=0 and image[nr][nc]==old):
                image[nr][nc]=color
                self.dfs(image, nr, nc, color, old, direction)
            


    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if(image[sr][sc]==color):
            return image
        if(len(image)==0):
            return image
        direction=[(-1,0),(1,0),(0,-1),(0,1)]
        old_color=image[sr][sc]
        image[sr][sc]=color
        self.dfs(image, sr, sc, color, old_color, direction)
        return image

#BFS
from collections import deque

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if(image[sr][sc]==color):
            return image
        if(len(image)==0):
            return image
        direction=[(-1,0),(1,0),(0,-1),(0,1)]
        q=deque([])
        prev_color=image[sr][sc]
        image[sr][sc]=color
        q.append((sr,sc))
        
        while(len(q)):
            curr=q.popleft()

            for i in direction:
                nr=curr[0]+i[0]
                nc=curr[1]+i[1]
                if(nr<len(image) and nr>=0 and nc<len(image[0]) and nc>=0 and image[nr][nc]==prev_color):
                    image[nr][nc]=color
                    q.append((nr,nc))
        return image
