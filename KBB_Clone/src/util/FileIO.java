package util;

import java.io.*;

import Adapter.ProxyAutomobile;
import exception.AutoException;
import model.Automobile;
import java.util.logging.*;


public class FileIO {

	private Automobile auto;
	private static final Logger logger = Logger.getLogger(FileIO.class.getName());		
	int counter=1;

	/** Build auto object. */
	// Maybe no longer needed from Lab 2 onwards?
	public void buildAutoObject(String filename) {
//		this.auto = new Automobile();
   	
	}

	/**
	 * Read input file and build Automotive object based on the contents of the
	 * file.
	 */
	public void readFile(String fileName) throws AutoException {

		auto = ProxyAutomobile.getAutomobile();
		int sizesOfOptionSets[];
		BufferedReader buff = null;
		boolean eof = false;
		String tempOfFirstLine[] = { "" };
		
		float basePrice=0f;		
	
        // This block configure the logger with handler and formatter  
		
	    try {  

	        // This block configure the logger with handler and formatter  
			FileHandler fh  = new FileHandler("MyLogFile.log");  
			counter++;
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages  
//	        logger.info("My first log");  

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    } 
		
		logger.info("Logging begins at the 1st try/catch in readFile() in FileIO class...");   // log INFO-level message
		try {
			FileReader file = new FileReader(fileName);
			buff = new BufferedReader(file);
			eof = false;
			// Read first line before entering while loop to avoid
			// NullPointerException.
			String firstLine = buff.readLine();
			tempOfFirstLine = firstLine.split(":");

			}catch (IOException e) {
				System.out.println("Error ­­ " + e.toString());
		         logger.log(Level.SEVERE, e.getMessage(), e);
			}
	
		try {
			 basePrice=Float.valueOf(tempOfFirstLine[3]);
			 auto.setBasePrice(basePrice);
		}catch(NumberFormatException nfe){
			
	        logger.log(Level.SEVERE, nfe.getMessage(), nfe);
			throw new AutoException(2,"Base Price Invalid In Input File.");
			
		}finally {
			auto.setName(tempOfFirstLine[1]);
	
			sizesOfOptionSets = new int[Integer.valueOf(tempOfFirstLine[5])];
			for (int i = 0; i < sizesOfOptionSets.length; i++) {

				sizesOfOptionSets[i] = Integer
						.valueOf(tempOfFirstLine[7 + i]);
			}
			
			auto.setOpsets(sizesOfOptionSets.length,sizesOfOptionSets);

			int optionSetCounter = -1;
			int optionCounter = 0;
			try {
				while (!eof) {
					String line = "";

					line = buff.readLine();

					if (line == null)
						eof = true;
					
					else {
							String temp[] = line.split(":");
							if (temp[0].equals("*Option Set*")) {
								auto.setOpsetName(Integer.valueOf(temp[1]), temp[2]);
								optionSetCounter++;
								optionCounter = 0;
	
							} else {
								auto.setOption(optionSetCounter, optionCounter,
										temp[0], Integer.valueOf(temp[1]));
								optionCounter++;
							}
					}
				}//end of while loop.
										
				buff.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
		        logger.log(Level.SEVERE, e.getMessage(), e);
				e.printStackTrace();
			}
		}//End of finally block.
		
	      logger.info("Done...");
	}

	/** Serialize an Automotive object. */
	public void serializeAuto(Automobile auto) {

		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("auto.ser");
			out = new ObjectOutputStream(fos);
			out.writeObject(auto);
			out.close();
		} catch (Exception e) {
			System.out.print("Error:" + e);
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Deserialize an Automotive object. */
	public Automobile deserializeAuto(String fileName) {

		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			Automobile auto = (Automobile) in.readObject();
			in.close();
		} catch (Exception e) {
			System.out.print("Error:" + e);
			e.printStackTrace();
			System.exit(1);
		}
		return auto;
	}

}
