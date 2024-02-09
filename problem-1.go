
/*Time Complexity: O(N)
Space Complexity: O(N)*/

func floodFill(image [][]int, sr int, sc int, color int) [][]int {
	// Store the dimensions of the image for easier access
	len_i := len(image)
	len_j := len(image[0])

	// Store the starting color of the pixel
	startingColor := image[sr][sc]

	// Define the offsets for adjacent pixels
	offsets := [4][2]int{{-1, 0}, {1, 0}, {0, 1}, {0, -1}}

	// Use a queue to store pixels to be processed
	queue := []coOrdinates{{sr, sc}}

	// Mark the starting pixel as visited
	image[sr][sc] = 10

	// Perform breadth-first search (BFS) to fill the region
	for len(queue) != 0 {
		// Dequeue the current pixel
		current := queue[0]
		queue = queue[1:]

		// Check adjacent pixels
		for _, offset := range offsets {
			x := current.i + offset[0]
			y := current.j + offset[1]

			// Check if the adjacent pixel is within bounds and has the starting color
			if x >= 0 && x < len_i && y >= 0 && y < len_j && image[x][y] == startingColor {
				// Mark the adjacent pixel as visited and add it to the queue
				queue = append(queue, coOrdinates{x, y})
				image[x][y] = 10
			}
		}
	}

	// Replace marked pixels with the new color
	for i := 0; i < len_i; i++ {
		for j := 0; j < len_j; j++ {
			if image[i][j] == 10 {
				image[i][j] = color
			}
		}
	}

	return image
}

type coOrdinates struct {
	i int
	j int
}
