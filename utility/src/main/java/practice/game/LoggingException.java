package practice.game;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Descriptions: Java文档的使用  异常的捕捉<p>
 *
 * @author SailHe
 * @date 2018/11/11 18:54
 */
class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggerException");

    public LoggingException() {
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}
