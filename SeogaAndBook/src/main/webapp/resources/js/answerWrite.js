/**
 * 
 */
$(function () {
	$('#headerNav-author').removeClass('active');
	$('#headerNav-book').removeClass('active');
	$('#headerNav-review').removeClass('active');
	$('#headerNav-question').addClass('active');
	
	$('#answer-form').attr('action', 'enterAnswer');
	$('#answer-form').attr('method', 'POST');
})