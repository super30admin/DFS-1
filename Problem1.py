from collections import deque

class Solution:
	def floodFill1(self, image, sr, sc, newColor):
		queue = deque()
		queue.append([sr, sc])
		rows = len(image)
		columns = len(image[0])
		val = image[sr][sc]
		if val == newColor:
			return image
		image1 = [x[:] for x in image]
		while len(queue) > 0:
			size = len(queue)
			for i in range(size):
				r, c = queue.popleft()
				if r > 0 and image[r - 1][c] == val:
					queue.append([r - 1, c])
				if r < len(image) - 1 and image[r + 1][c] == val:
					queue.append([r + 1, c])
				if c > 0 and image[r][c - 1] == val:
					queue.append([r, c - 1])
				if c < len(image[0]) - 1 and image[r][c + 1] == val:
					queue.append([r, c + 1])
				image1[r][c] = newColor
			print(len(queue))
		return image1

	def floodFill2(self, image, sr, sc, newColor):
		color = image[sr][sc]
		if color == newColor:
			return image
		self.helper(image, sr, sc, newColor, color)
		return image

	def helper(self, image, r, c, newColor, color):
		if image[r][c] == color:
			image[r][c] = newColor
			if r > 0:
				self.helper(image, r - 1, c, newColor, color)
			if r < len(image) - 1:
				self.helper(image, r + 1, c, newColor, color)
			if c > 0:
				self.helper(image, r, c - 1, newColor, color)
			if c < len(image[0]) - 1:
				self.helper(image, r, c + 1, newColor, color)

if __name__ == '__main__':
	ff = Solution()
	print(ff.floodFill2([[1,1,1],[1,1,0],[1,0,1]], 1, 1, 2))