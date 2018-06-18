package fr.atatorus.bookservice.entities;

public enum BookType {
	
	SCIENCE_FICTION(IBookType.SCIENCE_FICTION),
	POLICIER(IBookType.POLICIER),
	ROMAN_HISTORIQUE(IBookType.ROMAN_HISTORIQUE),
	HEROIC_FANTASY(IBookType.HEROIC_FANTASY),
	ROMANCE(IBookType.ROMANCE);
	
	private String label;

	private BookType(String label) {
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return ""+getLabel();
	}
}
