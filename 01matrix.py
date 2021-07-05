class Solution:
    def updateMatrixTwo(self, matrix: List[List[int]]) -> List[List[int]]:
        q = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.insert(0, (i,j))
                else:
                    matrix[i][j] = float('inf')
        directs = [(0,-1),(0,1),(-1,0),(1,0)]          
        while q:
            curr = q.pop()
            for direct in directs:
                r = curr[0] + direct[0]
                c = curr[1] + direct[1]
                if r >= 0 and c >= 0 and r < len(matrix) and c < len(matrix[0]) and matrix[r][c] > matrix[curr[0]][curr[1]] + 1:
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
                    q.insert(0,(r,c))
        return matrix