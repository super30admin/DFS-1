class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        '''
        TC : O(M*N) 
        SC : O(M*N) // for maintaining a queue
        Approach  : 
            Apply BFS
                Take all the position having '0' value at a 0th level.
                Now explore its neighbors having 1 value and change its value to as perv their level.
                
        '''
        
        n = len(matrix)
        if n == 0: return matrix
        m= len(matrix[0])
        if m == 0: return matrix
        
        visited = [[False for i in range(m)] for j in range(n)]
        
        q = []
        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    q.append((i,j))
                    visited[i][j] = True
        c = 1
        while q:
            l = len(q)
            while l:
                x,y = q.pop(0)
                d = [[1,0],[-1,0],[0,1],[0,-1]]
                for dx,dy in d: 
                    if x+dx >= 0 and y+dy >= 0 and x+dx<n and y+dy<m and matrix[x+dx][y+dy] == 1 and visited[x+dx][y+dy] == False:
                        visited[x+dx][y+dy] = True
                        matrix[x+dx][y+dy] = c
                        q.append((x+dx,y+dy))
                l-=1
            c += 1
        return matrix