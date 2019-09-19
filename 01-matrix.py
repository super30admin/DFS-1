'''
Time Complexity : O(m*n) 
Space Complexity : O(m*n)
Did this code successfully run on Leetcode : Yes

Any problem you faced while coding this :
I approached this code similar to the flood fill algorithm, so I was able to understand the approach.
Initially I approached with DFS on paper, but it was becoming more complex, than a single BFS.
The thought process was from class on 18 September 2Point0August class from gates and walls question
 on leet code.

Your code here along with comments explaining your approach:

Algorithm
Approach using explicit stack instead of recursion

1.Instead of searching from '1' for the nearest 0 we start our search from `0` for nearest `1` cell
2. We add all `0` cells in a queue. 
3. We invoke BFS from each cell added in the queue and check the distance whether the difference is greater 
than 1, because 1 is the min distance for a cell which is not in the queue.
4. This question tooke 2 hrs as I already solved this one before, so I was able to recapitulate it. 
'''

from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        self.R=len(matrix)
        self.C= len(matrix[0]) if self.R!=0 else 0
        
        dist = [ [float('inf')]*self.C for _ in range(self.R)]
        queue = deque()
        
        for i in range(self.R):
            for j in range(self.C):
                if matrix[i][j] == 0:
                    dist[i][j] = 0
                    queue.append((i,j))
        
        while queue:
            x,y = queue.popleft()
            neighbours = self.nextCoordinates(x,y)
            for neighbour in neighbours:
                dx,dy = neighbour
                if dist[dx][dy]-dist[x][y]>1:
                    dist[dx][dy] = dist[x][y]+1
                    queue.append((dx,dy))
        return dist
        
                  
    def nextCoordinates(self,r,c):
        nextPositions = ((r,c-1),(r,c+1),(r-1,c),(r+1,c))
        for position in nextPositions:
            row,col = position
            if 0<=row<self.R and 0<=col<self.C:
                yield position
        