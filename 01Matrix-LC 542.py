# BFS Solution using size of the queue
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)
class Solution:
    def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
        if mat == None or len(mat) == 0:
            return [[]]
        
        m = len(mat)
        n = len(mat[0])
        
        q = []
        
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        
        # Append the 0's in the queue and all the otehr elements to -1 first
        for i in range (m):
            for j in range (n):
                if mat[i][j] == 0:
                    q.append([i, j])
                
                else:
                    mat[i][j] = -1
                    
        
        # Maintain a distance variable, whose value will be same as the level we are, in the queue
        dist = 1
        
        while q:
            size = len(q)
            for i in range(size):
                curr = q.pop(0)
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    
                    # If conditions are satisfied, lookup for -1, append the coordinates, and change the value to distance (or level) val
                    if (nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1):
                        q.append([nr, nc])
                        mat[nr][nc] = dist
                        
            # Increment dist after each BFS traversal is done            
            dist += 1
            
        
        
        return mat
        
        



# BFS Solution without using size of the queue
# Time Complexity = O(m * n)
# Space Complexity = O(m * n)
class Solution:
    def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
        if mat == None or len(mat) == 0:
            return [[]]
        
        m = len(mat)
        n = len(mat[0])
        
        q = []
        
        dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        
        for i in range (m):
            for j in range (n):
                if mat[i][j] == 0:
                    q.append([i, j])
                
                else:
                    mat[i][j] = -1
        
        
        while q:
            curr = q.pop(0)
            for d in dirs:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]
                
                # Lookup for -1 and change the val of the cell with 1 + val of cell wer are comparing with (curr cell)
                if (nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1):
                    q.append([nr, nc])
                    mat[nr][nc] = 1 + mat[curr[0]][curr[1]]
                        
        
        return mat