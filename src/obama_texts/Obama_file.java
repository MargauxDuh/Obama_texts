package obama_texts;

import java.io.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Obama_file {

	
	//Fichiers dans un répertoire 
	public static DirectoryStream<Path> get_all_files(String directory) throws IOException{
		Path p = FileSystems.getDefault().getPath(directory);
		DirectoryStream<Path> stream = Files.newDirectoryStream(p, "*");
		return stream;
	}
	
	public static String read_file(Path path) {
		// Nom du fichier à ouvrir
        String fileName = path.toString();

        // Lecture de ligne à ligne
        String line = null;
        
        // Concaténationde toutes les lignes du fichier
        String file = "";
        
        try {
            // FileReader lit les fichiers 
            FileReader fileReader = new FileReader(fileName);

            // 
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                file = file + line + "\n";
            }   

            // Clôture du fichier
            bufferedReader.close(); 
            
            return file;
        }
        
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");
            return file;
        }
        
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            return file;
        }
	}
	
	
	
}
