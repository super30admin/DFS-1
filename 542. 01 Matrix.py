#Time Complexity:O(m*n)
#Space Complexity:O(m*n)

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        dqRow=collections.deque()
        dqCol=collections.deque()
        dire=[[-1,0],[1,0],[0,1],[0,-1]]
        m=len(mat)
        n=len(mat[0])
        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:
                    dqRow.append(i)
                    dqCol.append(j)
                else:
                    mat[i][j]=-1
        while dqRow:
            row=dqRow.popleft()
            col=dqCol.popleft()
            for i in range(len(dire)):
                nRow=row+dire[i][0]
                nCol=col+dire[i][1]
                if (nRow>=0 and nRow<m) and (nCol>=0 and nCol<n) and mat[nRow][nCol]==-1:
                    dqRow.append(nRow)
                    dqCol.append(nCol)
                    mat[nRow][nCol]=mat[row][col]+1 
        return mat