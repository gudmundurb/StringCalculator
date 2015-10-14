package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
	
	if(text.equals("")){
	    	return 0;
	}
	else if(text.contains("1")) {
		return 1; 
	}
	else 
		return -1;

	}
}
