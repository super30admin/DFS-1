# https://leetcode.com/problems/01-matrix/
# BFS Approach:
# Time Complexity- O(m * n) Space Complexity- O(m * n)
from collections import deque
class Solution:
    def updateMatrix(self, mat: list[list[int]]) -> list[list[int]]:
        # defining the directions
        self.directions = [[-1,0], [1,0], [0,-1], [0,1]]
        # finding the lenght of the matrix
        self.m = len(mat)
        self.n = len(mat[0])

        # initialise the queue
        q = deque()
        # iterate over the rows and columns
        for i in range(self.m):
            for j in range(self.n):
                # if the element is equal to the 0
                if mat[i][j] == 0:
                    # append into the deque
                    q.append([i, j])
                else:
                    # mark as unvisited cells because when the distance is 1 that time we can to update it to previous cell which is 0 + 1
                    mat[i][j] *= -1
        while q:
            # pop the left element
            curr = q.popleft()
            # iterate over the directions to find the neighbor of the current element
            for dir in self.directions:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                # check the edge cases and condition when the cell is -1
                if 0 <= r < self.m and 0 <= c < self.n and mat[r][c] == -1:
                    q.append([r,c])
                    # update the coordinate with 1 
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
        # return the matrix
        return mat

solution = Solution()
print(solution.updateMatrix([[0,0,0],[0,1,0],[0,0,0]]))