package com.kapur.app;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.BorderLayout;
import java.io.*;
import java.awt.Dimension;
import javax.swing.event.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;

import static com.kapur.app.AppConstants.*;

/**
 * The Java Editor One
 * 
 * @author Kapil Kumar (original author)
 * @author Kais el Kara (reviewer + refactor)
 *
 */
public class JavaEditorOne extends JPanel implements ActionListener {

	private static final long serialVersionUID = -7843100067947923104L;

	/** application frame */
	JFrame appFrame;

	JTextArea textComp;
	JTextArea[] ta = new JTextArea[100];
	JTextArea[] sectionForShowingFileRows = new JTextArea[100];
	JTextArea[] codeEditor = new JTextArea[10];
	
	String text[] = new String[100];
	JPanel[] mainFilePanel = new JPanel[10];
	JTextField jt1, jt2, jt3, tf, tf4, tf5;
	JPanel p1, p11, p12, p13, p2, p4, p5, p6, p7;
	
	JLabel l1, l11, l12, l13, l14, l15, l16, l17, l2, l3, l31, l32, l33, l34, l35, l4, l51, l52, l61, l62, l71, l72,
			l73;
	JButton b1, b21, b22, b23, b24, b25, b26, b27, b28, b29, b210, b211, b212, b213, b214, b215, b216, b217, b218, b219,
			b220, b221, b222, b223, b51, b52, b61, b62, b63, b64, b71, b72;
	
	JMenuBar menubar;
	JMenu menu1, menu2, menu3, menu4, menu_Settings, menu6, menu7, menu_Run, subm21, subm41, menuEncode;
	JMenuItem
	        mi11, mi12, mi13, mi14, mi15, mi16, mi17, mi18, mi19,
	        mi21, mi22, mi23, mi24, mi25, mi26, mi27, mi28,
			mi29, mi31, mi32, mi33, mi34, mi35, mi41, mi42, mi43, mi44, mi45, mi46, mi47, mi48, mi49, mi410, mi411,
			mi412, mir1, menuRun_Run, menuRun_CompileAndRun, mi51, mi52, mi61, mi62, mi63, mi64, mie1, mie2, mie3, mi71, mi72;

	KeyStroke k1, k2, k3, k4, k5, k6, k7, k8;
	JTabbedPane tabbedPane = new JTabbedPane();
	JPopupMenu popupMenu;
	JScrollPane[] sp = new JScrollPane[100];
	String data, newdata, select = ""; //$NON-NLS-1$
	char[] selectch;
	int tabCount = 0, selectedTab = 0, index = 0;
	String path[] = new String[100];
	String fileName[] = new String[100];
	String name[];
	// JPanel[] p3=new JPanel[100];
	JPanel p3 = new JPanel();

	JLabel[] lbl1 = new JLabel[100];
	JLabel[] lbl2 = new JLabel[100];
	JLabel[] lbl3 = new JLabel[100];
	JLabel[] lbl4 = new JLabel[100];
	String lineShow[] = new String[100];
	JPanel shortcutPanel;
	int gotoValue;
	int size = 16;
	int len[] = new int[100];
	int lines[] = new int[100];
	int ln[] = new int[100];
	int col[] = new int[100];
	// JPanel[] bottomPanel=new JPanel[100];
	JPanel bottomPanel;

	int findindex = 0, findindexpre = 0, findindexprev = 0;
	int prevtabselect, tabselect = 0;
	int i = 1;
	String find = ""; //$NON-NLS-1$
	String javaFileName = ""; //$NON-NLS-1$
	String fname1 = ""; //$NON-NLS-1$
	String result = ""; //$NON-NLS-1$
	String result1 = ""; //$NON-NLS-1$
	Runtime runtime;
	BufferedReader bufferReaderForCompileProcess = null;
	InputStream is = null;
	InputStreamReader isr = null;
	PrintWriter pw = null;
	FileWriter fw = null;
	JDialog dialog, dialog1, dialog2;
	protected UndoManager undoManager = new UndoManager();

	// popup
	JPopupMenu menu;
	JMenuItem item1, item2, item3, item4, item5, item6, item7;
	
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //

	public static void main(String s[]) {
		JavaEditorOne application = new JavaEditorOne();
	}
	
	/**
	 * Constructor
	 */
	public JavaEditorOne() {
		appFrame = new JFrame("Java Editor One - Kapur Edition"); //$NON-NLS-1$
		// f.setBackground(new Color (255,255,255));
		for (int i = 0; i < 100; i++) {
			// filename[i]="Untitled";
			text[i] = "";
			len[i] = 0;
			lines[i] = 1;
			ln[i] = 1;
			col[i] = 1;
			lineShow[i] = "1"; //$NON-NLS-1$
		}
		// upper menu
		menubar = new JMenuBar();
		
//		List<String> menuFile = Arrays.asList(
//				AppConstants.getString("JavaEditorOne.MENU_FILE_NEW"), AppConstants.getString("JavaEditorOne.MENU_FILE_OPEN"), AppConstants.getString("JavaEditorOne.MENU_FILE_SAVE"), AppConstants.getString("JavaEditorOne.MENU_FILE_SAVE_AS"), AppConstants.getString("JavaEditorOne.MENU_FILE_RENAME"), AppConstants.getString("JavaEditorOne.MENU_FILE_CLOSE"), AppConstants.getString("JavaEditorOne.MENU_FILE_CLOSE_ALL"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
//				AppConstants.getString("JavaEditorOne.MENU_FILE_PRINT"), //$NON-NLS-1$
//				AppConstants.getString("JavaEditorOne.MENU_FILE_EXIT")); //$NON-NLS-1$
//		
//		List<Integer> menuFile_KeyEvent = Arrays.asList(
//				KeyEvent.VK_N, KeyEvent.VK_O, KeyEvent.VK_S, KeyEvent.VK_S, -1, KeyEvent.VK_W, -1,
//				KeyEvent.VK_P,
//				KeyEvent.VK_F4
//				);
//		
//		List<Integer> menuFile_ActionEvent = Arrays.asList(
//				ActionEvent.CTRL_MASK, ActionEvent.CTRL_MASK, ActionEvent.CTRL_MASK, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK, -1, ActionEvent.CTRL_MASK, -1,
//				ActionEvent.CTRL_MASK,
//				ActionEvent.ALT_MASK
//				);
		
		//
		// menu 1 and items...
		//
		menu1 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_FILE")); //$NON-NLS-1$
		menu1.setMnemonic(KeyEvent.VK_F);
		menubar.add(menu1);

// TODO KAISEL / 11.11.2018 / refactor the menu creation and optimize the menu creation using templates
//		JMenuItem menuItem;
//		KeyStroke keyStroke;
//		int index = 0;
//		for (String menuItemName : menuFile) {
//			menuItem = new JMenuItem(menuItemName);
//			menuItem.addActionListener(this);
//			int keyCodeEvent = menuFile_KeyEvent.get(index);
//			int keyCodeAction = menuFile_ActionEvent.get(index);
//			if (keyCodeEvent != -1) {
//				keyStroke = KeyStroke.getKeyStroke(keyCodeEvent, keyCodeAction);
//				menuItem.setAccelerator(keyStroke);
//			}
//			menu1.add(menuItem);
//			index++;
//		}
		
		// menu item -> New
		mi11 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_NEW")); //$NON-NLS-1$
		mi11.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK);
		mi11.setAccelerator(k1);
		menu1.add(mi11);
		// menu item -> Open
		mi12 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_OPEN")); //$NON-NLS-1$
		mi12.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK);
		mi12.setAccelerator(k1);
		menu1.add(mi12);
		// menu item -> Save
		mi13 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_SAVE")); //$NON-NLS-1$
		mi13.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK);
		mi13.setAccelerator(k1);
		menu1.add(mi13);
		// menu item -> Save As
		mi14 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_SAVE_AS")); //$NON-NLS-1$
		mi14.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK);
		mi14.setAccelerator(k1);
		menu1.add(mi14);
		// menu item -> Rename
		mi15 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_RENAME")); //$NON-NLS-1$
		mi15.addActionListener(this);
		menu1.add(mi15);
		// menu item -> Close
		mi16 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_CLOSE")); //$NON-NLS-1$
		mi16.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK);
		mi16.setAccelerator(k1);
		menu1.add(mi16);
		// menu item -> Close All
		mi19 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_CLOSE_ALL")); //$NON-NLS-1$
		mi19.addActionListener(this);
		menu1.add(mi19);
		// menu item -> Separator
		menu1.addSeparator();
		// menu item -> Print
		mi17 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_PRINT")); //$NON-NLS-1$
		mi17.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK);
		mi17.setAccelerator(k1);
		menu1.add(mi17);
		// menu item -> Separator
		menu1.addSeparator();
		// menu item -> Exit
		mi18 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_FILE_EXIT")); //$NON-NLS-1$
		mi18.addActionListener(this);
		k1 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK);
		mi18.setAccelerator(k1);
		menu1.add(mi18);

		//
		// menu 2 and items...*
		//

		menu2 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_EDIT")); //$NON-NLS-1$
		menu2.setMnemonic(KeyEvent.VK_E);
		menubar.add(menu2);

		mi21 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_EDIT_UNDO")); //$NON-NLS-1$
		mi21.addActionListener(this);
		mi21.setEnabled(false);
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK);
		mi21.setAccelerator(k2);
		menu2.add(mi21);

		mi22 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_EDIT_REDO")); //$NON-NLS-1$
		mi22.addActionListener(this);
		mi22.setEnabled(false);
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK);
		mi22.setAccelerator(k2);
		menu2.add(mi22);

		menu2.addSeparator();
		/*
		 * mi23=new JMenuItem("Cut"); mi23.addActionListener(this);
		 * k2=KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
		 * mi23.setAccelerator(k2); menu2.add(mi23);
		 * 
		 * mi24=new JMenuItem("Copy"); mi24.addActionListener(this);
		 * k2=KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
		 * mi24.setAccelerator(k2); menu2.add(mi24);
		 * 
		 * mi25=new JMenuItem("Paste"); mi25.addActionListener(this);
		 * k2=KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK);
		 * mi25.setAccelerator(k2); menu2.add(mi25);
		 */

		mi23 = new JMenuItem(new DefaultEditorKit.CutAction());
		mi23.setText(AppConstants.getString("JavaEditorOne.MENU_EDIT_CUT")); //$NON-NLS-1$
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK);
		mi23.setAccelerator(k2);
		menu2.add(mi23);

		mi24 = new JMenuItem(new DefaultEditorKit.CopyAction());
		mi24.setText(AppConstants.getString("JavaEditorOne.MENU_EDIT_COPY")); //$NON-NLS-1$
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK);
		mi24.setAccelerator(k2);
		menu2.add(mi24);

		mi25 = new JMenuItem(new DefaultEditorKit.PasteAction());
		mi25.setText(AppConstants.getString("JavaEditorOne.MENU_EDIT_PASTE")); //$NON-NLS-1$
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK);
		mi25.setAccelerator(k2);
		menu2.add(mi25);

		mi26 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_EDIT_DELETE")); //$NON-NLS-1$
		mi26.addActionListener(this);
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
		mi26.setAccelerator(k2);
		menu2.add(mi26);

		mi27 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_EDIT_SELECT_ALL")); //$NON-NLS-1$
		mi27.addActionListener(this);
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK);
		mi27.setAccelerator(k2);
		menu2.add(mi27);

		menu2.addSeparator();

		subm21 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_EDIT_CONVERT_CASE_TO")); //$NON-NLS-1$

		mi28 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_EDIT_UPPER_CASE")); //$NON-NLS-1$
		mi28.addActionListener(this);
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK);
		mi28.setAccelerator(k2);
		subm21.add(mi28);
		mi29 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_EDIT_LOWER_CASE")); //$NON-NLS-1$
		mi29.addActionListener(this);
		k2 = KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK);
		mi29.setAccelerator(k2);
		subm21.add(mi29);

		menu2.add(subm21);

		// Menu 3 and Items

		menu3 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_SEARCH")); //$NON-NLS-1$
		menu3.setMnemonic(KeyEvent.VK_S);
		menubar.add(menu3);

		mi31 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_SEARCH_FIND")); //$NON-NLS-1$
		mi31.addActionListener(this);
		k3 = KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
		mi31.setAccelerator(k3);
		menu3.add(mi31);

		mi32 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_SEARCH_FIND_NEXT")); //$NON-NLS-1$
		mi32.addActionListener(this);
		k3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
		mi32.setAccelerator(k3);
		menu3.add(mi32);

		mi33 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_SEARCH_FIND_PREVIOUS")); //$NON-NLS-1$
		mi33.addActionListener(this);
		k3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, ActionEvent.SHIFT_MASK);
		mi33.setAccelerator(k3);
		menu3.add(mi33);

		mi34 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_SEARCH_REPLACE")); //$NON-NLS-1$
		mi34.addActionListener(this);
		k3 = KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK);
		mi34.setAccelerator(k3);
		menu3.add(mi34);

		mi35 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_SEARCH_GOTO")); //$NON-NLS-1$
		mi35.addActionListener(this);
		k3 = KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK);
		mi35.setAccelerator(k3);
		menu3.add(mi35);

		// Menu 4 and Items

		menu4 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_VIEW")); //$NON-NLS-1$
		menu4.setMnemonic(KeyEvent.VK_V);
		menubar.add(menu4);

		mi41 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_VIEW_FULL_SCREEN")); //$NON-NLS-1$
		mi41.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0);
		mi41.setAccelerator(k4);
		menu4.add(mi41);

		mi42 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_VIEW_ZOOM_IN")); //$NON-NLS-1$
		mi42.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_ADD, ActionEvent.CTRL_MASK);
		mi42.setAccelerator(k4);
		menu4.add(mi42);

		mi43 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_VIEW_ZOOM_OUT")); //$NON-NLS-1$
		mi43.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, ActionEvent.CTRL_MASK);
		mi43.setAccelerator(k4);
		menu4.add(mi43);

		mi412 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_VIEW_RESTORE_ZOOM")); //$NON-NLS-1$
		mi412.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, ActionEvent.CTRL_MASK);
		mi412.setAccelerator(k4);
		menu4.add(mi412);

		subm41 = new JMenu(AppConstants.getString("JavaEditorOne.TAB")); //$NON-NLS-1$

		mi44 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_ONE")); //$NON-NLS-1$
		mi44.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, ActionEvent.CTRL_MASK);
		mi44.setAccelerator(k4);
		subm41.add(mi44);
		mi45 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_TWO")); //$NON-NLS-1$
		mi45.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, ActionEvent.CTRL_MASK);
		mi45.setAccelerator(k4);
		subm41.add(mi45);
		mi46 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_THREE")); //$NON-NLS-1$
		mi46.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, ActionEvent.CTRL_MASK);
		mi46.setAccelerator(k4);
		subm41.add(mi46);
		mi410 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_FOUR")); //$NON-NLS-1$
		mi410.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, ActionEvent.CTRL_MASK);
		mi410.setAccelerator(k4);
		subm41.add(mi410);
		mi411 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_FIVE")); //$NON-NLS-1$
		mi411.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		mi411.setAccelerator(k4);
		subm41.add(mi411);

		subm41.addSeparator();
		mi47 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_NEXT")); //$NON-NLS-1$
		mi47.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_UP, ActionEvent.CTRL_MASK);
		mi47.setAccelerator(k4);
		subm41.add(mi47);
		mi48 = new JMenuItem(AppConstants.getString("JavaEditorOne.TAB_PREVIOUS")); //$NON-NLS-1$
		mi48.addActionListener(this);
		k4 = KeyStroke.getKeyStroke(KeyEvent.VK_PAGE_DOWN, ActionEvent.CTRL_MASK);
		mi48.setAccelerator(k4);
		subm41.add(mi48);

		menu4.add(subm41);

		mi49 = new JMenuItem(AppConstants.getString("JavaEditorOne.58")); //$NON-NLS-1$
		mi49.addActionListener(this);
		menu4.add(mi49);

		// Menu Run and Items

		menu_Run = new JMenu(AppConstants.getString("JavaEditorOne.MENU_RUN")); //$NON-NLS-1$
		menu_Run.setMnemonic(KeyEvent.VK_R);
		menubar.add(menu_Run);

		mir1 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RUN_COMPILE")); //$NON-NLS-1$
		mir1.addActionListener(this);
		// k4=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
		// mi41.setAccelerator(k4);
		menu_Run.add(mir1);

		menuRun_Run = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RUN_RUN")); //$NON-NLS-1$
		menuRun_Run.addActionListener(this);
		// k4=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
		// mi41.setAccelerator(k4);
		menu_Run.add(menuRun_Run);

		menuRun_CompileAndRun = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RUN_COMPILE_AND_RUN")); //$NON-NLS-1$
		menuRun_CompileAndRun.addActionListener(this);
		// k4=KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK);
		// mi41.setAccelerator(k4);
		menu_Run.add(menuRun_CompileAndRun);

		// Menu 5 and Items...
		menu_Settings = new JMenu(AppConstants.getString("JavaEditorOne.MENU_SETTINGS")); //$NON-NLS-1$
		menu_Settings.setMnemonic(KeyEvent.VK_T);
		menubar.add(menu_Settings);

		mi51 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_SETTINGS_STYLE")); //$NON-NLS-1$
		mi51.addActionListener(this);
		menu_Settings.add(mi51);

		// menu 6 and items...
		menu6 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_RECORDING")); //$NON-NLS-1$
		menu6.setMnemonic(KeyEvent.VK_D);
		menubar.add(menu6);

		mi61 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RECORDING_START")); //$NON-NLS-1$
		mi61.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menu6.add(mi61);

		mi62 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RECORDING_PAUSE")); //$NON-NLS-1$
		mi62.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menu6.add(mi62);

		mi63 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RECORDING_STOP")); //$NON-NLS-1$
		mi63.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menu6.add(mi63);

		mi64 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_RECORDING_SAVE")); //$NON-NLS-1$
		mi64.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menu6.add(mi64);

		// Encodeing menu and items...
		menuEncode = new JMenu(AppConstants.getString("JavaEditorOne.70")); //$NON-NLS-1$
		menuEncode.setMnemonic(KeyEvent.VK_E);
		menubar.add(menuEncode);

		mie1 = new JMenuItem(AppConstants.getString("JavaEditorOne.71")); //$NON-NLS-1$
		mie1.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menuEncode.add(mie1);

		mie2 = new JMenuItem(AppConstants.getString("JavaEditorOne.72")); //$NON-NLS-1$
		mie2.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menuEncode.add(mie2);

		mie3 = new JMenuItem(AppConstants.getString("JavaEditorOne.73")); //$NON-NLS-1$
		mie3.addActionListener(this);
		// k6=KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, ActionEvent.CTRL_MASK);
		// mi61.setAccelerator(k6);
		menuEncode.add(mie3);

		// ----------
		menu7 = new JMenu(AppConstants.getString("JavaEditorOne.MENU_HELP")); //$NON-NLS-1$
		menu7.setMnemonic(KeyEvent.VK_H);
		menubar.add(menu7);

		mi71 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_HELP_SHORTCUTS")); //$NON-NLS-1$
		mi71.addActionListener(this);
		menu7.add(mi71);

		mi72 = new JMenuItem(AppConstants.getString("JavaEditorOne.MENU_HELP_ABOUT_US")); //$NON-NLS-1$
		mi72.addActionListener(this);
		menu7.add(mi72);

		// disable menu items whene editor starting

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
		menuRun_Run.setEnabled(false);
		menuRun_CompileAndRun.setEnabled(false);

		mi51.setEnabled(false);

		mi61.setEnabled(false);
		mi62.setEnabled(false);
		mi63.setEnabled(false);
		mi64.setEnabled(false);

		mie1.setEnabled(false);
		mie2.setEnabled(false);
		mie3.setEnabled(false);

		// ----

		appFrame.setJMenuBar(menubar);

		// ******menu bellow images

		JToolBar bar = new JToolBar();

		b21 = new JButton();
		b22 = new JButton();
		b23 = new JButton();
		b24 = new JButton();
		b25 = new JButton(new DefaultEditorKit.CutAction());
		b26 = new JButton(new DefaultEditorKit.CopyAction());
		b27 = new JButton(new DefaultEditorKit.PasteAction());
		b28 = new JButton();
		b29 = new JButton();
		b210 = new JButton();
		b211 = new JButton();
		b212 = new JButton();
		b213 = new JButton();
		b214 = new JButton();
		b215 = new JButton();
		b216 = new JButton();
		b217 = new JButton();
		b218 = new JButton();
		b219 = new JButton();
		b220 = new JButton();
		b221 = new JButton();
		b222 = new JButton();

		b21.setIcon(ICON_NEW);
		b21.addActionListener(this);
		b22.setIcon(ICON_OPEN);
		b22.addActionListener(this);
		b23.setIcon(ICON_SAVE);
		b23.addActionListener(this);
		b24.setIcon(ICON_SAVE_AS);
		b24.addActionListener(this);
		b25.setIcon(ic5);
		b25.setText(""); //$NON-NLS-1$
		// b25.addActionListener(this);
		b26.setIcon(ic6);
		// b26.addActionListener(this);
		b26.setText(""); //$NON-NLS-1$
		b27.setIcon(ic7);
		// b27.addActionListener(this);
		b27.setText(""); //$NON-NLS-1$
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
		b214.setIcon(ICON_COMPILE);
		b214.addActionListener(this);
		b215.setIcon(ICON_RUN);
		b215.addActionListener(this);
		b216.setIcon(ICON_COMPILE_RUN);
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

		bar.setMargin(new Insets(0, 0, 0, 0));
		bar.setRollover(false);
		bar.setFloatable(false);
		appFrame.add(bar, BorderLayout.NORTH);

		/*
		 * //add popup menu...
		 * popup = new JPopupMenu(); JMenuItem item1,item2,item3,item4; item1=new
		 * JMenuItem("Cut"); popup.add(item1); item1.addActionListener(this);
		 * item2=new JMenuItem("Copy"); popup.add(item2); item2.addActionListener(this);
		 * item3=new JMenuItem("Paste"); popup.add(item3);
		 * item3.addActionListener(this);
		 * JPanel popupPanel=new JPanel(); popupPanel.setComponentPopupMenu(popup);
		 * f.add(popupPanel);
		 */

		// An inner class to check whether mouse events are the popup trigger

		// ---------------- //
		// bottom panel...
		// ---------------- //

		tabbedPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (e.getSource() instanceof JTabbedPane) {
					JTabbedPane pane = (JTabbedPane) e.getSource();
					int select = pane.getSelectedIndex();
					System.out.println(AppConstants.getString("JavaEditorOne.80") + pane.getSelectedIndex()); //$NON-NLS-1$
					// Caret Listener
					if (select >= 0) {
						codeEditor[select + 1].addCaretListener(new CaretListener() {
							public void caretUpdate(CaretEvent e) {
								JTextArea editArea = (JTextArea) e.getSource();
								try {
									int caretpos = editArea.getCaretPosition();
									ln[select + 1] = editArea.getLineOfOffset(caretpos);
									col[select + 1] = caretpos - editArea.getLineStartOffset(ln[select + 1]);
									int coll = col[select + 1] + 1;
									int lnn = ln[select + 1] + 1;
									lbl1[select + 1].setText(AppConstants.getString("JavaEditorOne.81") + len[select + 1]); //$NON-NLS-1$
									lbl2[select + 1].setText(AppConstants.getString("JavaEditorOne.82") + lines[select + 1]); //$NON-NLS-1$
									lbl3[select + 1].setText(AppConstants.getString("JavaEditorOne.83") + lnn); //$NON-NLS-1$
									lbl4[select + 1].setText(AppConstants.getString("JavaEditorOne.84") + coll); //$NON-NLS-1$
									// p3=new JPanel();
									ln[select + 1]++;
									// enable options
									String chkSelect = codeEditor[select + 1].getSelectedText();
									if (chkSelect != null) {
										b25.setEnabled(true);
										b26.setEnabled(true);
										mi23.setEnabled(true);
										mi24.setEnabled(true);
										mi26.setEnabled(true);
										// popup
										item1.setEnabled(true);
										item2.setEnabled(true);
										item4.setEnabled(true);
										item6.setEnabled(true);
										item7.setEnabled(true);
									} else {
										b25.setEnabled(false);
										b26.setEnabled(false);
										mi23.setEnabled(false);
										mi24.setEnabled(false);
										mi26.setEnabled(false);
										// popup
										item1.setEnabled(false);
										item2.setEnabled(false);
										item4.setEnabled(false);
										item6.setEnabled(false);
										item7.setEnabled(false);
									}
									// -----

								}

								catch (Exception ex) {
								}

							}
						});
						// ---
						// Left side line show count
						DocumentListener documentListener = new DocumentListener() {
							public void insertUpdate(DocumentEvent e) {
								updateLog(e, AppConstants.getString("JavaEditorOne.85")); //$NON-NLS-1$
							}
							public void removeUpdate(DocumentEvent e) {
								updateLog(e, AppConstants.getString("JavaEditorOne.86")); //$NON-NLS-1$
							}
							public void changedUpdate(DocumentEvent e) {
								// Plain text components do not fire these events
							}
							public void updateLog(DocumentEvent e, String action) {
								Document doc = (Document) e.getDocument();
								int changeLength = e.getLength();
								String s = codeEditor[select + 1].getText();
								lineShow[select + 1] = ""; //$NON-NLS-1$
								i = 1;
								for (int a = 0; a < s.length(); a++) {
									if (s.charAt(a) == '\n') {
										i = i + 1;
									}
								}
								lines[select + 1] = i;
								len[select + 1] = s.length();
								for (int k = 1; k <= i; k++) {
									lineShow[select + 1] = lineShow[select + 1] + k + "\n"; //$NON-NLS-1$
									sectionForShowingFileRows[select + 1].setText(lineShow[select + 1]);
								}
								// f.add(taLine[select+1],BorderLayout.WEST);
							}
						};
                        // undo action--------
						codeEditor[select + 1].getDocument().addUndoableEditListener(new UndoableEditListener() {
							public void undoableEditHappened(UndoableEditEvent e) {
								undoManager.addEdit(e.getEdit());
								updateButtons();
							}
						});
						codeEditor[select + 1].addMouseListener(new MouseAdapter() {
							public void mouseReleased(final MouseEvent e) {
								if (e.isPopupTrigger()) {
									menu.show(e.getComponent(), e.getX(), e.getY());
								}
							}
						});

						// set enable option when tab is selectedTab
						p3 = new JPanel();
						JLabel ext = new JLabel(AppConstants.getString("JavaEditorOne.89")); //$NON-NLS-1$
						JLabel ext1 = new JLabel();
						JLabel ext2 = new JLabel();
						p3.add(ext);
						p3.add(ext1);
						p3.add(ext2);

						p3.add(lbl1[select + 1]);
						p3.add(lbl2[select + 1]);
						p3.add(lbl3[select + 1]);
						p3.add(lbl4[select + 1]);
						p3.setPreferredSize(new Dimension(10, 15));

						p3.setLayout(new GridLayout(1, 7));
						// p3.setLayout(new FlowLayout(FlowLayout.RIGHT));
						// f.add(p3,BorderLayout.SOUTH);
						// ------------

						// ta[a]=new JTextArea(5,100);
						codeEditor[select + 1].getDocument().addDocumentListener(documentListener);

						TitledBorder titled = new TitledBorder(AppConstants.getString("JavaEditorOne.90")); //$NON-NLS-1$
						sp[select + 1].setBorder(titled);

						bottomPanel = new JPanel(new BorderLayout());

						bottomPanel.add(sp[select + 1], BorderLayout.CENTER);
						bottomPanel.add(p3, BorderLayout.SOUTH);

						appFrame.add(bottomPanel, BorderLayout.SOUTH);
					}
				} else {
					System.out.println(AppConstants.getString("JavaEditorOne.91")); //$NON-NLS-1$
				}
			}
		});

		// file browser

		p4 = new JPanel();
		l4 = new JLabel(AppConstants.getString("JavaEditorOne.HTML")); //$NON-NLS-1$
		p4.add(l4);
		// f.add(p4,BorderLayout.WEST);

		// f.add(tf);
		// f.setSize(1366,730);
		// f.pack();
		// f.setVisible(true);

		appFrame.setExtendedState(6);
		appFrame.setVisible(true);

		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		runtime = Runtime.getRuntime();
	}


	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	
	/**
	 * Create a new file
	 * @param parFileName
	 */
	void createNewFile(String parFileName) {
		StringBuffer fileContent = null;
		File templateFile = new File(TEMPLATE_NEW_FILE);
		if (templateFile.exists()) {
			try {
				FileReader freader = new FileReader(templateFile);
				fileContent = new StringBuffer(100);
				while((i=freader.read())!=-1)   {
					fileContent.append((char)i);
				}
				freader.close();
			} catch(Exception parEx) {
				parEx.printStackTrace();
			}
			
		}
		
		statusBar(tabCount);
		fileName[tabCount] = parFileName;
		int a = parFileName.indexOf("."); //$NON-NLS-1$
		String fname1 = parFileName.substring(0, a);
		path[tabCount] = AppConstants.getString("JavaEditorOne.JAVA_EDITOR_PATH") + parFileName; //$NON-NLS-1$
		codeEditor[tabCount].setText(fileContent.toString().replace("FILENAME", fname1));
		int tabSize = codeEditor[tabCount].getTabSize();
		tabSize = 4;
		codeEditor[tabCount].setTabSize(tabSize);
		Font displayFont = new Font("Consolas", Font.PLAIN, size);
		codeEditor[tabCount].setFont(displayFont);
		mainFilePanel[tabCount] = new JPanel(new BorderLayout());
		sectionForShowingFileRows[tabCount] = new JTextArea(1, 5);
		sectionForShowingFileRows[tabCount].setEditable(false);
		// line count in starting
		String s = codeEditor[tabCount].getText();
		lineShow[tabCount] = ""; //$NON-NLS-1$
		i = 1;
		for (int j = 0; j < s.length(); j++) {
			if (s.charAt(j) == '\n') {
				i = i + 1;
			}
		}
		lines[tabCount] = i;
		len[tabCount] = s.length();
		lbl1[tabCount].setText("Lenght: " + len[tabCount]); //$NON-NLS-1$
		lbl2[tabCount].setText("Lines: " + lines[tabCount]); //$NON-NLS-1$
		for (int k = 1; k <= i; k++) {
			lineShow[tabCount] = lineShow[tabCount] + " " + k + "\n"; //$NON-NLS-1$ //$NON-NLS-2$
			sectionForShowingFileRows[tabCount].setText(lineShow[tabCount]);
		}
		sectionForShowingFileRows[tabCount].setText(lineShow[tabCount]);
		sectionForShowingFileRows[tabCount].setFont(displayFont);
		sectionForShowingFileRows[tabCount].setBackground(Color.decode("#E0E0E0")); //$NON-NLS-1$
		sectionForShowingFileRows[tabCount].setForeground(Color.decode("#FF0000")); //$NON-NLS-1$
		mainFilePanel[tabCount].add(sectionForShowingFileRows[tabCount], BorderLayout.WEST);
		mainFilePanel[tabCount].add(codeEditor[tabCount], BorderLayout.CENTER);
		JScrollPane scroll = new JScrollPane(mainFilePanel[tabCount]);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab(parFileName, ICON_SAVE, scroll, path[tabCount]);
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		appFrame.add(tabbedPane);
		try {
			fw = new FileWriter(parFileName);
			String s2 = codeEditor[tabCount].getText();
			pw = new PrintWriter(fw);
			pw.println(s2);
			pw.flush();
		} catch (Exception ex) {
			System.out.println(ex);
		}
		appFrame.setExtendedState(6);
		appFrame.setVisible(true);
        // Popup menu
		addPopup(tabCount);
	}

	/**
	 * open a file
	 */
	void openFile() {
		JFileChooser jfc = new JFileChooser();
		int x = jfc.showOpenDialog(null);
		if (x == JFileChooser.APPROVE_OPTION) {
			tabCount++;
			statusBar(tabCount);
			codeEditor[tabCount] = new JTextArea();
			File file = jfc.getSelectedFile();
			if (file == null) return;
			javaFileName = jfc.getName(file);
			path[tabCount] = file.getAbsolutePath();
			fileName[tabCount] = javaFileName;
			FileReader reader = null;
			try {
				reader = new FileReader(file);
				codeEditor[tabCount].read(reader, null);
				data = codeEditor[tabCount].getText();
				Font displayFont = new Font("Consolas", Font.PLAIN, size); //$NON-NLS-1$
				codeEditor[tabCount].setFont(displayFont);
				mainFilePanel[tabCount] = new JPanel(new BorderLayout());
				sectionForShowingFileRows[tabCount] = new JTextArea(1, 5);
				sectionForShowingFileRows[tabCount].setEditable(false);
				// line count in starting
				String s = codeEditor[tabCount].getText();
				lineShow[tabCount] = ""; //$NON-NLS-1$
				i = 1;
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) == '\n') {
						i = i + 1;
					}
				}
				lines[tabCount] = i;
				len[tabCount] = s.length();
				lbl1[tabCount].setText("Lenght: " + len[tabCount]); //$NON-NLS-1$
				lbl2[tabCount].setText("Lines: " + lines[tabCount]); //$NON-NLS-1$
				for (int k = 1; k <= i; k++) {
					lineShow[tabCount] = lineShow[tabCount] + k + "\n"; //$NON-NLS-1$
					sectionForShowingFileRows[tabCount].setText(lineShow[tabCount]);
				}
				sectionForShowingFileRows[tabCount].setText(lineShow[tabCount]);
				sectionForShowingFileRows[tabCount].setFont(displayFont);
				sectionForShowingFileRows[tabCount].setBackground(Color.decode("#E0E0E0")); //$NON-NLS-1$
				mainFilePanel[tabCount].add(sectionForShowingFileRows[tabCount], BorderLayout.WEST);
				mainFilePanel[tabCount].add(codeEditor[tabCount], BorderLayout.CENTER);
				JScrollPane scroll = new JScrollPane(mainFilePanel[tabCount]);
				tabbedPane.addTab(javaFileName, ICON_SAVE, scroll, path[tabCount]);
				// popup menu
				addPopup(tabCount);
			} catch (IOException ex) {
				JOptionPane.showMessageDialog(appFrame, "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
			}
			appFrame.add(tabbedPane);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
		if (x == JFileChooser.CANCEL_OPTION) {
			System.out.println("cancel"); //$NON-NLS-1$
		}
		appFrame.setExtendedState(6);
		appFrame.setVisible(true);
	}

	/**
	 * compiling the java file
	 */
	public void compileFile() {
		result = ""; //$NON-NLS-1$
		try {
			javaFileName = fileName[selectedTab + 1];
			fw = new FileWriter(javaFileName);
			String s2 = codeEditor[selectedTab + 1].getText();
			pw = new PrintWriter(fw);
			pw.println(s2);
			pw.flush();
			Process compileProcess = runtime.exec(JAVA_PATH + "javac -d . " + javaFileName); //$NON-NLS-1$
			bufferReaderForCompileProcess = new BufferedReader(new InputStreamReader(compileProcess.getErrorStream()));
			System.out.println(compileProcess);
			while (true) {
				String temp = bufferReaderForCompileProcess.readLine();
				if (temp != null) {
					// result+="\n";
					result += temp;
					result += "\n"; //$NON-NLS-1$
				} else {
					break;
				}
			}
			if (result.equals("")) { //$NON-NLS-1$
				ta[selectedTab + 1].setText(AppConstants.getString("JavaEditorOne.COMPILE_SUCCESS")); //$NON-NLS-1$
				bufferReaderForCompileProcess.close();
			} else {
				ta[selectedTab + 1].setText(result);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * run the java file
	 */
	public void runFile() {
		result = ""; //$NON-NLS-1$
		result1 = ""; //$NON-NLS-1$
		try {
			javaFileName = fileName[selectedTab + 1];
			int a = javaFileName.indexOf("."); //$NON-NLS-1$
			String fname1 = javaFileName.substring(0, a);
			String fn = fname1;
			Process javaProcess = runtime.exec(JAVA_PATH + "java " + fn); //$NON-NLS-1$
			BufferedReader br1 = new BufferedReader(new InputStreamReader(javaProcess.getInputStream()));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(javaProcess.getErrorStream()));
			while (true) {
				String temp = br1.readLine();
				if (temp != null) {
					result += temp;
					result += "\n"; //$NON-NLS-1$
				} else {
					System.out.println("break1"); //$NON-NLS-1$
					break;
				}
			}
			while (true) {
				String temp1 = br2.readLine();
				if (temp1 != null) {
					result1 += temp1;
					result1 += "\n"; //$NON-NLS-1$
				} else {
					System.out.println("break2"); //$NON-NLS-1$
					break;
				}
			}
			br1.close();
			br2.close();
			System.out.println("br close"); //$NON-NLS-1$
			if (!result.equals("") && result1.equals("")) { //$NON-NLS-1$ //$NON-NLS-2$
				ta[selectedTab + 1].setText(result);
			}
			if (result.equals("")) { //$NON-NLS-1$
				ta[selectedTab + 1].setText(result1);
			}
			if (!result.equals("") && !result1.equals("")) { //$NON-NLS-1$ //$NON-NLS-2$
				ta[selectedTab + 1].setText(result + "\n" + result1); //$NON-NLS-1$
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	/**
	 * status bar
	 * @param a
	 */
	void statusBar(int a) {
		// panelLine[a]=new JPanel(new BorderLayout());
		ta[a] = new JTextArea(5, 10);
		ta[a].setEditable(false);
		// taLine[a]=new JTextArea();
		// taLine[a].setEditable(false);
		// panelLine[a].add(taLine[a],BorderLayout.WEST);
		// panelLine[a].add(jta[a],BorderLayout.CENTER);
		sp[a] = new JScrollPane(ta[a]);
		// JScrollPane sp= new JScrollPane();
		// ta[a]=new JTextArea(5,100);
		// bottomPanel[a]=new JPanel();
		// p3[a]=new JPanel();
		lbl1[a] = new JLabel();
		lbl1[a].setText("Lenght: " + len[a]); //$NON-NLS-1$
		lbl2[a] = new JLabel();
		lbl2[a].setText("Lines: " + lines[a]); //$NON-NLS-1$
		lbl3[a] = new JLabel();
		lbl3[a].setText(AppConstants.getString("JavaEditorOne.151") + ln[a]); //$NON-NLS-1$
		lbl4[a] = new JLabel();
		lbl4[a].setText(AppConstants.getString("JavaEditorOne.152") + col[a]); //$NON-NLS-1$
		/*
		 * p3[a].add(bl1[a]); p3[a].add(bl2[a]); p3[a].add(bl3[a]); p3[a].add(bl4[a]);
		 * p3[a].setLayout(new GridLayout(1,4)); //p3.setSize(1000,300);
		 */
	}

	public void updateButtons() {
		// undoButton.setText(undoManager.getUndoPresentationName());
		// redoButton.setText(undoManager.getRedoPresentationName());
		// undoButton.setEnabled(true);
		b28.setEnabled(undoManager.canUndo());
		// redoButton.setEnabled(true);
		b29.setEnabled(undoManager.canRedo());
		mi21.setEnabled(undoManager.canUndo());
		// redoButton.setEnabled(true);
		mi22.setEnabled(undoManager.canRedo());
	}

	public void addPopup(int b) {
		menu = new JPopupMenu();
		item1 = new JMenuItem(new DefaultEditorKit.CutAction());
		item1.setText(AppConstants.getString("JavaEditorOne.153")); //$NON-NLS-1$
		// item.setEnabled(jta[tabCount].getSelectionStart() !=
		// jta[tabCount].getSelectionEnd());
		menu.add(item1);
		item2 = new JMenuItem(new DefaultEditorKit.CopyAction());
		item2.setText(AppConstants.getString("JavaEditorOne.154")); //$NON-NLS-1$
		// item2.setEnabled(jta[tabCount].getSelectionStart() !=
		// jta[tabCount].getSelectionEnd());
		menu.add(item2);
		item3 = new JMenuItem(new DefaultEditorKit.PasteAction());
		item3.setText(AppConstants.getString("JavaEditorOne.155")); //$NON-NLS-1$
		menu.add(item3);
		item4 = new JMenuItem(AppConstants.getString("JavaEditorOne.156")); //$NON-NLS-1$
		item4.addActionListener(this);
		menu.add(item4);
		item5 = new JMenuItem(AppConstants.getString("JavaEditorOne.157")); //$NON-NLS-1$
		item5.addActionListener(this);
		menu.add(item5);
		item6 = new JMenuItem(AppConstants.getString("JavaEditorOne.158")); //$NON-NLS-1$
		item6.addActionListener(this);
		menu.add(item6);
		item7 = new JMenuItem(AppConstants.getString("JavaEditorOne.159")); //$NON-NLS-1$
		item7.addActionListener(this);
		menu.add(item7);
		item1.setEnabled(false);
		item2.setEnabled(false);
		item4.setEnabled(false);
		item6.setEnabled(false);
		item7.setEnabled(false);
	}

	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	
	/**
	 * shortcuts
	 */
	void showShortCuts() {
		shortcutPanel = new JPanel(new BorderLayout());
		JTable table = new JTable(SHORTCUTS_ROWS, SHORTCUTS_COLUMNS);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setEnabled(false);
		shortcutPanel.add(scrollPane, BorderLayout.CENTER);
		JOptionPane pane = new JOptionPane(shortcutPanel);
		JDialog dialog = pane.createDialog(appFrame, AppConstants.getString("JavaEditorOne.160")); //$NON-NLS-1$
		dialog.show();
	}

	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	
	/**
	 * action performed
	 */
	public void actionPerformed(ActionEvent e) {
		selectedTab = tabbedPane.getSelectedIndex();

        // action on menu1
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.161")) || e.getSource() == b21) { //$NON-NLS-1$

			JPanel panel = new JPanel();
			JLabel label = new JLabel(AppConstants.getString("JavaEditorOne.162")); //$NON-NLS-1$
			//label.requestFocus();
			JTextField tf = new JTextField(AppConstants.getString("JavaEditorOne.163")); //$NON-NLS-1$
			panel.add(label);
			panel.add(tf);
			panel.setLayout(new GridLayout(1, 2));

			int result = JOptionPane.showConfirmDialog(null, panel, AppConstants.getString("JavaEditorOne.164"), JOptionPane.OK_OPTION); //$NON-NLS-1$
			if (result == JOptionPane.OK_OPTION) {
				if (!tf.getText().equals("")) { //$NON-NLS-1$
					javaFileName = tf.getText().trim() + ".java"; //$NON-NLS-1$
					fname1 = tf.getText().trim();
					tabCount++;
					codeEditor[tabCount] = new JTextArea();
					// set enable option...

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

					// menu enable...

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
					menuRun_Run.setEnabled(true);
					menuRun_CompileAndRun.setEnabled(true);

					mi51.setEnabled(true);

					mi61.setEnabled(true);

					mie1.setEnabled(true);
					mie2.setEnabled(true);
					mie3.setEnabled(true);

					// ----
					createNewFile(javaFileName);
				}
			}

			else {
				System.out.println(AppConstants.getString("JavaEditorOne.167")); //$NON-NLS-1$
			}

		}
//open file action
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.168")) || e.getSource() == b22) { //$NON-NLS-1$

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

			// menu enable...

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
			menuRun_Run.setEnabled(true);
			menuRun_CompileAndRun.setEnabled(true);

			mi51.setEnabled(true);

			mi61.setEnabled(true);

			mie1.setEnabled(true);
			mie2.setEnabled(true);
			mie3.setEnabled(true);

			// ----
			openFile();
		}

//save option
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.169")) || e.getSource() == b23) { //$NON-NLS-1$
			try {
				fw = new FileWriter(javaFileName);
				String s2 = codeEditor[selectedTab + 1].getText();
				pw = new PrintWriter(fw);
				pw.println(s2);
				pw.flush();
			} catch (Exception ex) {
				System.out.println(e);
			}
		}
//save as option
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.170")) || e.getSource() == b24) { //$NON-NLS-1$
			JFileChooser jfc = new JFileChooser();
			int x = jfc.showSaveDialog(null);
			if (x == JFileChooser.APPROVE_OPTION) {
				File file = jfc.getSelectedFile();
				String s = jfc.getName(file);
				if (file == null)
					return;
				FileWriter writer = null;
				try {
					writer = new FileWriter(file);
					codeEditor[selectedTab + 1].write(writer);
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(appFrame, AppConstants.getString("JavaEditorOne.171"), AppConstants.getString("JavaEditorOne.172"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$ //$NON-NLS-2$
				}

			}
			if (x == JFileChooser.CANCEL_OPTION) {
				System.out.println(AppConstants.getString("JavaEditorOne.173")); //$NON-NLS-1$
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.174"))) { //$NON-NLS-1$
			codeEditor[selectedTab + 1].setText(AppConstants.getString("JavaEditorOne.175")); //$NON-NLS-1$
		}

		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.176")) || e.getSource() == b221) { //$NON-NLS-1$
			tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
			ta[selectedTab + 1].setVisible(false);
			lbl1[selectedTab + 1].setVisible(false);
			lbl2[selectedTab + 1].setVisible(false);
			lbl3[selectedTab + 1].setVisible(false);
			lbl4[selectedTab + 1].setVisible(false);
			tabCount--;

		}

		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.177")) || e.getSource() == b222) { //$NON-NLS-1$
			tabbedPane.removeAll();
			tabCount = 0;
		}

		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.178"))) { //$NON-NLS-1$
			/*
			 * try{ MessageFormat header= new MessageFormat("Edit k"); MessageFormat footer=
			 * new MessageFormat("All Rights Reserved");
			 * jta[selectedTab].print(header,footer,true,null,null,true); }
			 * catch(PrinterException ex){ System.out.println(ex); } catch(SecurityException
			 * ex){ System.out.println(ex); }
			 */
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.179"))) { //$NON-NLS-1$
			System.exit(0);
		}
        // action on  menu2
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.180")) || e.getSource() == b28) { //$NON-NLS-1$
			try {
				undoManager.undo();
			} catch (CannotRedoException cre) {
				cre.printStackTrace();
			}
			updateButtons();
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.181")) || e.getSource() == b29) { //$NON-NLS-1$
			try {
				undoManager.redo();
			} catch (CannotRedoException cre) {
				cre.printStackTrace();
			}
			updateButtons();
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.182")) || e.getSource() == item4) { //$NON-NLS-1$
			String deletedata = codeEditor[selectedTab + 1].getSelectedText();
			data = codeEditor[selectedTab + 1].getText();
			int pos = codeEditor[selectedTab + 1].getCaretPosition();
			if (deletedata != null) {
				String s2 = data.replace(deletedata, ""); //$NON-NLS-1$
				codeEditor[selectedTab + 1].setText(s2);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.184")) || e.getSource() == item5) { //$NON-NLS-1$
			codeEditor[selectedTab + 1].selectAll();
		}
        // UPPERCASE CHANGE
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.185")) || e.getSource() == item6) { //$NON-NLS-1$
			String selectedText = codeEditor[selectedTab + 1].getSelectedText();
			if (selectedText == null)
				return;
			selectedText = selectedText.toUpperCase();
			codeEditor[selectedTab + 1].replaceSelection(selectedText);
		}
        // lowercase change
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.186")) || e.getSource() == item7) { //$NON-NLS-1$
			String selectedText = codeEditor[selectedTab + 1].getSelectedText();
			if (selectedText == null)
				return;
			selectedText = selectedText.toLowerCase();
			codeEditor[selectedTab + 1].replaceSelection(selectedText);
		}
        // menu FIND
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.187")) || e.getSource() == b210) { //$NON-NLS-1$
			dialog = new JDialog(appFrame, AppConstants.getString("JavaEditorOne.188")); //$NON-NLS-1$
			p5 = new JPanel();
			jt1 = new JTextField(5);
			l51 = new JLabel(AppConstants.getString("JavaEditorOne.189")); //$NON-NLS-1$
			p5.add(l51);
			p5.add(jt1);
			b51 = new JButton(AppConstants.getString("JavaEditorOne.190")); //$NON-NLS-1$
			p5.add(b51);
			b51.addActionListener(this);
			b52 = new JButton(AppConstants.getString("JavaEditorOne.191")); //$NON-NLS-1$
			p5.add(b52);
			b52.addActionListener(this);
			p5.setLayout(new GridLayout(2, 2));

			dialog.add(p5);
			dialog.setResizable(false);
			dialog.setVisible(true);
			dialog.setSize(300, 100);
			dialog.setLocationRelativeTo(appFrame);
			findindexpre = codeEditor[selectedTab + 1].getCaretPosition();

		}

		if (e.getSource() == b51) {
			find = jt1.getText();
			data = codeEditor[selectedTab + 1].getText();
			int findlen = find.length();
			findindex = data.indexOf(find, findindexpre);
			findindexpre = findindex + findlen;
			int p0 = findindex;
			int p1 = findindex + findlen;
			if (findindex >= 0) {
				codeEditor[selectedTab + 1].requestFocus();
				codeEditor[selectedTab + 1].select(p0, p1);

			} else {
				dialog.dispose();
				JOptionPane.showMessageDialog(appFrame, AppConstants.getString("JavaEditorOne.192") + find, AppConstants.getString("JavaEditorOne.193"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == b52) {
			dialog.dispose();
		}

		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.194"))) { //$NON-NLS-1$

			data = codeEditor[selectedTab + 1].getText();
			int findlen = find.length();
			findindex = data.indexOf(find, findindexpre);
			int p0 = findindex;
			int p1 = findindex + findlen;
			if (findindex >= 0) {
				codeEditor[selectedTab + 1].requestFocus();
				codeEditor[selectedTab + 1].select(p0, p1);
				findindexpre = findindex + findlen;
			} else {
				JOptionPane.showMessageDialog(appFrame, AppConstants.getString("JavaEditorOne.195") + find, AppConstants.getString("JavaEditorOne.196"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.ERROR_MESSAGE);
			}

		}

		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.197"))) { //$NON-NLS-1$

			System.out.println(AppConstants.getString("JavaEditorOne.198") + find); //$NON-NLS-1$
//String find= jt1.getText();
			data = codeEditor[selectedTab + 1].getText();
			int findlen = find.length();

			findindexpre = codeEditor[selectedTab + 1].getCaretPosition();
			int p = findindexpre - findlen - 1;
			findindex = data.lastIndexOf(find, p);
			System.out.println(AppConstants.getString("JavaEditorOne.199") + findindexpre); //$NON-NLS-1$
			System.out.println(AppConstants.getString("JavaEditorOne.200") + findindex); //$NON-NLS-1$
			int p0 = findindex;
			int p1 = findindex + findlen;
			if (findindex >= 0) {

				codeEditor[selectedTab + 1].requestFocus();
				codeEditor[selectedTab + 1].select(p0, p1);

			} else {
				JOptionPane.showMessageDialog(appFrame, AppConstants.getString("JavaEditorOne.201") + find, AppConstants.getString("JavaEditorOne.202"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.203")) || e.getSource() == b211) { //$NON-NLS-1$
			System.out.println(AppConstants.getString("JavaEditorOne.204")); //$NON-NLS-1$
			dialog1 = new JDialog(appFrame, AppConstants.getString("JavaEditorOne.205")); //$NON-NLS-1$
			p6 = new JPanel();
			jt2 = new JTextField(5);
			jt3 = new JTextField(5);
			l61 = new JLabel(AppConstants.getString("JavaEditorOne.206")); //$NON-NLS-1$
			p6.add(l61);
			p6.add(jt2);
			l62 = new JLabel(AppConstants.getString("JavaEditorOne.207")); //$NON-NLS-1$
			p6.add(l62);
			p6.add(jt3);
			b61 = new JButton(AppConstants.getString("JavaEditorOne.208")); //$NON-NLS-1$
			b62 = new JButton(AppConstants.getString("JavaEditorOne.209")); //$NON-NLS-1$
			b63 = new JButton(AppConstants.getString("JavaEditorOne.210")); //$NON-NLS-1$
			b64 = new JButton(AppConstants.getString("JavaEditorOne.211")); //$NON-NLS-1$
			p6.add(b61);
			b61.addActionListener(this);
			p6.add(b62);
			b62.addActionListener(this);
			p6.add(b63);
			b63.addActionListener(this);
			p6.add(b64);
			b64.addActionListener(this);
			p6.setLayout(new GridLayout(4, 2));
			// int result=
			// JOptionPane.showConfirmDialog(null,p6,"Replace",JOptionPane.CLOSED_OPTION);
			dialog1.add(p6);
			dialog1.setResizable(false);
			dialog1.setVisible(true);
			dialog1.setSize(320, 180);
			dialog1.setLocationRelativeTo(appFrame);
			findindexprev = codeEditor[selectedTab + 1].getCaretPosition();

		}

		if (e.getSource() == b61) {
			find = jt2.getText();
			data = codeEditor[selectedTab + 1].getText();
			int findlen = find.length();
			findindex = data.indexOf(find, findindexprev);
			findindexprev = findindex + findlen;
			int p0 = findindex;
			int p1 = findindex + findlen;
			if (findindex >= 0) {
				codeEditor[selectedTab + 1].requestFocus();
				codeEditor[selectedTab + 1].select(p0, p1);

			} else {
				dialog1.dispose();
				JOptionPane.showMessageDialog(appFrame, AppConstants.getString("JavaEditorOne.212") + find, AppConstants.getString("JavaEditorOne.213"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == b62) {
			String findstr = "", replacestr = ""; //$NON-NLS-1$ //$NON-NLS-2$
			findstr = jt2.getText();
			char[] findstrchar = findstr.toCharArray();
			replacestr = jt3.getText();
			char[] replacestrchar = replacestr.toCharArray();
			data = codeEditor[selectedTab + 1].getText();
			char[] datachar = data.toCharArray();
			int findlen = findstr.length();
			int replacelen = replacestr.length();

			if (findindex >= 0) {
				if (findlen < replacelen) {
					for (int i = 0; i < findlen; i++) {
						datachar[findindex + i] = replacestrchar[i];
					}
					newdata = new String(datachar);
					StringBuilder s1 = new StringBuilder(newdata);
					for (int i = findlen; i < replacelen; i++) {
						s1.insert(i, replacestrchar[i]);
						newdata = new String(s1);
					}
					codeEditor[selectedTab + 1].setText(newdata);
					findindexprev = findindex + replacelen;
					findindex = data.indexOf(findstr, findindexprev);
					codeEditor[selectedTab + 1].select(findindex, findindex + findlen);
				}

				else if (findlen > replacelen) {
					System.out.println(AppConstants.getString("JavaEditorOne.216") + findindex); //$NON-NLS-1$
					for (int i = 0; i < replacelen; i++) {
						datachar[findindex + i] = replacestrchar[i];
					}
					newdata = new String(datachar);
					StringBuilder s1 = new StringBuilder(newdata);
					System.out.println(AppConstants.getString("JavaEditorOne.217") + newdata); //$NON-NLS-1$
					for (int i = findindex + replacelen; i < findindex + findlen; i++) {
						System.out.println("i= " + i); //$NON-NLS-1$
						s1.deleteCharAt(i);
						newdata = new String(s1);
					}
					findindexprev = findindex + replacelen;
					codeEditor[selectedTab + 1].setText(newdata);
					findindex = data.indexOf(findstr, findindexprev);
					codeEditor[selectedTab + 1].select(findindex, findindex + findlen);
				}

				else {
					for (int i = 0; i < findlen; i++) {
						datachar[findindex + i] = replacestrchar[i];
						newdata = new String(datachar);
					}
					findindexprev = findindex + replacelen;
					codeEditor[selectedTab + 1].setText(newdata);
					findindex = data.indexOf(findstr, findindexprev);
					codeEditor[selectedTab + 1].select(findindex, findindex + findlen);
				}

			} else {
				JOptionPane.showMessageDialog(appFrame, AppConstants.getString("JavaEditorOne.219") + find, AppConstants.getString("JavaEditorOne.220"), //$NON-NLS-1$ //$NON-NLS-2$
						JOptionPane.ERROR_MESSAGE);
			}

			/*
			 * char[] replacestrchar= replacestr.toCharArray(); data=
			 * jta[selectedTab+1].getText(); String s2=data.replace(findstr,replacestr);
			 * jta[selectedTab+1].setText(s2);
			 */
		}
		if (e.getSource() == b63) {
			String findstr = "", replacestr = ""; //$NON-NLS-1$ //$NON-NLS-2$
			findstr = jt2.getText();
			replacestr = jt3.getText();
			data = codeEditor[selectedTab + 1].getText();
			String s2 = data.replace(findstr, replacestr);
			codeEditor[selectedTab + 1].setText(s2);
		}
		if (e.getSource() == b64) {
			dialog1.dispose();
		}
        // goto action------
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.223"))) { //$NON-NLS-1$
			dialog2 = new JDialog(appFrame, AppConstants.getString("JavaEditorOne.224")); //$NON-NLS-1$
			p7 = new JPanel();
			tf4 = new JTextField();
			l71 = new JLabel(AppConstants.getString("JavaEditorOne.225")); //$NON-NLS-1$
			l72 = new JLabel("" + ln[selectedTab + 1]); //$NON-NLS-1$
			p7.add(l71);
			p7.add(l72);
			l72 = new JLabel(AppConstants.getString("JavaEditorOne.227")); //$NON-NLS-1$
			p7.add(l72);
			p7.add(tf4);
			b71 = new JButton(AppConstants.getString("JavaEditorOne.228")); //$NON-NLS-1$
			b72 = new JButton(AppConstants.getString("JavaEditorOne.229")); //$NON-NLS-1$
			p7.add(b71);
			b71.addActionListener(this);
			p7.add(b72);
			b72.addActionListener(this);
			String s = tf4.getText();
			p7.setLayout(new GridLayout(3, 2));
			// int result=
			// JOptionPane.showConfirmDialog(null,p6,"Replace",JOptionPane.CLOSED_OPTION);
			dialog2.add(p7);
			dialog2.setResizable(false);
			dialog2.setVisible(true);
			dialog2.setSize(320, 150);
			dialog2.setLocationRelativeTo(appFrame);
		}
		if (e.getSource() == b71) {
			String s = tf4.getText();
			try {
				gotoValue = Integer.parseInt(s);
				try {
					int k = codeEditor[selectedTab + 1].getLineStartOffset(gotoValue - 1);
					System.out.println(k);
					codeEditor[selectedTab + 1].setCaretPosition(k);
					dialog2.dispose();
				} catch (Exception ex) {
				}
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, AppConstants.getString("JavaEditorOne.230")); //$NON-NLS-1$
			}
		}
		if (e.getSource() == b72) {
			dialog2.dispose();
		}
        // action on  menu 4
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.231"))) { //$NON-NLS-1$
			appFrame.setExtendedState(6);
			appFrame.setVisible(true);
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.232")) || e.getSource() == b212) { //$NON-NLS-1$
			size = size + 2;
			Font displayFont = new Font(AppConstants.getString("JavaEditorOne.233"), Font.PLAIN, size); //$NON-NLS-1$
			codeEditor[selectedTab + 1].setFont(displayFont);
			sectionForShowingFileRows[selectedTab + 1].setFont(displayFont);
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.234")) || e.getSource() == b213) { //$NON-NLS-1$
			size = size - 2;
			Font displayFont = new Font(AppConstants.getString("JavaEditorOne.235"), Font.PLAIN, size); //$NON-NLS-1$
			codeEditor[selectedTab + 1].setFont(displayFont);
			sectionForShowingFileRows[selectedTab + 1].setFont(displayFont);
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.236"))) { //$NON-NLS-1$
			size = 16;
			Font displayFont = new Font(AppConstants.getString("JavaEditorOne.237"), Font.PLAIN, size); //$NON-NLS-1$
			codeEditor[selectedTab + 1].setFont(displayFont);
			sectionForShowingFileRows[selectedTab + 1].setFont(displayFont);
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.238"))) { //$NON-NLS-1$
			if (tabbedPane.getTabCount() >= 1) {
				tabbedPane.setSelectedIndex(0);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.239"))) { //$NON-NLS-1$
			if (tabbedPane.getTabCount() >= 2) {
				tabbedPane.setSelectedIndex(1);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.240"))) { //$NON-NLS-1$
			if (tabbedPane.getTabCount() >= 3) {
				tabbedPane.setSelectedIndex(2);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.241"))) { //$NON-NLS-1$
			if (tabbedPane.getTabCount() >= 4) {
				tabbedPane.setSelectedIndex(3);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.242"))) { //$NON-NLS-1$
			if (tabbedPane.getTabCount() >= 5) {
				tabbedPane.setSelectedIndex(5);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.243"))) { //$NON-NLS-1$

			if (tabbedPane.getSelectedIndex() < tabbedPane.getTabCount() - 1) {

				tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex() + 1);
			}

		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.244"))) { //$NON-NLS-1$
			if (tabbedPane.getSelectedIndex() > 0) {
				tabbedPane.setSelectedIndex(tabbedPane.getSelectedIndex() - 1);
			}
		}
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.245"))) { //$NON-NLS-1$
			System.out.println(AppConstants.getString("JavaEditorOne.246") + fileName[selectedTab + 1]); //$NON-NLS-1$
			System.out.println(AppConstants.getString("JavaEditorOne.247") + path[selectedTab + 1]); //$NON-NLS-1$
			String s = codeEditor[selectedTab + 1].getText();
			byte[] bytes = s.getBytes();
			try {
				System.out.println(AppConstants.getString("JavaEditorOne.248") + bytes.length); //$NON-NLS-1$
			} catch (Exception ex) {
				System.out.println(ex);
			}
			int length = s.length();
			System.out.println(AppConstants.getString("JavaEditorOne.249") + length); //$NON-NLS-1$
			int line = codeEditor[selectedTab + 1].getLineCount();
			System.out.println(AppConstants.getString("JavaEditorOne.250") + line); //$NON-NLS-1$
			String s1 = s.trim();
			int trimcount = s1.length();
			System.out.println(AppConstants.getString("JavaEditorOne.251") + trimcount); //$NON-NLS-1$
			JPanel jp = new JPanel();
			JTextArea ta = new JTextArea(AppConstants.getString("JavaEditorOne.252") + fileName[selectedTab + 1] + "\n" + AppConstants.getString("JavaEditorOne.254") //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					+ path[selectedTab + 1] + "\n" + AppConstants.getString("JavaEditorOne.256") + bytes.length + "\n" + "\n" + AppConstants.getString("JavaEditorOne.259") + line //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
					+ "\n" + AppConstants.getString("JavaEditorOne.261") + length + "\n" + AppConstants.getString("JavaEditorOne.263") + trimcount); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
			ta.setEditable(false);
//JLabel l2=new JLabel("File Name: "+fileName[selectedTab+1]+"\n"+"Path: "+path[selectedTab+1] );
			jp.add(ta);
			JOptionPane.showMessageDialog(appFrame, jp, AppConstants.getString("JavaEditorOne.264"), JOptionPane.PLAIN_MESSAGE, null); //$NON-NLS-1$
		}
        // menu run
		if (e.getSource() == mir1 || e.getSource() == b214) {
			System.out.println(AppConstants.getString("JavaEditorOne.265")); //$NON-NLS-1$
			compileFile();
		}
		if (e.getSource() == menuRun_Run || e.getSource() == b215) {
			runFile();
		}
		if (e.getSource() == menuRun_CompileAndRun || e.getSource() == b216) {
			compileFile();
			String s = ta[selectedTab + 1].getText();
			if (s.equals(AppConstants.getString("JavaEditorOne.266"))) { //$NON-NLS-1$
				runFile();
			}
		}
        // action on  menu 5
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.267"))) { //$NON-NLS-1$
		}
        // help menu action
		if (e.getActionCommand().equals(AppConstants.getString("JavaEditorOne.268"))) { //$NON-NLS-1$
			showShortCuts();
		}
	}

}