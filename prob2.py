class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n =len(mat[0])
        q=[]
        dirs = [[-1,0],[0,-1],[1,0],[0,1]]
        for i in range(m):
            for j in range(n):
                if(mat[i][j]==0):
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        dist = 1
        while(len(q) != 0):
            
            sz = len(q)
            for i in range(sz):
                cur = q.pop(0)
                for d in dirs:
                    nr = cur[0]+d[0]
                    nc = cur[1]+d[1]
                    if(nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1):
                        q.append([nr,nc])
                        mat[nr][nc]= dist
                
                
            dist += 1
        
        
        return mat

#TC:0(M X N)
#SC:0(M X N)