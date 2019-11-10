# Leetcode(542) : Successful

class Solution:
    def updateMatrix(self, matrix):
        #edge case
        if len(matrix) == 0 or matrix == None:
            return 0
        m = len(matrix)
        n = len(matrix[0])

        queue = []
        dirs = [[0,1],[1,0],[0,-1],[-1,0]]
        #traverse through the matrix
        for i in range(m):
            for j in range(n):
                #if val ==1 , set it to max
                if matrix[i][j] == 1:
                    matrix[i][j] = 9999
                #if val psuh to queue
                else:
                    queue.append([i,j])

        while len(queue) != 0:
            size = len(queue)
            #complete one level at a time
            for i in range(size):
                #pop from queue
                curr = queue.pop(0)
                #traverse in all 4 directions
                for dir in dirs:
                    i = curr[0]+dir[0]
                    j = curr[1]+dir[1]
                    #edge case
                    #array with bound and cell_val > current_cell_cal + 1
                    #then update with min val
                    #and append to queue
                    if(i>=0 and i<m and j>=0 and j<n and matrix[i][j] > matrix[curr[0]][curr[1]]+1):
                        matrix[i][j] = matrix[curr[0]][curr[1]]+1
                        queue.append([i,j])
        return matrix
obj = Solution()
print(obj.updateMatrix([[0,0,0],[0,1,0],[1,1,1]]))
