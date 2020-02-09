<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
hello file upload jsp

<form action="fileupload" method="POST">
<input type="file" id="file" multiple="multiple">
	<button onClick="upload()">upload</button>

</input>
</form>

<script type="text/javascript">

function upload(){
	
	var data=new FormData();
	jQuery.each(jQuery('#file')[0].files,function(i,file){
			data.append('file-'+i,file);
			
		});
	$.ajax({
	
		url:'/fileupload',
		data:data,
		cache:false, 
		
		contentType:false,
		processData:false,
		type:'POST',
		success:function(response){
		    if(response.status==200){
		    	alert(response.uploadedfile);
		    }else{
		    	alert("error");
		    }
		}
	});
};
</script>
</body>
</html>