class Solution(object):
    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        """
        # T: O(mn)
        # S: O(mn)
        m = len(mat)
        n = len(mat[0])

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        q = collections.deque([])
        # visited = set()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    q.append((i, j))
                # if we do not want to change the  value to -1, we mark the nodes as visited
                else:
                    mat[i][j] = -1
        count = 1
        while q:
            size = len(q)
            for i in range(size):
                x, y = q.popleft()

                for r, c in directions:
                    nr = x + r
                    nc = y + c
                    if nr >= 0 and nr < len(mat) and nc >= 0 and nc < len(mat[0]) and mat[nr][nc] == -1:
                        # and (nr,nc) not in visited:
                        # visited.add((nr,nc))
                        q.append((nr, nc))
                        mat[nr][nc] = count
            count += 1
        return mat


