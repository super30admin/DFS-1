#time complexity: O(m*n)
#space complexity: O(1)
#ran on leetcode: Yes
#initialize a queue. push coordinates that have 0 inside queue. No w, for each element, look at the its niegbors that are 1. Make this neoighbor visited(by changing the value to -1) and store the distance of this 1 as level. Return the result array after traversing the matrix.
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        Q=[]
        ans=[]
        #initilally, put all indexes with zeroes inside Q
        for i in range(len(mat)):
            temp=[]
            for j in range(len(mat[0])):
                
                if(mat[i][j]==0):
                    mat[i][j]=-1
                    Q.append((i,j))
                    #ans[i][j]=0
                    temp.append(0)
                else:
                    temp.append(-1)
            ans.append(temp)
        dirs=[(0,-1),(0,+1),(-1,0),(1,0)]
        while(Q):
            i=Q[0][0]
            j=Q[0][1]
            del(Q[0])
            level=ans[i][j]
            for dir in dirs:
                I=i+dir[0]
                J=j+dir[1]
                if(I<len(mat) and I>= 0 and J<len(mat[0]) and J>=0):
                    if(mat[I][J]!=-1):
                        ans[I][J]=level+1
                        mat[I][J]=-1
                        Q.append((I,J))
            
        return ans
                


