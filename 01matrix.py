
# Th approaach I used here is by using dfs for each element of matrix. (Optimizing it using BFS, will commit the optimized solution)
#Time Complxity: O(m*n^2)
#Space complexity: O(m*n)
def distZero(arr):
    if arr is None:
        return None
    for i in range(len(arr)):
        for j in range(len(arr[0])):
            dfs(arr,i,j,0)

def dfs(arr,i,j,dist):
        if i < 0 or i > len(arr) or j < 0 or j > len(arr[0]):
            return
        if arr[i][j] == 0:
            dp[i][j] = dist
            return
        if arr[i][j] != 0:
            print("dist",dist)
            dist = dist + 1
            
        dis = [(0,1),(0,-1),(-1,0),(1,0)]
        for dir in dis:
            r = dir[0] + i
            print(r)
            c = dir[1] + j
            print(c)
            dfs(arr,r,c,dist)

arr = [[0,0,0],[0,1,0],[0,0,0]]
dp = [[0 for i in range(len(arr))] for j in range(len(arr[0]))]
print(dp)
distZero(arr)