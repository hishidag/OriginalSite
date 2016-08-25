$("#analyze span").on({
  'mouseenter':function(ev){
    var top = $(this).position().top;
    var left = $(this).position().left;
    top = Math.floor(top); // Fx対策：整数にする
    left = Math.floor(left); // Fx対策：整数にする
	var text = $(this).attr("class");
    switch(text){
	    case "ADJ"     : text = "形容詞";break
	    case "ADJA"    : text = "限定形容詞";break
	    case "ADJD"    : text = "副詞成分または叙述形容詞";break
	    case "APPR"    : text = "前置詞：左側置詞";break
	    case "APPRART" : text = "冠詞つき前置詞";break
	    case "APPO"    : text = "後置詞";break
	    case "APZR"    : text = "右側置詞";break
	    case "ADV"     : text = "副詞";break
	    case "ART"     : text = "冠詞";break
	    case "CARD"    : text = "基数";break
	    case "FM"      : text = "外国語";break
	    case "ITJ"     : text = "間投詞";break
	    case "KOUI"    : text = "zu不定詞を伴う従属接続詞";break
	    case "KOUS"    : text = "文を伴う従属接続詞";break
	    case "KON"     : text = "接続詞";break
	    case "KOKOM"   : text = "比較接続詞";break
	    case "NN"      : text = "普通名詞";break
	    case "NE"      : text = "固有名詞";break
	    case "PDS"     : text = "指示代名詞";break
	    case "PDAT"    : text = "指示冠詞";break
	    case "PIS"     : text = "不定代名詞";break
	    case "PIAT"    : text = "不定冠詞など";break
	    case "PIDAT"   : text = "（冠詞の後の）不定代名詞";break
	    case "PPER"    : text = "人称代名詞";break
	    case "PPOS"    : text = "所有代名詞";break
	    case "PPOSAT"  : text = "所有冠詞";break
	    case "PRELS"   : text = "関係代名詞";break
	    case "PRELAT"  : text = "関係代名詞属格";break
	    case "PRF"     : text = "再帰代名詞";break
	    case "PWS"     : text = "疑問代名詞";break
	    case "PWAT"    : text = "疑問冠詞";break
	    case "PWAV"    : text = "疑問副詞、不定関係代名詞、関係副詞";break
	    case "PAV"     : text = "代名副詞";break
	    case "PTKZU"   : text = "不定詞前のzu";break
	    case "PTKNEG"  : text = "否定詞";break
	    case "PTKVZ"   : text = "分離前つづり";break
	    case "PTKANT"  : text = "応答詞";break
	    case "PTKA"    : text = "形容詞や副詞に伴う不変化詞";break
	    case "TRUNC"   : text = "第一構成素";break
	    case "VVFIN"   : text = "一般動詞、定動詞";break
	    case "VVIMP"   : text = "一般動詞、動詞-命令形";break
	    case "VVINF"   : text = "一般動詞、不定詞";break
	    case "VVIZU"   : text = "一般動詞、zu不定詞";break
	    case "VVPP"    : text = "一般動詞、分詞";break
	    case "VAFIN"   : text = "助動詞、定動詞";break
	    case "VAIMP"   : text = "助動詞、動詞-命令形";break
	    case "VAINF"   : text = "助動詞、不定詞";break
	    case "VAPP"    : text = "助動詞、分詞";break
	    case "VMFIN"   : text = "法助動詞、定動詞";break
	    case "VMINF"   : text = "法助動詞、不定詞";break
	    case "VMPP"    : text = "法助動詞、分詞";break
	    case "XY"      : text = "単語ではない文：特殊文字を含む";break
	    
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
