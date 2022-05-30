'''
time complexity: O(rc)
r - row c- col
space complexity: O(r+c)
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs = [(0,1),(1,0),(-1,0),(0,-1)]
        rq = deque([])
        cq = deque([])
        lr = len(mat)
        
        lc = len(mat[0])
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if(mat[i][j]==0):
                    rq.append(i)
                    cq.append(j)
                else:
                    mat[i][j]=-1
        dist=1
        while(len(rq)!=0):
            n = len(rq)
            for i in range(n):
                cr = rq.popleft()
                cc = cq.popleft()
                for dr,dc in dirs:
                    nr = cr + dr
                    nc = cc + dc
                    if(nr>=0 and nc>=0 and nr<lr and nc<lc):
                        if(mat[nr][nc]==-1):
                            rq.append(nr)
                            cq.append(nc)
                            mat[nr][nc]=dist
                            
            dist+=1
        return mat