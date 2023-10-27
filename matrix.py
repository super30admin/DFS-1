# // Time Complexity :O(mn)
# // Space Complexity :O(mn)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we are using bfs here. We change all values with 1 in the matrix to -1 to avpid confusion. and add indezes with 0 to queue. we start with all zero values in the queue and then take its neighbouring nodes by adding them into queue. When we add them to the queue we updaet the value in matrix with its distance
# from nearest zero - which is basically the level from which we are accessingt he neighbours+1. for this - we keep track of each level when we add them to queue
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        if(len(mat)==0): 
            return mat
        q=[]
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        m=len(mat)
        n=len(mat[0])
        for i in range(m):
            for j in range(n):
                if(mat[i][j]==0):
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        dist=1
        while(len(q)>0):
            size=len(q)
            for k in range(size):
                curr = q.pop(0)
                for dir in dirs:
                    nr= curr[0]+dir[0]
                    nc= curr[1] + dir[1]
                    if(nr>=0 and nr< m and nc>=0 and nc<n and mat[nr][nc]==-1):
                        q.append([nr,nc])
                        mat[nr][nc]=dist
            dist+=1
        return mat
        