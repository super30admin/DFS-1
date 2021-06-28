# Time Complexity : O(M*N) 
# Space Complexity :    O(M*N) 
# Did this code successfully run on Leetcode : YES
# Any problem you faced while coding this : NO


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if len(mat)==0:
            return []
        
        #if mat[i][j]==0 then append to the queue,
        #else mutate 1 to -1 - to handle level 1
        
        m = len(mat)
        n = len(mat[0])
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        dist=1
        while(len(q)):
            cursize = len(q)
            for i in range(cursize):
                cur = q.popleft()
                r = cur[0]
                c = cur[1]

                for d in dirs:
                    nr = r+d[0]
                    nc = c+d[1]
                    
                    if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==-1:
                        q.append([nr,nc])
                        mat[nr][nc]=dist
            dist+=1
                    
        return mat

