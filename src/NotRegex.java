
public class NotRegex {
	
	public static boolean validateEmail(String email) {
	    // If no email or wrong value gets passed in (or nothing is passed in), immediately return false.
	   
	    if(email.indexOf('@') == -1) return false;

	    // Get email parts
	    String[] emailParts = email.split("@");
	    		String  emailName = emailParts[0];
	    		String emailDomain = emailParts[1];
	       String[] emailDomainParts = emailDomain.split("\\.");
	     String validChars = "abcdefghijklmnopqrstuvwxyz.0123456789_-";

	    // There must be exactly 2 parts
	    if(emailParts.length != 2) {
	        return false;
	    }

	    // Must be at least one char before @ and 3 chars after
	    if(emailName.length() < 1 || emailDomain.length() < 3) {
	        return false;
	    }

	    // Domain must include but not start with .
	    if(emailDomain.indexOf('.') <= 0) {
	        return false;
	    }

	    // emailName must only include valid chars
	    for (int i = emailName.length() - 1; i >= 0; i--) {
	        if(validChars.indexOf(emailName.charAt(i)) < 0) {
	            return false;
	        }
	    };

	    // emailDomain must only include valid chars
	    for (int i = emailDomain.length() - 1; i >= 0; i--) {
	        if(validChars.indexOf(emailDomain.charAt(i)) < 0) {
	            return false;
	        }
	    };

	    // Domain's last . should be 2 chars or more from the end
	    if(emailDomainParts[(emailDomainParts.length - 1)].length() < 2) {
	        return false;   
	    }

	    return true;
	}
}
