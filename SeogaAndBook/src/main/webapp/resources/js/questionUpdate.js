/**
 * 
 */
$(function () {
	$('#headerNav-author').removeClass('active');
	$('#headerNav-book').removeClass('active');
	$('#headerNav-review').removeClass('active');
	$('#headerNav-question').addClass('active');
	
	$('#question-form').attr('action', 'update');
	$('#question-form').attr('method', 'POST');

})