'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 542. 01 Matrix

# Given an m x n binary matrix mat, return the distance of 
# the nearest 0 for each cell.

# The distance between two adjacent cells is 1.

#-----------------
# Time Complexity: 
#-----------------
# O(M * N) - Need to process M rows and N columns in every case
#------------------
# Space Complexity: 
#------------------
# O(M * N): Max size of queue is M*N elements

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

import math
import collections
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        if rows == 0:
            return mat
        
        cols = len(mat[0])
        
        distance = [[math.inf] * cols for j in range(rows)]
        queue = collections.deque()
        for i in range(rows):
            for j in range(cols):
                if mat[i][j] == 0:
                    distance[i][j] = 0
                    queue.append([i, j])
                    
        dirs = [[-1,0], [0,1], [1,0], [0,-1]]
        
        while len(queue) > 0:
            curr_r, curr_c = queue.popleft()
            for direction in dirs:
                neighbor_r = curr_r + direction[0]
                neighbor_c = curr_c + direction[1]
                if (neighbor_r >= 0 and neighbor_r < rows \
                and neighbor_c >= 0 and neighbor_c < cols):
                    if distance[neighbor_r][neighbor_c] > distance[curr_r][curr_c] + 1:
                        distance[neighbor_r][neighbor_c] = distance[curr_r][curr_c] + 1
                        queue.append([neighbor_r, neighbor_c])
        
        return distance