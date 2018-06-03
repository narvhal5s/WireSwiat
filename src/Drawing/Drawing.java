package Drawing;

import board.Board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Drawing extends JFrame{
    private VisualBoard visualBoard;
    private JButton start_pause;

    public Drawing( Board startBoard){

        visualBoard = new VisualBoard( startBoard );
        visualBoard.setBackground(Color.white);

        start_pause = new JButton("Start");
        start_pause.addActionListener(visualBoard);

        this.add(visualBoard, BorderLayout.NORTH);
        this.add(start_pause, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private class VisualBoard extends JPanel implements ActionListener{

        private final int DEFAULT_CELL = 10, DEFAULT_INTERVAL = 1000 ;

        private Dimension board_size;
        private int cell_size, interval;
        private boolean run;
        private Timer timer;
        private Board startBoard ;

        public VisualBoard( Board startBoard){
            board_size = new Dimension(startBoard.getHeight(), startBoard.getWidth());
            this.startBoard = startBoard ;
            cell_size = DEFAULT_CELL;
            interval = DEFAULT_INTERVAL;
            run = false;
            timer = new Timer(interval, this);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(board_size.height * cell_size, board_size.width * cell_size);
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            for (int h = 0; h < board_size.height; h++)
                for (int w = 0; w < board_size.width; w++){
                    try{
                            g.setColor( startBoard.getCellState( h , w ) );
                        g.fillRect(h * cell_size, w * cell_size, cell_size, cell_size);
                    } catch (ConcurrentModificationException cme){}
                }
        }

        public void actionPerformed(ActionEvent e) {

            if (e.getSource().equals(timer)){
                startBoard.genNext();
                repaint();
            }

            else if(e.getSource().equals(start_pause)){
                if(run){
                    timer.stop();
                    start_pause.setText("Start");
                }
                else {
                    timer.restart();
                    start_pause.setText("Pause");
                }
                run = !run;

            }
        }
    }
}