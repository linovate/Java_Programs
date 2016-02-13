package model;

public class OptionSet implements java.io.Serializable{

	private String name;
	private Option options []; 
	
	/**Overloaded constructors*/		
	protected OptionSet(String name, int size) {
	
		setName(name);
		this.options = new Option[size];
		for (int i=0; i< size; i++){
			options[i]=new Option();
		}
	 }	
	
	protected OptionSet(int size) {
		
		setName("unknown");
		this.options = new Option[size]; 
		for (int i=0; i< size; i++){
			options[i]=new Option();
		}
	 }
	
	protected OptionSet() {		
		setName("unknown");
	 }
	
	 /**Setters and getters of instance variables.*/
	//Has to change modifier from protected to public to let ProxyAutomobile to access it.
	public String getName() {
		return name;
	}
	
	//Has to change modifier from protected to public to let ProxyAutomobile to access it.
	public void setName(String name) {
		this.name = name;
	}

	protected Option[] getOptions() {
		return options;
	}
	
	/**Overloaded setters for Options.*/
	protected void setOptions(Option[] options) {
		this.options = options;
	}

	protected void setOption(int indexOfOption,String optionName,float optionPrice) {
		options[indexOfOption].setName(optionName);
		options[indexOfOption].setPrice(optionPrice);
	}
	
	public String toString(){
	
		StringBuilder sb = new StringBuilder("OptionSet Name : "+name+"\n");		
		for (int i=0; i<options.length; i++){
			if(options[i]!=null)
				sb.append(options[i].toString()+"\n");
		}
		return sb.toString();
	}

	
	/**Inner class Option:*/
	class Option implements java.io.Serializable{
		
		private String name;
		private float price;
		
		/**Overloaded constructors*/		
		protected Option (){
			setName("unknown");
			setPrice(-99999999F);
			
		}
		protected Option (String name, float price){
			setName(name);
			setPrice(price);
		}
		
		/**Setters and getters of instance variables*/	
		
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected float getPrice() {
			return price;
		}
		protected void setPrice(float price) {
			this.price = price;
		}	
		
		/**String representation of the object*/			
		public String toString(){
			return getName()+": "+ getPrice();
		}
	}
	
}
