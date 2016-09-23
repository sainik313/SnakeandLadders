import java.awt.*; 
import java.awt.event.*;  
import javax.swing.*; 
import java.awt.BorderLayout; 
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Dimension;

class Snake extends JFrame implements ActionListener{ 

JFrame f;
JPanel p,p1,p2,p21,p22,p23,p231,p232,p233,p24,p3,p4;

JLabel l[]=new JLabel[900];
JLabel ll1,ll2,ll21,ll22,ll23,ll24,ll25,ll26,ll27,ll28,ll3,ll4,ll5,dice;
Icon ic[]=new Icon[900];
JButton b1,b2,b21,b22,b23,b24,b3,b4;
Icon img,img1,pl1,pl2;
int x,y,rand;
int v1=0, v2=0,turn=0,prev1,prev2,select=0;
Timer timer;

Random randomGenerator = new Random();

Snake()
{
	p= new JPanel();
	p1= new JPanel();
	p2= new JPanel();
	p3= new JPanel();
	p4= new JPanel();
	p21= new JPanel();
	p22= new JPanel();
	p23= new JPanel();
	p231= new JPanel();
	p232= new JPanel();
	p233= new JPanel();
	p24= new JPanel();
	
	f=new JFrame("Snack and Ladder");
	
	//panel p
	for(int i=1;i<=780;i++)
	{
	l[i]=new JLabel();
	
	
	ic[i]=new ImageIcon(((new ImageIcon("images/i ("+i+").jpeg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	l[i].setIcon(ic[i]);
	p.add(l[i]);
	
	}
	p.setLayout(new GridLayout(26,30));
	
	//starting position of player
	pl1=new ImageIcon(((new ImageIcon("p1.jpg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	pl2=new ImageIcon(((new ImageIcon("p2.jpg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	
	l[674].setIcon(pl1);
		prev1=674;
		System.out.println("Player 1 position 0");
		
	l[676].setIcon(pl2);
		prev2=676;
		System.out.println("Player 2 position 0");
	
	//panel p1
	ll1=new JLabel();
	ll1.setText("<html><p style='color:red; font-family: Agency FB; font-size:30px; padding:10px;'>Snack and Ladder Game</p><html>");
	p1.add(ll1);
	p1.setBackground(new Color (135,206,235));
	
	//panel p2
	ll2=new JLabel();
	ll2.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Select Your Game Mode</p><html>");
	
	b21=new JButton("Vs Player");
	b22=new JButton("Vs Computer");
	b21.addActionListener(this);
	b22.addActionListener(this);
	
	p21.add(b21);
	p21.add(b22);
	
	p21.setLayout(new GridLayout(1,2,50,0));
	
	ll25=new JLabel();
	ll25.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Please Select</p><html>");
	
	
	p22.add(ll2);
	p22.add(p21);
	p22.add(ll25);
	p22.setLayout(new GridLayout(3,1));
	
	ll21=new JLabel();
	ll21.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Your Dice</p><html>");
	
	img =new ImageIcon("0.gif");
	
	dice=new JLabel();
	dice.setIcon(img); 
	
	
	ll22=new JLabel();
	ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 1:-</p><html>");
	b23=new JButton("Roll Dice");
	b23.addActionListener(this);
	
	p231.add(dice);
	p231.add(p232);
	p231.add(dice,BorderLayout.CENTER);
	
	p232.add(ll22);
	p232.add(b23);
	p232.setLayout(new GridLayout(1,2));
	
	p23.add(ll21);
	p23.add(p231);
	p23.add(p232);
	p23.setLayout(new GridLayout(3,1));
	
	ll23=new JLabel();
	ll23.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Game Status</p><html>");
		
	ll26=new JLabel();
	ll26.setText("Player1 at :- 0");
	ll26.setForeground(Color.RED);
		
	ll27=new JLabel();
	ll27.setText("Player2 at :- 0");
	ll27.setForeground(Color.RED);
	 
	p233.add(ll26);
	p233.add(ll27);
	p233.setLayout(new GridLayout(1,2));
	
	b24=new JButton("Restart Game");
	b24.addActionListener(this);
	
    p24.add(ll23);
    p24.add(p233);
    p24.add(b24);
     
	p24.setLayout(new GridLayout(3,1));
	
 
	p2.add(p22);
	p2.add(p23);
	p2.add(p24);
	p2.setLayout(new GridLayout(3,1));
	
	p2.setBackground(new Color (255,255,255));
	
	//panel p3
	ll3=new JLabel();
	ll3.setText("<html><p style='color:red; font-family: Agency FB; font-size:10px; padding:20px;'> &copy All Rights Reserverd by Kapil Saini</p><html>");
	p3.add(ll3);
	p3.setBackground(new Color (135,206,235));
	
	//panel p4
	ll4=new JLabel();
	ll4.setText("<html><p style='color:red; font-family: Agency FB; font-size:20px; padding:10px;'><b>S</b><br>N<br>A<br>C<br>K<br><br>&<br><br>L<br>A<br>D<br>D<br>E<br>R</p><html>");
	p4.add(ll4);
	p4.setBackground(new Color (255,255,255));
	
	//frame
	f.add(p);
	f.add(p1);
	f.add(p2);
	f.add(p3);
	f.add(p4);
	
	f.add(p,BorderLayout.CENTER); 
	f.add(p1,BorderLayout.NORTH); 
	f.add(p2,BorderLayout.EAST); 
	f.add(p3,BorderLayout.SOUTH); 
	f.add(p4,BorderLayout.WEST); 
	
	f.setBackground(new Color (255,255,255));
	f.pack();
	f.setVisible(true);
	f.setSize(1366,730);
	
	//f.setMaximumSize(new Dimension(1000, 550));
	f.setIconImage(new ImageIcon("02.jpg").getImage());
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

void rand(){
	rand = randomGenerator.nextInt((6 - 1) + 1) + 1;
	System.out.println("Rand: "+rand);
}

public void rolldice(){
	img1=new ImageIcon(rand+".gif");       
	dice.setIcon(img1);  
}

public void count()
{
	if(turn==0)
	{
		if(rand!=6)
		{
		v1=v1+rand;
		ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 2:-</p><html>");
		turn=1;
		System.out.println("p1 value:"+v1);
		}
		else{
			v1=v1+rand;
		ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 1:-</p><html>");
		turn=0;
		System.out.println("p1 value:"+v1);
		}
	}
	else
	{
		if(rand!=6)
		{
		v2=v2+rand;
		ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 1:-</p><html>");
		turn=0;
		System.out.println("p2 value:"+v2);
		}
		else{
			v2=v2+rand;
		ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 2:-</p><html>");
		turn=1;
		System.out.println("p2 value:"+v2);
		}
	}
	
	if(v1==v2){
		if(turn==1){
			v2=0;
			turn=0;
			l[prev1].setIcon(ic[prev1]);
			l[prev2].setIcon(pl1);
			prev1=prev2;
			ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 1:-</p><html>");
			System.out.println("Player 1 position "+v1);
			
			//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
                l[676].setIcon(pl2);
		prev2=676;
		System.out.println("Player 2 position 0");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
		}
		else{
			v1=0;
			turn=1;
			l[prev2].setIcon(ic[prev2]);
			l[prev1].setIcon(pl2);
			prev2=prev1;
			ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 2:-</p><html>");
			System.out.println("Player 2 position "+v2);
			
			//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
                l[674].setIcon(pl1);
		prev1=674;
		System.out.println("Player 1 position 0");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
		}
	}
}

public void change()
{
	pl1=new ImageIcon(((new ImageIcon("p1.jpg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	pl2=new ImageIcon(((new ImageIcon("p2.jpg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	
	/*
	if(v1==0){
		//ic[1]=new ImageIcon(((new ImageIcon("1.gif")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
		l[674].setIcon(pl1);
		prev1=674;
		System.out.println("Player 1 position 1");
	}
	if(v2==0){
		//ic[2]=new ImageIcon(((new ImageIcon("1.gif")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
		l[676].setIcon(pl2);
		prev1=676;
		System.out.println("Player 2 position 0");
	}
	*/
	
	
	if(turn==1)
	{
		
	if(v1==1)
	{
		l[prev1].setIcon(ic[prev1]);
		l[702].setIcon(pl1);
		prev1=702;
		System.out.println("Player 1 position 1");
	}
	if(v1==2)
	{
		
		l[prev1].setIcon(ic[prev1]);
		l[700].setIcon(pl1);
		prev1=700;
		System.out.println("Player 1 position 2");
	}
	if(v1==3)
	{
		l[prev1].setIcon(ic[prev1]);
		l[697].setIcon(pl1);
		prev1=697;
		System.out.println("Player 1 position 3");
	}
	if(v1==4)
	{
		l[prev1].setIcon(ic[prev1]);
		l[665].setIcon(pl1);
		prev1=665;
		System.out.println("Player 1 position 4");
	}
	if(v1==5)
	{
		l[prev1].setIcon(ic[prev1]);
		l[575].setIcon(pl1);
		prev1=575;
		System.out.println("Player 1 position 5");
	}
	if(v1==6)
	{
		l[prev1].setIcon(ic[prev1]);
		l[547].setIcon(pl1);
		prev1=547;
		System.out.println("Player 1 position 6");
	}
	if(v1==7)
	{
		l[prev1].setIcon(ic[prev1]);
		l[550].setIcon(pl1);
		prev1=550;
		System.out.println("Player 1 position 7");
	}
	if(v1==8)
	{ 
		l[prev1].setIcon(ic[prev1]);
		l[552].setIcon(pl1);
		prev1=552;
		System.out.println("Player 1 position 8");
	}
	if(v1==9)
	{
		l[prev1].setIcon(ic[prev1]);
		l[554].setIcon(pl1);
		prev1=554;
		System.out.println("Player 1 position 9");
	}
	if(v1==10)
	{
		l[prev1].setIcon(ic[prev1]);
		l[586].setIcon(pl1);
		prev1=586;
		System.out.println("Player 1 position 10");
		v1=24;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
                l[prev1].setIcon(ic[prev1]);
		l[346].setIcon(pl1);
		prev1=346;
		System.out.println("Player 1 position 24");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==11)
	{
		l[prev1].setIcon(ic[prev1]);
		l[588].setIcon(pl1);
		prev1=588;
		System.out.println("Player 1 position 11");
	}
	if(v1==12)
	{
		l[prev1].setIcon(ic[prev1]);
		l[590].setIcon(pl1);
		prev1=590;
		System.out.println("Player 1 position 12");
	}
	if(v1==13)
	{
		l[prev1].setIcon(ic[prev1]);
		l[592].setIcon(pl1);
		prev1=592;
		System.out.println("Player 1 position 13");
	}
	if(v1==14)
	{
		l[prev1].setIcon(ic[prev1]);
		l[594].setIcon(pl1);
		prev1=594;
		System.out.println("Player 1 position 14");
	}
	if(v1==15)
	{
		l[prev1].setIcon(ic[prev1]);
		l[566].setIcon(pl1);
		prev1=566;
		System.out.println("Player 1 position 15");
	}
	if(v1==16)
	{
		l[prev1].setIcon(ic[prev1]);
		l[568].setIcon(pl1);
		prev1=568;
		System.out.println("Player 1 position 16");
	}
	if(v1==17)
	{
		l[prev1].setIcon(ic[prev1]);
		l[479].setIcon(pl1);
		prev1=479;
		System.out.println("Player 1 position 17");
	}
	if(v1==18)
	{
		l[prev1].setIcon(ic[prev1]);
		l[418].setIcon(pl1);
		prev1=418;
		System.out.println("Player 1 position 18");
	}
	if(v1==19)
	{
		l[prev1].setIcon(ic[prev1]);
		l[387].setIcon(pl1);
		prev1=387;
		System.out.println("Player 1 position 19");
		v1=39;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {
		
            public void actionPerformed(ActionEvent e) {
				
               l[prev1].setIcon(ic[prev1]);
		l[236].setIcon(pl1);
		prev1=236;
		System.out.println("Player 1 position 39");
		
		 
            }
			
        });
        timer.start();
		timer.setRepeats(false);
        
	}
	if(v1==20)
	{
		l[prev1].setIcon(ic[prev1]);
		l[355].setIcon(pl1);
		prev1=355;
		System.out.println("Player 1 position 20");
	}
	if(v1==21)
	{
		l[prev1].setIcon(ic[prev1]);
		l[353].setIcon(pl1);
		prev1=353;
		System.out.println("Player 1 position 21");
		v1=13;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {
		
            public void actionPerformed(ActionEvent e) {
				
                l[prev1].setIcon(ic[prev1]);
		l[592].setIcon(pl1);
		prev1=592;
		System.out.println("Player 1 position 13");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==22)
	{
		l[prev1].setIcon(ic[prev1]);
		l[350].setIcon(pl1);
		prev1=350;
		System.out.println("Player 1 position 22");
	}
	if(v1==23)
	{
		l[prev1].setIcon(ic[prev1]);
		l[348].setIcon(pl1);
		prev1=348;
		System.out.println("Player 1 position 23");
	}
	if(v1==24)
	{
		l[prev1].setIcon(ic[prev1]);
		l[346].setIcon(pl1);
		prev1=346;
		System.out.println("Player 1 position 24");
	}
	if(v1==25)
	{
		l[prev1].setIcon(ic[prev1]);
		l[348].setIcon(pl1);
		prev1=348;
		System.out.println("Player 1 position 25");
	}
	if(v1==26)
	{
		l[prev1].setIcon(ic[prev1]);
		l[343].setIcon(pl1);
		prev1=343;
		System.out.println("Player 1 position 26");
	}
	if(v1==27)
	{
		l[prev1].setIcon(ic[prev1]);
		l[310].setIcon(pl1);
		prev1=310;
		System.out.println("Player 1 position 27");
	}
	if(v1==28)
	{
		l[prev1].setIcon(ic[prev1]);
		l[308].setIcon(pl1);
		prev1=308;
		System.out.println("Player 1 position 28");
	}
	if(v1==29)
	{
		l[prev1].setIcon(ic[prev1]);
		l[277].setIcon(pl1);
		prev1=277;
		System.out.println("Player 1 position 29");
		v1=5;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
                l[prev1].setIcon(ic[prev1]);
		l[575].setIcon(pl1);
		prev1=575;
		System.out.println("Player 1 position 5");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==30)
	{
		l[prev1].setIcon(ic[prev1]);
		l[218].setIcon(pl1);
		prev1=218;
		System.out.println("Player 1 position 30");
	}
	if(v1==31)
	{
		l[prev1].setIcon(ic[prev1]);
		l[221].setIcon(pl1);
		prev1=221;
		System.out.println("Player 1 position 31");
		v1=49;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
		
		
		l[prev1].setIcon(ic[prev1]);
		l[69].setIcon(pl1);
		prev1=69;
		System.out.println("Player 1 position 49");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==32)
	{
		l[prev1].setIcon(ic[prev1]);
		l[223].setIcon(pl1);
		prev1=223;
		System.out.println("Player 1 position 32");
	}
	if(v1==33)
	{
		l[prev1].setIcon(ic[prev1]);
		l[225].setIcon(pl1);
		prev1=225;
		System.out.println("Player 1 position 33");
	}
	if(v1==34)
	{
		l[prev1].setIcon(ic[prev1]);
		l[257].setIcon(pl1);
		prev1=257;
		System.out.println("Player 1 position 34");
	}
	if(v1==35)
	{
		l[prev1].setIcon(ic[prev1]);
		l[259].setIcon(pl1);
		prev1=259;
		System.out.println("Player 1 position 35");
		v1=45;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
               l[prev1].setIcon(ic[prev1]);
		l[49].setIcon(pl1);
		prev1=49;
		System.out.println("Player 1 position 45");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==36)
	{
		l[prev1].setIcon(ic[prev1]);
		l[261].setIcon(pl1);
		prev1=261;
		System.out.println("Player 1 position 36");
	}
	if(v1==37)
	{
		l[prev1].setIcon(ic[prev1]);
		l[263].setIcon(pl1);
		prev1=263;
		System.out.println("Player 1 position 37");
	}
	if(v1==38)
	{
		l[prev1].setIcon(ic[prev1]);
		l[264].setIcon(pl1);
		prev1=264;
		System.out.println("Player 1 position 38");
	}
	if(v1==39)
	{
		l[prev1].setIcon(ic[prev1]);
		l[236].setIcon(pl1);
		prev1=236;
		System.out.println("Player 1 position 39");
	}
	if(v1==40)
	{
		l[prev1].setIcon(ic[prev1]);
		l[207].setIcon(pl1);
		prev1=207;
		System.out.println("Player 1 position 40");
	}
	if(v1==41)
	{
		l[prev1].setIcon(ic[prev1]);
		l[147].setIcon(pl1);
		prev1=147;
		System.out.println("Player 1 position 41");
		v1=11;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
	
		l[prev1].setIcon(ic[prev1]);
		l[588].setIcon(pl1);
		prev1=588;
		System.out.println("Player 1 position 11");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==42)
	{
		l[prev1].setIcon(ic[prev1]);
		l[86].setIcon(pl1);
		prev1=86;
		System.out.println("Player 1 position 42");
	}
	if(v1==43)
	{
		l[prev1].setIcon(ic[prev1]);
		l[54].setIcon(pl1);
		prev1=54;
		System.out.println("Player 1 position 43");
	}
	if(v1==44)
	{
		l[prev1].setIcon(ic[prev1]);
		l[52].setIcon(pl1);
		prev1=52;
		System.out.println("Player 1 position 44");
	}
	if(v1==45)
	{
		l[prev1].setIcon(ic[prev1]);
		l[49].setIcon(pl1);
		prev1=49;
		System.out.println("Player 1 position 45");
	}
	if(v1==46)
	{
		l[prev1].setIcon(ic[prev1]);
		l[76].setIcon(pl1);
		prev1=76;
		System.out.println("Player 1 position 46");
	}
	if(v1==47)
	{
		l[prev1].setIcon(ic[prev1]);
		l[74].setIcon(pl1);
		prev1=74;
		System.out.println("Player 1 position 47");
		v1=34;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
	
		l[prev1].setIcon(ic[prev1]);
		l[257].setIcon(pl1);
		prev1=257;
		System.out.println("Player 1 position 34");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v1==48)
	{
		l[prev1].setIcon(ic[prev1]);
		l[72].setIcon(pl1);
		prev1=72;
		System.out.println("Player 1 position 48");
	}
	if(v1==49)
	{
		l[prev1].setIcon(ic[prev1]);
		l[69].setIcon(pl1);
		prev1=69;
		System.out.println("Player 1 position 49");
	}
	if(v1==50)
	{
		l[prev1].setIcon(ic[prev1]);
		l[97].setIcon(pl1);
		prev1=97;
		System.out.println("Player 1 position 50");
	}
	if(v1>50)
	{
		l[prev1].setIcon(ic[prev1]);
		l[95].setIcon(pl1);
		prev1=95;
		JOptionPane.showMessageDialog(p, "Player 1 win the Game");
		System.out.println("Player 1 Win the game");
	}
	
	}
	
	else{
		
	if(v2==1)
	{
		l[prev2].setIcon(ic[prev2]);
		l[702].setIcon(pl2);
		prev2=702;
		System.out.println("Player 2 position 1");
	}
	if(v2==2)
	{
		
		l[prev2].setIcon(ic[prev2]);
		l[700].setIcon(pl2);
		prev2=700;
		System.out.println("Player 2 position 2");
	}
	if(v2==3)
	{
		l[prev2].setIcon(ic[prev2]);
		l[697].setIcon(pl2);
		prev2=697;
		System.out.println("Player 2 position 3");
	}
	if(v2==4)
	{
		l[prev2].setIcon(ic[prev2]);
		l[665].setIcon(pl2);
		prev2=665;
		System.out.println("Player 2 position 4");
	}
	if(v2==5)
	{
		l[prev2].setIcon(ic[prev2]);
		l[575].setIcon(pl2);
		prev2=575;
		System.out.println("Player 2 position 5");
	}
	if(v2==6)
	{
		l[prev2].setIcon(ic[prev2]);
		l[547].setIcon(pl2);
		prev2=547;
		System.out.println("Player 2 position 6");
	}
	if(v2==7)
	{
		l[prev2].setIcon(ic[prev2]);
		l[550].setIcon(pl2);
		prev2=550;
		System.out.println("Player 2 position 7");
	}
	if(v2==8)
	{ 
		l[prev2].setIcon(ic[prev2]);
		l[552].setIcon(pl2);
		prev2=552;
		System.out.println("Player 2 position 8");
	}
	if(v2==9)
	{
		l[prev2].setIcon(ic[prev2]);
		l[554].setIcon(pl2);
		prev2=554;
		System.out.println("Player 2 position 9");
	}
	if(v2==10)
	{
		l[prev2].setIcon(ic[prev2]);
		l[586].setIcon(pl2);
		prev2=586;
		System.out.println("Player 2 position 10");
		v2=24;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
                l[prev2].setIcon(ic[prev2]);
		l[346].setIcon(pl2);
		prev2=346;
		System.out.println("Player 2 position 24");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==11)
	{
		l[prev2].setIcon(ic[prev2]);
		l[588].setIcon(pl2);
		prev2=588;
		System.out.println("Player 2 position 11");
	}
	if(v2==12)
	{
		l[prev2].setIcon(ic[prev2]);
		l[590].setIcon(pl2);
		prev2=590;
		System.out.println("Player 2 position 12");
	}
	if(v2==13)
	{
		l[prev2].setIcon(ic[prev2]);
		l[592].setIcon(pl2);
		prev2=592;
		System.out.println("Player 2 position 13");
	}
	if(v2==14)
	{
		l[prev2].setIcon(ic[prev2]);
		l[594].setIcon(pl2);
		prev2=594;
		System.out.println("Player 2 position 14");
	}
	if(v2==15)
	{
		l[prev2].setIcon(ic[prev2]);
		l[566].setIcon(pl2);
		prev2=566;
		System.out.println("Player 2 position 15");
	}
	if(v2==16)
	{
		l[prev2].setIcon(ic[prev2]);
		l[568].setIcon(pl2);
		prev2=568;
		System.out.println("Player 2 position 16");
	}
	if(v2==17)
	{
		l[prev2].setIcon(ic[prev2]);
		l[479].setIcon(pl2);
		prev2=479;
		System.out.println("Player 2 position 17");
	}
	if(v2==18)
	{
		l[prev2].setIcon(ic[prev2]);
		l[418].setIcon(pl2);
		prev2=418;
		System.out.println("Player 2 position 18");
	}
	if(v2==19)
	{
		l[prev2].setIcon(ic[prev2]);
		l[387].setIcon(pl2);
		prev2=387;
		System.out.println("Player 2 position 19");
		v2=39;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {
		
            public void actionPerformed(ActionEvent e) {
				
               l[prev2].setIcon(ic[prev2]);
		l[236].setIcon(pl2);
		prev2=236;
		System.out.println("Player 2 position 39");
		
		 
            }
			
        });
        timer.start();
		timer.setRepeats(false);
        
	}
	if(v2==20)
	{
		l[prev2].setIcon(ic[prev2]);
		l[355].setIcon(pl2);
		prev2=355;
		System.out.println("Player 2 position 20");
	}
	if(v2==21)
	{
		l[prev2].setIcon(ic[prev2]);
		l[353].setIcon(pl2);
		prev2=353;
		System.out.println("Player 2 position 21");
		v2=13;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {
		
            public void actionPerformed(ActionEvent e) {
				
                l[prev2].setIcon(ic[prev2]);
		l[592].setIcon(pl2);
		prev2=592;
		System.out.println("Player 2 position 13");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==22)
	{
		l[prev2].setIcon(ic[prev2]);
		l[350].setIcon(pl2);
		prev2=350;
		System.out.println("Player 2 position 22");
	}
	if(v2==23)
	{
		l[prev2].setIcon(ic[prev2]);
		l[348].setIcon(pl2);
		prev2=348;
		System.out.println("Player 2 position 23");
	}
	if(v2==24)
	{
		l[prev2].setIcon(ic[prev2]);
		l[346].setIcon(pl2);
		prev2=346;
		System.out.println("Player 2 position 24");
	}
	if(v2==25)
	{
		l[prev2].setIcon(ic[prev2]);
		l[348].setIcon(pl2);
		prev2=348;
		System.out.println("Player 2 position 25");
	}
	if(v2==26)
	{
		l[prev2].setIcon(ic[prev2]);
		l[343].setIcon(pl2);
		prev2=343;
		System.out.println("Player 2 position 26");
	}
	if(v2==27)
	{
		l[prev2].setIcon(ic[prev2]);
		l[310].setIcon(pl2);
		prev2=310;
		System.out.println("Player 2 position 27");
	}
	if(v2==28)
	{
		l[prev2].setIcon(ic[prev2]);
		l[308].setIcon(pl2);
		prev2=308;
		System.out.println("Player 2 position 28");
	}
	if(v2==29)
	{
		l[prev2].setIcon(ic[prev2]);
		l[277].setIcon(pl2);
		prev2=277;
		System.out.println("Player 2 position 29");
		v2=5;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
                l[prev2].setIcon(ic[prev2]);
		l[575].setIcon(pl2);
		prev2=575;
		System.out.println("Player 2 position 5");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==30)
	{
		l[prev2].setIcon(ic[prev2]);
		l[218].setIcon(pl2);
		prev2=218;
		System.out.println("Player 2 position 30");
	}
	if(v2==31)
	{
		l[prev2].setIcon(ic[prev2]);
		l[221].setIcon(pl2);
		prev2=221;
		System.out.println("Player 2 position 31");
		v2=49;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
		
		
		l[prev2].setIcon(ic[prev2]);
		l[69].setIcon(pl2);
		prev2=69;
		System.out.println("Player 2 position 49");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==32)
	{
		l[prev2].setIcon(ic[prev2]);
		l[223].setIcon(pl2);
		prev2=223;
		System.out.println("Player 2 position 32");
	}
	if(v2==33)
	{
		l[prev2].setIcon(ic[prev2]);
		l[225].setIcon(pl2);
		prev2=225;
		System.out.println("Player 2 position 33");
	}
	if(v2==34)
	{
		l[prev2].setIcon(ic[prev2]);
		l[257].setIcon(pl2);
		prev2=257;
		System.out.println("Player 2 position 34");
	}
	if(v2==35)
	{
		l[prev2].setIcon(ic[prev2]);
		l[259].setIcon(pl2);
		prev2=259;
		System.out.println("Player 2 position 35");
		v2=45;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
               l[prev2].setIcon(ic[prev2]);
		l[49].setIcon(pl2);
		prev2=49;
		System.out.println("Player 2 position 45");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==36)
	{
		l[prev2].setIcon(ic[prev2]);
		l[261].setIcon(pl2);
		prev2=261;
		System.out.println("Player 2 position 36");
	}
	if(v2==37)
	{
		l[prev2].setIcon(ic[prev2]);
		l[263].setIcon(pl2);
		prev2=263;
		System.out.println("Player 2 position 37");
	}
	if(v2==38)
	{
		l[prev2].setIcon(ic[prev2]);
		l[264].setIcon(pl2);
		prev2=264;
		System.out.println("Player 2 position 38");
	}
	if(v2==39)
	{
		l[prev2].setIcon(ic[prev2]);
		l[236].setIcon(pl2);
		prev2=236;
		System.out.println("Player 2 position 39");
	}
	if(v2==40)
	{
		l[prev2].setIcon(ic[prev2]);
		l[207].setIcon(pl2);
		prev2=207;
		System.out.println("Player 2 position 40");
	}
	if(v2==41)
	{
		l[prev2].setIcon(ic[prev2]);
		l[147].setIcon(pl2);
		prev2=147;
		System.out.println("Player 2 position 41");
		v2=11;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
	
		l[prev2].setIcon(ic[prev2]);
		l[588].setIcon(pl2);
		prev2=588;
		System.out.println("Player 2 position 11");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==42)
	{
		l[prev2].setIcon(ic[prev2]);
		l[86].setIcon(pl2);
		prev2=86;
		System.out.println("Player 2 position 42");
	}
	if(v2==43)
	{
		l[prev2].setIcon(ic[prev2]);
		l[54].setIcon(pl2);
		prev2=54;
		System.out.println("Player 2 position 43");
	}
	if(v2==44)
	{
		l[prev2].setIcon(ic[prev2]);
		l[52].setIcon(pl2);
		prev2=52;
		System.out.println("Player 2 position 44");
	}
	if(v2==45)
	{
		l[prev2].setIcon(ic[prev2]);
		l[49].setIcon(pl2);
		prev2=49;
		System.out.println("Player 2 position 45");
	}
	if(v2==46)
	{
		l[prev2].setIcon(ic[prev2]);
		l[76].setIcon(pl2);
		prev2=76;
		System.out.println("Player 2 position 46");
	}
	if(v2==47)
	{
		l[prev2].setIcon(ic[prev2]);
		l[74].setIcon(pl2);
		prev2=74;
		System.out.println("Player 2 position 47");
		v2=34;
		//after ladder
		Timer timer = new Timer(1000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
	
		l[prev2].setIcon(ic[prev2]);
		l[257].setIcon(pl2);
		prev2=257;
		System.out.println("Player 2 position 34");
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
	}
	if(v2==48)
	{
		l[prev2].setIcon(ic[prev2]);
		l[72].setIcon(pl2);
		prev2=72;
		System.out.println("Player 2 position 48");
	}
	if(v2==49)
	{
		l[prev2].setIcon(ic[prev2]);
		l[69].setIcon(pl2);
		prev2=69;
		System.out.println("Player 2 position 49");
	}
	if(v2==50)
	{
		l[prev2].setIcon(ic[prev2]);
		l[97].setIcon(pl2);
		prev2=97;
		System.out.println("Player 2 position 50");
	}
	if(v2>50)
	{
		l[prev2].setIcon(ic[prev2]);
		l[95].setIcon(pl2);
		prev2=95;
		JOptionPane.showMessageDialog(p, "Player 2 win the Game");
		 
		System.out.println("Player 2 Win the game");
	}
	
	}
	
}

public void status(){
	ll28=new JLabel();
	if(v1>50||v2>50){
		if(v1>50){
		ll26.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:100px; padding:5px; text-align:center;'>Player 1 Win</p><html>");
		ll27.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:100px; padding:5px; text-align:center;'>Player 2 Lose</p><html>");
		}
		else{
		ll26.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:100px; padding:5px; text-align:center;'>Player 2 Win</p><html>");
		ll27.setText("<html><p style='Background-color:red; color:#ffff; font-family: Agency FB; font-size:20px; width:100px; padding:5px; text-align:center;'>Player 1 Lose</p><html>");
		}
	
		 
	}
	else{
		 
	ll26.setText("Player1 at :- "+v1);

	ll27.setText("Player2 at :- "+v2);
	 
		
	}
}

public void actionPerformed(ActionEvent e){
	if(e.getSource()==b21){
		if(select==2){
			JOptionPane.showMessageDialog(p, "You can't change Game Mode. Please Restart the game and then Change the Game Mode");
		}
		else{
		ll25.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Vs Player Selected</p><html>");
		System.out.println("vs player is select");
		select=1;
		}
	}
	if(e.getSource()==b22){
		if(select==1)
		{
			JOptionPane.showMessageDialog(p, "You can't change Game Mode. Please Restart the game and then Change the Game Mode");
		}
		else{
		ll25.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Vs Computer Selected</p><html>");
		System.out.println("vs Computer is select");
		select=2;
		}
	}
	if(e.getSource()==b23){
		System.out.println("Roll Dice");
		if(select==0)
		{
			JOptionPane.showMessageDialog(p, "Please Select Game Mode");
		}
		else if(select==1){
		rand();
		rolldice();
		count();
		change();
		status();
		}
		else{
			rand();
		rolldice();
		count();
		change();
		status();
		
		//after ladder
		Timer timer = new Timer(2000, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
				
              rand();
		rolldice();
		count();
		change();
		status();
		if(rand==6){
			rand();
		rolldice();
		count();
		change();
		status();
		}
		
            }
        });
        
        timer.start();
		timer.setRepeats(false);
		
		}
		
	}
	if(e.getSource()==b24)
	{
		turn=0;
		ll22.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px;  padding:5px; text-align:left;'>Player 1:-</p><html>");
		v1=0;
		v2=0;
		select=0;
		
		ll25.setText("<html><p style='color:red;  font-family: Agency FB; font-size:20px; width:200px; padding:5px; text-align:center;'>Please Select</p><html>");
		
		img =new ImageIcon("0.gif");
		dice.setIcon(img);
		
		l[prev1].setIcon(ic[prev1]);
		l[prev2].setIcon(ic[prev2]);
		
		//starting position of player
	pl1=new ImageIcon(((new ImageIcon("p1.jpg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	pl2=new ImageIcon(((new ImageIcon("p2.jpg")).getImage()).getScaledInstance(35, 20, java.awt.Image.SCALE_SMOOTH));
	
	l[674].setIcon(pl1);
		prev1=674;
		System.out.println("Player 1 position 0");
		
	l[676].setIcon(pl2);
		prev2=676;
		System.out.println("Player 2 position 0");
		
	ll26.setText("Player1 at :- "+v1);

	ll27.setText("Player2 at :- "+v2);
		
	JOptionPane.showMessageDialog(p2, "Game Restarted");
	
	}
}

public static void main(String s[])
{
	new Snake();
}
}