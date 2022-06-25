# // Time Complexity : O(M*N)
# // Space Complexity : O(M*N)
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        r = len(grid)
        c = len(grid[0])
        if not grid:
            return 0
        queue = collections.deque([])
        count = 0
        for i in range(r):
            for j in range(c):
                if grid[i][j] == 2:
                    queue.append((i, j))
                elif grid[i][j] == 1:
                    count += 1

        time = 0
        if count == 0:
            return 0
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        while queue:
            size = len(queue)
            for i in range(size):
                curr = queue.popleft()
                for x, y in directions:
                    nx = x + curr[0]
                    ny = y + curr[1]
                    if 0 <= nx < r and 0 <= ny < c and grid[nx][ny] == 1:
                        grid[nx][ny] = 2
                        queue.append((nx, ny))
                        count -= 1
            time += 1
        if count != 0:
            return -1
        else:
            return time - 1
