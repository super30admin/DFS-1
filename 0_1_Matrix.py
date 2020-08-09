# Leetcode 542. 01 Matrix

# Time Complexity :  O(m X n) where m X n is the size of the grid

# Space Complexity : O(m X n) where m X n is the size of the grid that can be the worst case entry in Q

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Use Q to store initial level i.e all the indices with value as 0 and mark the rest as -1.
# For each entry in queue at that level the next neighbour in adjacent cells becomes the next level.
# The first level of neighbours are at distance 1. If the neighbours are -1 then change them with distance.
# After every level increment distance by 1 so that 2nd level is at dist 2 and so on. Return after all
# levels are processed and q is empty.

# Your code here along with comments explaining your approach

from collections import deque

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or len(matrix) == 0:
            return matrix
        q = deque()
        # appending 0's to queue and marking 1's as -1 to differentiate betweeen visited levels
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    q.append((i, j))
                else:
                    matrix[i][j] = -1
        dirs = {(0, 1), (0, -1), (1, 0), (-1, 0)}
        dist = 1
        while q:
            size = len(q)
            for _ in range(size):
                i, j = q.popleft()
                for direc in dirs:
                    r = direc[0] + i
                    c = direc[1] + j
                    # If coord's are valid & value @ that point is -1 change to dist at that level
                    if len(matrix) > r >= 0 and len(matrix[0]) > c >= 0 and matrix[r][c] == -1:
                        matrix[r][c] = dist
                        # Append the value to q for next level
                        q.append((r, c))
            # increment dist after every level to change the dist from 0 in subsequent levels
            dist += 1

        return matrix
