#TIme Complexity =O(n)
#Space Complexity = O(h)

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue =[]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if(mat[i][j]==0):
                    queue.append((i,j))
        count=0
        dire = [(0,-1),(-1,0),(1,0),(0,1)]
        while(len(queue)!=0):
            l = len(queue)
            while(l!=0):
                x,y = queue.pop(0)
                mat[x][y] = count
                for i,j in dire:
                    x1=x+i
                    y1=y+j
                    if(x1>=0 and x1<len(mat) and y1>=0 and y1<len(mat[0]) and mat[x1][y1]!=0 and (x1,y1) not in queue):
                        queue.append((x1,y1))
                l = l-1
            count+=1
        return mat
        