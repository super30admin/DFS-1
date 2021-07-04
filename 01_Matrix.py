"""
Time Complexity : updateMatrix_BFS1 - O(mn)
                  updateMatrix_BFS2 - O(mn)
Space Complexity : updateMatrix_BFS1 - O(mn)
                   updateMatrix_BFS2 - O(mn)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : none
"""

from queue import Queue
from math import inf

class Solution:
    def updateMatrix_BFS1(self, matrix):
        m = len(matrix)
        if not matrix or m == 0:
            return [[]]
        n = len(matrix[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = Queue()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.put([i, j])
                    
        dist = 1
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                neighbor = q.get()
                for d in dirs:
                    r = neighbor[0] + d[0]
                    c = neighbor[1] + d[1]
                    if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == 1:
                        matrix[r][c] = -1 * dist
                        q.put([r, c])
                    
            dist += 1
            
        for i in range(m):
            for j in range(n):
                if matrix[i][j] != 0:
                    matrix[i][j] *= -1
        
        return matrix
    
    def updateMatrix_BFS2(self, matrix):
        m = len(matrix)
        if not matrix or m == 0:
            return [[]]
        n = len(matrix[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = Queue()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.put([i, j])
                if matrix[i][j] == 1:
                    matrix[i][j] = inf
        
        while not q.empty():
            neighbor = q.get()
            for d in dirs:
                r = neighbor[0] + d[0]
                c = neighbor[1] + d[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] > matrix[neighbor[0]][neighbor[1]] + 1:
                    matrix[r][c] = matrix[neighbor[0]][neighbor[1]] + 1
                    q.put([r, c])
        
        return matrix
                
            
            