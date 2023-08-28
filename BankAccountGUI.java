import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
* An application with a Graphical User Interface that .
*
* @author Fares Yahmadi
*/
public class BankAccountGUI extends JFrame implements ActionListener {

  /** Display the prompt for entering the balance. */
  private JTextField balanceField;

  /** Button to click when the balance is entered. */
  private JButton initializeButton;

  /** Display the current balance. */
  private JLabel currbalanceLabel;

  /** Display the prompt for entering the amount for transaction (withdrawal/deposit) */
  private JTextField transactionField;

  /** Button to click to withdraw the amount. */
  private JButton withdrawButton;

  /** Button to click to deposit the amount. */
  private JButton depositButton;


  /** A SimpleAccount object to represent the balance */
  private SimpleAccount sa;


  /**
  * Creates a BankAccountGUI object.
  *
  */
  public BankAccountGUI() {

    this.buildGUI();

    // Make the GUI visible.
    // super means we are calling a method inherited from the super class
    super.setVisible(true);
  } // end of constructor


  /**
  * Creates the items in the GUI and adds them to the window.
  */
  private void buildGUI() {

    super.setSize(500, 200); // size of the window
    super.setTitle("Bank Account"); // title displayed on the window

    // Create a content pane to hold the GUI objects using BorderLayout
    Container contentPane = getContentPane();
    contentPane.setLayout(new BorderLayout());

    // Create objects for the getting the current balance
    JLabel balancePrompt = new JLabel("Enter the initial blance: ");
    this.balanceField = new JTextField(5);
    this.initializeButton = new JButton("Click here to initialize balance! ");
    this.initializeButton.addActionListener(this);

    // Put the balance objects into a panel and add the panel to the window.
    JPanel balancePanel = new JPanel();
    balancePanel.add(balancePrompt);
    balancePanel.add(this.balanceField);
    balancePanel.add(this.initializeButton);
    contentPane.add("North", balancePanel);

    // Create object to display the current balance  add it to window
    this.currbalanceLabel = new JLabel("Current Balance: ");
    contentPane.add("Center", currbalanceLabel);


    // Create objects for the amount of money choosen for the transaction
  
    JLabel transactionPrompt = new JLabel("Enter the transaction amount: ");
    this.transactionField = new JTextField(5);
    this.withdrawButton = new JButton("Withdraw");
    this.withdrawButton.addActionListener(this);
    this.depositButton = new JButton("Deposit");
    this.depositButton.addActionListener(this);

    // Put the transaction objects into a panel and add the panel to the window.
    JPanel transactionPanel = new JPanel();
    transactionPanel.add(transactionPrompt);
    transactionPanel.add(this.transactionField);
    transactionPanel.add(this.withdrawButton);
    transactionPanel.add(this.depositButton);
    contentPane.add("South", transactionPanel);

    

  } // end of buildGUI method

  /**
   * Handles action events from the GUI.
   * 
   * @param e The event from the GUI
   */
  public void actionPerformed(ActionEvent e) {
    if(e.getSource() == this.initializeButton) {
      // Button clicked to initialize the balance 

      // Get the text input for the initial balance
      String balanceText = this.balanceField.getText();

      // Convert the String input to a double using the Double wrapper class
      double balance = Double.parseDouble(balanceText);

      // Disable the initializebalance button, it should only be clicked one time.
      this.initializeButton.setEnabled(false);

      // creating the SimpleAccount object
      sa = new SimpleAccount(balance);
      // Display the current balance
      this.currbalanceLabel.setText("Current Balance: " + Double.toString(balance));

      // Activate the withdraw and deposit button
      this.withdrawButton.setEnabled(true);
      this.depositButton.setEnabled(true);
    }

    else if(e.getSource() == this.withdrawButton) {
      // Button clicked to withdraw money

      // Get the text input for the amount to be withdrawn 
      String withdrawText = this.transactionField.getText();
      // Convert the String input to a double using the Double wrapper class
      double withdrawAwamount = Double.parseDouble(withdrawText);
      // call withdraw method to deduct the amount of money withdrawn from the initial balance
      sa.withdraw(withdrawAwamount);  
      // Display the current balance
      this.currbalanceLabel.setText("Current Balance: " + Double.toString(sa.getBalance()));
  
      
    } 
    else if (e.getSource() == this.depositButton){
      // Get the text input for the amount to be deposited
        String depositText = this.transactionField.getText();
        // Convert the String input to a double using the Double wrapper class
        Double depositAmount = Double.parseDouble(depositText);
        // call withdraw method to add the amount of money deposited to the initial balance
        sa.deposit(depositAmount);
        // Display the current balance
        this.currbalanceLabel.setText("Current Balance: " + Double.toString(sa.getBalance()));
        
    }

  } // end of actionPerformed method

  /**
   * Program execution begins at main method.
   * 
   * @param args Not used
   */
  public static void main(String[] args) {

    // Create a BankAccountGUI object
    // This will display the GUI and allow user interaction
    BankAccountGUI gui = new BankAccountGUI();

    // inner class that closes the application when the window is closed
    gui.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  } // end of main method
}
