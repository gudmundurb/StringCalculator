package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		
	
	if(text.equals("")){
	    	return 0;
	}
	else if(text.contains(",")) {
		return Integer.parseInt(text[0]) + Integer.parseInt(text[1]) 
	}
	else 
		return -1;

}
