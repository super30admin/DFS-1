# // Time Complexity : O(mn)
# // Space Complexity : O(mn)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
	# Make a state matrix for visted purpose
	# apply BFS

from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
    
        if not matrix:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        Queue = deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    Queue.append([i,j])
                else:
                     matrix[i][j] = -1
        dirs = [[0,-1],[-1,0],[1,0],[0,1]]
        
        dist = 1
        while(len(Queue) != 0):
            size = len(Queue)
            for i in range(size):
                CurrCell = Queue.popleft()
                for dire in dirs:
                    r = CurrCell[0] + dire[0]
                    c = CurrCell[1] + dire[1]
                    if r >= 0 and c >= 0 and r < m and c < n and matrix[r][c] == -1:
                        matrix[r][c] = dist
                        Queue.append([r,c])
            dist += 1
        return matrix