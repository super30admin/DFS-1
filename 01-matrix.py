# Time complexity: O(m * n)
# Space compleity: O(m * n)

# The code sucessfully ran on Leetcode

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if mat == None or len(mat) == 0:    return []
        
        q = []
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        m = len(mat)
        n = len(mat[0])
        
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i, j])
                    
                else:
                    mat[i][j] = -1
                    
        distance = 1
        
        while q:
            size = len(q)
            
            for i in range(size):
                curr = q.pop(0)
                
                for d in dirs:
                    nr = curr[0] + d[0]
                    nc = curr[1] + d[1]
                    
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = distance
                        q.append([nr, nc])
                        
            distance += 1
            
        return mat
            