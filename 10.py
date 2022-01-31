# Time Complexity o(m*n)
# Space Complexitt o(m*n)

# Using BFS to traverse through each level by considering the O's as independent nodes

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        qu = collections.deque()
        dirs = [[1,0],[0,1],[-1,0],[0,-1]]
        if mat == None or len(mat) == 0:
            return matrix
        
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                
                if mat[i][j] == 0:                  
                    qu.append([i,j])
                if mat[i][j] == 1:
                    mat[i][j] = -1
        
        dist = 1
       
        while(len(qu)>0):
            
            size = len(qu)
            
            for i in range(size):
                curr = qu.popleft()
                print(curr)
                for a in dirs:
                    
                    nr = curr[0] + a[0]
                    nc = curr[1] + a[1]
                 
                    if nr >=0 and nc >=0 and nr <len(mat) and nc < len(mat[0]) and mat[nr][nc] == -1:
                        qu.append([nr,nc])
                      
                        mat[nr][nc] = dist
            dist = dist + 1
            
        return mat
                    
                
                
                    
        
        