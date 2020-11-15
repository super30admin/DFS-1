class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:

            if image is None or len(image)==0:
                return image

            m = len(image)
            n = len(image[0])

            if image[sr][sc] == newColor:
                return image
            color = image[sr][sc]
            q = collections.deque()
            q.append((sr,sc))
            image[sr][sc] = newColor
            dirs = [(0,1),(1,0),(0,-1),(-1,0)]
            while q:
                cur = q.pop()
                for d in dirs:
                    r = d[0]+cur[0]
                    c = d[1]+cur[1]
                    if (r in range(m) and c in range(n) and image[r][c]==color):
                        q.append((r,c))
                        image[r][c]=newColor

            return image
