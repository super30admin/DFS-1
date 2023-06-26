# Time and space complexity : O(mxn)
from queue import Queue
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        q = Queue()
        rows = len(mat) # Total no of rows in matrix
        columns = len(mat[0]) # Total no of columns in matrix
        dirs = [[-1,0],[0,-1],[1,0],[0,1]] # Left right down up to calculate neighbours
        
        for i in range(rows):
            for j in range(columns):
                if mat[i][j]==0:    # Put all the 0 elements in the queue
                    q.put([i,j])    
                else:
                    mat[i][j]=-1    # We'll make all the 1's as -1 so that we wont visit them again.
                                    # Because if we set the dist to 1, we'll count them again
        dist = 1 
        while not q.empty():
            size = q.qsize()        # We are taking size of queue so that the size will have same distance
            for i in range(size):
                curr = q.get()      # Get the top element in the queue
                for dir in dirs:    # Check the neighbours of the element
                    nr = curr[0]+dir[0]
                    nc = curr[1]+dir[1]
                    if(nr>=0 and nc>=0 and nr<rows      # If the neighbours are in the bounds and if the
                    and nc<columns and mat[nr][nc]==-1): # neighbour is -1, we make it = dist
                        mat[nr][nc] = dist
                        q.put([nr,nc])
            dist+=1
        return mat


        