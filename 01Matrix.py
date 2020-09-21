# // Time Complexity : O(n*m)
# // Space Complexity : O(n*m)
# // Did this code successfully run on Leetcode :Yes 
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        #base case
        if len(matrix) == 0 or matrix == None:
            return matrix

        n = len(matrix)
        m= len(matrix[0])
        
        # start filling queue with root indices(value is 0) and change 1s to inf
        queue = []
        for i in range(n):
            for j in range(m ):
                if matrix[i][j] == 1:
                    matrix[i][j] = float('inf')
                elif matrix[i][j] == 0:
                    queue.append((i,j))

        #maintain directions array
        dirs = [[-1,0], [1,0], [0,1], [0,-1]]

        #move in four directions from every element in queue and keep adding 1 to the value if new distance from 0 is more optimum
        while queue:
            
            front = queue.pop(0)
            i = front[0]
            j = front[1]

            for d in dirs:
                row = i + d[0]
                col = j + d[1]
                if row >= 0 and row < len(matrix) and col >=0 and col < len(matrix[0]) and matrix[i][j] + 1 < matrix[row][col]:
                    matrix[row][col] = matrix[i][j] + 1
                    queue.append((row,col))

        return matrix