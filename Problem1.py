# TC: O(N)
# SC: O(N) N is the number of pixels

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        original = image[sr][sc]
        if original == color:
            return image
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        q = collections.deque()
        q.append((sr, sc))
        m, n = len(image), len(image[0])
        image[sr][sc] = color
        while q:
            size = len(q)
            r, c = q.popleft()
            for dirc in dirs:
                nr = r + dirc[0]
                nc = c + dirc[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == original :
                    image[nr][nc] = color
                    q.append((nr, nc))
        return image
