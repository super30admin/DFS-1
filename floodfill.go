// Time Complexity : O(mn)
// Space Complexity : O(1) recursive stack mn
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if length is 0 return image
call recursive function with image, location, new and orginal colors

in recursive function
if element value is newColor or not orgColor return
set element color to newColor
call recursive for all its neighbors
*/
package main

import "fmt"

func floodFill(image [][]int, sr int, sc int, newColor int) [][]int {
	if len(image) == 0 || len(image[0]) == 0 {
		return image
	}
	h(image, sr, sc, newColor, image[sr][sc])
	return image
}

func h(image [][]int, sr int, sc int, newColor int, orgColor int) {
	if sr < 0 || sr >=len(image) || sc <0 ||sc >=len(image[0]) || image[sr][sc] == newColor || image[sr][sc] != orgColor {
		return
	}
	image[sr][sc] = newColor
	dirs := [][]int{{-1,0},{1, 0},{0, -1}, {0, 1}}
	for x:=0;x<len(dirs);x++{
		r := sr+dirs[x][0]
		c:=sc+dirs[x][1]
		h(image, r,c,newColor, orgColor)
	}
	return
}

func MainFloodFill() {
	fmt.Println(floodFill([][]int{{1,1,1},{1,1,0},{1,0,1}}, 1,1,2)) //expected [[2,2,2],[2,2,0],[2,0,1]]
}
