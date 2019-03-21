package obama_texts;

import java.io.*;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Obama_file {

	public static DirectoryStream<Path> get_all_files(String directory) throws IOException{
		Path p = FileSystems.getDefault().getPath(directory);
		DirectoryStream<Path> stream = Files.newDirectoryStream(p, "*");
		return stream;
	}
	
	public static String read_file(Path path) {
		// The name of the file to open.
        String fileName = path.toString();

        // This will reference one line at a time
        String line = null;
        
        // Final concatenation of all line
        String file = "";
        
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                file = file + line + "\n";
            }   

            // Always close files.
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
	
	public static void main(String[] args) throws IOException{
		
		String directory = "/Users/duhayon-fontaine/iCloud_Drive_archive/Documents/notes-M2/m2_exo/s2/java/obama-texts";
		DirectoryStream<Path> stream = get_all_files(directory);
		
		String chepakoi = null;
		int i = 0;
		for (Path path : stream) {
			chepakoi = read_file(path);
			// faire kelkechoz avek chepakoi
			System.out.println(path.getFileName());
			System.out.println(chepakoi);
			i += 1;
		}
		System.out.println(i);
		stream.close();
	}
	
}
