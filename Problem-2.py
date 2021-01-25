#Time Complexity :O(n)
#Space Complexity :O(n) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : tried running sum.
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if(matrix==None):
            return []
        
        queue=collections.deque()
        m=len(matrix)
        n=len(matrix[0])
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        
        for i in range(m):
            for j in range(n):
                if(matrix[i][j]==0):
                    queue.append([i,j])
                else:
                    matrix[i][j]=-1
        
        while(len(queue)>0):
            curr=queue.popleft()
            for dire in dirs:
                r=dire[0]+curr[0]
                c=dire[1]+curr[1]
                
                if(r>=0 and r<m and c>=0 and c<n and matrix[r][c]==-1):
                    matrix[r][c]=matrix[curr[0]][curr[1]]+1
                    queue.append([r,c])
        return matrix
                
            
        