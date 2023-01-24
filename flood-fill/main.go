package main

import "fmt"

// loop over the matrix and get the
// Time : O(mXn)
// Space : O(mXn)
func floodFill(image [][]int, sr int, sc int, color int) [][]int {
	// rows
	m := len(image) - 1
	n := len(image[0]) - 1

	ogColor := image[sr][sc]

	if image[sr][sc] == color {
		return image
	}

	dirs := [][]int{
		[]int{-1, 0}, // up
		[]int{0, -1}, //left
		[]int{0, 1},  // right
		[]int{1, 0},  // down
	}
	fmt.Println(dirs)

	q := [][]int{}
	q = append(q, []int{sr, sc})
	fmt.Println("before", q)

	for len(q) != 0 {

		// dq
		dq := q[0]
		q = q[1:]
		r := dq[0]
		c := dq[1]
		//change color
		image[r][c] = color
		//add to queue
		for _, v := range dirs {
			nr := r + v[0]
			nc := c + v[1]
			if nr >= 0 && nc >= 0 && nr <= m && nc <= n {
				if image[nr][nc] == ogColor {
					q = append(q, []int{nr, nc})
					image[nr][nc] = color
				}
			}
		}
	}
	return image

}
