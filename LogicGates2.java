import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class LogicGatesV2 extends JFrame implements ItemListener
{
   JLabel lnum1, lnum2;
   JComboBox tnum1, tnum2;
   JTextField tres;
   JComboBox optr;
   String optrs[] = {"AND", "OR", "NAND", "NOR", "XOR", "XNOR"};
   String A [] = {"1", "0"};
   Container c = getContentPane();
   
   LogicGatesV2() //constructor serves as 1. GUI Components
   {
      super("Logic Gates v2");
      lnum1 = new JLabel("   Input A: ");
      lnum2 = new JLabel("   Input B: ");
      optr = new JComboBox(optrs);
      
      tnum1 = new JComboBox(A);
      tnum2 = new JComboBox(A);
      tres = new JTextField(5); tres.setEditable(false);
      
      optr.addItemListener(this);
      
      c.setLayout(new GridLayout(3,2));
      c.add(lnum1); c.add(tnum1);
      c.add(lnum2); c.add(tnum2);
      c.add(optr); c.add(tres);

      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setSize(300, 200);
      setResizable(false);
      setVisible(true);
        }
   
   public void itemStateChanged(ItemEvent e)//2. Listener Method
   {
      int num1 =0, num2=0;
      boolean res = false;

      try
      {
         if(tnum1.getSelectedIndex()==0)
         num1 = 1;
         else
         num1 = 0;
         if(tnum2.getSelectedIndex()==0)
         num2 = 1;
         else
         num2 = 0;
         
         if(optr.getSelectedIndex()==0)
         {
            res = and(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==1)
         {
            res = or(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==2)
         {
            res = nAnd(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==3)
         {
            res = nor(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==4)
         {
            res = xOr(num1, num2);
         }
         else
         if(optr.getSelectedIndex()==5)
         {
            res = xNor(num1, num2);
         }
         tres.setText(res+"");
      }

      catch(NumberFormatException nfe)
      {
         tres.setText("   walay kamo, hahaha!");
      }
   }
   //3. Application Methods
   public boolean and(int num1, int num2) 
   {
      if(num1==1&&num2==1)
      return true;
      else if(num1==0&&num2==1)
      return false;
      else if(num1==1&&num2==0)
      return false;
      else if(num1==0&&num2==0)
      return false;
      else
      return false;
   }
   public boolean or(int num1, int num2)
   {
      if(num1==1&&num2==1)
      return true;
      else if(num1==0&&num2==1)
      return true;
      else if(num1==1&&num2==0)
      return true;
      else if(num1==0&&num2==0)
      return false;
      else
      return false;
   }
   public boolean nAnd(int num1, int num2)
   {
      if(num1==1&&num2==1)
      return false;
      else if(num1==0&&num2==1)
      return true;
      else if(num1==1&&num2==0)
      return true;
      else if(num1==0&&num2==0)
      return true;
      else
      return false;
   }
   public boolean nor(int num1, int num2)
   {
      if(num1==1&&num2==1)
      return false;
      else if(num1==0&&num2==1)
      return false;
      else if(num1==1&&num2==0)
      return false;
      else if(num1==0&&num2==0)
      return true;
      else
      return false;
   }
   public boolean xOr(int num1, int num2)
   {
      if(num1==1&&num2==1)
      return false;
      else if(num1==0&&num2==1)
      return true;
      else if(num1==1&&num2==0)
      return true;
      else if(num1==0&&num2==0)
      return false;
      else
      return false;
   }
   public boolean xNor(int num1, int num2)
   {
      if(num1==1&&num2==1)
      return true;
      else if(num1==0&&num2==1)
      return false;
      else if(num1==1&&num2==0)
      return false;
      else if(num1==0&&num2==0)
      return true;
      else
      return false;
   }
 
}

//--------------------------------------------
public class LogicGates2
{
   public static void main(String args[])
   {
      new LogicGatesV2();
      
   }
}