# #BFS:
# TC: O(V) where V is the number of vertices/cells of matrix
# SC: O(V) where V is the number of vertices/cells of matrix

from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) == 0:
            return []

        m = len(mat)
        n = len(mat[0])
        dirs = [(1,0), (-1,0), (0,-1), (0,1)]
        q = Queue()
        ans = [[0] * n for _ in range(m)]
        visited = set([])
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.put((i,j))
                    visited.add((i,j))

        while not q.empty():
            size = q.qsize()
            for _ in range(size):
                x, y = q.get()
                for dx, dy in dirs:
                    new_x = x + dx
                    new_y = y + dy
                    if 0 <= new_x < m and 0 <= new_y < n and (new_x, new_y) not in visited:
                        ans[new_x][new_y] = ans[x][y] + 1
                        q.put((new_x,new_y))
                        visited.add((new_x, new_y))
           
        return ans