package Adapter;

public interface UpdateAuto {
		
	void updateOptionSetName(String modelName, String optionSetName, String newName);

	void updateOptionPrice(String modelName, String optionSetName, String optionName, float newPrice);	
}
