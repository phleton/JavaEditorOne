package com.kapur.app;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * The main constants for the application.
 * 
 * @author PHLETON
 * @date 10.11.2018
 * @revision 11.11.2018
 *
 */
public class AppConstants {
	
	public static final String APPLICATION_VERSION = "0.1.0";

	/**
	 * The JAVA_PATH has to be changed according for your system SDK version
	 * in or to be able to compile and run the java file
	 */
	public static final String JAVA_PATH = "/Library/Java/JavaVirtualMachines/jdk1.8.0_181.jdk/Contents/Home/bin/";

	public static final String TEMPLATE_NEW_FILE = "resources/templates/newfile.txt";
	private static final String APP_BUNDLE_FILEPATH = "properties/application";
	
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	
	/** application resource bundle */
	private static ResourceBundle appResourceBundle;

	static {
		appResourceBundle = ResourceBundle.getBundle(APP_BUNDLE_FILEPATH, Locale.ENGLISH);
	}

	/**
	 * Getting the label given the property name
	 * @param parPropertyName property name
	 * @return the label
	 */
	public static String getString(String parPropertyName) {
		if (appResourceBundle.containsKey(parPropertyName)) {
			return appResourceBundle.getString(parPropertyName);
		}
		return "?";
	}
	
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //

	public static final String SHORTCUTS_COLUMNS[] = { "Name", "Shortcut" };
	public static final String SHORTCUTS_ROWS[][] = { { "New File", "Ctrl+N" }, { "Open File", "Ctrl+O" },
			{ "Save File", "Ctrl+S" }, { "Save as File", "Ctrl+shift+S" }, { "Close File", "Ctrl+W" },
			{ "Print File", "Ctrl+P" }, { "Exit", "Alt+F4" }, { "Undo", "Ctrl+Z" }, { "Redo", "Ctrl+Y" },
			{ "Cut", "Ctrl+X" }, { "Copy", "Ctrl+C" }, { "Paste", "Ctrl+P" }, { "Delete", "DEL" },
			{ "Select All", "Ctrl+A" }, { "UPPERCASE", "Ctrl+U" }, { "lowercase", "Ctrl+l" }, { "Find", "Ctrl+F" },
			{ "Find Next", "F3" }, { "Find Previous", "Shift+F3" }, { "Replace", "Ctrl+H" }, { "Go To", "Ctrl+G" },
			{ "Zoom In", "Ctrl+Numpad+" }, { "Zoom Out", "Ctrl+Numpad-" }, { "Default Zoom", "Ctrl+Equals" },
			{ "1st Tab", "Ctrl+Numpad 1" }, { "2nd Tab", "Ctrl+Numpad 2" }, { "3rd Tab", "Ctrl+Numpad 3" },
			{ "4th Tab", "Ctrl+Numpad 4" }, { "5th Tab", "Ctrl+Numpad 5" }, { "Next Tab", "Ctrl+ Page Up" },
			{ "Previous Tab", "Ctrl+Page Down" }, { "Compile", "ctrl+F9" }, { "Run", "ctrl+F10" },
			{ "Compile and Run", "F9" } };

	// -------------------------------------------------- //
	// -------------------------------------------------- //
	// -------------------------------------------------- //
	
	public static final Icon ICON_NEW = new ImageIcon("images/new.gif");
	public static final Icon ICON_OPEN = new ImageIcon("images/open.gif");
	public static final Icon ICON_SAVE = new ImageIcon("images/save.gif");
	public static final Icon ICON_SAVE_AS = new ImageIcon("images/saveas.gif");
	public static final Icon ic5 = new ImageIcon("images/cut.gif");
	public static final Icon ic6 = new ImageIcon("images/copy.gif");
	public static final Icon ic7 = new ImageIcon("images/paste.gif");
	public static final Icon ic8 = new ImageIcon("images/undo.gif");
	public static final Icon ic9 = new ImageIcon("images/redo.gif");
	public static final Icon ic10 = new ImageIcon("images/find.gif");
	public static final Icon ic11 = new ImageIcon("images/replace.gif");
	public static final Icon ic12 = new ImageIcon("images/zoomin.gif");
	public static final Icon ic13 = new ImageIcon("images/zoomout.gif");
	public static final Icon ICON_COMPILE = new ImageIcon("images/compile.gif");
	public static final Icon ICON_RUN = new ImageIcon("images/run.gif");
	public static final Icon ICON_COMPILE_RUN = new ImageIcon("images/compilerun.gif");
	public static final Icon ic17 = new ImageIcon("images/startr.gif");
	public static final Icon ic18 = new ImageIcon("images/pauser.gif");
	public static final Icon ic19 = new ImageIcon("images/stopr.gif");
	public static final Icon ic20 = new ImageIcon("images/saver.gif");
	public static final Icon ic21 = new ImageIcon("images/close.gif");
	public static final Icon ic22 = new ImageIcon("images/closeall.gif");
	public static final Icon ic23 = new ImageIcon("images/no.gif");

}
