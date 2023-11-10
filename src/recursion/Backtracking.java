package recursion;

public class Backtracking {
	public static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// QueenPermutation(new boolean[4],0,2,"");
		// QueenCombination(new boolean[4],0,2,"",-1);
		int arr[] = { 2, 3, 5,6 };
		//coinChangeCombination(arr,10,"",0);
		coinChangePermutation(arr,10,"");
		// System.out.println("hello");
		//coinChangeCoinRespect(arr,0,10,"");
		// queenCombinationBoxRespect2DKill(new boolean[3][4], 0, 0, 0, 3, "");
		//NKnights(new boolean[3][3], 0, 0, 0, 3, "");

	}

	public static void QueenPermutation(boolean box[], int qpsf, int tq, String ans) {
		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = 0; i < box.length; i++) {
			if (box[i] == false) {
				box[i] = true;
				QueenPermutation(box, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ");
				// undo
				box[i] = false;

			}
		}

	}

	public static void QueenCombination(boolean box[], int qpsf, int tq, String ans, int lastboxused) {
		if (qpsf == tq) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}

		for (int i = lastboxused + 1; i < box.length; i++) {
			box[i] = true;
			QueenCombination(box, qpsf + 1, tq, ans + "q" + qpsf + "b" + i + " ", i);
			// undo
			box[i] = false;

		}

	}

	public static void coinChangeCombination(int[] denom, int amount, String ans, int lastdenoidx) {
		if (amount == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
		for (int i = lastdenoidx; i < denom.length; i++) {
			if (amount >= denom[i])
				coinChangeCombination(denom, amount - denom[i], ans + denom[i], i);
		}
	}

	public static void coinChangePermutation(int[] denom, int amount, String ans) {
		if (amount == 0) {
			count++;
			System.out.println(count + ". " + ans);
			return;
		}
		for (int i = 0; i < denom.length; i++) {
			if (amount >= denom[i]) {
				coinChangePermutation(denom, amount - denom[i], ans + denom[i]);
			}
		}
	}

	public static void queenCombinationBoxRespect(boolean board[], int col, int qpsf, int tq, String ans) {
		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}
		// negative bc
		if (col == board.length) {
			return; 
		}
		// place
		board[col] = true;
		queenCombinationBoxRespect(board, col + 1, qpsf + 1, tq, ans + "b" + col);
		board[col] = false;// undo
		// not place
		queenCombinationBoxRespect(board, col + 1, qpsf, tq, ans);
	}

	public static void coinChangeCoinRespect(int[] coin, int vidx, int amt, String ans) {
		// positive base case
		if (amt == 0) {
			System.out.println(ans);
			return;
		}
		// negative bc
		if (amt < 0 || vidx == coin.length) {
			return;
		}

		// coin gives contribute
		coinChangeCoinRespect(coin, vidx, amt - coin[vidx], ans + coin[vidx]);
		// coin does not give contribute
		coinChangeCoinRespect(coin, vidx + 1, amt, ans);
	}

	// manually variable change approch
	public static void queenCombinationBoxRespect2D(boolean board[][], int row, int col, int qpsf, int tq, String ans) {
		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// manually variable change
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		// negative bc
		if (row == board.length) {
			return;
		}
		// place
		board[row][col] = true;
		queenCombinationBoxRespect2D(board, row, col + 1, qpsf + 1, tq, ans + "(" + row + "," + col + ")");
		board[row][col] = false;// undo
		// not place
		queenCombinationBoxRespect2D(board, row, col + 1, qpsf, tq, ans);
	}

	// extra recrsive call approch
	public static void queenCombinationBoxRespect2DRecCall(boolean board[][], int row, int col, int qpsf, int tq,
			String ans) {
		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// extra rec call
		if (col == board[0].length) {
			queenCombinationBoxRespect2DRecCall(board, row + 1, 0, qpsf, tq, ans);
			return;
		}
		// negative bc
		if (row == board.length) {
			return;
		}
		// place
		board[row][col] = true;
		queenCombinationBoxRespect2DRecCall(board, row, col + 1, qpsf + 1, tq, ans + "(" + row + "," + col + ")");
		board[row][col] = false;// undo
		// not place
		queenCombinationBoxRespect2DRecCall(board, row, col + 1, qpsf, tq, ans);
	}

	public static void queenCombinationBoxRespect2DKill(boolean board[][], int row, int col, int qpsf, int tq,
			String ans) {
		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// manually variable change
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		// negative bc
		if (row == board.length) {
			return;
		}
		// place
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			queenCombinationBoxRespect2DKill(board, row, col + 1, qpsf + 1, tq, ans + "(" + row + "," + col + ")");
			board[row][col] = false;// undo
		}
		// not place
		queenCombinationBoxRespect2DKill(board, row, col + 1, qpsf, tq, ans);
	}

	public static boolean isItSafeToPlaceTheQueen(boolean[][] board, int row, int col) {
		// vertically upward
		int r = row - 1;
		int c = col;

		while (r >= 0) {
			if (board[r][c])
				return false;
			r--;
		}

		// horizontally left
		r = row;
		c = col - 1;
		while (c >= 0) {
			if (board[r][c])
				return false;
			c--;

		}
		// digonally left
		r = row - 1;
		c = col - 1;
		while (c >= 0 && r >= 0) {
			if (board[r][c])
				return false;
			c--;
			r--;

		}
		// digonally right
		r = row - 1;
		c = col + 1;
		while (c < board[0].length && r >= 0) {
			if (board[r][c])
				return false;
			c++;
			r--;

		}

		return true;
	}

	public static void NQueen(boolean board[][], int row, int col, int qpsf, int tq, String ans) {
		// positive bc
		if (qpsf == tq) {
			System.out.println(ans);
			return;
		}

		// manually variable change
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		// negative bc
		if (row == board.length) {
			return;
		}
		// place
		if (isItSafeToPlaceTheQueen(board, row, col)) {
			board[row][col] = true;
			NQueen(board, row, col + 1, qpsf + 1, tq, ans + "(" + row + "," + col + ")");
			board[row][col] = false;// undo
		}
		// not place
		NQueen(board, row, col + 1, qpsf, tq, ans);
	}

	public static void NKnights(boolean board[][], int row, int col, int kpsf, int tk, String ans) {
		// positive bc
		if (kpsf == tk) {
			System.out.println(++count + ". " + ans);
			return;
		}

		// manually variable change
		if (col == board[0].length) {
			row++;
			col = 0;
		}
		// negative bc
		if (row == board.length) {
			return;
		}
		// place
		if (isItSafeToPlaceTheKnights(board, row, col)) {
			board[row][col] = true;
			NKnights(board, row, col + 1, kpsf + 1, tk, ans + "(" + row + "," + col + ")");
			board[row][col] = false;// undo
		}
		// not place
		NKnights(board, row, col + 1, kpsf, tk, ans);
	}

	public static boolean isItSafeToPlaceTheKnights(boolean[][] board, int row, int col) {
		int rowArr[] = { -1, -2, -2, -1 };
		int colArr[] = { 2, 1, -1, -2 };
		for (int i = 0; i < 4; i++) {
			int r = row + rowArr[i];
			int c = col + colArr[i];
			if (r <= 0 && r > board.length && c <= 0 && c > board[0].length) {
				if (board[r][c])
					return false;
			}
		}
		return true;
	}
	//m2
	public static void Nqueen(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col]=true;
				Nqueen(board, row + 1, ans + "{" + row + "," + col + "}");
				board[row][col]=false;
			}
		}

	}
	public static boolean isItSafe(boolean[][] board,int row,int col) {
		//for up
		int c=col;
		int r=row-1;
		while(r>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
		}
		// for diagonally left
		c=col-1;
		 r=row-1;
		while(r>=0 && c>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		// for diagonally right
		c=col+1;
		 r=row-1;
		while(r>=0 && c<board[0].length) {
			if(board[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		return true;
		
	}
	public static void blockedMazePath(int[][] maze, int cr, int cc, boolean[][] visited, String ans) {
		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (cr > maze.length - 1 || cc > maze[0].length - 1 || cc < 0 || cr < 0 || visited[cr][cc] == true
				|| maze[cr][cc] == 1) {
			return;
		}
		visited[cr][cc] = true;
		blockedMazePath(maze, cr, cc + 1, visited, ans + "R");
		blockedMazePath(maze, cr + 1, cc, visited, ans + "D");
		blockedMazePath(maze, cr - 1, cc, visited, ans + "T");
		blockedMazePath(maze, cr, cc - 1, visited, ans + "L");
		visited[cr][cc] = false;
	}




}