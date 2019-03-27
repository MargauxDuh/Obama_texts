package obama_texts;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import obama_texts.Obama_file;
import sentimentAnalysisTest.TestSentiment;

public class TrouveSentiment {
	
	// MAIN CLASS : pour chaque document des discours on va calculer le sentiment 
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		String directory = "/Users/elviraquesada/Dropbox/M2/2-SEMESTRE/JAVA/obama-texts";
		DirectoryStream<Path> stream = Obama_file.get_all_files(directory);
		
		String chepakoi = null;
		int i = 0;
		for (Path path : stream) {
			chepakoi = Obama_file.read_file(path);
			
			System.out.println(path.getFileName());
			System.out.println(chepakoi);
			i += 1;
			
			TestSentiment.init();
			
			System.out.println(i + " : " + TestSentiment.findSentiment(chepakoi));
			
		}
		System.out.println(i);
		stream.close();
		
		
	}

}
