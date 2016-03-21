<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理</title>

<link href="${ctx_path}/themes/default/style.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx_path}/themes/css/core.css" rel="stylesheet" type="text/css" media="screen"/>
<link href="${ctx_path}/themes/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${ctx_path}/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" media="screen"/>
<!--[if IE]>
<link href="${ctx_path}/themes/css/ieHack.css" rel="stylesheet" type="text/css" media="screen"/>
<![endif]-->

<!--[if lte IE 9]>
<script src="js/speedup.js" type="text/javascript"></script>
<![endif]-->

<script type="text/javascript">
	showMsg();
	function showMsg() {
		var result = "${result}";
		var msg = "${msg}";
		if (result != null && result != "" && result == "1")
			{
			window.location.href="${ctx_path}/index.jsp";
				alert(msg);
			}
	}
</script>
</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="#">标志</a>
				<ul class="nav">
					
					<li><a href="changepwd.html" target="dialog" width="600">设置</a></li>
					<li><a href="${ctx_path}/login/exit" >退出</a></li>
				</ul>
				<!-- <ul class="themeList" id="themeList">
					<li theme="default"><div class="selected">蓝色</div></li>
					<li theme="green"><div>绿色</div></li>
					<li theme="red"><div>红色</div></li>
					<li theme="purple"><div>紫色</div></li>
					<li theme="silver"><div>银色</div></li>
					<li theme="azure"><div>天蓝</div></li>
				</ul> -->
			</div>

			<!-- navMenu -->
			
		</div>

		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"><h2>主菜单</h2><div>收缩</div></div>

				<div class="accordion" fillSpace="sidebar">
					 
					<div class="accordionHeader">
						<h2><span>Folder</span>常用功能</h2>
					</div>
					<div class="accordionContent">
								<ul class="tree treeFolder">
							<li><a href="${ctx_path}/Answer/add2" target="dialog"  max="true"  mask="true"  rel="UserAnswerAdd">问卷填写</a></li>
							<li><a href="${ctx_path}/Customer/index" target="navTab" rel="Customer">客服管理</a></li>
							<li><a href="${ctx_path}/Note/index?strut=0" target="navTab" rel="Customer">未完成问卷管理</a></li>
							<li><a href="${ctx_path}/Note/index?strut=1" target="navTab" rel="Customer">已完成问卷管理</a></li>
							<li><a href="${ctx_path}/Customer/deleteAll" target="ajaxTodo" rel="Customer">小灵呼客户清空(仅九点半以前可用)</a></li>
							<c:if test="${sessionScope.userID==sessionScope.admin}">
							<li><a href="${ctx_path}/Note/count?year=2014&moth=06" target="navTab" rel="Customer">统计</a></li>
							<li><a href="${ctx_path}/Note/countAll?questionID=11&disNo=1" target="navTab" rel="Customer">调查结果(单选题)</a></li>
							<li><a href="${ctx_path}/DownLog.jsp" target="navTab" rel="Customer">调查结果(文本题)</a></li>
					<li><a href="${ctx_path}/Customer/updateAll" target="navTab" rel="Customer">科室调整</a></li>
				 	<li><a href="${ctx_path}/Customer/deleteDuoc" target="navTab" rel="Customer">去除重复</a></li>
				 	<li><a href="${ctx_path}/Customer/updatePost" target="navTab" rel="Customer">添加answerresult科室</a></li>
						<%--	
					<li><a href="${ctx_path}/Customer/select" target="navTab" rel="Customer">查询重复</a></li>
					<li><a href="${ctx_path}/Customer/select2" target="navTab" rel="Customer">查询重复2</a></li>
					--%>						 	
					
							</c:if>
						</ul>
					</div>
					<c:if test="${sessionScope.userID==sessionScope.admin}">
					<div class="accordionHeader">
						<h2><span>Folder</span>系统设置</h2>
					</div>
					<div class="accordionContent">
						<ul class="tree">
							<li><a href="${ctx_path}/CustomerExcelAdd.jsp" target="navTab" rel="CustomerExcelAdd"  external="true">导入客服</a></li>
							<li><a href="${ctx_path}/Survey/index" target="navTab" rel="SurveyList">问卷管理</a></li>
							<li><a href="${ctx_path}/Questions/index" target="navTab" rel="QuestionsAdminList">问题管理</a></li>
							<li><a href="${ctx_path}/Select/index" target="navTab" rel="SelectAdminList">选项管理</a></li>
						</ul>
					</div>
					</c:if>
				</div>
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:;"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:;">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div class="page unitBox">
						<div class="accountInfo">
						
							<div class="alertInfo">
							<br/>
								当前登陆用户:${sessionScope.userID}
							</div>
							
							
						</div>
						 
						<div class="pageFormContent" >
						欢迎
						</div>
						 
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer">Copyright &copy; 2014 <a href="demo_page2.html" target="dialog">关于我们</a> 京ICP备05019125号-10</div>
 
<script src="${ctx_path}/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="${ctx_path}/js/jquery.cookie.js" type="text/javascript"></script>
<script src="${ctx_path}/js/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx_path}/js/jquery.bgiframe.js" type="text/javascript"></script>
<script src="${ctx_path}/xheditor/xheditor-1.2.1.min.js" type="text/javascript"></script>
<script src="${ctx_path}/xheditor/xheditor_lang/zh-cn.js" type="text/javascript"></script>
<script src="${ctx_path}/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>

<script src="${ctx_path}/js/dwz.core.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.util.date.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.validate.method.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.barDrag.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.drag.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.tree.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.accordion.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.ui.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.theme.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.switchEnv.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.alertMsg.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.contextmenu.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.navTab.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.tab.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.resize.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.dialog.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.dialogDrag.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.sortDrag.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.cssTable.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.stable.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.taskBar.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.ajax.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.pagination.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.database.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.datepicker.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.effects.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.panel.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.checkbox.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.history.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.combox.js" type="text/javascript"></script>
<script src="${ctx_path}/js/dwz.print.js" type="text/javascript"></script>

<!-- 可以用dwz.min.js替换前面全部dwz.*.js (注意：替换是下面dwz.regional.zh.js还需要引入)
<script src="bin/dwz.min.js" type="text/javascript"></script>
-->
<script src="${ctx_path}/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){
	DWZ.init("${ctx_path}/dwz.frag.xml", {
		loginUrl:"login_dialog.html", loginTitle:"登录",	// 弹出登录对话框
//		loginUrl:"login.html",	// 跳到登录页面
		statusCode:{ok:200, error:300, timeout:301}, //【可选】
		pageInfo:{pageNum:"pageNum", numPerPage:"numPerPage", orderField:"orderField", orderDirection:"orderDirection"}, //【可选】
		keys: {statusCode:"statusCode", message:"message"}, //【可选】
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"themes"}); // themeBase 相对于index页面的主题base路径
		}
	});
});

</script>





</body>
</html>