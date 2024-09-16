//Time Complexity-O(No.of elements in the matrix)
//Space Complexity-O(No.of elements in the matrix)
//Ran successfully on leetcode
//3 point algo-
	//1a)Using bfs, we push the chosen element index into the queue and change it to the new colour.
	//1b)Then for all its neighbours which are of old colour i.e. not operated on, colour is changed to new colour and it is pushed into the queue.
	//2a)Using dfs, we visit all the neighbours of the given element one by one.
	//2b)If it is of old colour, we change it to the new colour and call the recursion on it again so that its neighbours can be operated on.

class Solution {
public:
	/*bfs
	vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.empty()||(image[sr][sc]==newColor))
            return image;
        int old_colour=image[sr][sc];
        queue<vector<int>>q;
        q.push({sr,sc});
        image[sr][sc]=newColor;
        vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.empty())
        {
            vector<int>curr=q.front();
            q.pop();
            //image[curr[0]][curr[1]]=newColor;            
            for(auto dir:dirs)
            {
                int r=curr[0]+dir[0];
                int c=curr[1]+dir[1];
                if(r>=0 && r<image.size() && c>=0 && c<image[0].size() && image[r][c]==old_colour)
                {
                    image[r][c]=newColor;
                    q.push({r,c});
                }
            }
        }
        return image;   
    }*/
	//dfs
    vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
    vector<vector<int>> floodFill(vector<vector<int>>&image, int sr, int sc, int newColor) {
        if(image.empty() || newColor==image[sr][sc])
            return image;
        int old_colour=image[sr][sc];
        dfs(image,sr,sc,old_colour,newColor);
        return image;
    }
    void dfs(vector<vector<int>>&image,int sr,int sc,int old_colour,int newColor)
    {
        if(sr<0 || sr>=image.size() || sc<0 || sc>=image[0].size() || image[sr][sc]!=old_colour)
            return;
        image[sr][sc]=newColor;
        for(auto dir:dirs)
        {
            int r=dir[0]+sr;
            int c=dir[1]+sc;
            
            dfs(image,r,c,old_colour,newColor);
        }
    }
};