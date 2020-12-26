# Approach: BFS 

# In this apporach we will move forward level-wise. So at first we will add every position 0 found in a queue and convert every 1 found to -1. Now we perform BFS on all the from all the positions inside the queue and add only those positions that have -1 has as their neighbour into the queue and convert it into 1 to mark it visisted. Also for every level we will maintain a variable that will maintain the value of level/distance. So after doing a bfs over every position found in the queue at a time we will increment the variable.

# Time complextiy: O(m*n); n= no of rows and m = no of cols
# Space complextiy: O(m*n);  n= no of rows and m = no of cols
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix == None or len(matrix) == 0:
            return matrix
        
        zeroes = []
        m = len(matrix) 
        n = len(matrix[0])
        queue = []
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    matrix[i][j] = -1
                else:
                    queue.append([i,j])
                    
        dirs = [[1,0],[0,1],[-1,0], [0,-1]]
        dist = 1

        while len(queue) != 0:
            size = len(queue)
            for i in range(size):
                curr = queue.pop(0)
                for d in dirs:
                    row = curr[0] + d[0]
                    col = curr[1] + d[1]
                    if row>=0 and col >= 0 and row < m and col < n and matrix[row][col] == -1:
                        matrix[row][col] = dist
                        queue.append([row,col])
            dist += 1
            
        return matrix
