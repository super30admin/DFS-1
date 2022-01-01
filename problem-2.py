# putting all 1s in que will not work due to
# 0 0 0
# 1 1 1
# 1 1 1
# so put all the 0's in the queue

#O(m*n) , O(m*n)
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix==None or len(matrix) == None:
            return matrix
        
        que = deque()
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    que.append((i,j))
                else:
                    matrix[i][j]=-1
        
        dist = 1
        directions = [[0,-1],[0,1],[1,0],[-1,0]]
        while(que):
            size = len(que)
            for i in range(size):
                cur = que.popleft()
                for direction in directions:
                    r = cur[0]+direction[0]
                    c = cur[1]+direction[1]
                    if( r>=0 and r<= (len(matrix)-1) and c>=0 and c<=(len(matrix[0])-1) and matrix[r][c]==-1):
                        matrix[r][c]= dist
                        que.append((r,c))
            dist+=1
        
        return matrix
            
        