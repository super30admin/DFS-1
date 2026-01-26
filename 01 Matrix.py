class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m=len(mat)
        n=len(mat[0])
        dirs=[[-1,0],[0,1],[1,0],[0,-1]]
        queue=[]

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    queue.append([i,j])
                elif mat[i][j]==1:
                    mat[i][j]=-1
        distance=1

        while queue:
            size=len(queue)
            for i in range(size):
                 curr=queue.pop(0)
                 for dir in dirs:
                    nr=curr[0]+dir[0]
                    nc=curr[1]+dir[1]

                    if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==-1:
                        queue.append([nr,nc])
                        mat[nr][nc]=distance
            distance=distance+1

        return mat