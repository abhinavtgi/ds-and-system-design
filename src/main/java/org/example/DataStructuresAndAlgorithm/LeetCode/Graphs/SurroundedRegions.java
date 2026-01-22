package org.example.DataStructuresAndAlgorithm.LeetCode.Graphs;

//https://leetcode.com/problems/surrounded-regions/description/
public class SurroundedRegions {
    void markBoundaryRegions(int i, int j, char[][] board, int m, int n) {
        if(i>=m || i<0 || j>=n || j<0 || board[i][j]=='X' || board[i][j]=='K') {
            return;
        }
        board[i][j]='K';
        markBoundaryRegions(i+1,j,board,m,n);
        markBoundaryRegions(i-1,j,board,m,n);
        markBoundaryRegions(i,j+1,board,m,n);
        markBoundaryRegions(i,j-1,board,m,n);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++) {
            markBoundaryRegions(i,0,board,m,n);
            markBoundaryRegions(i,n-1,board,m,n);
        }

        for(int j=0;j<n;j++) {
            markBoundaryRegions(0,j,board,m,n);
            markBoundaryRegions(m-1,j,board,m,n);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j]=='K') {
                    board[i][j]='O';
                }
            }
        }
    }
}
