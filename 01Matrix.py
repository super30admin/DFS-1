'''
    Time Complexity:
        O(mn) (where m = number of rows of matrix, n = number of columns of matrix)

    Space Complexity:
        O(mn) (where m = number of rows of matrix, n = number of columns of matrix)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        BFS approach so that we can easily find minimum distance.
        Use additional visited matrix to keep track of visited cells.
'''
DIRECTIONS = [
    (-1, 0), (0, 1), (1, 0), (0, -1)
]

class Solution:
    def __init__(self):
        self.matrix = []
        self.visited = []
        self.q = collections.deque()

    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        self.matrix = matrix
        self.visited = [[False] * len(self.matrix[0]) for _ in range(len(self.matrix))]

        self.visit_zeros()
        self.visit_neighbors()

        return self.matrix

    def visit_zeros(self):
        for i, row in enumerate(self.matrix):
            for j, cell in enumerate(row):
                if cell != 0:
                    continue

                self.q.append((i, j))
                self.visited[i][j] = True

    def visit_neighbors(self):
        dist = 1
        while self.q:
            zeros = len(self.q)
            z = 0

            while z < zeros:
                i, j = self.q.popleft()

                for r, c in DIRECTIONS:
                    self.visit(i + r, j + c, dist)

                z += 1

            dist += 1

    def visit(self, i, j, dist):
        if i not in range(0, len(self.matrix)):
            return

        if j not in range(0, len(self.matrix[i])):
            return

        if self.visited[i][j]:
            return

        self.q.append((i, j))
        self.matrix[i][j] = dist
        self.visited[i][j] = True
