import java.awt.*;
import java.awt.event.*;
import java.math.*;
import java.lang.*;
import java.util.*;
class Main{
	public static void main(String[]argv){
		new MyFrame("Calculator");
	}
}
class MyFrame extends Frame implements WindowListener{ 
	Display dis;
	NomberButton nb;
	SignButton sb;
	ClearButton cb;
	EqualsButton eq;
	 public MyFrame(String title){ 
      super(title); 
       setLocation(200,100); 
       setSize(400,524); 
       setResizable(false); 
       setBackground(Color.white); 
       add(dis=new Display("0",this));
      add(nb=new NomberButton("1",this,dis,0,124));
       add(nb=new NomberButton("2",this,dis,100,124));
       add(nb=new NomberButton("3",this,dis,200,124));
       add(nb=new NomberButton("4",this,dis,0,224));
       add(nb=new NomberButton("5",this,dis,100,224));
       add(nb=new NomberButton("6",this,dis,200,224));
       add(nb=new NomberButton("7",this,dis,0,324));
       add(nb=new NomberButton("8",this,dis,100,324));
       add(nb=new NomberButton("9",this,dis,200,324));
       add(nb=new NomberButton("0",this,dis,0,424));
       add(sb=new SignButton("+",this,dis,300,124));
       add(sb=new SignButton("-",this,dis,300,224));
       add(sb=new SignButton("*",this,dis,300,324));
       add(sb=new SignButton("/",this,dis,300,424));
       add(cb=new ClearButton("Clear",this,dis,200,424));
       add(eq=new EqualsButton("=",this,dis,100,424));
       addWindowListener(this);
        setLayout(null);
	   setVisible(true);
    }
    public void windowClosed(WindowEvent we){}
    public void  windowClosing(WindowEvent we){System.exit(0);}
    public void  windowOpened(WindowEvent we){}
    public void  windowActivated(WindowEvent we){}
    public void  windowDeactivated(WindowEvent we){}
    public void  windowIconified(WindowEvent we){}
    public void  windowDeiconified(WindowEvent we){}

}



class Display extends TextField {
	MyFrame win;
	String x="";
	String y;//x,y-числа,s- знак;
	String title;
	String s="=";
	String z="";
	public Display(String title,MyFrame win){
		super(title);
		this.title=title;
		this.win=win;
		
		setSize(400,100);
		setLocation(5,27);
		setBackground(Color.white);
	}
	public void change(String q){
	
     String a;
  
     
    int  i = Integer.valueOf(q);
    q = Integer.toString(i);
    
    if(title.equals("0")){
    setText(q); 
    this.title=q;
    
  
}
else{
	if (x.equals(title)){this.title="";}
		a=title+q;
	setText(a);
	 this.title=a;
	//x=a;
	}
 //x=title;
 //System.out.println(x);
}
public void clear(String s){
	//y=x;
	x="0";
	y="0";
	s="=";
	this.title="0";
	setText("0");  
	System.out.println(x+" " +s+" "+y);
}

public void signum(String q){
	
		
	if (s.equals("=")){
	 x=title;
	y=x;

	 this.title="0";
	setText(x);
	 
 }
 else {

   x=title;
	int  x1= Integer.valueOf(x);
	int  y1= Integer.valueOf(y);
	int sum=x1+y1;
	int mul=x1*y1;
	int min=y1-x1;
	int del=0;
	if (x1!=0){
	 del=y1/x1;}
	switch(s){
		case"+":x=Integer.toString(sum);y=x;
		break;
		case"*":x=Integer.toString(mul);y=x; 
		break;
		case"-":x=Integer.toString(min);y=x;
		break;
		case"/":x=Integer.toString(del);y=x;
		break;
	} 
	this.title="0";
		setText(x);
		z=x;
	}
	//System.out.println(x+" " +s+" "+y);
	s=q;
}
public void equals(String q){
	signum(q);
	x=z;
	y=x;
	this.title=x;
	s="=";
	//System.out.println(x+" " +s+" "+y);
}
}
class NomberButton extends Button implements ActionListener{
	MyFrame win;
	int x,y;
	Display dis;
	String q;
	public NomberButton(String title,MyFrame win,Display dis,int x,int y){
		super(title);
		this.x=x;
		this.y=y;
		this.win=win;
		this.q=title;
		setSize(100,100);
		setLocation(x,y);
		
		setBackground(new Color(0,255,246));
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
   win.dis.change(q);
	}
}
class SignButton extends Button  implements ActionListener{
	MyFrame win;
	int x,y;
	Display dis;
	String q;
	//String s="=";//старый знак
	String k="=";
	int m;
	public SignButton(String title,MyFrame win,Display dis,int x,int y){
	super(title);
		this.x=x;
		this.y=y;
		this.win=win;
		this.q=title;//введенный знак
		setSize(100,100);
		setLocation(x,y);
		setBackground(new Color(0,255,246));
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
	win.dis.signum(q);
	
		k=q;	

	}
	
}
class ClearButton extends Button  implements ActionListener{
	MyFrame win;
	int x,y;
	Display dis;
	String s;
	public ClearButton(String title,MyFrame win,Display dis,int x,int y){
		super(title);
		this.x=x;
		this.y=y;
		this.win=win;
		setSize(100,100);
		setLocation(x,y);
		
		setBackground(new Color(0,255,246));
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
	win.dis.clear(s);
	}
}
class EqualsButton extends Button  implements ActionListener{
	MyFrame win;
	int x,y;
	Display dis;
	String q;
	String k="";
	int m;
	public EqualsButton(String title,MyFrame win,Display dis,int x,int y){
       super(title);
		this.x=x;
		this.y=y;
		this.win=win;
		
		setSize(100,100);
		setLocation(x,y);
		
		setBackground(new Color(0,255,246));
		addActionListener(this);
	}
	public void actionPerformed(ActionEvent ae){
	
		
		
		win.dis.equals(q);
		
	}
}
