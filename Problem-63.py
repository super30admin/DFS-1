# leet code - 01 matrix -542 - https://leetcode.com/problems/01-matrix/
#Time complexity -o(M2 *N2)
#space complexity=0(1)

#Approach - BFS approach it's same like rotten oranges concept.
from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        #edge case
        if not matrix: return matrix
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j]!=0:
                    matrix[i][j]=self.bfs(matrix,i,j)
        return matrix
        
    def bfs(self,matrix,i,j):
        queue=deque()
        queue.append((i,j))
        dir=[(0,1),(1,0),(0,-1),(-1,0)]
        dist=0
        while queue:
            size=len(queue)
            for i in range(size):
                curr=queue.popleft()
                for (x,y) in dir:
                    new_r=x+curr[0]
                    new_c=y+curr[1]
                    if (0<=new_r<len(matrix) and 0<=new_c<len(matrix[0])):
                        if matrix[new_r][new_c]==0:
                            return dist+1
                        else:
                            queue.append((new_r,new_c))
                        
               
            dist=dist+1
                
        return -1
        