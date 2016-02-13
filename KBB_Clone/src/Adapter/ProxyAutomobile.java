package Adapter;
import exception.AutoException;
import util.FileIO;
import model.*;

public abstract class ProxyAutomobile {

	private static Automobile a1;
	
	public static Automobile getAutomobile(){
		return a1;
	}
	
	//Given a text file name a method called BuildAuto can be written to build an instance of
	//Automobile. This method does not have to return the Auto instance.
	public void buildAuto(String fileName){
		FileIO fio=new FileIO();	
		a1= new Automobile();
		
		try{
			fio.readFile(fileName);
		}catch(AutoException ae){
			fix(ae);
		}
	}
	
	//This function searches and prints the properties of a given Automodel.
	//Don't need ModelName to print the Auto yet because there is only one Model "FordZTW.txt" for now.
	public void printAuto(String modelName){
		if (a1.getName().equals(modelName)){
			a1.print();
		}else{
			System.out.println("Couldn't find this modelName.");
		}
	}
	
	//This function searches the Model for a given OptionSet and sets the name of OptionSet to newName.
	public void updateOptionSetName(String modelName, String optionSetName, String newName){
		if (a1.getName().equals(modelName)){
			a1.setOpsetNameThroughCurrentName(optionSetName,newName);
		}
	}
	
	//This function searches the Model for a given OptionSet and Option name, and sets the price to newPrice.￼
	public void updateOptionPrice(String modelName, String optionSetName, String optionName, float newPrice){
		if (a1.getName().equals(modelName)){
			a1.updateOptionPrice(optionSetName, optionName,newPrice);
		}
	}
	
	public void fix(AutoException ae){
		ae.fix(ae.getErrorno());
	}

}
