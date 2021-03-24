import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrabalhoQuiz extends JPanel{

	//Criar
	JTextField nameField;
	ButtonGroup question0, question1, question2, question3, question4;
	JRadioButton Q1O1, Q1O2, Q1O3, Q2O1, Q2O2, Q3O1, Q3O2, Q4O1, Q4O2, Q5O1, Q5O2;
	JButton calculateResult;
	JLabel result;
	
	//Chamar
	public TrabalhoQuiz() {
		Components();
		eventScript();
	}
	
	
	//Criar e Instanciar
	void Components() {
		
		question0 = new ButtonGroup();
		question1 = new ButtonGroup();
		question2 = new ButtonGroup();
		question3 = new ButtonGroup();
		question4 = new ButtonGroup();
		
		setLayout(null);
		JLabel titleLable = new JLabel("Bem Vindo ao Quiz!");
		titleLable.setBounds(163, 11, 134, 14);
		add(titleLable);
		
		JLabel nameLabel = new JLabel("NOME:");
		nameLabel.setBounds(152, 41, 55, 14);
		add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(195, 38, 102, 20);
		add(nameField);
		nameField.setColumns(10);
		
		JLabel Divisor1 = new JLabel("___________________________________");
		Divisor1.setBounds(102, 67, 254, 14);
		add(Divisor1);
		
		JLabel questionLabel = new JLabel("1-O que � o Git?");
		questionLabel.setBounds(178, 92, 94, 14);
		add(questionLabel);
		
		
		
		Q1O1 = new JRadioButton("Uma IDE");
		Q1O1.setBounds(47, 141, 80, 23);
		question0.add(Q1O1);
		add(Q1O1);
		
		Q1O2 = new JRadioButton("Um Website");
		Q1O2.setBounds(146, 141, 102, 23);
		question0.add(Q1O2);
		add(Q1O2);
		
		Q1O3 = new JRadioButton("Um Versionador de codigos");
		Q1O3.setBounds(250, 141, 201, 23);
		question0.add(Q1O3);
		add(Q1O3);
		
		JLabel gitImage = new JLabel("");
		gitImage.setIcon(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/GitIcon.png"));//ALTERAR O DIRET�RIO
		gitImage.setBounds(205, 111, 30, 30);
		add(gitImage);
		
		JLabel Divisor2 = new JLabel("___________________________________");
		Divisor2.setBounds(102, 171, 254, 14);
		add(Divisor2);
		
		JLabel questionLabel1 = new JLabel("2-O que � Java?");
		questionLabel1.setBounds(178, 196, 94, 14);
		add(questionLabel1);
		
		JLabel javaImage = new JLabel("");
		javaImage.setIcon(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/javaIcon.png"));//ALTERAR O DIRET�RIO
		javaImage.setBounds(205, 213, 39, 45);
		add(javaImage);
		
		Q2O1 = new JRadioButton("Uma Linguagem de Programa��o");
		Q2O1.setBounds(30, 258, 222, 30);
		add(Q2O1);
		question1.add(Q2O1);
		
		Q2O2 = new JRadioButton("Um Jogo");
		Q2O2.setBounds(254, 262, 109, 23);
		add(Q2O2);
		question1.add(Q2O2);
		
		JLabel Divisor3 = new JLabel("___________________________________");
		Divisor3.setBounds(102, 295, 254, 14);
		add(Divisor3);
		
		JLabel questionLabel2 = new JLabel("3-O que � DevOps?");
		questionLabel2.setBounds(163, 320, 115, 14);
		add(questionLabel2);
		
		Q3O1 = new JRadioButton("Um Sistema Operacional");
		Q3O1.setBounds(49, 369, 169, 23);
		add(Q3O1);
		question2.add(Q3O1);
		
		Q3O2 = new JRadioButton("Uma estrutura de integra��o");
		Q3O2.setBounds(222, 369, 188, 23);
		add(Q3O2);
		question2.add(Q3O2);
		
		JLabel devOpsImage = new JLabel("");
		devOpsImage.setIcon(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/DevOpsIcon.png"));//ALTERAR O DIRET�RIO
		devOpsImage.setBounds(195, 338, 55, 38);
		add(devOpsImage);
		
		JLabel Divisor4 = new JLabel("___________________________________");
		Divisor4.setBounds(102, 395, 254, 14);
		add(Divisor4);
		
		JLabel questionLabel3 = new JLabel("4-Qual o significa a sigla 'PC'?");
		questionLabel3.setBounds(144, 420, 165, 14);
		add(questionLabel3);
		
		Q4O1 = new JRadioButton("Personal Computer");
		Q4O1.setBounds(73, 469, 162, 23);
		add(Q4O1);
		question3.add(Q4O1);
		
		Q4O2 = new JRadioButton("Computador");
		Q4O2.setBounds(235, 469, 188, 23);
		add(Q4O2);
		question3.add(Q4O2);
		
		JLabel Divisor5 = new JLabel("___________________________________");
		Divisor5.setBounds(102, 495, 254, 14);
		add(Divisor5);
		
		JLabel lbloQue = new JLabel("5-Em que ano foi inventado o primeiro computador?");
		lbloQue.setBounds(102, 520, 293, 14);
		add(lbloQue);
		
		Q5O1 = new JRadioButton("1934");
		Q5O1.setBounds(100, 579, 162, 23);
		add(Q5O1);
		question4.add(Q5O1);
		
		Q5O2 = new JRadioButton("1945");
		Q5O2.setBounds(270, 579, 188, 23);
		add(Q5O2);
		question4.add(Q5O2);
		
		JLabel PCImage = new JLabel("");
		PCImage.setIcon(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/PC.png"));//ALTERAR O DIRET�RIO
		PCImage.setBounds(190, 434, 45, 36);
		add(PCImage);
		
		JLabel bookImage = new JLabel("");
		bookImage.setIcon(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/Book.png"));//ALTERAR O DIRET�RIO
		bookImage.setBounds(195, 534, 53, 38);
		add(bookImage);
		
		calculateResult = new JButton("FINALIZAR QUIZ");
		calculateResult.setBounds(150, 610, 140, 20);
		add(calculateResult);
		
		result = new JLabel("Resultado: ");
		result.setBounds(160, 610, 140, 20);
		result.setVisible(false);
		add(result);
		
	}
	
	public static void main(String args[]) {
		
		JFrame frame = new JFrame("Quiz");
		frame.getContentPane().add(new TrabalhoQuiz(), 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 445, 720);
		frame.setVisible(true);
		
	}
	
	public void eventScript() {
		calculateResult.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
		
				calculateResult.setVisible(false);
				
				int score = 0;
				//CALCULAR PONTOS
				if(Q1O3.isSelected()) { score += 2;}
				if(Q2O1.isSelected()) { score += 2;}
				if(Q3O2.isSelected()) { score += 2;}
				if(Q4O1.isSelected()) { score += 2;}
				if(Q5O2.isSelected()) { score += 2;}
				
				result.setVisible(true);
				result.setText("Pontua��o:  " + String.valueOf(score) + "!");
				
				
				
			}
	});
	}
	
	
}
