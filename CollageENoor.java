//Mahnoor Malik
// CollageENoor
// mahnoorfmalik@lewisu.edu

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

import java.util.ArrayList;
import java.util.Random;

class MITile extends JPanel {
    private int green,red,blue;
    private String letter;
    private int rectangles;


    
    //Constructor
   MITile() {
    super();
    SetRandomNumbers();
    }

    final public void SetRandomNumbers() {
        green = GetNumberBetween(0,255);
        red = GetNumberBetween(0,255);
        blue = GetNumberBetween(0,255);

        // Thank you professor
        letter = "M";
        if(GetNumberBetween(0,26) == 1) {
         letter = "A";
        }  else if (GetNumberBetween(0,26) == 2) {
            letter = "H";
        }   else if (GetNumberBetween(0,26) == 3) {
            letter = "N";  
        } else if (GetNumberBetween(0,26) == 4) {
            letter = "O";
        } else if (GetNumberBetween(0,26) == 5) {
            letter = "O";
        }else if (GetNumberBetween(0,26) == 6) {
            letter = "R";
        }else if (GetNumberBetween(0,26) == 7) {
            letter = "M";
        } else if (GetNumberBetween(0,26) == 8) {
            letter = "A";
        }else if (GetNumberBetween(0,26) == 9) {
            letter = "L";
        }else if (GetNumberBetween(0,26) == 9) {
        letter = "I";
    } else if (GetNumberBetween(0,26) == 9) {
    letter = "K";
        }
    }
    // Thank you Amajla
    
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            int panelWidth = getWidth();
            int panelHeight = getHeight();

        g.setColor(new Color(green,red,blue));
        g.fillRect(11, 11, panelWidth-10, panelHeight-10);
        g.drawOval(110,110,110,110);
        g.fillOval(110,110,110,110);

        g.setColor(new Color(GetContrastingColor(green),GetContrastingColor(red),GetContrastingColor(blue)));
        g.fillOval(110, 110, 110, 110);
        final int myfontSize = 70;
        g.setFont(new Font("Calibri", Font.PLAIN , myfontSize));
        int stringX = (panelWidth/2)-20;
        int stringY = (panelHeight/2)+20;
        g.drawString(letter,stringX,stringY);
    }

    private static int GetContrastingColor(int colorIn) {
        return ((colorIn+128)%256);

}
        private static int GetNumberBetween(int min, int max) {
            Random random = new Random();
            return min + random.nextInt(max-min+1);
        }

}
// Thank you professor

 class CollageENoorFrame extends JFrame implements ActionListener {
   private ArrayList<MITile> miTiles;

    public CollageENoorFrame() {
        setBounds(300,300,1100,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JPanel mybuttonPanel = new JPanel();
        contentPane.add(mybuttonPanel, BorderLayout.SOUTH);

        JButton randomize = new JButton("Randomize!");
        mybuttonPanel.add(randomize);
        randomize.addActionListener(this);

        JPanel myinfoGridPanel = new JPanel();
        contentPane.add(myinfoGridPanel, BorderLayout.CENTER);
        myinfoGridPanel.setLayout(new GridLayout(12,12));
        
        miTiles = new ArrayList<MITile>();
        for(int i=1; i<13; i++) {
           MITile tile  = new MITile ();
           myinfoGridPanel.add(tile);
          miTiles.add(tile);
        }
    }

        public void actionPerformed(ActionEvent e) {
            for (MITile tile:miTiles) {
          tile.SetRandomNumbers();
            }
            repaint();
        }
    }



public class CollageENoor {
    public static void main(String[] args) {
        System.out.println("Welcome to Noor's land!....");

        CollageENoorFrame myinfoFrame = new CollageENoorFrame();
        myinfoFrame.setVisible(true);
    }
}




