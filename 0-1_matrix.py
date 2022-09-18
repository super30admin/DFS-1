class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        if len(mat)==0 or mat==None:
            return []
        
        rows=len(mat)
        cols=len(mat[0])
        directions=[[1,0],[-1,0],[0,1],[0,-1]]
        
        
        q=[]
        
        for i in range(rows):
            for j in range(cols):
                if mat[i][j]==0:
                    q.append([i,j])
                    
                else:
                    mat[i][j]=-1
                    
        dist=0
        while q:
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                for d in directions:
                    nr=curr[0]+d[0]
                    nc=curr[1]+d[1]
                    
                    #bounds check
                    if (nr>=0 and nc>=0 and nr<rows and nc<cols and mat[nr][nc]==-1):
                        mat[nr][nc]=dist+1
                        q.append([nr,nc])
            dist+=1
            
        return mat