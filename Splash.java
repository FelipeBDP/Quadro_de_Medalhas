import javax.swing.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;



public class Splash extends JDialog
{
   public static void Executar()
   {
      Splash frm = new Splash();
      frm.setVisible(true);
   }

   BufferedImage fundo;
 
   private Splash()
   {
      setSize(750,350);
      setLocationRelativeTo(null);
      setUndecorated(true);
      setAlwaysOnTop( true );
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      setModal(true);

      try{
        fundo = ImageIO.read(new File("olp2016.png"));
      }
      catch(Exception e)
      {
      }
   }

   public void paint(Graphics g)
   {
      g.setColor(Color.WHITE);
      g.fillRect(0,0,getWidth(),getHeight());
      if (fundo!=null)
         g.drawImage(fundo, 0,0, getWidth(), getHeight(), 0, 0, fundo.getWidth(), fundo.getHeight(), null);
      
      try{ 
        Thread.sleep(3000);
        setVisible(false);
      }catch(Exception e)
      {}
   } 
  
   public static void main(String s[])
   {
      Splash.Executar();  
   } 
}