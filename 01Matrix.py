from collections import deque
class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        # Rotten Oranges Soln
        # Add all 0s to the queue consider these in Level 0
        # Now traverse all the nodes in BFS
        # Time Complexity is O(mn)
        # Space Complexity is O(mn), where m is the number of rows and n is the number of columns
        if(len(matrix) == 0):
            return matrix
        q = deque()
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if(matrix[i][j] == 0):
                    q.append((i,j))
                else:
                    matrix[i][j] = -1
        
        level = 0
        dirs = [(0,-1),(0,1),(1,0),(-1,0)]
        #print(q)
        while(q):
            size = len(q)
            for _ in range(size):
                i,j = q.popleft()
                #print(i,j,level)
                matrix[i][j] = level
                for r,c in dirs:
                    row = i+r
                    col = j+c
                    if(0<= row < len(matrix) and 0 <= col < len(matrix[0]) and matrix[row][col] == -1):
                        q.append((row,col))
                        matrix[row][col] = level+1
            level+=1
        return matrix