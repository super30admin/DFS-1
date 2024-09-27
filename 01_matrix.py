// Time Complexity : O(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we use BFS approach in this problem .we start this problem by finding all the zeros in the matrix and then apply BFS by taking the size of the queue and then continue this process and the size will be the value of the element of that matrix.we do this till no elements are left in the queue.

# using BFS
from collections import deque


class Solution:
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
        if matrix == None or len(matrix) == 0:
            return matrix
        queue = deque([])
        count = 0
        visited=[[0 for i in range(len(matrix[0]))] for j in range(len(matrix))]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    visited[i][j]=1
                    queue.append([i, j])
        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                q = queue.popleft()
                matrix[q[0]][q[1]] = count
                for j in dirs:
                    row = q[0] + j[0]
                    col = q[1] + j[1]
                    if 0 <= row < len(matrix) and 0 <= col < len(matrix[0]) and  visited[row][col]==0:
                        visited[row][col]=1
                        queue.append([row, col])
            count = count + 1
        return matrix