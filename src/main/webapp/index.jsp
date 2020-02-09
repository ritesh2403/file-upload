<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

</head>
<body>
	<h2>Hello World!</h2>

	<form>
		<input id="check" type="checkbox" name="credit" value="">apply
		credit limit <input id="credit" style="display: none" type="text"
			name="credit" placeholder="enter credit limit"></input> <input
			id="create" type="button" value="submit"></input>
			
			<input type="file"></input>
	</form>
</body>
</html>
<script>
	$(document).ready(function() {

		$("#check").click(function() {
			$("#credit").val("0.0");
			$("#credit").toggle();
		});

	});

	
	/* $(document).ready(function() {
	
		$("#create").click(function() {
			var x=$("#credit").val();
			alert(x);
			
			$.ajax({
				url:'creditcard',
				type : "POST",
				data : {credit:x}, 
				 dataType: 'html',
				success : function(data) {
					alert(data);
				}
			
			});
			
		});
		
	}); */
		
</script>