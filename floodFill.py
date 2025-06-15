# Space Complexity - o(m*n)
# Time Complexity - o(m*n)

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        
        if image[sr][sc] == color:
            return image

        q = deque()
        m = len(image)
        n = len(image[0])
        original = image[sr][sc]
        image[sr][sc] = color
        q.append([sr,sc])
        directions = [[1,0],[0,1],[-1,0],[0,-1]]
        
        while q:
            for _ in range(len(q)):
                r,c = q.popleft()

                for dr, dc in directions:
                    ir = dr+r
                    ic = dc+c

                    if 0<= ir<m and 0<=ic<n and image[ir][ic]==original:
                        image[ir][ic] = color
                        q.append([ir,ic])

        return image

