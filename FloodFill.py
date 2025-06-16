# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image == None or len(image) == 0:
            return image
        m = len(image)
        n = len(image[0])
        initColor = image[sr][sc]
        if initColor == color:
            return image
        dirs = [[0,1],[1,0],[-1,0],[0,-1]]
        q = deque()
        q.append((sr, sc))
        image[sr][sc] = color
        while q:
            cr, cc = q.popleft()
            for dr, dc in dirs:
                nr = dr + cr
                nc = dc + cc
                if nr >=0 and nc >=0 and nr < m and nc < n and image[nr][nc] == initColor:
                        q.append((nr,nc))
                        image[nr][nc] = color

        return image