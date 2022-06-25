# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# BFS
from collections import deque


class Solution:
    def updateMatrix(self, matrix: list[list[int]]) -> list[list[int]]:
        m = len(matrix)
        n = len(matrix[0])
        queue = deque()
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append([i, j])
                else:
                    matrix[i][j] = -1
        distance = 1
        while queue:
            size = len(queue)
            for _ in range(size):
                pop = queue.popleft()
                for x in dirs:
                    nr = x[0] + pop[0]
                    nc = x[1] + pop[1]
                    if 0 <= nr < m and 0 <= nc < n and matrix[nr][nc] == -1:
                        matrix[nr][nc] = distance
                        queue.append([nr, nc])
            distance += 1
        return matrix


print(Solution().updateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1], [1, 1, 1]]))

# BFS
# from collections import deque
#
#
# class Solution:
#     def updateMatrix(self, matrix: list[list[int]]) -> list[list[int]]:
#         _ = matrix
#         m = len(matrix)
#         n = len(matrix[0])
#         queue = deque()
#         dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
#         for i in range(m):
#             for j in range(n):
#                 if matrix[i][j] == 0:
#                     queue.append([i, j])
#                 else:
#                     matrix[i][j] = -1
#         while queue:
#             pop = queue.popleft()
#             for x in dirs:
#                 nr = x[0] + pop[0]
#                 nc = x[1] + pop[1]
#                 if 0 <= nr < m and 0 <= nc < n and matrix[nr][nc] == -1:
#                     matrix[nr][nc] = (matrix[pop[0]][pop[1]] + 1)
#                     queue.append([nr, nc])
#         return matrix
#
#
# print(Solution().updateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1], [1, 1, 1]]))


# BFS
# TC: O((m*n)^2); SC: O(m*n)
# from collections import deque
#
#
# class Solution:
#     def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
#         dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
#         m = len(mat)
#         n = len(mat[0])
#         check = []
#         for i in range(m):
#             check.append([0] * n)
#         for i in range(m):
#             for j in range(n):
#                 queue = deque()
#                 distance = 0
#                 flag = False
#                 if mat[i][j] == 1:
#                     queue.append([i, j])
#                     while queue and not flag:
#                         size = len(queue)
#                         for _ in range(size):
#                             pop = queue.popleft()
#                             for x in dirs:
#                                 nr = x[0] + pop[0]
#                                 nc = x[1] + pop[1]
#                                 if 0 <= nr < m and 0 <= nc < n:
#                                     if mat[nr][nc] == 0:
#                                         flag = True
#                                         break
#                                     else:
#                                         queue.append([nr, nc])
#                                 if flag is True:
#                                     break
#                             if flag is True:
#                                 break
#                         distance += 1
#                     mat[i][j] = distance
#         return mat
#
#
# print(Solution().updateMatrix([[0, 0, 0], [0, 1, 0], [1, 1, 1], [1, 1, 1]]))
