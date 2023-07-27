class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        dirs = [[0,1], [1, 0], [-1, 0], [0, -1]]
        rows = len(image)-1
        cols = len(image[0]) -1
        q = deque()
        q.append((sr, sc))
        given = image[sr][sc]
        image[sr][sc] = color

        if given == color:
            return image

        while q:
            curr = q.popleft()

            for d in dirs:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]

                if 0 <= nr <= rows and 0 <= nc <= cols and image[nr][nc] == given:
                    q.append((nr, nc))
                    image[nr][nc] = color
        
        return image
       