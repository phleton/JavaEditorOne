import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoManager;
import static java.awt.event.KeyEvent.VK_F1;/*0x70*/
import static java.awt.event.KeyEvent.VK_F2;/*0x71*/
import static java.awt.event.KeyEvent.VK_F3;/*0x72*/
import static java.awt.event.KeyEvent.VK_F4;/*0x73*/
import static java.awt.event.KeyEvent.VK_F5;/*0x73*/
import static java.awt.event.KeyEvent.VK_F6;/*0x73*/
import static java.awt.event.KeyEvent.VK_F7;/*0x73*/
import static java.awt.event.KeyEvent.VK_F8;/*0x73*/
import static java.awt.event.KeyEvent.VK_F9;/*0x73*/
import static java.awt.event.KeyEvent.VK_F10;/*0x73*/
import static java.awt.event.KeyEvent.VK_F11;/*0x73*/
import static java.awt.event.KeyEvent.VK_F12;/*0x73*/
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_B;
import static java.awt.event.KeyEvent.VK_C;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_G;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_O;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_U;
import static java.awt.event.KeyEvent.VK_W;
import static java.awt.event.KeyEvent.VK_X;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_Z;
import static java.awt.event.KeyEvent.VK_SUBTRACT;
import static java.awt.event.KeyEvent.VK_ADD;
import static java.awt.event.ActionEvent.CTRL_MASK;
import static java.awt.event.ActionEvent.ALT_MASK;
import static java.awt.event.ActionEvent.SHIFT_MASK;
/**
 * The Java Editor One (Kapur Edition)
 * 
 * @author Kapil Kumar (original author)
 * @author Kais el Kara (reviewer, refactorer)
 * @date 12/2018
 * @version 0.0.0
 * @lastmodified 24. Oktober 2019 um 16:51:53 KartagoTimezone
 * @revision Fr,17APR2020>20:50>17APR2020CRISTOS>added>Font>JavaConsole
 * @revision Fr,17APR2020>21:06>17APR2020CRISTOS>changed>defaultDirectory>EditorFileChooser>InOrderToWork
 * @revision Fr,17APR2020>21:10-37>17APR2020CRISTOS>optimization>removing>blanksYUnneccessarBytes
 * @revision Fr,17APR2020>22:00-23:15>17APR2020CRISTOS>codeCompression+optimization
 * @revision Sa,18APR2020>12:49-13:55-14:28,SAVD§14h55m59s§>18APR2020CRISTOS>Todo Keyboard[Control+O]>optimization[DONE]>operation[verkuerzt[OP]]
 * @revision Di,21APR2020:18h51mn55sec>implemented>keyboardShortcut
 * @revision Di,21APR2020:19h29mn>added>MenuGOTO+multiKeys
 * @revision Di,21APR2020:19h30mn14s>saved
 * @revision Mi,22APR2020:13:30>open4Change+DialogNewFile[addedRadioButtons]+DialogGoto[LabelCloseButton]
 * @revision Mi,22APR2020:15:17>open4Change+[JavaEngine::optimization]+[JavaEngine::Support4Python]
 * @revision Mi,22. April 2020 um 15:32:57>SAVD
 * @revision Mi,22. April 2020 um 22:59:56>SAVD
 * @revision Do,23. April 2020 um 10:30:00>NewFilePythonRadioButton>PyTemplate>
 * @revision Do,23. April 2020 um 11:36:34>SAVD
 * @revision Do,23. April 2020 um 16:04:00>OPND
 * 
 * @revision 11/2018
 *           <ul>
 *           <li>lookup and first try to improve the JavaEditorOne-v0</li>
 *           </ul>
 * @revision 01-12,23.12.2018
 *           <ul>
 *           <li>Creation of version 0.0.0 (single Java editor class)</li>
 *           <li>Creation of version 0.0.1 (suite)</li>
 *           <li>Creation of a bash script to save, package the different
 *           app-versions</li>
 *           <li>Refactoring, improvement, code adjustment and
 *           minimization.</li>
 *           <li>Pushing all string labels, texts, etc. to the property
 *           file.</li>
 *           <li>Generalization of the menu/toolbar creation using "phleton core
 *           library"</li>
 *           <li>Memory lookup of the application</li>
 *           </ul>
 * @internal 0.0.0.0
 * @comment What we learned from this code:<br>
 *          <ol>
 *          <li>We renamed the file from Edit1 to JavaEditorOne.</li>
 *          <li>We named the application "Java Editor One - Kapur Edition"</li>
 *          <li>We removed, corrected mistakes while keeping the original source
 *          code, however we refactored alot.
 *          <ul>
 *          <li>The visibility of the class was originally per default package,
 *          which cannot let us export it in the jar file as main application,
 *          that is why we set the visibility to public.</li>
 *          <li>We moved the file under the source folder src.</li>
 *          <li>We changed the package import to import only the requested
 *          classes. We dont want to import everything from the requested
 *          package, we want only to import the classes that we want to use to
 *          save memory and resources when launching the application.</li>
 *          <li>Not used class imports were removed since the Eclipse-IDE
 *          display warning messages.</li>
 *          </ul>
 *          <li>We corrected the java path to let us compile and run the java
 *          code.</li>
 *          <li>We renamed the variable-names, to let us understand what the
 *          variables are used for. We also removed alot of them. Also, in the
 *          Eclipse-IDE there is a function called rename, which can let you
 *          rename a variable, by selecting the variable and pressing
 *          ALT+COMMAND+R, or just right click and goto refactor->rename. The
 *          renaming of the variable is propagated to all occurrences of the
 *          variables in the code, and this will save you a huge amount of
 *          time.</li>
 *          <li>We moved all coding that handle command action into separate
 *          methods for each action, to have a separated logic and modularity in
 *          the application. For doing this operation, we used the function
 *          inside Eclipse IDE (Toggle Split Editor (Vertical)) to be able to
 *          refactor this more quickly. After this operation, in the
 *          Outline-view we can jump quickly into the desired method to review
 *          the methods, check the source code, improve it, and possible remove
 *          the method.</li>
 *          <li>We unified the creation of menu and created Objects for that
 *          purpose</li>
 *          <li>We discovered that "Kapil" is using a lot of arrays to try to
 *          make his understanding and ideas of the Java Editor work. We think
 *          that "Kapil" should have used Objects for that purpose. In the
 *          future, we recommend him to always use Objects and Objected-Oriented
 *          Programming, if he has difficulty to solve his problem. We did use
 *          objects to display lines for the editor.</li>
 *          <li>The big breakthrough was to use a separate JavaEditor which is
 *          implemented as an interface, and can be reimplemented depending the
 *          UI-Toolkit (Swing, FX, Eclipse-RCP)</li>
 *          <li>We moved most of the strings to properties files, which separate
 *          the language of the application from its code, and let us in the
 *          future display the application in different languages.</li>
 *          </ol>
 */
public class JavaEditorOne extends JFrame {
	private static final long serialVersionUID=3616628158040079811L;
	private static final int APP_WIDTH=1024;private static final int APP_HEIGHT=768;
	private static final int APP_EXTSTATE=JFrame.MAXIMIZED_BOTH;
	private static final Color APP_BACKGROUND=new Color(255,255,255);
	/*---------- ----------*/
	// 1. Please use as less global variables as possible.
	// 2. Avoid also using arrays and use objects instead. Using arrays will make the source code difficult
	// to understand and it will be more difficult to improve the application.
	/*---------- ----------*/
	private static JavaEditorOne javaEditorOneInstance;
	private AppBundle appBundle;
	/*Window*/private JFrame appFrame;
	/*TabbedManager*/private JTabbedPane appTabManager=new JTabbedPane();
	/*---------- ----------*/
	/*ApplicationLogger*/private AppLogger appLogger;
	/*JavaEngine*/private JavaEngine javaFramework;/*framework responsible for compile, run a Java file*/
	/*FileManager*/private FileManager fileManager;/*responsible for reading, writing files*/
	/*Undo Manager*/private UndoManager undoManager;
	/*ActionListener*/private JavaEditorActionListener actionListener;
	/*---------- ----------*/
	/**JavaEditors*/private List<IJavaEditor> openedJavaEditors;
	/*---------- ----------*/
	/**Panels::/*should stay empty*/
	/**Textfield and Textarea::/*should stay empty*/
	/**Labels::/*should stay empty*/
	/**Buttons::/*should stay empty*/
	/*---------- ----------*/
	private DIAFindDialog findDialog;
	private DIAFindReplaceDialog dialogForFindReplace;
	/*---------- ----------*/
	private int globalCurrActiveEditor=-1, globalCurrSelectedTab=0;
	private int globalIndIdx=0, globalNtNeededRevFindIndex=0;
	private String fileName=""; //$NON-NLS-1$
	private String editorData, newStringData;
	private String arrayForPath[]=new String[10];
	private String arrayForFileNames[]=new String[10];
	/*---------- ----------*/
	/**main entry for the "Java Editor One" application
	 * @param args arguments
	 */
	public static void main(String[] args){JavaEditorOne javaEditor=new JavaEditorOne();javaEditor.show();}
	/**Shows the application*/
	public void show(){appFrame.setBackground(APP_BACKGROUND);
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setSize(APP_WIDTH, APP_HEIGHT);appFrame.setExtendedState(APP_EXTSTATE);
		appFrame.pack();appFrame.setVisible(true);
	}
	/**
	 * Constructor
	 */
	public JavaEditorOne(){/**initFrameworks*/
		/*setAppInstance*/javaEditorOneInstance=this;
		/*NWAppBundle*/appBundle=new AppBundle();
		/*NWAppLogger*/appLogger=new AppLogger();
		/*NWFileManager*/fileManager=new FileManager(appLogger);
		/*CREAjavaEngine*/javaFramework=new JavaEngine(appLogger);
		/*CREAeditors*/openedJavaEditors=new ArrayList<IJavaEditor>();
		/*NWActionListener*/actionListener=new JavaEditorActionListener();
		/*NWChangeListener->MouseEvents*/appTabManager.addChangeListener(new JavaEditorChangeListener());
		/*createWindow*/appFrame=new JFrame(AppConstants.APP_NAME);
		appFrame.setLayout(new BorderLayout());
		/*CREAMenu*/appFrame.setJMenuBar(createMenu());
		/*CREAToolbar*/appFrame.add(createToolBar(), BorderLayout.NORTH);
	}
	// -------------------------------------------------- //
	private JMenuBar createMenu(){
		// @formatter:off
		return Factorys.createMenuBar(
				new String[][]{
					// MENU BAR : the menu bar of the application will look like follows:
					/**
					{ "File", "Edit", "Search", "View", "Run", "Settings", "Recording", "Encoding", "Help" },
					*/        
					// menu FILE: this part creates the items of the menu File
					/**
					{ "New", "Open", "Save", "Save As..", "Rename", "Close", "Close All", "Print", "Exit" },
					*/
					// menu GO
					/**
					{ "Goto" },
					*/
					// menu EDIT: this part creates the items of the menu Edit
					/**
					{ "Undo", "Redo", "Cut", "Copy", "Paste", "Delete", "Select All", "Convert Case To", "UPPER CASE", "LOWER CASE" },
					*/
					//menu WORD::{'UpperCase','LowerCase'}
					// menu SEARCH: this part creates the items of the menu Search
					/**
					{ "Find", "Find_Next", "Find Previous", "Replace", "Goto" },
					*/
					// menu VIEW: this part creates the items of the menu View
					/**
					{ "Full Screen Mode", "Zoom In", "Zoom Out", "Restore Default Zoom", "Tab", "Summary..." },
					*/
					// menu RUN: this part creates the items of the menu Run
					/**
					{ "Compile", "Run", "Compile and Run" },
					*/
					// menu SETTINGS: this part creates the items of the menu Settings
					/**
					{ "Style Configurator..." },
					*/
					// menu RECORDING: this part creates the items of the menu Recording
					/**
					{ "Start Recording", "Pause Recording", "Stop Recording", "Save Recording" },
					*/
					// menu ENCODING: this part creates the items of the menu Encoding
					/**
					{ "Encode k1", "Encode k2", "Encode k3" },
					*/
					// menu HELP: this part creates the items of the menu Help
					/**
					{ "Shortcuts", "About Us!" },	
					*/
					// MENU BAR : the menu bar of the application will look like follows:
					{ AppConstants.get(AppBundle.MENU_FILE),
					  AppConstants.get(AppBundle.MENU_GOTO),
					  AppConstants.get(AppBundle.MENU_EDIT),
					  AppConstants.get(AppBundle.MENU_WORD),
					  AppConstants.get(AppBundle.MENU_SEARCH),
					  AppConstants.get(AppBundle.MENU_VIEW),
					  AppConstants.get(AppBundle.MENU_RUN),
					  AppConstants.get(AppBundle.MENU_SETTINGS),
//					  AppConstants.$(MENU_RECORDING), AppConstants.$(MENU_ENCODING),
					  AppConstants.get(AppBundle.MENU_HELP)
					},       
					// menu FILE: this part creates the items of the menu File
					{ AppConstants.get(AppBundle.MENU_FILE_NEW), AppConstants.get(AppBundle.MENU_FILE_OPEN), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_FILE_SAVE), AppConstants.get(AppBundle.MENU_FILE_SAVE_AS), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_FILE_RENAME), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_FILE_CLOSE), AppConstants.get(AppBundle.MENU_FILE_CLOSE_ALL), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_FILE_PRINT), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_FILE_EXIT)
					},
					  // COMMANDS
					{ AppCommands.CMD_NEW_FILE, AppCommands.CMD_OPEN_FILE, AppBundle.MENU_SEPARATOR,
					  AppCommands.CMD_SAVE_FILE, AppCommands.CMD_SAVE_AS_FILE, AppBundle.MENU_SEPARATOR,
					  AppCommands.CMD_RENAME_FILE, AppBundle.MENU_SEPARATOR,
					  AppCommands.CMD_CLOSE_FILE, AppCommands.CMD_CLOSE_ALL_FILES, AppBundle.MENU_SEPARATOR,
					  AppCommands.CMD_PRINT,  AppBundle.MENU_SEPARATOR,
					  AppCommands.CMD_EXIT
					},
					//TODO DONE[MKK::21APR202019h09mn]
					/*menu GO*/{AppConstants.get(AppBundle.MENU_SEARCH_GOTO)},/*GOTO COMMANDS*/{AppCommands.CMD_GOTO},
					
					// menu EDIT: this part creates the items of the menu Edit
					{ AppConstants.get(AppBundle.MENU_EDIT_UNDO), AppConstants.get(AppBundle.MENU_EDIT_REDO), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_EDIT_CUT), AppConstants.get(AppBundle.MENU_EDIT_COPY), AppConstants.get(AppBundle.MENU_EDIT_PASTE), AppConstants.get(AppBundle.MENU_EDIT_DELETE), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_EDIT_SELECT_ALL), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_EDIT_CONVERT_CASE_TO), AppConstants.get(AppBundle.MENU_EDIT_UPPERCASE), AppConstants.get(AppBundle.MENU_EDIT_LOWERCASE)
					},
					  // COMMANDS
					{ AppCommands.CMD_UNDO, AppCommands.CMD_REDO, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_CUT, AppCommands.CMD_COPY, AppCommands.CMD_PASTE, AppCommands.CMD_DELETE, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_SELECT_ALL, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_CONVERT_CASE_TO, AppCommands.CMD_UPPERCASE, AppCommands.CMD_LOWERCASE
					},
					
					//TODO DONE[MKK::22APR202015h24(30)mn]
					/*menu WORD*/{AppConstants.get(AppBundle.MENU_EDIT_CONVERT_CASE_TO),AppBundle.MENU_SEPARATOR,AppConstants.get(AppBundle.MENU_EDIT_UPPERCASE),AppConstants.get(AppBundle.MENU_EDIT_LOWERCASE)},
					/*menu WORD*/{AppCommands.CMD_CONVERT_CASE_TO,AppBundle.MENU_SEPARATOR,AppCommands.CMD_UPPERCASE, AppCommands.CMD_LOWERCASE},
					
					// menu SEARCH: this part creates the items of the menu Search
					{ AppConstants.get(AppBundle.MENU_SEARCH_FIND), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_SEARCH_FIND_NEXT), AppConstants.get(AppBundle.MENU_SEARCH_FIND_PREVIOUS), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_SEARCH_REPLACE), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_SEARCH_GOTO)
					},{ AppCommands.CMD_FIND, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_FIND_NEXT, AppCommands.CMD_FIND_PREVIOUS, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_REPLACE, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_GOTO
					},
					// menu VIEW: this part creates the items of the menu View
					{ AppConstants.get(AppBundle.MENU_VIEW_FULLSCREEN), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_VIEW_ZOOM_IN), AppConstants.get(AppBundle.MENU_VIEW_ZOOM_OUT), AppConstants.get(AppBundle.MENU_VIEW_ZOOM_RESTORE), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_VIEW_TAB), AppConstants.get(AppBundle.MENU_VIEW_SUMMARY)
					},{AppCommands.CMD_FULLSCREEN, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_ZOOM_IN, AppCommands.CMD_ZOOM_OUT, AppCommands.CMD_ZOOM_RESTORE, AppCommands.CMD_EMPTY,
					  AppCommands.CMD_TAB_SELECTION, AppCommands.CMD_SUMMARY, AppCommands.CMD_EMPTY,
					},
					// menu RUN: this part creates the items of the menu Run
					{ AppConstants.get(AppBundle.MENU_RUN_COMPILE), AppConstants.get(AppBundle.MENU_RUN_RUN), AppConstants.get(AppBundle.MENU_RUN_COMPILE_AND_RUN) },
					  /*COMMANDS*/{AppCommands.CMD_COMPILE,AppCommands.CMD_RUN,AppCommands.CMD_COMPILE_AND_RUN
				    },
					// menu SETTINGS: this part creates the items of the menu Settings
					{AppConstants.get(AppBundle.MENU_SETTINGS_CONFIG_STYLE)},
					{AppCommands.CMD_CONFIG_STYLE},
//					// menu RECORDING: this part creates the items of the menu Recording
//					{ AppConstants.$(AppBundle.MENU_RECORDING_RECORD_START), AppConstants.$(AppBundle.MENU_RECORDING_RECORD_PAUSE), AppConstants.$(AppBundle.MENU_RECORDING_RECORD_STOP), AppConstants.$(AppBundle.MENU_RECORDING_RECORD_SAVE)
//					},
//					/*COMMANDS*/{ AppCommands.CMD_RECORD_START, AppCommands.CMD_RECORD_PAUSE, AppCommands.CMD_RECORD_STOP, AppCommands.CMD_RECORD_SAVE },
//					// menu ENCODING: this part creates the items of the menu Encoding
//					{ AppConstants.$(AppBundle.MENU_ENCODING_ENCODE1), AppConstants.$(AppBundle.MENU_ENCODING_ENCODE2), AppConstants.$(AppBundle.MENU_ENCODING_ENCODE3)
//					},
//					// COMMANDS
//					{ AppCommands.CMD_ENCODE1, AppCommands.CMD_ENCODE2, AppCommands.CMD_ENCODE3
//					},
					// menu HELP: this part creates the items of the menu Help
					{ AppConstants.get(AppBundle.MENU_HELP_SHORTCUTS), AppBundle.MENU_SEPARATOR,
					  AppConstants.get(AppBundle.MENU_HELP_ABOUTUS)
					},/*COMMANDS*/{AppCommands.CMD_SHORTCUTS, AppCommands.CMD_EMPTY,AppCommands.CMD_ABOUTUS},
					},
				this.actionListener);
		// @formatter:on
	}
	/**
	 * Creates the toolbar of the application
	 * @return toolbar the application toolbar
	 */
	private JToolBar createToolBar(){
		//@formatter:off
		JToolBar toolBar=Factorys.createToolbar(
		new Object[][]{
			{ "new","open","save","save as..","close","close all","zoom in","zoom out",
			  "compile","run","compile & run"
			},
			/*tooltips*/
			{ "new", "open", "save", "saveas", "close editor", "",
			  AppConstants.get(AppBundle.BTN_ZOOM_IN_TOOLTIP), AppConstants.get(AppBundle.BTN_ZOOM_OUT_TOOLTIP),
			  "", "", ""
			},
			/*icons*/
			{ AppConstants.iconNewFile, AppConstants.iconOpenFile, AppConstants.iconSaveFile, AppConstants.iconSaveAs, AppConstants.iconClose, AppConstants.iconCloseAll,
			  AppConstants.iconZoomIn, AppConstants.iconZoomOut,
			  AppConstants.iconCompile, AppConstants.iconRun, AppConstants.iconCompileAndRun
			},
			/*commands*/
			{ AppCommands.CMD_NEW_FILE, AppCommands.CMD_OPEN_FILE, AppCommands.CMD_SAVE_FILE, AppCommands.CMD_SAVE_AS_FILE, AppCommands.CMD_CLOSE_FILE, AppCommands.CMD_CLOSE_ALL_FILES,
			  AppCommands.CMD_ZOOM_IN, AppCommands.CMD_ZOOM_OUT,
			  AppCommands.CMD_COMPILE, AppCommands.CMD_RUN, AppCommands.CMD_COMPILE_AND_RUN
			}
		},
		this.actionListener
		);//@formatter:on
		toolBar.setMargin(new Insets(0,0,0,0));
		toolBar.setRollover(false);toolBar.setFloatable(true);
		return toolBar;
	}
	/**
	 * For creating a new file
	 * @param parFileName
	 */
	private boolean createNewFile(String parFileName){/*Create NewJavaEditor&AssignToTemplate*/
		arrayForFileNames[globalCurrActiveEditor]=parFileName;
		arrayForPath[globalCurrActiveEditor]=parFileName;
		try {if(parFileName.equals("")){return false;}
			/*choose a template*/DIATemplateChooserDialog dialog=new DIATemplateChooserDialog(this.appFrame);
			int templateId=dialog.showDialog();
			if (templateId<1){return false;}
			String fileNameWithoutExtension=parFileName;
			//if (parFileName.endsWith(".java")){fileNameWithoutExtension=parFileName.substring(0, parFileName.indexOf("."));}
			fileNameWithoutExtension=parFileName.substring(0,parFileName.indexOf("."));
			/*open the file in the editor*/
			this.getCurrentActiveJavaEditor().createAndOpenFile(this.fileManager,parFileName,
					templateForNewJavaFile(fileNameWithoutExtension, templateId));
			/*set up the information of the console and the status bar*/
			setUpStatusBar(globalCurrActiveEditor);
			/*append the Java editor and its lines*/
			JComponent editorComponent=(JComponent) this.getCurrentActiveJavaEditor().getObservable();
			appTabManager.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			appTabManager.addTab(parFileName, AppConstants.iconSaveFile, editorComponent,
					arrayForPath[globalCurrActiveEditor]);
			appTabManager.setSelectedIndex(appTabManager.getTabCount()-1);
			appFrame.add(appTabManager);appFrame.setExtendedState(APP_EXTSTATE);
			appFrame.setVisible(true);
		}catch(IOException e){e.printStackTrace();return false;}
		return true;
	}
	/**This function open a selected file*/
	private void op01OpenFile(){enableToolbar(true);
		EditorFileChooser fileChooser=new EditorFileChooser(appFrame);
		int fileChooserState=fileChooser.showDialog();
		if (fileChooserState==JFileChooser.APPROVE_OPTION){
			File file=fileChooser.getSelectedFile();
			fileName=fileChooser.getName(file);
			try{createJavaEditor();
				arrayForFileNames[globalCurrActiveEditor]=fileName;
				arrayForPath[globalCurrActiveEditor]=file.getAbsolutePath();
				getCurrentActiveJavaEditor().openFile(file);
				if (getCurrentActiveJavaEditor().isOpened()) {
					appTabManager.addTab(fileName, AppConstants.iconSaveFile,
						(JComponent) getCurrentActiveJavaEditor().getObservable(),
						arrayForPath[globalCurrActiveEditor]);
					appTabManager.setSelectedIndex(appTabManager.getTabCount()-1);
					appFrame.add(appTabManager);
					appFrame.setExtendedState(APP_EXTSTATE);
					appFrame.setVisible(true);
				}
			}catch (IOException ex){JOptionPane.showMessageDialog(appFrame,"File Not Found", "ERROR",JOptionPane.ERROR_MESSAGE);/*$NON-NLS-1$$NON-NLS-2$*/}
		}
	}
	/**CreateNewJavaEditor*/
	private void createJavaEditor(){boolean isAdded=openedJavaEditors.add(new JavaEditor());
		if(isAdded){globalCurrActiveEditor=openedJavaEditors.size()-1;}
	}
	/**
	 * GettingCurrentActiveJavaEditor
	 * @return ActiveEditor
	 */
	private IJavaEditor getCurrentActiveJavaEditor(){
		if(openedJavaEditors==null){throw new RuntimeException("Something wrong in here !!! -> The object for JavaEditor is nullable!");}
		if(globalCurrActiveEditor>=0 && globalCurrActiveEditor<openedJavaEditors.size()){
			return openedJavaEditors.get(globalCurrActiveEditor);
		}else{appLogger.errorHighlighted("the current active editor is wrong: "+globalCurrActiveEditor);}
		return null;
	}
	private void enableToolbar(boolean enable){/*TODO KAISELenableToolbar*/}
	/**open NewJavaFile4Editing*/
	private void op00NewFile(){DIANewFileDialog dialog=new DIANewFileDialog(appFrame);
	 if (dialog.showDialog()==JOptionPane.OK_OPTION){
		String fileExtension=".";fileName=dialog.getFileName();
		     if(dialog.isJavaSelected())  {fileExtension+=AppConstants.FILE_EXTENSION_JAVA;}
		else if(dialog.isSelectedPython()){fileExtension+=AppConstants.FILE_EXTENSION_PYTHON;}
		else if(dialog.isSelectedHTML())  {fileExtension+=AppConstants.FILE_EXTENSION_HTML;}
		else{fileExtension+="garbage";}
		fileName+=fileExtension;
		this.createJavaEditor();createNewFile(fileName);enableToolbar(true);
	 }
	}
	/*private void op01OpenFile(){enableToolbar(true);openFile();}*/
	private void op02SaveFile(){String fileContent=this.getCurrentActiveJavaEditor().getJavaCode();
		fileManager.writeJavaFileInWorkspace(fileName,fileContent);
	}
	private void op03SaveAs(){JFileChooser jfc=new JFileChooser();
		int x=jfc.showSaveDialog(null);
		if (x==JFileChooser.APPROVE_OPTION){
			boolean isSaved=this.getCurrentActiveJavaEditor().saveFile(jfc.getSelectedFile());
			if(!isSaved){JOptionPane.showMessageDialog(appFrame, "File Not Found", "ERROR", JOptionPane.ERROR_MESSAGE);/*$NON-NLS-1$$NON-NLS-2$*/}
		}if(x==JFileChooser.CANCEL_OPTION){appLogger.infoHighlighted("cancel");/*$NON-NLS-1$*/}
	}
	private void op04Rename(){new DIARenameFileDialog(appFrame, fileName).showDialog();}
	private void op05CloseFile(){appTabManager.removeTabAt(appTabManager.getSelectedIndex());
		/*this.getConsole(currSelectedTab).setVisible(false);*/
		globalCurrActiveEditor--;if(globalCurrActiveEditor<1){enableToolbar(false);}
	}
	private void op06CloseAll(){appTabManager.removeAll();globalCurrActiveEditor=0;enableToolbar(false);}
	private void operationPrint(){/*TODO NADOR 06DEZ2018 implementPrintFunction*/
		try{MessageFormat tableHeader=new MessageFormat("JavaEditorOne"); //$NON-NLS-1$
			MessageFormat tableFooter=new MessageFormat("This Software is licensed unter the EARTH LICENSE v1.0 (c) Copyright 2018"); //$NON-NLS-1$
			final Object[] header={tableHeader};
			final Object[][] data={{tableFooter}};
			JTable jtable=new JTable(data,header);
			jtable.print();
		}catch(PrinterException ex) {appLogger.severe(ex);}
	}
	private void op0iExit(){appFrame.setVisible(false);appFrame.dispose();System.exit(0);}
	private void opUndoRedoUndo(){opUndoRedo(0);}
	private void opUndoRedoRedo(){opUndoRedo(1);}
	private boolean opUndoRedo(int idx){
		try{if(idx==0){undoManager.undo();updateUndoRedoButtons();}/*TODO MKK18APR2020*/
			if(idx==1){undoManager.redo();updateUndoRedoButtons();}
		}catch(CannotRedoException parEx){appLogger.fatal(parEx);return false;}
		return true;
	}
	public void updateUndoRedoButtons(){/*btnUndo.setEnabled(undoManager.canUndo());
		btnRedo.setEnabled(undoManager.canRedo());
		menuEdit_UNDO.setEnabled(undoManager.canUndo());
		menuEdit_REDO.setEnabled(undoManager.canRedo());*/
	}
	private void opDeleteFile(){String deletedata=this.getCurrentActiveJavaEditor().getSelectedJavaCode();
		editorData=this.getCurrentActiveJavaEditor().getJavaCode();
		this.getCurrentActiveJavaEditor().getCaretPosition();
		if(deletedata!=null){String s2=editorData.replace(deletedata,"");/*$NON-NLS-1$*/
			this.getCurrentActiveJavaEditor().setJavaCode(s2);
		}
	}
	private void opSelectAll(){this.getCurrentActiveJavaEditor().selectAll();}
	private boolean opWordLowerCase(){return opWordCase(0);}
	private boolean opWordUpperCase(){return opWordCase(1);}
	private boolean opWordCase(int idx){String selectedText="";String selTxt="";
		IJavaEditor editor=this.getCurrentActiveJavaEditor();
		selTxt=(selectedText=editor.getSelectedJavaCode());
		if(StringHelper.isEmpty(selectedText)){return false;}
		if(idx==0){selTxt=selTxt.toLowerCase();}
		if(idx==1){selTxt=selTxt.toUpperCase();}
		editor.replaceSelection(selTxt);return true;
	}
	private void opOpenDialogFind(){findDialog=new DIAFindDialog(appFrame,this.getCurrentActiveJavaEditor());
		findDialog.showDialog();
	}
	private void opFindPrevious(){String toFindValue=findDialog.getFindValue();
		appLogger.infoHighlighted("find data="+toFindValue);/*$NON-NLS-1$*/
		/*String find=jt1.getText();*/
		editorData=this.getCurrentActiveJavaEditor().getJavaCode();
		int findlen=toFindValue.length();
		int caretPosition=this.getCurrentActiveJavaEditor().getCaretPosition();
		int p=caretPosition-findlen-1;
		globalIndIdx=editorData.lastIndexOf(toFindValue,p);
		appLogger.infoHighlighted("find pre="+caretPosition);/*$NON-NLS-1$*/
		appLogger.infoHighlighted("new index="+globalIndIdx);/*$NON-NLS-1$*/
		int cursorPosBegin0=globalIndIdx;int cursorPosEnd1=globalIndIdx+findlen;
		if(globalIndIdx>=0){this.getCurrentActiveJavaEditor().requestFocus();
			this.getCurrentActiveJavaEditor().setSelectedJavaCode(cursorPosBegin0,cursorPosEnd1);
		}else{JOptionPane.showMessageDialog(appFrame,"Can't find the text: "+toFindValue,"Search Result",/*$NON-NLS-1$$NON-NLS-2$*/JOptionPane.ERROR_MESSAGE);
		}
	}
	private void opOpenDialogFindReplace(){
		this.dialogForFindReplace=new DIAFindReplaceDialog(this.appFrame,this.getCurrentActiveJavaEditor());
		dialogForFindReplace.showDialog();
	}
	private void opFindNext(){String toFindValue=findDialog.getFindValue();
		editorData=this.getCurrentActiveJavaEditor().getJavaCode();
		int sizeOfToFindValue=toFindValue.length();
		globalIndIdx=editorData.indexOf(toFindValue, globalNtNeededRevFindIndex);
		globalNtNeededRevFindIndex=globalIndIdx+sizeOfToFindValue;
		int foundPositionStart=globalIndIdx;
		int foundPositionEnd=foundPositionStart+sizeOfToFindValue;
		if(foundPositionStart>=0){this.getCurrentActiveJavaEditor().requestFocus();
			this.getCurrentActiveJavaEditor().setSelectedJavaCode(foundPositionStart, foundPositionEnd);
		}else{JOptionPane.showMessageDialog(appFrame,"Can't find the text: "+toFindValue, "Search Result",/*$NON-NLS-1$$NON-NLS-2$*/JOptionPane.ERROR_MESSAGE);}
	}
	private void opFindReplace(){String findstr=findDialog.getFindValue();
		String replacestr="";/*tfReplaceValue.getText();*/
		findstr.toCharArray();
		char[] arrayCharReplace=replacestr.toCharArray();
		editorData=this.getCurrentActiveJavaEditor().getJavaCode();
		char[] datachar=editorData.toCharArray();
		int findlen=findstr.length();
		int replacelen=replacestr.length();
		if(globalIndIdx>=0){
			if(findlen<replacelen){for(int i=0;i<findlen;i++){datachar[globalIndIdx+i]=arrayCharReplace[i];}
				newStringData=new String(datachar);
				StringBuilder s1=new StringBuilder(newStringData);
				for(int i=findlen;i<replacelen;i++){s1.insert(i, arrayCharReplace[i]);newStringData=new String(s1);}
				this.getCurrentActiveJavaEditor().setJavaCode(newStringData);
				globalNtNeededRevFindIndex=globalIndIdx+replacelen;
				globalIndIdx=editorData.indexOf(findstr, globalNtNeededRevFindIndex);
				this.getCurrentActiveJavaEditor().setSelectedJavaCode(globalIndIdx, globalIndIdx+findlen);
			}else if(findlen>replacelen){
				appLogger.infoHighlighted("find index "+globalIndIdx); //$NON-NLS-1$
				for(int i=0;i<replacelen;i++){datachar[globalIndIdx+i]=arrayCharReplace[i];}
				newStringData=new String(datachar);
				StringBuilder s1=new StringBuilder(newStringData);
				appLogger.infoHighlighted("new data1 "+newStringData);/*$NON-NLS-1$*/
				for (int i=globalIndIdx+replacelen;i<globalIndIdx+findlen;i++){
					appLogger.infoHighlighted("i= "+i);/*$NON-NLS-1$*/
					s1.deleteCharAt(i);newStringData=new String(s1);
				}
				globalNtNeededRevFindIndex=globalIndIdx+replacelen;
				this.getCurrentActiveJavaEditor().setJavaCode(newStringData);
				globalIndIdx=editorData.indexOf(findstr, globalNtNeededRevFindIndex);
				this.getCurrentActiveJavaEditor().setSelectedJavaCode(globalIndIdx, globalIndIdx+findlen);
			} else {
				for (int i=0;i<findlen;i++){datachar[globalIndIdx+i]=arrayCharReplace[i];
					newStringData=new String(datachar);
				}
				globalNtNeededRevFindIndex=globalIndIdx+replacelen;
				this.getCurrentActiveJavaEditor().setJavaCode(newStringData);
				globalIndIdx=editorData.indexOf(findstr, globalNtNeededRevFindIndex);
				this.getCurrentActiveJavaEditor().setSelectedJavaCode(globalIndIdx, globalIndIdx+findlen);
			}
		}else{JOptionPane.showMessageDialog(appFrame, "Can't find the text: "+findstr,"Search Result",/*$NON-NLS-1$$NON-NLS-2$*/JOptionPane.ERROR_MESSAGE);}
	}
	private void opFindReplaceAll(){String toFindContent="",toReplaceContent="";/*$NON-NLS-1$$NON-NLS-2$*/
		toFindContent=findDialog.getFindValue();
		toReplaceContent="";/*tfReplaceValue.getText();*/
		editorData=this.getCurrentActiveJavaEditor().getJavaCode();
		String editorChangedData=editorData.replace(toFindContent, toReplaceContent);
		this.getCurrentActiveJavaEditor().setJavaCode(editorChangedData);
	}
	private void opOpenDialogGoto(){DIAGotoDialog gotoDialog=new DIAGotoDialog(this.appFrame,this.getCurrentActiveJavaEditor());gotoDialog.showDialog();}
	private void opFullscreen(){/*TODO NADOR 03DEZ2018 (showed the fullscreen but caused my os to crash :()*/
		/*GraphicsDevice device=GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];*/
		/*device.setFullScreenWindow(appFrame);*/
	}
	private void opZoomIn(){getCurrentActiveJavaEditor().zoomIn();/*taLine[selectedTab+1].setFont(displayFont);*/}
	private void opZoomOut(){getCurrentActiveJavaEditor().zoomOut();/*taLine[selectedTab+1].setFont(displayFont);*/}
	private void opZoomRestore(){getCurrentActiveJavaEditor().zoomRestore();/*taLine[selectedTab+1].setFont(displayFont);*/}
	private void opSelectTab(int tabId){if(appTabManager.getTabCount()>=(tabId+1)){appTabManager.setSelectedIndex(tabId);}}
	private void opTabNextTab(){if(appTabManager.getSelectedIndex()<appTabManager.getTabCount()-1){appTabManager.setSelectedIndex(appTabManager.getSelectedIndex()+1);}}
	private void opTabPrevTab() {if(appTabManager.getSelectedIndex()>0){appTabManager.setSelectedIndex(appTabManager.getSelectedIndex()-1);}}
	private void operationSummary(){
		appLogger.infoHighlighted("File Name: "+arrayForFileNames[globalCurrSelectedTab+1]); //$NON-NLS-1$
		appLogger.infoHighlighted("Path: "+arrayForPath[globalCurrSelectedTab+1]); //$NON-NLS-1$
		String s=this.getCurrentActiveJavaEditor().getJavaCode();
		byte[] bytes=s.getBytes();
		try{appLogger.infoHighlighted("bytes length="+bytes.length); //$NON-NLS-1$
		}catch(Exception ex){appLogger.fatal(ex);}
		int length=s.length();
		appLogger.infoHighlighted("Total Char: "+length); //$NON-NLS-1$
		int line=this.getCurrentActiveJavaEditor().getLineCount();
		appLogger.infoHighlighted("Total Lines: "+line); //$NON-NLS-1$
		String s1=s.trim();
		int trimcount=s1.length();
		appLogger.infoHighlighted("Total count(Without Blanks): "+trimcount); //$NON-NLS-1$
		JPanel jp=new JPanel();
		JTextArea ta=new JTextArea("File Name: "+arrayForFileNames[globalCurrSelectedTab+1]+"\n"+"Path: " //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				+ arrayForPath[globalCurrSelectedTab+1]+"\n"+"Length(Bytes): "+bytes.length+"\n"+"\n" //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				+ "Lines: " //$NON-NLS-1$
				+ line+"\n"+"Character: "+length+"\n"+"Character(without blacks): "+trimcount); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		ta.setEditable(false);
		// JLabel l2=new JLabel("File Name: "+fileName[selectedTab+1]+"\n"+"Path:
		// "+path[selectedTab+1] );
		jp.add(ta);
		JOptionPane.showMessageDialog(appFrame, jp, "Summary", JOptionPane.PLAIN_MESSAGE, null); //$NON-NLS-1$
	}
	/**
	 * Depending the use case the compilation/run of a java code is executed.
	 * @param compile true, if to compile the java code
	 * @param run     true, if to run the java code
	 */
	private void operationCompileAndRun(boolean compile, boolean run) {
		fileName=arrayForFileNames[globalCurrSelectedTab];
		String javaFileContent=this.getCurrentActiveJavaEditor().getJavaCode();
		String processResult=""; //$NON-NLS-1$
		if (compile){appLogger.infoHighlighted("START: Starting.. Java compilation!"); //$NON-NLS-1$
			processResult=javaFramework.compile(fileName, javaFileContent);
			appLogger.infoHighlighted(processResult);
			appLogger.infoHighlighted("END: Java compilation ended!"); //$NON-NLS-1$
		}
		if (run){appLogger.infoHighlighted("START: Starting.. run java class file!"); //$NON-NLS-1$
			processResult=javaFramework.run(fileName, javaFileContent);
			appLogger.infoHighlighted(processResult);
			appLogger.infoHighlighted("END: Run Operation terminated!");/*$NON-NLS-1$*/
		}
		getCurrentActiveJavaEditor().getConsole().setContent(processResult);
	}
	private void operationStyleConfigurator(){
		/*TODO handle style configurator*/
		new DIASettingsDialog(appFrame).showDialog();
	}
	/**The shortcuts of the application are listed here*/
	private void operationShowShortcuts(){new DIAShortcutsDialog(appFrame).showDialog();}
	/**The about us dialog is shown here*/
	private void operationShowAboutUs(){new AboutUsDialog(appFrame).showDialog();}
	/**
	 * A new template for a java file is created here
	 * @param parFileName name of the file
	 * @return the java template
	 */
	private String templateForNewJavaFile(String parFileName, int templateId) {
		return new JavaTemplateManager().templateForNewJavaFile(parFileName, templateId);
	}
	/**
	 * When an action on the application menu is performed
	 */
	private class JavaEditorActionListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			final String CMD=actionEvent.getActionCommand();
/**MenuFile*/if(CMD.equals(AppCommands.CMD_NEW_FILE)){op00NewFile();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_OPEN_FILE)){op01OpenFile();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_SAVE_FILE)){op02SaveFile();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_SAVE_AS_FILE)){op03SaveAs();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_RENAME_FILE)){op04Rename();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_CLOSE_FILE)){op05CloseFile();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_CLOSE_ALL_FILES)){op06CloseAll();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_PRINT)){operationPrint();}
/**MenuFile*/else if(CMD.equals(AppCommands.CMD_EXIT)){op0iExit();}
	/***Menu EDIT*/else if(CMD.equals(AppCommands.CMD_UNDO)){opUndoRedoUndo();}
	/***Menu EDIT*/else if(CMD.equals(AppCommands.CMD_REDO)){opUndoRedoRedo();}
	/***Menu EDIT*/else if(CMD.equals(AppCommands.CMD_DELETE)){opDeleteFile();}
	/***Menu EDIT*/else if(CMD.equals(AppCommands.CMD_SELECT_ALL)){opSelectAll();}
	/***Menu EDIT*/else if(CMD.equals(AppCommands.CMD_UPPERCASE)){opWordUpperCase();}
	/***Menu EDIT*/else if(CMD.equals(AppCommands.CMD_LOWERCASE)){opWordLowerCase();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_FIND)){opOpenDialogFind();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_FIND_NEXT)){opFindNext();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_FIND_PREVIOUS)){opFindPrevious();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_FIND_REPLACE)){opOpenDialogFindReplace();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_REPLACE)){opFindReplace();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_REPLACE_ALL)){opFindReplaceAll();}
		/**MenuSEARCH*/else if(CMD.equals(AppCommands.CMD_GOTO)){opOpenDialogGoto();}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_FULLSCREEN)){opFullscreen();}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_ZOOM_IN)){opZoomIn();}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_ZOOM_OUT)){opZoomOut();}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_ZOOM_RESTORE)){opZoomRestore();}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_TAB_FIRST)){opSelectTab(0);}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_TAB_SECOND)){opSelectTab(1);}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_TAB_NEXT)){opTabNextTab();}
	/**MenuVIEW*/else if(CMD.equals(AppCommands.CMD_TAB_PREV)){opTabPrevTab();}
	/**MenuVIEW*/else if (CMD.equals(AppCommands.CMD_SUMMARY)){operationSummary();}
/**MenuRUN*/else if (CMD.equals(AppCommands.CMD_COMPILE)){operationCompileAndRun(true, false);}
/**MenuRUN*/else if (CMD.equals(AppCommands.CMD_RUN)){operationCompileAndRun(false, true);}
/**MenuRUN*/else if (CMD.equals(AppCommands.CMD_COMPILE_AND_RUN)){operationCompileAndRun(true, true);}
/**MenuSET*/else if (CMD.equals(AppCommands.CMD_CONFIG_STYLE)){operationStyleConfigurator();}
/**Menu HELP*/else if (CMD.equals(AppCommands.CMD_SHORTCUTS)){operationShowShortcuts();}
/**Menu HELP*/else if (CMD.equals(AppCommands.CMD_ABOUTUS)){operationShowAboutUs();}
		}
	}
	// -------------------------------------------------- //
	private class JavaEditorChangeListener implements ChangeListener{
		JavaEditorChangeListener(){}
		@Override
		public void stateChanged(ChangeEvent e){
			if (e.getSource() instanceof JTabbedPane){
				JTabbedPane pane=(JTabbedPane) e.getSource();
				appLogger.debugHighlighted("The selected tab (java-document) : "+pane.getSelectedIndex()); //$NON-NLS-1$
				setUpStatusBar(pane.getSelectedIndex());
			} else{
				appLogger.debugHighlighted("No selected tab"); //$NON-NLS-1$
			}
		}
	}
	// ------------ ----------- //
	// ------------ ------------- //
	private void setUpStatusBar(int editorIndex){
		EditorStatus editorInfo=this.getCurrentActiveJavaEditor().getEditorInfo();
		if (!this.getCurrentActiveJavaEditor().isOpened())
			return;
		/*create labels*/
		JLabel lblSourceFile=new JLabel("Java Source File");
		JLabel lblExt1=new JLabel();
		JLabel lblExt2=new JLabel();
		JLabel lblLength=new JLabel();
		JLabel lblLines=new JLabel();
		JLabel lblCursorLineNr=new JLabel();
		JLabel lblCursorColNr=new JLabel();
		lblLength.setText("Lenght: "+editorInfo.getTotalLength());
		lblLines.setText("Lines: "+editorInfo.getTotalLines());
		lblCursorLineNr.setText("Cursor Line No: "+editorInfo.getCursorPosition());
		lblCursorColNr.setText("Cursor Column No: "+editorInfo.getCursorColumn());
		/*createStatusBar*/
		JPanel statusPanel=new JPanel();
		statusPanel.add(lblSourceFile);
		statusPanel.add(lblExt1);
		statusPanel.add(lblExt2);
		statusPanel.add(lblLength);
		statusPanel.add(lblLines);
		statusPanel.add(lblCursorLineNr);
		statusPanel.add(lblCursorColNr);
		statusPanel.setPreferredSize(new Dimension(10, 25));
		statusPanel.setLayout(new GridLayout(1, 7));
//		TitledBorder border=new TitledBorder("Output");
//		appScrollPane[editorIndex].setBorder(border);
//		JPanel panel=new JPanel(new BorderLayout());
//		panel.add(appScrollPane[editorIndex], BorderLayout.CENTER);
//		panel.add(statusPanel, BorderLayout.SOUTH);
		/**adding the status panel to the IDE*/
		appFrame.add(statusPanel, BorderLayout.PAGE_END);
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public static class AppConstants{
		public static final String APP_VERSION="0.0.0";public static final String APP_VERSION_INTERNAL="0.0.0.0";
		public static final String APP_NAME="Java Editor One - Kapur Edition"+" - version "+APP_VERSION+" (under development)";
		public static final int APP_WIDTH=1024;public static final int APP_HEIGHT=768;
		public static final String PYTHON_PATH="F:\\msdos\\users\\python\\python-3.9\\";
		public static final String JAVA_PATH="D:\\Program Files\\Java\\jdk1.8.0_112\\bin\\";/*FOR WINDOWS: Use this path and change it to your jdk*/
		//"/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/bin/";/*FOR MACOS: Use this path and change it to your jdk*/
		public static final String FILE_EXTENSION_A="a";
		public static final String FILE_EXTENSION_B="b";
		public static final String FILE_EXTENSION_C="c";
		public static final String FILE_EXTENSION_CPLUSPLUS="c++";
		public static final String FILE_EXTENSION_D="d";
		public static final String FILE_EXTENSION_E="e";
		public static final String FILE_EXTENSION_FORTRAN="fortran";
		public static final String FILE_EXTENSION_HASKELL="haskell";
		public static final String FILE_EXTENSION_JAVA="java";
		public static final String FILE_EXTENSION_PYTHON="py";/*thon*/
		public static final String FILE_EXTENSION_HTML="html";
		public static final String TEMPLATE_FILE_NAME_JAVA="JavaOne";/*Untitled*/
		public static final String TEMPLATE_FILE_NAME_PYTHON="Python";
		public static final String TEMPLATE_FILE_NEW="resources/templates/newfile.txt";
		public static final String WORKSPACE="workspace";
		public static String WORKSPACE_PATH="workspace/";
		public static final String APP_BUNDLE_FILEPATH="properties/application";
		public static String get(String key){return javaEditorOneInstance.appBundle.getString(key);}
		// @formatter:off
		public static final String ABOUTUS_COLUMNS[]={"Name","Description"};
		public static final String ABOUTUS_ROWS[][]={
				{"Version",APP_VERSION},
				{"Internal",APP_VERSION_INTERNAL},
				{"Contributor 1","Kapil Kumar"},
				{"Contributor 2","Kais el Kara"},
				{"Contributor 3","Corto Maltese"},
				{"Date Contr. 1","2016"},
				{"Date Contr. 2","01-31.12.2018,04.06.2019"},
				{"Date Contr. 3","2020APR[17,18,21,22]"},
				{"Last rev. (author)","CortoMaltese"},
				{"Last revision","22.APR.2020 CRISTOS"},
				{"Last rev. time","22:22:22,22 MALTA Timezone"}
		};
		// @formatter:on
		// @formatter:off
		public static final String SHORTCUTS_COLUMNS[]={"Name","Shortcut"};
		public static final String SHORTCUTS_ROWS[][]={
				{">OPEN<",""},{"Exit","Alt+F4"},
				
				{">>PROCESS<<",""},{"Compile","CTRL+F9"},{"Run","CTRL+F10"},{"Compile and Run","CTRL+F11"},
				
				{">FILE<",""},{"New File","Ctrl+N"},{"Open File","Ctrl+O"},{"Save File","Ctrl+S"},{"Save as File","Ctrl+shift+S"},{"Close File","Ctrl+W"},{"Print File","Ctrl+P"},
				
				{">GO<",""},{"Go To", "Ctrl+G"},
				
				{">EDIT<",""},{"Undo","Ctrl+Z"},{"Redo","Ctrl+Y"},{"Cut","Ctrl+X"},{"Copy","Ctrl+C"},{"Paste","Ctrl+P"},{"Delete","DEL"},{"Select All","Ctrl+A"},
				
				{">WORD<",""},{"UPPERCASE","Ctrl+U"},{"lowercase", "Ctrl+l"},
				
				{">SEARCH<",""},{"Find", "Ctrl+F"},{"Find Next","F3"},{"Find Previous","Shift+F3"},{"Replace","Ctrl+H"},
				
				{">ZOOM<",""},{"Zoom In", "ALTGR+Numpad+"},{"Zoom Out","ALTGR+Numpad-"},{"Default Zoom","ALTGR+o"},
				
				{">TABS<",""},{"1st Tab","Ctrl+Numpad 1"},{"2nd Tab","Ctrl+Numpad 2"},{"3rd Tab","Ctrl+Numpad 3"},{"4th Tab","Ctrl+Numpad 4"},{"5th Tab","Ctrl+Numpad 5"},{"Next Tab","Ctrl+ Page Up"},{"Previous Tab","Ctrl+Page Down"},
				
				{"",""}
				
		};
		// @formatter:on
		// -------------------------------------------------- //
		// ------ ICONS ------------------------------------- //
		// -------------------------------------------------- //
		public static final Icon iconNewFile=getIcon("new.gif");
		public static final Icon iconOpenFile=getIcon("open.gif");
		public static final Icon iconSaveFile=getIcon("save.gif");
		public static final Icon iconSaveAs=getIcon("saveas.gif");
		public static final Icon iconCut=getIcon("cut.gif");
		public static final Icon iconCopy=getIcon("copy.gif");
		public static final Icon iconPaste=getIcon("paste.gif");
		public static final Icon iconUndo=getIcon("undo.gif");
		public static final Icon iconRedo=getIcon("redo.gif");
		public static final Icon iconFind=getIcon("find.gif");
		public static final Icon iconReplace=getIcon("replace.gif");
		public static final Icon iconZoomIn=getIcon("zoomin.gif");
		public static final Icon iconZoomOut=getIcon("zoomout.gif");
		public static final Icon iconCompile=getIcon("compile.gif");
		public static final Icon iconRun=getIcon("run.gif");
		public static final Icon iconCompileAndRun=getIcon("compilerun.gif");
		public static final Icon iconStartRecording=getIcon("startr.gif");
		public static final Icon iconPauseRecording=getIcon("pauser.gif");
		public static final Icon iconStopRecording=getIcon("stopr.gif");
		public static final Icon iconSaveRecording=getIcon("saver.gif");
		public static final Icon iconClose=getIcon("close.gif");
		public static final Icon iconCloseAll=getIcon("closeall.gif");
		public static final Icon iconNO=getIcon("no.gif");
		private static ImageIcon getIcon(String imgName){
			final String constImgPath="pics/";
			URL url=AppConstants.class.getClassLoader().getResource(constImgPath+imgName);
			if(url!=null){return new ImageIcon(url);}
			return new ImageIcon(constImgPath+imgName);
		}
		public static String getWorkspace(String filename){return WORKSPACE_PATH+filename;}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class AppBundle extends AppBundleDescriptor{
		/** application resource bundle */
		/*private ResourceBundle appResourceBundle;*/
		private Map<String, String> map;
		AppBundle(){
//			appResourceBundle=ResourceBundle.getBundle(AppConstants.APP_BUNDLE_FILEPATH, Locale.ENGLISH);
			map=new HashMap<String, String>();
//			#------------------------------#
//			# APPLICATION MENU
//			#------------------------------#
			map.put("BTN_COMPILE_AND_RUN_TOOLTIP", "Compile and Run");
			map.put("MENU_GOTO", "Go");
			map.put("MENU_EDIT", "Edit");
			map.put("MENU_WORD", "Word");
			map.put("MENU_ENCODING", "Encoding");
			map.put("MENU_FILE", "File");
			map.put("MENU_HELP", "Help");
			map.put("MENU_RECORDING", "Recording");
			map.put("MENU_RUN", "Run");
			map.put("MENU_SEARCH", "Search");
			map.put("MENU_SETTINGS", "Settings");
			map.put("MENU_VIEW", "View");
//			#------------------------------#
//			# MENU FILE
//			#------------------------------#
			map.put("MENU_FILE_CLOSE", "Close");
			map.put("MENU_FILE_CLOSE_ALL", "Close All");
			map.put("MENU_FILE_EXIT", "Exit");
			map.put("MENU_FILE_NEW", "New");
			map.put("MENU_FILE_OPEN", "Open");
			map.put("MENU_FILE_PRINT", "Print");
			map.put("MENU_FILE_RENAME", "Rename");
			map.put("MENU_FILE_SAVE", "Save");
			map.put("MENU_FILE_SAVE_AS", "Save As..");
//			#------------------------------#
//			# MENU EDIT
//			#------------------------------#
			map.put("MENU_EDIT_UNDO","Undo");
			map.put("MENU_EDIT_REDO","Redo");
			map.put("MENU_EDIT_CUT","Cut");
			map.put("MENU_EDIT_COPY","Copy");
			map.put("MENU_EDIT_PASTE","Paste");
			map.put("MENU_EDIT_DELETE","Delete");
			map.put("MENU_EDIT_SELECT_ALL","Select All");
			map.put("MENU_EDIT_CONVERT_CASE_TO","Convert Word To");
			map.put("MENU_EDIT_UPPERCASE","UPPER CASE");
			map.put("MENU_EDIT_LOWERCASE","LOWER CASE");
//			#------------------------------#
//			# MENU WORD
//			#------------------------------#			
			//map.put("MENU_EDIT_CONVERT_CASE_TO","Convert Case To");
			//map.put("MENU_EDIT_UPPERCASE","UPPER CASE");
			//map.put("MENU_EDIT_LOWERCASE","LOWER CASE");
//			#------------------------------#
//			# MENU SEARCH
//			#------------------------------#
			map.put("MENU_SEARCH_FIND","Find");
			map.put("MENU_SEARCH_FIND_NEXT","Find Next");
			map.put("MENU_SEARCH_FIND_PREVIOUS","Find Previous");
			map.put("MENU_SEARCH_REPLACE","Replace");
			map.put("MENU_SEARCH_GOTO","Goto");
//			#------------------------------#
//			# MENU VIEW
//			#------------------------------#
			map.put("MENU_VIEW_FULLSCREEN", "Full Screen Mode");
			map.put("MENU_VIEW_ZOOM_IN", "Zoom In");
			map.put("MENU_VIEW_ZOOM_OUT", "Zoom Out");
			map.put("MENU_VIEW_ZOOM_RESTORE", "Restore Default Zoom");
			map.put("MENU_VIEW_TAB", "Tab");
			map.put("MENU_VIEW_SUMMARY", "Summary...");
//			#------------------------------#
//			# MENU RUN
//			#------------------------------#
			map.put("MENU_RUN_COMPILE", "Compile");
			map.put("MENU_RUN_RUN", "Run");
			map.put("MENU_RUN_COMPILE_AND_RUN", "Compile and Run");
//			#------------------------------#
//			# MENU SETTINGS
//			#------------------------------#
			map.put("MENU_SETTINGS_CONFIG_STYLE", "Settings!");/*Style Configurator...*/
//			#------------------------------#
//			# MENU RECORDING
//			#------------------------------#
			map.put("MENU_RECORDING_RECORD_START","Start Recording");
			map.put("MENU_RECORDING_RECORD_PAUSE","Pause Recording");
			map.put("MENU_RECORDING_RECORD_STOP","Stop Recording");
			map.put("MENU_RECORDING_RECORD_SAVE","Save Recording");
//			#------------------------------#
//			# MENU ENCODING
//			#------------------------------#
			map.put("MENU_ENCODING_ENCODE1","Encode k1");
			map.put("MENU_ENCODING_ENCODE2","Encode k2");
			map.put("MENU_ENCODING_ENCODE3","Encode k3");
//			#------------------------------#
//			# MENU HELP
//			#------------------------------#
			map.put("MENU_HELP_SHORTCUTS","Shortcuts");
			map.put("MENU_HELP_ABOUTUS","About Us!");
//			#------------------------------#
//			# TOOLBAR
//			#------------------------------#
			map.put("BTN_COMPILE_AND_RUN_TOOLTIP","Compile and Run");
			map.put("BTN_COMPILE_TOOLTIP","Compile");
			map.put("BTN_RUN_TOOLTIP","Run");
			map.put("BTN_ZOOM_IN_TOOLTIP","Zoom In");
			map.put("BTN_ZOOM_OUT_TOOLTIP","Zoom Out");
//			#------------------------------#
//			# DIALOGE
//			#------------------------------#
			map.put("DIALOG_ABOUTUS_TITLE", "About Us!");
			map.put("DIALOG_SHORTCUTS_TITLE", "Shortcuts");
			map.put("DIALOG_NEWFILE_TITLE", "Create new file");
			map.put("DIALOG_RENAME_FILE_TITLE", "Rename file");
			map.put("DIALOG_TEMPLATE_FILE_TITLE", "Choose a template");
			map.put("DIALOG_GOTO_TITLE", "Goto line");
			map.put("DIALOG_FIND_TITLE", "Find");
//			#------------------------------#
//			# DIALOG NEWFILE for creating a new file
//			#------------------------------#
			map.put("LBL_NEWFILE_NAME", "Enter Filename:");
			map.put("JAVA","Java");
			map.put("PYTHON","Python");
			map.put("HTML","Html");
			/*#------------------------------#*/
			/*# DIALOG for renaming an existing file*/
			/*#------------------------------#*/
			map.put("LBL_RENAME_FILE_NAME", "File to Rename:");
//			#------------------------------#
//			# DIALOG for templates
//			#------------------------------#
			map.put("RBTN_FILE_TEMPLATE_1","Basic class with main method");
			map.put("RBTN_FILE_TEMPLATE_2","Class with a graphical window");
			map.put("RBTN_FILE_TEMPLATE_3","Loop template");
			map.put("RBTN_FILE_TEMPLATE_101","Python template");
			map.put("RBTN_FILE_TEMPLATE_201","HTML template");
//			#------------------------------#
//			# DIALOG GOTO
//			#------------------------------#
			map.put("LBL_GOTO_FROM","You are here:");
			map.put("LBL_GOTO_TO","You want to go to:");
			map.put("BTN_GOTO_GO","Go");
			map.put("BTN_GOTO_CLOSE","Close");
//			#------------------------------#
//			# DIALOG FIND
//			#------------------------------#
			map.put("LBL_FIND_WHAT", "Find:");
			map.put("LBL_FIND_NEXT", "Next");
			map.put("BTN_FIND_CLOSE", "Close");
		}
		/**
		 * Return the string value represented by the property key
		 * @param parPropertyKey property key
		 * @return string value of the property key
		 */
		String getString(String parPropertyKey){
//			if (appResourceBundle.containsKey(parPropertyKey)){
//				return appResourceBundle.getString(parPropertyKey);
//			}
			if (map.containsKey(parPropertyKey)){
				return map.get(parPropertyKey);
			}
			return "?";
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class AppBundleDescriptor{public static final String MENU_SEPARATOR="|"; //$NON-NLS-1$
		/***Dialogs titles*/
		public static final String DIALOG_ABOUTUS_TITLE="DIALOG_ABOUTUS_TITLE";
		public static final String DIALOG_SHORTCUTS_TITLE="DIALOG_SHORTCUTS_TITLE";
		public static final String DIALOG_SETTINGS_TITLE="DIALOG_SHORTCUTS_TITLE";
		public static final String DIALOG_NEWFILE_TITLE="DIALOG_NEWFILE_TITLE";
		public static final String DIALOG_RENAME_FILE_TITLE="DIALOG_RENAME_FILE_TITLE";
		public static final String DIALOG_TEMPLATE_FILE_TITLE="DIALOG_TEMPLATE_FILE_TITLE";
		public static final String DIALOG_GOTO_TITLE="DIALOG_GOTO_TITLE";
		public static final String DIALOG_FIND_TITLE="DIALOG_FIND_TITLE";
		/***Menus*/
		public static final String MENU_FILE="MENU_FILE";
		public static final String MENU_GOTO="MENU_GOTO";
		public static final String MENU_EDIT="MENU_EDIT";
		public static final String MENU_WORD="MENU_WORD";
		public static final String MENU_SEARCH="MENU_SEARCH";
		public static final String MENU_VIEW="MENU_VIEW";
		public static final String MENU_RUN="MENU_RUN";
		public static final String MENU_SETTINGS="MENU_SETTINGS";
		public static final String MENU_RECORDING="MENU_RECORDING";
		public static final String MENU_ENCODING="MENU_ENCODING";
		public static final String MENU_HELP="MENU_HELP";
		/***Menu_File*/
		public static final String MENU_FILE_NEW="MENU_FILE_NEW";
		public static final String MENU_FILE_OPEN="MENU_FILE_OPEN";
		public static final String MENU_FILE_SAVE="MENU_FILE_SAVE";
		public static final String MENU_FILE_SAVE_AS="MENU_FILE_SAVE_AS";
		public static final String MENU_FILE_RENAME="MENU_FILE_RENAME";
		public static final String MENU_FILE_CLOSE="MENU_FILE_CLOSE";
		public static final String MENU_FILE_CLOSE_ALL="MENU_FILE_CLOSE_ALL";
		public static final String MENU_FILE_PRINT="MENU_FILE_PRINT";
		public static final String MENU_FILE_EXIT="MENU_FILE_EXIT";
		/***Menu_Edit*/
		public static final String MENU_EDIT_UNDO="MENU_EDIT_UNDO";
		public static final String MENU_EDIT_REDO="MENU_EDIT_REDO";
		public static final String MENU_EDIT_CUT="MENU_EDIT_CUT";
		public static final String MENU_EDIT_COPY="MENU_EDIT_COPY";
		public static final String MENU_EDIT_PASTE="MENU_EDIT_PASTE";
		public static final String MENU_EDIT_DELETE="MENU_EDIT_DELETE";
		public static final String MENU_EDIT_SELECT_ALL="MENU_EDIT_SELECT_ALL";
		public static final String MENU_EDIT_CONVERT_CASE_TO="MENU_EDIT_CONVERT_CASE_TO";
		public static final String MENU_EDIT_UPPERCASE="MENU_EDIT_UPPERCASE";
		public static final String MENU_EDIT_LOWERCASE="MENU_EDIT_LOWERCASE";
		/**
		 * Menu Search
		 */
		public static final String MENU_SEARCH_FIND="MENU_SEARCH_FIND";
		public static final String MENU_SEARCH_FIND_NEXT="MENU_SEARCH_FIND_NEXT";
		public static final String MENU_SEARCH_FIND_PREVIOUS="MENU_SEARCH_FIND_PREVIOUS";
		public static final String MENU_SEARCH_REPLACE="MENU_SEARCH_REPLACE";
		public static final String MENU_SEARCH_GOTO="MENU_SEARCH_GOTO";
		/**
		 * Menu View
		 */
		public static final String MENU_VIEW_FULLSCREEN="MENU_VIEW_FULLSCREEN";
		public static final String MENU_VIEW_ZOOM_IN="MENU_VIEW_ZOOM_IN";
		public static final String MENU_VIEW_ZOOM_OUT="MENU_VIEW_ZOOM_OUT";
		public static final String MENU_VIEW_ZOOM_RESTORE="MENU_VIEW_ZOOM_RESTORE";
		public static final String MENU_VIEW_TAB="MENU_VIEW_TAB";
		public static final String MENU_VIEW_SUMMARY="MENU_VIEW_SUMMARY";
		/**
		 * Menu Run
		 */
		public static final String MENU_RUN_COMPILE="MENU_RUN_COMPILE";
		public static final String MENU_RUN_RUN="MENU_RUN_RUN";
		public static final String MENU_RUN_COMPILE_AND_RUN="MENU_RUN_COMPILE_AND_RUN";
		/***Menu_Settings*/
		public static final String MENU_SETTINGS_CONFIG_STYLE="MENU_SETTINGS_CONFIG_STYLE";
		/***Menu_Recording*/
		public static final String MENU_RECORDING_RECORD_START="MENU_RECORDING_RECORD_START";
		public static final String MENU_RECORDING_RECORD_PAUSE="MENU_RECORDING_RECORD_PAUSE";
		public static final String MENU_RECORDING_RECORD_STOP="MENU_RECORDING_RECORD_STOP";
		public static final String MENU_RECORDING_RECORD_SAVE="MENU_RECORDING_RECORD_SAVE";
		/***Menu_Encoding*/
		public static final String MENU_ENCODING_ENCODE1="MENU_ENCODING_ENCODE1";
		public static final String MENU_ENCODING_ENCODE2="MENU_ENCODING_ENCODE2";
		public static final String MENU_ENCODING_ENCODE3="MENU_ENCODING_ENCODE3";
		/***Menu Help*/
		public static final String MENU_HELP_SHORTCUTS="MENU_HELP_SHORTCUTS";
		public static final String MENU_HELP_ABOUTUS="MENU_HELP_ABOUTUS";
		/***TOOLBAR*/
		public static final String BTN_ZOOM_IN_TOOLTIP="BTN_ZOOM_IN_TOOLTIP";
		public static final String BTN_ZOOM_OUT_TOOLTIP="BTN_ZOOM_OUT_TOOLTIP";
		public static final String BTN_COMPILE_TOOLTIP="BTN_COMPILE_TOOLTIP";
		public static final String BTN_RUN_TOOLTIP="BTN_RUN_TOOLTIP";
		public static final String BTN_COMPILE_AND_RUN_TOOLTIP="BTN_COMPILE_AND_RUN_TOOLTIP";
		/***Dialog_NewFileDialog*/
		public static final String LBL_NEWFILE_NAME="LBL_NEWFILE_NAME";
		public static final String LBL_RENAME_FILE_NAME="LBL_RENAME_FILE_NAME";
		public static final String JAVA="JAVA";
		public static final String PYTHON="PYTHON";
		public static final String HTML="HTML";
		/***Dialog_TemplateChooserDialog*/
		public static final String RBTN_FILE_TEMPLATE_1="RBTN_FILE_TEMPLATE_1";
		public static final String RBTN_FILE_TEMPLATE_2="RBTN_FILE_TEMPLATE_2";
		public static final String RBTN_FILE_TEMPLATE_3="RBTN_FILE_TEMPLATE_3";
		public static final String RBTN_FILE_TEMPLATE_101="RBTN_FILE_TEMPLATE_101";
		public static final String RBTN_FILE_TEMPLATE_102="RBTN_FILE_TEMPLATE_102";
		public static final String RBTN_FILE_TEMPLATE_103="RBTN_FILE_TEMPLATE_103";
		public static final String RBTN_FILE_TEMPLATE_201="RBTN_FILE_TEMPLATE_201";
		public static final String RBTN_FILE_TEMPLATE_202="RBTN_FILE_TEMPLATE_202";
		public static final String RBTN_FILE_TEMPLATE_203="RBTN_FILE_TEMPLATE_203";
		/***Dialog_GotoDialog*/
		public static final String LBL_GOTO_FROM="LBL_GOTO_FROM";
		public static final String LBL_GOTO_TO="LBL_GOTO_TO";
		public static final String BTN_GOTO_GO="BTN_GOTO_GO";
		public static final String BTN_GOTO_CLOSE="BTN_GOTO_CLOSE";
		/***Dialog_FindDialog*/
		public static final String LBL_FIND_WHAT="LBL_FIND_WHAT";
		public static final String LBL_FIND_NEXT="LBL_FIND_NEXT";
		public static final String BTN_FIND_CLOSE="BTN_FIND_CLOSE";
	}
	//*----------*//
	//*--------------------*//
	public class AppCommands{public static final String CMD_EMPTY="NONE";
		// menu FILE: this part creates the items of the menu File
		public static final String CMD_NEW_FILE="NEW_FILE";
		public static final String CMD_OPEN_FILE="OPEN_FILE";
		public static final String CMD_SAVE_FILE="SAVE_FILE";
		public static final String CMD_SAVE_AS_FILE="SAVE_AS";
		public static final String CMD_RENAME_FILE="RENAME_FILE";
		public static final String CMD_CLOSE_FILE="CLOSE_FILE";
		public static final String CMD_CLOSE_ALL_FILES="CLOSE_ALL_FILES";
		public static final String CMD_PRINT="PRINT";
		public static final String CMD_EXIT="EXIT";
		/*menu EDIT: this part creates the items of the menu Edit*/
		public static final String CMD_UNDO="UNDO";
		public static final String CMD_REDO="REDO";
		public static final String CMD_CUT="CUT";
		public static final String CMD_COPY="COPY";
		public static final String CMD_PASTE="PASTE";
		public static final String CMD_DELETE="DELETE";
		public static final String CMD_SELECT_ALL="SELECT_ALL";
		public static final String CMD_CONVERT_CASE_TO="CONVERT_CASE_TO";
		public static final String CMD_UPPERCASE="UPPERCASE";
		public static final String CMD_LOWERCASE="LOWERCASE";
		// menu SEARCH: this part creates the items of the menu Search
		public static final String CMD_FIND="FIND";
		public static final String CMD_FIND_NEXT="FIND_NEXT";
		public static final String CMD_FIND_PREVIOUS="FIND_PREV";
		public static final String CMD_FIND_REPLACE="FIND_AND_REPLACE";
		public static final String CMD_REPLACE="REPLACE";
		public static final String CMD_REPLACE_ALL="REPLACE_ALL";
		public static final String CMD_GOTO="GOTO";
		// menu VIEW: this part creates the items of the menu View
		public static final String CMD_FULLSCREEN="FULLSCREEN";
		public static final String CMD_ZOOM_IN="ZOOM_IN";
		public static final String CMD_ZOOM_OUT="ZOOM_OUT";
		public static final String CMD_ZOOM_RESTORE="ZOOM_RESTORE";
		public static final String CMD_TAB_SELECTION="TAB_SELECTION";
		public static final String CMD_TAB_FIRST="TAB1";
		public static final String CMD_TAB_SECOND="TAB2";
		public static final String CMD_TAB_NEXT="TAB_NEXT";
		public static final String CMD_TAB_PREV="TAB_PREV";
		public static final String CMD_SUMMARY="SUMMARY";
		// menu RUN: this part creates the items of the menu Run
		public static final String CMD_COMPILE="COMPILE";
		public static final String CMD_RUN="RUN";
		public static final String CMD_COMPILE_AND_RUN="COMPILE_AND_RUN";
		// menu SETTINGS: this part creates the items of the menu Settings
		public static final String CMD_CONFIG_STYLE="CONFIG_STYLE";
		// menu RECORDING: this part creates the items of the menu Recording
		public static final String CMD_RECORD_START="RECORD_START";
		public static final String CMD_RECORD_PAUSE="RECORD_PAUSE";
		public static final String CMD_RECORD_STOP="RECORD_STOP";
		public static final String CMD_RECORD_SAVE="RECORD_SAVE";
		// menu ENCODING: this part creates the items of the menu Encoding
		public static final String CMD_ENCODE1="ENCODE1";
		public static final String CMD_ENCODE2="ENCODE2";
		public static final String CMD_ENCODE3="ENCODE3";
		// menu HELP: this part creates the items of the menu Help
		public static final String CMD_SHORTCUTS="SHORTCUTS";
		public static final String CMD_ABOUTUS="ABOUTUS";
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public final class AppLogger{public static final String LOG_SYMBOL="-";
		public static final String LOG_SYMBOL_START=">> ";public static final String LOG_SYMBOL_END=" <<";
		public static final int LOG_REPEAT_COUNT=70;
		/**console*/private AppConsole console;
		private boolean consoleActive;
		/***Constructor***/public AppLogger(){consoleActive=true;console=AppConsole.getConsole();}
		public void infoHighlighted(String parInfo){final String symbol=LOG_SYMBOL;final int count=LOG_REPEAT_COUNT;
			info(Strings.repeat(symbol, LOG_SYMBOL_START, "", LOG_SYMBOL_END, count, false));
			info(Strings.repeat(symbol, LOG_SYMBOL_START, parInfo, LOG_SYMBOL_END, count, false));
			info(Strings.repeat(symbol, LOG_SYMBOL_START, "", LOG_SYMBOL_END, count, false));
		}
		public void info(String parInfo){if(consoleActive){console.info(parInfo);}}
		public void warn(String parWarn){if(consoleActive){console.warn(parWarn);}}
		public void error(String parError){if(consoleActive){console.error(parError);}}
		public void errorHighlighted(String parError){
			final String symbol=LOG_SYMBOL;final int count=LOG_REPEAT_COUNT;
			error(Strings.repeat(symbol, LOG_SYMBOL_START, "", LOG_SYMBOL_END, count, false));
			error(Strings.repeat(symbol, LOG_SYMBOL_START, parError, LOG_SYMBOL_END, count, false));
			error(Strings.repeat(symbol, LOG_SYMBOL_START, "", LOG_SYMBOL_END, count, false));
		}
		public void debug(String parDebug){if(consoleActive){console.debug(parDebug);}}
		public void debugHighlighted(String parInfo){final String symbol=LOG_SYMBOL;final int count=LOG_REPEAT_COUNT;
			debug(Strings.repeat(symbol,LOG_SYMBOL_START,"",LOG_SYMBOL_END, count, false));
			debug(Strings.repeat(symbol,LOG_SYMBOL_START,parInfo,LOG_SYMBOL_END, count, false));
			debug(Strings.repeat(symbol,LOG_SYMBOL_START,"",LOG_SYMBOL_END, count, false));
		}
		public void severe(Exception ex){if(consoleActive){console.severe(ex);}else{error(ex.getMessage());}}
		public void fatal(Exception ex){if(consoleActive){console.fatal(ex);}else{error(ex.getMessage());}}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public static class AppConsole{
		/**console*/private static AppConsole console;
		static{console=new AppConsole();}
		public static AppConsole getConsole(){return console;}
		/***The different supported log properties*/
		enum LOG_PROPERTY{INFO,WARNING,ERROR,DEBUG}
		public void info(String parText){logToConsole(LOG_PROPERTY.INFO,parText);}
		public void info(String... elems){logToConsole(LOG_PROPERTY.DEBUG,elems);}
		public void warn(String parText){logToConsole(LOG_PROPERTY.WARNING,parText);}
		public void error(String parText){logToConsole(LOG_PROPERTY.ERROR,parText);}
		public void debug(String... elems){logToConsole(LOG_PROPERTY.DEBUG,elems);}
		public void severe(Exception parEx){parEx.printStackTrace();}
		public void fatal(Exception parEx){parEx.printStackTrace();}
		public void logToConsole(LOG_PROPERTY parProperty,String... elems){
			StringBuffer buffer=new StringBuffer();
			boolean optionActive=elems.length > 1;
			for(String elem : elems){if(optionActive){buffer.append("[");}
				buffer.append(elem);if(optionActive){buffer.append("]");}
			}logToConsole(parProperty,buffer.toString());
		}
		/**
		 * The logging is redirected to the default system console
		 * @param parProperty log property
		 * @param parText     text to log
		 */
		private void logToConsole(LOG_PROPERTY parProperty, String parText){
			if (parProperty==LOG_PROPERTY.INFO){System.out.println("INFO: "+parText);
			} else if (parProperty==LOG_PROPERTY.WARNING){System.out.println("WARN: "+parText);
			} else if (parProperty==LOG_PROPERTY.ERROR){System.err.println("ERROR: "+parText);
			} else if (parProperty==LOG_PROPERTY.DEBUG){System.out.println("DEBUG: "+parText);
			}
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public interface IJavaConsole{
		public void setContent(String content);
		public String getContent();
		public Object getObservable();
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class JavaConsole implements IJavaConsole{
		private static final String FONT_NAME="Consolas";
		private static final int FONT_SIZE=24;
		/** console data */
		private JTextArea consoleData;
		/**
		 * Constructor
		 */
		public JavaConsole(){consoleData=new JTextArea(30,10);
			Font displayFont=new Font(FONT_NAME,Font.BOLD,FONT_SIZE);
			consoleData.setFont(displayFont);
		}
		@Override
		public void setContent(String content){consoleData.setText(content);consoleData.updateUI();}
		@Override
		public String getContent(){return consoleData.getText();}
		@Override
		public Object getObservable(){return new JScrollPane(consoleData);}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public interface IJavaEditor{
		public void setJavaCode(String javaCode);
		public String getJavaCode();
		public void createAndOpenFile(FileManager fileManager, String fileName, String content) throws IOException;
		public void openFile(File file) throws IOException;
		public boolean isOpened();
		public boolean saveFile(File file);
		public void selectAll();
		public void setSelectedJavaCode(int begin, int end);
		public String getSelectedJavaCode();
		public void replaceSelection(String content);
		public Object getObservable();
		public int getLineCount();
		public int getLineStartOffset(int line);
		public int getNumberOfLines();
		public int getLength();
		public void setCaretPosition(int position);
		public int getCaretPosition();
		public void requestFocus();
		public void zoomIn();
		public void zoomOut();
		public void zoomRestore();
		public EditorStatus getEditorInfo();
		public IJavaConsole getConsole();
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class JavaEditor implements IJavaEditor{
		private static final String NEWLINE="\n";
		private static final String FONT_NAME="Consolas";
		private static final int FONT_SIZE=28;
		private String fontName;private int fontSize;
		private JTextArea editorData;private JTextArea editorLineDisplayer;
		private boolean isFileOpened;
		/**UndoManager*/private UndoManager undoManager;
		/**EditorStatus*/private EditorStatus editorStatus;
		/**JavaEditorConsole*/private IJavaConsole console;
		/**
		 * Constructor
		 */
		public JavaEditor(){/***Init*/editorData=new JTextArea();undoManager=new UndoManager();
			editorStatus=new EditorStatus();console=new JavaConsole();
/***AddListeners*/editorData.addMouseListener(new JavaEditorMouseAdapter());
/***AddListeners*/editorData.addCaretListener(new JavaEditorCaretListener());
/***AddListeners*/editorData.getDocument().addDocumentListener(new JavaEditorDocumentListener());
/***AddListeners*/editorData.getDocument().addUndoableEditListener(new JavaEditorUndoableEditListener());
///***AddListeners*/editorData.addKeyListener(l);
			/***?*/int tabSize=editorData.getTabSize();
			tabSize=4;
			editorData.setTabSize(tabSize);
			/***font*/
			Font displayFont=new Font(fontName=FONT_NAME, Font.PLAIN, fontSize=FONT_SIZE);
			editorData.setFont(displayFont);
			createLineDisplayer();
		}
		public void selectAll(){editorData.selectAll();}
		public void setSelectedJavaCode(int begin,int end){editorData.select(begin, end);}
		public String getSelectedJavaCode(){return editorData.getSelectedText();}
		public void setJavaCode(String javaCode){editorData.setText(javaCode);
			if(!isOpened()){this.isFileOpened=true;}
		}
		public String getJavaCode(){return editorData.getText();}
		@Override
		public void createAndOpenFile(FileManager fileManager,String fileName,String content) throws IOException{
//			String fileNameWithExtension="";
//			if (!fileName.endsWith(".java")){
//				fileNameWithExtension=fileName+".java";			
//			}
			// write the newly created Java class to the disk
			// write the new file to the disk with the specified template
			fileManager.writeJavaFileInWorkspace(fileName, content);
			openFile(new File(AppConstants.getWorkspace(fileName)));
		}
		public void openFile(File file) throws IOException{
			FileReader reader=null;
			isFileOpened=false;
			try{reader=new FileReader(file);editorData.read(reader, null);
				isFileOpened=true;
			}catch(IOException e){throw e;
			}finally{if(reader!=null){reader.close();}}
			updateEditorStatus();
			setCaretPosition(0);
		}
		private void updateEditorStatus(){
			editorStatus.setTotalLength(editorData.getText().length());
			editorStatus.setTotalLines(editorData.getLineCount());
		}
		public boolean isOpened(){return this.isFileOpened;}
		public int getNumberOfLines(){String txt=editorData.getText();
			int numberOfLines=0;
			for(int j=0;j<txt.length();j++){if(txt.charAt(j)=='\n'){numberOfLines=numberOfLines+1;}}
			return numberOfLines;
		}
		public int getLength(){return editorData.getText().length();}
		public boolean saveFile(File file){
			boolean isSaved=false;
			if(file==null){return false;}
			try{FileWriter writer=new FileWriter(file);
				editorData.write(writer);isSaved=true;
			}catch (IOException ex){ex.printStackTrace();}
			return isSaved;
		}
		public JComponent getObservable(){
			/*CreateActionListener*/
			EditorActionListener actionListener=new EditorActionListener();
			/*AppendJavaEditor&ItsLines*/
			JPanel fullEditor=new JPanel(new BorderLayout());
			fullEditor.add(updateLineDisplayer(), BorderLayout.WEST);
			editorData.setMargin(new Insets(5, 5, 5, 5));
			/*TODO NADOR 09.12.2018 Popup in the editor still not working*/
			/***addPopupMenu*/
			/*CreatePanels*/JPanel popupPanel=new JPanel();
			JPopupMenu popup=new JPopupMenu();
			JMenuItem popupCut, popupCopy, popupPaste;
			/*CreateMenuItems*/popupCut=new JMenuItem("Cut");popupCopy=new JMenuItem("Copy");popupPaste=new JMenuItem("Paste");
			/*AddElemIntoPopupMenu*/popup.add(popupCut);popup.add(popupCopy);popup.add(popupPaste);
			/*addActionListener*/popupCut.addActionListener(actionListener);popupCopy.addActionListener(actionListener);popupPaste.addActionListener(actionListener);
			/*SetComponents*/popupPanel.setComponentPopupMenu(popup);editorData.add(popupPanel);
			/*ReturnFulleditor*/
			fullEditor.add(editorData, BorderLayout.CENTER);
			fullEditor.add((Component)((JavaConsole)console).getObservable(),BorderLayout.SOUTH);
			return new JScrollPane(fullEditor);
		}
		public void setCaretPosition(int position){editorData.setCaretPosition(position);updateLineDisplayer();}
		public int getCaretPosition(){int caretPos=editorData.getCaretPosition();return caretPos;}
		public void zoomIn(){setFont(fontSize+=2);}
		public void zoomOut(){setFont(fontSize-=2);}
		public void zoomRestore(){setFont(fontSize=FONT_SIZE);}
		private void setFont(int parFontSize){
			Font displayFont=new Font(fontName, Font.PLAIN, parFontSize);
			editorData.setFont(displayFont);
			editorLineDisplayer.setFont(displayFont);
		}
		private void createLineDisplayer(){
			Font displayFont=new Font(FONT_NAME,Font.PLAIN,FONT_SIZE+3);
			editorLineDisplayer=new JTextArea(1,2);
			editorLineDisplayer.setEditable(false);
			editorLineDisplayer.setFont(displayFont);
			editorLineDisplayer.setBackground(Color.decode("#FFFFFF"));/*WHITE*//*$NON-NLS-1$*/
			editorLineDisplayer.setForeground(Color.decode("#FF6060"));/*RED*//*$NON-NLS-1$*/
			editorLineDisplayer.setText(generateLines(getLineCount()));
		}
		private String generateLines(final int maxLines){StringBuffer buffer=new StringBuffer();
			int val=maxLines;int count=0;
			while(val>=10){count++;val/=10;}
			int hCount=1;int repeat=-1;
			for (int i=1;i<=maxLines;i++){
				if((i>=Math.pow(10,hCount))&&(i<Math.pow(10, hCount+1))){hCount++;}
				repeat=count-hCount+1;
				buffer.append(Strings.repeat("0",repeat)+i);
				buffer.append(NEWLINE);
			}return buffer.toString();
		}
		private JTextArea updateLineDisplayer(){if(editorLineDisplayer==null){createLineDisplayer();}
			editorLineDisplayer.setText(generateLines(getLineCount()));
			return editorLineDisplayer;
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		public EditorStatus getEditorInfo(){return editorStatus;}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		private class JavaEditorUndoableEditListener implements UndoableEditListener{
			public void undoableEditHappened(UndoableEditEvent e){
				undoManager.addEdit(e.getEdit());
//				updateUndoRedoButtons();
			}
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		private class JavaEditorMouseAdapter extends MouseAdapter{
			public void mouseReleased(final MouseEvent e){
				if(e.isPopupTrigger()){/*popupMenu2.show(e.getComponent(), e.getX(), e.getY());*/}
			}
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		private class EditorActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				// TODO implement the action listener
			}
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		private class JavaEditorCaretListener implements CaretListener{
			JavaEditorCaretListener(){}
			public void caretUpdate(CaretEvent caretEvent){
				JTextArea editArea=(JTextArea) caretEvent.getSource();
				try{int caretpos=editArea.getCaretPosition();
					int offset=editArea.getLineOfOffset(caretpos);
					@SuppressWarnings("unused")
					int select=caretpos - editArea.getLineStartOffset(offset);
					updateLineDisplayer();
				} catch (Exception parEx){
					AppConsole.getConsole().severe(parEx);
				}
			}
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		private class JavaEditorDocumentListener implements DocumentListener{
			JavaEditorDocumentListener(){}
			public void insertUpdate(DocumentEvent e){updateLog(e, "inserted into");}
			public void removeUpdate(DocumentEvent e){updateLog(e, "removed from");}
			public void changedUpdate(DocumentEvent e){
				// Plain text components do not fire these events
			}
			public void updateLog(DocumentEvent e, String action){
				Document document=(Document) e.getDocument();
				int changeLength=e.getLength();
//				String s=openedJavaEditors[mySelect].getJavaCode();
//				arrayForShowingLines[mySelect]="";
//				i=1;
//				for (int a=0; a < s.length(); a++){
//					if (s.charAt(a) == '\n'){
//						i=i+1;
//					}
//				}
//				lines[mySelect]=i;
//				len[mySelect]=s.length();
//				for (int k=1; k <= i; k++){
//					arrayForShowingLines[mySelect]=arrayForShowingLines[mySelect]+k+"\n";
//					taLine[mySelect].setText(arrayForShowingLines[mySelect]);
//				}
				// f.add(taLine[select+1],BorderLayout.WEST);
			}
		}
		public void replaceSelection(String content){editorData.replaceSelection(content);}
		public void requestFocus(){editorData.requestFocus();}
		public int getLineCount(){return editorData.getLineCount();}
		public int getLineStartOffset(int line){try{return editorData.getLineStartOffset(line);}catch(BadLocationException e){e.printStackTrace();}
			return -1;
		}
		public IJavaConsole getConsole(){return console;}
	}
	public interface IEditorStatus{
		public int getTotalLength();
		public void setTotalLength(int totalLength);
		public int getTotalLines();
		public void setTotalLines(int totalLines);
		public int getCursorPosition();
		public void setCursorPosition(int cursorPosition);
		public int getCursorColumn();
		public void setCursorColumn(int cursorColumn);
	}
	public class EditorStatus implements IEditorStatus{
		private int totalLength;private int totalLines;
		private int cursorPosition;private int cursorColumn;
		public EditorStatus(){}
		public int getTotalLength(){return totalLength;}
		public void setTotalLength(int totalLength){this.totalLength=totalLength;}
		public int getTotalLines(){return totalLines;}
		public void setTotalLines(int totalLines){this.totalLines=totalLines;}
		public int getCursorPosition(){return cursorPosition;}
		public void setCursorPosition(int cursorPosition){this.cursorPosition=cursorPosition;}
		public int getCursorColumn(){return cursorColumn;}
		public void setCursorColumn(int cursorColumn){this.cursorColumn=cursorColumn;}
	}
	public class JavaEngine{public Runtime runtimeEngine;
		/**fileManager*/private FileManager fileManager;/**logger*/private AppLogger appLogger;
		private String fileName;
		private String fileContent;
		private String filenameNoExtension;
		private ProcessDescriptor processDescriptor;
		/**
		 * Constructor
		 * @param logger application logger
		 */
		public JavaEngine(AppLogger logger){this.appLogger=logger;runtimeEngine=Runtime.getRuntime();
			fileManager=new FileManager(appLogger);
		}
		private String eval(ProcessDescriptor parDescriptor) {
			if(parDescriptor==null){return "?";}
			StringBuffer buffer=new StringBuffer();
			final String actionName="[COMPILATION]";
			if(!parDescriptor.getErrorLog().equals("")){buffer.append(actionName+" UNSUCCESSFUL :(\n");buffer.append(parDescriptor.getErrorLog());
			}else{buffer.append(actionName+" SUCCESSFUL :)\n");buffer.append(parDescriptor.getProcessResults());}
			return buffer.toString();
		}
		private ProcessDescriptor compileJAVA(){processDescriptor=OSProcess_EXECUTE(this,
					"javac -d . "+AppConstants.getWorkspace(this.fileName));return processDescriptor;
		}
		private ProcessDescriptor compilePYTHON(){processDescriptor=OSProcess_EXECUTE(this,
					"python.exe "+AppConstants.getWorkspace(this.fileName));return processDescriptor;
		}
		/*** This function compile the JavaFile*/
		public String compile(String parFileName,String parFileContent){
			this.fileName=parFileName;this.fileContent=parFileContent;this.processDescriptor=null;
			/*this.javaFileName=javaFileName.substring(0,javaFileName.indexOf("."));*/
			boolean status=fileManager.writeJavaFileInWorkspace(fileName,fileContent);
			if(!status){appLogger.errorHighlighted("Due to IO-operation the file cannot be compiled!");}
			/*jaaava*/if(fileName.endsWith(".java")){return eval(compileJAVA());}
			/*python*/else if(fileName.endsWith(".python")){eval(compilePYTHON());}
			/*nooone*/else{return eval(processDescriptor);}
			return "!";
		}
		/*** This function run the JavaFile class containing the JavaByteCode*/
		public String run(String parFileName, String parFileContent){
			this.processDescriptor=null;fileName=parFileName;fileContent=parFileContent;
			
			if(fileName.endsWith(".java")){
				filenameNoExtension=fileName.substring(0,fileName.indexOf("."));
				processDescriptor=OSProcess_EXECUTE(this,"java.exe "+filenameNoExtension);
			}else if(fileName.endsWith(".python")){
				processDescriptor=OSProcess_EXECUTE(this,"python.exe "+parFileName);
			}else{return "?";}
			
			if(processDescriptor==null){return "?";}
			StringBuffer buffer=new StringBuffer();
			if(!processDescriptor.getErrorLog().equals("")){
				buffer.append("Run unsuccessful :(\n");
				buffer.append(processDescriptor.getErrorLog());
			}else{
				buffer.append("Run successful :)\n");
				buffer.append(processDescriptor.getProcessResults());
			}
			return buffer.toString();
		}
		/*** creatingYstarting::theJavaProcess*/
		public ProcessDescriptor OSProcess_EXECUTE(JavaEngine parProcessInfo,String parCommand) {
			/*variables*/Process javaProcess;String processLogErr="";String processResults="";
			/*var*/ProcessDescriptor procDescriptor=new ProcessDescriptor();
			try{javaProcess=parProcessInfo.runtimeEngine.exec(AppConstants.JAVA_PATH+parCommand);
				/*->extract::ErrorStream*/processLogErr=extractProcessInfo(javaProcess.getErrorStream());
				/*->extract::InputStream*/processResults=extractProcessInfo(javaProcess.getInputStream());
				/*->setErrorLog  ::intheProcessDescriptor*/procDescriptor.setErrorLog(processLogErr);
				/*->setResultsLog::intheProcessDescriptor*/procDescriptor.setProcessResults(processResults);
				/*->if process has error throw an IOException*/
				if(!processLogErr.equals("")){throw new IOException(processLogErr);}
			}catch(IOException parEx){appLogger.errorHighlighted(parEx.getMessage());procDescriptor.setErrorLog(processLogErr);}
			return procDescriptor;
		}
		/**
		 * extract info (errors/results) from the Java process
		 * @param iostream process stream
		 * @return info as String
		 */
		private String extractProcessInfo(InputStream iostream){StringBuffer buffer=new StringBuffer();BufferedReader bufferReader=null;
			String io="";
			try{bufferReader=new BufferedReader(new InputStreamReader(iostream));
				while(true){io=bufferReader.readLine();
					if(StringHelper.isNotEmpty(io)){buffer.append(io);buffer.append("\n");
					}else{break;}
				}
			}catch(IOException e){e.printStackTrace();
			}finally{if(bufferReader!=null){try{bufferReader.close();}catch(IOException e){appLogger.fatal(e);}}}
			return buffer.toString();
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public final class ProcessDescriptor {
		private String errLog;
		private String processResults;
		ProcessDescriptor(){}
		public String getErrorLog(){return errLog;}
		public void setErrorLog(String errLog){this.errLog=errLog;}
		public String getProcessResults(){return processResults;}
		public void setProcessResults(String processResults){this.processResults=processResults;}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class JavaTemplateManager{
		public String templateForNewJavaFile(String parFileName, int templateId) {
			// @formatter:off
			/**
			 * public class XYZ{
			 * 		public static void main(String args[]){
			 * 				// Enter your code in here ;)
			 *              System.out.println("Hello Java Editor One!");
			 *      }
			 * }
			 */
			/*@formatter:on*/
			JavaParser parser=new JavaParser(parFileName);
			if(templateId==0){return "";}
			if(templateId==1){return parser.generateTemplate1();}
			if(templateId==2){return parser.generateTemplate2();}
			if(templateId==3){return parser.generateTemplate3();}
			if(templateId==101){return parser.generateTemplatePython01();}
			if(templateId==201){return parser.generateTemplateHTML01();}
			return parser.generate();
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class JavaParser{
		/**className*/private String className;
		/**
		 * Constructor
		 * @param className class name
		 */
		public JavaParser(String className){this.className=className;}
		public String generate(){StringBuffer localBuffer=new StringBuffer();
			/*@formatter:off*/generateClass(localBuffer, this.className,
					generateMethod("main", createMethodCore(Arrays.asList(
			   				createComent("Enter your code in here :)")
			))));/*@formatter:on*/
			return localBuffer.toString();
		}
		public String generateTemplate1(){StringBuffer localBuffer=new StringBuffer();
			/*@formatter:off*/generateClass(localBuffer, this.className,
					generateMethod("main", createMethodCore(Arrays.asList(
			   				createComent("Enter your code in here :)")
			))));/*@formatter:on*/
			return localBuffer.toString();
		}
		public String generateTemplate2(){StringBuffer localBuffer=new StringBuffer();
			/*@formatter:off*/generateClass(localBuffer, this.className,
					generateMethod("main", createMethodCore(Arrays.asList(
			   				createComent("GUI WINDOW TODO :)")
			))));/*@formatter:on*/
			return localBuffer.toString();
		}
		public String generateTemplate3(){StringBuffer localBuffer=new StringBuffer();
			/*@formatter:off*/generateClass(localBuffer, this.className,
					generateMethod("main", createMethodCore(Arrays.asList(
			   				createComent("Enter your code in here!"),
							createLoop(20)
			))));/*@formatter:on*/
			return localBuffer.toString();
		}
		public String generateTemplatePython01(){StringBuffer localBuffer=new StringBuffer();
			final String pyImport="import os,sys,time";
			final String pyInstruction00="def start():";
			final String pyInstruction01="  exit=False";
			final String pyInstruction02="  while not(exit):";
			final String pyInstruction03="    argv=input('corto:> ')";
			final String pyInstruction04="      if argv='exit': exit=True";
			final String pyInstruction05="    elif argv='h'   : os.system('shutdown /h')";
			final String pyInstruction06="    elif argv='s'   : os.system('shutdown /s')";
			final String pyInstruction07="    elif argv='a'   : os.system('shutdown /a')";
			final String pyInstruction08="    elif argv='t'   : os.system('time')";
			final String pyInstruction09="    elif argv=' '   : ";
			final String pyInstruction10="    elif argv=' '   : ";
			final String pyInstruction11="    elif argv=' '   : ";
			final String pyInstruction12="    elif argv=' '   : ";
			final String pyInstruction13="    elif argv=' '   : ";
			final String pyInstruction14="    elif argv=' '   : ";
			final String pyInstruction15="    elif argv=' '   : ";
			final String pyInstruction16="    elif argv=' '   : ";
			final String pyInstruction20="    else            : print('Please Help-Me!')";
			final String pyInstruction21="  #endwhile";
			final String pyInstruction22="#fed";
			final String pyInstruction23="start()";
			String pyTemplate=null;
			localBuffer.append(pyImport+'\n');
			localBuffer.append(pyInstruction00+'\n');
			localBuffer.append(pyInstruction01+'\n');
			localBuffer.append(pyInstruction02+'\n');
			localBuffer.append(pyInstruction03+'\n');
			localBuffer.append(pyInstruction04+'\n');
			localBuffer.append(pyInstruction05+'\n');
			localBuffer.append(pyInstruction06+'\n');
			localBuffer.append(pyInstruction07+'\n');
			localBuffer.append(pyInstruction08+'\n');
			localBuffer.append(pyInstruction20+'\n');
			localBuffer.append(pyInstruction21+'\n');
			localBuffer.append(pyInstruction22+'\n');
			localBuffer.append(pyInstruction23+'\n');
			pyTemplate=localBuffer.toString();
			return pyTemplate;
		}
		public String generateTemplateHTML01(){StringBuffer localBuffer=new StringBuffer();
			String html="";
			final String HTMLBegin="<!DOCTYPE html>";
			final String HTMLEnnnd="</html>";
			final String HTMLHeadBegin="<head>";
			final String HTMLHeadEnnnd="<head>";
			final String HTMLBodyBegin="<body>";
			final String HTMLBodyEnnnd="</body>";
			final String HTMLHeadTitle="<title></title>";
			final String HTMLStyleBegin="<style>";
			final String HTMLStyle01="body{position:absolute;top:100px;left:200px;font-size:18pt;font-family:Arial;}";
			final String HTMLStyleEnnnd="</style>";
			
			final String HTMLScriptBegin="<script type='text/javascript'>";
			final String HTMLScriptEnnnd="</script>";
			final String JsScript01="function get('id'){return document.getElementById(id);}";			
			final String HTMLTitle="<h1></h1>";
			final String HTMLSubtitle="<h2></h2>";
			
			/*beg*/localBuffer.append(HTMLBegin+'\n');
			/*head*/localBuffer.append(HTMLHeadBegin+'\n');
			/*title*/localBuffer.append(HTMLHeadTitle+'\n');
			/*sty*/localBuffer.append(HTMLStyleBegin+'\n');
			/*sty*/localBuffer.append(HTMLStyle01+'\n');
			/*sty*/localBuffer.append(HTMLStyleEnnnd+'\n');
			/*js*/localBuffer.append(HTMLScriptBegin+'\n');
			/*js*/localBuffer.append(JsScript01+'\n');
			/*js*/localBuffer.append(HTMLScriptEnnnd+'\n');
			/*head*/localBuffer.append(HTMLHeadEnnnd+'\n');
			
			/*body*/localBuffer.append(HTMLBodyBegin+'\n');
			localBuffer.append(HTMLTitle+'\n');
			localBuffer.append(HTMLSubtitle+'\n');
			/*body*/localBuffer.append(HTMLBodyEnnnd+'\n');
			
			/*end*/localBuffer.append(HTMLEnnnd+'\n');
			html=localBuffer.toString();
			return html;
		}
		private void generateClass(StringBuffer buffer, String className, String classCore) {
			buffer.append("public class "+className);
			insertOpenBracket(buffer);
			insertCarriageReturn(buffer);
			buffer.append(classCore);
			insertCarriageReturn(buffer);
			insertCloseBracket(buffer);
		}
		private String generateMethod(String methodName, String methodCore) {
			StringBuffer localBuffer=new StringBuffer();
			localBuffer.append("public static void "+methodName+"(String args[])");
			insertOpenBracket(localBuffer);
			localBuffer.append(methodCore);
			insertCloseBracket(localBuffer);
			return localBuffer.toString();
		}
		public String createComent(String coment){
			String[] pattern={"//"+coment,"/*"+coment+"*/"};
			return pattern[1];
		}
		public String createMethodCore(List<String> expressions){
			StringBuffer buffer=new StringBuffer();
			for(String value : expressions){insertCarriageReturn(buffer);buffer.append(value);}
			return buffer.toString();
		}
		public String createLoop(int count){StringBuffer localBuffer=new StringBuffer();
			localBuffer.append("for(int i=0;i<"+count+";i++)");
			insertOpenBracket(localBuffer);
			localBuffer.append("System.out.println(\"Hello JavaEditorOne 0.0.0 Iteration \"+i);");
			insertCloseBracket(localBuffer);
			return localBuffer.toString();
		}
		private void insertOpenBracket(StringBuffer buffer){insertBlank(buffer);
			buffer.append("{");insertCarriageReturn(buffer);
		}
		private void insertCloseBracket(StringBuffer buffer){insertCarriageReturn(buffer);
			buffer.append("}");insertCarriageReturn(buffer);
		}
		private void insertBlank(StringBuffer buffer){buffer.append(" ");}
		private void insertCarriageReturn(StringBuffer buffer){buffer.append("\n");}
	}
	// ---------- //
	public class FileManager{
		/**applogger*/private AppLogger appLogger;
		/**curDirec*/private String currDirectory;
		/**
		 * Constructor
		 * @param logger application logger
		 */
		public FileManager(AppLogger logger){this.appLogger=logger;
			try{currDirectory=System.getProperty("user.dir");
				appLogger.debug("Current Directory: ["+currDirectory+"]");
				Directorys.createDirectory(currDirectory, AppConstants.WORKSPACE);
				AppConstants.WORKSPACE_PATH=currDirectory+"/"+AppConstants.WORKSPACE+"/";
				appLogger.debug("Workspace Directory: ["+AppConstants.WORKSPACE_PATH+"]");
			}catch(IOException e){appLogger.debug(e.getMessage());}
		}
		public boolean writeJavaFileInWorkspace(String fileName,String fileContent){
			String fileExtension="";String fileNameWithoutExtension="";
			if(fileName.endsWith(Files.FILE_JAVA)){fileExtension=Files.FILE_JAVA;
				fileNameWithoutExtension=fileName.replace(fileExtension,"");
			}else if(fileName.endsWith(Files.FILE_PYTHON)){fileExtension=Files.FILE_PYTHON;
				fileNameWithoutExtension=fileName.replace(fileExtension,"");
			}else if(fileName.endsWith(Files.FILE_HTML)){fileExtension=Files.FILE_HTML;
				fileNameWithoutExtension=fileName.replace(fileExtension,"");
			}
			
			try{return Files.createFile(AppConstants.WORKSPACE_PATH,
						fileNameWithoutExtension,fileExtension,fileContent);
			} catch(IOException e){appLogger.debug(e.getMessage());}
			return false;
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class AboutUsDialog{private static final int DIALOG_WIDTH=300;private static final int DIALOG_HEIGHT=300;
		/**parentFrame*/private JFrame parentFrame;
		/**
		 * Constructor
		 * @param parParentFrame
		 */
		public AboutUsDialog(JFrame parParentFrame){this.parentFrame=parParentFrame;}
		/**
		 * shows the dialog
		 */
		public void showDialog(){
			/*create a table to show the about us information*/
			JTable table=new JTable(AppConstants.ABOUTUS_ROWS, AppConstants.ABOUTUS_COLUMNS);
			table.setEnabled(false);
			/*let this table be scrollable*/
			JScrollPane scrollPane=new JScrollPane(table);
			/*create a new panel and assign the scrollable table*/
			JPanel panel=new JPanel(new BorderLayout());
			panel.add(scrollPane, BorderLayout.CENTER);
			/**create a new dialog using the class JOptionPane to let the new created dialog
			 **be centered relatively to the parent window and control buttons are also added*/
			JOptionPane pane=new JOptionPane(panel);
			JDialog dialog=pane.createDialog(parentFrame, AppConstants.get(AppBundle.DIALOG_ABOUTUS_TITLE)); // $NON-NLS-1$
			/**set parameters for the dialog and show*/
			dialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
			dialog.setVisible(true);
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class EditorFileChooser extends JFileChooser{
		private static final long serialVersionUID=-8926265627006019935L;
		/**parent*/private Component parent;
		/**
		 * Constructor
		 * @param parent parent component
		 */
		public EditorFileChooser(Component parent){
			super(new File("C:\\@PHLETON-ALL-IN-ONE\\PHLETON-PROJECTS\\JAVAONE\\trunk\\JavaEditorOne-v0.0.0\\workspace"));
			this.parent=parent;
		}
		/**showing the dialog
		 * @return
		 */
		public int showDialog(){return super.showOpenDialog(parent);
			/*setDialogType(OPEN_DIALOG);*/
	        /*return super.showDialog(parent, null);*/
		}
		@Override
		public void setCurrentDirectory(File dir){super.setCurrentDirectory(dir);}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIANewFileDialog extends JDialog{private static final long serialVersionUID=-8926265627006019935L;
		/**parent*/private Component parent;
		/**mainDialogComponent*/private JPanel main;
		/**filenameToCreate*/private JTextField tfFileName;
		private JRadioButton rbnJava;
		private JRadioButton rbnPython;
		private JRadioButton rbnHTML;
		/***Constructor*@param parent parentComponent*/
		public DIANewFileDialog(Component parent){this.parent=parent;main=new JPanel();createGUI();}
		/***create the GUI for the dialog*/
		public void createGUI(){
			JLabel lblJavaFileName=new JLabel(AppConstants.get(AppBundle.LBL_NEWFILE_NAME));
			tfFileName=new JTextField("");/*AppConstants.TEMPLATE_JAVA_FILE_NAME);*/
			tfFileName.setSize(this.getWidth(),30);
			rbnJava=new JRadioButton(AppConstants.get(AppBundle.JAVA),true);
			rbnPython=new JRadioButton(AppConstants.get(AppBundle.PYTHON),false);
			rbnHTML=new JRadioButton(AppConstants.get(AppBundle.HTML),false);
			/*TODO DONE23APR2020<MKK>22APR2020>14h13mn>addGrouping4RadioButtons*/
			ButtonGroup group=new ButtonGroup();
			group.add(rbnJava);
			group.add(rbnPython);
			group.add(rbnHTML);
			/*addElements*/main.setLayout(new GridLayout(3,2));
			main.add(lblJavaFileName);main.add(tfFileName);
			main.add(rbnJava);main.add(rbnPython);
			main.add(rbnHTML);
			/*TODO MKK>22APR2020>14h13mn>setFocusOnFilename*/tfFileName.requestFocus();
		}
		/**
		 * showing the dialog 
		 * @return
		 */
		public int showDialog(){int status=JOptionPane.showConfirmDialog(parent, main, AppConstants.get(AppBundle.DIALOG_NEWFILE_TITLE),JOptionPane.OK_OPTION);
			if(tfFileName.getText().equals("")){status=JOptionPane.NO_OPTION;}
			return status;
		}
		/**
		 * Get the name of the java file to create
		 * @return the java filename
		 */
		public String getFileName(){return tfFileName.getText().trim();}
		public boolean isJavaSelected(){return rbnJava.isSelected();}
		public boolean isSelectedPython(){return rbnPython.isSelected();}
		public boolean isSelectedHTML(){return rbnHTML.isSelected();}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIARenameFileDialog extends JDialog{
		private static final long serialVersionUID=-8926265627006019935L;
		/**parent*/private Component parent;
		/**mainPanel*/private JPanel mainPanel;
		/**filename4JavaClassToCreate*/private JTextField tfJavaFileName;
		/**filenameToChange*/private String filenameToChange;
		/**
		 * Constructor
		 * @param parent parent component
		 */
		public DIARenameFileDialog(Component parent, String filename){super();
			this.parent=parent;this.filenameToChange=filename;
			mainPanel=new JPanel();createGUI();
		}
		/**
		 * create GUI
		 */
		public void createGUI(){JLabel lblNewFileName=new JLabel(AppConstants.get(AppBundle.LBL_RENAME_FILE_NAME));
			tfJavaFileName=new JTextField(filenameToChange);
			/*addElements*/mainPanel.setLayout(new GridLayout(1, 2));
			mainPanel.add(lblNewFileName);mainPanel.add(tfJavaFileName);
		}
		/**
		 * showing the dialog
		 * @return
		 */
		public int showDialog() {int status=JOptionPane.showConfirmDialog(parent, mainPanel, AppConstants.get(AppBundle.DIALOG_RENAME_FILE_TITLE),JOptionPane.OK_OPTION);
			if (tfJavaFileName.getText().equals("")){status=JOptionPane.NO_OPTION;}
			return status;
		}
		/**
		 * Get the java file name 
		 * @return
		 */
		public String getJavaFileName(){return tfJavaFileName.getText().trim()+AppConstants.FILE_EXTENSION_JAVA;}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIAShortcutsDialog{/**parentFrame*/private JFrame parentFrame;
		/**
		 * Constructor
		 * @param parParentFrame
		 */
		public DIAShortcutsDialog(JFrame parParentFrame){this.parentFrame=parParentFrame;}
		/**
		 * shows the dialog
		 */
		public void showDialog(){JPanel shortcutPanel=new JPanel(new BorderLayout());
			JTable table=new JTable(AppConstants.SHORTCUTS_ROWS,AppConstants.SHORTCUTS_COLUMNS);
			JScrollPane scrollPane=new JScrollPane(table);
			table.setEnabled(false);
			shortcutPanel.add(scrollPane, BorderLayout.CENTER);
			JOptionPane pane=new JOptionPane(shortcutPanel);
			JDialog dialog=pane.createDialog(parentFrame, AppConstants.get(AppBundle.DIALOG_SHORTCUTS_TITLE)); // $NON-NLS-1$
			dialog.setVisible(true);
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIASettingsDialog{/**parentFrame*/private JFrame parentFrame;
		/**
		 * Constructor
		 * @param parParentFrame
		 */
		public DIASettingsDialog(JFrame parParentFrame){this.parentFrame=parParentFrame;}
		/**
		 * shows the dialog
		 */
		public void showDialog(){JPanel shortcutPanel=new JPanel(new BorderLayout());
			JTable table=new JTable(AppConstants.SHORTCUTS_ROWS,AppConstants.SHORTCUTS_COLUMNS);
			JScrollPane scrollPane=new JScrollPane(table);
			table.setEnabled(false);
			shortcutPanel.add(scrollPane,BorderLayout.CENTER);
			JOptionPane pane=new JOptionPane(shortcutPanel);
			JDialog dialog=pane.createDialog(parentFrame,
					AppConstants.get(AppBundle.DIALOG_SETTINGS_TITLE));/*$NON-NLS-1$*/
			dialog.setVisible(true);
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIAFindDialog extends JDialog implements ActionListener{
		private static final long serialVersionUID=5674876539031216457L;
		private static final int DIALOG_WIDTH=300;private static final int DIALOG_HEIGHT=300;
		// -> parent frame
		private JFrame parentFrame;
		// -> editor
		private IJavaEditor editor;
		// -> text fields
		private JTextField tfFindField;
		// -> buttons
		private JButton btnFind;
		private JButton btnFindCloseDialog;
		/**
		 * Constructor
		 * @param parParentFrame
		 */
		public DIAFindDialog(JFrame parParentFrame, IJavaEditor javaEditor){
			super(parParentFrame, AppConstants.get(AppBundle.DIALOG_FIND_TITLE));
			this.parentFrame=parParentFrame;this.editor=javaEditor;
			createGUI();
		}
		/**
		 * Create UI-elements
		 */
		private void createGUI() {
			/**create ui-elements for the dialog*/
			//->labels
			JLabel lblFindField=new JLabel(AppConstants.get(AppBundle.LBL_FIND_WHAT));
			//->textFields
			tfFindField=new JTextField(20);
			btnFind=new JButton(AppConstants.get(AppBundle.LBL_FIND_NEXT));
			//->buttons
			btnFindCloseDialog=new JButton(AppConstants.get(AppBundle.BTN_FIND_CLOSE));
			//->register4actions
			btnFind.addActionListener(this);
			btnFindCloseDialog.addActionListener(this);
			/**
			 * FIND -> top
			 */
			JPanel panelTop=new JPanel();
			panelTop.setLayout(new FlowLayout());
			panelTop.add(lblFindField);
			panelTop.add(tfFindField);
			/**
			 * FIND -> center
			 */
			JPanel panelCenter=new JPanel();
			panelCenter.setLayout(new FlowLayout());
			JButton btnElemC1=new JButton();
			JButton btnElemC2=new JButton();
			btnElemC1.setVisible(false);
			btnElemC2.setVisible(false);
			panelCenter.add(btnElemC1);
			panelCenter.add(btnFind);
			panelCenter.add(btnElemC2);
			/**
			 * FIND -> bottom
			 */
			JPanel panelBottom=new JPanel();
			panelBottom.setLayout(new FlowLayout());
			JButton btnElemB1=new JButton();
			JButton btnElemB2=new JButton();
			btnElemB1.setVisible(false);
			btnElemB2.setVisible(false);
			panelBottom.add(btnElemB1);
			panelBottom.add(btnElemB2);
			panelBottom.add(btnFindCloseDialog);
			/**
			 * add the panels
			 */
			JPanel jpFind=new JPanel();
			jpFind.setLayout(new BorderLayout());
			jpFind.add(panelTop, BorderLayout.NORTH);
			jpFind.add(panelCenter, BorderLayout.CENTER);
			jpFind.add(panelBottom, BorderLayout.SOUTH);
			// add the finder panel into the dialog
			add(jpFind);
		}

		/**
		 * shortcuts
		 */
		public void showDialog(){pack();
			setResizable(false);setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
            /*setLocationRelativeTo(this.parentFrame);*/
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e){
			if(btnFind.equals(e.getSource())){findNext();}
			else if (btnFindCloseDialog.equals(e.getSource())){closeDialog();}
		}
		private void findNext(){String editorData=editor.getJavaCode();
			String toFindContent=tfFindField.getText();
			int caretPosition=editor.getCaretPosition();
			int findlen=toFindContent.length();
			int findIdx=editorData.indexOf(toFindContent, caretPosition);
			int foundPositionStart=findIdx;
			int foundPositionEnd=foundPositionStart+findlen;
			if(foundPositionStart>=0){editor.requestFocus();
				editor.setSelectedJavaCode(foundPositionStart, foundPositionEnd);
				caretPosition=findIdx+findlen;
			}else{
				JOptionPane.showMessageDialog(parentFrame, "No Search results were found!", "Search Result",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		private void closeDialog(){this.setVisible(false);this.dispose();}
		public String getFindValue(){return "?";}
//		private void operationFindPrevious() {
//			appLogger.infoHighlighted("find data="+find);
//			// String find= jt1.getText();
//			stringData=textareaOfOpenedFiles[selectedTab+1].getText();
//			int findlen=find.length();
//			caretPosition=textareaOfOpenedFiles[selectedTab+1].getCaretPosition();
//			int p=caretPosition - findlen - 1;
//			findindex=stringData.lastIndexOf(find, p);
//			appLogger.infoHighlighted("find pre="+caretPosition);
//			appLogger.infoHighlighted("new index="+findindex);
//			int p0=findindex;
//			int p1=findindex+findlen;
//			if (findindex >= 0) {
//				textareaOfOpenedFiles[selectedTab+1].requestFocus();
//				textareaOfOpenedFiles[selectedTab+1].select(p0, p1);
//			} else {
//				JOptionPane.showMessageDialog(appFrame, "Can't find the text: "+find, "Search Result",
//						JOptionPane.ERROR_MESSAGE);
//			}
//		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIAFindReplaceDialog extends JDialog implements ActionListener{
		private static final long serialVersionUID=5674876539031216457L;
		private static final int DIALOG_WIDTH=300;
		private static final int DIALOG_HEIGHT=300;
		// -> parent frame
		private JFrame parentFrame;
		// -> editor
		private IJavaEditor editor;
		// -> text fields
		private JTextField tfFindField;
		// -> buttons
		private JButton btnFind;
		private JButton btnFindCloseDialog;
		/**
		 * Constructor
		 * @param parParentFrame
		 */
		public DIAFindReplaceDialog(JFrame parParentFrame, IJavaEditor javaEditor) {
			super(parParentFrame, AppConstants.get(AppBundle.DIALOG_FIND_TITLE));
			this.parentFrame=parParentFrame;
			this.editor=javaEditor;
			createGUI();
		}
		/**
		 * Create UI-elements
		 */
		private void createGUI() {
			/**
			 * create ui-elements for the dialog
			 */
			// -> labels
			JLabel lblFindField=new JLabel(AppConstants.get(AppBundle.LBL_FIND_WHAT));
			// -> text fields
			tfFindField=new JTextField(20);
			btnFind=new JButton(AppConstants.get(AppBundle.LBL_FIND_NEXT));
			// -> buttons
			btnFindCloseDialog=new JButton(AppConstants.get(AppBundle.BTN_FIND_CLOSE));
			// -> register for actions
			btnFind.addActionListener(this);
			btnFindCloseDialog.addActionListener(this);
			/**
			 * FIND -> top
			 */
			JPanel panelTop=new JPanel();
			panelTop.setLayout(new FlowLayout());
			panelTop.add(lblFindField);
			panelTop.add(tfFindField);
			/**
			 * FIND -> center
			 */
			JPanel panelCenter=new JPanel();
			panelCenter.setLayout(new FlowLayout());
			JButton btnElemC1=new JButton();
			JButton btnElemC2=new JButton();
			btnElemC1.setVisible(false);
			btnElemC2.setVisible(false);
			panelCenter.add(btnElemC1);
			panelCenter.add(btnFind);
			panelCenter.add(btnElemC2);
			/**
			 * FIND -> bottom
			 */
			JPanel panelBottom=new JPanel();
			panelBottom.setLayout(new FlowLayout());
			JButton btnElemB1=new JButton();
			JButton btnElemB2=new JButton();
			btnElemB1.setVisible(false);
			btnElemB2.setVisible(false);
			panelBottom.add(btnElemB1);
			panelBottom.add(btnElemB2);
			panelBottom.add(btnFindCloseDialog);
			/**
			 * add the panels
			 */
			JPanel jpFind=new JPanel();
			jpFind.setLayout(new BorderLayout());
			jpFind.add(panelTop, BorderLayout.NORTH);
			jpFind.add(panelCenter, BorderLayout.CENTER);
			jpFind.add(panelBottom, BorderLayout.SOUTH);
			// add the finder panel into the dialog
			add(jpFind);
		}
		private void operationFindAndReplaceOpenDialog() {
			// text fields
			JTextField tfFindValue=new JTextField(5);
			JTextField tfReplaceValue=new JTextField(5);
			// labels
			JLabel lblFind=new JLabel("Find: "); //$NON-NLS-1$
			JLabel lblReplace=new JLabel("Replace: "); //$NON-NLS-1$
			// buttons
			JButton btnFindNext=new JButton("Find Next"); //$NON-NLS-1$
			JButton btnReplacee=new JButton("Replace"); //$NON-NLS-1$
			JButton btnReplaceAll=new JButton("Replace All"); //$NON-NLS-1$
			JButton btnCloseFindReplaceDialog=new JButton("Close Dialog"); //$NON-NLS-1$
			btnFindNext.addActionListener(this);
			btnReplacee.addActionListener(this);
			btnReplaceAll.addActionListener(this);
			btnCloseFindReplaceDialog.addActionListener(this);
			// int result=
			// JOptionPane.showConfirmDialog(null,p6,"Replace",JOptionPane.CLOSED_OPTION);
			JPanel jpFindReplace=new JPanel();
			GridLayout layout=new GridLayout(4, 2);
			layout.setHgap(10);
			layout.setVgap(10);
			jpFindReplace.setLayout(layout);
			jpFindReplace.add(lblFind);
			jpFindReplace.add(tfFindValue);
			jpFindReplace.add(lblReplace);
			jpFindReplace.add(tfReplaceValue);
			jpFindReplace.add(btnFindNext);
			jpFindReplace.add(btnReplacee);
			jpFindReplace.add(btnReplaceAll);
			jpFindReplace.add(btnCloseFindReplaceDialog);
//			dialogForFindReplace=new JDialog(appFrame, "Find And Replace"); //$NON-NLS-1$
//			dialogForFindReplace.add(jpFindReplace);
//			dialogForFindReplace.setResizable(false);
//			dialogForFindReplace.setVisible(true);
//			dialogForFindReplace.setSize(400, 300);
//			dialogForFindReplace.setLocationRelativeTo(appFrame);
//			prevFindIndex=this.getCurrentActiveJavaEditor().getCaretPosition();
		}
		/**
		 * shortcuts
		 */
		public void showDialog(){pack();
			setResizable(false);setSize(DIALOG_WIDTH, DIALOG_HEIGHT);
//			setLocationRelativeTo(this.parentFrame);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e){
			if(btnFind.equals(e.getSource())){findNext();
			}else if(btnFindCloseDialog.equals(e.getSource())){closeDialog();}
		}
		private void findNext(){String editorData=editor.getJavaCode();
			String toFindContent=tfFindField.getText();
			int caretPosition=editor.getCaretPosition();
			int findlen=toFindContent.length();
			int findIdx=editorData.indexOf(toFindContent, caretPosition);
			int foundPositionStart=findIdx;
			int foundPositionEnd=foundPositionStart+findlen;
			if(foundPositionStart>=0){editor.requestFocus();
				editor.setSelectedJavaCode(foundPositionStart, foundPositionEnd);
				caretPosition=findIdx+findlen;
			}else{JOptionPane.showMessageDialog(parentFrame, "No Search results were found!", "Search Result",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		private void closeDialog(){this.setVisible(false);this.dispose();}
		public String getFindValue(){return "?";}
		private void operationFindPrevious(){
//			appLogger.infoHighlighted("find data="+find);
//			// String find= jt1.getText();
//			stringData=textareaOfOpenedFiles[selectedTab+1].getText();
//			int findlen=find.length();
//			caretPosition=textareaOfOpenedFiles[selectedTab+1].getCaretPosition();
//			int p=caretPosition - findlen - 1;
//			findindex=stringData.lastIndexOf(find, p);
//			appLogger.infoHighlighted("find pre="+caretPosition);
//			appLogger.infoHighlighted("new index="+findindex);
//			int p0=findindex;
//			int p1=findindex+findlen;
//			if (findindex >= 0) {
//				textareaOfOpenedFiles[selectedTab+1].requestFocus();
//				textareaOfOpenedFiles[selectedTab+1].select(p0, p1);
//			} else {
//				JOptionPane.showMessageDialog(appFrame, "Can't find the text: "+find, "Search Result",
//						JOptionPane.ERROR_MESSAGE);
//			}
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIAGotoDialog extends JDialog implements ActionListener {
		private static final long serialVersionUID=5674876539031216457L;
		private static final int DIALOG_WIDTH=320;private static final int DIALOG_HEIGHT=150;
		/**window*/private JFrame parentFrame;
		/**editor*/private IJavaEditor editor;
		/**gotoLine*/private JTextField tfGotoLine;
		/**gotoButton*/private JButton btnGo;
		/**closeBtn*/private JButton btnCloseDialogGoto;
		/*** Constructor*@param parParentFrame*/
		public DIAGotoDialog(JFrame parParentFrame,IJavaEditor javaEditor){
			super(parParentFrame,AppConstants.get(AppBundle.DIALOG_GOTO_TITLE));
			this.parentFrame=parParentFrame;this.editor=javaEditor;createGUI();
		}
		/***Create the UI-elements for the GotoDialog*/
		private void createGUI(){/*create ui-elements*/JPanel jpGoto=new JPanel();
			/*->Labels*/JLabel lblGotoFrom=new JLabel(AppConstants.get(AppBundle.LBL_GOTO_FROM));
			/*->LBL*/JLabel lblGotoWantTo=new JLabel(AppConstants.get(AppBundle.LBL_GOTO_TO));
			/*->TextFields*/JTextField tfGotoFrom=new JTextField("");/*+ln[selectedTab+1]);*/
			/*->TxtField*/tfGotoLine=new JTextField();
			/*->Buttons*/btnGo=new JButton(AppConstants.get(AppBundle.BTN_GOTO_GO));
			/*->Btn*/btnCloseDialogGoto=new JButton(AppConstants.get(AppBundle.BTN_GOTO_CLOSE));
			/*->Enabling*/tfGotoFrom.setEnabled(false);/*setParameters->Enabling,ActionListener*/
			/*->ActionListener*/btnGo.addActionListener(this);
			/*->ActionListener*/btnCloseDialogGoto.addActionListener(this);
			/*addingUIElements*/jpGoto.setLayout(new GridLayout(3,2));
			/*addUI*/jpGoto.add(lblGotoFrom)       ;jpGoto.add(tfGotoFrom);
			/*addUI*/jpGoto.add(lblGotoWantTo)     ;jpGoto.add(tfGotoLine);
			/*addUI*/jpGoto.add(btnCloseDialogGoto);jpGoto.add(btnGo);
			/*addPanel2Dialog*/add(jpGoto);
		}
		/***Shortcuts*/
		public void showDialog(){pack();setResizable(false);setSize(DIALOG_WIDTH,DIALOG_HEIGHT);
			setLocationRelativeTo(this.parentFrame);setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e){if(btnGo.equals(e.getSource())){gotoEditor();}else if(this.btnCloseDialogGoto.equals(e.getSource())){closeDialog();}}
		private void gotoEditor(){
			try{int gotoLine=Integer.parseInt(tfGotoLine.getText());
				int caretPosition=editor.getLineStartOffset(gotoLine-1);
				editor.setCaretPosition(caretPosition);this.closeDialog();
			}catch(Exception ex){JOptionPane.showMessageDialog(null, "The entered line number is incorrect!");}
		}
		private void closeDialog(){this.setVisible(false);this.dispose();}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class DIATemplateChooserDialog extends JDialog{private static final long serialVersionUID=-8926265627006019935L;
		private Component parent;
		private JPanel panelForTemplating;
		private JRadioButton btnTemplate1;private JRadioButton btnTemplate2;
		private JRadioButton btnTemplate3;
		private JRadioButton btnTemplate101;
		private JRadioButton btnTemplate102;
		private JRadioButton btnTemplate103;
		private JRadioButton btnTemplate201;
		private ButtonGroup btnGroup;
		private int templateId=-1;
		/**
		 * Constructor
		 * @param parent parent component
		 */
		public DIATemplateChooserDialog(Component parent){this.parent=parent;
		panelForTemplating=new JPanel();createGUI();
		}
		public void createGUI(){final String[] listName={AppBundle.RBTN_FILE_TEMPLATE_1,AppBundle.RBTN_FILE_TEMPLATE_2,AppBundle.RBTN_FILE_TEMPLATE_3,AppBundle.RBTN_FILE_TEMPLATE_101,AppBundle.RBTN_FILE_TEMPLATE_201};	
			final JRadioButton[] list={btnTemplate1,btnTemplate2,btnTemplate3,btnTemplate101,btnTemplate201};
			final int sizeOfList=list.length;
			final MyActionListener actionLisener=new MyActionListener();
			btnGroup=Factorys.getButtongroup();
			panelForTemplating.setLayout(new GridLayout(sizeOfList,1));
			for(int l=0;l<sizeOfList;l++){
				list[l]=Factorys.getRadiobutton(AppConstants.get(listName[l]));
				list[l].addActionListener(actionLisener);
				btnGroup.add(list[l]);
				panelForTemplating.add(list[l]);
				
				if(l==0){btnTemplate1=list[l];}
				if(l==0){btnTemplate1.setSelected(true);templateId=1;}
				if(l==1){btnTemplate2=list[l];}
				if(l==2){btnTemplate3=list[l];}
				if(l==3){btnTemplate101=list[l];}
				if(l==4){btnTemplate201=list[l];}
			}			
		}
		public int showDialog() {JOptionPane.showConfirmDialog(parent,panelForTemplating,AppConstants.get(AppBundle.DIALOG_TEMPLATE_FILE_TITLE),JOptionPane.OK_OPTION);
			return templateId;
		}
		class MyActionListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource().equals(btnTemplate1)){templateId=1;
				}else if (e.getSource().equals(btnTemplate2)){templateId=2;
				}else if(e.getSource().equals(btnTemplate3)){templateId=3;
				}else if(e.getSource().equals(btnTemplate101)){templateId=101;
				}else if(e.getSource().equals(btnTemplate102)){templateId=102;
				}else if(e.getSource().equals(btnTemplate103)){templateId=103;
				}else if(e.getSource().equals(btnTemplate201)){templateId=201;
				}else{templateId=0;}
			}
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public static class Factorys {
		public enum WindowType{s,S,M,L,XL,DEFAULT,MAXIMIZED,FULLSCREEN}
		/**
		 * Window size
		 */
		public static final int WINDOW_WIDTH_XL=1600;public static final int WINDOW_HEIGHT_XL=1200;
		public static final int WINDOW_WIDTH_L=1024;public static final int WINDOW_HEIGHT_L=768;
		public static final int WINDOW_WIDTH_M=800;public static final int WINDOW_HEIGHT_M=600;
		public static final int WINDOW_WIDTH_S=640;public static final int WINDOW_HEIGHT_S=480;
		public static final int WINDOW_WIDTH_s=300;public static final int WINDOW_HEIGHT_s=300;
		public static final int WINDOW_WIDTH=WINDOW_WIDTH_M;public static final int WINDOW_HEIGHT=WINDOW_HEIGHT_M;
		/***Title*/public static final String WINDOW_TITLE="-- ? --";
		/**create and show a window with the default size*/
		public static void createWindowAndShow(){createWindowAndShow(WindowType.DEFAULT);}
		/**
		 * create the window and displaying it
		 * @param windowType passing the window type such as default, s, S, M, L, XL
		 */
		public static void createWindowAndShow(WindowType windowType){JFrame frame=createWindow();frame.setVisible(true);}
		/**
		 * create a window
		 * @return the newly created window
		 */
		public static JFrame createWindow(){return createFrame(WindowType.DEFAULT);}
		/**
		 * create a java frame
		 * @return the newly created frame
		 */
		public static JFrame createFrame(){return createFrame(WindowType.DEFAULT);}
		public static JFrame createFrame(WindowType windowType){
			int width=WINDOW_WIDTH;int height=WINDOW_HEIGHT;
			switch(windowType){
			case s:width=WINDOW_WIDTH_s;height=WINDOW_HEIGHT_s;break;
			case S:width=WINDOW_WIDTH_S;height=WINDOW_HEIGHT_S;break;
			case M:width=WINDOW_WIDTH_M;height=WINDOW_HEIGHT_M;break;
			case L:width=WINDOW_WIDTH_L;height=WINDOW_HEIGHT_L;break;
			case XL:width=WINDOW_WIDTH_XL;height=WINDOW_HEIGHT_XL;break;
			default:break;
			}
			GraphicsConfiguration gc=null;
			JFrame frame=new JFrame(gc);
			frame.setTitle(WINDOW_TITLE.replace("?", windowType.name()));
			frame.setSize(width, height);
			/*frame.setLocation(0, 0);*/
			/*frame.setResizable(false);*/
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			return frame;
		}
		public static JMenuBar getMenubar(){return new JMenuBar();}
		public static JToolBar getToolbar(){return new JToolBar();}
		public static JMenu getMenu(String title){return new JMenu(title);}
		public static JCheckBoxMenuItem getCheckboxMenuItem(String title){return new JCheckBoxMenuItem(title);}
		public static JRadioButtonMenuItem getRadiobuttonMenuItem(String title){return new JRadioButtonMenuItem(title);}
		public static JMenuItem getMenuItem(String title){return new JMenuItem(title);}
		public static JButton getButton(String title){return new JButton(title);}
		public static JToggleButton getToggleButton(String title){return new JToggleButton(title);}
		public static ButtonGroup getButtongroup(){return new ButtonGroup();}
		public static JRadioButton getRadiobutton(String title){return new JRadioButton(title);}
		public static JCheckBox getCheckbox(String title){return new JCheckBox(title);}
		/**
		 * create a visible menu bar based on the menu structure
		 * @param ofMenu
		 * @return
		 */
		public static JMenuBar createMenuBar(String[][] ofMenu, ActionListener actionListener) {
			/*create the visible swing menu bar*/
			if (ListHelper.isEmpty(ofMenu)){return Factorys.getMenubar();}
			/*define the required variables*/
			int rowPointer;String menuName;String menuItemName;String menuItemKey;
			/*create the required menu objects*/
			LocalMenuFactory menuFactory=null;
			IMenu menuAdded;IMenuItem menuItem;
			try{menuFactory=javaEditorOneInstance.new LocalMenuFactory();
				menuFactory.setActionListener(actionListener);
				for(int pointer=0;pointer<ofMenu[0].length;pointer++){
					/*create the swing menu*/
					menuName=ofMenu[0][pointer];
					menuAdded=menuFactory.addMenu(menuName);
					rowPointer=pointer*2+1;
					for (int i=0;i<ofMenu[rowPointer].length;i++) {
						/*createSwingMenuItem*/
						menuItemName=ofMenu[rowPointer][i];
						menuItemKey=ofMenu[rowPointer+1][i];
						menuItem=menuAdded.addItem(menuItemName);
						menuItem.setId(menuItemKey);
						//TODO KAISEL 18APR2020 14:28
						//<li>java.awt.event.KeyEvent.VK_ENTER
					    //* <li>java.awt.event.KeyEvent.VK_TAB
					    /* <li>java.awt.event.KeyEvent.VK_SPACE*/
						//<li>java.awt.event.InputEvent.CTRL_MASK
						//KeyStroke keystroke = KeyStroke.getKeyStroke((char)java.awt.event.KeyEvent.VK_SPACE);
						//new JMenuItem().setAccelerator(keystroke);
						
					}
				}return menuFactory.generate();
			}catch(Exception parEx){parEx.printStackTrace();}
			return null;
		}
		/**
		 * create a visible menu bar based on the menu structure
		 * @param ofMenu
		 * @return
		 */
		public static JToolBar createToolbar(Object[][] ofButtons, ActionListener actionListener) {
			if(ListHelper.isEmpty(ofButtons)){return Factorys.getToolbar();}
			/*define the required variables*/
			String btnName;JButton button;
			/*create the visible swing menu bar*/
			try{JToolBar toolbar=Factorys.getToolbar();
				for (int pointer=0; pointer < ofButtons[0].length; pointer++) {
					/*create the swing menu*/
					btnName=ofButtons[0][pointer].toString();
					button=new JButton(btnName);
					button.setToolTipText(ofButtons[1][pointer].toString());
					button.setIcon((Icon) ofButtons[2][pointer]);
					button.setActionCommand(ofButtons[3][pointer].toString());
					button.addActionListener(actionListener);
					toolbar.add(button);
				}
				return toolbar;
			}catch(Exception parEx){parEx.printStackTrace();}
			return null;
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class LocalMenuFactory extends MenuFactory {
		/**action listener*/private ActionListener listener;
		/**
		 * Constructor
		 */
		LocalMenuFactory(){super();}
		public void setActionListener(ActionListener listener) {
			this.listener=listener;
		}
		/**
		 * Generate a swing menu bar by extracting the menu object creating the menu and
		 * its items using the swing framework.
		 */
		public JMenuBar generate(){LocalMenu localMenu;JMenuBar menubar=Factorys.getMenubar();
			for (IMenu menu:queue){localMenu=new LocalMenu(menu);
				localMenu.setActionListener(listener);
				menubar.add((JMenu) localMenu.generate());
			}return menubar;
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public interface IMenu{
		public void setTitle(String title);
		public String getTitle();
		public void setQueue(Queue<IMenuItem> queue);
		public Queue<IMenuItem> getQueue();
		public IMenuItem addItem();
		public IMenuItem addItem(String title);
		public Object generate();
	}
	/**local menu class used for generating a visible menu using the swing framework.*/
	class LocalMenu extends Menu{
		/**action listener*/
		private ActionListener listener;
		/**
		 * Constructor
		 * @param menu menu object
		 */
		LocalMenu(IMenu menu){super(menu.getTitle());this.setQueue(menu.getQueue());}
		public void setActionListener(ActionListener listener){this.listener=listener;}
		@Override
		public JMenu generate(){LocalMenuItem localMenuItem;
			JMenu menuSWING=Factorys.getMenu(getTitle());
			while(!getQueue().isEmpty()){
				localMenuItem=new LocalMenuItem(getQueue().remove());
				localMenuItem.setActionListener(listener);
				if (localMenuItem.getTitle() == "|"){menuSWING.addSeparator();
				}else{menuSWING.add(localMenuItem.generate());}
			}return menuSWING;
		}
	}
	/**local menu item class used for generating a visible menu item using the swing framework.*/
	class LocalMenuItem extends MenuItem{
		/*action listener*/private ActionListener listener;
		/**
		 * Constructor
		 * @param menuItem menu item object
		 */
		LocalMenuItem(IMenuItem menuItem){setTitle(menuItem.getTitle());setId(menuItem.getId());}
		/**
		 * Setting the action listener
		 * @param listener the action listener to set
		 */
		public void setActionListener(ActionListener listener){this.listener=listener;}
		@Override
		public JMenuItem generate(){
			final String miTitle=getTitle();
			JMenuItem menuItem=Factorys.getMenuItem(miTitle);
			KeyStroke keyStroke=null;
			menuItem.setActionCommand(getId());
			menuItem.addActionListener(listener);
			if(miTitle.equals("")){}
			else if(miTitle.equals("New")){keyStroke=KeyStroke.getKeyStroke(VK_N,CTRL_MASK);}
			else if(miTitle.equals("Open")){/*TODO MKK'DONE'21APR2020:18h51mn55sec*/keyStroke=KeyStroke.getKeyStroke(VK_O,CTRL_MASK);}
			else if(miTitle.equals("Close")){keyStroke=KeyStroke.getKeyStroke(VK_W,CTRL_MASK);}
			else if(miTitle.equals("Save")){keyStroke=KeyStroke.getKeyStroke(VK_S,CTRL_MASK);}
			else if(miTitle.equals("Goto")){keyStroke=KeyStroke.getKeyStroke(VK_G,CTRL_MASK);}
			
			else if(miTitle.equals("UPPER CASE")){keyStroke=KeyStroke.getKeyStroke(VK_U,CTRL_MASK);}
			else if(miTitle.equals("LOWER CASE")){keyStroke=KeyStroke.getKeyStroke(VK_U,SHIFT_MASK);}
			
			else if(miTitle.equals("Shortcuts")){keyStroke=KeyStroke.getKeyStroke(VK_F1,ALT_MASK);}
			else if(miTitle.equals("About Us!")){keyStroke=KeyStroke.getKeyStroke(VK_F2,ALT_MASK);}
			else if(miTitle.equals("Settings!")){keyStroke=KeyStroke.getKeyStroke(VK_F3,ALT_MASK);}
			
			else if(miTitle.equals("Exit")){keyStroke=KeyStroke.getKeyStroke(VK_F4,CTRL_MASK);}
			else if(miTitle.equals("Compile")){keyStroke=KeyStroke.getKeyStroke(VK_F9,CTRL_MASK);}
			else if(miTitle.equals("Run")){keyStroke=KeyStroke.getKeyStroke(VK_F10,CTRL_MASK);}
			else if(miTitle.equals("Compile and Run")){keyStroke=KeyStroke.getKeyStroke(VK_F11,CTRL_MASK);}
			
			else if(miTitle.equals("Zoom In")){keyStroke=KeyStroke.getKeyStroke(VK_SUBTRACT,ALT_MASK);}
			else if(miTitle.equals("Zoom Out")){keyStroke=KeyStroke.getKeyStroke(VK_ADD,ALT_MASK);}
			else if(miTitle.equals("Restore Default Zoom")){keyStroke=KeyStroke.getKeyStroke(VK_O,ALT_MASK);}
			
			if(keyStroke!=null){menuItem.setAccelerator(keyStroke);}
			return menuItem;
		}
	}
	public interface IMenuItem{
		public void setTitle(String title);
		public String getTitle();
		public void setId(String menuItemKey);
		public String getId();
		public Object generate();
	}
	public class Menu implements IMenu {
		/**menuTitle*/private String title;
		/**Stack4MenuItems*/
		private Queue<IMenuItem> queue;
		/**
		 * Constructor
		 */
		public Menu(){this(null);}
		public Menu(String title){queue=new LinkedList<IMenuItem>();setTitle(title);}
		@Override
		public void setTitle(String title){this.title=(title == null)?"":title;}
		@Override
		public String getTitle(){return title;}
		@Override
		public void setQueue(Queue<IMenuItem> queue){this.queue=queue;}
		@Override
		public Queue<IMenuItem> getQueue(){return this.queue;}
		@Override
		public MenuItem addItem(){return addItem(null);}
		@Override
		public MenuItem addItem(String title){MenuItem item=new MenuItem(title);queue.add(item);
		return item;}
		@Override
		public Object generate() {
			return new Object();
		}
		@Override
		public boolean equals(Object obj){
			if (obj instanceof IMenu){Menu menu=(Menu) obj;
				return (this.getTitle().equals(menu.getTitle()) && this.queue.equals(menu.getQueue()));
			}
		return false;}
		@Override
		public String toString(){StringBuffer buffer=new StringBuffer();
			buffer.append("[");buffer.append("title:");buffer.append(this.title);
			buffer.append(",");buffer.append(queue.toString());buffer.append("]");
			return buffer.toString();
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class MenuFactory{
		/***the stack containing all available menu objects*/
		protected Queue<IMenu> queue;
		/**
		 * Constructor
		 */
		protected MenuFactory(){queue=new LinkedList<IMenu>();}
		/**
		 * Adding a newly created menu with an empty title
		 * @return the new menu
		 */
		public IMenu addMenu(){return addMenu(null);}
		/**
		 * Adding a new menu with a title 
		 * @param title title of the menu
		 * @return a newly created menu object
		 */
		public IMenu addMenu(String title){IMenu menu=new Menu(title);queue.add(menu);return menu;}
		/**
		 * Generate visible menus
		 * @return visible object, if available
		 */
		public Object generate(){return new Object();}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public class MenuItem implements IMenuItem{
		/** title of the menu item */private String title;
		/***the id, usually known as the key to identify the menu item when an action occurs*/
		private String id;
		/**
		 * Default Constructor
		 */
		public MenuItem(){this(null);}
		/**
		 * Constructor
		 * @param title title of the menu
		 */
		public MenuItem(String title){setTitle(title);}
		@Override
		public void setTitle(String title){this.title=(title == null)?"":title;}
		@Override
		public String getTitle(){return title;}
		@Override
		public void setId(String key){this.id=key;}
		@Override
		public String getId(){return this.id;}
		@Override
		public Object generate(){return new Object();}
		@Override
		public String toString(){StringBuffer buffer=new StringBuffer();
			buffer.append("[");buffer.append("title:");
			buffer.append(getTitle());buffer.append(",");
			buffer.append("id:");buffer.append(getId());buffer.append("]");
			return buffer.toString();
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public static class ListHelper{
		/**
		 * Check if the collection or list is empty
		 * @param parCollection collection
		 * @return true, if the collection is empty
		 */
		public static boolean isEmpty(Collection<Object> parCollection){return (parCollection == null) || parCollection.isEmpty();}
		/**
		 * Check if the array is empty
		 * @param parArray array
		 * @return true, if the array is empty
		 */
		public static boolean isEmpty(Object[] parArray){return (parArray == null) || parArray.length == 0;}
		public static boolean isNotEmpty(Object[] parArray){return !isEmpty(parArray);}
		/**
		 * Check whether the specified element is contained in the list
		 * @param parList    the list
		 * @param parElement the element to check in the list
		 * @return true, if the element is contained in the list
		 */
		public static boolean contains(Collection<Object> parList, Object parElement){
			if(isEmpty(parList)){return false;}
			return parList.contains(parElement);
		}
		/**
		 * Check whether the specified element is contained in the array
		 * @param parList    the list
		 * @param parElement the element to check in the list
		 * @return true, if the element is contained in the list
		 */
		public static boolean contains(Object[] parList, Object parElement){
			if(isEmpty(parList)){return false;}
			for(int i=0;i<parList.length;i++){if(parList[i].equals(parElement)){return true;}}
			return false;
		}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public static class Directorys{
		/**
		 * Create a directory, if it does not exist, with the specified name
		 * @param directoryPath the path where the directory should be created
		 * @param directoryName the name of the directory
		 * @return true, if the directory was created, unless false.
		 * @throws IOException throw an IOException, when the path is incorrect
		 */
		public static boolean createDirectory(String directoryPath, String directoryName) throws IOException {
			boolean state=false;File path;File directory;
			/*Checks %% Directory creation %%*/
			path=new File(directoryPath);
			if(!path.isDirectory()){throw new IOException("The provided path:["+directoryPath+"] is incorrect!");}
			directory=new File(directoryPath.concat("/").concat(directoryName));
			if(!directory.exists()){state=directory.mkdir();}else{state=true;}
			return state;
		}
	}
	// -------------------------------------------------- //
	public static class Files{
		/**
		 * Defines common file extensions
		 */
		public static final String FILE_TEXT=".txt";
		public static final String FILE_CSV=".csv";
		public static final String FILE_DOC=".doc";
		public static final String FILE_WORD=".docx";
		public static final String FILE_EXCEL_OLD=".xls";
		public static final String FILE_EXCEL=".xlsx";
		public static final String FILE_PDF=".pdf";
		public static final String FILE_ZIP=".zip";
		/**
		 * Common Images
		 */
		public static final String FILE_BMP=".bmp";
		public static final String FILE_PNG=".png";
		public static final String FILE_GIF=".gif";
		public static final String FILE_SVG=".svg";
		/**
		 * PROGRAMMING LANGUAGES
		 */
		public static final String FILE_PHP=".php";
		public static final String FILE_HTML=".html";
		public static final String FILE_HTM=".htm";
		public static final String FILE_CSS=".css";
		public static final String FILE_JS=".js";
		public static final String FILE_C=".c";
		public static final String FILE_JAVA=".java";
		public static final String FILE_PYTHON=".py";
		public static final String FILE_JAVA_COMPILED=".class";
		/**
		 * UNIX OS
		 */
		public static final String FILE_BASH=".bash";
		/**
		 * WINDOWS OS
		 */
		public static final String FILE_EXE=".exe";
		public static final String FILE_BAT=".bat";
		/**
		 * Defines filters on the common file extensions
		 */
		public static final String[] FILTER_FILES_JAVA=new String[]{FILE_JAVA};
		public static final String[] FILTER_FILES_DOC=new String[]{FILE_TEXT,FILE_DOC,FILE_WORD };
		public static final String[] FILTER_FILES_EXCEL=new String[]{FILE_EXCEL,FILE_EXCEL_OLD };
		public static final String[] FILTER_FILES_PDF=new String[]{FILE_PDF};
		/**
		 * This method creates a new file (if it does not exist) into the current folder of
		 * the hard drive and set its content.
		 * @param fileName    the name of the file to write
		 * @param fileContent the string content of the file
		 * @return true, if the file was written, unless an IO-Exception is generated.
		 * @throws IOException throw the IO-Exception
		 */
		public static boolean createFile(String fileName, String fileContent) throws IOException {
			if (StringHelper.isEmpty(fileName)) return false;
			return createFile("", fileName, "", fileContent);
		}
		/**
		 * This method creates a new file, if does not exist, into the specified path,
		 * along with the specified file extension.
		 * @param filePath      the directory path where to create the file
		 * @param fileName      the name of the file to write
		 * @param fileExtension the file type or file extension
		 * @param fileContent   the string content of the file
		 * @return true, if the file was created and filled with its content
		 * @throws IOException throw the IO-Exception
		 */
		public static boolean createFile(String filePath, String fileName, String fileExtension, String fileContent)
				throws IOException{
			boolean state=false;
			File path;File file;PrintWriter printwriter=null;
			/*Checks*/
			path=new File(filePath);
			if (!path.isDirectory()) {
				throw new IOException("The provided path:["+filePath+"] is uncorrect!");
			}
			file=new File(filePath.concat(fileName).concat(fileExtension));
			if(!file.exists()){file.createNewFile();}
			/*Creation*/
			try(FileWriter filewriter=new FileWriter(file)){
				printwriter=new PrintWriter(filewriter);
				printwriter.println(fileContent);
				printwriter.flush();
				state=true;
			}catch(IOException ex){throw ex;
			}finally{if(printwriter != null){printwriter.close();}}
			return state;
		}
	}
	public static class StringHelper extends Strings{
		public static final String EMPTY_STRING="";
		public static final String NONE_STRING="????";
		/**
		 * Constructor
		 * @param value string value
		 */
		public StringHelper(String value){super(value);}
		public boolean isEmpty(){return isEmpty(this.str);}
		public boolean isNotEmpty(){return isNotEmpty(this.str);}
		public String trim(){return trim(this.str);}
		/**
		 * Trim empty spaces at the begin/end of the string
		 * @param parValue the string value
		 * @return the trimmed string
		 */
		public static String trim(String parValue){return parValue.trim();}		
		/**
		 * Check whether the string is nullable or empty
		 * @param parValue the string value
		 * @return true, if the string is empty
		 */
		public static boolean isEmpty(String parValue){return parValue==null||parValue=="";}
		/**
		 * The inverse operation of the method isEmpty
		 * @param parValue the string value
		 * @return true, if the string is not empty
		 */
		public static boolean isNotEmpty(String parValue) {
			return !isEmpty(parValue);
		}
		/**
		 * Convert String value to integer
		 * @param parValue String value
		 * @return integer value
		 */
		public static int convertToInteger(String parValue, int parDefaultValue){
			int value=parDefaultValue;
			try{value=Integer.valueOf(parValue.trim());
			}catch(NumberFormatException parEx){value=parDefaultValue;}
		return value;}
		/**
		 * Convert any kind of object to String
		 * @param parValue value
		 * @param parDefaultValue the default value
		 * @return the returned string
		 */
		public static String convertToString(Object parValue,String parDefaultValue){
			String value=parDefaultValue;
			if(parValue instanceof String){value=(String) parValue;
				value=value.equals(EMPTY_STRING) ? parDefaultValue : value;
			}else if(parValue instanceof Integer){return convertIntegerToString((int)parValue,parDefaultValue);
			}else{value=(parValue == null) ? parDefaultValue : ((Object) parValue).toString();
			}
			return value;
		}
		/**
		 * Convert integer value to string
		 * @param parValue
		 * @param parDefaultValue
		 * @return
		 */
		private static String convertIntegerToString(int parValue,String parDefaultValue){
			String value=parDefaultValue;
			try{value=String.valueOf(parValue);
			}catch(NumberFormatException parEx){value=parDefaultValue;}
		return value;}
	}
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	public static class Strings{public static final String CR="\r";
		public static final String TAB="\t";
		public static final String NEWLINE="\n";
		public static final String EMPTY="";public static final String BLANK=" ";
		public static final String UNKNOWN="?";public static final String WHITESPACE=" ";
		public static final String SEPARATOR=";";
		public static final String SEPARATOR_COMMA=",";
		public static final String SEPARATOR_SEMICOLON=";";
		public static final String SYMBOL_MINUS="-";
		public static final String SYMBOL_BAR="|";
		public static final String SYMBOL_HASH="#";
		public static final String SYMBOL_DOLLAR="$";
		public static final String SYMBOL_PERCENT="%";
		public static final String SYMBOL_UNDERSCORE="_";
		public static final String SYMBOL_MINUS_DOPPEL="--";
		public static final String SYMBOL_BAR_DOPPEL="||";
		public static final String SYMBOL_UNDERSCORE_DOPPEL="__";
		public static final String SYMBOL_HIGHER=">>";
		public static final String SYMBOL_LOWER="<<";
		public static final String BINARY_ZERO="0";
		public static final String BINARY_ONE="1";
		/** string */protected String str;
		/**
		 * Constructor
		 * @param str string
		 */
		public Strings(String str){this.str=str;}
		public String reverse(){StringBuffer bfr=getBfr();
			for(int i=str.length()-1;i>=0;i--){bfr.append(str.charAt(i));}
			return bfr.toString();
		}
		public String reverse(String parStr){StringBuffer bfr=getBfr();
			for (int i=parStr.length()-1;i>=0;i--){bfr.append(parStr.charAt(i));}
			return bfr.toString();
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		/**
		 * Repeat a symbol to the given repeat count
		 * @param symbol the symbol for repeat
		 * @param count  the number of times the symbol should be repeated
		 * @return a new string with the repeated symbol
		 */
		public static String repeat(String symbol,int count) {
			StringBuffer buffer=getBfr();
			for(int i=0;i<count;i++){buffer.append(symbol);}
			return buffer.toString();
		}
		/**
		 * Repeat a symbol to the given repeat count and add a carriage return to the
		 * generated string.
		 * 
		 * @param symbol the symbol for repeat
		 * @param count  the number of times the symbol should be repeated
		 * @return a new string with the repeated symbol
		 */
		public String repeatln(String symbol, int count){StringBuffer buffer=getBfr();
			for (int i=0;i<count;i++){buffer.append(symbol);}
			buffer.append(CR);return buffer.toString();
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		/**
		 * Repeat a specific symbol x-times and add a content in the middle of the
		 * string object and lastly add a carriage return and return the string object.
		 * 
		 * @param symbol the symbol for repeat
		 * @param count  the number of times the symbol should be repeated
		 * @return a new string with the repeated symbol
		 * @return a new string with the repeated symbol
		 */
		public String repeatln(String symbol, String content, int count) {
			return repeat(symbol, null, content, null, count, false);
		}
		/**
		 * Repeat a specific symbol x-times and add a content in the middle of the
		 * string object, without adding a carriage return, and return the string
		 * object.
		 * 
		 * @param symbol the symbol for repeat
		 * @param count  the number of times the symbol should be repeated
		 * @return a new string with the repeated symbol
		 * @return a new string with the repeated symbol
		 */
		public String repeat(String symbol, String content, int count) {
			return repeat(symbol, null, content, null, count, false);
		}
		// -------------------------------------------------- //
		// -------------------------------------------------- //
		/**
		 * This main, standard and expert repeat-function to repeat a given symbol. The
		 * function add start/end symbol at the start/end of the string, and a content
		 * message is added in the middle of the string, at the end of the generated
		 * string a carriage return is added, if it is requested.
		 * @param symbol         the symbol to repeat
		 * @param startSymbol    the start symbol
		 * @param content
		 * @param endSymbol      the end symbol
		 * @param count          how many time should the symbol be repeated, however
		 *                       the start/end symbol are not counted, only the content
		 *                       message length is subtracted from the repetition
		 *                       count,
		 * @param carriageReturn true, if to add a carriage return at the end
		 * @return the created string
		 */
		public static String repeat(final String symbol, final String startSymbol, final String content,
				final String endSymbol, final int count, final boolean carriageReturn) {
			/*the start/end and content message should be not nullable, unless an empty string is assigned*/
			final String symbolB=(startSymbol != null) ? startSymbol : EMPTY;
			final String symbolE=(endSymbol != null) ? endSymbol : EMPTY;
			/*the content message if filled, will get blank string at start/end of the message*/
			String contentProvider=content;
			if(content != null && !"".equals(content)){contentProvider=BLANK+content+BLANK;
			}else{contentProvider=EMPTY;}
			/*CalculatePatternLength*/
			int repeatLength=count * symbol.length();
			int repeatFactor=repeatLength - (contentProvider.length());
			repeatFactor=(repeatFactor / symbol.length()) / 2;
			final int repeatAtLeft=repeatFactor;
			final int repeatAtRight=repeatLength-repeatAtLeft-(contentProvider.length());
			StringBuffer buffer=new StringBuffer();
			buffer.append(symbolB);
			buffer.append(repeat(symbol, repeatAtLeft));
			buffer.append(contentProvider);
			buffer.append(repeat(symbol, repeatAtRight));
			buffer.append(symbolE);
			if(carriageReturn){buffer.append(CR);}
			/*create the string object*/return buffer.toString();
		}
		public static StringBuffer getStringBuffer(){return getBfr();}
		public static StringBuffer getStringbuffer(){return getBfr();}
		public static StringBuffer getStgBfr(){return getBfr();}
		public static StringBuffer getStgbfr(){return getBfr();}
		public static StringBuffer getBfr(){return new StringBuffer();}
	}
}