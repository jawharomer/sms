package com.joh.sms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "WEB_SITE")
public class WebSite {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "I_WEB_SITE")
	private Integer id;

	@Column(name = "HEADER", columnDefinition = "LONGTEXT")
	private String header;

	@Column(name = "ABOUT", columnDefinition = "LONGTEXT")
	private String about;

	@Column(name = "ADDRESS", columnDefinition = "TEXT")
	private String address;

	@Column(name = "CONTACT", columnDefinition = "TEXT")
	private String contact;

	@Column(name = "LINK", columnDefinition = "TEXT")
	private String link;

	@OneToMany()
	@JoinTable(name = "WEB_SITE_CAROUSEL_FILES", joinColumns = {
			@JoinColumn(name = "I_WEB_SITE") }, inverseJoinColumns = { @JoinColumn(name = "I_ATTACHED_FILE") })
	private List<AttachedFile> carouselFiles;

	@OneToMany()
	@JoinTable(name = "WEB_SITE_ALBUM_FILES", joinColumns = { @JoinColumn(name = "I_WEB_SITE") }, inverseJoinColumns = {
			@JoinColumn(name = "I_ATTACHED_FILE") })
	private List<AttachedFile> albumFiles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<AttachedFile> getCarouselFiles() {
		return carouselFiles;
	}

	public void setCarouselFiles(List<AttachedFile> carouselFiles) {
		this.carouselFiles = carouselFiles;
	}

	public List<AttachedFile> getAlbumFiles() {
		return albumFiles;
	}

	public void setAlbumFiles(List<AttachedFile> albumFiles) {
		this.albumFiles = albumFiles;
	}

	@Override
	public String toString() {
		return "WebSite [id=" + id + ", header=" + header + ", about=" + about + ", address=" + address + ", contact="
				+ contact + ", link=" + link + "]";
	}

}
