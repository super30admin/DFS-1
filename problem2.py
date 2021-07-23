from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        #BFS
        if len(mat)==0:
            return mat
        queue=deque()
        #First keep all the 0's in the queue
        #Also, make the 1's as -1 so, it will be easier to convert
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
                    
        #We are considering starting distance as 1 so, it will be easier to calculate            
        dist=1
        dirs=[(-1,0),(0,-1),(1,0),(0,1)]
        while(len(queue)>0):
            sz=len(queue)
            #To distinguise each level separately
            for i in range(sz):
                v=queue.popleft()
                for x,y in dirs:
                    r1=v[0]+x
                    c1=v[1]+y
                    if (0<=r1<len(mat) and 0<=c1<len(mat[0]) and  mat[r1][c1]==-1):
                        mat[r1][c1]=mat[v[0]][v[1]]+dist
                        queue.append([r1,c1])
                   
        return mat
        #Time O(m*n)
        # Space O(m*n)
