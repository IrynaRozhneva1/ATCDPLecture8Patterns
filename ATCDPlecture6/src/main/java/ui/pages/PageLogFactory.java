package ui.pages;

public class PageLogFactory {
	
	private static String message = "Factory has not been initialized!";

	public static String initializeLog(IPage page){
		switch (page.getClass().getName().replace("ui.pages.", "")) {
		case "EmailPage":
			message = "Email Page: ";
			break;
		case "InboxPage":
			message = "Inbox Page: ";
			break;
		case "NewEmailPage":
			message = "New Email Page: ";
			break;
		case "SignInPage":
			message = "Sign In Page: ";
			break;
		case "SpamPage":
			message = "Spam Page: ";
			break;
		case "StartPage":
			message = "Start Page: ";
			break;
		default:
			message = "Incorrect page has been initialized!";
			break;
		}
		
		return message;
	}
}
