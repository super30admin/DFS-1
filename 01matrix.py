class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        '''We can do it using BFS or DFS'''
        
        #BFS
        '''First find one and start applying BFS on it. Start a fresh BFS for every 1.
        Check if there is any 0 in the neighbor. If not continue, else change update the count.
        We also need a visited set to avoid processing the same neighbors again. T-O(mn*mn)
        S-O(mn)
        
        Optimized:
        Process by levels.
        1st level--- dist 1
        2nd level --- 1st level+1 ...and so on
        And instead of making a visited set, we can put the distance itself in the queue instead of the index. For first level put -1 so that we can distingush if its the distance or the value
        
        Time Complexity: O(mn)
        Space Complexity: O(mn)
        '''
        #edge case
        if len(matrix)==0:
            return matrix
        
        queue=deque([])
        m=len(matrix)
        n=len(matrix[0])
        
        #direction array right, left, top, bottom
        dirs=[[0,1],[0,-1],[-1,0],[1,0]]
        
        #Iterate over the matrix
        for i in range(m):
            for j in range(n):
                #If at a the position we find 0, add it to queue
                if matrix[i][j]==0:
                    queue.append([i,j])
                #Repace 1 to -1 so that we can distinguish
                elif matrix[i][j]==1:
                    matrix[i][j]=-1
                    
        dist=0
        while len(queue)!=0:
            #once a level is processed, increase dist
            size=len(queue)
            #process levels
            #Iterate on number of nodes of that level
            for i in range(size):
                curr=queue.popleft()
                for d in dirs:
                    nr=d[0]+curr[0]
                    nc=d[1]+curr[1]
                    #bound check
                    if nr>=0 and nc>=0 and nr<m and nc < n and matrix[nr][nc]==-1:
                        #replace it with dist
                        matrix[nr][nc]=dist+1
                        queue.append([nr,nc])
            dist+=1
        return matrix
            
