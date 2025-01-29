# tc O(m*n), sc O(m+n).
old_color = image[sr][sc]
if old_color == color:
    return image

ROWS, COLUMNS = len(image), len(image[0])
from collections import deque
queue = deque([(sr, sc)])
image[sr][sc] = color

while queue:
    nodei, nodej = queue.popleft()
    neighbors = [[nodei-1, nodej], [nodei, nodej+1], [nodei+1, nodej], [nodei, nodej-1]]
    
    for nrow, ncol in neighbors:
        if 0 <= nrow < ROWS and 0 <= ncol < COLUMNS and image[nrow][ncol] == old_color:
            image[nrow][ncol] = color
            queue.append((nrow, ncol))

return image