from collections import deque
class Solution:
	def updateMatrix1(self, matrix: List[List[int]]) -> List[List[int]]:
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
			distances.append(temp)
		rows = len(matrix)
		columns = len(matrix[0])
		while len(queue) > 0:
			size = len(queue)
			for i in range(size):
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