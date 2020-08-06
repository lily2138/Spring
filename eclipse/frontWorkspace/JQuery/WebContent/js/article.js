$(function(){
	//1. p태그가 몇개인지 alert창으로 확인....
	//alert($('p').length);
	
	//2. 2번째 p태그를 firstP라는 변수에 할당
	var firstP=$('p:eq(1)');
	//alert(firstP.html()); //text()   //p태그 ㄴ내용확인
	
	//3. a태그를 클릭하면...
	$('a.more').click(function(){
		if(firstP.is(':hidden')){	//안보인다면
			firstP.slideToggle('slow');
			$(this).html('read less');
		}else{	//보인다면
			firstP.slideToggle('slow');
			$(this).html('read more');
		}
	})//click
	
	//4.
	var speech=$('div.speech');
	var defaultSize = speech.css('fontSize');
	//alert(defaultSize);			//19.2px
	
	var num = parseInt(defaultSize,10);			//10단위로 끊어서 나타낸다
	//alert(num);			//19
	
	$('#switcher>button').click(function(){
		switch(this.id){
		case 'switcher-large':
			num +=5;
			break;
		case 'switcher-small':
			num -=5;
			break;
		default:
			num = parseInt(defaultSize,10);
		}//switch
		
		//반드시 animate()적용해줘야 한다....
		speech.animate({fontSize:num+'px'}, 'slow');
	})
	
})