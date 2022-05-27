# Time Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Space Complexity : O(m*n) where m is number of rows and n is number of columns in the matrix
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        ROWS, COLS = len(image), len(image[0])
        if ROWS == 0 or image[sr][sc] == newColor:
            return image
        dirs = [(0,1), (1,0), (-1,0), (0, -1)]
        oldColor = image[sr][sc]
        image[sr][sc] = newColor
        
        q = deque()
        q.appendleft((sr, sc))
        
        while len(q) != 0:
            pixel = q.pop()
            
            for d in dirs:
                r = pixel[0] + d[0]
                c = pixel[1] + d[1]
                
                if r >= 0 and c >= 0 and r < ROWS and c < COLS and image[r][c] == oldColor:
                    image[r][c] = newColor
                    q.appendleft((r,c))

        return image