# Time Complexity: O(mn)
# Space Complexity: O(mn)
# Ran on Leetcode: Yes

from queue import Queue
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not len(matrix):
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        count = 0
        q = Queue()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.put([i, j])
                else:
                    count += 1
                    matrix[i][j] = -1
        if not count:
            return matrix
        direction = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        while not q.empty():
            i, j = q.get()
            for elem in direction:
                r = i + elem[0]
                c = j + elem[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                    matrix[r][c] = matrix[i][j] + 1
                    q.put([r, c])
        return matrix
            
        
        