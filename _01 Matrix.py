# TC : O(mxn)
# SC : O(mxn)

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        q = deque()
        m = len(mat)
        n = len(mat[0])
        dist = 1
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i,j])
                    
                else:
                    mat[i][j] = -1
                    
        
        while q:
            size = len(q)
            for _ in range(size):
                r,c = q.popleft()                
                for dr,dc in dirs:
                    nr = dr+r
                    nc = dc+c                    
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc] = dist
                        q.append([nr,nc])
            dist+=1
            
        return mat
                    