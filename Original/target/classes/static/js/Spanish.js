$("#analyze span").on({
  'mouseenter':function(ev){
    var top = $(this).position().top;
    var left = $(this).position().left;
    top = Math.floor(top); // Fx対策：整数にする
    left = Math.floor(left); // Fx対策：整数にする
	var text = $(this).attr("class");
    switch(text){
    	case("ao0000")	: text="序数詞";break
    	case("aq0000")	: text="形容詞";break
		case("aq0000-part") : text="形容詞の一部";break 
    	case("cc")		: text="等位接続詞";break
    	case("cs")		: text="従属接続詞";break
    	case("da0000")	: text="限定詞";break
    	case("dd0000")	: text="指示代名詞";break
    	case("de0000")	: text="感嘆文";break
    	case("di0000")	: text="冠詞";break
    	case("dn0000")	: text="数詞";break
    	case("dp0000")	: text="所有格短縮形";break
    	case("dt0000")	: text="疑問詞";break
    	case("f0")		: text="記号(その他)";break
    	case("faa")		: text="¡";break
    	case("fat")		: text="!";break
    	case("fc")		: text=",";break
    	case("fd")		: text=":";break
    	case("fe")		: text="\"";break
    	case("fg")		: text="-";break
    	case("fh")		: text="/";break
    	case("fia")		: text="¿";break
    	case("fit")		: text="?";break
    	case("fp")		: text=".";break
    	case("fpa")		: text="(";break
    	case("fpt")		: text=")";break
    	case("fs")		: text="...";break
    	case("ft")		: text="%";break
    	case("fx")		: text=";";break
    	case("fz")		: text="'";break
    	case("i")		: text="間投詞";break
    	case("nc00000")	: text="普通名詞(外来語、新語)";break
    	case("nc0n000")	: text="普通名詞(不可算)";break     	
    	case("nc0p000")	: text="普通名詞(複数形)";break     	
    	case("nc0s000")	: text="普通名詞(単数形)";break 
    	case("np00000")	: text="固有名詞";break
    	case("p0000000"): text="不人称代名詞";break
    	case("pd000000"): text="指示代名詞";break
    	case("pe000000"): text="驚嘆代名詞";break
    	case("pi000000"): text="不定数詞";break
    	case("pn000000"): text="定数詞";break
    	case("pp000000"): text="人称代名詞";break
    	case("pr000000"): text="関係代名詞";break
    	case("pt000000"): text="疑問代名詞";break
    	case("px000000"): text="所有格完全形";break
    	case("rg")		: text="副詞";break 
    	case("rn")		: text="否定語";break     	
    	case("sp000")	: text="前置詞";break 
    	case("vag0000")	: text="助動詞、現在分詞・動名詞";break 
    	case("vaic000")	: text="助動詞、直説法過去未来(条件、可能)";break 
    	case("vaif000")	: text="助動詞、直説法未来";break 
    	case("vaii000")	: text="助動詞、直説法不完了過去(線過去)";break 
    	case("vaip000")	: text="助動詞、直説法現在";break 
    	case("vais000")	: text="助動詞、直説法完了過去(点過去)";break 
    	case("vam0000")	: text="助動詞、命令形";break 
    	case("van0000")	: text="助動詞、不定詞";break 
    	case("vap0000")	: text="助動詞、過去分詞";break 
    	case("vasi000")	: text="助動詞、接続法過去";break 
    	case("vasp000")	: text="助動詞、接続法現在";break 
    	case("vmg0000")	: text="一般動詞、現在分詞・動名詞";break 
    	case("vmic000")	: text="一般動詞、直説法過去未来(条件、可能)";break 
    	case("vmif000")	: text="一般動詞、直説法未来";break 
    	case("vmii000")	: text="一般動詞、直説法不完了過去(線過去)";break 
    	case("vmip000")	: text="一般動詞、直説法現在";break 
    	case("vmis000")	: text="一般動詞、直説法完了過去(点過去)";break 
    	case("vmm0000")	: text="一般動詞、命令形";break 
    	case("vmn0000")	: text="一般動詞、不定詞";break 
    	case("vmp0000")	: text="一般動詞、過去分詞";break 
    	case("vmsi000")	: text="一般動詞、接続法過去";break 
    	case("vmsp000")	: text="一般動詞、接続法現在";break 
    	case("vsg0000")	: text="ser動詞、現在分詞・動名詞";break 
    	case("vsic000")	: text="ser動詞、直説法過去未来(条件、可能)";break 
    	case("vsif000")	: text="ser動詞、直説法未来";break 
    	case("vsii000")	: text="ser動詞、直説法不完了過去(線過去)";break 
    	case("vsip000")	: text="ser動詞、直説法現在";break 
    	case("vsis000")	: text="ser動詞、直説法完了過去(点過去)";break 
    	case("vsm0000")	: text="ser動詞、命令形";break 
    	case("vsn0000")	: text="ser動詞、不定詞";break 
    	case("vsp0000")	: text="ser動詞、過去分詞";break 
    	case("vssi000")	: text="ser動詞、接続法過去";break 
    	case("vssp000")	: text="ser動詞、接続法現在";break 
    	case("w")		: text="日付";break
    	case("z0")		: text="数詞";break
    	case("zm")		: text="通貨";break
    	case("zu")		: text="単位";break
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
