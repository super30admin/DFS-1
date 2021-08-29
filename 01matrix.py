"""
//Time Complexity : O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this : NO
"""
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        #T.C = O(m*n)
        #S.C = O(m*n)
        
        if len(mat) == 0:
            return mat
        m = len(mat)
        n = len(mat[0])
        from collections import deque
        r= deque()
        c= deque()
        for i in range(0,m):
            for j in range(0,n):
                if(mat[i][j]==0):
                    r.append(i)
                    c.append(j)
                else:
                    mat[i][j] = -1
        level = 1
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        while r:
            size = len(r)
            for i in range(0,size):
                row = r.popleft()
                col = c.popleft()
                for d in dirs:
                    nr = row + d[0]
                    nc = col + d[1]
                    if(nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]== -1):
                        r.append(nr)
                        c.append(nc)
                        mat[nr][nc]= level
            level+=1
        return mat