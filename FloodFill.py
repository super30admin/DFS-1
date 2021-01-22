# TC: O(mn)
# SC: O(mn)
# BFS
# Maintain neighbours at each level in the queue. process each element in the queue one by one. If we encounter same color among neighbours, change it and add to the queue to consider its neighbours.  
from collections import deque
class Solution:
    def floodFill(self, image, sr, sc, newColor):
        # edge
        if image == None or len(image) == 0 or image[sr][sc] == newColor: return image 
        m, n = len(image), len(image[0])
        color = image[sr][sc]
        q = deque()
        q.append((sr, sc))
        image[sr][sc] = newColor
        dirs = [(0,1), (0,-1), (-1,0), (1,0)]
        while q:
            cr, cc = q.pop()
            for d in dirs:
                r = cr + d[0]
                c = cc + d[1]
                if r>= 0 and r < m and c >= 0 and c < n and image[r][c] == color:
                    image[r][c] = newColor
                    q.append((r,c))
        return image

# DFS
# Recursion through relevant elements and its neighbours
class Solution:
    def __init__(self):
        self.m = None
        self.n = None
        self.color = None
        
    def floodFill(self, image, sr, sc, newColor):
        if image == None or len(image) == 0 or image[sr][sc] == newColor: return image
        self.m = len(image)
        self.n = len(image[0])
        self.color = image[sr][sc]
        self.dfs(image, sr, sc, newColor)
        return image
    
    def dfs(self, image, sr, sc, newColor):
        # base
        if sr < 0 or sc < 0 or sr == self.m or sc == self.n or image[sr][sc] != self.color: return
        # logic
        image[sr][sc] = newColor
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]
        for d in dirs:
            r = d[0] + sr
            c = d[1] + sc
            self.dfs(image, r, c, newColor)