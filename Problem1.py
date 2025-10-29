class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image:
            return []
        q = deque()
        q.append((sr, sc)) 
    
        if image[sr][sc] == color:
            return image
        dirs = [(-1, 0), (0, -1), (1, 0), (0, 1)]
        ROWS, COLS = len(image), len(image[0])

        while q:
            cur_r, cur_c = q.popleft()

            for r, c in dirs:
                new_r, new_c = cur_r + r, cur_c + c

                if 0<= new_r < ROWS and 0<= new_c < COLS:
                    if image[new_r][new_c] == color:
                        continue
                    if image[new_r][new_c] == image[cur_r][cur_c]:
                        q.append((new_r, new_c))

            image[cur_r][cur_c] = color
            # print(image)
        return image
