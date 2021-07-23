#Time: O(n) as we will visit all elements
# Space: O(n) set and queue
class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        # ans = [[0 for _ in range(len(mat[0]))] for _ in range(len(mat))]
        queue = deque()
        visited = set()
        # for r in range(len(mat)):
        #     for c in range(len(mat[0])):
        #         if not mat[r][c]:
        #             queue.append((r,c,0))
        #             visited.add((r,c))
        queue.append((sr,sc))
        visited.add((sr,sc))
        old_color = image[sr][sc]
        image[sr][sc] = newColor
        while(queue):
            r,c = queue.popleft()
            for r_shift,c_shift in [(-1,0),(1,0),(0,-1),(0,1)]:
                if r+r_shift>=0 and r+r_shift<len(image) and c+c_shift>=0 and c+c_shift<len(image[0]) and (r+r_shift,c+c_shift) not in visited and image[r+r_shift][c+c_shift] == old_color:
                    image[r+r_shift][c+c_shift]=newColor
                    visited.add((r+r_shift,c+c_shift))
                    queue.append((r+r_shift,c+c_shift))
        return image