package chatting_app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
public class client extends JFrame implements ActionListener {
  
    
   JPanel p1;
    JTextField t1;
   JButton b1; 
 static JTextArea a1;
   
   
    static Socket s;
  static DataInputStream din;
  static DataOutputStream dout;
  
  boolean typing;

   
   client(){
        p1 = new JPanel(); 
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        add(p1);
        
        
       
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("chatting_app/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(3,8,40,40);
       p1. add(l1);
       
       l1.addMouseListener(new MouseAdapter(){
    public void mouseClicked (MouseEvent ae){
        System.exit(0);
    }
    });
       
       
        
           ImageIcon i4 =new ImageIcon(ClassLoader.getSystemResource("chatting_app/icons/12.png"));
        Image i5 = i4.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(35,5,60,60);
       p1. add(l2);
       
        ImageIcon i7 =new ImageIcon(ClassLoader.getSystemResource("chatting_app/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i9 =new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(290,19,30,30);
       p1. add(l5);
   
       
        ImageIcon i11 =new ImageIcon(ClassLoader.getSystemResource("chatting_app/icons/phone.png"));
        Image i12 = i11.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i13 =new ImageIcon(i12);
        JLabel l6 = new JLabel(i13);
        l6.setBounds(335,19,30,30);
       p1. add(l6);
       
        ImageIcon i14 =new ImageIcon(ClassLoader.getSystemResource("chatting_app/icons/3icon.png"));
        Image i15 = i14.getImage().getScaledInstance(12,22,Image.SCALE_DEFAULT);
        ImageIcon i16 =new ImageIcon(i15);
        JLabel l7 = new JLabel(i16);
        l7.setBounds(370,21,12,22);
       p1. add(l7);
   
   
       
       
       
       JLabel l3 = new JLabel("Shubham");
       l3.setFont(new Font("SAN_SERFIE",Font.BOLD,22));
       l3.setForeground(Color.WHITE);
       l3.setBounds(110,15,100,18);
       p1.add(l3);
       
       
        JLabel l4 = new JLabel("Active Now");
       l4.setFont(new Font("SAN_SERFIE",Font.PLAIN,14));
       l4.setForeground(Color.WHITE);
       l4.setBounds(110,35,100,20);
       p1.add(l4);
       
          /*    Timer t = new Timer(1, new ActionListener(){
           public void actionPerformed(ActionEvent ae){
               if(!typing){
                   l4.setText("Active Now");
               }
           }
       });

       t.setInitialDelay(2000);*/

  
       
       
       
       
       a1 = new JTextArea();
       a1.setBounds(3,75,385,520);
     // a1.setBackground(Color.pink);
      a1.setFont(new Font("SAN_SERFIE",Font.PLAIN,16));
      a1.setEditable(false);
      a1.setLineWrap(true);
      a1.setWrapStyleWord(true);
       add(a1);
       
       
       
       
  
       t1 = new JTextField();
       t1.setBounds(3,600,300,35);
        t1. setFont(new Font("SAN_SERFIE",Font.BOLD,16));
 
       add(t1);
       
       b1 = new JButton("send");
       b1.setBounds(280,600,115,35);
       b1.setBackground(new Color (7,94,84));
       b1.setForeground(Color.WHITE);
       b1.setFont(new Font("SAN_SERFIE",Font.PLAIN,16));
       b1.addActionListener(this);
       add(b1);
       
  
       
     getContentPane().setBackground(Color.white);
       
        setLayout(null);  
      setSize(400,650);
      setLocation(800,50);
      setUndecorated(true);
       setVisible(true); 
        
    
}
    
    public void actionPerformed(ActionEvent ae){
        try{    
        String out = t1.getText();
         a1.setText(a1.getText()+"\n\t\t\t"+out);
         dout.writeUTF(out);
         t1.setText("");
         
        }catch(Exception e){
        }
    }
 public static void main(String[] args){
 
 new client().setVisible(true);
 
 try{
     
     s=new Socket("127.0.0.1",6001);
     
      din = new  DataInputStream(s.getInputStream());
     dout = new DataOutputStream(s.getOutputStream());
     String msginput = "";
        while(true){
                a1.setLayout(new BorderLayout());
	        msginput = din.readUTF();
            	a1.setText(a1.getText()+"\n"+msginput);
            	//JPanel p2 = formatLabel(msginput);
              JPanel left = new JPanel(new BorderLayout());
              //  left.add(p2, BorderLayout.LINE_START);

               // vertical.add(left);
              //  vertical.add(Box.createVerticalStrut(15));
             //   a1.add(vertical, BorderLayout.PAGE_START);
              //  f1.validate();
            }

        }catch(Exception e){
        }
 
}
}