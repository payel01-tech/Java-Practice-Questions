package RecursionBackTrackingProblems;

public class SudokuSolver {
    public static void main(String args[])
    {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
    }
    public static void solveSudoku(char[][] board) {
        int startRow=0,column=0;
        solveSudokuImpl(board,startRow,column);
    }
    public static boolean solveSudokuImpl(char[][] board,int row,int column) {
        if(row==board.length)
            return true;
        if(column==board.length)
        {
            row=row+1;
            column=0;
            return solveSudokuImpl(board,row,column);
        }
        if(board[row][column]!='.')
            return solveSudokuImpl(board,row,column+1);
        for(char i = '1'; i<='9'; i++)
        {
            if(isSafe(board,row,column,i))
            {
                board[row][column]= i;
                if(solveSudokuImpl(board, row, column+1))
                    return true;
                board[row][column]='.';
            }
        }
        return false;
    }

    public static boolean isSafe(char[][] board, int row, int column, char i) {
        //horizontal
        for(int j=0;j<board[0].length;j++)
        {
            if(board[row][j]==i)
                return false;
        }

        //vertical
        for(int j=0;j< board.length;j++)
        {
            if(board[j][column]==i)
                return false;
        }

        //grid
        int startRow=(row/3)*3;
        int startColumn=(column/3)*3;
        for(int r=startRow;r<=startRow+2;r++)
        {
            for(int c=startColumn;c<=startColumn+2;c++)
            {
                if(board[r][c]==i)
                    return false;
            }
        }
        return true;
    }
}
