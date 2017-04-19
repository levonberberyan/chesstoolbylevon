package levonberberyan.chesstournamentorganizer.chessboard;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import levonberberyan.chesstournamentorganizer.chessmove.ChessMove;
import levonberberyan.chesstournamentorganizer.chesspiece.ChessPieceAbstract;
import levonberberyan.chesstournamentorganizer.chesspiece.ChessPieceAbstractEnum;

  
public class ChessBoardAsSwingWindow extends JFrame implements ChessBoardI, MouseListener, MouseMotionListener {
    JLayeredPane layeredPane;
    JPanel chessBoard;
    JLabel chessPiece;
    int xAdjustment;
    int yAdjustment;
	int sx,sy;
	int dx,dy;
 
	int x,y;
	
	public ChessBoardAsSwingWindow(ChessBoardI theBoard){
        /*Dimension boardSize = new Dimension(600, 600);
  
        //Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
 
        //Add a chess board to the Layered Pane 
  
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        boolean flag=false;
        for (int j = 0; j < 8; j++) {
        	if(j%2==0)
        		flag=false;
        	else if(j%2==1)
        		flag=true;
        	for(int i=0;i<8;i++){
        		JPanel square = new JPanel( new BorderLayout() );
        		chessBoard.add( square );
        		if(flag==true)
        			square.setBackground( i % 2 == 0 ? Color.GRAY : Color.LIGHT_GRAY );
        		else
        			square.setBackground( i % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY );
            }
        }
        
        //Add a few pieces to the board
        for(int y = 0; y < 8; y++)
        	for(int x = 0; x < 8; x++){
        		if(theBoard.getFigureOnXY(y, x) != null){
        			if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.WHITE_BISHOP)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/bishopw.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.WHITE_KING)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/kingw.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.WHITE_KNIGHT)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/knightw.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.WHITE_PAWN)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/pawnw.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.WHITE_QUEEN)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/queenw.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.WHITE_ROOK)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/rookw.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.BLACK_BISHOP)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/bishopb.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.BLACK_KING)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/kingb.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.BLACK_KNIGHT)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/knightb.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.BLACK_PAWN)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/pawnb.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.BLACK_QUEEN)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/queenb.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x );
	                    panel.add(label);
	        		}
	        		else if(theBoard.getFigureOnXY(y, x).equals(ChessmanAbstract.BLACK_ROOK)){
	        			JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/rookb.png")) );
	        			JPanel panel = (JPanel)chessBoard.getComponent(y*8 + x);
	                    panel.add(label);
	        		}
        		}
        		else{
        			
        		}
        	}
        
        this.setSize(new Dimension(625, 655));
        
        this.setVisible(true);*/
    } 
	
    public ChessBoardAsSwingWindow(){
        Dimension boardSize = new Dimension(600, 600);
  
        //Use a Layered Pane for this this application
        layeredPane = new JLayeredPane();
        getContentPane().add(layeredPane);
        layeredPane.setPreferredSize(boardSize);
        layeredPane.addMouseListener(this);
        layeredPane.addMouseMotionListener(this);
 
        //Add a chess board to the Layered Pane 
  
        chessBoard = new JPanel();
        layeredPane.add(chessBoard, JLayeredPane.DEFAULT_LAYER);
        chessBoard.setLayout( new GridLayout(8, 8) );
        chessBoard.setPreferredSize( boardSize );
        chessBoard.setBounds(0, 0, boardSize.width, boardSize.height);
        boolean flag=false;
        for (int j = 0; j < 8; j++) {
        	if(j%2==0)
        		flag=false;
        	else if(j%2==1)
        		flag=true;
        	for(int i=0;i<8;i++){
        		JPanel square = new JPanel( new BorderLayout() );
        		chessBoard.add( square );
        		if(flag==true)
        			square.setBackground( i % 2 == 0 ? Color.GRAY : Color.LIGHT_GRAY );
        		else
        			square.setBackground( i % 2 == 0 ? Color.LIGHT_GRAY : Color.GRAY );
            }
        }
        
        //Add a few pieces to the board
        
        // Blacks
        JLabel label = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/rookb.png")) );
        JPanel panel = (JPanel)chessBoard.getComponent(0);
        panel.add(label);
        
        JLabel label2 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/knightb.png")) );
        JPanel panel2 = (JPanel)chessBoard.getComponent(1);
        panel2.add(label2);
        
        JLabel label3 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/bishopb.png")) );
        JPanel panel3 = (JPanel)chessBoard.getComponent(2);
        panel3.add(label3);
        
        JLabel label4 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/queenb.png")) );
        JPanel panel4 = (JPanel)chessBoard.getComponent(3);
        panel4.add(label4);
        
        JLabel label5 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/kingb.png")) );
        JPanel panel5 = (JPanel)chessBoard.getComponent(4);
        panel5.add(label5);
        
        JLabel label6 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/bishopb.png")) );
        JPanel panel6 = (JPanel)chessBoard.getComponent(5);
        panel6.add(label6);
        
        JLabel label7 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/knightb.png")) );
        JPanel panel7 = (JPanel)chessBoard.getComponent(6);
        panel7.add(label7);
        
        JLabel label8 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/rookb.png")) );
        JPanel panel8 = (JPanel)chessBoard.getComponent(7);
        panel8.add(label8);
        
        JLabel labels[] = new JLabel[8];
        JPanel panels[] = new JPanel[8];
        for(int i = 0; i < 8; i++){
        	labels[i] = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/pawnb.png")) );
            panels[i] = (JPanel)chessBoard.getComponent(i+8);
            panels[i].add(labels[i]);
        }
        
        // WHITES
        JLabel labels2[] = new JLabel[8];
        JPanel panels2[] = new JPanel[8];
        for(int i = 0; i < 8; i++){
        	labels2[i] = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/pawnw.png")) );
            panels2[i] = (JPanel)chessBoard.getComponent(i+48);
            panels2[i].add(labels2[i]);
        }
        
        JLabel label9 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/rookw.png")) );
        JPanel panel9 = (JPanel)chessBoard.getComponent(56);
        panel9.add(label9);
        
        JLabel label10 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/knightw.png")) );
        JPanel panel10 = (JPanel)chessBoard.getComponent(57);
        panel10.add(label10);
        
        JLabel label11 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/bishopw.png")) );
        JPanel panel11 = (JPanel)chessBoard.getComponent(58);
        panel11.add(label11);
        
        JLabel label12 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/kingw.png")) );
        JPanel panel12 = (JPanel)chessBoard.getComponent(59);
        panel12.add(label12);
        
        JLabel label13 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/queenw.png")) );
        JPanel panel13 = (JPanel)chessBoard.getComponent(60);
        panel13.add(label13);
        
        JLabel label14 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/bishopw.png")) );
        JPanel panel14 = (JPanel)chessBoard.getComponent(61);
        panel14.add(label14);
        
        JLabel label15 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/knightw.png")) );
        JPanel panel15 = (JPanel)chessBoard.getComponent(62);
        panel15.add(label15);
        
        JLabel label16 = new JLabel( new ImageIcon(this.getClass().getResource("/chesspieces/rookw.png")) );
        JPanel panel16 = (JPanel)chessBoard.getComponent(63);
        panel16.add(label16);
        
        this.setSize(new Dimension(625, 655));
        
        this.setVisible(true);
    } 
    
    public void mousePressed(MouseEvent e){
        chessPiece = null;
        Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
        x=e.getX();
        y=e.getY();
 
        //sx=source x
 
        sx=(e.getX())/75;   
        sy=(e.getY())/75;
        System.out.println(sx);
 
        if (c instanceof JPanel) 
        	return;
        
        
  
        Point parentLocation = c.getParent().getLocation();
        //System.out.println(parentLocation.x);
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        chessPiece = (JLabel)c;
        chessPiece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        chessPiece.setSize(chessPiece.getWidth(), chessPiece.getHeight());
        layeredPane.add(chessPiece, JLayeredPane.DRAG_LAYER);
    }
    
    //Move the chess piece around
    public void mouseDragged(MouseEvent me) {
        if (chessPiece == null) return;
         chessPiece.setLocation(me.getX() + xAdjustment, me.getY() + yAdjustment);
	}
      
	//Drop the chess piece back onto the chess board
    public void mouseReleased(MouseEvent e) {
        if(chessPiece == null) return;
  
        //dx= destination x     
        dx=(e.getX())/75;
        dy=(e.getY())/75;
 
        //Here d main logic comes
 
        //if((sx==dx) || (sy==dy))
        //{
        	chessPiece.setVisible(false);
        	System.out.println(dy);
        	
        	Component c =  chessBoard.findComponentAt(e.getX(), e.getY());
 
        	if (c instanceof JLabel){
        		Container parent = c.getParent();
        		parent.remove(0);
        		parent.add( chessPiece );
        	}
        	else {
        		Container parent = (Container)c;
        		parent.add( chessPiece );
     
        	}
        	chessPiece.setVisible(true);
 
        //}
        //else
        	//i think problem is here
        	//chessPiece.setLocation(x + xAdjustment, y + yAdjustment);
 
    }        
 
	public void mouseClicked(MouseEvent e) {
   
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e){
   
	}
	public void mouseExited(MouseEvent e) {
   
	}
  
 
	public static void main(String[] args) {
		JFrame frame = new ChessBoardAsSwingWindow();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE );
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
	}

	public void showInfo() {
		// TODO Auto-generated method stub
		
	}

	public void registerMove(String move) {
		// TODO Auto-generated method stub
		
	}

	public void setFigureOnXY(int y, int x, String aFigureLetter) {
		// TODO Auto-generated method stub
		
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

	public boolean getTurnColor() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setTurnColor(boolean aColor) {
		// TODO Auto-generated method stub
		
	}

	public String getCastlingAvailability() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCastlingAvailability(String aCastling) {
		// TODO Auto-generated method stub
		
	}

	public String getEnPassant() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEnPassant(String aAnPassant) {
		// TODO Auto-generated method stub
		
	}

	public int getHalfMovesNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setHalfMovesNumber(int aHalfMovesNumber) {
		// TODO Auto-generated method stub
		
	}

	public int getFullMovesNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setFullMovesNumber(int aFullMovesNumber) {
		// TODO Auto-generated method stub
		
	}

	public void incrementFullMovesNumber() {
		// TODO Auto-generated method stub
		
	}

	public void setBoardMatrix(String[][] theBoardMatrix) {
		// TODO Auto-generated method stub
		
	}

	public void registerSymbolicMove(String theSymbolicMove) {
		// TODO Auto-generated method stub
		
	}

	public void setFigureOnXY(int theY, int theX, ChessPieceAbstract theChessPiece) {
		// TODO Auto-generated method stub
		
	}

	public void setBoardMatrix(ChessPieceAbstract[][] theBoardMatrix) {
		// TODO Auto-generated method stub
		
	}

	public ChessPieceAbstract getFigureOnXY(int theY, int theX) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChessPieceAbstractEnum[][] getBoardMatrix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBoardMatrix(ChessPieceAbstractEnum[][] theBoardMatrix) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChessPieceAbstractEnum getChessPieceOnXY(int theY, int theX) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setChessPieceOnXY(int theY, int theX,
			ChessPieceAbstractEnum theChessman) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void applyMoveToBoard(ChessMove theMove) {
		// TODO Auto-generated method stub
		
	}
}
