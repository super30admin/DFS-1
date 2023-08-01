#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m=len(mat)
        n=len(mat[0])
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        q=collections.deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j]==1:
                    mat[i][j]=-1
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append([i,j])
        height=1
        while q:
            size=len(q)
            for s in range(size):
                lis=q.popleft()
                for d in directions:
                    nr=lis[0]+d[0]
                    nc=lis[1]+d[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc]=height
                        q.append([nr,nc])
            height=height+1
                
        return mat