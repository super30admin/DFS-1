#542. 01 Matrix
# Time Complexity : O(m*n)
# Space Complexity :O(m*n)
# Did this code successfully run on Leetcode : Yes
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if not matrix:
            return matrix
        queue = []
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = -1
        dist = 1
        while queue:
            size = len(queue)
            dirs = [[1,0],[-1,0],[0,1],[0,-1]]
            for i in range(size):
                curr = queue.pop(0)
                for d in dirs:
                    r = d[0] + curr[0]
                    c = d[1] + curr[1]
                    if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                        matrix[r][c] = dist
                        queue.append([r,c])
                        
            dist += 1
        return matrix