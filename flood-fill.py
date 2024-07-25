from queue import Queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if image[sr][sc] == color: return image
        dirs = [[-1,0],[1,0],[0,-1],[0,1]]
        m = len(image)
        n = len(image[0])
        q = Queue()
        q.put([sr,sc])
        curr_color = image[sr][sc]
        image[sr][sc] = color
        while not q.empty():
            curr = q.get()
            for d in dirs:
                nr = curr[0] + d[0]
                nc = curr[1] + d[1]
                if nr >= 0 and nc >= 0 and nr < m and nc < n and image[nr][nc] == curr_color:
                    print(image)
                    q.put([nr,nc])
                    image[nr][nc] = color
        return image

        