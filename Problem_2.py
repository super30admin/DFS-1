"""
Problem : 2

Time Complexity : O(m*n)
Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Appending all the 0's inside the queue so at to mark all of its neighbors are 1
then appending all the neighbors having value as 1, and marking their neighbors as 2
and repeating the process until all the numbers are processed

"""

# 01 Matrix

# Approach - 1
# BFS

class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        m=len(mat)
        n=len(mat[0])
        # res=[[float('inf') for _ in range(m)] for _ in range(n)]
        
        directions=[[1,0],[0,-1],[-1,0],[0,1]]

        q=collections.deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j]==0:

                    q.append((i,j))
                else:
                    mat[i][j]=-1
                    
        while q:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                for dirs in directions:
                    r=dirs[0]+curr[0]
                    c=dirs[1]+curr[1]
                    if r>=0 and r<m and c>=0 and c<n and mat[r][c]==-1:
                        mat[r][c]=mat[curr[0]][curr[1]]+1
                        q.append((r,c))
        return mat