from collections import deque

class Solution:
	def floodFill1(self, image, sr, sc, newColor):
		# Time Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Space Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Accepted on leetcode
		# BFS Approach
		queue = deque()
		queue.append([sr, sc])
		rows = len(image)
		columns = len(image[0])
		val = image[sr][sc]
		if image == None or image[0] == None or val == newColor:
			return image
		while len(queue) > 0:
			r, c = queue.popleft()
			image[r][c] = newColor
			if r > 0 and image[r - 1][c] == val:
				queue.append([r - 1, c])
			if r < len(image) - 1 and image[r + 1][c] == val:
				queue.append([r + 1, c])
			if c > 0 and image[r][c - 1] == val:
				queue.append([r, c - 1])
			if c < len(image[0]) - 1 and image[r][c + 1] == val:
				queue.append([r, c + 1])
		return image

	def floodFill2(self, image, sr, sc, newColor):
		# Time Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Space Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Accepted on leetcode
		# DFS Approach
		color = image[sr][sc]
		if color == newColor:
			# If the new color is same as the existing color no changes is needed
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