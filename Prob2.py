# Time complexity : O(m*n),
# Space complexity : O(m*n)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # BFS - start with all 0s and using dist variable.
        # m=len(mat)
        # n=len(mat[0])
        # dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        # q=deque()
        # for i in range(m):
        #     for j in range(n):
        #         if mat[i][j]==0:
        #             q.append([i,j])
        #         else:
        #             mat[i][j]=-1
        # dist=1
        # while q:
        #     size=len(q)
        #     for i in range(size):
        #         r,c=q.popleft() 
        #         for dr, dc in dirs:
        #             nr = r + dr
        #             nc = c + dc
        #             if 0<=nr<m and 0<=nc<n and mat[nr][nc]==-1:
        #                 q.append((nr,nc))
        #                 mat[nr][nc]=dist
        #     dist+=1
        # return mat
        m=len(mat)
        n=len(mat[0])
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        q=deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        while q:
            size=len(q)
            for i in range(size):
                r,c=q.popleft() 
                for dr, dc in dirs:
                    nr = r + dr
                    nc = c + dc
                    if 0<=nr<m and 0<=nc<n and mat[nr][nc]==-1:
                        q.append((nr,nc))
                        mat[nr][nc]=1+mat[r][c] #instead of using dist variable, use previously calulcated index's value. 
        return mat

