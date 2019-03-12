package utilities;

import utilities.Wrapper;

public class _drivers {
	public static void singletonDemo() {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 1 is running...");
				int num = 5;
				
				Debugger.getDebugger().logEvent(Wrapper.Nums.wrap(num));
				Debugger.getDebugger().fileLog("debugger_log.txt");
				System.out.println("Thread 1 has finished");
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 2 is running...");
				Object o = new Object();
				
				Debugger.getDebugger().logEvent(o);
				Debugger.getDebugger().fileLog("debugger_log.txt");
				System.out.println("Thread 2 has finished");
			}
		});
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread 3 is running...");
				String str = "sample_string";
				
				Debugger.getDebugger().logEvent(str);
				Debugger.getDebugger().fileLog("debugger_log.txt");
				System.out.println("Thread 3 has finished");
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
		} catch (InterruptedException ex) {
			Debugger.getDebugger().logException(ex);
		}
	}
}
