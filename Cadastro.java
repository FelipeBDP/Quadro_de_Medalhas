import javax.swing.*;

public class Cadastro implements java.io.Serializable
{
   private int ouro,prata,bronze;
   private String Id,Nome_pais;   

   public Cadastro()
   {
      Nome_pais="";
      ouro=prata=bronze=0;
   }   

   public String    getId()  { return Id;  }    
   public String getNome_pais() { return Nome_pais; }    
   public int    getouro()  { return ouro;  }    
   public int    getprata()  { return prata;  }
   public int    getbronze()  { return bronze;  } 

   public void setId(String valor)  { Id = valor ; }  
   public void setNome_pais(String valor) { Nome_pais = valor; } 
   public void setouro(int valor) {ouro = valor; }    
   public void setprata(int valor) {prata = valor; }
   public void setbronze(int valor) {bronze = valor; }    


   public void ler()
   {
    Id = JOptionPane.showInputDialog("Entre com o Id");
    Nome_pais = JOptionPane.showInputDialog("Entre com o Nome do Pais");
    ouro = Integer.parseInt( JOptionPane.showInputDialog("Medalhas de Ouro ") );
    prata = Integer.parseInt( JOptionPane.showInputDialog("Medalhas de Prata") );
    bronze = Integer.parseInt( JOptionPane.showInputDialog("Medalhas de Bronze") );
   }    
   
   public int Total()
   {
       return (ouro+prata+bronze);
   } 
   
}