//Time Complexity : O(m*n) 
//Space Complexity : O(m*n)
//m = matrix's row length & n = matrix's column length
/*Approach : For first solution we are using BFS.
We take a Queue and we add the given node to the queue, also we change its colour.
Now we get the first node out of queue and we traverse horizontally and veritically to get the next nodes 
which match the initial color. If the initial color is matched then we turn them into given color 
and add them to Queue or if the nodes donot match the initial color we donot move forward with those nodes.
Like this we keep adding the next nodes and travesring over the queue until it gets empty. 
Once it is empty we are returning modified matrix.
*/
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;    // validate whether given matrix is null or not
        if(image[sr][sc] == color) return image;                // validate if the given node in matrix is same as the given color and returning the matrix assuming all other nodes are same as given color.
        
        int m = image.length;                                   // matrix's row length.
        int n = image[0].length;                                // matrix's column length.
        int intCol = image[sr][sc];                             // storing initial colour of the node in matrix
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};       // this is directions array which helps us to traverse both vertically and horizontally through matrix.
                
        Queue<Integer> q = new LinkedList<>();                  // initializing queue.
        q.add(sr);                                              // adding given row of node into queue.
        q.add(sc);                                              // adding given column of node into queue.
        image[sr][sc] = color;                                  // updating the given intial node to given color i.e, 2 in this case.
        
        while(!q.isEmpty()){                                    // while loop will run as long as queue is not empty.
            int currR = q.poll();                               // get the current row from top of queue.
            int currC = q.poll();                               // get the current column from top of queue.
            for(int[] dir : directions){                        // traverse over the directions array to get the next nodes.
                int nr = currR + dir[0];                        // storing next/neighbouring node as per directions and given row of node.
                int nc = currC + dir[1];                        // storing next/neighbouring node as per directions and given column of node.

                if(nr >=0 && nc >=0 && nr < m                   // validating if the next/neighbouring node values are in range of 0 and length of row & column of matrix.
                && nc < n && image[nr][nc] == intCol){          // validation if the given node of matrix is same as intial color.
                    q.add(nr);                                  // add the neighbouring row of node to queue to contiue until related nodes are given color.
                    q.add(nc);                                  // add the neighbouring column of node to queue to contiue until related nodes are given color.
                    image[nr][nc] = color;                      // updating the given node of matrix to given color.
                }
            }

        }
        return image;
        
    }
}


//Time Complexity : O(m*n) 
//Space Complexity : O(m*n)
//m = matrix's row length & n = matrix's column length
/* Approach :  we are using DFS.
We first store the intial color and return back the matrix if it is empty or given node matches with the given color.
We use recursive approach where we traverse through every node of matrix checking if it is initial color, 
if yes then we change the node to given color and traverse vertically & horizontally until all the nodes of matrix are covered
or if no then we simply donot modify the node and keep traversing. Once the all the nodes of matrix are traversed then we return 
the updated matrix.
*/


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0) return image;            // validate whether given matrix is null or not
        if(image[sr][sc] == color) return image;                        // validate if the given node in matrix is same as the given color and returning the matrix assuming all other nodes are same as given color.

        int initCol = image[sr][sc];                                    // storing initial colour of the node in matrix
        int[][] directions = {{0,1},{0,-1},{-1,0},{1,0}};               // this is directions array which helps us to traverse both vertically and horizontally through matrix.

        helper(image,sr,sc,color,directions,initCol);                   // first call of recursive method with intial color, directions array, matrix, given row & column node.
        return image;
    }
    private void helper(int[][] image, int sr, int sc, int color,int[][] directions,int initCol){ // we are using void based method as we are passing the parameter in the method that needs to be modified.
        //base
        if(sr < 0 || sc < 0 || sr == image.length                       // validating if given/neighbouring row & column nodes are in range of 0 and matrix length and                   
        || sc == image[0].length || image[sr][sc] != initCol) return;   // also validating if given node matches the intial color, if not it will return to previous node and does not modify the node. 
        //logic
        image[sr][sc] = color;                                          // updating given/neighbouring node of matrix to given color.
        for(int[] dir:directions){                                      // traverse through the directions array to get the next nodes.
            int nr = dir[0] + sr;                                       // storing next/neighbouring node as per directions and given row of node.
            int nc = dir[1] + sc;                                       // storing next/neighbouring node as per directions and given column of node.
            helper(image,nr,nc,color,directions,initCol);               // keep calling helper method until all the nodes are visited in matrix.
        }
    }
}