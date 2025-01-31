# 1. BFS: Traverse the matrix and convert 1's to -1s and add 0s to queue as level 1 since they are independent. Now do a bfs and add level + 1 at each -1 you find at that level
# TC: O(m x n)
# SC: O(m x n)
# Yes, this worked in leetcode


from collections import deque

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return mat
        q = deque()
        lvl = 0
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append([i, j])
                else:
                    mat[i][j] = -1
        dirs = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                for dir in dirs:
                    nr = curr[0] + dir[0]
                    nc = curr[1] + dir[1]
                    if nr >= 0 and nr < len(mat) and nc >= 0 and nc < len(mat[0]) and mat[nr][nc] == -1:
                        q.append([nr, nc])
                        mat[nr][nc] = lvl + 1
            lvl += 1
        return mat