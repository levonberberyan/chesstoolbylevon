package levonberberyan.chesstoolbylevon.chessboard;

import java.util.Arrays;

import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractEnum;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceAbstractHandler;
import levonberberyan.chesstoolbylevon.chesspiece.ChessPieceSymbolicHandler;

public final class ChessBoardAsCharArray implements ChessBoardI{
	/**
	 * Show Current Board State
	 */
	public void showCurrentBoardState(){
		String aSeparator = "";
		char[][] aBoardMatrixWithTitledColumns = new char[10][10];
		// add Y Letters
		for(int y = 0; y < 8; y++){
			aBoardMatrixWithTitledColumns[y][0] = Character.forDigit(8-y, 10);
		}
		// two empty Y-s
		aBoardMatrixWithTitledColumns[8][0] = ' ';
		aBoardMatrixWithTitledColumns[9][0] = ' ';
		// add X Letters
		aBoardMatrixWithTitledColumns[9][2] = 'a';
		aBoardMatrixWithTitledColumns[9][3] = 'b';
		aBoardMatrixWithTitledColumns[9][4] = 'c';
		aBoardMatrixWithTitledColumns[9][5] = 'd';
		aBoardMatrixWithTitledColumns[9][6] = 'e';
		aBoardMatrixWithTitledColumns[9][7] = 'f';
		aBoardMatrixWithTitledColumns[9][8] = 'g';
		aBoardMatrixWithTitledColumns[9][9] = 'h';
		//2 empty X-s
		aBoardMatrixWithTitledColumns[9][0] = ' ';
		aBoardMatrixWithTitledColumns[9][1] = ' ';
		//2 empty rows
		for(int y = 0; y < 10; y++){
			aBoardMatrixWithTitledColumns[y][1] = ' ';
		}
		for(int x = 0; x < 10; x++){
			aBoardMatrixWithTitledColumns[8][x] = ' ';
		}
		// add board values
		for(int y = 0; y < 8; y++)
			for(int x = 2; x < 10; x++){
				aBoardMatrixWithTitledColumns[y][x] = getCharAt(y, x-2);
			}
		// print board with titled columns
		for(int y = 0; y < 10; y++)
			for(int x = 0; x < 10; x++){
				if(x==9) {aSeparator = "\n";} else {aSeparator = " ";}
				System.out.print(aBoardMatrixWithTitledColumns[y][x] + aSeparator);
			}
	}
	/**
	 * Set chess piece at x,y from Abstract Piece
	 */
	public void setChessPieceOnXYFromAbstractPiece(int theY, int theX, ChessPieceAbstractEnum theChessPiece){
		setCharAt(theY, theX, ChessPieceSymbolicHandler.convertAbstractChessPieceToSymbolic(theChessPiece));
	}
	/**
	 * Get Abstract chess piece at y, x
	 * (y,x) instead of (x,y) because of simple array structure
	 */
	public ChessPieceAbstractEnum getAbstractChessPieceatAtXY(int theY, int theX){
		return ChessPieceAbstractHandler.convertSymbolicChessPieceToAbstract(getCharAt(theY, theX));
	}
	/**
	 * Set Board from Abstract Pieces Matrix
	 */
	public void setBoardFromAbstractPiecesMatrix(ChessPieceAbstractEnum[][] theBoardAbstractEnumMatrix){
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++){
				setCharAt(i, j, ChessPieceSymbolicHandler.convertAbstractChessPieceToSymbolic(theBoardAbstractEnumMatrix[i][j]));
			}
	}
	/**
	 * Get board as Abstract Pieces matrix
	 */
	public ChessPieceAbstractEnum[][] getBoardAsAbstractPiecesMatrix(){
		ChessPieceAbstractEnum[][] aBoardAbstractEnumMatrix = new ChessPieceAbstractEnum[8][8];
		for(int y = 0; y < 8; y++)
			for(int x = 0; x < 8; x++)
				aBoardAbstractEnumMatrix[y][x] = getAbstractChessPieceatAtXY(y, x);
		return aBoardAbstractEnumMatrix;
	}
	/**
	 * Set Board at x,y
	 */
	public void setCharAt(int theY, int theX, char theValue){
		chessBoardMatrix[theY][theX] = theValue;
	}
	/**
	 * Get Board char at x,y
	 */
	public char getCharAt(int theY, int theX){
		return chessBoardMatrix[theY][theX];
	}
	/**
	 * Initialize Board with initial chess state
	 */
	public void initializeBoardState(){
		char[][] aInitialChessBoardArr = {
				{'r','n','b','q','k','b','n','r'},
	            {'p','p','p','p','p','p','p','p'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'P','P','P','P','P','P','P','P'},
	            {'R','N','B','Q','K','B','N','R'}};
		setChessBoardMatrix(aInitialChessBoardArr);
	}
	/**
	 * Default Constructor
	 */
	public ChessBoardAsCharArray(){
		char[][] aEmptyChessBoardArr = {
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'},
	            {'o','o','o','o','o','o','o','o'}}; // temporary board state for operations
		setChessBoardMatrix(aEmptyChessBoardArr);
		ActiveChessBoardsHandler.addNewActiveChessBoard(this);
	}
	/**
	 * Getters, Setters
	 */
	public char[][] getChessBoardMatrix(){
		// skip direct access to matrix
		char[][] aIntermediateChessBoardMatrix = Arrays.copyOf(chessBoardMatrix, chessBoardMatrix.length);
		return aIntermediateChessBoardMatrix;
	}
	public void setChessBoardMatrix(char[][] theChessBoardMatrix){chessBoardMatrix = theChessBoardMatrix;}
	/**
	 * Board Matrix
	 */
	private char[][] chessBoardMatrix;
}
