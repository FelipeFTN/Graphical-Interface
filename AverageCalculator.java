import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FirstProgram2 extends JPanel{
	
	//Criar
	JLabel textName, textNumber, logo, smile, sad, textClass, textGrade0, textGrade1, textGrade2, textResult;
	JTextField nameField, numberField, classField, gradeField0, gradeField1, gradeField2;
	static ImageIcon logoImg;
	ImageIcon smileImg, sadImg;
	JButton calculateButton;
	
	//Chamar
	public FirstProgram2() {
		Componentes();
		EventScript();	
	}
	
	//Instânciar
	public void Componentes() {
		setLayout(null);
		textName = new JLabel("Nome:");
		nameField = new JTextField(15);
		logoImg = new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/graduation-hat.png");
		logo = new JLabel(logoImg);
		textNumber = new JLabel("Número:");
		numberField = new JTextField(9);
		textClass = new JLabel("Turma:");
		classField = new JTextField(5);
		textGrade0 = new JLabel("Nota 1:");
		textGrade1 = new JLabel("Nota 2:");
		textGrade2 = new JLabel("Nota 3:");
		gradeField0 = new JTextField(3);
		gradeField1 = new JTextField(3);
		gradeField2 = new JTextField(3);
		calculateButton = new JButton("Calcular");
		textResult = new JLabel("");
		textResult.setVisible(false);
		smileImg = new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/smile.png");
		smile = new JLabel(smileImg);
		sadImg = new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/sad.png");
		sad = new JLabel(sadImg);
		//Posicionar
		textName.setBounds(10,10,40,40);
		nameField.setBounds(50,21,150,20);
		logo.setBounds(220, 10, 40, 40);
		textNumber.setBounds(10, 40, 60, 40);
		numberField.setBounds(65,50,85,20);
		textClass.setBounds(160, 40, 60, 40);
		classField.setBounds(205, 50, 45, 20);
		textGrade0.setBounds(10, 70, 40, 40);
		gradeField0.setBounds(55, 80, 40, 20);
		textGrade1.setBounds(100, 70, 40, 40);
		gradeField1.setBounds(145, 80, 40, 20);
		textGrade2.setBounds(190, 70, 40, 40);
		gradeField2.setBounds(235, 80, 40, 20);
		calculateButton.setBounds(95, 120, 100, 20);
		textResult.setBounds(25, 150, 300, 20);
		smile.setBounds(120, 180, 40, 40);
		sad.setBounds(120, 180, 40, 40);
		smile.setVisible(false);
		sad.setVisible(false);
		//Adicionar
		add(logo);
		add(textName);
		add(nameField);
		add(textNumber);
		add(numberField);
		add(textClass);
		add(classField);
		add(textGrade0);
		add(gradeField0);
		add(textGrade1);
		add(gradeField1);
		add(textGrade2);
		add(gradeField2);
		add(calculateButton);
		add(textResult);
		add(smile);
		add(sad);
	}
	//Frame
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Calcular Média");
		frame.getContentPane().add(new FirstProgram2());
		frame.setIconImage(logoImg.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	
	public void EventScript() {
		calculateButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				textResult.setVisible(true);
				
				double average = (Float.parseFloat(gradeField0.getText()) + Float.parseFloat(gradeField1.getText()) + Float.parseFloat(gradeField2.getText())) / 3;
				
				textResult.setText("O aluno "+ nameField.getText() + " (" + numberField.getText() + ")" + " Está com média " + String.valueOf(average));
				
				if(average >= 6) {
					smile.setVisible(true);
					sad.setVisible(false);
				} else {
					sad.setVisible(true);
					smile.setVisible(false);
				}
			}
		});
	}
}
