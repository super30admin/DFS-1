#Time Complexity = O(m*n)
#Space Complexity = O(m*n)
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        if not image or not image[0]:  
            return image  # Base case: If image is empty
        
        m, n = len(image), len(image[0])
        dirs = [(1, 0), (0, 1), (-1, 0), (0, -1)] # Directions for neighbors (down, right, up, left)
        original = image[sr][sc]

        # If the starting pixel already has the target color, return the image as is.
        if original == color:
            return image

        q = deque([(sr, sc)])
        image[sr][sc] = color

        while q:
            r, c = q.popleft()
            for dr, dc in dirs:
                nr, nc = r + dr, c + dc
                if 0 <= nr < m and 0 <= nc < n and image[nr][nc] == original:
                    q.append((nr, nc))
                    image[nr][nc] = color  # Mark visited by changing the color

        return image
