
#Time: O(m*n)
#Space: O(m*n)


from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        rows = len(matrix)
        cols = len(matrix[0])

        q = deque()
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] == 0:
                    q.append((row, col, 0))
                else:
                    matrix[row][col] = -1 # unprocessed

        directions = {(0, 1), (0, -1), (1, 0), (-1, 0)}
        while q:
            row, col, level = q.popleft()

            # check 4 neighbors

            for direction in directions:
                new_row = row + direction[0]
                new_col = col + direction[1]
                if 0 <= new_row < rows and 0 <= new_col < cols and matrix[new_row][new_col] == -1:
                    matrix[new_row][new_col] = level + 1
                    q.append((new_row, new_col, level + 1))

        return matrix