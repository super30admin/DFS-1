""" 
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Time Complexity using BFS: O(m*n)
Space Complexity using BFS: O(m*n)

Time Complexity using DP: O(m*n)
Space Complexity using DP: O(1) as output array is not considered extra space
"""

#bfs from all 0s

from collections import deque
def updateMatrix(mat):
    
    dirs = [(0,1), (0,-1), (1,0), (-1,0)]
    m, n = len(mat), len(mat[0])
    
    queue = deque()
    
    for i in range(m):
        for j in range(n):
            if mat[i][j] == 0:
                queue.append((i,j))
            else:
                mat[i][j] = float('inf')
                
    while queue:
        r, c = queue.popleft()
        
        for dr, dc in dirs:
            nr = r + dr
            nc = c + dc
            
            if 0 <= nr < m and 0 <= nc < n and mat[nr][nc] > mat[r][c] + 1:
                mat[nr][nc] = mat[r][c] + 1
                queue.append((nr,nc))
                
                
    return mat
    
#using dynamic programming
def updateMatrix(mat):
    
    m, n = len(mat), len(mat[0])
    distances = [[float('inf') for _ in range(n)] for _ in range(m)]
    
    for i in range(m):
        for j in range(n):
            if mat[i][j] == 0:
                distances[i][j] = 0
            else:
                if i > 0:
                    distances[i][j] = min(distances[i][j], distances[i-1][j] + 1)
                if j > 0:
                    distances[i][j] = min(distances[i][j], distances[i][j-1] + 1)
                    
    for i in range(m-1, -1, -1):
        for j in range(n-1, -1, -1):
            if i < m-1:
                distances[i][j] = min(distances[i][j], distances[i+1][j] + 1)
            if j < n-1:
                distances[i][j] = min(distances[i][j], distances[i][j+1] + 1)
                
    return distances
                

    