from collections import deque
class Solution:
	def updateMatrix1(self, matrix: List[List[int]]) -> List[List[int]]:
		# BFS Approach
		# Time Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Space Complexity : O(2mn) where m is the number of rows and n is the number of columns
		# because I have a queue and not mutating the original matrix but creating a completely new matrix
		# Accepted on Leetcode
		queue = deque()
		rows = len(matrix)
		columns = len(matrix[0])
		distances = []
		for i in range(rows):
			temp = []
			for j in range(columns):
				if matrix[i][j] == 0:
					temp.append(0)
					queue.append([i,j])
				else:
					temp.append(9999999)
			distances.append(temp) # create a new matrix from give source with zeroes intact and ones changed to 9999999
		rows = len(matrix)
		columns = len(matrix[0])
		while len(queue) > 0:
			r, c = queue.popleft()
			nei_dist = distances[r][c]
			if r > 0 and distances[r - 1][c] > nei_dist + 1:
				distances[r - 1][c] = nei_dist + 1
				queue.append([r - 1, c])
			if r < rows - 1 and distances[r + 1][c] > nei_dist + 1:
				distances[r + 1][c] = nei_dist + 1
				queue.append([r + 1, c])
			if c > 0 and distances[r][c - 1] > nei_dist + 1:
				distances[r][c - 1] = nei_dist + 1
				queue.append([r, c - 1])
			if c < columns - 1 and distances[r][c + 1] > nei_dist + 1:
				distances[r][c + 1] = nei_dist + 1
				queue.append([r, c + 1])
		return distances

	def updateMatrix2(self, matrix: List[List[int]]) -> List[List[int]]:
		# BFS Approach
		# Time Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Space Complexity : O(mn) where m is the number of rows and n is the number of columns
		# because I have only a queue
		# Accepted on Leetcode
		queue = deque()
		rows = len(matrix)
		columns = len(matrix[0])
		for i in range(rows):
			for j in range(columns):
				if matrix[i][j] == 0:
					queue.append([i,j])
				else:
					matrix[i][j] = 9999 # Mutating the original matrix itself
		while len(queue) > 0:
			r, c = queue.popleft()
			nei_dist = matrix[r][c]
			if r > 0 and matrix[r - 1][c] > nei_dist + 1:
				matrix[r - 1][c] = nei_dist + 1
				queue.append([r - 1, c])
			if r < rows - 1 and matrix[r + 1][c] > nei_dist + 1:
				matrix[r + 1][c] = nei_dist + 1
				queue.append([r + 1, c])
			if c > 0 and matrix[r][c - 1] > nei_dist + 1:
				matrix[r][c - 1] = nei_dist + 1
				queue.append([r, c - 1])
			if c < columns - 1 and matrix[r][c + 1] > nei_dist + 1:
				matrix[r][c + 1] = nei_dist + 1
				queue.append([r, c + 1])
		return matrix

	def updateMatrix3(self, matrix: List[List[int]]) -> List[List[int]]:
		# DP approach
		# We have to traverse the matrix twice. 2 Pass approach
		# Once from top to bottom and left to right
		# Next from bottom to top and right to left
		# Time Complexity : O(2mn) = O(mn) 2mn because of the two pass where m is the number of rows and n is the number of columns
		# Space Complexity : Constant but we are creating a new array of size mn and changing that. Not changing the original array
		# Accepted on leetcode
		rows = len(matrix)
		columns = len(matrix[0])
		distances = []
		for i in range(rows):
			temp = []
			for j in range(columns):
				if matrix[i][j] == 0:
					temp.append(0)
					queue.append([i,j])
				else:
					temp.append(9999999)
			distances.append(temp)
		for i in range(rows):
			for j in range(columns):
				if matrix[i][j] == 0:
					distances[i][j] = 0
				else:
					if i > 0:
						distances[i][j] = min(distances[i][j], distances[i - 1][j] + 1)
					if j > 0:
						distances[i][j] = min(distances[i][j], distances[i][j - 1] + 1)
		for i in range(rows - 1, -1, -1):
			for j in range(columns - 1, -1, -1):
				if matrix[i][j] == 0:
					distances[i][j] = 0
				else:
					if i < rows - 1:
						distances[i][j] = min(distances[i][j], distances[i + 1][j] + 1)
					if j < columns - 1:
						distances[i][j] = min(distances[i][j], distances[i][j + 1] + 1)
		return distances

	def updateMatrix4(self, matrix: List[List[int]]) -> List[List[int]]:
		# DFS Approach
		# Time Complexity : O(mn) where m is the number of rows and n is the number of columns
		# Space Complexity : O(mn) where m is the number of rows and n is the number of columns
		# We have a matrix visited which will tell if a particular cell is visited or not
		rows = len(matrix)
		if rows == 0:
			return None
		columns = len(matrix[0])
		visited = [[False for i in range(columns)] for j in range(rows)]
		for i in range(rows):
			for j in range(columns):
				if matrix[i][j] != 0:
					matrix[i][j] = 99999 # Mutating the original matrix itself
		for i in range(rows):
			for j in range(columns):
				if not visited[i][j] and matrix[i][j] != 0:
					self.dfs(matrix, visited, i, j)
		return matrix

	def dfs(self, matrix, visited, i, j):
		if i < 0 or j < 0 or i >= len(matrix) or j >= len(matrix[0]):
			return 99999
		if visited[i][j]:
			return matrix[i][j]
		visited[i][j] = True
		if i - 1 >= 0:
			matrix[i][j] = min(matrix[i][j], matrix[i - 1][j] + 1)
		if i + 1 < len(matrix):
			matrix[i][j] = min(matrix[i][j], matrix[i + 1][j] + 1)
		if j - 1 >= 0:
			matrix[i][j] = min(matrix[i][j], matrix[i][j - 1] + 1)
		if j + 1 < len(matrix[0]):
			matrix[i][j] = min(matrix[i][j], matrix[i][j + 1] + 1)
		leftmin = self.dfs(matrix, visited, i - 1, j)
		rightmin = self.dfs(matrix, visited, i + 1, j)
		topmin = self.dfs(matrix, visited, i, j - 1)
		bottommin = self.dfs(matrix, visited, i, j + 1)
		minval = min(leftmin, rightmin, topmin, bottommin)
		matrix[i][j] = min(matrix[i][j], minval + 1)
		return matrix[i][j]