# Time - O(mn)
# Space - O(mn)
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        q = deque()
        
        directions = [[0,1], [0,-1], [1,0], [-1,0]]
        
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                
                if mat[i][j] == 0:
                    
                    q.append([i, j])
                
                if mat[i][j] == 1:
                    
                    mat[i][j] = -1
        
        distance = 1
        while(len(q) != 0):

            size = len(q)
            
            for i in range(size):
                
                curr = q.popleft()
                
                for direction in directions:
                    
                    row = curr[0] + direction[0]
                    col = curr[1] + direction[1]
                    
                    if (row >=0 and row<len(mat)  and col >=0 and col <len(mat[0]) and mat[row][col] == -1):           
                        mat[row][col] = distance
                        q.append([row, col])
            
            distance = distance + 1
    
        return mat
        
                    
                
                