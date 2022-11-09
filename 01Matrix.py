class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        queue = collections.deque()
        
        row = len(mat)
        col = len(mat[0])
        
        for i in range(row):
            for j in range(col):
                
                if  mat[i][j] == 0:
                    queue.append([i, j])
                else:
                    mat[i][j] = -1
        
        directions = [[0,1], [0,-1], [-1,0], [1,0]]
        distance = 1
        while queue:
            size = len(queue)
            
            for i in range(size):
                coords = queue.popleft()
                for direction in directions:
                    nr = coords[0] + direction[0]
                    nc = coords[1] + direction[1]

                    if (nr >= 0 and nc >= 0 and nr < row and nc < col and mat[nr][nc] == -1):
                        mat[nr][nc] = distance
                        queue.append([nr,nc])
            distance += 1
            
        return mat
    
    # TIME COMPLEXITY: O(M x N).
    # SPACE COMPLEXITY: O(M x N) in case of all 0's and one 1 everything will go inside the queue.
                    