'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        q = collections.deque()
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        for r in range(m):
            for c in range(n):
                if mat[r][c] == 0:
                    q.append((r,c))
                else:
                    mat[r][c] = -1
        dist = 1
        while q:
            size = len(q)
            for i in range(size):
                cr, cc = q.popleft()
                for dr, dc in dirs:
                    nr = cr + dr
                    nc = cc + dc
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = dist
                        q.append((nr, nc))
            dist += 1
        return mat
