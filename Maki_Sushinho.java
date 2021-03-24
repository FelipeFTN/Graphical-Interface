import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Maki_Sushinho extends JPanel{

	//Criar
	JCheckBox ckmaki_ball, ckhot_roll, cktemaki_c, cktemaki_gre, ckbatata, ckbatataM, ckbatataP,ckcamarao, ckcocaL, ckfantaL, ckagua, ckaguaC;
	JLabel lbmaki, lbalimentos, lbporcoes, lbbebida, lbResultado, checkImg, errorImg;
	JRadioButton rbDinheiro, rbCcredito,rbCdebito, rbVR;
	ButtonGroup btGroup;
	static ImageIcon logoImg;
	ImageIcon imgCheck, imgError;
	JButton btFinalizar;
	
	//Chamar
	public Maki_Sushinho(){
		Components();
		EventScript();
	}
	
	//Instânciar
	private void Components(){
			
		rbVR = new JRadioButton("VR");
		rbCdebito = new JRadioButton("C/debito");
		rbCcredito = new JRadioButton("C/credito");
		rbDinheiro = new JRadioButton("Dinheiro");
			
		ckaguaC = new JCheckBox("Água c/gas  (R$3.50)");
		ckagua = new JCheckBox("Água  	(R$3.00)");
		ckfantaL = new JCheckBox("Fanta lata  (R$4.50)");
		ckcocaL = new JCheckBox("Coca lata  (R$4.50)");
		ckcamarao = new JCheckBox("Camarão  (R$55.00)");
		ckbatataP = new JCheckBox("Batata P  (R$7.00)");
		ckbatataM = new JCheckBox("Batata M  (R$12.00)");
		ckbatata = new JCheckBox("Batata G  (R$16.00)");
		cktemaki_gre = new JCheckBox("Temaki grelhado (R$17.00)");
		cktemaki_gre.setFont(new Font("Arial", Font.BOLD, 11));
		cktemaki_c = new JCheckBox("Temaki cru (R$17.00)");
		ckmaki_ball = new JCheckBox("Maki ball (R$20.00)");
		ckhot_roll = new JCheckBox("Hot roll (R$15.00)");
		
			
		lbmaki = new JLabel("Cardápio Maki Sushi");
		lbalimentos = new JLabel("Pratos");
		lbporcoes = new JLabel("Porções");
		lbbebida = new JLabel("Bebidas");
		lbResultado = new JLabel("Valor Total:");
		
		//ATENÇÃO!! ALTERAR O DIRETÓRIO DA LOGO / FAVICON
		logoImg = new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/MakiLogo.jpeg");
		JLabel logo = new JLabel(logoImg);
		checkImg = new JLabel(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/check.png"));
		errorImg = new JLabel(new ImageIcon("C:/Users/FelipeTT/Desktop/Java/Images/close.png"));
		//ATENÇÃO!! ALTERAR O DIRETÓRIO DA LOGO / FAVICON
		
		btGroup = new ButtonGroup();
		btGroup.add(rbDinheiro);
		btGroup.add(rbCcredito);
		btGroup.add(rbCdebito);
		btGroup.add(rbVR);
		btFinalizar = new JButton("Finalizar");
			
		setLayout(null);
			
		rbVR.setBounds(330,160,80,25);
		rbCdebito.setBounds(240,160,80,25);
		rbCcredito.setBounds(150,160,80,25);
		rbDinheiro.setBounds(60,160,80,25);
		
		ckaguaC.setBounds(340,130,200,25);
		ckagua.setBounds(340,110,200,25);
		ckfantaL.setBounds(340,90,200,25);
		ckcocaL.setBounds(340,70,200,25);
		ckcamarao.setBounds(180,130,140,25);
		ckbatataP.setBounds(180,110,140,25);
		ckbatataM.setBounds(180,90,140,25);
		ckbatata.setBounds(180,70,140,25);
		cktemaki_gre.setBounds(15,130,169,25);
		cktemaki_c.setBounds(15,110,150,25);
		ckmaki_ball.setBounds(15,70,150,25);
		ckhot_roll.setBounds(15,90,150,25);
			
		lbmaki.setBounds(180,10,120,30);
		lbalimentos.setBounds(20,40,120,25);
		lbporcoes.setBounds(200,40,120,25);
		lbbebida.setBounds(350,40,120,25);
		lbResultado.setBounds(195, 240, 120, 25);
		btFinalizar.setBounds(180,200,120,25);
		errorImg.setBounds(215, 260, 40, 40);
		checkImg.setBounds(215, 260, 40, 40);
		lbResultado.setVisible(false);
		checkImg.setVisible(false);
		errorImg.setVisible(false);

		//Adicionar
		add(btFinalizar);
		add(rbVR);
		add(rbCdebito);
		add(rbCcredito);
		add(rbDinheiro);
		add(ckaguaC);
		add(ckagua);
		add(ckfantaL);
		add(ckcocaL);
		add(lbbebida);
		add(ckcamarao);
		add(ckbatataP);
		add(ckbatataM);
		add(ckbatata);
		add(lbporcoes);
		add(lbalimentos);
		add(ckmaki_ball);
		add(ckhot_roll);
		add(lbmaki);
		add(cktemaki_c);
		add(cktemaki_gre);
		add(lbResultado);
		add(errorImg);
		add(checkImg);
		
	}
	//Frame		
	public static void main(String args[]){
		JFrame frame = new JFrame("Cardapio Maki Sushi");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Maki_Sushinho());
		frame.setIconImage(logoImg.getImage());
		frame.setBounds(0,0,500,350);
		frame.setVisible(true);	 
	}
	
	//Executar Eventos
	public void EventScript(){
		btFinalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				
				lbResultado.setVisible(true);
				
				double totalValue = 0;
				
				//Criar algoritmo para calcular os valores no CheckBox
				if(ckmaki_ball.isSelected()) {totalValue += 20;}
				if(ckhot_roll.isSelected()) {totalValue += 15;}
				if(cktemaki_c.isSelected()) {totalValue += 17;}
				if(cktemaki_gre.isSelected()) {totalValue += 17;}
				
				if(ckbatata.isSelected()) {totalValue += 16;}
				if(ckbatataM.isSelected()) {totalValue += 12;}
				if(ckbatataP.isSelected()) {totalValue += 7;}
				if(ckcamarao.isSelected()) {totalValue += 55;}
				
				if(ckcocaL.isSelected()) {totalValue += 4.5;}
				if(ckfantaL.isSelected()) {totalValue += 4.5;}
				if(ckagua.isSelected()) {totalValue += 3;}
				if(ckaguaC.isSelected()) {totalValue += 3.5;}
				
				lbResultado.setText("Valor Total: " + String.valueOf(totalValue));
				
				if(btGroup.isSelected(null)) {
					
					errorImg.setVisible(true);
					checkImg.setVisible(false);
					
					}else {
						
						checkImg.setVisible(true);
						errorImg.setVisible(false);
						
					}
				
			}
		});
		
	}

}

	

