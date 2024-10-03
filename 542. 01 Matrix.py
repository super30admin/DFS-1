class Solution:
    '''
    - Using BFS starting from all 0 values
    - count the level at each of the location 1 is observed
    '''
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows = len(mat)
        cols = len(mat[0])
        copy_matrix = [[0 for _ in range(cols)] for _ in range(rows)]
        visited = set()
        queue = collections.deque()
        levels = 0
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r,c))
                    visited.add((r,c))

        while queue:
            levels += 1
            for val in range(len(queue)):
                row,col = queue.popleft()
                if row + 1 < rows and (row+1, col) not in visited:
                    queue.append((row + 1, col))
                    copy_matrix[row + 1][col] = levels
                    visited.add((row+1,col))
                if col + 1 < cols and (row, col+1) not in visited:
                    queue.append((row, col+1))
                    copy_matrix[row][col+1] = levels
                    visited.add((row,col+1))
                if row - 1 >= 0 and (row-1, col) not in visited:
                    queue.append((row - 1, col))
                    copy_matrix[row - 1][col] = levels
                    visited.add((row-1,col))
                if col -1 >= 0 and (row, col-1) not in visited:
                    queue.append((row, col -1))
                    copy_matrix[row][col-1] = levels
                    visited.add((row,col-1))
        return copy_matrix