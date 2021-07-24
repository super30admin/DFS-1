# time complexity: m*n
# space: m*n

class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # base case:
        if not image or len(image) == 0 or image[sr][sc] == newColor:
            return image
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        # we can use DFS as we dont neeed to maintain any time
        R = len(image)
        C = len(image[0])
        color = image[sr][sc]
        q = collections.deque()
        q.append([sr, sc])
        image[sr][sc] = newColor
        while q:
            curr = q.popleft()
            # now iteraate over the neighbouring matrix elements
            for dir in directions:
                nghbr_r = curr[0] + dir[0]
                nghbr_c = curr[1] + dir[1]
                if (0 <= nghbr_r < R and 0 <= nghbr_c < C and
                        image[nghbr_r][nghbr_c] == color):
                    q.append([nghbr_r, nghbr_c])
                    image[nghbr_r][nghbr_c] = newColor
        return image
