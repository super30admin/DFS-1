# Using BFS
# Time complexity - O(2*n*m)
# Space complexity - O(n*m) queue 
# Did this solution run on leetcode? - yes
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return 
        
        n, m = len(matrix), len(matrix[0])          # 3,3
        q = deque()
        # add the location of 0s as the starting indices.
        for r in range(n):                   
            for c in range(m):
                if matrix[r][c]==0:
                    q.append((r, c))
                else:
                    # mark as unvisited
                    matrix[r][c]=-1
        
        # directions array # right, left, down, up
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]   
        
        step = 1
        while q:
            # traverse the queue
            for _ in range(len(q)):
                idx = q.popleft()
                r, c = idx
                for d in dirs:
                    # add the indices which have not been visited yet. 
                    # bounds check
                    if 0<=r+d[0]<n and 0<=c+d[1]<m and matrix[r+d[0]][c+d[1]]==-1:  
                        matrix[r+d[0]][c+d[1]] = step
                        q.append((r+d[0], c+d[1]))
            step+=1
        
        return matrix
        

# Leetcode solution
# Using dynamic programming
# Time complexity - O(n*m) # 2 passes # top-down and bottom-up
# Space complexity - O(n*m)
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return
        
        n, m = len(matrix), len(matrix[0])
        dist = [[float('inf')]*m for _ in range(n)] # result array
        
        # Top-down
        for r in range(n):
            for c in range(m):
                if matrix[r][c]==0:
                    dist[r][c]=0
                else:
                    if r>0:
                        dist[r][c] = min(dist[r][c], dist[r-1][c]+1)
                    if c>0:
                        dist[r][c] = min(dist[r][c], dist[r][c-1]+1)
                
        # Bottom-up
        for r in range(n-1, -1, -1):
            for c in range(m-1, -1, -1):
                if r<n-1:
                    dist[r][c] = min(dist[r][c], dist[r+1][c]+1)
                if c<m-1:
                    dist[r][c] = min(dist[r][c], dist[r][c+1]+1)
                    
        return dist
                