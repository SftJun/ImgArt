$(document).ready(function(e) {
	$('#listimg').onclick(function loadImg() {
		var imgs = $("#imgs");
		$.ajax({
			url : "listjson",
			dataType : 'json',
			success : function(data) {
				$.each(data, function(idx, item) {
					var chart = '<img src="';
					chart.append(item.imgUrl);
					char.append('"/>');
					imgs.html(chart);
					alert(chart);
					/*alert(item.imgUrl);*/
				})
			}
		});
	});
});