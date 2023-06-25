#Time complexity is: O(m*n)
#Space complexity is: O(m*n)
#Code ran successfully on leetcode
#No issues faced while coding

#bfs method
import collections
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        #Taking the count of rows and columns
        m=len(mat)
        n=len(mat[0])
        dir=[[0,1],[0,-1],[-1,0],[1,0]]
        #Creating a queue
        q=collections.deque()
        #if the value is 0, we will append that to queue else, we will update with -1
        for i in range(0,m):
            for j in range(0,n):
                if(mat[i][j]==0):
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        dist=1
        #Going through all the directions
        while(len(q)):
            size=len(q)
            for i in range(0,size):
                curr=q.popleft()
                for d in dir:
                    nr=curr[0]+d[0]
                    nc=curr[1]+d[1]
                    #based on the bounding conditions, we will update the matrix with distance 
                    if(nr>=0 and nc>=0 and nr<m and nc<n and mat[nr][nc]==-1):
                        mat[nr][nc]=dist
                        q.append([nr,nc])
            dist+=1
        #Finally we will be returning the matrix
        return mat      
