package controller;

import java.io.File;
import java.util.ArrayList;

/**
* http://www.fobec.com/java/964/lister-fichiers-dossiers-repertoire.html
*/

public class ImageDao {
	
	public ArrayList<String> listImages() throws Exception {
		//adress racine (attention entre le portable et le Pc)
		String path = "E:\\afpa travail\\JEE\\projectStat\\src\\main\\webapp\\profil";
		//webapp\images
		String path1 = "profil/";
		File file = new File (path);
		ArrayList<String> listNameFile = new ArrayList<>();
		
        File[] files = file.listFiles();
        //on verifie si il y a bien des elements dans le dossier path
        if (files != null) {
        	//si il y a des elements on les deroules avec le for
            for (int i = 0; i < files.length; i++) {
            	/*
            	 * dans un 1er temps on prend le nom du fichier qui est a la racine et 
            	 * on lui met le chemin que Url de la jsp prend en compte 
            	 */
            	listNameFile.add(path1+files[i].getName());
            }
        }
        return listNameFile;
	}  //fin 
	
}
