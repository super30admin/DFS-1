# approach: BFS starts from all 0's simultaneously, it efficiently finds the shortest distance to zero for each 1.
# TC: O(m*n), visit each cell only once when popped out from queue
# sc: O(m*n), just queue
from typing import List
from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m = len(mat)
        n = len(mat[0])

        queue = deque()

        # Initialize the queue with all 0s and mark 1s as -1 (unvisited)
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j))
                else:
                    mat[i][j] *= -1

        dist = 1
        # BFS from all 0s simultaneously
        while queue:
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                for dirc in directions:
                    r = dirc[0] + curr[0]
                    c = dirc[1] + curr[1]

                    if r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
                        queue.append((r, c))
                        mat[r][c] = dist
                        # mat[r][c] = mat[curr[0]][curr[1]] + 1 # if you want to remove extra size variable
            dist += 1  # remove this is you're not using size
        return mat


sol = Solution()
matrix = [[1, 0, 0], [1, 1, 1], [1, 1, 1]]
result = sol.updateMatrix(matrix)
print(result)
