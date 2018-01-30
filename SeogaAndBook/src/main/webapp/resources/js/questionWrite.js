/**
 * 
 */
$(function () {
	$('#headerNav-author').removeClass('active');
	$('#headerNav-book').removeClass('active');
	$('#headerNav-review').removeClass('active');
	$('#headerNav-question').addClass('active');
	
	$('#question-form').attr('action', 'write');
	$('#question-form').attr('method', 'POST');
})