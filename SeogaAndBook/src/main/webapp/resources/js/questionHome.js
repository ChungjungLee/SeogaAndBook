/**
 * 
 */
$(function () {
	$('#headerNav-author').removeClass('active');
	$('#headerNav-book').removeClass('active');
	$('#headerNav-review').removeClass('active');
	$('#headerNav-question').addClass('active');
	
	$('#search-btn').on('click', function () {
		search(1);
	});
})

function search(page) {
	$('#pageNum').val(page);
	$('#searchForm').submit();
}

