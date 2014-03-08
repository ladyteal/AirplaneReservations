/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airplanereservations;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
/**
 *
 * @author Mark Rustad
 */
public class MainWindow extends JFrame{

    //various panels
    private JPanel flightInformationPanel, //Contains the flight information
            yourInformationPanel, //displays your information
            legendPanel, //gives user definitions for symbols
            seatGrid; //Grid for the seats
    
    //changing display information
    JTextField custName_TF, custEmail_TF;//input fields for email and name
    JLabel selectedSeatsDisplay; // Label to display the selected seats
     
    //seat-related arrays
    private JButton [] buttonArray;//array to store the buttons
    private String[] seatNames;
    
    public MainWindow()
    {
        initComponents();
    }
    
    public void initComponents() {
        // TODO code application logic here
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        setLayout(new BorderLayout());
        
        createSeats();
        createYourInformationPanel();
        pack();
        setVisible(true);
    }
    
    public void createSeats()
    {
        // set the number of rows
        int numRows = 10;
        int numSeatsInRow = 4;
        //get the total seats
        int totalSeats = numRows * numSeatsInRow;
        
        //set the grid layout
        seatGrid = new JPanel();
        seatGrid.setLayout(new GridLayout (numRows, numSeatsInRow ));
        add(seatGrid, BorderLayout.CENTER);
        seatGrid.setVisible(true);
        
        int seatIndex =0;//keep track of the number of seats
        buttonArray = new JButton[totalSeats];
        seatNames = new String[totalSeats];
       
        //loop for each row
        for (int rowCount = 0; rowCount < numRows; rowCount++)
        {
            //set up for the aisle
            //for each seat in the row
            for (int seatCount = 0; seatCount <= numSeatsInRow; seatCount++)
            {
                int aislePosition = numSeatsInRow/2;
                //middle of the seats should be an aisle
                if (seatCount != aislePosition)
                {
                    //declare the letter the seat will be
                    char seatID;
                    int firstSeatIDAscii = 65;
                    //before aisle, simple addition
                    if(seatCount < aislePosition)
                    {
                        seatID = (char)(firstSeatIDAscii + seatCount);
                    }
                    //after aisle, take 1 away
                    else
                    {
                        seatID = (char)(firstSeatIDAscii + seatCount-1);
                    }
                    
                    //declare the seat's name
                    int rowName = rowCount + 1;
                    String seatName = "Seat " + rowName + seatID;
                    // add the seatname to a table
                    //create a new button
                    JButton newButton = new JButton(seatName);
                    //add it to the buttonArray
                    buttonArray[seatIndex] = newButton;
                    seatNames[seatIndex] = seatName;
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
    
    public void createYourInformationPanel()
    {
        yourInformationPanel = new JPanel();
        yourInformationPanel.setLayout(new BorderLayout());
        add(yourInformationPanel, BorderLayout.EAST);
        yourInformationPanel.setVisible(true);
        //add title to the box
        Border border = BorderFactory.createTitledBorder("Your Information");
        yourInformationPanel.setBorder(border);
        //add labels to the West side
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new FlowLayout());
        JLabel custNameLabel = new JLabel("Name:");
       yourInformationPanel.add(custNameLabel, BorderLayout.WEST);
       
       JLabel custEmailLabel = new JLabel("Email:");
       yourInformationPanel.add(custEmailLabel, BorderLayout.WEST);
       
       JLabel selectedSeatsLabel = new JLabel("Selected Seats:");
       yourInformationPanel.add(selectedSeatsLabel, BorderLayout.WEST);
       
        //add display in the CENTER
       custName_TF = new JTextField();
      // yourInformationPanel.add(custName_TF, BorderLayout.CENTER);
        //add panel to south
        //add purchase button to south
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
