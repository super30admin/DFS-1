"""DFS approach"""

#Time complexity - O(MN) as we are visting every element
#Space complexity - O(MN) as we are using res matrix


class Solution(object):
    m = 0 #Encapsulation
    n = 0 #Encapsulation
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        #Edge case
        if matrix == None or len(matrix) == 0:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        res = [[0 for x in range(n)] for y in range(m)]
        
        def dfs(matrix,res,i,j):
            #Base case
            if i < 0 or i >= m or j < 0 or j >= n:
                return 9999
            if matrix[i][j] == 0:
                return 0
            if i > 0 and matrix[i-1][j] == 0:
                return 1
            if j > 0 and matrix[i][j-1] == 0:
                return 1
            if i < m-1 and matrix[i+1][j] == 0:
                return 1
            if j < n-1 and matrix[i][j+1] == 0:
                return 1
            #Don't have any neighboring zero
            #top, left, right, bottom = 0,0,0,0
            top, left = 9999, 9999 #Declare them as infinity
            if i > 0 and res[i-1][j] != 0:
                top = res[i-1][j]
            if j > 0 and res[i][j-1] != 0:
                left =  res[i][j-1]
            bottom = dfs(matrix,res,i+1,j)
            right = dfs(matrix,res,i,j+1)
            return min(min(left,right), min(top,bottom)) + 1#Correction:add 1
            
        for i in range(m):
            for j in range(n):
                res[i][j] = dfs(matrix, res, i,j)
        return res