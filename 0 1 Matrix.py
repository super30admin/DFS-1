# Time complexity : O(m*n), we shoould traverse all elements in worst case
# Space complexity : O(m*n)
# The code ran on Leetcode

# Maintain a queue to find the level at which 1 is found. Update the value in the matrix with the minimum level

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        m = len(mat); n = len(mat[0])
        queue = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j, 0))
                else:
                    # Indicate the cell needs to be processed
                    mat[i][j] = -1
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while queue:
            size = len(queue)
            for _ in range(size):
                x, y, level = queue.popleft()

                for dx, dy in dirs:
                    xn = x + dx; yn = y + dy

                    if 0 <= xn < m and 0 <= yn < n and mat[xn][yn] == -1:
                        mat[xn][yn] = level+1
                        queue.append((xn, yn, level+1))

        return mat