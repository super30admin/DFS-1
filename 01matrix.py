class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        ans = [[0 for _ in range(len(mat[0]))] for _ in range(len(mat))]
        queue = deque()
        visited = set()
        for r in range(len(mat)):
            for c in range(len(mat[0])):
                if not mat[r][c]:
                    queue.append((r,c,0))
                    visited.add((r,c))
                    
        while(queue):
            r,c,dist = queue.popleft()
            for r_shift,c_shift in [(-1,0),(1,0),(0,-1),(0,1)]:
                if r+r_shift>=0 and r+r_shift<len(mat) and c+c_shift>=0 and c+c_shift<len(mat[0]) and (r+r_shift,c+c_shift) not in visited:
                    ans[r+r_shift][c+c_shift]=dist+1
                    visited.add((r+r_shift,c+c_shift))
                    queue.append((r+r_shift,c+c_shift,dist+1))
        return ans