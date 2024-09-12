# // Time Complexity :O(m*n)
# // Space Complexity :O(m*n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach






class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        dirs=[[0,1],[0,-1],[1,0],[-1,0]]
        dist=1
        queue=[]
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j]==1:
                    mat[i][j]=-1
                else:
                    queue.append([i,j])
        while queue:
            size=len(queue)
            
            
            for i in range(size):
                elem=queue.pop(0)
                print(elem)
                for i in dirs:
                    r=elem[0]+i[0]
                    c=elem[1]+i[1]
                    if r>=0 and c>=0 and r<len(mat) and c<len(mat[0]) and mat[r][c]==-1:
                        mat[r][c]=dist
                        queue.append([r,c])
            dist=dist+1
        return mat
        