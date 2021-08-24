/*
Time Complexity = O(M*N)
Space Complexity =O(M*N)
Where M is the number of rows and N is the number of columns in the matrix.
*/
class Solution {
public:
    int m,n;
    int color;
    void dfs(vector<vector<int>>& image, int r, int c, int newColor)
    {
        //base
        if(r<0 || r>=m || c<0 || c>=n || color!=image[r][c])
            return;
            
        //logic
        image[r][c] = newColor;
        dfs(image, r+0, c+1 , newColor);
        dfs(image, r+1, c+0 , newColor);
        dfs(image, r+0, c-1 , newColor);
        dfs(image, r-1, c+0 , newColor);
    }
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        color = image[sr][sc];
        m = image.size();
        n = image[0].size();
        dfs(image, sr, sc, newColor);
        return image;
    }
};

/*
Time Complexity = O(M*N)
Space Complexity =O(M*N)
Where M is the number of rows and N is the number of columns in the matrix.
*/
class Solution {
public:
    int m,n;
    int color;
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor)
            return image;
        color = image[sr][sc];
        m = image.size();
        n = image[0].size();
        int size,i,j;
        queue<vector<int>> q;
        vector <vector<int>> dirs{{0,1}, {1,0}, {-1,0}, {0,-1}};
        q.push({sr,sc});
        image[sr][sc] = newColor;
        while(!q.empty())
        {
            size = q.size();
            vector<int> temp(q.front());
            q.pop();
            for(i=0;i<size;i++)
            {
                for(j=0;j<4;j++){
                int r = temp[0] +  dirs[j][0];
                int c = temp[1] + dirs[j][1];
                    if(r>=0 && r<m && c>=0 && c<n && image[r][c]==color)
                    {
                        q.push({r,c});
                        image[r][c] = newColor;
                    }
                }
            }
        }
        return image;
    }
};
