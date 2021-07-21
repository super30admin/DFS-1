# Time Complexity: O(mn), where m - num of rows, n - num of cols
# Space Complexity: O(mn)
# Did this code successfully run on Leetcode: Yes

# Solution:

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or len(matrix) == 0:
            return []

        rows = len(matrix)
        cols = len(matrix[0])
        q = deque()

        for i in range(rows):
            for j in range(cols):
                # Start from elements with val 0 (Initialize the queue)
                if matrix[i][j] == 0:
                    q.append([i, j])
                # change the matrix value 1 to -1 to track visited
                else:
                    matrix[i][j] = -1

        while q:
            # For every value from the queue, explore the four neighbors
            curr = q.popleft()
            dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                # If neighboring val is -1, increment its distance by 1 level
                if 0 <= r < rows and 0 <= c < cols and matrix[r][c] == -1:
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
                    q.append([r, c])

        return matrix
