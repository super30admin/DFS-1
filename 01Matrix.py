class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        rows, cols = len(mat), len(mat[0])
        queue = deque()

        # Step 1: Initialize the queue with all '0' positions and set '1' cells to -1
        for r in range(rows):
            for c in range(cols):
                if mat[r][c] == 0:
                    queue.append((r, c))  # Add all 0s to the queue
                else:
                    mat[r][c] = -1  # Mark 1s as unvisited (-1)

        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        # Step 2: Multi-source BFS
        while queue:
            r, c = queue.popleft()
            for dr, dc in directions:
                nr, nc = r + dr, c + dc
                if 0 <= nr < rows and 0 <= nc < cols and mat[nr][nc] == -1:
                    mat[nr][nc] = mat[r][c] + 1
                    queue.append((nr, nc))  # Add to queue for further processing

        return mat

    # T: O(m * n), S: O(m * n)
