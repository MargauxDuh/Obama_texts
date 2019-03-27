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
		
		
		
		String directory = "/Users/elviraquesada/Dropbox/M2/2-SEMESTRE/JAVA/obama_texts";
		DirectoryStream<Path> stream = Obama_file.get_all_files(directory);
		
		ArrayList<String> docs = new ArrayList<String>();
		docs.add("I stand before you as someone who is not opposed to war in all circumstances.");
		TestSentiment.init();
		for (String doc : docs) {
			System.out.println(doc + " : " + TestSentiment.findSentiment(doc));
		}
	}

}
