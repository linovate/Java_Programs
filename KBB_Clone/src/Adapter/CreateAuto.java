package Adapter;

import exception.AutoException;

public interface CreateAuto {

	void buildAuto(String fileName) throws AutoException;
	
	void printAuto(String modelName);
}
