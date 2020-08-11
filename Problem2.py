#Time complexity: O(m*n)
#Space complexity: O(m*n)
#Works on leetcode: yes
#Approach: We change every 1 to inf and add all the location of zeroes to a queue. Now while the queue lasts, we pop location
#of zero from the queue and check if the neighbouring cells are within bounds and the new cell was previously 1(now inf).
#If it is, we add this cell location to queue and set the value of this neighbouring cell as popped cell value+1
import collections
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        queue, m,n = collections.deque([]), len(matrix), len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j]!=0:
                    matrix[i][j]= float('inf')
                else:
                    queue.append((i,j))
        while queue:
            i,j = queue.popleft()
            for r,c in {(i,j-1),(i,j+1),(i-1,j),(i+1,j)}:
                new = matrix[i][j]+1
                if 0<=r<m and 0<=c<n and matrix[r][c]>new:
                    matrix[r][c]=new
                    queue.append((r,c))
        return matrix