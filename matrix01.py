#Time Complexity :  O(mn)
#Space Complexity : O(mn)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

from collections import deque
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(mat)==0:
            return mat
        
        m = len(mat)
        n= len(mat[0])
        queue = deque()
        
        for row in range(m):
            for col in range(n):
                if mat[row][col]==0:
                    queue.append((row,col))
                else:
                    mat[row][col]= -1* mat[row][col]
                
        dirs = [[0,-1],[0,1],[1,0],[-1,0]]
        level = 1
        while(queue):
            for ele in range(len(queue)):
                poped_element = queue.popleft()
                r = poped_element[0]
                c = poped_element[1]
                for direction in dirs:
                    r1 = r+direction[0]
                    c1 = c+direction[1]
                    if (r1>=0 and r1<m) and (c1>=0 and c1<n) and mat[r1][c1]==-1:
                        mat[r1][c1]=level
                        queue.append((r1,c1))
            level+=1 
        return mat