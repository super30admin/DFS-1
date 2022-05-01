class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat==None or len(mat)==0:return mat
        m=len(mat)
        n=len(mat[0])
        q=[]
        dirs=[[1,0],[-1,0],[0,1],[0,-1]]
        for i in range(m):
            for j in range(n):
                if(mat[i][j]==0):
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        dist=1
        while(len(q)!=0):
            size=len(q)
            for i in range(size):
                curr=q.pop(0)
                for dir1 in dirs:
                    r=curr[0]+dir1[0]
                    c=curr[1]+dir1[1]
                    if(r>=0 and r<m and c>=0 and c<n and mat[r][c]==-1):
                        mat[r][c]=dist
                        q.append([r,c])
            dist+=1
        return mat
        