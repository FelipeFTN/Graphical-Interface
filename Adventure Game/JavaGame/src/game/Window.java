package game;

import javax.swing.JFrame;

public class Window extends JFrame{//Este e o codigo principal responsavel por criar a janela

	public Window() {
		
		add(new Board());
		setTitle("Adventure Game");//Nome da Janela
		setSize(335, 350);//Tamanho da janela
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sair ao apertar no botao fechar
		setResizable(false);//Janela nao muda de tamanho
		setLocationRelativeTo(null);//Janela aparece no meio da tela
	}
	
	public static void main(String[] args)	{		
		Window w = new Window(); //Instancia a Janela
		w.setVisible(true);//deixa a janela visivel
	}
}
