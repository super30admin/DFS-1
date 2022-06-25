"""
Approach: DFS Recursive
TC: O(N) or O(m*n) - size image size
SC: O(N) or O(m*n) for call stack of recursion.
"""
class Solution:
    dirs = [[1,0],[0,1],[0,-1],[-1,0]]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # base case
        if not image or len(image)  == 0:
            return list()
        
        # if image color at given location is same as expected color, stop there
        # one such case is [[0,0,0],[0,0,0]] 0 0 0
        if image[sr][sc] == color: return image
        # logic - use DFS
        self.dfs(image, sr, sc, color, image[sr][sc])
        return image
        
    def dfs(self, image, sr, sc, color, origColor):
        # base case
        if sr < 0 or sc < 0 or sr >= len(image) or sc >= len(image[0]) or image[sr][sc] != origColor: return
        
        # logic
        image[sr][sc] = color
        for d in self.dirs:
            nr = sr + d[0]
            nc = sc + d[1]
            self.dfs(image, nr, nc, color, origColor)
        

"""Approach: BFS

TC O(m*n)
SC O(m*n)
"""

from collections import deque
class Solution:
    dirs = [[1,0],[0,1],[0,-1],[-1,0]]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        # base case
        if not image or len(image)  == 0:
            return list()
        
        # if image color at given location is same as expected color, stop there
        # one such case is [[0,0,0],[0,0,0]] 0 0 0
        if image[sr][sc] == color: return image
        # logic - use BFS
        q = deque()
        origColor= image[sr][sc]
        print(origColor, color)
        q.append((sr,sc))
        
        while q:
            sr, sc = q.popleft()
            if sr >= 0 and sc >= 0 and sr < len(image) and sc < len(image[0]) and image[sr][sc] == origColor: 
                image[sr][sc] = color
                for d in self.dirs:
                    nr = sr + d[0]
                    nc = sc + d[1]
                    q.append((nr,nc))

        return image
        