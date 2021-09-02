package DTO;

public class CheckInput {
	public static boolean checkStringNumber(String data) {
		for(int i=0;i<data.length();i++) {
			if((int)data.charAt(i)<48||(int)data.charAt(i)>57) return false;
		}
		return true;
	}
	public static boolean checkPhoneNumber(String data) {
        if(data.length()==10 && checkStringNumber(data))
            return true;
        return false;
    }
	public static boolean checkFAX(String data) {
        if(data.length()==8 && checkStringNumber(data))
            return true;
        return false;
    }

	public static boolean checkInt(String data) {
		if(data.length()>7) return false;
		return true;
	}
	public static boolean xuliDate(String dayFrom,String dayTo)
	{
		String[]  From= dayFrom.split("-");
		String[]  To= dayTo.split("-");
		int ddFrom=Integer.parseInt(From[2]);
		int mmFrom=Integer.parseInt(From[1]);
		int yyFrom=Integer.parseInt(From[0]);
		int ddTo=Integer.parseInt(To[2]);
		int mmTo=Integer.parseInt(To[1]);
		int yyTo=Integer.parseInt(To[0]);
		
		if(yyFrom>yyTo) return false;
		if(yyFrom==yyTo) {
			if(mmFrom>mmTo) return false;
			if(mmFrom==mmTo) {
				if(ddFrom>=ddTo) return false;
			}
		}
		return true;
	}
	public static boolean checkString(String data) {
		for(int i=0;i<data.length();i++) {
			if((int)data.charAt(i)==34||(int)data.charAt(i)==39||(int)data.charAt(i)==96) return false;
		}
		return true;
	}
	public static boolean checkBorn(String data) {
		if(data.length()==4&&checkStringNumber(data)==true) {
			int n=Integer.parseInt(data);
			if(n<1970||n>2010) {
				return false;
			}
			return true;
		}
		return false;
	}
        
}
