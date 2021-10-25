//Time complexity:- o(mn);
//space complexity:-0(1);
//Did it run on leetcode:-Yes;
// what problems you faced while doing this sum?:- initially got wrong ansers.
//your code with explanation:- initially we can do this by bfs as it can have multiple statrting values,Also it said to 
// get global nearest so dp also can be used. I used dynamic programming concept where first for non zero elements checking
//zero in top and left and present value is changed in the minimum of top,left+1because if it is adjacent you get o but as it is adjacent adding 1 to it.
//similary bottom,right are used to change but in math.min we consider present element also as it was first changed in first nested loop.




class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int max=100000;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=0){
                    int top= i-1>=0 ?mat[i-1][j]: max;
                    int left=j-1>=0?mat[i][j-1]:max;
                    mat[i][j]=Math.min(left,top)+1;
                }
                
            }
        }
        for(int k=m-1;k>=0;k--){
           for(int l=n-1;l>=0;l--){
               int bottom=k+1<m?mat[k+1][l]:max;
               int right=l+1<n?mat[k][l+1]:max;
               mat[k][l]=Math.min(Math.min(bottom,right)+1,mat[k][l]);
           } 
        }
       return mat; }
    
    
    }
