# TC: O(mn)
# SC: O(mn)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m=len(mat)
        n=len(mat[0])
        dirs=[(0,1),(1,0),(0,-1),(-1,0)]
        q=deque([])
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append((i,j))
        
        while q:
            size=len(q)
            for _ in range(size):
                curr=q.popleft()
                cr=curr[0]
                cc=curr[1]

                for d in dirs:
                    nr=cr+d[0]
                    nc=cc+d[1]

                    if nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==1:
                        mat[nr][nc]=-(abs(mat[cr][cc])+mat[nr][nc])
                        q.append((nr,nc))
        
        for i in range(m):
            for j in range(n):
                mat[i][j]*=-1
        return mat

                




