class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image is None:
            return image
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        q = deque()
        orgclr = image[sr][sc]
        if orgclr == color:
            return image
        q.append(sr)
        q.append(sc)
        image[sr][sc] = color

        while q:
            cr = q.popleft()
            cc = q.popleft()
            for dire in dirs:
                nr = cr + dire[0]
                nc = cc + dire[1]
                if(nr >= 0 and nr < len(image) and nc >= 0 and nc < len(image[0]) and image[nr][nc] == orgclr):
                    q.append(nr)
                    q.append(nc)
                    image[nr][nc] = color
        
        return image



        