package sentimentAnalysisTest;

import java.util.Properties;

import org.ejml.simple.SimpleMatrix;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;

// Class SentimentAnalyzer : run sentiment analysis on a discourse 

public class SentimentAnalyzer {
	
	

		// Construction d'un object StandfordCoreNLP : pipeline that takes in a string and returns various analyzed linguistic forms. The string is tokenized and other sequence model style annotation can be used to add things like lemmas, POS tags and named entities. These are returned as a list of CoreLabels. First build up the pipeline by adding Annotators, and then take the objects we wish to annotate and pass them in and get in return a fully annotated object.
	
		static StanfordCoreNLP pipeline;
		
		// Création des propriétés pour l'objet StandfordCoreNLP
		
		public static void init() {
			
			Properties props = new Properties();
			props.setProperty("annotators", "tokenize, ssplit, parse, sentiment"); // liste des annotateurs
			pipeline = new StanfordCoreNLP(props); //construct a basic pipeline
		}
		
		public static int findSentiment(String doc) {
			
			int mainSentiment = 0;
			
			if (doc != null && doc.length() > 0) {
				
				System.out.println("J'ai reçu un string, je vais calculer son sentiment");
				int longest = 0;
				//create annotation with text
				Annotation annotation = pipeline.process(doc); // runs the entire pipeline on the content of the given text passed in
				// ?? see readFileList(String fileName) --> ON POURRAIT L'UTILISER
				
				for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
					//get the tree for the sentence
					Tree tree = sentence.get(SentimentAnnotatedTree.class);
					// get the argmax of the class predictions. 
					int sentiment = RNNCoreAnnotations.getPredictedClass(tree);
					SimpleMatrix sentiment_new = RNNCoreAnnotations.getPredictions(tree);
					String partText = sentence.toString();
					if (partText.length() > longest) {
						mainSentiment = sentiment;
						longest = partText.length();
					}
				}
				
				// Results :
				// 0: "Very Negative"
				// 1: "Negative" 
				// 2: "Neutral" 
				// 3: "Positive" 
				// 4: "Very Positive"

				
				
				
			}
			return mainSentiment;
			
		}

}
