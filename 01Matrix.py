"""
Approach: BFS
For our BFS routine, we keep a queue, q to maintain the queue of cells to be examined next.
We start by adding all the cells with 0s to q.
We make all 1s as `-1`s. Then while popping items from the queue, we calculate
new nr,nc locations, check their bounds and if mat[nr][nc] == -1 we replace that with
dist, and then append (nr,nc) to queue to process its neighbors.
TC: O(m * n) as each cell only goes into queue if it is currently set to -1, that avoids cells re-entering queue over and over again.
SC: O(m*n) as in worst case we may need to add most of the cells in the queue.
"""

from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1

        dist = 1
        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for d in dirs:
                    nr, nc = curr[0] + d[0], curr[1] + d[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist 
                        q.append((nr,nc))
            dist += 1
        return mat

"""Approach 2: BFS without use of Size or Distance variable
TC and SC is same as above."""
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1

        dirs = [(1,0),(0,1),(0,-1),(-1,0)]
        while q:
            curr = q.popleft()
            for d in dirs:
                nr, nc = curr[0] + d[0], curr[1] + d[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[curr[0]][curr[1]] + 1 
                    q.append((nr,nc))
        return mat