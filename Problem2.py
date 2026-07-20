# Problem2 (https://leetcode.com/problems/01-matrix/)
# Time Complexity: O(m x n)
# Space Complexity: O(m x n)
# Approach:
# We start BFS from every 0 at the same time instead of searching outward from each 1.
# We mark all 1s as -1 to show they are not filled yet, then spread outward wave by wave, stamping each wave with the current distance.
# Because BFS reaches a cell by its shortest path first, the first time a cell gets filled is its true distance to the nearest 0.

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        self.directions = [[0,1],[0,-1],[1,0],[-1,0]]   # the four moves: right, left, down, up 
        self.m = len(mat)                               # number of rows in the grid
        self.n = len(mat[0])                            # number of columns in the grid

        queue = deque()                                 # holds the cells we still need to spread out from

        for i in range(self.m):                         # walk every cell once to set things up
            for j in range(self.n):
                if mat[i][j]==0:                        # every 0 is a starting point for the spread
                    queue.append([i,j])                 # so put it in the queue right away
                else:
                    mat[i][j] *=-1                      # turn each 1 into -1 to mark it as not filled yet

        distance = 1                                    # the 0s are distance 0, so the first wave we fill is one step out
        while queue:                                    # keep going while there are cells left to spread from
            size = len(queue)                           # snapshot the count so we handle only this wave, not cells added during it
            for x in range(size):                       # process exactly the cells that were in the queue when the wave started
                current = queue.popleft()               # take one cell off the front, this is the cell we spread from
                for dir in self.directions:             # look at its four neighbors
                    row = dir[0]+current[0]             # neighbor's row, current[0] is the current cell's row
                    column = dir[1]+current[1]          # neighbor's column, current[1] is the current cell's column

                    # keep the neighbor only if it is on the grid and is still an unfilled 1
                    if 0 <= row < self.m and 0 <= column < self.n and mat[row][column]==-1:
                        queue.append([row,column])      # schedule it so we spread from it in the next wave
                        mat[row][column] = distance     # write its answer, which also clears the -1 so nobody fills it twice
            distance +=1                                # one full wave done, so the next wave is one step farther out
        return mat                                      # queue is empty, every cell has its distance
            