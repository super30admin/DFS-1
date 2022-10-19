class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        if (len(mat)==0):
            return mat
        m = len(mat)
        n=len(mat[0])
        q=[]
        di=[[-1,0],[0,-1],[0,1],[1,0]]
        for i in range(m):
            for j in range(n):
                
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        distance=1
        while q:
            size=len(q)
            for s in range(size):
                curr=q.pop(0)
                for d in di:
                    nr=curr[0]+d[0]
                    nc=curr[1]+d[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]== -1:
                        mat[nr][nc]=distance
                        q.append([nr,nc])
            distance+=1
        return mat