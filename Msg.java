package mod;

import javax.swing.JOptionPane;

public class Msg {
	
	// Print to console without skipping a line.
	public static void print(Object o) {
		System.out.print(o);
	}

	// Print to console and skip a line.
	public static void println(Object o) {
		System.out.println(o);
	}
	
	// Send a message
	public static void msg(Object o) {
		JOptionPane.showMessageDialog(null, o);
	}
	
	// User input
	public static String in(Object o) {
		return JOptionPane.showInputDialog(o);
	}
	
	// Yes or No Option
	public static int yN(String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
	}
	
	// Yes, No or Cancel Option
	public static int yNC(String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 0);
	}
	
	// Custom Options
	// Note: Options can be String Arrays or
	// Image arrays or other things.
	public static int opt(Object[] options, String msg, String title) {
		return JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, 0);
	}
	

	
}