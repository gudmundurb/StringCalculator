package is.ru.stringcalculator;
public class Calculator {

	public static int add(String text){
	  try{
		negative(splitNumbers(text));
	  }catch(Exception negativeNumber){
	
	  }
	if(text.isEmpty()){
 		return 0;
	}
	else if(text.startsWith("//") && text.contains("\n"))  {
		
		return changeDelim(text);
	}
	else if(text.contains(",")){
		return sum(splitNumbers(text));
	}
	else
		return toInt(text);
	}

	private static int toInt(String number){
		if (isInt(number)) {
		return Integer.parseInt(number);
		}
		else {
		  return 0;
		}
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split("[, | \n]");
    	}
	
        private static int sum(String[] numbers){
 	    int total = 0;
            for(String number : numbers){
	    	if(isInt(number)){
   		    total += toInt(number);
		}
   	    }
	    return total;
	}
	private static Boolean isInt(String numbers){
		try{
		  int number = Integer.parseInt(numbers);
		  }catch(NumberFormatException illegalNumber ){
		    return false;
		   }
		return true;
	}
	private static int changeDelim(String numbers) {
	  String delimiter = "";
	  delimiter = Character.toString(numbers.charAt(2));
	  numbers = numbers.replace(delimiter, ",");
	  return newLine(numbers);

	}
	private static int newLine(String numbers) {
		numbers = numbers.replace("\n" , ",");
		return sum(splitNumbers(numbers));
	
	
	}
	private static void negative(String[] numbers) throws Exception {
	
		String negative = "";
		for (String number : numbers) {
			if (isInt(number)){
				if(toInt(number) < 0) {
					negative += number+",";
				
				}
			
			}
			if(!negative.equals("")) {
				throw new Exception("Negatives not allowed: " + negative);
			}
			
		}
	
	}
}
