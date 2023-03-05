#Time Complexity : O(M*N)), M being the length the matrix and N the width
#Space Complexity : O(M*N)), M being the length the matrix and N the width
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Got completely stuck on trying to do dfs with time exceeded 
#eventually before trying bfs solution. 
#Your code here along with comments explaining your approach in three sentences only
'''Using BFS and a queue array, place all i,j value into queue if zero. Then, update with distance if 
value in matrix is -1. 
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        #initialize directions array and queue
        direction=[[-1,0],[1,0],[0,1],[0,-1]]
        queue=[]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    queue.append([i,j])
                else:
                    mat[i][j]=-1
        #with distance as queue, pop the indices, update the value in the matrix if is -1, and
        #add to queue. 
        distance = 0
        while(len(queue)>0):
            length = len(queue)
            for i in range(length):
                curr = queue.pop(0)
                r = curr[0]
                c = curr[1]
                for d in direction:
                    nr = r+d[0]
                    nc = c+d[1]
                    if nr>=0 and nr<len(mat) and nc>=0 and nc<len(mat[0]):
                        if mat[nr][nc]==-1:
                            mat[nr][nc]=distance+1
                            queue.append([nr,nc])
            distance = distance+1
        return mat

