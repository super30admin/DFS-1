package main

// if I know the distance to a cell from 0 and if there is another cell next to it. that cell will be +1 from the cell and eventually we will get
// find 1 and explore all directions for 0
// if found then change the cell to be 1+1
// Time : O(mXn)
// Space : O(mXn)
// TODO : code the brute force approach
func updateMatrix(mat [][]int) [][]int {
	m := len(mat)
	n := len(mat[0])

	dirs := [][]int{
		[]int{-1, 0}, // up
		[]int{0, -1}, //left
		[]int{0, 1},  // right
		[]int{1, 0},  // down
	}
	q := [][]int{}
	// add 0's to queue
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if mat[i][j] == 0 {
				q = append(q, []int{i, j})
			} else {
				mat[i][j] = -1
			}
		}
	}
	level := 1
	for len(q) != 0 {
		qLen := len(q)
		for qLen != 0 {
			dq := q[0]
			q = q[1:]
			r := dq[0]
			c := dq[1]
			// bfs
			for _, v := range dirs {
				nr := r + v[0]
				nc := c + v[1]
				if nr >= 0 && nc >= 0 && nr < m && nc < n {
					if mat[nr][nc] == -1 {
						q = append(q, []int{nr, nc})
						mat[nr][nc] = level
					}
				}
			}
			qLen--
		}
		level++
	}
	return mat
}