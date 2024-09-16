//Time Complexity-O(No.of elements in the matrix+neighbours)=O(n)
//Space Complexity-O(No.of elements in the matrix)=O(n)
//Ran successfully on leetcode
//3 point algo-
	//1.We operate on the zeros first and push them into the queue because their dist is 0. Rest of the elements are turned to -1 for uniformity.
	//2.Then we maintain the size of the queue for tracking every level. Neighbours of 0 whihch are not operated on previously i.e -1, are changed to dist value(1) and pushed on to the queue.
	//3.For each level, we incremnt dist value. Finally return the matrix.

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& matrix) {
        if(matrix.empty())
            return matrix;
        queue<vector<int>>q;
        for(int i=0;i<matrix.size();i++)
            for(int j=0;j<matrix[0].size();j++)
            {
                if(matrix[i][j]==0)
                    q.push({i,j});
                else
                    matrix[i][j]=-1;
            }
        vector<vector<int>>dirs={{0,1},{1,0},{-1,0},{0,-1}};
        int dist=1;
        while(!q.empty())
        {
            int n=q.size();
            for(int i=0;i<n;i++)
            {
                vector<int>curr=q.front();
                q.pop();
                for(auto dir:dirs)
                {
                    int r=dir[0]+curr[0];
                    int c=dir[1]+curr[1];
                    if(r>=0 && r<matrix.size() && c>=0 && c<matrix[0].size() && matrix[r][c]==-1)
                    {
                        matrix[r][c]=dist;
                        q.push({r,c});
                    }
                }
            }
            dist++;
        }
        return matrix;
    }
};