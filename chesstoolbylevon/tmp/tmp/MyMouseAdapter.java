package tmp;

import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.JLabel;

/*
//private inner class
private class MyMouseAdapter extends MouseAdapter {
private JLabel piece = null;

// Point distance from dragging mouse to piece's left upper corner
private Point delta = null;

// location of chess piece prior to move
private int oldRank = -1;
private int oldFile = -1;
 
@Override
public void mousePressed(MouseEvent e) {
   Point p = e.getPoint();
   Component c = board.getComponentAt(p);

   // find out which square was clicked
   for (int rank = 0; rank < jPanelSquareGrid.length; rank++) {
      for (int file = 0; file < jPanelSquareGrid[rank].length; file++) {
         if (jPanelSquareGrid[rank][file] == c) {

            // the jPanelSquares are derived from JPanel but have a 
            // few of their own methods.  This checks to see if it holds a piece
            if (jPanelSquareGrid[rank][file].getChessPiece() != null) {                     
               piece = jPanelSquareGrid[rank][file].getChessPiece();
               oldRank = rank;
               oldFile = file;

               // remove piece from sqare and add to layered pane's drag layer
               jPanelSquareGrid[rank][file].remove(piece);
               mainLayeredPane.add(piece, JLayeredPane.DRAG_LAYER);

               // center piece over mouse
               int x = p.x - PIECE_WIDTH/2;
               int y = p.y - PIECE_WIDTH/2;
               piece.setLocation(x, y);
                
               delta = new Point(p.x - x, p.y - y);
               board.revalidate();
               mainLayeredPane.repaint();
               return;
            }
         }
      }
   }
    
   // no piece found
   oldFile = -1;
   oldRank = -1;
}
 
@Override
public void mouseDragged(MouseEvent e) {
   if (piece != null) {
      Point p = e.getPoint();
      int x = p.x - delta.x;
      int y = p.y - delta.y;
      piece.setLocation(x, y);
      mainLayeredPane.revalidate();
      mainLayeredPane.repaint();
   }
}
 
@Override
public void mouseReleased(MouseEvent e) {
   if (piece != null) {
      // find the square that we've released over
      JPanelSquare sqr = (JPanelSquare) board.getComponentAt(e.getPoint());

      // no matter what happens, the layered pane loses the piece
      mainLayeredPane.remove(piece);  

      // if released off of board grid or move is not valid
      if (sqr == null || !validMove(sqr)) {
         // return piece to original square
         jPanelSquareGrid[oldRank][oldFile].add(piece);
      } else {
         // otherwise add to new square
         sqr.add(piece);
      }

      // re-initialize things
      piece = null;
      delta = null;
       
      oldRank = -1;
      oldFile = -1;
       
      board.revalidate();
      mainLayeredPane.repaint();
   }
}

// just a pawn's moves
private boolean validMove(JPanelSquare sqr) {
   int rank = sqr.getRank();
   int file = sqr.getFile();
    
   if (file != oldFile) {
      return false;
   }
   if (oldRank == 1 && (rank != 2 && rank != 3)) {
      return false;
   }
   if (oldRank != 1 && rank != oldRank + 1) {
      return false;
   }
   return true;
}
}
*/
