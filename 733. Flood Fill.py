class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        current_color = image[sr][sc]
        row_size = len(image)
        col_size = len(image[0])

        def dfs(row, col):
            if image[row][col] == current_color:
                image[row][col] = color
                if row + 1 < row_size:
                    dfs(row+1, col)
                if row - 1 >= 0:
                    dfs(row-1, col)
                if col + 1 < col_size:
                    dfs(row, col+1)
                if col - 1 >= 0:
                    dfs(row, col-1)
        
        if color == current_color:
            return image
        dfs(sr, sc)
        return image