#Time Complexity :O(m*n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes
class Solution:
    def updateMatrix(self, mat):
        q=deque()
        #Adding all the zeroes in first level and adding it to queue and marking 1 as -1
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                
                if mat[i][j]==0:
                    q.append([i,j])
                else:
                    mat[i][j]=-1
        # Finding the neighbors of Zeroes and finding their distance from zero           
        while q:
            x,y=q.popleft()
            
            for i,j in [(0,1),(0,-1),(1,0),(-1,0)]:
                xx=x+i
                yy=y+j
                
                if xx<0 or xx>=len(mat) or yy<0 or yy>=len(mat[0]) or mat[xx][yy]!=-1:
                    continue
                    
                q.append([xx,yy])
                mat[xx][yy]=mat[x][y]+1
                
        return mat