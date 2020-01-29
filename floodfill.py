"""
Time complexity: O(M * N)
Space complexity: O (sqrt(M^2 + N^2))
Compiled on leetcode: Yes
Difficulties faced: No
"""
from collections import deque
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        existingColor = image[sr][sc]
        if existingColor == newColor:
            return image
        dirs = ((1,0), (-1, 0), (0, -1), (0, 1))
        
        queue = deque()
        queue.append((sr,sc))
        
        while queue:
            currentIndex = queue.popleft()
            image[currentIndex[0]][currentIndex[1]] = newColor
            for dir in dirs:
                r = dir[0] + currentIndex[0]
                c = dir[1] + currentIndex[1]
                if r >= 0 and r < m and c >= 0 and c < n and image[r][c] == existingColor:
                    image[r][c] = newColor
                    queue.append((r,c))
        
        return image
        