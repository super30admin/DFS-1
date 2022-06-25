'''
Solution 1: Brute Force Way
1. Iterate the matrix, chk for cell value = 1
2. If neighbors of cell are all 1, add to the queue and process the next lvl
3. If at the subsequest levels, you find 0, set the value of cell to val+lvl
4. Continue checking for other cells with value = 1

Idea: chk for cell value = 1, perform bfs. Till you dont find the 0 neighbor, continue increasing the lvl

Solution 2: Process all the non dependent cell values together
(Process all the 0's together)
1. Enque all the non independent 0's to the queue and set the lvl to 0
2. Deque the elements from the queue, override the val of cell with the lvl and enque its non-visited neighbors to the queue
3. Continue processing till my queue is not empty

Idea: chk for 0's i.e. non independents, enque to the queue
deque ele from the queue, update the cell value with it's level and enque it's non visited neigbours to the 
queue

Time Complexity : 0(mn)
Space Complexity : 0(mn)
Run on LeetCode : Yes
'''
from collections import deque
class Solution:
    
    def __init__(self):
        self.dirMatrix = [
            [0,1],          # right
            [0,-1],         # left
            [-1,0],         # top
            [1,0]           # bottom
        ]
        
        # initialize the queue
        self.queue = deque([])
    
        # visited matrix
        self.visitedMatrix = None
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        
        # initlize a visitedMatrix
        self.visitedMatrix = [[None for col in range(0,len(matrix[0]))] for row in range(0,len(matrix))]
        
        # 1. enque all the zero's to the queue
        for row in range(0,len(matrix)):
            for col in range(0,len(matrix[0])):
                
                if matrix[row][col] == 0:
                    # enque the cell
                    self.queue.append((row,col))
                    # also set the visited matrix
                    self.visitedMatrix[row][col] = True
        '''end of for loop'''
        
        # 2. iterate the queue
        lvl = 0
        while len(self.queue) != 0:
            
            # initialize the size
            size = len(self.queue)
            
            # iterate till count == size
            for count in range(0,size):
                
                # deque the ele from the queue
                ele = self.queue.popleft()
                
                # update the matrix value to lvl
                matrix[ele[0]][ele[1]] = lvl
                
                # chk for neigbours in 4-directions
                for dir in self.dirMatrix:
                    temp_r = dir[0] + ele[0]
                    temp_c = dir[1] + ele[1]
                    
                    # chk for bounds
                    if (temp_r < 0 or temp_r >= len(matrix)) or (temp_c < 0 or temp_c >= len(matrix[0])):
                        continue
                    
                    elif self.visitedMatrix[temp_r][temp_c] != True:
                        # not visited
                        # enque to the queue and mark it as visited 
                        self.queue.append((temp_r,temp_c))
                        self.visitedMatrix[temp_r][temp_c] = True
                '''end of dir matrix'''
            # update the lvl
            lvl+=1
        '''end of iterating the queue'''
        
        # update the lvl
        lvl -= 1
        
        # print the matrix
        # print(matrix)
        return matrix