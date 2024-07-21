def flood_fill(matrix, x, y, new_color):
    rows, cols = len(matrix), len(matrix[0])
    target_color = matrix[x][y]

    def fill(x, y):
        if x < 0 or x >= rows or y < 0 or y >= cols or matrix[x][y] != target_color:
            return
        matrix[x][y] = new_color
        fill(x + 1, y)
        fill(x - 1, y)
        fill(x, y + 1)
        fill(x, y - 1)
    
    if target_color != new_color:
        fill(x, y)

# Example usage:
matrix = [
    [1, 1, 1],
    [1, 1, 0],
    [1, 0, 1]
]
flood_fill(matrix, 1, 1, 2)
print(matrix)

#time = O(N×M)
#space = O(N×M)