/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airplanereservations;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Mark
 */
public class MainWindow extends JFrame{

    /**
     * @param args the command line arguments
     */
    //private JFrame main;
    private JPanel mainPanel, //Main page to work with
            seatGrid; //Grid for the seats
    private JButton [] buttonArray;//array to store the buttons
    
    public MainWindow()
    {
        initComponents();
    }
    
    public void initComponents() {
        // TODO code application logic here
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        setLayout(new BorderLayout());
        getContentPane().add(new JLabel ("Testing"), BorderLayout.EAST);
        
        createSeats();
        pack();
        setVisible(true);
    }
    
    public void createSeats()
    {
        // set the number of rows
        int numRows = 10;
        int numSeatsInRow = 4;
        
        //set the grid layout
        seatGrid = new JPanel();
        seatGrid.setLayout(new GridLayout (numRows, numSeatsInRow ));
        add(seatGrid, BorderLayout.CENTER);
        seatGrid.setVisible(true);
        
        int seatIndex =0;//keep track of the number of seats
        buttonArray = new JButton[numRows * numSeatsInRow];
       
        //loop for each row
        for (int rowCount = 0; rowCount < numRows; rowCount++)
        {
            //set up for the aisle
            //for each seat in the row
            for (int seatCount = 0; seatCount <= numSeatsInRow; seatCount++)
            {
                //middle of the seats should be an aisle
                if (seatCount != numSeatsInRow/2)
                {
                    //create a new button
                JButton newButton = new JButton("Seat " + seatCount);
                //add it to the buttonArray
                buttonArray[seatIndex] = newButton;
                //increment seat index
                seatIndex++;
                //add it to the grid
                seatGrid.add(newButton);
                }
                else
                {
                    //add an empty seat for the aisle
                    seatGrid.add(new JLabel(""));
                }
            }//end seat loop
            
        }
        
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
