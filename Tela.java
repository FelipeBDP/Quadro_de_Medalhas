import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;
import java.awt.event.*;

public class Tela extends JDialog implements ActionListener
{
    
    private int Result;	
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton)e.getSource();
        switch( btn.getText().charAt(0))
	{
		case 'I': Result = 1; break;
		case 'R': Result = 2; break;
		case 'L': Result = 3; break;
        case 'C': Result = 4; break;
        case 'A': Result = 5; break;
        case 'V': Result = 6; break;
        case 'S': Result = 7; break;
        default : Result = 0; break; 
	}
        setVisible(false);
    }

    public Tela()
    {
        initComponents();
    }  
    private JPanel pnlBotoes;
    private JButton criarBotao(String Texto)
    {
	JButton btn = new JButton(Texto); 
        pnlBotoes.add(btn);
        btn.setPreferredSize(new Dimension(210,30));
        btn.addActionListener(this);
	return btn;
    }
    private void initComponents()
    {
           
 	 setTitle("Informações");
         setSize(500,300);
         Image im = Toolkit.getDefaultToolkit().getImage("inf.png");
         setIconImage(im);
         
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         setLocationRelativeTo(null);

         setModal(true);

	 setLayout(new FlowLayout());	
         
         pnlBotoes = new JPanel();    
         pnlBotoes.setPreferredSize(new Dimension(300,500));
	 add(pnlBotoes);	
 
	 criarBotao("Inserir");
	 criarBotao("Remover");
	 criarBotao("Listar");
	 criarBotao("Cadastrar Novo Administrador");
	 criarBotao("Apagar Administrador");
	 criarBotao("Voltar");
	 criarBotao("Sair");
    }  

    private static Tela tela;
    public static int Executar()
    {
        if ( tela == null)
          tela = new Tela();
        tela.Result = 7;
        tela.setVisible(true);
        return tela.Result;
    }
    
    public static void main(String ty[])
    {
	int opc;
        while (  (opc=Executar())!=7)
	       JOptionPane.showMessageDialog(null,"Escolheu:"+opc);	

	System.exit(0);
    }
}