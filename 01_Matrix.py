class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix:
            return 
        
        queue = deque()
        count = 0
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                else:
                    matrix[i][j] = -1
                    count +=1
        if count== 0:
            return matrix
        dir_array = [(1,0),(0,1),(-1,0),(0,-1)]
        while queue:
            element = queue.popleft()
            r = element[0]
            c = element[1]
            for i in dir_array:
                row = r+i[0]  
                column = c +i[1]
                if 0<=row<m and 0<= column < n and matrix[row][column]==-1:
                    matrix[row][column] = matrix[r][c] + 1
                    queue.append((row,column))
                    
        return  matrix           
        
