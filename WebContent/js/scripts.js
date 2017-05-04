$( document ).ready(function() {
    tabs();
});

function tabs() {
	$(".tab-title").click(function() {
		console.log($(this));
		$(".tab-title").toggleClass("active");
		$(".tab-content").toggleClass("tab-active");
	});
}