# Runs on Leetcode
# Runtime - O(n)
# Memory - O(n)

'''
BFS 

'''

class Solution:
    def updateMatrix(self, matrix):
        if not len(matrix):
            return matrix
        
        queue = []
        directions = [[0,1],[1,0],[0,-1],[-1,0]]
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    queue.append([i,j])
                else:
                    matrix[i][j] = 9999
        while queue:
            element = queue.pop(0)
            for i in directions:
                a = element[0] + i[0]
                b = element[1] + i[1]
                if a >= 0 and a < len(matrix) and b < len(matrix[0]) and b >= 0 and                             matrix[a][b] != 0:
                    if matrix[element[0]][element[1]] + matrix[a][b] >= 9999 :
                        queue.append([a,b])
                        matrix[a][b] = matrix[element[0]][element[1]]+1
                    else:
                        continue
        return matrix
                
        
