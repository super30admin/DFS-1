# Optimized BFS
# Time complexity : O(m*n)
# Space complexity : O(m*n)
from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # if matrix is null or len of matrix is 0, then return matrix
        if not mat or len(mat) == 0:
            return mat
        
        # find rows and columns, define the direction array and initialize an empty queue
        rows = len(mat)
        cols = len(mat[0])
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        q = deque([])
        
        # we add the index of 0 to queue and covert 1 to -1
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 1:
                    mat[i][j] = -1
                else:
                    q.append((i,j))
        # declare the distance as 0, since we start from level 0
        dist = 0
        # traverse until queue is empty
        while q:
            # maintain the size of the list to differentiate the level of the graph
            for i in range(len(q)):
                # pop the indexes from queue and check for element in directions
                row, col = q.popleft()
                for di in dirs:
                    r = row + di[0]
                    c = col + di[1]
                    # do the boundary check condition and we only increase the distance if the element is -1
                    if r >= 0 and r < rows and c >= 0 and c < cols and mat[r][c] == -1:
                        # update the element in the matrix
                        # append the element which is updated in the queue
                        mat[r][c] = dist + 1
                        q.append((r,c))
            # increase the distance after each level
            dist += 1
        # return the modified matrix
        return mat
