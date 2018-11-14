package chapter_01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintArrays {

	static Logger logger = LogManager.getLogger();
	
	public static void print(int [] a)
	{
		String out = "";
		for(int i : a) out += i + " ";
		logger.info(out);
	}
	
}
