# Time Complexity - O(mn)
# Space Complexity - O(mn)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = deque()
        m = len(mat)
        n = len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        level = 0
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                if mat[curr[0]][curr[1]]==-1:
                    mat[curr[0]][curr[1]]=level
                for dir1 in dirs:
                    nr = curr[0]+dir1[0]
                    nc = curr[1]+dir1[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1:
                        q.append((nr,nc))
            level = level+1
        return mat
