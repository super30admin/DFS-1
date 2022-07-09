class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # Bottom up DP
        # Time Complexity = O(Rows*Cols)
        # Space Complexity = O(1) just for output
        Rows = len(mat)
        Cols = len(mat[0])
        dp = [[float('inf') if mat[i][j] != 0 else 0 for j in range(Cols)] for i in range(Rows)]

        for i in range(Rows):
            for j in range(Cols):
                if i > 0:
                    dp[i][j] = min(dp[i][j], 1 + dp[i - 1][j])
                if j > 0:
                    dp[i][j] = min(dp[i][j], 1 + dp[i][j - 1])
        for i in range(Rows - 1, -1, -1):
            for j in range(Cols - 1, -1, -1):
                if i < Rows - 1:
                    dp[i][j] = min(dp[i][j], 1 + dp[i + 1][j])
                if j < Cols - 1:
                    dp[i][j] = min(dp[i][j], 1 + dp[i][j + 1])
        return dp

'''
        #BFS Time complexity: O(m * n) Space complexity: O(m * n) 
        m, n = len(mat), len(mat[0])
        output = [[math.inf if mat[i][j] != 0 else 0 for j in range(n)] for i in range(m)]
        queue = deque()
        visited = set()
        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j)) # append all 0 s in queue and use BFS on them
        distance = 0
        while len(queue) > 0:
            size = len(queue)
            while size > 0:
                size -= 1
                i, j = queue.popleft()
                if mat[i][j] != 0:
                    output[i][j] = distance        
                for i, j in [(i + 1, j), (i, j + 1), (i - 1, j), (i, j - 1)]:
                    if 0 <= i < m and 0 <= j < n and (i, j) not in visited:
                        visited.add((i, j))
                        queue.append((i, j))
            distance += 1             
        return output 
'''

'''
        # Note there should be atleast One '0' in mat
        m, n = len(mat), len(mat[0])
        output = [[math.inf if mat[i][j] != 0 else 0 for j in range(n)] for i in range(m)]

        def bfs(i, j):
            queue = deque([(i, j)])
            visited = set((i, j))
            distance = 0
            while len(queue) > 0:
                size = len(queue)
                while size:
                    size -= 1
                    x, y = queue.popleft()
                    if mat[x][y] == 0:
                        return distance
                    for x, y in [(x + 1, y), (x, y + 1), (x - 1, y), (x, y - 1)]:
                        if 0 <= x < m and 0 <= y < n and (x, y) not in visited:
                            visited.add((x, y))
                            queue.append((x, y))
                distance += 1
            return distance                
        for i in range(m):
            for j in range(n):
                if mat[i][j] != 0:
                    output[i][j] = bfs(i, j)
        return output    
'''