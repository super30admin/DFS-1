# Flooding
# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
    def dfs(self, r, c, m, n, image, color, change_color):
        
        for dir in self.dirs:
            nr = dir[0] + r
            nc = dir[1] + c
            
            if nr >= 0 and nr < m and nc >= 0 and nc < n:
                if image[nr][nc] == color:
                    image[nr][nc] = change_color
                    self.dfs(nr, nc, m, n, image, color, change_color)
                
        
    
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        
        m = len(image)
        n = len(image[0])
        color = image[sr][sc]
        
        if color == newColor: return image
        
        image[sr][sc] = newColor
        self.dfs(sr, sc, m, n, image, color, newColor)
        
        return image

# 0-1 Matrix
# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    dirs = [(1, 0),(0, 1),(-1, 0),(0, -1)]
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        Q = []
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    Q.append((i, j))
                else:
                    mat[i][j] = -1                 
        dist = 1
        while Q:
            size = len(Q)
            
            for i in range(size):
                loc = Q.pop(0)
                
                for dir in self.dirs:
                    nr = dir[0] + loc[0]
                    nc = dir[1] + loc[1]
                    
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist
                        Q.append((nr, nc))
            
            dist += 1
            
        
        return mat
