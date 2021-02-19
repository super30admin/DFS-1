################# Iterative solution
# Time complexity: O(Number of zeros*m*n)
# Space complexity: O(n*m)
# Worked on leetcode: yes
# Iterative approach: This algorithm uses a queue. First, we change all 1's in the matrix to integer.max. Then, we add the indices of all 0's in the matrix to the queue.
# Then, till the queue is not empty, we pop the front element from queue, and check its 4 neighbors, if value of front + 1 < neighbor, we push the indices of the neighbor
# to the queue. This means that front is 0 and the neighbors are at distance of 1 from this 0. So, we update all neighboring integer.max to 1.
# We keep doing this till the queue is empty.

import sys

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:

        if matrix == None or len(matrix) == 0 or len(matrix[0]) == 0:
            return matrix

        queue = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    queue.append([i, j])
                elif matrix[i][j] == 1:
                    matrix[i][j] = sys.maxsize

        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]

        while (len(queue) > 0):
            current = queue.pop(0)
            for direction in dirs:
                row = current[0] + direction[0]
                col = current[1] + direction[1]
                if row >= 0 and row < len(matrix) and col >= 0 and col < len(matrix[0]) and matrix[current[0]][current[1]] + 1 < matrix[row][col]:
                    queue.append([row, col])
                    matrix[row][col] = 1 + matrix[current[0]][current[1]]

        return matrix
