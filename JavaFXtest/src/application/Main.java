package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.GridPane;

public class Main extends Application 
{
	
	private TextField betTextField;
	private TextField depositTextField;
    private Label winningLabel;
    private Label deposit;
    private Label balanceLabel;
    private Label depositLabel;
    private Label fundAlert;
	public ImageView imageView1;
	public Image imagePlum;
	public Image imageApple;
	public Image imageOrange;
	public ImageView imageView2;
	public ImageView imageView3;
	
	double balance = 0.0;
	
	public double getBalance()
	{
		return balance;
	}
	public void addBalance(double balance)
	{
		this.balance += balance;
	}
	public void subtractBalance(double balance)
	{
		this.balance -= balance;
	}
	@Override
	
    public void start(Stage primaryStage)   
    {
    	
  
        
        imageApple = new Image("file:C:\\Users\\alecn\\Desktop\\code\\Slot Machine\\JavaFXtest\\src\\apple_200.jpg");
        imageOrange = new Image("file:C:\\Users\\alecn\\Desktop\\code\\Slot Machine\\JavaFXtest\\src\\orange_200.jpg");
        imagePlum = new Image("file:C:\\Users\\alecn\\Desktop\\code\\Slot Machine\\JavaFXtest\\src\\plum_200.jpg");
        
         imageView1 = new ImageView(imageApple);
         imageView2 = new ImageView(imageOrange);
         imageView3 = new ImageView(imagePlum);
        
         
        betTextField = new TextField();
        depositTextField = new TextField();
        
        winningLabel = new Label("You win $ 0.00");
        winningLabel.setStyle("-fx-font-weight: bold;");
        balanceLabel = new Label("Balance: $" + getBalance());
        balanceLabel.setStyle("-fx-font-weight: bold;");
        depositLabel = new Label("Depoeesit: ");
        fundAlert = new Label("");
        fundAlert.setStyle("-fx-text-fill: red;");
        Button myButton = new Button("Spin");
        Button depoButton = new Button("Deposit");
        deposit = new Label("                                                    Bet:");
        depositLabel = new Label("                                               Deposit:");
        
        GridPane gridPane = new GridPane();
        gridPane.add(imageView1, 0, 0);
        gridPane.add(imageView2, 1, 0);
        gridPane.add(imageView3, 2, 0);
        gridPane.add(deposit, 0, 10);
        gridPane.add(depositLabel, 0, 11);
        gridPane.add(betTextField, 1, 10);
        gridPane.add(depositTextField, 1, 11);
        gridPane.add(fundAlert, 1, 12);
        gridPane.add(myButton, 2, 10);
        gridPane.add(depoButton, 2, 11);
        gridPane.add(winningLabel, 3, 10);
        gridPane.add(balanceLabel, 3, 11);
        
        
       
        
        myButton.setOnAction(new ButtonClickHandler());
        depoButton.setOnAction(new DepositHandler());
        
        Scene scene1 = new Scene(gridPane, 700, 600);
        
        primaryStage.setScene(scene1);
        
        primaryStage.setTitle("Slot Machine by Alec Namey");
        
        primaryStage.show();

    }
	class DepositHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			
			addBalance(Double.parseDouble(depositTextField.getText()));
			String balance = Double.toString(getBalance());
			balanceLabel.setText("Balance: $" + balance);
		}
	}
	
	
	class ButtonClickHandler implements EventHandler<ActionEvent>  
    {
    	
		@Override
		public void handle(ActionEvent event)
    	{
			if(Double.parseDouble(betTextField.getText()) <= getBalance())
			{
				fundAlert.setText("");
				double balance = getBalance();
				double bet = Double.parseDouble(betTextField.getText());
				
				winningLabel.setText("You win $0.00");
				subtractBalance(Double.parseDouble(betTextField.getText()));
				balanceLabel.setText("Balance: $" + getBalance());
				
				
				//winningLabel.setText(ip + ", Welcome!");
				//Declare local variables if necessary.
				
				// Create a Random object.
				Random randomNumbers1 = new Random();
				Random randomNumbers2 = new Random();
				Random randomNumbers3 = new Random();
				// for 1st position, generate a random number from 0, 1, 2
				int random = randomNumbers1.nextInt(3);
				int random2 = randomNumbers2.nextInt(3);
				int random3 = randomNumbers3.nextInt(3);
				// if 0, display apple
				
				if(random == 0)
				{
					imageView1.setImage(imageApple);
					
					
					
				}
				// if 1, display orange
				if(random == 1)
				{
					imageView1.setImage(imageOrange);
					
					
				}
				// if 2, display plum
				if(random == 2)
				{
					imageView1.setImage(imagePlum);
				}
				
				// do the same thing for 2nd and 3rd positions.-------------------------
				if(random2 == 0)
				{
					imageView2.setImage(imageApple);
					
				}
				// if 1, display orange
				if(random2 == 1)
				{
					imageView2.setImage(imageOrange);
				}
				// if 2, display plum
				if(random2 == 2)
				{
					imageView2.setImage(imagePlum);
				}
				// spacer-----------------------------------------------------
				if(random3 == 0)
				{
					imageView3.setImage(imageApple);
					
				}
				// if 1, display orange
				if(random3 == 1)
				{
					imageView3.setImage(imageOrange);
				}
				// if 2, display plum
				if(random3 == 2)
				{
					imageView3.setImage(imagePlum);
				}
				
				// Get the deposit.
				// Calculate the winning.
				if(random == random2)
				{
					winningLabel.setText("You win $" + (bet * 2));
					addBalance(bet * 2);
					balanceLabel.setText("Balance: $" + getBalance());
				}
				if(random2 == random3)
				{
					winningLabel.setText("You win $" + (bet * 2));
					addBalance(bet * 2);
					balanceLabel.setText("Balance: $" + getBalance());
				}
				if((random == random2) && (random == random3))
				{
					winningLabel.setText("You win $" + (bet * 3));
					addBalance(bet * 3);
					balanceLabel.setText("Balance: $" + getBalance());
				}
				// Display the results. 
			}
			else
			{
				fundAlert.setText("Insignificant funds for your bet");
			}
    	}
    }
	
    public static void main(String[] args) 
    {
        launch(args);
    }
}


















