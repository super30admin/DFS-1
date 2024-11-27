"Time Complexity is O(N)"
"Space Complexity is O(N)"

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m = len(image)
        n = len(image[0])

        oldcolor = image[sr][sc]

        if oldcolor == color:
            return image

        direction_array = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        queue = deque()

        image[sr][sc] = color
        queue.append((sr,sc))

        while(queue):
            r,c = queue.popleft()
        
            for dx, dy in direction_array:
                nr = r + dx
                nc = c + dy

                if 0 <= nr < m and 0 <= nc < n and image[nr][nc] == oldcolor:
                    image[nr][nc] = color
                    queue.append((nr,nc))
        return image
            