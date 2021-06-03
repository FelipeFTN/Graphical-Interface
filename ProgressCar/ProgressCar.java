import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ProgressCar extends JPanel{
	
	JProgressBar mainProgress;
	JButton speedUp, speedDown;
	JLabel car;
	ImageIcon carImg;
	int carPosition = 0;
	
	public ProgressCar() {
		
		Components();
		EventScript();
		
	}
	
	public void Components() {
		setLayout(null);
		mainProgress = new JProgressBar();
		mainProgress.setBounds(100,50,100,20);
		carImg = new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/car.png");
		car = new JLabel(carImg);
		speedUp = new JButton("Speed UP");
		speedUp.setBounds(100,100,100,25);
		speedUp.setMnemonic('A');
		speedDown = new JButton("Speed Down");
		speedDown.setFont(new Font("Arial", Font.BOLD, 9));
		car.setBounds(0, 10, 50, 50);
		speedDown.setBounds(100,150,100,25);
		speedDown.setMnemonic('D');
		add(mainProgress);
		add(speedUp);
		add(speedDown);
		add(car);
		
	}
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("ProgressCar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ProgressCar());
		frame.setSize(300,300);
		frame.setVisible(true);
		new ProgressCar();
		
	}
	
	private void EventScript(){
		speedUp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent  e){
				
				mainProgress.setValue(mainProgress.getValue() + 2);
				carPosition = mainProgress.getValue() + 6;
				car.setBounds(carPosition * 2, 10, 50, 50);
				System.out.print(mainProgress.getValue() + " ");
				mainProgress.setStringPainted(true);
				mainProgress.setForeground(Color.blue);
				mainProgress.setString("PROGRESSO");
			}
	});
		speedDown.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent  e){
				
				mainProgress.setValue(mainProgress.getValue() - 2);
				carPosition = mainProgress.getValue() - 6;
				car.setBounds(carPosition * 2, 10, 50, 50);
				System.out.print(mainProgress.getValue() + " ");
				mainProgress.setStringPainted(true);
				mainProgress.setForeground(Color.red);
				mainProgress.setString("PROGRESSO");
				
				
				
			}
	});
	}
	
	
	
	
	
	

}
