"""
542. 01 Matrix

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.


Time = O(m*n) where m = num of rows, n= num of cols
space = O(m*n) where m = num of rows, n= num of cols
Successfully excecuted on leetcode


Approach --
1. BFS + Queue
2. Iterate over the matrix, and where cell value = 0 append it to the queue; else if cell value = 1 -> convert it to -1
3. Explore all the neighbors of the cell with 0 value and update the cell value with curr_value + 1
4. If the cell value = -1 and one of it's neighbour is 0, then new cell value would be curr_value+1

"""


class Solution:

    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        q = collections.deque([])
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                        q.append([i,j])
                else:
                    matrix[i][j] = -1
                    
        #dist = 1
        while q:            
            i,j = q.popleft()
            for r,c in [(i-1,j),(i,j-1),(i+1,j),(i,j+1)]:
                if 0<=r<m and 0<=c<n and matrix[r][c] == -1:
                    matrix[r][c] = matrix[i][j] + 1
                    q.append([r,c])

        return matrix