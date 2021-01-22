class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        '''
        Time Complexity: O(mn)
        Space Complexity: O(mn)
        '''
        q = deque([])
        for i in range(0,len(matrix)):
            for j in range(0,len(matrix[0])):
                if(matrix[i][j]==0):
                    q.append((i,j))
                elif(matrix[i][j]==1):
                    matrix[i][j] = -1
        directions = [(0,1),(0,-1),(1,0),(-1,0)]
        
        while(len(q)>0):
            e = q.popleft()
            for i in directions:
                r = e[0] + i[0]
                c = e[1] + i[1]
                if(r>=0 and c>=0 and r<len(matrix) and c<len(matrix[0]) and matrix[r][c]==-1):
                    matrix[r][c] = matrix[e[0]][e[1]] + 1
                    q.append((r,c))
        
        return matrix
