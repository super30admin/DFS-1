# Time Complesity: O(m * n)
# Space Complexity: O(max(m, n)) 
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        m, n = len(mat), len(mat[0])
        dirs = [[0, 1], [1, 0], [-1, 0], [0, -1]]
        visited = set()

        def dfs(row, col):
            if not (0 <= row < m and 0 <= col < n) or (row, col) in visited:
                return float('inf')
            
            if mat[row][col] == 0:
                return 0
            
            visited.add((row, col))
            distances = []
            for dr, dc in dirs:
                new_row, new_col = row + dr, col + dc
                distances.append(dfs(new_row, new_col) + 1)

            visited.remove((row, col))
            return min(distances)

        for i in range(m):
            for j in range(n):
                if mat[i][j] == 1:
                    mat[i][j] = dfs(i, j)

        return mat
