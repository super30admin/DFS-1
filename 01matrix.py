# approach: brute-force, process all the 1's first with BFS
# TC: O(m^2 * n^2)
# sc: O(2(m*n)) == O(m*n)
from typing import List
from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # directions that needs to be checked
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        m = len(mat)  # rows
        n = len(mat[0])  # cols

        # go through matrix , process each 1
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = self.bfs(mat, i, j, directions, m, n)
        return mat

    def bfs(self, mat, i, j, directions, m, n):
        queue = deque([(i, j)])

        visited = [
            [False for _ in range(n)] for _ in range(m)
        ]  # boolean matrix to mark visited
        visited[i][j] = True

        dist = 0

        while queue:
            size = len(queue)  # track level
            for _ in range(size):
                curr = queue.popleft()  # get the position of curr element
                for dirc in directions:  # go through neighbours
                    r = dirc[0] + curr[0]
                    c = dirc[1] + curr[1]
                    if r >= 0 and c >= 0 and r < m and c < n:
                        if mat[r][c] == 0:  # if neigh. is zero, calc the distance
                            return dist + 1
                        elif not visited[r][
                            c
                        ]:  # if not add it to the queue and mark true in visited
                            visited[r][c] = True
                            queue.append((r, c))
            dist += 1  # Increment only after processing current level
        return -1  # fallback


sol = Solution()
matrix = [[1, 0, 0], [1, 1, 1], [1, 1, 1]]
result = sol.updateMatrix(matrix)
print(result)
