/**
 * Javascript for memberJoin.jsp
 */
$(function () {
	$('#signin-form').attr('action', 'join');
	$('#signin-form').attr('method', 'post');
});



/* 외부 유효성 검사 라이브러리용 시험 코드 */
/*$('#signin-form').validator({
	custom : {
		duplicated : function() {
			
			
			$.ajax({
				url: 'checkIdDuplicate'
					, type: 'get'
					, data: {
						id: $('#inputId').val()
					} 
					, dataType: 'json'
					
					, success: function (data) {
						if (data.canUse) {
							//$('#help-block-id').text('사용가능');
							
						} else {
							//$('#help-block-id').text('사용불가');
							return "사용불가한 아이디입니다.";
						}
					}
			});
			
			
		}
	}
	
});
*/

