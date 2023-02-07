# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# BFS Solution

# Iterate over the matrix and append all the 0's in the queue
# make negative all the 1's, so Initial state can be maintain

# after iterate over the queue
# pop the elements 1 by 1 and process
# iterate over the all the neighbour of that node using direction array
# if matrix value is -1, it means that node is not visited
# Change that node's value from -1 to current node's value+1
# and append that node to the queue, so we can process it's unvisited neighbour
class Solution: 
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix == None or len(matrix) == 0:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        queue = deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = -1
        

        direction = [[0,1],[0,-1],[1,0],[-1,0]]
        while queue:
                curr = queue.popleft()
                for dire in direction:
                    nr = dire[0]+curr[0]
                    nc = dire[1]+curr[1]
                    if nr >= 0 and nc >= 0 and nr < m and nc < n and matrix[nr][nc] == -1:
                        matrix[nr][nc] = matrix[curr[0]][curr[1]]+1
                        queue.append([nr,nc])
        return matrix