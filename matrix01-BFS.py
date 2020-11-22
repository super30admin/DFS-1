"""BFS with distance array"""
#Accepted by leetcode
#Time complexity - O(n) as we are visting every element
#Space complexity - O(n) as we are using queue and distance array

class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if matrix == None or len(matrix) == 0:
            return matrix
        dist = [[0 for x in range(len(matrix[0]))] for y in range(len(matrix))]
        
        def bfs(matrix,x,y):
            q = []
            q.append((x,y))
            dirs = [(0,1),(1,0),(0,-1),(-1,0)]
            dist = 0
            while len(q) > 0:
                size = len(q)
                for i in range(size):
                    curr = q.pop(0)
                    for d in dirs:
                        r = d[0] + curr[0]
                        c = d[1] + curr[1]
                        if 0 <= r < len(matrix) and 0 <= c < len(matrix[0]):
                            if matrix[r][c] == 0:
                                return dist + 1
                            else:
                                q.append((r,c))
                dist += 1              
            return -1
        
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] != 0:
                    dist[i][j] = bfs(matrix,i,j)
        return dist