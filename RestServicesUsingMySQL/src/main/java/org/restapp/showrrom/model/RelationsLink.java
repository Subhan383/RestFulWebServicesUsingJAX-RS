package org.restapp.showrrom.model;

public class RelationsLink {

	private String link;
	private String relationship;

	public RelationsLink() {

	}

	public RelationsLink(String link, String relationship) {

		this.link = link;
		this.relationship = relationship;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

}
