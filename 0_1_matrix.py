# O(M*N) TIME AND SPACE WHERE M IS NO.OF ROWS AND N IS NO.OF COLUMNS
class Solution():
    def updateMatrix(self, matrix):
        queue = []
        for i in range(0, len(matrix)):
            for j in range(0, len(matrix[0])):
                if matrix[i][j] == 1:
                    matrix[i][j] = float('inf')
                elif matrix[i][j] == 0:
                    queue.append((i,j))
        while queue:
            front = queue.pop(0)
            r = front[0]
            c = front[1]
            for d in [[r,c+1],[r+1,c],[r,c-1],[r-1,c]]:
                row = d[0]
                col = d[1]
                if row >= 0 and row < len(matrix) and col >=0 and col < len(matrix[0]) and matrix[r][c] + 1 < matrix[row][col]:
                    matrix[row][col] = matrix[r][c] + 1
                    queue.append((row,col))
        
        return matrix