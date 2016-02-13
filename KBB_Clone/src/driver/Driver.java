package driver;

import Adapter.*;

public class Driver {

	public static void main(String [] args) {
		
		BuildAuto ba = new BuildAuto();
		String inputFilename;

		System.out.println("---Build an auto with proper input file:---");
		inputFilename="FordZTW_v1.txt";
		ba.buildAuto(inputFilename);
		System.out.println("-----Start printing right after buildAuto() an Automotive from a proper file-----\n");
		ba.printAuto("Ford Focus Wagon ZTW");
		
		System.out.println("About to updateOptionSetName:");
		ba.updateOptionSetName("Ford Focus Wagon ZTW", "Power Moonroof", "Power Moonrooves");
		System.out.println("------After updateOptionSetName:");
		ba.printAuto("Ford Focus Wagon ZTW");
		
		System.out.println("About to updateOptionPrice for Option \"Fort Knox Gold Clearcoat Metallic\":");
		ba.updateOptionPrice("Ford Focus Wagon ZTW", "Color", "Fort Knox Gold Clearcoat Metallic", 168f);
		System.out.println("------After updateOptionPrice:");
		ba.printAuto("Ford Focus Wagon ZTW");
		
		//Start testing improper input file:
		System.out.println("---Start testing files that doesn't contain Base Price:---");
		inputFilename="FordZTW_v1_missing_BasePrice.txt";
		ba.buildAuto(inputFilename);

		/**Check to see if exception is handled properly.*/
		System.out.println("-----Start printing right after buildAuto() an Automotive from improper file-----\n");
		ba.printAuto("Ford Focus Wagon ZTW");
				
//		System.out.println("Start serializing auto.\n");
//		/**Serialize the object*/
//		fio.serializeAuto(FordZTW);
//		/**Deserialize the object and read it into memory.*/
//		Automobile newFordZTW = fio.deserializeAuto("auto.ser");
//
//		System.out.println("-----Start printing deserialized auto-----\n");
//		newFordZTW.print();
//			
//		newFordZTW.deleteOptionSet("Color");
//		System.out.println("-----Right after deleting OptionSet Color-----\n");
//		newFordZTW.print();
//
//		newFordZTW.deleteOption("Automatic");
//		System.out.println("-----Right after deleting Option Automatic in OptionSet Transmission-----\n");
//		newFordZTW.print();		

	}				
	
}

