'''

## Problem 542: 01 matrix

## Author: Neha Doiphode
## Date:   07-27-2022

## Description:
    Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
    The distance between two adjacent cells is 1.

## Examples:
    Example 1:
        Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
        Output: [[0,0,0],[0,1,0],[0,0,0]]

    Example 2:
        Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
        Output: [[0,0,0],[0,1,0],[1,2,1]]

## Constraints:
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 104
    1 <= m * n <= 104
    mat[i][j] is either 0 or 1.
    There is at least one 0 in mat.

## Notes: THIS PROBLEM IS WRONGLY TAGGED TO THE TOPIC DFS WHEN IT CAN BE EFFICIENTLY SOLVED USING BFS.

## Time complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Space complexity: Please refer to doc-strings of respective approaches used below to solve the problem.

## Notes:
    If we choose exhaustive approach here, each node which for nearest 0 is to be found, cost would be O(m * n).
    If we have to do it for all nodes, total time complexity would be O(m * n)^2.
'''

from typing import List, Optional
from queue import Queue

def get_input():
    print("Enter the number of rows in the matrix: ", end = "")
    rows = int(input())
    print("Enter the number of columns in the matrix: ", end = "")
    columns = int(input())
    input_matrix = []
    for row in range(rows):
        l = []
        print(f"Row {row + 1}: ")
        for column in range(columns):
            inp = int(input())
            l.append(inp)
        input_matrix.append(l)

    return input_matrix


class Solution:
    def updateMatrix_BFS(self, mat: List[List[int]]) -> List[List[int]]:
        '''
        ## Time complexity : O(m * n), since we are processing m * n cells.
                                       Also, at the max m * n elements can go in the queue.
                                       For cells getting changed in 1 pass, we proces m * n cells
                                       Lets say we need to make 2 such passes to rot all oranges.
                                       So, it will be O(2 * (m * n)) ~= O(m * n), asymptotically.

        ## Space complexity: O(m * n), At the max queue size will be m * n.
        '''
        if len(mat) == 0:
            return mat

        m = len(mat)
        n = len(mat[0])

        q = Queue()
        dirs = [[0, 1],[0, -1],[1, 0],[-1, 0]]

        # Start with basic processing.
        # Convert all 1s to -1
        # if it is independent node that is if the value is 0, insert the cell into the queue
        for row in range(m):
            for column in range(n):
                if mat[row][column] == 0:
                    q.put([row, column])
                elif mat[row][column] == 1:
                    mat[row][column] = -1

        # initialize distance
        distance = 1

        # Now start the actual BFS
        while not q.empty():
            size = q.qsize()
            for _ in range(size):
                current = q.get()
                # Now check in all directions
                for dir in dirs:
                    nr = current[0] + dir[0]
                    nc = current[1] + dir[1]

                    if nr >=0 and nr < m and nc >=0 and nc < n and mat[nr][nc] == -1:
                        q.put([nr, nc])
                        mat[nr][nc] = distance

            distance += 1
        return mat


# Driver code
solution = Solution()
matrix = get_input()
print(f"Input matrix: {matrix}")
print(f"Output: Distance of the nearest 0 for each cell: {solution.updateMatrix_BFS(matrix)}")
