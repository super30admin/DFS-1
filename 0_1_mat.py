from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        :TC: O(m*n)
        """
        
        queue_r = deque()
        queue_c = deque()
        m=len(mat)
        n=len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j] ==0:
                    queue_r.append(i)
                    queue_c.append(j)
                
                else:
                    mat[i][j]==-1
        
       
        dirs = [(0,1),(0,-1),(-1,0),(1,0)]
        while queue_r:
            cr=queue_r.popleft()
            cc=queue_c.popleft()
            for dir in dirs:
                nr = cr+dir[0]
                nc= cc+dir[1]
                if nr<0 or nc<0 or nr>=m or nc>=n or mat[nr][nc]==0:
                    continue
                queue_r.append(nr)
                queue_c.append(nc)
                mat[nr][nc] = mat[cr][cc]+1

            return mat
                        
                
                        
        
        