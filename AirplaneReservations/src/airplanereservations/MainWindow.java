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
    private JPanel 
            infoPanel, //holds the information panels
            flightInformationPanel, //Contains the flight information
            yourInformationPanel, //displays your information
            legendPanel, //gives user definitions for symbols
            seatGrid; //Grid for the seats
    
    //changing display information
    private JTextField custName_TF, custEmail_TF;//input fields for email and name
    private JLabel selectedSeatsDisplay, totalPriceDisplay; // Label to display the selected seats
    private JButton purchaseButton; 
    
    
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
        
        //ready the info panel 
        infoPanel = new JPanel();
        int numInfoPanels = 2;//your/flight information
        infoPanel.setLayout(new GridLayout(numInfoPanels, 1));
        add(infoPanel, BorderLayout.EAST);
        
        //add the individual panels
        createSeats();
        createFlightInformation();
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
        infoPanel.add(yourInformationPanel, BorderLayout.EAST);
        yourInformationPanel.setVisible(true);
        //add title to the box
        Border border = BorderFactory.createTitledBorder("Your Information");
        yourInformationPanel.setBorder(border);
        
        //set up the label panel
        int numLabels = 4;
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(numLabels, 2));
        yourInformationPanel.add(labelPanel, BorderLayout.WEST);
        
        //add name fields to the label panel
        JLabel custNameLabel = new JLabel("Name:");
        labelPanel.add(custNameLabel);
       custName_TF = new JTextField();
       labelPanel.add(custName_TF);
       
       //add the email fields
       JLabel custEmailLabel = new JLabel("Email:");
       labelPanel.add(custEmailLabel);
       custEmail_TF = new JTextField();
       labelPanel.add(custEmail_TF);
       
       //add the selected seats fields
       JLabel selectedSeatsLabel = new JLabel("Selected Seats:");
       labelPanel.add(selectedSeatsLabel);
       selectedSeatsDisplay = new JLabel("Test Text for seats");
       labelPanel.add(selectedSeatsDisplay);
       
        //add the money fields
       JLabel totalPriceLabel = new JLabel("Total Price:");
       labelPanel.add(totalPriceLabel);
       totalPriceDisplay = new JLabel("Test Price");
       labelPanel.add(totalPriceDisplay);
       
        //add panel to south
       JPanel purchaseButtonPanel = new JPanel();
       yourInformationPanel.add(purchaseButtonPanel, BorderLayout.SOUTH);
       purchaseButtonPanel.setLayout(new FlowLayout());
       
        //add purchase button to south
       purchaseButton = new JButton("Purchase Seats");
       purchaseButtonPanel.add(purchaseButton);
    }
    
    public void createFlightInformation()
    {
        //All of the flight information
        
        String airlineName = "SpeedyJet Airways";
        String departureCity = "MSP";
        String departureTime = "1:30 PM, 6/12/2014";
        String arrivalCity = "LAX";
        String arrivalTime = "5:40 PM, 6/12/2014";
        String aircraftName = "Boeing 737";
        String flightNumber_S = "#3667";
        
        //settings for the flight panel
        flightInformationPanel = new JPanel();
        infoPanel.add(flightInformationPanel, BorderLayout.EAST);
        //add a title to the panel
        Border border = BorderFactory.createTitledBorder("Flight Information");
        flightInformationPanel.setBorder(border);
        
        //set up the layout of the panel
        int numDisplayFields = 5;
        flightInformationPanel.setLayout(new GridLayout(numDisplayFields, 2));
        
        //add the airline information/label
        JLabel airlineLabel = new JLabel("Airline:");
        flightInformationPanel.add(airlineLabel);
        JLabel airlineInfo = new JLabel(airlineName);
        flightInformationPanel.add(airlineInfo);
        
        //add departure label/info
        JLabel departLabel = new JLabel("Departure Information:");
        flightInformationPanel.add(departLabel);
        JLabel deptDisplay = new JLabel(departureCity + " " + departureTime);
        flightInformationPanel.add(deptDisplay);
        
        //add arrival label/info
        JLabel arrivalLabel = new JLabel("Arrival Information:");
        flightInformationPanel.add(arrivalLabel);
        JLabel arrivalInfo = new JLabel(arrivalCity + " " + arrivalTime);
        flightInformationPanel.add(arrivalInfo);
        
        //add aircraft info
        JLabel aircraftLabel = new JLabel("Aircraft:");
        flightInformationPanel.add(aircraftLabel);
        JLabel aircraftInfo = new JLabel(aircraftName);
        flightInformationPanel.add(aircraftInfo);
        
        //add flight number
        JLabel flightLabel = new JLabel("Flight Number:");
        flightInformationPanel.add(flightLabel);
        JLabel flightInfo = new JLabel(flightNumber_S);
        flightInformationPanel.add(flightInfo);
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
