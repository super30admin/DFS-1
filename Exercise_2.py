# Time Complexity: O(m*n)
# Space Complexity: O(m*n) 
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        m = len(mat)
        n = len(mat[0])
        q = deque()
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
        
        dirs = [[0,1], [1,0], [-1,0], [0,-1]]
        
        dist = 1
        while q:
            size = len(q)
            for i in range(size):
                cell = q.pop()
                for dir in dirs:
                    nr = dir[0]+cell[0]
                    nc = dir[1]+cell[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc] = dist
                        q.appendleft((nr,nc))
            dist+=1
        return mat