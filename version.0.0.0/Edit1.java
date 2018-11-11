import java.awt.*; 
import java.awt.event.*;  
import javax.swing.*; 
import javax.swing.text.*;
import java.awt.BorderLayout; 
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import java.io.*;
import java.lang.*;
import java.awt.event.*;
import java.util.Hashtable;
import java.net.URL; 
import javax.sound.sampled.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.awt.Dimension;
import java.text.*;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;
import java.beans.*;
import javax.swing.text.*;
import java.util.HashMap;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

class Edit1 extends JPanel implements ActionListener{
	
	JFrame f;

	JTextArea textComp;
	JTextArea[] ta=new JTextArea[100];
	JTextArea[] taLine=new JTextArea[100];
	String text[]=new String[100];
	JTextArea[] jta=new JTextArea[10];
	JPanel[] panelLine=new JPanel[10];
	JTextField jt1,jt2,jt3,tf,tf4,tf5;
	JPanel p1,p11,p12,p13,p2,p4,p5,p6,p7;
	JLabel l1,l11,l12,l13,l14,l15,l16,l17,l2,l3,l31,l32,l33,l34,l35,l4,l51,l52,l61,l62,l71,l72,l73;
	JButton b1,b21,b22,b23,b24,b25,b26,b27,b28,b29,b210,b211,b212,b213,b214,b215,b216,b217,b218,b219,b220,b221,b222,b223,b51,b52,b61,b62,b63,b64,b71,b72;
	JMenuBar menubar;
	JMenu menu1,menu2,menu3,menu4,menu5,menu6,menu7,menuRun, subm21,subm41,menuEncode;
	JMenuItem mi11,mi12,mi13,mi14,mi15,mi16,mi17,mi18,mi19,mi21,mi22,mi23,mi24,mi25,mi26,mi27,mi28,mi29,mi31,mi32,mi33,mi34,mi35,mi41,mi42,mi43,mi44,mi45,mi46,mi47,mi48,mi49,mi410,mi411,mi412,mir1,mir2,mir3,mi51,mi52,mi61,mi62,mi63,mi64,mie1,mie2,mie3,mi71,mi72;
	
	KeyStroke  k1,k2,k3,k4,k5,k6,k7,k8;
	JTabbedPane tab1= new JTabbedPane();
	JPopupMenu popup;
	JScrollPane[] sp=new JScrollPane[100];
	String data,newdata,select="";
	char[] selectch;
	int tabCount=0, selectedTab=0,index=0;
	String path[]=new String[100];
	String fileName[]=new String[100];
	String name[];
	//JPanel[] p3=new JPanel[100];
	JPanel p3=new JPanel();
	
	JLabel[] bl1=new JLabel[100];
	JLabel[] bl2=new JLabel[100];
	JLabel[] bl3=new JLabel[100];
	JLabel[] bl4=new JLabel[100];
	String lineShow[]= new String[100];
	JPanel shortcutPanel;
	int gotoValue;
	int size=16;
	int len[]=new int[100];
	int lines[]=new int[100];
	int ln[] =new int[100];
	int col[]=new int[100];
	//JPanel[] bottomPanel=new JPanel[100];
	JPanel bottomPanel;
	
	int findindex=0,findindexpre=0,findindexprev=0;
	int prevtabselect,tabselect=0;
	int i=1;
	String find="";
	String fname="";
	String fname1="";
	String result="";
	String result1="";
	Runtime r;
	BufferedReader br = null;
	InputStream is = null; 
    InputStreamReader isr = null;
	PrintWriter pw=null;
	FileWriter fw=null;
	JDialog dialog,dialog1,dialog2;
	protected UndoManager undoManager = new UndoManager();
	
	//popup
	 JPopupMenu menu;
     JMenuItem item1,item2,item3,item4,item5,item6,item7;
	//---
	

	Icon ic1= new ImageIcon("images/new.gif");
	Icon ic2= new ImageIcon("images/open.gif");
	Icon ic3= new ImageIcon("images/save.gif");
	Icon ic4= new ImageIcon("images/saveas.gif");
	Icon ic5= new ImageIcon("images/cut.gif");
	Icon ic6= new ImageIcon("images/copy.gif");
	Icon ic7= new ImageIcon("images/paste.gif");
	Icon ic8= new ImageIcon("images/undo.gif");
	Icon ic9= new ImageIcon("images/redo.gif");
	Icon ic10= new ImageIcon("images/find.gif");
	Icon ic11= new ImageIcon("images/replace.gif");
	Icon ic12= new ImageIcon("images/zoomin.gif");
	Icon ic13= new ImageIcon("images/zoomout.gif");
	Icon ic14= new ImageIcon("images/compile.gif");
	Icon ic15= new ImageIcon("images/run.gif");
	Icon ic16= new ImageIcon("images/compilerun.gif");
	Icon ic17= new ImageIcon("images/startr.gif");
	Icon ic18= new ImageIcon("images/pauser.gif");
	Icon ic19= new ImageIcon("images/stopr.gif");
	Icon ic20= new ImageIcon("images/saver.gif");
	Icon ic21= new ImageIcon("images/close.gif");
	Icon ic22= new ImageIcon("images/closeall.gif");
	Icon ic23= new ImageIcon("images/no.gif");
	
	
public Edit1(){
	
	f=new JFrame("Edit K");
	//f.setBackground(new Color (255,255,255));
	for(int i=0;i<100;i++)
	{
		//filename[i]="Untiteled";
		text[i]="";
		len[i]=0;
		lines[i]=1;
		ln[i]=1;
		col[i]=1;
		lineShow[i]="1";
		
	}
	
	
	//upper menu**********
	menubar= new JMenuBar();
	
	//menu 1 and items...
	menu1= new JMenu("File");
	menu1.setMnemonic(KeyEvent.VK_F);
	menubar.add(menu1);

	mi11=new JMenuItem("New");
	mi11.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK);
	mi11.setAccelerator(k1);
	menu1.add(mi11);
	
	mi12=new JMenuItem("Open");
	mi12.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK);
	mi12.setAccelerator(k1);
	menu1.add(mi12);
	
	mi13=new JMenuItem("Save");
	mi13.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
	mi13.setAccelerator(k1);
	menu1.add(mi13);
	
	mi14=new JMenuItem("Save As...   ");
	mi14.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK+ActionEvent.SHIFT_MASK);
	mi14.setAccelerator(k1);
	menu1.add(mi14);
	
	mi15=new JMenuItem("Rename...");
	mi15.addActionListener(this);
	menu1.add(mi15);
	
	mi16=new JMenuItem("Close");
	mi16.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
	mi16.setAccelerator(k1);
	menu1.add(mi16);
	
	mi19=new JMenuItem("Close All");
	mi19.addActionListener(this);
	menu1.add(mi19);
	
	menu1.addSeparator();
	
	mi17=new JMenuItem("Print");
	mi17.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
	mi17.setAccelerator(k1);
	menu1.add(mi17);
	
	menu1.addSeparator();
	
	mi18=new JMenuItem("Exit");
	mi18.addActionListener(this);
	k1=KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK);
	mi18.setAccelerator(k1);
	menu1.add(mi18);
	
	//menu 2 and items...*
	
	menu2= new JMenu("Edit");
	menu2.setMnemonic(KeyEvent.VK_E);
	menubar.add(menu2);
	
	mi21=new JMenuItem("Undo");
	mi21.addActionListener(this);
	mi21.setEnabled(false);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK);
	mi21.setAccelerator(k2);
	menu2.add(mi21);
	
	mi22=new JMenuItem("Redo");
	mi22.addActionListener(this);
	mi22.setEnabled(false);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK);
	mi22.setAccelerator(k2);
	menu2.add(mi22);
	
	menu2.addSeparator();
	/*
	mi23=new JMenuItem("Cut");
	mi23.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
	mi23.setAccelerator(k2);
	menu2.add(mi23);
	
	mi24=new JMenuItem("Copy");
	mi24.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
	mi24.setAccelerator(k2);
	menu2.add(mi24);
	
	mi25=new JMenuItem("Paste");
	mi25.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK);
	mi25.setAccelerator(k2);
	menu2.add(mi25);
	*/
	
	mi23= new JMenuItem(new DefaultEditorKit.CutAction());
	mi23.setText("Cut");
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
	mi23.setAccelerator(k2);
	menu2.add(mi23);
	
	mi24= new JMenuItem(new DefaultEditorKit.CopyAction());
	mi24.setText("Copy");
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
	mi24.setAccelerator(k2);
	menu2.add(mi24);
	
	mi25= new JMenuItem(new DefaultEditorKit.PasteAction());
	mi25.setText("Paste");
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK);
	mi25.setAccelerator(k2);
	menu2.add(mi25);
	
	
	mi26=new JMenuItem("Delete");
	mi26.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
	mi26.setAccelerator(k2);
	menu2.add(mi26);
	
	mi27=new JMenuItem("Select All");
	mi27.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK);
	mi27.setAccelerator(k2);
	menu2.add(mi27);
	
	menu2.addSeparator();
	
	subm21=new JMenu("Convert Case To");
	
	mi28=new JMenuItem("UPPER CASE");
	mi28.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK);
	mi28.setAccelerator(k2);
	subm21.add(mi28);
	mi29=new JMenuItem("lower case");
	mi29.addActionListener(this);
	k2=KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK);
	mi29.setAccelerator(k2);
	subm21.add(mi29);
	
	menu2.add(subm21);
	
	
	//Menu 3 and Items
	
	menu3= new JMenu("Search");
	menu3.setMnemonic(KeyEvent.VK_S);
	menubar.add(menu3);
	
	mi31=new JMenuItem("Find");
	mi31.addActionListener(this);
	k3=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
	mi31.setAccelerator(k3);
	menu3.add(mi31);
	
	mi32=new JMenuItem("Find Next");
	mi32.addActionListener(this);
	k3=KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
	mi32.setAccelerator(k3);
	menu3.add(mi32);
	
	mi33=new JMenuItem("Find Previous");
	mi33.addActionListener(this);
	k3=KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.SHIFT_MASK);
	mi33.setAccelerator(k3);
	menu3.add(mi33);
	
	mi34=new JMenuItem("Replace");
	mi34.addActionListener(this);
	k3=KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK);
	mi34.setAccelerator(k3);
	menu3.add(mi34);
	
	mi35=new JMenuItem("Goto");
	mi35.addActionListener(this);
	k3=KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK);
	mi35.setAccelerator(k3);
	menu3.add(mi35);
	
	//Menu 4 and Items
	
	menu4= new JMenu("View");
	menu4.setMnemonic(KeyEvent.VK_V);
	menubar.add(menu4);
	
	mi41=new JMenuItem("Full Screen Mode");
	mi41.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0);
	mi41.setAccelerator(k4);
	menu4.add(mi41);
	
	mi42=new JMenuItem("Zoom In");
	mi42.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK);
	mi42.setAccelerator(k4);
	menu4.add(mi42);
	
	mi43=new JMenuItem("Zoom Out");
	mi43.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK);
	mi43.setAccelerator(k4);
	menu4.add(mi43);
	
	mi412=new JMenuItem("Restore Default Zoom");
	mi412.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK);
	mi412.setAccelerator(k4);
	menu4.add(mi412);
	
	subm41=new JMenu("Tab");
	
	mi44=new JMenuItem("1st Tab");
	mi44.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, ActionEvent.CTRL_MASK);
	mi44.setAccelerator(k4);
	subm41.add(mi44);
	mi45=new JMenuItem("2nd Tab");
	mi45.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, ActionEvent.CTRL_MASK);
	mi45.setAccelerator(k4);
	subm41.add(mi45);
	mi46=new JMenuItem("3rd Tab");
	mi46.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, ActionEvent.CTRL_MASK);
	mi46.setAccelerator(k4);
	subm41.add(mi46);
	mi410=new JMenuItem("4th Tab");
	mi410.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, ActionEvent.CTRL_MASK);
	mi410.setAccelerator(k4);
	subm41.add(mi410);
	mi411=new JMenuItem("5th Tab");
	mi411.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	mi411.setAccelerator(k4);
	subm41.add(mi411);
	
	subm41.addSeparator();
	mi47=new JMenuItem("Next Tab");
	mi47.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP,ActionEvent.CTRL_MASK);
	mi47.setAccelerator(k4);
	subm41.add(mi47);
	mi48=new JMenuItem("Previous Tab");
	mi48.addActionListener(this);
	k4=KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN,ActionEvent.CTRL_MASK);
	mi48.setAccelerator(k4);
	subm41.add(mi48);
	
	menu4.add(subm41);
	
	mi49=new JMenuItem("Summery...");
	mi49.addActionListener(this);
	menu4.add(mi49);
	
	
	//Menu Run and Items
	
	menuRun= new JMenu("Run");
	menuRun.setMnemonic(KeyEvent.VK_R);
	menubar.add(menuRun);
	
	mir1=new JMenuItem("Complie");
	mir1.addActionListener(this);
	//k4=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
	//mi41.setAccelerator(k4);
	menuRun.add(mir1);
	
	mir2=new JMenuItem("Run");
	mir2.addActionListener(this);
	//k4=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
	//mi41.setAccelerator(k4);
	menuRun.add(mir2);
	
	mir3=new JMenuItem("Complie and Run");
	mir3.addActionListener(this);
	//k4=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
	//mi41.setAccelerator(k4);
	menuRun.add(mir3);
	
	
	//Menu 5 and Items...
	menu5= new JMenu("Seting");
	menu5.setMnemonic(KeyEvent.VK_T);
	menubar.add(menu5);
	
	mi51=new JMenuItem("Style Configurator...");
	mi51.addActionListener(this);
	menu5.add(mi51);
	
	//menu 6 and items...
	menu6= new JMenu("Recording");
	menu6.setMnemonic(KeyEvent.VK_D);
	menubar.add(menu6);
	
	mi61=new JMenuItem("Start Recording");
	mi61.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menu6.add(mi61);
	
	mi62=new JMenuItem("Pause Recording");
	mi62.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menu6.add(mi62);
	
	mi63=new JMenuItem("Stop Recording");
	mi63.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menu6.add(mi63);
	
	mi64=new JMenuItem("Save Recording");
	mi64.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menu6.add(mi64);
	
	
	//Encodeing menu and items...
	menuEncode= new JMenu("Encoding");
	menuEncode.setMnemonic(KeyEvent.VK_E);
	menubar.add(menuEncode);
	
	mie1=new JMenuItem("Encode k1");
	mie1.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menuEncode.add(mie1);
	
	mie2=new JMenuItem("Encode k1");
	mie2.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menuEncode.add(mie2);
	
	mie3=new JMenuItem("Encode k1");
	mie3.addActionListener(this);
	//k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
	//mi61.setAccelerator(k6);
	menuEncode.add(mie3);
	
	
	//----------
	menu7= new JMenu("Help");
	menu7.setMnemonic(KeyEvent.VK_H);
	menubar.add(menu7);
	
	mi71=new JMenuItem("Shortcuts");
	mi71.addActionListener(this);
	menu7.add(mi71);
	
	mi72=new JMenuItem("About us");
	mi72.addActionListener(this);
	menu7.add(mi72);
	
	//disable menu items whene editor starting
	
	mi13.setEnabled(false);
	mi14.setEnabled(false);
	mi15.setEnabled(false);
	mi16.setEnabled(false);
	mi17.setEnabled(false);
	mi19.setEnabled(false);
	
	mi23.setEnabled(false);
	mi24.setEnabled(false);
	mi25.setEnabled(false);
	mi26.setEnabled(false);
	mi27.setEnabled(false);
	subm21.setEnabled(false);
	
	mi31.setEnabled(false);
	mi32.setEnabled(false);
	mi33.setEnabled(false);
	mi34.setEnabled(false);
	mi35.setEnabled(false);
	
	mi42.setEnabled(false);
	mi43.setEnabled(false);
	subm41.setEnabled(false);
	mi49.setEnabled(false);
	mi412.setEnabled(false);
	
	mir1.setEnabled(false);
	mir2.setEnabled(false);
	mir3.setEnabled(false);
	
	mi51.setEnabled(false);
	
	mi61.setEnabled(false);
	mi62.setEnabled(false);
	mi63.setEnabled(false);
	mi64.setEnabled(false);
	
	mie1.setEnabled(false);
	mie2.setEnabled(false);
	mie3.setEnabled(false);
	
	//----
	
	f.setJMenuBar(menubar);
	
	//******menu bellow images
	
	JToolBar bar = new JToolBar();
	
	b21=new JButton();
	b22=new JButton();
	b23=new JButton();
	b24=new JButton();
	b25=new JButton(new DefaultEditorKit.CutAction());
	b26=new JButton(new DefaultEditorKit.CopyAction());
	b27=new JButton(new DefaultEditorKit.PasteAction());
	b28=new JButton();
	b29=new JButton();
	b210=new JButton();
	b211=new JButton();
	b212=new JButton();
	b213=new JButton();
	b214=new JButton();
	b215=new JButton();
	b216=new JButton();
	b217=new JButton();
	b218=new JButton();
	b219=new JButton();
	b220=new JButton();
	b221=new JButton();
	b222=new JButton();
	
	
	b21.setIcon(ic1);
	b21.addActionListener(this);
	b22.setIcon(ic2);
	b22.addActionListener(this);
	b23.setIcon(ic3);
	b23.addActionListener(this);
	b24.setIcon(ic4);
	b24.addActionListener(this);
	b25.setIcon(ic5);
	b25.setText("");
	//b25.addActionListener(this);
	b26.setIcon(ic6);
	//b26.addActionListener(this);
	b26.setText("");
	b27.setIcon(ic7);
	//b27.addActionListener(this);
	b27.setText("");
	b28.setIcon(ic8);
	b28.addActionListener(this);
	b29.setIcon(ic9);
	b29.addActionListener(this);
	b210.setIcon(ic10);
	b210.addActionListener(this);
	b211.setIcon(ic11);
	b211.addActionListener(this);
	b212.setIcon(ic12);
	b212.addActionListener(this);
	b213.setIcon(ic13);
	b213.addActionListener(this);
	b214.setIcon(ic14);
	b214.addActionListener(this);
	b215.setIcon(ic15);
	b215.addActionListener(this);
	b216.setIcon(ic16);
	b216.addActionListener(this);
	b217.setIcon(ic17);
	b217.addActionListener(this);
	b218.setIcon(ic18);
	b218.addActionListener(this);
	b219.setIcon(ic19);
	b219.addActionListener(this);
	b220.setIcon(ic20);
	b220.addActionListener(this);
	b221.setIcon(ic21);
	b221.addActionListener(this);
	b222.setIcon(ic22);
	b222.addActionListener(this);
	
	
	b23.setEnabled(false);
	b24.setEnabled(false);
	b221.setEnabled(false);
	b222.setEnabled(false);
	
	b25.setEnabled(false);
    b26.setEnabled(false);
    b27.setEnabled(false);
	
	b28.setEnabled(false);
    b29.setEnabled(false);
	
	b210.setEnabled(false);
    b211.setEnabled(false);
	
	b212.setEnabled(false);
    b213.setEnabled(false);
	
	b214.setEnabled(false);
    b215.setEnabled(false);
    b216.setEnabled(false);
	
	b217.setEnabled(false);
    b218.setEnabled(false);
    b219.setEnabled(false);
    b220.setEnabled(false);

	
	bar.add(b21);
	bar.add(b22);
	bar.add(b23);
	bar.add(b24);
	bar.add(b221);
	bar.add(b222);
	bar.addSeparator();
	bar.add(b25);
	bar.add(b26);
	bar.add(b27);
	bar.addSeparator();
	bar.add(b28);
	bar.add(b29);
	bar.addSeparator();
	bar.add(b210);
	bar.add(b211);
	bar.addSeparator();
	bar.add(b212);
	bar.add(b213);
	bar.addSeparator();
	bar.add(b214);
	bar.add(b215);
	bar.add(b216);
	bar.addSeparator();
	bar.add(b217);
	bar.add(b218);
	bar.add(b219);
	bar.add(b220);
	
	bar.setMargin(new Insets(0,0,0,0));
	bar.setRollover(false);
	bar.setFloatable(false);
	
	
	f.add(bar, BorderLayout.NORTH);
	
	/*
				//add popup menu...
	
		popup = new JPopupMenu(); 
		JMenuItem item1,item2,item3,item4;
		item1=new JMenuItem("Cut");
		popup.add(item1);
		item1.addActionListener(this);
		
		item2=new JMenuItem("Copy");
		popup.add(item2);
		item2.addActionListener(this);
		
		item3=new JMenuItem("Paste");
		popup.add(item3);
		item3.addActionListener(this);
		
		JPanel popupPanel=new JPanel();
		popupPanel.setComponentPopupMenu(popup);
	  
		f.add(popupPanel);
	*/

    // An inner class to check whether mouse events are the popup trigger
    
	
	//----------------******
	

	
	//bottom panel....
	
	
	
	
	tab1.addChangeListener(new ChangeListener() {

                    public void stateChanged(ChangeEvent e) {
                        if (e.getSource() instanceof JTabbedPane) {
                            JTabbedPane pane = (JTabbedPane) e.getSource();
							int select=pane.getSelectedIndex();
							
							System.out.println("Selected paneNo : " + pane.getSelectedIndex());
							
							// Caret Listener 
if(select>=0){							
							jta[select+1].addCaretListener(new CaretListener() {
             public void caretUpdate(CaretEvent e) {
					JTextArea editArea = (JTextArea)e.getSource();
					try {
					
					int caretpos = editArea.getCaretPosition();
                    ln[select+1] = editArea.getLineOfOffset(caretpos);
                   
				    col[select+1] = caretpos - editArea.getLineStartOffset(ln[select+1]);
					
					int coll=col[select+1]+1;
					int lnn= ln[select+1]+1;
					
					 
					
					                bl1[select+1].setText("Lenght: "+len[select+1]);
	 
									bl2[select+1].setText("Lines: "+lines[select+1]);
	 
									bl3[select+1].setText("Cursor Line No: "+lnn);
	 
									bl4[select+1].setText("Cursor Column No: "+coll);
	//p3=new JPanel();
	
	

								ln[select+1]++;
								
								
								//enable options
								String chkSelect = jta[select+1].getSelectedText();
							if(chkSelect!=null){
								b25.setEnabled(true);
								b26.setEnabled(true);
								mi23.setEnabled(true);
								mi24.setEnabled(true);
								mi26.setEnabled(true);
								
								//popup
								item1.setEnabled(true);
								item2.setEnabled(true);
								item4.setEnabled(true);
								item6.setEnabled(true);
								item7.setEnabled(true);
							}
							else{
								b25.setEnabled(false);
								b26.setEnabled(false);
								mi23.setEnabled(false);
								mi24.setEnabled(false);
								mi26.setEnabled(false);
								
								//popup
								item1.setEnabled(false);
								item2.setEnabled(false);
								item4.setEnabled(false);
								item6.setEnabled(false);
								item7.setEnabled(false);
							}
								//-----
								
								}
								
								
								catch(Exception ex) { }
	
								}
							});
							//---
							// Left side line show count
	 DocumentListener documentListener = new DocumentListener() {
								
   public void insertUpdate(DocumentEvent e) {
	   
        updateLog(e, "inserted into");
    }
  public void removeUpdate(DocumentEvent e) {
 
        updateLog(e, "removed from");
		
    }
   public void changedUpdate(DocumentEvent e) {
        //Plain text components do not fire these events
		
    }

   public void updateLog(DocumentEvent e, String action) {
	   
        Document doc = (Document)e.getDocument();
        int changeLength = e.getLength();
        
	String s=jta[select+1].getText();
		
		lineShow[select+1]="";
		i=1;
		for(int a=0;a<s.length();a++){
			if(s.charAt(a)=='\n'){	
				
				i=i+1;
			}
		}
		
		lines[select+1]=i;
		len[select+1]=s.length();
		
		
		
		for(int k=1;k<=i;k++){
			lineShow[select+1]=lineShow[select+1]+k+"\n";
				 
				taLine[select+1].setText(lineShow[select+1]);
		}
	//f.add(taLine[select+1],BorderLayout.WEST);
	
    }	
	
 };

//undo action--------
jta[select+1].getDocument().addUndoableEditListener(
        new UndoableEditListener() {
          public void undoableEditHappened(UndoableEditEvent e) {
            undoManager.addEdit(e.getEdit());
            updateButtons();
          }
        });
//--------- 

jta[select+1].addMouseListener(new MouseAdapter() {
   public void mouseReleased(final MouseEvent e) {
    if (e.isPopupTrigger()) {
 
	 
     menu.show(e.getComponent(), e.getX(), e.getY());
    }
   }
  });
	
							
							//set ebanble option whene tab is selectedTab
						
							//--------
							p3=new JPanel();
							JLabel ext=new JLabel("Java Source File");
							JLabel ext1= new JLabel();
							JLabel ext2= new JLabel();
							p3.add(ext);
							p3.add(ext1);
							p3.add(ext2);
							 
							p3.add(bl1[select+1]);
							p3.add(bl2[select+1]);
							p3.add(bl3[select+1]);
							p3.add(bl4[select+1]);
							p3.setPreferredSize(new Dimension(10, 15));
	
							p3.setLayout(new GridLayout(1,7));
							//p3.setLayout(new FlowLayout(FlowLayout.RIGHT));  
							//f.add(p3,BorderLayout.SOUTH);
							//------------

                            
							//ta[a]=new JTextArea(5,100);
							jta[select+1].getDocument().addDocumentListener(documentListener);
							
							TitledBorder titled = new TitledBorder("Output");
							sp[select+1].setBorder(titled);
							
							bottomPanel=new JPanel(new BorderLayout());
							
							bottomPanel.add(sp[select+1],BorderLayout.CENTER);
							bottomPanel.add(p3,BorderLayout.SOUTH);
							
							f.add(bottomPanel,BorderLayout.SOUTH);
                        }
						}
	else{
	System.out.println("No selected tab");
                    }
					}
                });
	

	
	//file browser
	
	p4=new JPanel();
	l4=new JLabel("<html><p style='font-size[index]:12px;'><br>1<br>2<br>3<br>4<br>5<br>6<br>7</p></html>");
	p4.add(l4);
	//f.add(p4,BorderLayout.WEST);
	
	//f.add(tf);
	//f.setSize(1366,730);
	//f.pack();
	//f.setVisible(true);
	
	f.setExtendedState(6);
	f.setVisible(true);
	
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	r=Runtime.getRuntime();
} 

public void actionPerformed(ActionEvent e)
{
	
	selectedTab=tab1.getSelectedIndex();
 

//action on menu1

if(e.getActionCommand().equals("New")||e.getSource()==b21)
{
	

	JPanel panel= new JPanel();
	JLabel label=new JLabel("Enter File Name: ");
	JTextField tf=new JTextField();
	panel.add(label);
	panel.add(tf);
	panel.setLayout(new GridLayout(1,2));
	
	int result= JOptionPane.showConfirmDialog(null,panel,"Enter File Name",JOptionPane.OK_OPTION);
	if(result == JOptionPane.OK_OPTION){
		if(!tf.getText().equals("")){	
		fname=tf.getText().trim()+".java";
		fname1=tf.getText().trim();
		tabCount++;
	jta[tabCount] = new JTextArea();
		//set enable option...
		
	
	b23.setEnabled(true);
	b24.setEnabled(true);
	b221.setEnabled(true);
	b222.setEnabled(true);
	
	b27.setEnabled(true);
	
	b210.setEnabled(true);
    b211.setEnabled(true);
	
	b212.setEnabled(true);
    b213.setEnabled(true);
	
	b214.setEnabled(true);
    b215.setEnabled(true);
    b216.setEnabled(true);
	
	b217.setEnabled(true);
	
	//menu enable...
	
	mi13.setEnabled(true);
	mi14.setEnabled(true);
	mi15.setEnabled(true);
	mi16.setEnabled(true);
	mi17.setEnabled(true);
	mi19.setEnabled(true);
	
	mi25.setEnabled(true);
	
	mi27.setEnabled(true);
	subm21.setEnabled(true);
	
	mi31.setEnabled(true);
	mi32.setEnabled(true);
	mi33.setEnabled(true);
	mi34.setEnabled(true);
	mi35.setEnabled(true);
	
	mi42.setEnabled(true);
	mi43.setEnabled(true);
	subm41.setEnabled(true);
	mi49.setEnabled(true);
	mi412.setEnabled(true);
	
	mir1.setEnabled(true);
	mir2.setEnabled(true);
	mir3.setEnabled(true);
	
	mi51.setEnabled(true);
	
	mi61.setEnabled(true);
	
	mie1.setEnabled(true);
	mie2.setEnabled(true);
	mie3.setEnabled(true);
		
		//----
		
		createNewFile(fname);
		}
	}
		
	else{
		System.out.println("close");
	}
	
}
//open file action
if(e.getActionCommand().equals("Open")||e.getSource()==b22)
{

//set enable option...
		
	
	b23.setEnabled(true);
	b24.setEnabled(true);
	b221.setEnabled(true);
	b222.setEnabled(true);
	
	b27.setEnabled(true);
	
	b210.setEnabled(true);
    b211.setEnabled(true);
	
	b212.setEnabled(true);
    b213.setEnabled(true);
	
	b214.setEnabled(true);
    b215.setEnabled(true);
    b216.setEnabled(true);
	
	b217.setEnabled(true);
	
	//menu enable...
	
	mi13.setEnabled(true);
	mi14.setEnabled(true);
	mi15.setEnabled(true);
	mi16.setEnabled(true);
	mi17.setEnabled(true);
	mi19.setEnabled(true);
	
	mi25.setEnabled(true);
	
	mi27.setEnabled(true);
	subm21.setEnabled(true);
	
	mi31.setEnabled(true);
	mi32.setEnabled(true);
	mi33.setEnabled(true);
	mi34.setEnabled(true);
	mi35.setEnabled(true);
	
	mi42.setEnabled(true);
	mi43.setEnabled(true);
	subm41.setEnabled(true);
	mi49.setEnabled(true);
	mi412.setEnabled(true);
	
	mir1.setEnabled(true);
	mir2.setEnabled(true);
	mir3.setEnabled(true);
	
	mi51.setEnabled(true);
	
	mi61.setEnabled(true);
	
	mie1.setEnabled(true);
	mie2.setEnabled(true);
	mie3.setEnabled(true);
		
		//----

openFile();

	

}

//save option
if(e.getActionCommand().equals("Save")||e.getSource()==b23)
{
try{
				fw= new FileWriter(fname);
				  
				String s2=jta[selectedTab+1].getText();
				 
				pw = new PrintWriter(fw);
				pw.println(s2);
				pw.flush();
}
catch(Exception ex){
System.out.println(e);	
}

}
//save as option
if(e.getActionCommand().equals("Save As...   ")||e.getSource()==b24)
{
JFileChooser jfc=new JFileChooser();
int x=jfc.showSaveDialog(null);
if(x==JFileChooser.APPROVE_OPTION)
{
File file=jfc.getSelectedFile();
String s=jfc.getName(file);
 

if (file == null)
        return;

      FileWriter writer = null;
      try {
        writer = new FileWriter(file);
        jta[selectedTab+1].write(writer);
      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(f, "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
      }

}
if(x==JFileChooser.CANCEL_OPTION)
{
System.out.println("cancel");
}
}
if(e.getActionCommand().equals("Rename..."))
{
jta[selectedTab+1].setText("Rename...");
}

if(e.getActionCommand().equals("Close")||e.getSource()==b221)
{
tab1.removeTabAt(tab1.getSelectedIndex());
ta[selectedTab+1].setVisible(false);
bl1[selectedTab+1].setVisible(false);
bl2[selectedTab+1].setVisible(false);
bl3[selectedTab+1].setVisible(false);
bl4[selectedTab+1].setVisible(false);
tabCount--;

}

if(e.getActionCommand().equals("Close All")||e.getSource()==b222)
{
tab1.removeAll();
tabCount=0;
}

if(e.getActionCommand().equals("Print"))
{
/*
try{
MessageFormat header= new MessageFormat("Edit k");
MessageFormat footer= new MessageFormat("All Rights Reserved");
jta[selectedTab].print(header,footer,true,null,null,true);
}
catch(PrinterException ex){
	System.out.println(ex);
}
catch(SecurityException ex){
	System.out.println(ex);
}
*/

}
if(e.getActionCommand().equals("Exit"))
{
System.exit(0);
}

//action on  menu2

if(e.getActionCommand().equals("Undo")||e.getSource()==b28)
{

	try {
          undoManager.undo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        updateButtons();

}
if(e.getActionCommand().equals("Redo")||e.getSource()==b29)
{

	try {
          undoManager.redo();
        } catch (CannotRedoException cre) {
          cre.printStackTrace();
        }
        updateButtons();

}


if(e.getActionCommand().equals("Delete")||e.getSource()==item4)
{
String deletedata= jta[selectedTab+1].getSelectedText();
data= jta[selectedTab+1].getText();
int pos= jta[selectedTab+1].getCaretPosition();
if(deletedata!=null){
String s2=data.replace(deletedata,"");
jta[selectedTab+1].setText(s2);
}
}

if(e.getActionCommand().equals("Select All")||e.getSource()==item5)
{
jta[selectedTab+1].selectAll();
}
//UPPERCASE CHANGE
if(e.getActionCommand().equals("UPPER CASE")||e.getSource()==item6)
{

String selectedText=jta[selectedTab+1].getSelectedText();
       if (selectedText==null)return;
       selectedText=selectedText.toUpperCase();
       jta[selectedTab+1].replaceSelection(selectedText);

}

//lowercase change
if(e.getActionCommand().equals("lower case")||e.getSource()==item7)
{

String selectedText=jta[selectedTab+1].getSelectedText();
       if (selectedText==null)return;
       selectedText=selectedText.toLowerCase();
       jta[selectedTab+1].replaceSelection(selectedText);
}

//menu 3
if(e.getActionCommand().equals("Find")||e.getSource()==b210)
{

	dialog = new JDialog(f,"Find");
	p5 = new JPanel();
	jt1= new JTextField(5);
	l51= new JLabel("Find What: ");
	p5.add(l51);
	p5.add(jt1);
	b51= new JButton("Find Next..");
	p5.add(b51);
	b51.addActionListener(this);
	b52= new JButton("Close Find");
	p5.add(b52);
	b52.addActionListener(this);
	p5.setLayout(new GridLayout(2,2));
	
	dialog.add(p5);
	dialog.setResizable(false);
    dialog.setVisible(true);
	dialog.setSize(300,100);
	dialog.setLocationRelativeTo(f);
	findindexpre= jta[selectedTab+1].getCaretPosition();

}

if(e.getSource()==b51){
find= jt1.getText();
data=jta[selectedTab+1].getText();
int findlen= find.length();
findindex= data.indexOf(find,findindexpre);
findindexpre=findindex+findlen;
int p0=findindex;
int p1=findindex+findlen;
if(findindex>=0){
	jta[selectedTab+1].requestFocus();
jta[selectedTab+1].select(p0,p1);

}
else{
	dialog.dispose();
	JOptionPane.showMessageDialog(f, "Can't find the text: "+find, "Search Result", JOptionPane.ERROR_MESSAGE);
}
}

if(e.getSource()==b52)
{
	dialog.dispose();
}

if(e.getActionCommand().equals("Find Next"))
{

data=jta[selectedTab+1].getText();
int findlen= find.length();
findindex= data.indexOf(find,findindexpre);
int p0=findindex;
int p1=findindex+findlen;
if(findindex>=0){
	jta[selectedTab+1].requestFocus();
jta[selectedTab+1].select(p0,p1);
findindexpre=findindex+findlen;
}
else{
	JOptionPane.showMessageDialog(f, "Can't find the text: "+find, "Search Result", JOptionPane.ERROR_MESSAGE);
}

}


if(e.getActionCommand().equals("Find Previous"))
{
	
System.out.println("find data="+find);
//String find= jt1.getText();
data=jta[selectedTab+1].getText();
int findlen= find.length();

findindexpre=jta[selectedTab+1].getCaretPosition();
int p=findindexpre-findlen-1;
findindex= data.lastIndexOf(find,p);
System.out.println("find pre="+findindexpre);
System.out.println("new index="+findindex);
int p0=findindex;
int p1=findindex+findlen;
if(findindex>=0){

	jta[selectedTab+1].requestFocus();
jta[selectedTab+1].select(p0,p1);

}
else{
	JOptionPane.showMessageDialog(f, "Can't find the text: "+find, "Search Result", JOptionPane.ERROR_MESSAGE);
}
}

if(e.getActionCommand().equals("Replace")||e.getSource()==b211)
{
System.out.println("Replace");
	dialog1 = new JDialog(f,"Replace");
	p6 = new JPanel();
	jt2= new JTextField(5);
	jt3 = new JTextField(5);
	l61= new JLabel("Find: ");
	p6.add(l61);
	p6.add(jt2);
	l62=new JLabel("Replace: ");
	p6.add(l62);
	p6.add(jt3);
	b61= new JButton("Find Next...");
	b62= new JButton("Replace...");
	b63= new JButton("Replace All...");
	b64= new JButton("Close Replace");
	p6.add(b61);
	b61.addActionListener(this);
	p6.add(b62);
	b62.addActionListener(this);
	p6.add(b63);
	b63.addActionListener(this);
	p6.add(b64);
	b64.addActionListener(this);
	p6.setLayout(new GridLayout(4,2));
	//int result= JOptionPane.showConfirmDialog(null,p6,"Replace",JOptionPane.CLOSED_OPTION);
	dialog1.add(p6);
	dialog1.setResizable(false);
    dialog1.setVisible(true);
	dialog1.setSize(320,180);
	dialog1.setLocationRelativeTo(f);
	findindexprev= jta[selectedTab+1].getCaretPosition();

}

if(e.getSource()==b61){
find= jt2.getText();
data=jta[selectedTab+1].getText();
int findlen= find.length();
findindex= data.indexOf(find,findindexprev);
findindexprev=findindex+findlen;
int p0=findindex;
int p1=findindex+findlen;
if(findindex>=0){
	jta[selectedTab+1].requestFocus();
jta[selectedTab+1].select(p0,p1);

}
else{
	dialog1.dispose();
	JOptionPane.showMessageDialog(f, "Can't find the text: "+find, "Search Result", JOptionPane.ERROR_MESSAGE);
}
}

if(e.getSource()==b62){
	String findstr="",replacestr="";
	findstr= jt2.getText();
	char[] findstrchar= findstr.toCharArray();
	replacestr= jt3.getText();
	char[] replacestrchar= replacestr.toCharArray();
	data=jta[selectedTab+1].getText();
	char[] datachar= data.toCharArray();
	int findlen=findstr.length();
	int replacelen= replacestr.length();
	
	if(findindex>=0){
		if(findlen<replacelen){
		for(int i=0;i<findlen;i++){
		datachar[findindex+i]=replacestrchar[i];
		
		}
		newdata= new String(datachar);
		StringBuilder s1=new StringBuilder(newdata);
		for(int i=findlen;i<replacelen;i++){
			s1.insert(i,replacestrchar[i]);
			newdata= new String(s1);
		}
		
		jta[selectedTab+1].setText(newdata);
		findindexprev=findindex+replacelen;
		findindex= data.indexOf(findstr,findindexprev);
		jta[selectedTab+1].select(findindex,findindex+findlen);
		
		}
		
		else if(findlen>replacelen){
			System.out.println("find index "+findindex);
		for(int i=0;i<replacelen;i++){
			 
		datachar[findindex+i]=replacestrchar[i];
		
		}
		newdata= new String(datachar);
		StringBuilder s1=new StringBuilder(newdata);
		System.out.println("new data1 "+newdata);
		for(int i=findindex+replacelen;i<findindex+findlen;i++){
			System.out.println("i= "+i);
			s1.deleteCharAt(i);
			newdata= new String(s1);
		}
		findindexprev=findindex+replacelen;
		jta[selectedTab+1].setText(newdata);
		findindex= data.indexOf(findstr,findindexprev);
		jta[selectedTab+1].select(findindex,findindex+findlen);
		
		}
		
		else{
			for(int i=0;i<findlen;i++){
		datachar[findindex+i]=replacestrchar[i];
		newdata= new String(datachar);
			}
		findindexprev=findindex+replacelen;
		jta[selectedTab+1].setText(newdata);
		findindex= data.indexOf(findstr,findindexprev);
		jta[selectedTab+1].select(findindex,findindex+findlen);
		
		}
		
	}
	else{
		JOptionPane.showMessageDialog(f, "Can't find the text: "+find, "Search Result", JOptionPane.ERROR_MESSAGE);
	}
	
	
	/*char[] replacestrchar= replacestr.toCharArray();
	data= jta[selectedTab+1].getText();
	String s2=data.replace(findstr,replacestr);
	jta[selectedTab+1].setText(s2);*/
}

if(e.getSource()==b63){
	String findstr="",replacestr="";
	findstr= jt2.getText();
	replacestr= jt3.getText();
	data= jta[selectedTab+1].getText();
	String s2=data.replace(findstr,replacestr);
	jta[selectedTab+1].setText(s2);
}
if(e.getSource()==b64)
{
	dialog1.dispose();
}

//goto action------

if(e.getActionCommand().equals("Goto"))
{

dialog2 = new JDialog(f,"GO TO");
	p7 = new JPanel();
	tf4=new JTextField();
	
	l71= new JLabel("You are here: ");
	l72= new JLabel(""+ln[selectedTab+1]);
	p7.add(l71);
	p7.add(l72);
	l72=new JLabel("You want to go to: ");
	p7.add(l72);
	p7.add(tf4);
	b71= new JButton("Go");
	b72= new JButton("Close Goto");
	p7.add(b71);
	b71.addActionListener(this);
	p7.add(b72);
	b72.addActionListener(this);
	String s=tf4.getText();
	
	p7.setLayout(new GridLayout(3,2));
	//int result= JOptionPane.showConfirmDialog(null,p6,"Replace",JOptionPane.CLOSED_OPTION);
	dialog2.add(p7);
	dialog2.setResizable(false);
    dialog2.setVisible(true);
	dialog2.setSize(320,150);
	dialog2.setLocationRelativeTo(f);
	
	
	
}

if(e.getSource()==b71){
	
	String s=tf4.getText();
    try {
	gotoValue = Integer.parseInt(s);
	
	try{
	int k=jta[selectedTab+1].getLineStartOffset(gotoValue-1);
	
	System.out.println(k);
	jta[selectedTab+1].setCaretPosition(k);
	dialog2.dispose();
	}
	catch(Exception ex){}
	
	} catch (Exception ex) {
	JOptionPane.showMessageDialog(null, "Please give number");
	}

}
if(e.getSource()==b72){
	dialog2.dispose();
}




//action on  menu 4

if(e.getActionCommand().equals("Full Screen Mode"))
{
f.setExtendedState(6);
f.setVisible(true);
}

if(e.getActionCommand().equals("Zoom In")||e.getSource()==b212)
{
size=size+2;
Font displayFont = new Font("Consolas", Font.PLAIN, size);
	jta[selectedTab+1].setFont(displayFont);
	taLine[selectedTab+1].setFont(displayFont);
}

if(e.getActionCommand().equals("Zoom Out")||e.getSource()==b213)
{
size=size-2;
Font displayFont = new Font("Consolas", Font.PLAIN, size);
	jta[selectedTab+1].setFont(displayFont);
	taLine[selectedTab+1].setFont(displayFont);
}

if(e.getActionCommand().equals("Restore Default Zoom"))
{
size=16;
Font displayFont = new Font("Consolas", Font.PLAIN, size);
	jta[selectedTab+1].setFont(displayFont);
	taLine[selectedTab+1].setFont(displayFont);
}

if(e.getActionCommand().equals("1st Tab"))
{

	if(tab1.getTabCount()>=1){
		
		tab1.setSelectedIndex(0);
	}

}
if(e.getActionCommand().equals("2nd Tab"))
{
	if(tab1.getTabCount()>=2){
		
		tab1.setSelectedIndex(1);
	}
}
if(e.getActionCommand().equals("3rd Tab"))
{
	if(tab1.getTabCount()>=3){
		
		tab1.setSelectedIndex(2);
	}
}
if(e.getActionCommand().equals("4th Tab"))
{
	if(tab1.getTabCount()>=4){
		
		tab1.setSelectedIndex(3);
	}
}
if(e.getActionCommand().equals("5th Tab"))
{
	if(tab1.getTabCount()>=5){
		
		tab1.setSelectedIndex(5);
	}
}
if(e.getActionCommand().equals("Next Tab"))
{

	if(tab1.getSelectedIndex()<tab1.getTabCount()-1){
		
		tab1.setSelectedIndex(tab1.getSelectedIndex()+1);
	}



}
if(e.getActionCommand().equals("Previous Tab"))
{

	if(tab1.getSelectedIndex()>0){
		
		tab1.setSelectedIndex(tab1.getSelectedIndex()-1);
	}

}
if(e.getActionCommand().equals("Summery..."))
{
System.out.println("File Name: "+fileName[selectedTab+1]);	
System.out.println("Path: "+path[selectedTab+1]);
	
String s= jta[selectedTab+1].getText();
byte[] bytes = s.getBytes();
try{

System.out.println("bytes length = "+bytes.length);
}
catch(Exception ex){
	System.out.println(ex);
}
int length= s.length();
System.out.println("Total Char: "+length);

int line=jta[selectedTab+1].getLineCount();
System.out.println("Total Lines: "+line);

String s1= s.trim();
int trimcount= s1.length();
System.out.println("Total count(Without Blanks): "+trimcount);

JPanel jp=new JPanel();
JTextArea ta=new JTextArea(
"File Name: "+fileName[selectedTab+1]+"\n"
+"Path: "+path[selectedTab+1]+"\n"
+"Length(Bytes): "+bytes.length+"\n"
+"\n"
+"Lines: "+line+"\n"
+"Character: "+length+"\n"
+"Character(without blacks): "+trimcount 
);
ta.setEditable(false);

//JLabel l2=new JLabel("File Name: "+fileName[selectedTab+1]+"\n"+"Path: "+path[selectedTab+1] );
jp.add(ta);

JOptionPane.showMessageDialog(f, jp, "Summery", JOptionPane.PLAIN_MESSAGE, null);

}

//menu run

if(e.getSource()==mir1||e.getSource()==b214)
{
System.out.println("Complie");

compilefile();

}

if(e.getSource()==mir2||e.getSource()==b215)
{

runfile();

}

if(e.getSource()==mir3||e.getSource()==b216)
{

compilefile();
String s=ta[selectedTab+1].getText();
if(s.equals("Compile Successfull"))
{
runfile();
}
}


//action on  menu 5

if(e.getActionCommand().equals("Style Configurator..."))
{

}

//help menu action

if(e.getActionCommand().equals("Shortcuts"))
{
shortCut();
}


}




//new file method*******

void createNewFile(String fname){
	    bottomPanel(tabCount);
		fileName[tabCount]=fname;
		int a=fname.indexOf(".");
		String fname1=fname.substring(0, a);
	
		path[tabCount]="F:\\Java Program\\swing\\my\\JavaEditor\\"+fname;
		jta[tabCount].setText("public class "+fname1+"\n"+"{"+"\n"+"    "+"public static void main(String s[])"+"\n"+"    "+"{"+"\n"+"        "+"//Enter Code Here"+"\n"+"    "+"}"+"\n"+"}");
		int tabSize = jta[tabCount].getTabSize();
		tabSize = 4;
		jta[tabCount].setTabSize(tabSize);
		
		Font displayFont = new Font("Consolas", Font.PLAIN, size);
	jta[tabCount].setFont(displayFont);
	
	panelLine[tabCount]=new JPanel(new BorderLayout());
	taLine[tabCount]=new JTextArea(1,5);
	taLine[tabCount].setEditable(false);
	
	//line count in starting
		String s=jta[tabCount].getText();
		
		lineShow[tabCount]="";
		i=1;
		for(int j=0;j<s.length();j++){
			if(s.charAt(j)=='\n'){	
				
				i=i+1;
			}
		}
		
		lines[tabCount]=i;
		len[tabCount]=s.length();
		bl1[tabCount].setText("Lenght: "+len[tabCount]);
		bl2[tabCount].setText("Lines: "+lines[tabCount]);
		
		for(int k=1;k<=i;k++){
			lineShow[tabCount]=lineShow[tabCount]+k+"\n";

				taLine[tabCount].setText(lineShow[tabCount]);
		}
	
	//---
	
	taLine[tabCount].setText(lineShow[tabCount]);
	taLine[tabCount].setFont(displayFont);
	taLine[tabCount].setBackground(Color.decode("#E0E0E0"));
	taLine[tabCount].setForeground(Color.decode("#606060"));
	
	
	panelLine[tabCount].add(taLine[tabCount],BorderLayout.WEST);
	panelLine[tabCount].add(jta[tabCount],BorderLayout.CENTER);
	
	JScrollPane scroll= new JScrollPane(panelLine[tabCount]);
	tab1.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	tab1.addTab(fname,ic3,scroll,path[tabCount]);
	tab1.setSelectedIndex(tab1.getTabCount()-1);
	
		f.add(tab1);
		
		
		 try {
		fw= new FileWriter(fname);
				 
				String s2=jta[tabCount].getText();
				 
				pw = new PrintWriter(fw);
				pw.println(s2);
				pw.flush();
		 }
		 catch (Exception ex) {
        System.out.println(ex);
      }
		
	  f.setExtendedState(6);
f.setVisible(true);

//Popup menu-------

addPopup(tabCount);

//----------------
	
}

void openFile(){

JFileChooser jfc=new JFileChooser();
int x=jfc.showOpenDialog(null);
if(x==JFileChooser.APPROVE_OPTION)
{
	
	tabCount++;
bottomPanel(tabCount);
jta[tabCount]=new JTextArea();
	
File file=jfc.getSelectedFile();
fname=jfc.getName(file);

path[tabCount]=file.getAbsolutePath();
fileName[tabCount]=fname;
 

if (file == null)
        return;

      FileReader reader = null;
      try {
        reader = new FileReader(file);
        jta[tabCount].read(reader, null);
		data=jta[tabCount].getText();
	Font displayFont = new Font("Consolas", Font.PLAIN, size);
	jta[tabCount].setFont(displayFont);
	
	panelLine[tabCount]=new JPanel(new BorderLayout());
	taLine[tabCount]=new JTextArea(1,5);
	taLine[tabCount].setEditable(false);
	
	//line count in starting
		String s=jta[tabCount].getText();
		
		lineShow[tabCount]="";
		i=1;
		for(int j=0;j<s.length();j++){
			if(s.charAt(j)=='\n'){	
				
				i=i+1;
			}
		}
		
		lines[tabCount]=i;
		len[tabCount]=s.length();
		bl1[tabCount].setText("Lenght: "+len[tabCount]);
		bl2[tabCount].setText("Lines: "+lines[tabCount]);
		
		for(int k=1;k<=i;k++){
			lineShow[tabCount]=lineShow[tabCount]+k+"\n";
				 
				taLine[tabCount].setText(lineShow[tabCount]);
		}
	
	//---
	
	taLine[tabCount].setText(lineShow[tabCount]);
	taLine[tabCount].setFont(displayFont);
	taLine[tabCount].setBackground(Color.decode("#E0E0E0"));
	
	
	panelLine[tabCount].add(taLine[tabCount],BorderLayout.WEST);
	panelLine[tabCount].add(jta[tabCount],BorderLayout.CENTER);
	
	JScrollPane scroll= new JScrollPane(panelLine[tabCount]);

	tab1.addTab(fname,ic3,scroll,path[tabCount]);
	
	//----popup menu
	addPopup(tabCount);
	//---

      }
      catch (IOException ex) {
        JOptionPane.showMessageDialog(f, "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);
      }
	  f.add(tab1);
	
	tab1.setSelectedIndex(tab1.getTabCount()-1);

}
if(x==JFileChooser.CANCEL_OPTION)
{
System.out.println("cancel");
}
	
	f.setExtendedState(6);
f.setVisible(true);
}

public void compilefile(){
	
	result="";

	try{
				fname=fileName[selectedTab+1];
				
				fw= new FileWriter(fname);
				  
				String s2=jta[selectedTab+1].getText();
			 
				pw = new PrintWriter(fw);
				pw.println(s2);
				pw.flush();
				
				Process error= r.exec("C:\\Program Files\\Java\\jdk1.8.0_05\\bin\\javac.exe -d . "+fname);
				
				br=new BufferedReader(new InputStreamReader(error.getErrorStream())); 
				System.out.println(error);
				
				while(true){
					String temp=br.readLine();
					if(temp!=null){
						//result+="\n";
						result+=temp;
						result+="\n";
						 
					}
					else{
						break;
					}
				}
					if(result.equals("")){
						ta[selectedTab+1].setText("Compile Successfull");
						br.close();
					}
					else{
						ta[selectedTab+1].setText(result);
					}
				
			}
			catch(Exception ex){
				System.out.println(ex);
			}
	
}

public void runfile(){
	result="";
	result1="";
	try{
		fname=fileName[selectedTab+1];
		int a=fname.indexOf(".");
		String fname1=fname.substring(0, a);
	 
		String fn= fname1;
		 
		Process p = r.exec("C:\\Program Files\\Java\\jdk1.8.0_05\\bin\\java.exe "+fn);
		 
		BufferedReader br1=new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader br2=new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
		while(true){
			String temp=br1.readLine();
			if(temp!=null){
				result+=temp;
				result+="\n";
				 
			}
			else{
				System.out.println("break1");
				break;
				
			}
		}
		
		while(true){
			String temp1=br2.readLine();
			if(temp1!=null){
				result1+=temp1;
				result1+="\n";
			}
			else{
				System.out.println("break2");
				break;
			}
		}
		br1.close();
		br2.close();
		System.out.println("br close");
		
		if(!result.equals("")&&result1.equals("")){
			ta[selectedTab+1].setText(result);
			 
		}
		if(result.equals("")){
			ta[selectedTab+1].setText(result1);
			 
		}
		if(!result.equals("")&&!result1.equals("")){
			ta[selectedTab+1].setText(result+"\n"+result1);
			 
		}
		
		}
		catch(Exception ex){
				System.out.println(ex);
			}
}

void bottomPanel(int a){

	//panelLine[a]=new JPanel(new BorderLayout());
	ta[a]=new JTextArea(5,10);
	ta[a].setEditable(false);
	//taLine[a]=new JTextArea();
	//taLine[a].setEditable(false);
	//panelLine[a].add(taLine[a],BorderLayout.WEST);
	//panelLine[a].add(jta[a],BorderLayout.CENTER);
	sp[a]= new JScrollPane(ta[a]);
	
	//JScrollPane sp= new JScrollPane();
							//ta[a]=new JTextArea(5,100);
	
							
	
	//bottomPanel[a]=new JPanel();
	//p3[a]=new JPanel();
	
	bl1[a]=new JLabel();
	bl1[a].setText("Lenght: "+len[a]);
	bl2[a]=new JLabel();
	bl2[a].setText("Lines: "+lines[a]);
	bl3[a]=new JLabel();
	bl3[a].setText("Cursor Line No: "+ln[a]);
	bl4[a]=new JLabel();
	bl4[a].setText("Cursor Column No: "+col[a]);
	
	/*p3[a].add(bl1[a]);
	p3[a].add(bl2[a]);
	p3[a].add(bl3[a]);
	p3[a].add(bl4[a]);
	
	
	p3[a].setLayout(new GridLayout(1,4));
	//p3.setSize(1000,300);
*/
	
}

 public void updateButtons() {
    //undoButton.setText(undoManager.getUndoPresentationName());
    //redoButton.setText(undoManager.getRedoPresentationName());
    //undoButton.setEnabled(true);
    b28.setEnabled(undoManager.canUndo());
    //redoButton.setEnabled(true);
    b29.setEnabled(undoManager.canRedo());
	
	mi21.setEnabled(undoManager.canUndo());
    //redoButton.setEnabled(true);
    mi22.setEnabled(undoManager.canRedo());
  }
  
public void addPopup(int b){
	menu = new JPopupMenu();
     item1 = new JMenuItem(new DefaultEditorKit.CutAction());
     item1.setText("Cut");
     //item.setEnabled(jta[tabCount].getSelectionStart() != jta[tabCount].getSelectionEnd());
     menu.add(item1);
	 item2 = new JMenuItem(new DefaultEditorKit.CopyAction());
     item2.setText("Copy");
     //item2.setEnabled(jta[tabCount].getSelectionStart() != jta[tabCount].getSelectionEnd());
	 menu.add(item2);
     item3 = new JMenuItem(new DefaultEditorKit.PasteAction());
     item3.setText("Paste");
	 menu.add(item3);
	 item4 = new JMenuItem("Delete");
     item4.addActionListener(this);
	 menu.add(item4);
	 item5 = new JMenuItem("Select All");
     item5.addActionListener(this);
	 menu.add(item5);
	 item6 = new JMenuItem("UPPERCASE    ");
     item6.addActionListener(this);
	 menu.add(item6);
	 item7 = new JMenuItem("lowercase");
     item7.addActionListener(this);
	 menu.add(item7);
	 
	 item1.setEnabled(false);
	 item2.setEnabled(false);
	 item4.setEnabled(false);
	 item6.setEnabled(false);
	 item7.setEnabled(false);
	 
	
}

void shortCut(){
	shortcutPanel=new JPanel(new BorderLayout());
	String col[]={"Name", "Shortcut"};
	
	String row[][]={
	{"New File","Ctrl+N"},{"Open File","Ctrl+O"},{"Save File","Ctrl+S"},{"Save as File","Ctrl+shift+S"},{"Close File","Ctrl+W"},{"Print File","Ctrl+P"},{"Exit","Alt+F4"},
	{"Undo","Ctrl+Z"},{"Redo","Ctrl+Y"},{"Cut","Ctrl+X"},{"Copy","Ctrl+C"},{"Paste","Ctrl+P"},{"Delete","DEL"},{"Select All","Ctrl+A"},{"UPPERCASE","Ctrl+U"},{"lowercase","Ctrl+l"},
	{"Find","Ctrl+F"},{"Find Next","F3"},{"Find Previous","Shift+F3"},{"Replace","Ctrl+H"},{"Go To","Ctrl+G"},
	{"Zoom In","Ctrl+Numpad+"},{"Zoom Out","Ctrl+Numpad-"},{"Default Zoom","Ctrl+Equals"},{"1st Tab","Ctrl+Numpad 1"},{"2nd Tab","Ctrl+Numpad 2"},{"3rd Tab","Ctrl+Numpad 3"},{"4th Tab","Ctrl+Numpad 4"},{"5th Tab","Ctrl+Numpad 5"},{"Next Tab","Ctrl+ Page Up"},{"Previous Tab","Ctrl+Page Down"},
	{"Compile","ctrl+F9"},{"Run","ctrl+F10"},{"Compile and Run","F9"}
	};
	
	JTable table= new JTable(row,col);
	JScrollPane scrollPane = new JScrollPane(table);
	table.setEnabled(false);
	
	shortcutPanel.add( scrollPane, BorderLayout.CENTER );
	
	JOptionPane pane = new JOptionPane(shortcutPanel);
		JDialog dialog = pane.createDialog(f, "ShortCuts");
		dialog.show();
		
}

public static void main(String s[]){
	Edit1 ed=new Edit1();
}

}