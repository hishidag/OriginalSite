$("#analyze span").on({
  'mouseenter':function(ev){
    var top = $(this).position().top;
    var left = $(this).position().left;
    top = Math.floor(top); // Fx対策：整数にする
    left = Math.floor(left); // Fx対策：整数にする
	var text = $(this).attr("class");
    switch(text){
	    case "ART" : text = "冠詞"; break;
	    case "BE"  : text = "be動詞（現在形、過去形）"; break;
	    case "BEG" : text = "be動詞（現在分詞形･動名詞形）"; break;
	    case "BEN" : text = "be 動詞（過去分詞形）"; break;
	    case "CC"  : text = "等位接続詞"; break;
	    case "CD"  : text = "数字、数詞、序数などの数字を含む単語"; break;
	    case "DO"  : text = "do 動詞（現在形･過去形）"; break;  	
	    case "DOG" : text = "do 動詞（現在分詞形･動名詞形）"; break;
	    case "DON" : text = "do 動詞（過去分詞形）"; break;
	    case "DT"  : text = "決定詞･限定詞"; break;
	    case "EX"  : text = "存在の THERE"; break;
	    case "FW"  : text = "外来語";break;
	    case "HV"  : text = "have 動詞（現在形･過去形）";break;
	    case "HVG" : text = "have 動詞（現在分詞形･動名詞形）";break;
	    case "IF"  : text = "条件法･仮定法標識";break;
	    case "IN"  : text = "前置詞および従位接続詞"; break;
	    case "JJ"  : text = "形容詞";break;
	    case "JJR" : text = "比較級形容詞"; break;
	    case "JJS" : text = "最上級形容詞"; break;
	    case "LS"  : text = "リスト項目標識";break;
	    case "MD"  : text = "法助動詞";break;
	    case "NEG" : text = "否定標識";break;
	    case "NN"  : text = "普通名詞（単数形 [省略形･短縮形を含む]）";break;
	    case "NNP" : text = "固有名詞（単数形）"; break;
	    case "NNPS": text = "固有名詞（複数形）";break;
	    case "NNS" : text = "普通名詞（複数形 [省略形･短縮形を含む]）";break;
	    case "PDT" : text = "前限定詞 (predeterminers)";break;
	    case "POS" : text = "所有格標識";break;
	    case "PRP" : text = "代名詞";break;
	    case "PRP$": text = "所有格代名詞";break;
	    case "RB"  : text = "副詞";break;
	    case "RBR" : text = "比較級副詞 (comparative adverbs)";break;
	    case "RBS" : text = "最上級副詞 (superlative adverbs)";break;
	    case "RP"  : text = "副詞小辞 (adverbial particles)";break;
	    case "TO"  : text = "不定詞標識 (infinitive marker)";break;
	    case "UH"  : text = "感嘆詞･間投詞 (interjections)";break;
	    case "VB"  : text = "一般動詞（基底形 [または現在形]）";break;
	    case "VBD" : text = "一般動詞（過去形）";break;
	    case "VBG" : text = "一般動詞（現在分詞形･動名詞形）";break;
	    case "VBN" : text = "一般動詞（過去分詞形）";break;
	    case "VBP" : text = "一般動詞（現在形:非三人称単数）";break;
	    case "VBZ" : text = "一般動詞（現在形:三人称単数）";break;
	    case "WDT" : text = "Wh-決定詞";break;
	    case "WP"  : text = "Wh-代名詞";break;
	    case "WP$" : text = "Wh-所有格代名詞";break;
	    case "WRB" : text = "Wh-副詞";break;
	    case "WZH" : text = "Whether [従位接続詞]";break;
	    default:break;
    }
    $(this).append('<div id="test'+top+'-'+left+'" class="pos">'+text+'</div>');
    var obj = $("#test"+top+"-"+left);
    var x = ev.pageX;
    var y = ev.pageY;
    obj.css({top: y - 80, left: x + 15}); // ← 表示する位置を適当に調整

  },
  
  	'mousemove':function(ev){
	    var top = $(this).position().top;
	    var left = $(this).position().left;
	    top = Math.floor(top); // Fx対策：整数にする
	　　	left = Math.floor(left); // Fx対策：整数にする
	    var obj = $("#test"+top+"-"+left);
	    var x = ev.pageX;
	    var y = ev.pageY;
	    obj.css({top: y - 80, left: x + 15});
	  },
	  
  'mouseleave':function(ev){
	  var top = $(this).position().top;
	  var left = $(this).position().left;
	　　top = Math.floor(top); // Fx対策：整数にする
	　　left = Math.floor(left); // Fx対策：整数にする
	  $("#test"+top+"-"+left).remove();
	  $(this).find(".pos").remove();
  }

});





