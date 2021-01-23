#Time 0(M*N)2
#Space 0(M*N)
#Solved using BFS method

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        #Base case
        if not matrix or len(matrix) == 0:
            return
        
        queue = deque()
        row = len(matrix)
        col = len(matrix[0])
        
        
        #Add all the 0's to queue and change all the elements to -1
        for i in range(row):
            for j in range(col):
                if matrix[i][j] == 0:
                    queue.append((i, j))
                    
                else:
                    matrix[i][j] = -1

                    
        dist = 1
        
        #initialize dist arr forr 4 directions
        dirArr = [[0,1],[0,-1],[-1,0],[1,0]]
        
        
        #For every element check the neighbours and add the total distance from 0
        while queue:
            
            curr = queue.popleft()
            
            for dir in dirArr:
                
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                
                #If the element is -1 add the distance of its neighbour plus 1
                if r >= 0 and r < row and c >= 0 and c < col and matrix[r][c] == -1:
                
                    matrix[r][c] =  matrix[curr[0]][curr[1]] + 1
                    
                    queue.append((r,c))
            
            dist += 1 
                    
        return matrix
                
                
                
                
            
