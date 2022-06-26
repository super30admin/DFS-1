"""
Leetcode - https://leetcode.com/problems/01-matrix/ (submitted)
TC- O(N), SC- O(N) BFS
Challenge- Coming up with O(N) solution
Lecture-https://youtu.be/L8y3-JZNEhM
FAQ-
Can you use DFS? Yes, but it will not be the most optimal solutions since DFS is ANY (BFS is ALL), it will start with
first zero and calculate distance for each 1's from it, next dfs called from 2nd zero will have to take minimum of
previous and the current distance, which will make the solution O(N^2) brute force.

Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.

Example 1:
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Example 2:
Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
mat[i][j] is either 0 or 1.
There is at least one 0 in mat.
"""

from collections import deque


class Solution:
    """
    Ideation-Brute force BFS O(N^2) time and O(N) space
    For every 1 call the BFS and find the nearest zero.
    """

    def updateMatrix1(self, mat):
        m, n = len(mat), len(mat[0])
        self.dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = self.bfs(mat, i, j, m, n)

        return mat

    def bfs(self, mat, i, j, m, n):
        q = deque()
        q.append([i, j])
        distance = 0
        while q:
            [r, c] = q.popleft()
            if mat[r][c] == 0:
                return distance
            for dir in self.dirs:
                nr, nc = i + dir[0], j + dir[1]
                if 0 <= nr < m and 0 <= nc < n:
                    q.append([nr, nc])
            distance += 1
        return distance

    """
    Ideation- BFS O(N) time and O(N) space
    
    If we start processing BFS from all 1's looking for 0's, we will have to pick the minimum of nearest distance of 
    zero from all its neighbors and their minimums, which will make the TC O(N^2). 
    To avoid that, we can instead start processing from all 0's and find nearest 1's, doing so we can guarantee that all
    1's processed with already be the nearest distance from their 0's. This will change the game because now nearest
    will come to us than us going after it.
    
    Now, all we have to do is, whatever value is from the parent (already nearest to its 0), we just add 1 to it.
    """

    def updateMatrix(self, mat):
        m, n = len(mat), len(mat[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    # to distinguish unvisited nodes from distance
                    mat[i][j] = -1

        distance = 0
        while q:
            # can also be done without size (levels), we can do mat[nr][nc] = mat[r][c] + 1, since we will be adding
            # + 1 from its parents distance
            size = len(q)
            for _ in range(size):
                [r, c] = q.popleft()
                for dir in dirs:
                    nr, nc = r + dir[0], c + dir[1]
                    if 0 <= nr < m and 0 <= nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = distance + 1
                        q.append([nr, nc])
            #  increase distance after each level
            distance += 1

        return mat


inp = [[0, 0, 0], [0, 1, 0], [1, 1, 1], [1, 1, 1]]
result = Solution().updateMatrix(inp)
print(result)
