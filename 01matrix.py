# Time Complexity : O(M*N) where M is the number of rows and N is the number of columns in the image
# Space Complexity : O(M*N) where M is the number of rows and N is the number of columns in the image
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using BFS to traverse the matrix starting from all the cells with 0.
# I am keeping a queue to store the cells to be processed.
# I am initializing all the cells with 1 to -1 to indicate that they are unvisited.
# For each cell, I am checking its 4 adjacent cells (up, down, left, right).
# If the adjacent cell is within bounds and unvisited, I am updating its value to the current cell's value + 1 and adding it to the queue.
# Finally, I return the modified matrix.




from typing import List
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        n = len(mat)
        m = len(mat[0])
        q = deque()
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        while q:
            r,c = q.popleft()
            for dr,dc in dirs:
                nr = r + dr
                nc = c + dc
                if 0 <= nr < n and 0 <= nc < m and mat[nr][nc] == -1:
                    q.append((nr,nc))
                    mat[nr][nc] = mat[r][c] + 1
        return mat

                

        