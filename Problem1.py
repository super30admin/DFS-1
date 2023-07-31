# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or image[sr][sc]==color:
            return image
        m=len(image)
        n=len(image[0])
        q=deque()
        oldColor=image[sr][sc]
        image[sr][sc]=color
        q.append((sr,sc))
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        while q:
            curr=q.popleft()
            for dir in dirs:
                nr=curr[0]+dir[0]
                nc=curr[1]+dir[1]
                if nr>=0 and nr<m and nc>=0 and nc<n and image[nr][nc]==oldColor:
                    image[nr][nc]=color
                    q.append((nr,nc))
        return image
