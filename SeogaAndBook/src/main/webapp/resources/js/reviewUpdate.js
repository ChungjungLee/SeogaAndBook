/**
 * 
 */
$(function () {
	$('#headerNav-author').removeClass('active');
	$('#headerNav-book').removeClass('active');
	$('#headerNav-review').addClass('active');
	$('#headerNav-question').removeClass('active');
	
	$('#review-form').attr('action', 'update');
	$('#review-form').attr('method', 'POST');
})