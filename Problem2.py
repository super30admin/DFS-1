# Time Complexity : O(MxN) (Where M is no of row and N is no of column)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Instead of running dfs on each 1 we can run it on each 0.
# - Chage value of 1 to some big number and add location of 0 in teh queue.
# - If neighbour is greater than current value + 1 that means, that neighbour was 1 in the original matrix. So, update it's value with minimum distance.
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
#       Initialize queue and find length of row and column
        queue = []
        maxrow = len(matrix)
        maxcol = len(matrix[0])
        
#       Initizlize direction
        drow = [-1, 1 , 0, 0]
        dcol = [0, 0, 1 , -1]
        
#       Parse through every cell
        for i in range(maxrow):
            for j in range(maxcol):
#               If the cell is 0 than we will append it to queue, because that will serve as our starting point.
                if matrix[i][j] == 0:
                    queue.append((i, j))
#               Convert all the 1 into +infinite.
                else:
                    matrix[i][j] = float("+inf")
                    
#       Run the loop untill queue is not empty
        while queue:
#           Pop the first element
            current = queue.pop(0)
            (row, col) = current
#           Try all 4 direction
            for j in range(4):
#               Update row and column according to direction
                nrow = row + drow[j]
                ncol = col + dcol[j]
#               If neighbour's row and column is not out of bound and it's value is greater than current cell value + 1 we go in. This is possible only when neighbour cell was 1.
                if 0 <= nrow and nrow < maxrow and 0 <= ncol and ncol < maxcol and matrix[nrow][ncol] > matrix[row][col] + 1:
#                   Update new row and column value to the current cell value plus 1.
                    matrix[nrow][ncol] = matrix[row][col] + 1
#                   add new row and column value into the queue
                    queue.append((nrow, ncol))  
        
#       Return the answer
        return matrix
        
                        
