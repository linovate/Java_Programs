package exception;

public class AutoException extends Exception {
	
	private int errorno;
	private String errormsg;
	
	public AutoException() {
		super();
		printAutoException();
	}
	
	public AutoException(String errormsg) {
		super();
		this.errormsg = errormsg;
		printAutoException();
	}
	
	public AutoException(int errorno) {
		super();
		this.errorno = errorno;
		printAutoException();
	}
	
	public AutoException(int errorno, String errormsg) {
		super();
		this.errorno = errorno;
		this.errormsg = errormsg;
		printAutoException();
	}
	
	public int getErrorno() {
		return errorno;
	}
	
	public void setErrorno(int errorno) {
		this.errorno = errorno;
	}
	
	public String getErrormsg() {
		return errormsg;
	}
	
	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
	public void printAutoException() {
		System.out.println("AutoException [errorno=" + errorno + ", errormsg=" + errormsg+"]\n"); 
	}

	public String fixProblemReadFromConsole()
	{
		String a = "Z:\\JavaPrograms\\SelfHealingSoftware\\bin\\abc.txt";
		System.out.println("got here --> fixProblemReadFromConsole");
		return a;
	}

	public void fix(int errno) {
		
		if (errno>0 && errno<=100){
			Fix1To100 f1To100 = new Fix1To100(); 			

			switch(errno)
			{
				case 1: f1To100.fix1(errno);
				break;
				
				case 2: f1To100.fix2(errno);
				break;	
			
			}
		
		}else if(errno>100 && errno<=200){
			Fix101To200 f101To200 = new Fix101To200(); 			

			switch(errno)
			{
				case 1: f101To200.fix101(errno);
				break;
			
				case 2: f101To200.fix102(errno);
				break;
			
			}
			
		}
		
		
	}	
	
}
