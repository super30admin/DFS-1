'''
Time Complexity: O(m * n)
Space Complexity: O(m * n)
Run on Leetcode: YES
'''
from ast import List
from collections import deque


class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        if not mat:
            return mat
        m = len(mat)
        n = len(mat[0])
        direction = [[-1,0], [0,1], [1,0], [0,-1]]
        queue = deque()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1 * mat[i][j]
        count = 1
        while(len(queue) != 0):
            size = len(queue)
            for _ in range(size):
                curr = queue.popleft()
                for direct in direction:
                    nr = curr[0] + direct[0]
                    nc = curr[1] + direct[1]
                    if nr >= 0 and nr < m and nc >= 0 and nc < n and mat[nr][nc] == -1:
                        mat[nr][nc] = count
                        queue.append([nr,nc])
            count += 1

        return mat