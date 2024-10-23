'''
    Time Complexity: O(mxn)
    Space Complexity: O(mxn)
'''
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        queue = deque()
        m = len(image)
        n = len(image[0])
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

        originalColor = image[sr][sc]

        if originalColor == color:
            return image

        image[sr][sc] = color
        queue.append((sr, sc))

        while len(queue):
            pixel = queue.popleft()
        
            for dr in directions:
                r = pixel[0] + dr[0]
                c = pixel[1] + dr[1]

                if 0 <= r < m and 0 <= c < n:
                    if image[r][c] == originalColor:
                        image[r][c] = color
                        queue.append((r, c))

        return image
