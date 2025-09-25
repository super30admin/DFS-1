const dirs = [
	[0, 1],
	[0, -1],
	[1, 0],
	[-1, 0],
];

// Time complexity - O(m*n),m = number of rows, n = number of columns
// Space complexity - O(m*n)
function floodFill(
	image: number[][],
	sr: number,
	sc: number,
	color: number
): number[][] {
	const originalColor = image[sr][sc];
	if (color === originalColor) return image;

	dfs(image, sr, sc, color, originalColor);
	return image;
}

function dfs(
	image: number[][],
	sr: number,
	sc: number,
	color: number,
	originalColor: number
) {
	// base
	if (
		sr < 0 ||
		sc < 0 ||
		sr >= image.length ||
		sc >= image[0].length ||
		image[sr][sc] !== originalColor
	)
		return;

	// logic
	image[sr][sc] = color;

	for (let [dr, dc] of dirs) {
		const r = sr + dr;
		const c = sc + dc;
		dfs(image, r, c, color, originalColor);
	}
}
