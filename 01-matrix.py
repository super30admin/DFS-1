class Solution:
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if matrix is None or len(matrix) == 0:
            return matrix
        q = deque()
        m = len(matrix)
        n = len(matrix[0])
        count = 0
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 0:
                    q.append([i, j])
                else:
                    count += 1
                    matrix[i][j] = -1
        if count == 0:
            return matrix
        lvl = 1
        while q:
            # size =len(q)
            # for i in range(size):
            dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
            curr = q.popleft()
            for dirc in dirs:
                r = curr[0] + dirc[0]
                c = curr[1] + dirc[1]
                if r >= 0 and r < m and c >= 0 and c < n and matrix[r][c] == -1:
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
                    q.append([r, c])
        # lvl+=1
        return matrix
