// Time Complexity : O(m*n) 
// Space Complexity : O(m*n) worst case all elements will be in queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

'''
1. update the matrix if 0 do nothing and negate 1. 
2. Also add 0 locations to queue.
3. initialize the distance 1
4. Find elements close to queue if -1 update there dist else continue
5. Once we changed the state from -1 to dist add it to
   queue to process elements close to it

'''

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        
        # calulate distance from 0 to 1
        
        # if zero location add to queue else if 1 
        # make value invalid like below zero
        
        queue=[]
        for i in range(0,len(mat)):
            for j in range(0,len(mat[0])):
                
                if mat[i][j] ==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        dist=1
        dir=[[0,1],[0,-1],[-1,0],[1,0]]
        
        while len(queue)!=0:
            
            size=len(queue)
            
            while size!=0:
                row,col=queue.pop(0)
                for v in dir:
                    nRow,nCol=row+v[0],col+v[1]
                    if (nRow>=0 and nRow<len(mat) and nCol>=0 and nCol<len(mat[0]) and                               mat[nRow][nCol] == -1):
                            mat[nRow][nCol]=dist
                            queue.append([nRow,nCol])
                size=size-1
            size=len(queue)
            dist=dist+1
            
        return mat
            
            
                
        