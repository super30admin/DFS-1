# Problem 2 :  01 Matrix
# Time Complexity : O(m*n)
# Space Complexity : O(m*n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        # get the row and column length
        rows, cols = len(matrix), len(matrix[0])
        # intialize queue
        queue = deque()

        # Marking the cell with value as 1 to -1 and add cell whose value as 0 
        # Starting from 0 to calculate distance
        for r in range(rows):
            for c in range(cols):
                if matrix[r][c] == 0:
                    queue.append((r, c))
                else:
                    matrix[r][c] = -1

        # Setting direction array 
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        # loop until queue is not empty
        while queue:
            row, col = queue.popleft()
            # visting the neighbours
            for dr, dc in directions:
                new_row = row + dr
                new_col = col + dc
                # checking boundary condition and also checking if the value is of the cell is -1
                if 0 <= new_row < rows and 0 <= new_col < cols and matrix[new_row][new_col] == -1:
                    # updating the distance value in matrix
                    matrix[new_row][new_col] = matrix[row][col] + 1
                    # appending that neighbouring cell in the queue
                    queue.append((new_row, new_col))
        return matrix