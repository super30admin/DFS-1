#Time Complexity :- O(mxn)
#Space Complexity :- O(mxn)
## Approach : BFS 
## Can be done using DFS but complicated in terms of DFS because we need maintain an adjancency list with min distance. So BFS is most better path to follow

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = []
        m = len(mat)
        n = len(mat[0])
        total = 1
        dirs = [[0,1],[0,-1],[1,0],[-1,0]]

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append([i,j])
                else:
                    mat[i][j] = -1
        
        while(len(queue)>0):
           # size = len(queue)
            
           # for k in range(size):
                curr = queue.pop(0)
                for dir in dirs:
                    nr = curr[0]+ dir[0]
                    nc = curr[1]+ dir[1]
                    if nr>=0 and nr<m and nc>=0 and nc<n and mat[nr][nc]==-1:
                        mat[nr][nc] = mat[curr[0]][curr[1]]+1
                        queue.append([nr,nc])
          #  total +=1
        return mat

