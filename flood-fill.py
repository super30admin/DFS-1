'''
Time Complexity: O(m*n)  since for the worst case we will be visiting all the nodes 
Space complexity: O(h) recursive stack 
'''

class Solution:
    def floodFill(
        self, image: List[List[int]], sr: int, sc: int, color: int
    ) -> List[List[int]]:
        ROWS, COLS = len(image), len(image[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        starting_color = image[sr][sc]

        def dfs(cr, cc):
            if cr < 0 or cr >= ROWS or cc < 0 or cc >= COLS:
                return

            if image[cr][cc] == starting_color and starting_color != color:
                image[cr][cc] = color
                for dr, dc in directions:
                    dfs(dr + cr, dc + cc)

            return

        dfs(sr, sc)
        return image
