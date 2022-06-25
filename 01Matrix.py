#TC:O(m*n)
#SC:O(m*n)
class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        if mat==None or len(mat)==0: return mat
        q=[]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1 
        dire=[[-1,0],[0,-1],[1,0],[0,1]]
        dist=0
        row=len(mat)
        col=len(mat[0])
        size=0
        while q:
            #if size==0:
                #size=len(q)
                #dist+=1
            curr=q.pop(0)
            size-=1
            for i in range(len(dire)):
                cr=curr[0]+dire[i][0]
                cc=curr[1]+dire[i][1]
                if cr<0 or cc<0 or cr>=row or cc>=col: continue
                if mat[cr][cc]==-1:
                    q.append([cr,cc])
                    mat[cr][cc]=mat[curr[0]][curr[1]]+1
                    #mat[cr][cc]=dist
        return mat
#if we do brutforce method where we create a new q for every 0 that we find:
#TC:O((m*n)^2)
#SC:O(m*n)
        

        