"""
Time Complexity : O(m*n)- as will be visiting all the nodes
Space Complexity : O(m*n)- size of queue
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach
We will be doing it with BFS as DFS will add a lot of complexity. I iterated through the matrix and added indices
of all the 0s in the queue and converted all the 1s to -1. Then started traversing throught hte queue.
Once we take out the value from the queue, we look at all of its neighbours, if any is -1, we hange its value
by adding 1 to value of current node and add it to the queue.

"""
from collections import deque


class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        q = deque()
        m = len(matrix)
        n = len(matrix[0])
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append((i, j))
                else:
                    matrix[i][j] = -1
        dirs = [(0, -1), (-1, 0), (0, 1), (1, 0)]
        while q:
            curr = q.popleft()
            for d in dirs:
                r = d[0]+curr[0]
                c = d[1]+curr[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                    matrix[r][c] = matrix[curr[0]][curr[1]]+1
                    q.append((r, c))
        return matrix
