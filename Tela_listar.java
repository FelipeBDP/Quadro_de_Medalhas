import javax.swing.*;
import java.awt.*;
import javax.swing.UIManager.*;
import java.awt.event.*;

public class Tela_listar extends JDialog implements ActionListener
{
    
    private int Result;	
    public void actionPerformed(ActionEvent e)
    {
        JButton btn = (JButton)e.getSource();
        switch( btn.getText().charAt(0))
	{
		case 'L': Result = 1; break;
        case 'V': Result = 2; break;
        case 'S': Result = 3; break;
        default : Result = 0; break; 
	}
        setVisible(false);
    }

    public Tela_listar()
    {
        initComponents();
    }  
    private JPanel pnlBotoes;
    private JButton criarBotao(String Texto)
    {
	JButton btn = new JButton(Texto); 
        pnlBotoes.add(btn);
        btn.setPreferredSize(new Dimension(150,30));
        btn.addActionListener(this);
	return btn;
    }
    private void initComponents()
    {
           
 	 setTitle("Quadro de Medalhas");
         setSize(400,250);
        
         Image im = Toolkit.getDefaultToolkit().getImage("icone_med.png");
         setIconImage(im);
                 
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
         setLocationRelativeTo(null);

         setModal(true);

	 setLayout(new FlowLayout());	
         
         pnlBotoes = new JPanel();    
         pnlBotoes.setPreferredSize(new Dimension(200,200));
	 add(pnlBotoes);	
 
	 criarBotao("Listar");
	 criarBotao("Voltar");
	 criarBotao("Sair");
    }  

    private static Tela_listar tela;
    public static int Executar()
    {
        if ( tela == null)
          tela = new Tela_listar();
        tela.Result = 3;
        tela.setVisible(true);
        return tela.Result;
    }
    
    public static void main(String s[])
    {
	int opc;
        while (  (opc=Executar())!=3)
	       JOptionPane.showMessageDialog(null,"Escolheu:"+opc);	

	System.exit(0);
    }
}