"""
// Time Complexity : O(m*n) 
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
Algorithm explanation
BFS
- Initial conf - Update the 1s to inf and add the values with 0 to the queue
- Idea is to run BFS on 0 in the matrix and update the value in place
    based on the current distance and next element distance + 1
"""

from collections import deque
class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])

        q = deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append((i,j))
                else:
                    matrix[i][j] = float("inf")

        #Having all thepositions of 0 in the matrix, can apply BFS now
        # new_q = deque()
        # distance = 1

        directions = [[1,0],[-1,0],[0,1],[0,-1]] #[[i+1,j],[i-1,j],[i,j+1],[i,j-1]]

        while q:
            curr = q.popleft()
            #print("curr",curr)

            # level_ans = []
            # N = len(q)

            for d in directions:
                i = curr[0] + d[0]
                j = curr[1] + d[1]
                
                #print("i j",i,j)

                #if new cell is out of bounds or closer to another 0, stop bfs
                if i <0 or i>=m or j < 0 or j>=n or matrix[i][j] <= matrix[curr[0]][curr[1]] + 1:
                    continue

                q.append((i,j))
                matrix[i][j] = matrix[curr[0]][curr[1]]+1
        return matrix