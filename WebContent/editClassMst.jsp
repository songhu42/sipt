<%@ page contentType = "text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/initPage.jsp" %>
<%@ page import="com.humanval.sipt.util.ComUtil" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.humanval.sipt.dao.Class_mst"%>
<%@ page import="com.humanval.sipt.service.Class_mstService"%>
<%
	SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	Class_mstService service = new Class_mstService(); 
	Class_mst info = new Class_mst(); 
	

	List<Com_code> classTpList = codeService.selectList("A18");  
	List<Com_code> classStateList = codeService.selectList("A19");  

	String saveAction = ComUtil.chNull(request.getParameter("saveAction")); 
	String selClassId = ComUtil.chNull(request.getParameter("selClassId"));

	System.out.println("action : " + saveAction + " selClassId : " + selClassId); 
	

	// N : New Save, U : Update Save, D : Delete => Close Window & reload parent
	// E : Edit Mode setting .. 
	if( saveAction.equals("E") ) {
		info = service.select(ComUtil.getLongNumber(selClassId));  
	} else if( !saveAction.equals("") ) {
		long class_id = ComUtil.getLongNumber(request.getParameter("class_id"));
		String user_ids = ComUtil.chNull(request.getParameter("user_ids"));
		String class_tp = ComUtil.chNull(request.getParameter("class_tp"));
		String class_wds = new String(ComUtil.chNull(request.getParameter("class_wds")).getBytes("8859_1"), "UTF-8");
		
		int str_tm = ComUtil.getIntNumber(request.getParameter("str_tm"));
		int end_tm = ComUtil.getIntNumber(request.getParameter("end_tm"));
		long price = ComUtil.getLongNumber(request.getParameter("price"));
		int reg_cnt = ComUtil.getIntNumber(request.getParameter("reg_cnt"));
		int add_cnt = ComUtil.getIntNumber(request.getParameter("add_cnt"));

		Date start_dt = ComUtil.getDate(request.getParameter("start_dt"));
		String state = ComUtil.chNull(request.getParameter("state"));

		info.setClass_id(class_id); 
		info.setAdmin_id(userId); 
		info.setUser_ids(user_ids); 
		info.setClass_tp(class_tp); 
		info.setClass_wds(class_wds); 
		info.setStr_tm(str_tm); 
		info.setEnd_tm(end_tm); 
		info.setPrice(price); 
		info.setTot_price(price*reg_cnt); 

		info.setReg_cnt(reg_cnt); 
		info.setAdd_cnt(add_cnt); 
		info.setStart_dt(start_dt); 
		
		info.setState(state); 

		if( saveAction.equals("D") ) {
			service.delete(info); 
		} else if( saveAction.equals("U") ) {
			service.update(info); 
			
		} else if( saveAction.equals("N") ) {
			service.insert(info); 
		}
		info.setReg_dt(new Date()); 
		
	} else {
		info.setClass_id(0); 
		info.setAdmin_id(userId); 
		info.setUser_ids(""); 
		info.setUser_ids_nm(""); 
		info.setClass_tp(""); 
		info.setClass_wds(""); 
		info.setStr_tm(900); 
		info.setEnd_tm(1000); 
		info.setPrice(30000); 

		info.setReg_cnt(10); 
		info.setAdd_cnt(0); 
		info.setStart_dt(new Date()); 
		info.setReg_dt(new Date()); 
		
		info.setState(""); 
	}
	
%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>휴먼밸 서비스</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="휴먼밸, 영단어신, 바이오범프, 철학, 채식" />

		<script src="assets/js/jquery.min.js"></script>
		<script src="assets/js/jquery.modal.js"></script>
		<script src="assets/js/sido.js"></script> 
		<script src="assets/js/hsmutil.js?ver=2"></script> 
			
		<link rel="stylesheet" href="assets/css/main.css" /> 
		<link rel="stylesheet" href="assets/css/jquery.modal.css" /> 
		<link rel="stylesheet" href="assets/css/hsm.css?ver=2" /> 
<script >
</script>
	</head>
	<body class="is-preload popup">
			<section class="wrapper">
					<div class="popup">
						<section class="write">
							<div class="content">
								<h2>수업정보 등록</h2>
								
<form name="writeform" method="POST"  action="editClassMst.jsp"> 
<input type="hidden" name="saveAction" id="saveAction" value="<%=saveAction%>">
<input type="hidden" name="selClassId" id="selClassId" value="<%=selClassId%>">

<input type="hidden" name="admin_id" id="admin_id" value="<%=userId%>">

<div class="title_section"><i class="fa fa-home"></i>&nbsp;수업 정보</div>
	<table  class="table_form">
	<colgroup>
		 <col width="10%" />
		 <col width="20%" />
		 <col width="10%" />
		 <col width="20%" />
		 <col width="10%" />
		 <col width="30%" />
	  </colgroup>

	<tr>
		<th class="mandatory">ID</th>
		<td colspan="1"><input type="text" name="class_id" size="30" maxlength="30" class="f_input" value="<%=info.getClass_id()%>" readonly ></td>

		<th class="mandatory">수업종류</th>
		<td colspan="1">
				<select name="class_tp" id="class_tp" class="f_select">
<%
	for(int i=0; i<classTpList.size(); i++ ) {
		Com_code code = (Com_code)classTpList.get(i); 
%>
				  				<option value="<%=code.getCode_id()%>"  <%=(code.getCode_id().equals(info.getClass_tp()))?" selected ":"" %> ><%=code.getCode_nm()%></option>
<%}%>
		  		</select>
		</td>

		<th class="mandatory">사용자명</th>
		<td colspan="1">
			<input type="text" name="user_ids" size="30" maxlength="30" class="f_input" value="<%=info.getUser_ids()%> ">
			<input type="text" name="user_ids_nm" size="30" maxlength="30" class="f_input" value="<%=info.getUser_ids_nm()%>" readonly >
		</td>
		
	</tr>

	<tr>
		<th class="mandatory">수업요일</th>
		<td colspan="1"><input type="text" name="class_wds" size="30" maxlength="30" class="f_input" value="<%=info.getClass_wds()%>"></td>

		<th class="mandatory">시작시간</th>
		<td colspan="1"><input type="text" name="str_tm" size="30" maxlength="30" class="f_input" value="<%=info.getStr_tm()%>"></td>

		<th class="mandatory">종료시간</th>
		<td colspan="1"><input type="text" name="end_tm" size="30" maxlength="30" class="f_input" value="<%=info.getEnd_tm()%>"></td>
	</tr>


	<tr>
		<th class="mandatory">수업비용</th>
		<td colspan="1"><input type="text" name="price" size="30" maxlength="30" class="f_input" value="<%=info.getPrice()%>"></td>

		<th class="mandatory">수업횟수</th>
		<td colspan="1"><input type="text" name="reg_cnt" size="30" maxlength="30" class="f_input" value="<%=info.getReg_cnt()%>"></td>

		<th class="mandatory">보너스횟수</th>
		<td colspan="1"><input type="text" name="add_cnt" size="30" maxlength="30" class="f_input" value="<%=info.getAdd_cnt()%>"></td>

	</tr>


	<tr>
		<th class="mandatory">시작일자</th>
		<td colspan="1"><input type="text" name="start_dt" size="30" maxlength="30" class="f_input" value="<%=dayFormat.format(info.getStart_dt())%>"></td>

		<th class="mandatory">수업상태</th>
		<td colspan="1">
				<select name="state" id="state" class="f_select">
<%
	for(int i=0; i<classStateList.size(); i++ ) {
		Com_code code = (Com_code)classStateList.get(i); 
%>
				  				<option value="<%=code.getCode_id()%>"  <%=(code.getCode_id().equals(info.getState()))?" selected ":"" %> ><%=code.getCode_nm()%></option>
<%}%>
		  		</select>
		</td>

		<th class="mandatory">등록일자</th>
		<td colspan="1"><%=timeFormat.format(info.getReg_dt())%></td>

	</tr>

</table>

<div class="admin_button">
<% if( saveAction.equals("E") ) { %>
	<input type="button" class="small action" value="수정하기" onclick="check_form('U');"/>
	<input type="button" class="small action" value="삭제하기" onclick="check_form('D');"/>
<% } else { %>
	<input type="button" class="small action" value="등록하기" onclick="check_form('N');"/>
<% } %>

	<input type="button" class="small action" value="닫기" onclick="javascript:window.close();"/> 
</div>

</form>
							</div>

						</section>
						<!-- end write -->
	</div>

</section>						
			
		
<script>


(function($) {
	
	<%
	if( saveAction.equals("N") || saveAction.equals("D") || saveAction.equals("U") ) {
		if( saveAction.equals("N") || saveAction.equals("U") ) {
	%>
			alert("저장 되었습니다!"); 
	<%
		}  else {
		%>
			alert("삭제 되었습니다!"); 
		<%
		}  
		%>

		window.opener.goSearch(); 
		window.close(); 
	<%
	}
	%>
	
})(jQuery);


function send_sms(msg) {
	var send_url = "http://" + window.location.host;  
	if( $("#isSMS").val() == "N" ) return; 
	
	$.ajax({
        headers:{ 
           "Accept":"application/json", 
           "Content-type":"application/x-www-form-urlencoded" 
        },   
        url:send_url + "/rest/sendReqSms.jsp?msg=" + msg,
        success:function(response){
        	var res = response.result;
        	console.log("sms result : " + res); 
        	
        }, 
        error: function(XMLHttpRequest, textStatus, errorThrown) { 
            console.log("Fail to connect to address server : " + textStatus + " Error : " + errorThrown);  
        }   
	});

}

function check_form(cmd) {
	var form = document.writeform; 
	
	if( cmd == "D" ) {
		if (confirm('정말 삭제 하시겠습니까?')) {
			form.saveAction.value = cmd; 
			form.submit();
       }
	} else { 
		if( form.user_ids.value == "") {
			      alert('사용자명을 입력하세요!');
			      form.user_ids.focus();
			      return false;
			      
		   } else if( form.str_tm.value == "") {
			      alert('시작시간을 입력하세요!');
			      form.str_tm.focus();
			      return false;
		   } else if( form.end_tm.value == "") {
			      alert('종료시간을 입력하세요!');
			      form.end_tm.focus();
			      return false;
		   } else if( form.price.value == "") {
			      alert('회별수업비용을 입력하세요!');
			      form.price.focus();
			      return false;
		   }

		form.saveAction.value = cmd; 
		form.submit();
	}
}

</script>


	</body>
</html>