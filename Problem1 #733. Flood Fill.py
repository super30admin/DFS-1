# Time Complexity: O(m*n)
# Space Complexity: O(m*n)

# DFS APPROACH
class Solution:
    m = 0
    n = 0
    dirs = []
    def floodFill(image, sr, sc, color):
        if image is None or len(image) == 0 or image[sr][sc] == color:
            return image

        m = len(image) 
        n = len(image[0])
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        oldColor = image[sr][sc]
        dfs(sr, sc, image, color, oldColor)

        return image
    
    def dfs(row, col, image, color, oldColor):
        #base
        if row < 0 or col < 0 or row == m or col == n or image[row][col] != oldColor:
            return 
            
        #logic
        image[row][col] = color
        for dir in dirs:
            nr = row + dir[0]
            nc = col + dir[1]
            dfs(nr, nc, image, color, oldColor)


# # BFS APPROACH
# import collections


# class Solution:
#     def floodFill(image, sr, sc, color):
#         if image is None or len(image) == 0 or image[sr][sc] == color:
#             return image

#         m = len(image) 
#         n = len(image[0])
#         rows = collections.deque()
#         cols = collections.deque()
#         dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
#         oldColor = image[sr][sc]
#         rows.append(sr)
#         cols.append(sc)
#         image[sr][sc] = color

#         while rows:
#             curr_row = rows.popleft()
#             curr_col = cols.popleft()
#             for dir in dirs:
#                 nr = curr_row + dir[0]
#                 nc = curr_col + dir[1]
#                 if nr >= 0 and nr < m and nc >= 0 and nc < n and image[nr][nc] == oldColor:
#                     rows.append(nr)
#                     cols.append(nc)
#                     image[nr][nc] = color
        
#         return image