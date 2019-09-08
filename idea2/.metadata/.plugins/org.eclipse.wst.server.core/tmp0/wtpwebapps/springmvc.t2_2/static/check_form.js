//验证
   function checkRq(elmentArr){
	   pass=null;
	  $.each(elmentArr,function(i,elment){
	  if(elment.validity.valueMissing){
		  pass=elment;
		  alert($(elment).prev().text()+"不能为空!!");
		  return false;
	     }; 
	  });
	  return pass;
   };
   function checkPe(elmentArr){
	   pass=null;
 	  $.each(elmentArr,function(i,elment){
 	  if(elment.validity.patternMismatch){
 		  pass=elment;
 		  alert($(elment).prev().text()+$(elment).next().text());
 		  return false;
 	     }; 
 	  });
 	  return pass;
   };