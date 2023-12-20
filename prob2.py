# Time Complexity : O(M*N) as we go through entire matrix
# Space Complexity : O(M*N) similar to rotting oranges, 
# in worst case all element points in queue
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach

# using bfs put all zeros in queue and update the cells with -1 to
#  the current cell value + 1


from collections import deque
class Solution:

    def updateMatrix(self, mat):

        if len(mat) == 0 or mat is None:
            return mat
        
        q = deque()
        m, n = len(mat), len(mat[0])

        for i in range(m):
            for j in range(n):

                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    mat[i][j] = -1
        
        dirs = [[0, 1], [0, -1], [-1, 0], [1, 0]]

        while len(q) != 0:
            curr = q.popleft()
            for d in dirs:
                r = curr[0] + d[0]
                c = curr[1] + d[1]
                if  r >= 0 and c >= 0 and r < m and c < n and mat[r][c] == -1:
                    mat[r][c] = mat[curr[0]][curr[1]] + 1
                    q.append([r, c])
        return mat