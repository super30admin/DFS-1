class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        # tc: Omn
        #     sc: o(mn)
        matrix = mat
        if matrix is None:
            return matrix
        m = len(matrix)
        n = len(matrix[0])
        q = collections.deque()
        for i in range(m):
            for j in range(n):
                if matrix[i][j] == 1:
                    matrix[i][j] = -1
                elif matrix[i][j] == 0:
                    q.append((i, j))

        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        distance = 1
        ###for traversing level by level and maintaing only those number of nodes, we can maintain the size
        ###of the queue
        while q:
            # size=len(q)
            # for i in range(size):
            curr = q.popleft()
            for d in dirs:
                r = d[0] + curr[0]
                c = d[1] + curr[1]
                if (r >= 0 and c >= 0 and r < m and c < n and matrix[r][c] == -1):
                    # matrix[r][c]=distance
                    matrix[r][c] = matrix[curr[0]][curr[1]] + 1
                    q.append((r, c))

        # distance+=1

        # for d in dirs:

        return matrix


