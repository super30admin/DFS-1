class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:

        global dirs, rowlen, collen, original_color
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        rowlen = len(image)
        collen = len(image[0])
        original_color = image[sr][sc]

        # DFS APPROACH
        # Time Complexity: O(n*m)
        # Space Complexity: O(n*m)
        def dfs(r, c, color):
            if image[r][c] != original_color or image[r][c] == color: return
            image[r][c] = color
            for dirr in dirs:
                nr = r + dirr[0]
                nc = c + dirr[1]
                if nr >= 0 and nr < rowlen and nc >= 0 and nc < collen:
                    dfs(nr, nc, color)

        dfs(sr, sc, color)
        return image

        # BFS Approach
        # Time Complexity: O(n*m)
        # Space Complexity: O(n*m)
        # dq = collections.deque()
        # dq.append((sr,sc))

        # while dq:
        #     r,c = dq.popleft()
        #     if image[r][c] != original_color or image[r][c] == color: continue
        #     image[r][c] = color
        #     for dirr in dirs:
        #         nr = r + dirr[0]
        #         nc = c + dirr[1]
        #         if nr >=0 and nr < rowlen and nc >=0 and nc < collen and image[nr][nc] == original_color:
        #             dq.append((nr,nc))

        # return image


