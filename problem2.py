class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        h, w = len(matrix), len(matrix[0])
        q = deque()
        for i in range(h):
            for j in range(w):
                if matrix[i][j] == 0:
                    q += [(i, j)]
                else:
                    matrix[i][j] = -1
        # print(matrix)
        while q:
            i, j = q.pop()
            # print(i,j,"-")
            for ai, aj in [(i-1, j), (i+1, j), (i, j-1), (i, j+1)]:
                
                if 0 <= ai < h and 0 <= aj < w and matrix[ai][aj] < 0:
                    
                    matrix[ai][aj] = matrix[i][j] + 1
                    # print(ai,aj,matrix[ai][aj])
                    q.appendleft((ai, aj))
        
        return matrix
#         def dfs(i,j,ss,matt):
#             if i<0 or i>=len(matt) or j<0 or j>=len(matt[0]) or ((i,j)) in ss:
#                 return float('inf')
#             if matt[i][j]==0:
#                 return 0
#             ss.add((i,j))
            
#             a=dfs(i,j-1,ss,matt)
#             b=dfs(i,j+1,ss,matt)
#             c=dfs(i-1,j,ss,matt)
#             d=dfs(i+1,j,ss,matt)
#             ss.remove((i,j))
#             return 1+min(min(a,b),min(c,d))

#         res = [[0 for i in range(len(mat[0]))] for j in range(len(mat))]
#         for i in range(len(mat)):
#             for j in range(len(mat[0])):
#                 if mat[i][j]>0:
#                     ss=set()
#                     res[i][j]=dfs(i,j,ss,mat)
#         return(res)
                