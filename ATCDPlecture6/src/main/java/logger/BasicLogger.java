package logger;

public class BasicLogger implements Logger {

	@Override
	public void log(String msg) {
		System.out.println("BasicLogger: " + msg);

	}

}
