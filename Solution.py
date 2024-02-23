class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        [0,0,0]
        [0,1,0]
        time: O(mn)
        space: O(mn)
        """
        if color == image[sr][sc]:
            return image
        q = deque([(sr, sc)])
        s_color = image[sr][sc]
        image[sr][sc] = color
        while q:
            r, c = q.popleft()
            for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
                nr, nc = r+dr, c+dc
                if 0 <= nr < len(image) and 0 <= nc < len(image[0]) and image[nr][nc] == s_color:
                    image[nr][nc] = color
                    q.append((nr, nc))
        return image

    def updateMatrix(self, mat):
        """
        :type mat: List[List[int]]
        :rtype: List[List[int]]
        time: O(mn)
        space: O(mn)
        """
        q = deque([])
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                if mat[i][j] == 0:
                    q.append((i, j))
                else:
                    mat[i][j] = -1
        dirn = [(0,1), (0,-1), (1,0), (-1,0)]
        while q:
            cx, cy = q.popleft()
            for dx, dy in dirn:
                nx, ny = cx + dx, cy + dy
                if 0 <= nx < len(mat) and 0 <= ny < len(mat[0]) and mat[nx][ny] == -1:
                    mat[nx][ny] = mat[cx][cy] + 1
                    q.append((nx, ny))
        return mat