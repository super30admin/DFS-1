// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
have a dirs array for finding neighbors
have a q
loop through matrix to get all elements that are 0 and add them to q and set all others to -1

set dist = 1
while q is not empty
loop through the size of q
get all neighbor elements
if any neighbor is -1 then set that element to dist, this sets all immediate neighbors in q to that particular distance
all elements that are farther inside will come in next level of q size loop so increment dist
*/
package main

import "fmt"

func updateMatrix(matrix [][]int) [][]int {
	dirs:=[][]int{{-1, 0},{1,0},{0,-1},{0,1}}
	q := [][]int{}
	for i:=0;i<len(matrix);i++{
		for j:=0;j<len(matrix[0]);j++{
			if matrix[i][j] == 0 {
				q = append(q, []int{i,j})
			} else {
				matrix[i][j] = -1
			}
		}
	}

	dis := 1
	for len(q)>0 {
		size := len(q)
		for x := 0;x<size;x++ {
			ele := q[0]
			q = q[1:]
			for y :=0;y<len(dirs);y++{
				r := ele[0]+dirs[y][0]
				c:=ele[1]+dirs[y][1]

				if r >=0 && r<len(matrix) && c>=0 && c<len(matrix[0]) && matrix[r][c] == -1 {
					matrix[r][c] = dis
					q=append(q, []int{r,c})
				}
			}
		}
		dis++
	}
	return matrix
}

func Main01Matrix() {
	fmt.Println(updateMatrix([][]int{{0,0,0},{0,1,0}, {1,1,1}})) //expected [[0,0,0],	[0,1,0],	[1,2,1]]
}
