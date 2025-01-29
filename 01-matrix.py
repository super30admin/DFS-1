# tc O(m * n), sc O(m * n).
ROWS, COLUMNS = len(mat), len(mat[0])
res = [[None for _ in range(COLUMNS)] for _ in range(ROWS)]

queue = deque()
for r in range(ROWS):
    for c in range(COLUMNS):
        if mat[r][c] == 0:
            queue.append((r, c))
            res[r][c] = 0

while queue:
    for _ in range(len(queue)):
        r, c = queue.popleft()
        ndirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        for rdir, cdir in ndirs:
            nr = r + rdir
            nc = c + cdir
            if 0 <= nr < ROWS and 0 <= nc < COLUMNS:
                if res[nr][nc] == None:
                    res[nr][nc] = res[r][c] + 1
                    queue.append((nr, nc))

return res