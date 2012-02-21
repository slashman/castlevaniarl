package sz.util;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Debug {

	static int methodLevel;

	final static boolean debug = false;
	final static boolean timing = false;
	final static boolean gossip = false;
/*
	static JTextArea testArea;
	static {
		if (debug){
			JFrame testFrame = new JFrame();
			testArea = new JTextArea();
			testArea.setLineWrap(true);
			testArea.setWrapStyleWord(true);
			testFrame.getContentPane().setLayout(new GridLayout(1,1));
			testFrame.getContentPane().add(new JScrollPane(testArea));
			testFrame.setBounds(0,0,400,500);
			testFrame.setVisible(true);
		}
		
	}*/
	static long firstTimer, lastTimer;

	public static void startTimer(){
		if (timing)
			firstTimer = System.currentTimeMillis();
	}

	public static void stopTimer(String desc){
		if (timing){
        	lastTimer = System.currentTimeMillis();
			System.out.println("Timing for "+desc+": "+(lastTimer-firstTimer));
		}
	}

	public static void enterStaticMethod(String classs, String method){
		if (!debug) return;
			methodLevel++;
		//System.out.println(spaces(methodLevel) + "-"+cls.getClass().getName()+"."+method+"()");
		System.out.println(spaces(methodLevel) + "-"+classs+"."+method+"()");
		//testArea.append(spaces(methodLevel) + "-"+classs+"."+method+"()");
	}

	public static void enterMethod(Object cls, String method, Object params){
		if (!debug) return;
		methodLevel++;
		//System.out.println(spaces(methodLevel) + "-"+cls.getClass().getName()+"."+method+"("+params+")");
		//System.out.println(spaces(methodLevel) + "-"+cls+"("+cls.getClass().getName()+")."+method+"("+params+")");
		System.out.println(spaces(methodLevel) + "-"+cls+"."+method+"("+params+")");
		//testArea.append(spaces(methodLevel) + "-"+cls+"."+method+"("+params+")");
	}

	public static void enterMethod(Object cls, String method){
		if (!debug) return;
		methodLevel++;
		//System.out.println(spaces(methodLevel) + "-"+cls.getClass().getName()+"."+method+"()");
		System.out.println(spaces(methodLevel) + "-"+cls+"."+method+"()");
		//testArea.append(spaces(methodLevel) + "-"+cls+"."+method+"()");
	}

	/*public static void doAssert(boolean expression){

		if (!expression){
			System.out.println("Programming Assertion Failed");
			System.exit(0);
		}
	} */

	public static void doAssert(boolean expression, String msg){
		if (!expression){
			System.out.println("Programming Assertion Failed:"+msg);
			System.exit(0);
		}
	}

	public static void exitExceptionally(Throwable why){
		if (!debug) return;
		System.out.println(spaces(methodLevel) +"throws "+why);
		methodLevel--;
	}
	
	public static void exitMethod(){
		if (!debug) return;
		System.out.println(spaces(methodLevel) +"-done.");
		//testArea.append(spaces(methodLevel) +"-done");
		methodLevel--;
	}

	public static void exitMethod(Object returns){
		if (!debug) return;
		System.out.println(spaces(methodLevel) +"-done, returns "+returns);
		//testArea.append(spaces(methodLevel) +"-done, returns "+returns);
		methodLevel--;
	}
	
	public static void exitMethod(int returns){
		if (!debug) return;
		System.out.println(spaces(methodLevel) +"-done, returns "+returns);
		//testArea.append(spaces(methodLevel) +"-done, returns "+returns);
		methodLevel--;
	}

	public static void say(String s){
		//testArea.append(s+";  ");
		if (!gossip) return;
		System.out.println(spaces(methodLevel+1) + s);
	}

	public static void say(Object o){
		//testArea.append(o+";  ");
		if (!gossip) return;
		if (o==null){
			System.out.println(spaces(methodLevel+1) + "NULL");
		} else
			System.out.println(spaces(methodLevel+1) + o.toString());
	}

	public static void say(String s, int level){
		if (!gossip) return;
		if (level < 4)
			System.out.println(s);
	}

	private static String spaces(int n){

		String ret = "";
		for (int i=0; i<n; i++){
			ret += "   ";
		}
		return ret;
	}

	public static void byebye(String msg){
		System.out.println(msg);
		System.exit(0);
	}
}