# Time complexity : O(n*m)
# Space complexity : O(m*n)
from collections import deque
from typing import List


class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if len(image) == 0 or len(image[0]) == 0 or image[sr][sc] == color:
            return image
        m = len(image)
        n = len(image[0])
        queuer = deque()
        queuec = deque()
        old_color = image[sr][sc]
        image[sr][sc] = color
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        queuer.append(sr)
        queuec.append(sc)
        while queuer:
            currrow = queuer.popleft()
            currcol = queuec.popleft()
            for dir1 in dirs:
                nr = currrow + dir1[0]
                nc = currcol + dir1[1]
                if m > nr >=0 and n > nc >=0 and image[nr][nc] == old_color :
                    image[nr][nc] = color
                    queuer.append(nr)
                    queuec.append(nc)
       
        return image