# TC: O(m*n)
# SC: O(m*n)
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        q = deque()
        oldColor = image[sr][sc]
        q.append((sr, sc))

        if oldColor == color:
            return image
        
        image[sr][sc] = color

        dir = [[-1, 0], [1, 0], [0, 1], [0, -1]]

        while len(q) != 0:
            right, left = q.popleft()
            for d in dir:
                r = right + d[0]
                l = left + d[1]
                if r >= 0 and l >= 0 and r < m and l < n and image[r][l] == oldColor:
                    image[r][l] = color
                    q.append((r,l))
        return image
            

