package utilities; 

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Debugger {
	private static Debugger dbg = new Debugger();
	private static String log = "DEBUGGER LOG\n\n";

	public static synchronized Debugger getDebugger() {
		return dbg;
	}

	private Debugger() {
		log += "---> new Debug()\n\n";
	}
	/*
	 * LocalDateTime outputs a time stamp of the following format: yyyy-mm-ddThh:mm:ss
	 * 
	 */
	public synchronized void logException(Exception ex) {
		log += "---> Exception logged @ " + LocalDateTime.now().toString() + "\n\t" + ex.toString() + "\n\n";
	}
	
	public synchronized void logEvent(Object o) {
		log += "---> Event logged @ " + LocalDateTime.now().toString() + "\n\t" + o.toString() + "\n\n";
	}
	
	public synchronized void inspect(Object o) {
		log += "---> Inspecting object " + o.toString() + "\n\t";
		/*
		Class<? extends Object> type = o.getClass();
		 *
		 * class type analysis...
		 * 
		 */
	}
	/*
	 * record generation
	 * recommended extension for fileName is .txt
	 * 
	 */
	public synchronized void fileLog(String fileName) {
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.print(log);
			writer.close();
		} catch (IOException ex) {
			log += "---> Exception logged in Debug.fileLog()\n";
			this.logException(ex);
		}
	}
	/*
	private Queue<Long> clockStart;
	private Stack<Long> clockEnd;
	*/
	/*
	public void logDelays() {
		if (isActive) {
			this.log += "Clock trackers\n";
			
			if (!validateClock()) {
				this.log += "\t#CLK_ERR_INVALID\n";
			}
			
			while (validateClock()) {
				
				//@DEBUG - may need to cast clock result to assign to 'String' (currently 'long')
				this.log += ("\t" + (this.clockEnd.pop() - this.clockStart.remove())  + " ms\n");
			}
			
			this.log += "\n";
		}
	}	
	/*
	 * clock(true) implies the need for a corresponding call to clock(false)
	 * calls to clock() should be treated like delimiter
	 * clock(true) == start delimiter
	 * clock(false) == end delimiter
	 * 
	 *//*
	public void clock(boolean isStart) {
		if (isActive && isStart) {
			clockStart.add(System.currentTimeMillis());
			return;
		}
		
		if (isActive) {
			clockEnd.push(System.currentTimeMillis());
		}
	}
	
	private boolean validateClock() {
		return (clockStart.size() == clockEnd.size() && clockStart.size() + clockEnd.size() >= 2) ? true : false;
	}
	*/
}
