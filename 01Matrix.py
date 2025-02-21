"""
BFS Approach -
TC - O(m * n)
SC - O(m * n)
"""


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat is None or len(mat) == 0: return 0

        m = len(mat)
        n = len(mat[0])

        q = deque([])

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    # since we need to keep track of visited/processed elements
                    mat[i][j] = -1
        # print(q)

        # directions arr
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        distance = 1

        while q:
            qsize = len(q)
            for i in range(qsize):
                curr = q.popleft()
                for directions in dirs:
                    new_row = curr[0] + directions[0]
                    new_col = curr[1] + directions[1]

                    if new_row >= 0 and new_col >= 0 and new_row < m and new_col < n and mat[new_row][new_col] == -1:
                        mat[new_row][new_col] = distance
                        # append new indices to the q for next elements processing
                        q.append([new_row, new_col])
            distance += 1

        return mat
