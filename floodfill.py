# To solve this problem, I use DFS as taught in class. 
# Time Complexity: O(m*n)
# Space Complxity: O(m*n)
def floodfill(arr,sr,sc,newColor):
    if arr is None or len(arr)==0:
        return arr
    color = arr[sr][sc]
    if color == newColor:
        return arr
    dfs(arr,sr,sc,newColor)
    return arr

def dfs(arr,i,j,newColor):
    if i < 0 or i > len(arr) or j < 0 or j > len(arr[0] or arr[i][j]!=newColor):
        return

    dis = [{0,1},{0,-1},{-1,0},{1,0}] #left,top,down,right
    arr[i][j] = newColor
    for dir in dis:
        r = dir[0] + i
        c = dir[1] + j
    dfs(arr,r,c,newColor)

image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1
sc = 1
newColor = 2
floodfill(image,sr,sc,newColor)