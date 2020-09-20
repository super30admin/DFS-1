class Solution(object):
    def updateMatrix(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        if(matrix == None or len(matrix) == 0 or len(matrix[0]) == 0):
            return matrix
        
        n = len(matrix)
        m = len(matrix[0])
        queue = deque()
        directions = [[0, 1],[0, -1],[1, 0],[-1, 0]]
        
        for i in range(0, n):
            for j in range(0, m):
                if matrix[i][j] == 1:
                    matrix[i][j] = float("inf")
                elif matrix[i][j] == 0:
                    queue.append([i, j])
        print(queue)
        
        while(queue):
            top = queue.popleft()
            for dirs in directions:
                i = top[0]
                j = top[1]
                r = i + dirs[0]
                c = j + dirs[1]
                if(r >=0 and r < n and c >= 0 and c < m and (matrix[r][c] > matrix[i][j] + 1)):
                    matrix[r][c] = matrix[i][j] + 1
                    queue.append([r, c])
        
        return matrix
