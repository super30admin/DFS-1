//
// Created by shazm on 8/1/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>

using namespace std;

struct Index{
    int i;
    int j;
};

bool operator<(const Index& lhs, const Index& rhs){
    return tie(lhs.i,lhs.j) < tie(rhs.i,rhs.j);
}

class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if(image.empty()){return image;}
        stack<Index> Stack;
        Index dex1{sr,sc};
        int initial = image[sr][sc];
        Stack.push(dex1);
        Index dex;
        while(!Stack.empty()){
            dex = Stack.top(); Stack.pop();
            image[dex.i][dex.j] = newColor;
            if(validate(dex.i-1,dex.j,image) && image[dex.i-1][dex.j] != newColor && image[dex.i-1][dex.j] == initial){
                Index dex2{dex.i-1,dex.j};
                Stack.push(dex2);
            }
            if(validate(dex.i+1,dex.j,image)  && image[dex.i+1][dex.j] != newColor && image[dex.i+1][dex.j] == initial){
                Index dex2{dex.i+1,dex.j};
                Stack.push(dex2);
            }
            if(validate(dex.i,dex.j-1,image)  && image[dex.i][dex.j-1] != newColor && image[dex.i][dex.j-1] == initial){
                Index dex2{dex.i,dex.j-1};
                Stack.push(dex2);
            }
            if(validate(dex.i,dex.j+1,image)  && image[dex.i][dex.j+1] != newColor && image[dex.i][dex.j+1] == initial){
                Index dex2{dex.i,dex.j+1};
                Stack.push(dex2);
            }
        }
        return image;
    }
private:
    bool validate(int i, int j, vector<vector<int>>& image){
        if(i>=0 && i<image.size() && j<image[0].size() && j>=0){
            return true;
        }
        return false;
    }
};