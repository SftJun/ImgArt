$(document).ready(function(e) {
	$('#listimg').click(function loadImg() {
		var imgs = $('#imgs');
		$.ajax({
			url : "listjson",
			dataType : 'json',
			success : function(data) {
				$.each(data, function(idx, item) {
					var firstchar = "<img src='/ImgArt/img/showimg/";
					var imgid = item.id;
					var lastchar = "'>";
					imgs.append(firstchar+imgid+lastchar);
				})
			}
		});
	});
});