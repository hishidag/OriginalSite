package original.domain.service;

import java.util.*;

import org.springframework.stereotype.Component;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.*;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.PropertiesUtils;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


/**
 * 
 * 形態素解析サービス
 * exchangeメソッドの引数に変換したい文章と元の言語を渡すと
 * 文章が単語ごとにexchangeクラスへと変換され配列となる。
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Exchange {
	private String text;
	private String pos;
	private String ner;
	
	public ArrayList<Exchange> exchange(String text,String language){
		ArrayList<Exchange> exchange = new ArrayList<>();
		String annotators;
		String parse;
		String pos;
		String country;
		if(language.equals("English")){
			annotators = "tokenize, ssplit, pos, lemma, ner, parse";
			parse = "edu/stanford/nlp/models/lexparser/englishPCFG.caseless.ser.gz";
			pos   = "edu/stanford/nlp/models/pos-tagger/english-caseless-left3words-distsim.tagger";
			country = "en";
		}else if(language.equals("German")){
			annotators = "tokenize, ssplit, pos, lemma, ner, parse";
			parse = "edu/stanford/nlp/models/lexparser/germanFactored.ser.gz";
			pos   = "edu/stanford/nlp/models/pos-tagger/german/german-hgc.tagger";
			country = "de";
		}else if(language.equals("French")){
			annotators = "tokenize, ssplit, pos, parse";
			parse = "edu/stanford/nlp/models/lexparser/frenchFactored.ser.gz";
			pos   = "edu/stanford/nlp/models/pos-tagger/french/french.tagger";
			country = "fr";
		}else if(language.equals("Spanish")){
			annotators = "tokenize, ssplit, pos, lemma, ner, parse";
			parse = "edu/stanford/nlp/models/lexparser/spanishPCFG.ser.gz";
			pos   = "edu/stanford/nlp/models/pos-tagger/spanish/spanish-distsim.tagger";
			country = "es";
		}/*else if(language.equals("中国語")){いつか実装する予定
			annotators = "segment, ssplit, pos, lemma, ner, parse";
			parse = "edu/stanford/nlp/models/lexparser/chineseFactored.ser.gz";
			pos   = "edu/stanford/nlp/models/pos-tagger/chinese-distsim/chinese-distsim.tagger";
			country = "zh";
		}*/else{//英語のパターンをデフォルト値に設定する
			annotators = "tokenize, ssplit, pos, lemma, ner, parse";
			parse = "edu/stanford/nlp/models/lexparser/englishPCFG.caseless.ser.gz";
			pos   = "edu/stanford/nlp/models/pos-tagger/english-caseless-left3words-distsim.tagger";
			country = "en";
		}
		String[] prop	  = {"annotators",annotators,"parse.model",parse,"pos.model",pos,"tokenize.language",country};
		StanfordCoreNLP cNLP = new StanfordCoreNLP(PropertiesUtils.asProperties(prop));
		Annotation anno = new Annotation(text);
		cNLP.annotate(anno);
		List<CoreLabel> labels = anno.get(TokensAnnotation.class);

		//サニタイズされた記号を復元
		for (CoreLabel label : labels) {
			String word = label.get(TextAnnotation.class);
			switch(word){
				case("-LRB-"):
					word = "(";				
				break;
				case("-RRB-"):
					word = ")";
				break;
				case("-LSB-"):
					word = "[";
				break;
				case("-RSB-"):
					word = "]";
				break;
				case("``"):
					word = "\"";
				default:
				break;
			}
			Exchange e = new Exchange(
					word,
					label.get(PartOfSpeechAnnotation.class),
					label.get(NamedEntityTagAnnotation.class)
					);
			exchange.add(e);
        }
		
		return exchange;
	}

}
