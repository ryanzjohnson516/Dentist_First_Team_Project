package edu.neumont.bell.model;

public class Provider {

	private ProviderType title;

	public Provider(ProviderType pro) {
		this.setTitle(pro);
	}

	public ProviderType getTitle() {
		return title;
	}

	public void setTitle(ProviderType title) {
		this.title = title;
	}
}
