const dirs = [
	[1, 0],
	[-1, 0],
	[0, 1],
	[0, -1],
];
// Time complexity - O(m*n),m = number of rows, n = number of columns
// Space complexity - O(m*n)
// BFS approach is simple for this problems since it find the min distance when the cell is visited naturally
function updateMatrix(mat: number[][]): number[][] {
	const m = mat.length;
	const n = mat[0].length;
	const q = [];

	// initialize the matrix and the queue.
	for (let i = 0; i < m; i++) {
		for (let j = 0; j < n; j++) {
			if (mat[i][j] === 0) {
				// if we find a '0', add row, col to the queue for BFS
				q.push([i, j]);
			} else {
				// mark cell as -1 to count as unvisited
				mat[i][j] = -1;
			}
		}
	}

	let dist = 1;
	while (q.length > 0) {
		const size = q.length;

		// process all cell at current level
		for (let i = 0; i < size; i++) {
			const [row, col] = q.shift()!;

			for (const [dr, dc] of dirs) {
				const nr = row + dr;
				const nc = col + dc;

				// check for unvisited cell
				if (
					nr >= 0 &&
					nr < m &&
					nc >= 0 &&
					nc < n &&
					mat[nr][nc] === -1
				) {
					// update the distance of the unvisited cell with the current distance.
					mat[nr][nc] = dist;
					// add the newly visited cell to the queue to explore its neighbors in the next level.
					q.push([nr, nc]);
				}
			}
		}
		// increase the distance since current level is complete
		dist++;
	}

	return mat;
}
