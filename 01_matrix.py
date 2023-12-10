# TC: O(M X N)
# SC: O(M X N)


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q=deque()
        dir1=[[0,1],[0,-1],[1,0],[-1,0]]
        m=len(mat)
        n=len(mat[0])
        for i in range(0,m):
            for j in range(0,n):
                if mat[i][j]==0:
                    q.append((i,j))
                else:
                    mat[i][j]=-1
        
        dis=1

        while q:
            size1=len(q)
            for i in range(0,size1):
                hr,hc=q.popleft()
                for i in range(0,len(dir1)):
                    r=hr+dir1[i][0]
                    c=hc+dir1[i][1]

                    if r>=0 and c>=0 and r<m and c<n and mat[r][c]==-1:
                        mat[r][c]=dis
                        q.append((r,c))
            dis+=1

        # print(q)
        # print(mat)

        return mat
        