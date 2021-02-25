"""
542. 01 Matrix
Time Complexity - O((No of zeros)*(n*m)) 
Space Complexity - O(n*m) n*m worst case that all elements are zeros
Verify if input is valid.Used a queue that stores co-ordinates of all zero elements in given matrix and make all 1 element as Infinity
Until queue is not empty run a loop that will update distance as per its adjacent element if adjacent element value is greater than center co-ordinate + 1 then update distance
"""
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix == None  or len(matrix) == 0 or matrix[0] == None or len(matrix[0]) == 0:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        queue = []
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append((i,j))
                else:
                    matrix[i][j] = float("inf")
        
        dirs = ((-1,0),(0,1),(1,0),(0,-1))
        while(len(queue) != 0):
            front = queue.pop(0)
            for dir in dirs:
                r = dir[0] + front[0]
                c = dir[1] + front[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[front[0]][front[1]]+1 < matrix[r][c]:
                    queue.append((r,c))
                    matrix[r][c] = matrix[front[0]][front[1]] + 1
        
        return matrix
                
        