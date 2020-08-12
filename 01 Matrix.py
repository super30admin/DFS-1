# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:

        def bfs(pair):

            q = deque()

            i, j = pair

            q.append(((i, j), 0))

            visited = set()

            dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

            while q:

                for i in range(len(q)):

                    src, distance = q.popleft()

                    x, y = src

                    if matrix[x][y] == 0:
                        return distance

                    visited.add(src)

                    for dir in dirs:

                        newX, newY = x + dir[0], y + dir[1]

                        if newX >= 0 and newY >= 0 and newX < len(matrix) and newY < len(matrix[0]):

                            if (newX, newY) not in visited:
                                q.append(((newX, newY), distance + 1))

        r = len(matrix)
        c = len(matrix[0])

        for i in range(r):
            for j in range(c):
                matrix[i][j] = bfs((i, j))

        return matrix




