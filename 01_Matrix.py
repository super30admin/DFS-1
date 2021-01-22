#Time: O(mxn)
#space: O(mxn)
#leetcode: yes


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if (matrix==[] or len(matrix)==0):
            return []
        q=deque()
        row=len(matrix)
        column=len(matrix[0])
        dist=1
        for i in range(row):
            for j in range(column):
                if(matrix[i][j]==0):
                    q.append([i,j])
                else:
                    matrix[i][j]=-1   
        direct=[[0,1],[1,0],[-1,0],[0,-1]]
        while(q!=deque()):
            for v in range(len(q)):
                r,c=q.popleft()
                for d in direct:
                    i=r+d[0]
                    j=c+d[1]
                    if(i>=0 and i<row and j>=0 and j<column and matrix[i][j]==-1):
                        matrix[i][j]=dist
                        q.append([i,j])
            dist+=1
        return matrix
            