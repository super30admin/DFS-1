# 733. Flood Fill
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        dirs = [(0,1),(0,-1),(1,0),(-1,0)]

        if image[sr][sc] == color:
            return image
        
        q = deque()
        q.append(sr)
        q.append(sc)
        oldColor = image[sr][sc]
        image[sr][sc] = color
        
        while q:
            cr = q.popleft()
            cc = q.popleft()

            for dir_ in dirs:
                nr = cr + dir_[0]
                nc = cc + dir_[1]

                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == oldColor:
                    image[nr][nc] = color
                    q.append(nr)
                    q.append(nc)
        
        return image
