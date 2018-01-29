/**
 * Javascript for memberUpdate.jsp
 */
$(function () {
	
	$('#update-form').attr('action', getContextPath()+'/member/update');
	$('#update-form').attr('method', 'post');
	
	$('#withdrawal').on('click', function () {
		location.href = "delete";
	});
	
});

function getContextPath(){
    var offset=location.href.indexOf(location.host)+location.host.length;
    var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
    return ctxPath;
}
