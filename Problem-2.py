'''
    Time Complexity: O(2mn)
    Space Complexity: O(mn)
'''
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m = len(mat)
        n = len(mat[0])
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        queue = deque()

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 0:
                    queue.append((i, j))
                if mat[i][j] == 1:
                    mat[i][j] = -1

        size = len(queue)
        level = 1

        while len(queue):
            for i in range(size):
                cell = queue.popleft()

                for dr in directions:
                    r = cell[0] + dr[0]
                    c = cell[1] + dr[1]

                    if 0 <= r < m and 0 <= c < n:
                        if mat[r][c] == -1:
                            mat[r][c] = level
                            queue.append((r, c))
            
            size = len(queue)
            level += 1

        return mat

            