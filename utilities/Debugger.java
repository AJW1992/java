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
}
