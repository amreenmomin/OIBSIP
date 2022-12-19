import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception; 
import java.util.Timer;
import java.util.TimerTask;  
class login extends JFrame implements ActionListener  
{   
    JButton b1;  
    JPanel newPanel;  
    JLabel userLabel, passLabel;  
    final JTextField  textField1, textField2;  
  
    login()  
    {     
  
        userLabel = new JLabel();  
        userLabel.setText("Username");  
     
        textField1 = new JTextField(20);   
  
       
        passLabel = new JLabel();  
        passLabel.setText("Password");       
           
        textField2 = new JPasswordField(20);     
           
        b1 = new JButton("submit"); 
       
        newPanel = new JPanel(new GridLayout(5, 3));  
        newPanel.add(userLabel);    
        newPanel.add(textField1);     
        newPanel.add(passLabel);     
        newPanel.add(textField2);    
        newPanel.add(b1);            
          
          
        add(newPanel, BorderLayout.CENTER);  
          
          
        b1.addActionListener(this);      
        setTitle("LOGIN FORM FOR TEST");         
    }  
         
    public void actionPerformed(ActionEvent ae)    
    {  
        String userValue = textField1.getText();          
        String passValue = textField2.getText();         
       
    
        if(!passValue.equals(""))
            new OnlineTestBegin(userValue); 
        else{
            textField2.setText("Enter Password");
            actionPerformed(ae);
        }
    }
        
}  
class OnlineTestBegin extends JFrame implements ActionListener  
{  
    JLabel l;  
    JLabel l1;
     
    
    JRadioButton jb[]=new JRadioButton[8];  
    JButton b1,b2,log;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];  
    Timer timer = new Timer();
    
   
    OnlineTestBegin(String s)  
    {  
        
        super(s); 
        
        l=new JLabel();
        l1 = new JLabel();  
        
        add(l);
        add(l1);  
        bg=new ButtonGroup();  
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Save and Next");  
        b2=new JButton("Marked for Review");  
        b1.addActionListener(this);  
        b2.addActionListener(this);  
        add(b1);add(b2);  
        set();  
        l.setBounds(35,45,505,25);
        l1.setBounds(25,25,455,25);
        jb[0].setBounds(60,90,100,30);  
        jb[1].setBounds(60,110,100,30);  
        jb[2].setBounds(60,140,100,30);  
        jb[3].setBounds(60,170,100,30);
         
        b1.setBounds(85,230,130,30);  
        b2.setBounds(260,230,150,30);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(350,100);  
        setVisible(true);  
        setSize(700,350);  
        
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 80;
    
            public void run() {
    
                l1.setText("Time left: " + i);
                i--;
    
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Over");
                }
            }
        }, 0, 1000);    
       
    }  
    public void actionPerformed(ActionEvent e)  
    {   
        
        if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==4)  
            {  
                b1.setEnabled(false);  
                b2.setText("Result");  
            }  
        }  
        if(e.getActionCommand().equals("Marked for Review"))  
        {  
            JButton bk=new JButton("Review"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==5)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Review"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
      
        if(e.getActionCommand().equals("Result"))  
        {  
            if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            JOptionPane.showMessageDialog(this,"Score ="+count);  
            System.exit(0);  
        }  
    }  
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Who is the father of computer?");  
            jb[0].setText("James");jb[1].setText("Charles Babbage");jb[2].setText("Dennis Ritchie");jb[3].setText("Bjarne Stroustrup");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: What is the full form of CPU?");  
            jb[0].setText("Computer processor Unit");jb[1].setText("Central Processing Unit");jb[2].setText("Computer Portable Unit");jb[3].setText("Control Process Unit");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Who invented python?");  
            jb[0].setText("Charles");jb[1].setText("James");jb[2].setText("Guido Van Rossum ");jb[3].setText("None of the mentioned");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: What is the extension of java code files?");  
            jb[0].setText(".js");jb[1].setText(".txt");jb[2].setText(".class");jb[3].setText(".java");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: which of the following is not an OOPS concept in java?");  
            jb[0].setText("Polymorphism");jb[1].setText("Inheritance");jb[2].setText("Compilation");jb[3].setText("Encapsulation");  
        }  
  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[1].isSelected());  
        if(current==1)  
            return(jb[1].isSelected());  
        if(current==2)  
            return(jb[2].isSelected());  
        if(current==3)  
            return(jb[0].isSelected());  
        if(current==4)  
            return(jb[2].isSelected());  
      
        return false;  
    } 
   
    
} 
 
class Online_exam  
{  
     
    public static void main(String arg[])  
    {  
        try  
        {  
         
            login form = new login();  
            form.setSize(700,300);   
            form.setVisible(true);    
        }  
        catch(Exception e)  
        {      
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
    }  
} 