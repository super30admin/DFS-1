# Accepted on leet code(542)
# time - O(M*N), space - O(M*N)
# In this BFS solution, we are at the first converting all 1's to infinity and then add all zeros to queue.
# Then process each zero's by using dirs array to update the infinity cells.
class Solution:
    def updateMatrix(self, matrix):
        # edge case
        if not matrix: return matrix
        # storing num of rows and columns
        m = len(matrix)
        n = len(matrix[0])
        # initializing queue and dirs array
        queue = []
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        # adding 0 to queue and making 1 as infinity.
        for i in range(m):
            for j in range(n):
                if matrix[i][j]  == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = float('inf')
        # BFS
        while queue:
            size = len(queue)
            for k in range(size):
                curr = queue.pop(0)
                for dir in dirs:
                    r = dir[0] + curr[0]
                    c = dir[1] + curr[1]
                    # Base case, if updated (r,c) position has value which is greater than curr+1 then append that to queue and change its value to curr + 1.
                    if r >=0 and r < m and c >= 0 and c < n and matrix[r][c] > matrix[curr[0]][curr[1]] + 1:
                        queue.append([r,c])
                        matrix[r][c] = matrix[curr[0]][curr[1]] + 1
        return matrix