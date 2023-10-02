class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])
        r = deque()
        c = deque()
        r.append(sr)
        c.append(sc)
        originalcolor = image[sr][sc]
        dir = [[-1,0],[1,0],[0,1],[0,-1]]
        if image[sr][sc] == color:
            return image
        image[sr][sc] = color
        while r:
            for i in range(len(r)):
                row = r.popleft()
                col = c.popleft()
                for d in dir:
                    nr = row + d[0]
                    nc = col + d[1]
                    if nr >=0 and nc >= 0 and nr <m and nc < n and image[nr][nc] == originalcolor:
                        image[nr][nc] = color 
                        r.append(nr)
                        c.append(nc)
        
        return image
        

#TC: O(nm)^2
#SC: O(nm)