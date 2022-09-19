'''
542. 01 Matrix

APPROACH 1: optimized BFS
TIME COMPLEXITY: O(M*N)
SPACE COMPLEXITY: O(M*N)
LEETCODE: Yes
DIFFICULTIES: yes. I solved it after the class.

NOTE: EXHAUSTIVE BFS(timed out)
TODO: DFS, DP DFS
'''

from collections import deque
class Solution:
    def updateMatrix(self, mmat: List[List[int]]) -> List[List[int]]:
        global mat, dirs
        mat = mmat
        dirs = [(-1,0), (1,0), (0,1), (0,-1)]
        
        # BFS
        def approach1():
            m = len(mat)
            n = len(mat[0])
            q = deque()
            
            for i in range(0, m):
                for j in range(0, n):
                    if mat[i][j] == 1:
                        mat[i][j] = -1
                    elif mat[i][j] == 0:
                        q.append((i,j))
            
            level = 1
            while len(q) != 0:
                sz = len(q)
                for i in range(0, sz):
                    i,j = q.popleft()
                    for dirr, dirc in dirs:
                        nr = i + dirr
                        nc = j + dirc
                        
                        if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                            mat[nr][nc] = level
                            q.append((nr, nc))
                level += 1
            
        approach1()
        
        return mat
