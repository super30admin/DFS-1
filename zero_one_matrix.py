"""
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
DFS
- Idea is to run DFS on 1 in the matrix and update the value in place
    as min of all possible zeroes around it
"""

class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        def dfs(i,j,matrix,m,n,depth):
            if matrix[i][j] == 0:
                return depth
            
            directions = [(1,0),(0,1),(-1,0),(0,-1)]
            for x,y in directions:
                valx = x + i
                valy = y + j
                if valx >=0 and valx < m and valy >=0 and valy < n:
                    #continue the dfs , update the value based on the result
                    result = min(result,dfs(valx,valy,matrix,m,n,depth+1))
                    matrix[i][j] = result
            #return depth
        
        m = len(matrix)
        n = len(matrix[0])
        one_i,one_j = -1,-1

        #finding the coordinate for the element with value1
        for i in range(m):
            one_found = False
            for j in range(n):
                if matrix[i][j] == 1:
                    one_i,one_j = i,j
                    one_found = True
            if one_found:
                break

        dfs(one_i,one_j,matrix,m,n,0)