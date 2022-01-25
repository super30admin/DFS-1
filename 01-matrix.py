# Time Complexity: O(n)
# Space Complexity: O(1)
import sys
class Solution(object):
    def updateMatrix(self, mat):
        m, n = len(mat), len(mat[0])
        # output = [[sys.maxsize if mat[i][j] != 0 else 0 for j in range(n)] for i in range(m)]
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                else:
                    mat[i][j] = -1
        
        dist = 1
        dirs = [[0,1], [0,-1], [1,0], [-1,0]]
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dir in dirs:
                    nr = dir[0] + curr[0]
                    nc = dir[1] + curr[1]
                    if nr >= 0 and nc >= 0  and nr < m and nc < n and mat[nr][nc] == -1:
                        q.append([nr, nc])
                        mat[nr][nc] = dist
            dist += 1
        
        return mat
            
#         def bfs(i, j):
#             q = deque()
#             visited = set()
#             result = 0
            
#             q.append([i,j])
#             while q:
#                 size = len(q)
#                 while size:
#                     size -= 1
#                     x,y = q.popleft()
#                     if mat[x][y] == 0:
#                         return result
#                     for x, y in [(x + 1, y), (x, y + 1), (x - 1, y), (x, y - 1)]:
#                         if 0 <= x < len(mat) and 0 <= y < len(mat[0]) and (x, y) not in visited:
#                             visited.add((x, y))
#                             q.append((x, y))
#                 result += 1
#             return result

        
#         for i in range(len(mat)):
#             for j in range(len(mat[0])):
#                 output[i][j]  = bfs(i,j)
#         return output