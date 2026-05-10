 
 # O(n) time, O(n) space
 class Solution:
 	def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
 		rows, cols = len(image), len(image[0])
 		startColor = image[sr][sc]

 		# if the starting pixel is already new color, no work needed (prevents infinite recursion)
 		if startColor==color:
 			return image

 		def dfs(r,c):
 			if image[r][c]==startColor:
 				image[r][c]=color
 				if r+1 < rows:
 					dfs(r+1,c)
 				if r-1 > 0:
 					dfs(r-1,c)
 				if c+1 < cols:
 					dfs(r,c+1)
 				if c-1 > 0:
 					dfs(r,c-1)


 		dfs(sr,sc)
 		return image

