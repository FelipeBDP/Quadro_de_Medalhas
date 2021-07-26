import javax.swing.*;


public class Principal
{
   private static int Menu_principal()
   {
      int esc;
      do{
    	  esc = Integer.parseInt(JOptionPane.showInputDialog("1-Administrador\n2-Visitante\n3-Sair"));
      }while (esc<=0 || esc>3); 
      return esc;	
   }
   
   private static int Menu_administrador()
   {
      int esc2;
      do{
        esc2 = Integer.parseInt(JOptionPane.showInputDialog("1-Inserir\n2-Remover\n3-Listar\n4-Melhores\n5-Sair"));
      }while (esc2<=0 || esc2>5); 
      return esc2;	
   }
   
   private static int Menu_visitante()
   {
      int esc3;
      do{
        esc3 = Integer.parseInt(JOptionPane.showInputDialog("1-Listar\n2-Sair"));
      }while (esc3<=0 || esc3>2); 
      return esc3;	
   }
   
   public static void main(String args[])
   {
	   
	boolean logar=false;
	boolean info = false;
	boolean visitar=false;
	Quadro t = new Quadro();
	Splash.Executar(); 
    
 /* +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    +                                                                                                         +
    +                                      Tela Inicial                                                       + 
    +                                                                                                         +
    +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
        while (!logar)
    	{
    	    switch(Tela_login.Executar())
    	    {
    	       case 1:    	    	
    	        Login a=new Login();
    	   	    Tela_logando.Executar(a); 
    	        logar = true;
    	        info=false;
    		    visitar = true;
    		  break;
    		  
    	      case 2:
    	       logar = true;
    	       info = true;
    	       visitar=false;
    		  break; 
    		 
    	      case 3:
    	       logar=true;
    	       info = true;
    		   visitar=true;
    		 break; 
            }	
    	  //-----------------------------------------------------------------------------------------------------------
   
        /*  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            +                                                                                                         +
            +                                      Tela Cadastro                                                      + 
            +                                                                                                         +
            +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
          //-----------------------------------------------------------------------------------------------------------
    	    
            while (! info)
	        {
	            switch(Tela.Executar())
	              {
	                   case 1:
		                Cadastro a = new Cadastro();
		                 if (Tela_cadastro.Executar(a))
  		                   t.inserir(a);
		               break; 
		               
	                   case 2:
		                String Id = JOptionPane.showInputDialog("Entre com o ID para remover o Pais");
		                t.remover(Id);
		               break; 
		               
	                   case 3:
	                    t.listarop();
		               break;
		               
	                   case 4:
	   	                Login b = new Login();
	   	                 if (Tela_logar.Executar(b))
	                      t.inserir_login(b);
	   	               break;
	   	               
	                   case 5:
	                    String matricula = JOptionPane.showInputDialog("Entre com o matricula para remover o Administrador");
	   	                t.remover_login(matricula);
	                   break;
	                   
	                   case 6:
	   	                logar=false;
	   	                info = true;
	   	               break; 
	   	               
	                   case 7:
	                    logar=true;
	                    info = true;
	                    visitar=true;
	                   break; 
                }	    	
	       }
       //-----------------------------------------------------------------------------------------------------------     
        
    /*  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        +                                                                                                         +
        +                                      Lista Visitante                                                    + 
        +                                                                                                         +
        +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ */
      //-----------------------------------------------------------------------------------------------------------
        while (!visitar)
    	{
    	    switch(Tela_listar.Executar())
    	    {
    	      case 1:
    	 t.lista();
    		break;
    	      case 2:
    	    logar=false;
    	    info=false;
    		visitar=true;
    		break;
    	      case 3:
    	    logar=true;
    	    info=true;
    	    visitar=true;
    	    break; 
           }	    	
    	}
      //-----------------------------------------------------------------------------------------------------------  
        
    }
        System.exit(0);
   }
}