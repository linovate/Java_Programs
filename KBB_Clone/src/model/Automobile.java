package model;

public class Automobile implements java.io.Serializable {

	private String name;
	private float basePrice;
	private OptionSet opsets[];

	/** Overloaded constructors */
	public Automobile() {
		this.name = "";
		this.basePrice = 0F;
//		this.opsets = null;
	}

	public Automobile(String name, float basePrice, int numberOfOptionSets) {
		this.name = name;
		this.basePrice = basePrice;
		this.opsets = new OptionSet[numberOfOptionSets];
	}

	public Automobile(String name, float basePrice) {
		this.name = name;
		this.basePrice = basePrice;
		this.opsets = null;
	}

	/** find an OptionSet with a given name */
	public OptionSet findOptionSetWithName(String optionSetName) {
		for (OptionSet optSet : opsets) {
			if (optSet.getName().equals(optionSetName))
				return optSet;
		}
		return null;
	}

	/** find an Option with a given name */
	public OptionSet.Option findOptionWithName(String optionName) {
		for (OptionSet optSet : opsets) {
			for (OptionSet.Option opt : optSet.getOptions()) {
				if (opt.getName().equals(optionName))
					return opt;
			}
		}
		return null;
	}

	/** Delete an Option by setting it to null */
	public boolean deleteOption(String optionName) {
		for (int i = 0; i < opsets.length; i++) {
			OptionSet.Option[] temp = opsets[i].getOptions();

			for (int j = 0; j < temp.length; j++) {
				if (temp[j].getName().equals(optionName)) {
					for (int k = j; k < temp.length - 1; k++) {
						temp[k] = temp[k + 1];
					}
					temp[temp.length - 1] = null;
					return true;
				}
			}
		}
		return false;
	}

	/** Delete an OptionSet by setting it to null */
	public boolean deleteOptionSet(String optionSetName) {
		for (int i = 0; i < opsets.length; i++) {
			if (opsets[i].getName().equals(optionSetName)) {
				for (int j = i; j < opsets.length - 1; j++) {
					opsets[j] = opsets[j + 1];
				}
				opsets[opsets.length - 1] = null;
				return true;
			}
		}
		return false;
	}

	/** Find an OptionSet by its name and update it with a new one */
	public boolean updateValuesOfOptionSet(String optionSetName,
			OptionSet newOptionSet) {
		for (OptionSet optSet : opsets) {
			if (optSet.getName().equals(optionSetName)) {
				optSet = newOptionSet;
				return true;
			}
		}
		return false;
	}

	/** Find an Option by its name and update it with a new one */
	public boolean updateValuesOfOption(String optionName,
			OptionSet.Option newOption) {
		for (OptionSet optSet : opsets) {
			for (OptionSet.Option opt : optSet.getOptions()) {
				if (opt.getName().equals(optionName)) {
					opt = newOption;
					return true;
				}
			}
		}
		return false;
	}

	/** Setters and getters of instance variables. */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(float basePrice) {
		this.basePrice = basePrice;
	}

	public OptionSet[] getOpsets() {
		return opsets;
	}

	public OptionSet getOpsetByIndex(int index) {
		return opsets[index];
	}

	/** Overloaded setters for Opsets. */
	public void setOpsets(int[] sizesOfOptionSets) {
		for (int i = 0; i < this.opsets.length; i++) {
			opsets[i] = new OptionSet(sizesOfOptionSets[i]);
		}
	}

	public void setOpsets(int numberOfOptionSets, int[] sizesOfOptionSets) {
		this.opsets = new OptionSet[numberOfOptionSets];
		for (int i = 0; i < numberOfOptionSets; i++) {
			opsets[i] = new OptionSet(sizesOfOptionSets[i]);
		}
	}

	public void setOpsetName(int index, String optSetName) {

		this.opsets[index].setName(optSetName);
	}

	public void setOpsetNameThroughCurrentName(String currentOptionSetName,
			String newOptionSetName) {

		for (OptionSet item : opsets) {
			if (item.getName().equals(currentOptionSetName)) {
				item.setName(newOptionSetName);
				break;
			}
		}
	}

	public void updateOptionPrice(String optionSetName, String optionName,
			float newPrice) {
		for (OptionSet anOptionSet : opsets) {
			if (anOptionSet.getName().equals(optionSetName)) {
				for (OptionSet.Option anOption : anOptionSet.getOptions()) {
					if (anOption.getName().equals(optionName)) {
						anOption.setPrice(newPrice);
						break;
					}
				}
				break;
			}
		}
	}

	/** Set Option with 4 parameters */
	public void setOption(int indexOfOptionSet, int indexOfOption,
			String optionName, float optionPrice) {

		this.opsets[indexOfOptionSet].setOption(indexOfOption, optionName,
				optionPrice);
	}

	/** Print the string representation of the object to console */
	public void print() {
		System.out.println(this.toString());
	}

	// Build a string describing the Automotive object, ignoring OptionSets and
	// Options that are null.
	public String toString() {

		StringBuilder sb = new StringBuilder("Automotive Name : " + name + "\n");
		sb.append("Automotive Base Price : " + basePrice + "\n\n");

		for (int i = 0; i < opsets.length; i++) {
			if (opsets[i] != null)
				sb.append("Option Set # " + (i + 1) + ":\n"
						+ opsets[i].toString() + "\n");
		}
		return sb.toString();
	}

}
