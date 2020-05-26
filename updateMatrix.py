#Time COmplexity: O(n)
# Space Complexity: O(n)
# Ran successfully on Leetcode: Yes

# Algorithm:
# Traverse the matrix and set the ones as -1. 
# Also, the elements with 0 value are appended into the queue. 
# Then we explore its neighbour and if they have 1 as value we set them distance which is its nearest 0 from 1. 

class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if not matrix or len(matrix)==0:
            return matrix
        m=len(matrix)
        n=len(matrix[0])
        q=[]
        dist=1
        
        for i in range(m):
            for j in range(n):
                if matrix[i][j]==0:
                    q.append((i,j))
                else:
                    matrix[i][j]=-1
        while q:
            size=len(q)
            for _ in range(size):
                curr=q.pop(0)
                for dx,dy in [[0,1],[0,-1],[1,0],[-1,0]]:
                    r=curr[0]+dx
                    c=curr[1]+dy
                    if 0<=r<m and 0<=c<n and matrix[r][c]==-1:
                        matrix[r][c]=dist
                        q.append((r,c))
            dist+=1
        return matrix 
