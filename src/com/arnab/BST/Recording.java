package com.arnab.BST;

import java.util.List;

public class Recording {
	
	private String title;
	private List<Music> music;

	Recording(){}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Music> getMusic() {
		return music;
	}

	public void setMusic(List<Music> music) {
		this.music = music;
	}
}