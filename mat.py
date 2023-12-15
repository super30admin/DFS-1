class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        row = len(mat)
        col = len(mat[0])
        q=[]
        seen=set()
        temp = [[0]*col for _ in range(row)]

        for i in range(row):
            for j in range(col):
                if mat[i][j]==0:
                    q.append((i,j))
                    seen.add((i,j))
        dist = 1
        while q:
            size = len(q)
            for i in range(size):
                t= q.pop(0)
                r=t[0]
                c=t[1]
                if r>=1 and (r-1,c) not in seen and mat[r-1][c]==1:
                    temp[r-1][c]=dist
                    seen.add((r-1,c))
                    q.append((r-1,c))
                if r<row-1 and (r+1,c) not in seen and mat[r+1][c]==1:
                    temp[r+1][c]=dist
                    seen.add((r+1,c))
                    q.append((r+1,c))

                if c>=1 and (r,c-1) not in seen and mat[r][c-1]==1:
                    temp[r][c-1]=dist
                    seen.add((r,c-1))
                    q.append((r,c-1))

                if c<col-1 and (r,c+1) not in seen and mat[r][c+1]==1:
                    temp[r][c+1]=dist
                    seen.add((r,c+1))
                    q.append((r,c+1))

            dist+=1

        return temp
        



                

        