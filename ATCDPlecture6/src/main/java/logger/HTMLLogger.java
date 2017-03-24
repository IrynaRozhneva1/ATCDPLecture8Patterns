package logger;

public class HTMLLogger extends LoggerDecorator{
	 public HTMLLogger(Logger logger) {
	        super(logger);
	    }

	    @Override
	    public void log(String msg) {
	        logger.log(msg);
	        System.out.println("<HTML> HTML Logger" + msg);
	    }
}
