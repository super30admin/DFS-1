#Accepted by leetcode
#Time complexity - O(N) as we are visting every element
#Space complexity - O(N) as we are using queue


from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if matrix == None or len(matrix) == 0:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        q = deque()
        dirs = [(0,1),(1,0),(0,-1),(-1,0)]
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append([i,j])
                else:
                    matrix[i][j] = 9999
        while len(q) > 0:
            size = len(q)
            for k in range(size):
                curr = q.popleft()
                for d in dirs:
                    r = d[0] + curr[0]
                    c = d[1] + curr[1]
                    if r>= 0 and r < m and c >= 0 and c < n and matrix[r][c] > matrix[curr[0]][curr[1]] + 1:
                        q.append([r,c])
                        matrix[r][c] = matrix[curr[0]][curr[1]] + 1
        return matrix