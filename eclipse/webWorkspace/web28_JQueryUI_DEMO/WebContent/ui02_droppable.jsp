<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Droppable - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/sunny/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <style>
  #clothing{ margin-left: 3px; float:left; width:500px; }
  #cart{ width: 450px; float: left; margin-top: 5px; }
  
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
	  $( "#catalog" ).accordion({
	    	//컨텐츠의 사이즈에 맞게 어코디언의 폭을 조절....
	    	heightStyle:'content' /* default가 fill */
	    });
	  
	  //draggable 적용
	  $('#catalog li').draggable({
		  helper:'clone',	//복사본을 만들어서 draggable 해라
		  appendTo : '#cart'
	  });
	
	  //droppable
	  $('#cart ol').droppable({
		  drop: function( event, ui ) {
			  $( this).find( ".placeholder" ).remove();
			  var uidrag = ui.draggable.text();
			   
			  $(this).append('<li>' + uidrag + '</li>');
		  }
	  });
  });
  </script>
</head>
<body>
	<div id="clothing">
		<h2 class="ui-widget-header">카 달 로 그</h2>
		<!-- 드래그 하는 대상들.... -->
		<div id="catalog">
		
			<h2><a href = "#">상의류</a></h2>
			<div>
				<ul>
					<li>블라우스</li>
					<li>티셔츠</li>
					<li>폴라티</li>
					<li>바바리</li>
					<li>가디건</li>
				</ul>
			</div>
			
			<h2><a href = "#">하의류</a></h2>
			<div>
				<ul>
					<li>청바지</li>
					<li>롱스커트</li>
					<li>치마</li>
					<li>베기팬츠</li>
				</ul>
			</div>
			
			<h2><a href = "#">액세사리</a></h2>
			<div>
				<ul>
					<li>시계</li>
					<li>목걸이</li>
					<li>귀걸이</li>
					<li>모자</li>
					<li>백팩</li>
					<li>팔찌</li>
				</ul>
			</div>
			
		</div>
	</div>
 
 <!-- drop할 영역을 지정... cart -->
 <div id="cart">
 	<h2 class="ui-widget-header">>Clothing Cart</h2>
 	<div class="ui-widget-content">
 		<ol>
 			<li class="placeholder">Dropping Here!!!!</li>
 		</ol>
 	</div>
 </div>
</body>
</html>