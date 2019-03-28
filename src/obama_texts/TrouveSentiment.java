package obama_texts;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import obama_texts.Obama_file;
import sentimentAnalysisTest.SentimentAnalyzer;

public class TrouveSentiment {
	
	//TEST TEST TEST
	
	// MAIN CLASS : pour chaque document des discours on va calculer le sentiment 
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		String directory = "./obama-texts";
		DirectoryStream<Path> stream = Obama_file.get_all_files(directory);
		
		String texte = null;
		int i = 0;
		for (Path path : stream) {
			texte = Obama_file.read_file(path);
			
			System.out.println(path.getFileName());
			System.out.println(texte);
			i += 1;
			
			SentimentAnalyzer.init();
			
			System.out.println(i + " : " + SentimentAnalyzer.findSentiment(texte));
			
		}
		System.out.println(i);
		stream.close();
		
		
	}

}
