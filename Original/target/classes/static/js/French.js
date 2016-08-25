$("#analyze span").on({
  'mouseenter':function(ev){
    var top = $(this).position().top;
    var left = $(this).position().left;
    top = Math.floor(top); // Fx対策：整数にする
    left = Math.floor(left); // Fx対策：整数にする
	var text = $(this).attr("class");
    switch(text){
    	case("ADJ")		: text="形容詞";break
    	case("ADJWH")	: text="疑問形容詞";break
    	case("ADV")		: text="副詞";break
    	case("ADVWH") 	: text="疑問副詞";break
    	case("CC")		: text="等位接続詞";break
    	case("CLO")		: text="代名詞目的格";break
    	case("CLR")		: text="再帰代名詞";break
    	case("CLS")		: text="代名詞主格";break
    	case("CS")		: text="従属接続詞";break
    	case("DET")		: text="限定詞";break
    	case("DETWH")	: text="疑問限定詞";break
    	case("ET")		: text="外語";break
    	case("I")		: text="間投詞";break
    	case("NC")		: text="普通名詞";break
    	case("NPP")		: text="固有名詞";break
    	case("P")		: text="前置詞";break
    	case("P+D")		: text="前置詞＋限定詞";break
    	case("P+PRO")	: text="前置詞＋代名詞";break
    	case("PUNC")	: text="句読点";break
    	case("PREF")	: text="接頭辞";break
    	case("PRO")		: text="代名詞";break
    	case("PROREL")	: text="関係代名詞";break
    	case("PROWH")	: text="疑問代名詞";break
    	case("V")		: text="動詞";break
    	case("VIMP")	: text="動詞、命令形";break
    	case("VINF")	: text="動詞、不定詞";break
    	case("VPP")		: text="動詞、過去分詞";break 
    	case("VPR")		: text="動詞、現在分詞";break
    	case("VS")		: text="動詞、接続法";break
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
