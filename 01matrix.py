class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        #O(m*n)
        #O(m*n)
        if not matrix:
            return matrix
        #bfs
        q=deque()
        m=len(matrix)
        n=len(matrix[0])
        for i in range((m)):
            for j in range((n)):
                #queue is filled by independent node (zeroes) 
                if matrix[i][j]==0:
                    q.append((i,j))
                else:
                    #all 1s have changed state to prevent looping back to same 1 value
                    matrix[i][j]=-1
        
        dirs=[[0,1],[1,0],[-1,0],[0,-1]]
        while q: 
            cur=q.popleft()       
            for dir in dirs:
                #find new indices of neighbor
                r=cur[0]+dir[0]
                c=cur[1]+dir[1]
                #check bounds and if value in matrix is still -1 (not accessed yet)
                if r<m and r>=0 and c>=0 and c<n and matrix[r][c]==-1 :
                    #find route from nearest zero
                    matrix[r][c]=matrix[cur[0]][cur[1]]+1
                    #append new node to queue
                    q.append((r,c))
        return matrix
    #here levels are internally formed
        
        
        