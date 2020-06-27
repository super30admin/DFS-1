# Time Complexity :O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        queue = deque()
        #collect all zeros and change all 1s to -1s
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = -1
        #direction matrix
        directions = [[0,1],[0,-1],[1,0],[-1,0]]
        #all distance zero done so we start from distance one
        dist = 1
        #start going through the queue
        while queue:
            #safe size to use same queue
            size = len(queue)
            #loop through each level
            for i in range(size):
                #get from queue
                curr = queue.popleft()
                #check all directions
                for direction in directions:
                    r = direction[0] + curr[0]
                    c = direction[1] + curr[1]
                    #if in bound and == -1 change -1 to distance and append the value
                    if r >=0 and r <len(matrix) and c >=0 and c < len(matrix[0]) and matrix[r][c ] == -1:
                        matrix[r][c ] = dist
                        queue.append([r,c])
            #after finishing level add 1 to distance
            dist+=1
        #return matrix
        return matrix