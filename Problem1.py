# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Uses a breadth-first search (BFS) algorithm. It fills the initial pixel, adds it to a queue, 
# and then iteratively checks its neighbors. The BFS continues likewise.

from collections import deque

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image:
            return None
        
        if not len(image):
            return [[]]
        
        if image[sr][sc] == color:
            return image
        
        ref = image[sr][sc]
        
        
        m = len(image)
        n = len(image[0])
        q = deque([])
        q.append((sr, sc))
        
        while q:
            (r, c) = q.popleft()
            image[r][c] = color
            dirs = [[0,1], [0,-1], [-1,0], [1,0]]
            for dr, dc in dirs:
                nr, nc = r+dr, c+dc
                if 0<=nr<m and 0<=nc<n and image[nr][nc] == ref:
                    q.append((nr, nc))
        
        return image


