class Solution:
    m = 0
    n = 0
    def updateMatrix(self, matrix):
        m = len(matrix)
        if matrix ==None or m == 0:
            return 0
        result = [][]
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                result = self.dfs(matrix,i,j)
        return result

    def dfs(self,matrix,i,j):
        #base case

        if( i>=0 and matrix[i-1][j] == 0 ):
            return 1
        if( i< m and matrix[i+1][j] == 0 ):
            return 1
        if( j>=0 and matrix[i][j-1] == 0 ):
            return 1
        if( i< n and matrix[i][j+1] == 0 ):
            return 1

        top = left = 9999
