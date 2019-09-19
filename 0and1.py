"""
The approach here is to find the index and the element where it is not surrounded with 0's and then find 
the minimum from all the adjacent cells, the adjacent cells have the path value to the nearest 0 to them.
hence in this way we can alter the matrix.
"""
def updateMatrix(self, matrix):
        rows, cols = len(matrix), len(matrix[0])
        
        # Calculate the TOP/LEFT adjacents
        for row in range(rows):
            for col in range(cols):
                if matrix[row][col] != 0:
                    top  = matrix[row - 1][col] if row > 0 else float('inf')
                    left = matrix[row][col - 1] if col > 0 else float('inf')
                    
                    matrix[row][col] = min(top, left) + 1
        
        # Calcualte the BOTTOM/RIGHT adjacents
        for row in range(rows)[::-1]:
            for col in range(cols)[::-1]:
                if matrix[row][col] != 0:
                    bottom = matrix[row + 1][col] if row < rows - 1 else float('inf')
                    right  = matrix[row][col + 1] if col < cols - 1 else float('inf')
                    
                    matrix[row][col] = min(matrix[row][col], min(bottom, right) + 1)

        return matrix