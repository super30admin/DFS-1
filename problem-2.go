/*Time Complexity : O(m * n)
Space Complexity : O(m * n)*/

func updateMatrix(mat [][]int) [][]int {
	// Check if the input matrix is empty
	if mat == nil || len(mat) == 0 || len(mat[0]) == 0 {
		// If so, return an empty matrix
		return [][]int{}
	}

	// Get the number of rows (m) and columns (n) in the matrix
	m, n := len(mat), len(mat[0])

	// Initialize an empty queue for BFS
	queue := make([][]int, 0)

	// Define the maximum possible value in the matrix
	MAX_VALUE := m * n

	// Iterate through each cell in the matrix
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			// If the cell value is 0, add its coordinates to the queue
			if mat[i][j] == 0 {
				queue = append(queue, []int{i, j})
			} else {
				// Otherwise, set the cell value to MAX_VALUE
				mat[i][j] = MAX_VALUE
			}
		}
	}

	// Define possible movements: up, down, left, and right
	directions := [][]int{{1, 0}, {-1, 0}, {0, 1}, {0, -1}}

	// Perform BFS traversal
	for len(queue) > 0 {
		// Dequeue a cell from the queue
		cell := queue[0]
		queue = queue[1:]

		// Explore neighboring cells
		for _, dir := range directions {
			r, c := cell[0]+dir[0], cell[1]+dir[1]
			// Check if the neighboring cell is within bounds and if updating its value minimizes distance
			if r >= 0 && r < m && c >= 0 && c < n && mat[r][c] > mat[cell[0]][cell[1]]+1 {
				// Update the neighboring cell's value
				queue = append(queue, []int{r, c})
				mat[r][c] = mat[cell[0]][cell[1]] + 1
			}
		}
	}

	// Return the updated matrix
	return mat
}
