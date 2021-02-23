// Time Complexity :(n*m)
// Space Complexity :(n*m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or not matrix[0] or not len(matrix) or not len(matrix[0]):
            return matrix
        
        n=len(matrix)
        m=len(matrix[0])
        
        queue=deque()
            
        for i in range(n):      //traverse whole matrix and append the index into the queue when value of matrix at certain index==0 else make value as Infinity
            for j in range(m):
                if matrix[i][j]==0:
                    queue.append((i,j))
                else:
                    matrix[i][j]=float('inf')

        dirs=[[-1,0],[1,0],[0,-1],[0,1]]
        
        while len(queue)!=0:    //traverse till the queue till it becomes empty
            front=queue.popleft()   //pop the first index from queue
            
            for dir in dirs:        //check for 
                i=dir[0]+front[0]
                j=dir[1]+front[1]
                
                if i>=0 and j>=0 and i<n and j<m and matrix[front[0]][front[1]]+1 < matrix[i][j]:   //if current index exist and its value its value is greater than the new calculated value then append the new index into the queue and update the value 
                    queue.append((i,j))
                    matrix[i][j]=1+matrix[front[0]][front[1]]
        
        return matrix
        
