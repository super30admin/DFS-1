//Time Complexity-O(m*n) -total number of elements in the matrix
//Space Complexity-O(m*n)- if we have all 0's in the matrix(worst case)
//Did the code run on leetcode? yes

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        queue<vector<int>>k;
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix[0].size();j++)
            {
                if(matrix[i][j]==0)
                {
                    k.push({i,j});
                }
            }
        }
        int level=1;
        vector<vector<int>>dir={{0,1},{0,-1},{1,0},{-1,0}};
        while(!k.empty())
        {
            int size=k.size();
            while(size!=0)
            {
                vector<int>m=k.front();
                k.pop();
                for(int i=0;i<dir.size();i++)
                {
                    vector<int>a=dir[i];
                    int row=a[0]+m[0];
                    int col=a[1]+m[1];
                    if(row>=0 && row<matrix.size() && col>=0 && col<matrix[0].size())
                    {
                        if(matrix[row][col]==1)
                        {
                            matrix[row][col]=-level;
                            k.push({row,col});
                        }
                    }
                }
                size--;
            }
            level++;
        }
        for(int i=0;i<matrix.size();i++)
        {
            for(int j=0;j<matrix[0].size();j++)
            {
                matrix[i][j]=-matrix[i][j];
            }
        }
        return matrix;
    }
};