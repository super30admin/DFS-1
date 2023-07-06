# Time Complexity : O(mn)
# Space Complexity : O(mn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Use a breadth-first search (BFS) algorithm. First add all cells that are marked 0. 
# We use a time variable to then track at what time each of the other cells are visited.
# We can store the answer directly in the matrix itself.

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return None
        if not len(mat):
            return [[]]
        
        m, n = len(mat), len(mat[0])
        q = deque([])
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    q.append((r, c))
        
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        time = 1
        while q:
            for _ in range(len(q)):
                (r, c) = q.popleft()
                for (dr, dc) in dirs:
                    nr, nc = r+dr, c+dc
                    if 0<=nr<m and 0<=nc<n and mat[nr][nc] == 1:
                        mat[nr][nc] = time + 1
                        q.append((nr, nc))
            time += 1
        
        for r in range(m):
            for c in range(n):
                if mat[r][c] > 1:
                    mat[r][c] -= 1
        return mat
