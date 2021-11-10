# Did this code successfully run on Leetcode: Yes
# Time Complexity: O(mXn)
# Space Complexity: O(mXn)
# Logic: Instead of firing BFS from each found 1 & calculate its distance, consider 0 as independent nodes whose
# distance has already been calculated. Add them in queue & calculate distance of its neighbours, when initial distance
# is 0, search of 1's if any 1 found make its distance = current distance + 1 & add it in queue as its dist has been
# calculated after 1 complete iteration distance will be incremented by 1. & so on.

from collections import deque


class Solution:
    def updateMatrix(self, mat):
        rows = len(mat)
        cols = len(mat[0])
        queue = deque()
        distance = 0
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    queue.append((i,j))
                else:
                    mat[i][j] = -1
        direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while queue:
            size = len(queue)
            for i in range(size):
                r, c = queue.popleft()
                for d in direction:
                    row = r + d[0]
                    col = c + d[1]
                    if row >= 0 and row < rows and col >= 0 and col < cols and mat[row][col] == -1:
                        queue.append((row, col))
                        mat[row][col] = distance + 1
            distance += 1
        return mat