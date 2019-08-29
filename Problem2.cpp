/*Time Complexity : O(M*N)
Space Complexity : O(M*N) // Created a DP matrix for result. 

Did it run on LeetCode : No. - > RunTime Error.
Any problems? : Took help from Jaspinder's LeetCode solution.

*/


class Solution {
public:
    
    int min(int a, int b)
    {
        if (a>b)
            return b;
        else
            return a;
    }
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        int row = matrix.size();
        int col = matrix[0].size();
        vector<vector<int>>dp;
        
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                dp[i][j]=(DFS(matrix,dp,i,j));
            }
        }
        return dp;
    } 
        
        int DFS(vector<vector<int>> matrix , vector<vector<int>> dp , int i , int j)
        {
            int m = matrix.size() ;
        int n = matrix[0].size();
            if(i<0 || i>m-1 || j < 0 || j > n-1) return 9999; 
            
             if(matrix[i][j] == 0) return 0;
            
            // Find 0 on Top : 
            if(i > 0 && matrix[i-1][j] == 0) return 1;
            
            //Find 0 - left : 
            if(j>0 && matrix[i][j-1] == 0) return 1;
            
            // Find 0 - bottom  : 
            if(i < m-1 && matrix[i+1][j] == 0) return 1;
            
           // Find 0 - right :
            if(j<n-1 && matrix[i][j+1]==0) return 1;
            
            int left,bottom,right,top;
        
       left=9999; top = 9999;
        if(i > 0 && dp[i-1][j] != 0){
            top = dp[i-1][j];
        }
            
            if(j> 0 && dp[i][j-1] != 0)
            {
            left = dp[i][j-1];
        }
            
            bottom = DFS(matrix, dp,i+1, j);
            right=DFS(matrix, dp , i, j+1);
            
            return min(min(left,right), min(top,bottom)+1);
        }        
    };