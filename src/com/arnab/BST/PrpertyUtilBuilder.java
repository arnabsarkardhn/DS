package com.arnab.BST;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

public class PrpertyUtilBuilder {

	
	public static void main(String args[]) {
		Recording recording = new Recording();
		recording.setTitle("Magical Mystery Tour");
		Music music = new Music();
		music.setName("Micheal");
		Music music1 = new Music();
		music1.setName("Shreya");
		List<Music> musicList = new ArrayList<Music>();
		musicList.add(music);
		musicList.add(music1);
		recording.setMusic(musicList);
		try {
            /*
             * Using PropertyUtils.getPropertyType() to determine the type of
             * title property.
             */
            Class<?> type = PropertyUtils.getPropertyType(recording, "title");
            System.out.println("type = " + type.getName());
            
           /* List<Music> musics = null;
            musics = (List<Music>) PropertyUtils.getProperty(recording, "music");
            System.out.println("type = " + musics.get(1).getName());*/
            for(int i = 0; i < 2; i++){
            String s = (String) PropertyUtils.getProperty(recording, "music[" + i + "].name");
            System.out.println(s);}
           
        //    PropertyUtils.setProperty(recording, "title", "Magic buddy");
            
            String value = (String) PropertyUtils.getProperty(recording, "title");
            System.out.println("value = " + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	

}


