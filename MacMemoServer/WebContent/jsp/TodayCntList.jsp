<%@page import="dao.StaticDao"%>
<%@page import="vo.TodayCnt"%>
<%@page import="dao.TodayCntDao"%>
<%@page import="dao.MobileUserDao"%>
<%@page import="vo.MobileUser"%>
<%@page import="dao.UpdateAppDao"%>
<%@page import="vo.UpdateApp"%>
<%@page import="utils.XMLParser"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="CheckSession.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/jquery.scrolly.min.js"></script>
<script src="js/jquery.onvisible.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<script src="http://code.jquery.com/jquery-1.9.0.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.0.0.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/style.css" />
<link rel="stylesheet" href="/css/style-desktop.css" />
<link rel="stylesheet" href="/css/style-noscript.css" />
<script type="text/javascript">
	function pass(url) {
		location.href = url;
	}
	//월별 배열 
	var todayCntArr = new Array();
	var lastestDayCntArr = new Array();
	for (var i = 0; i < 12; i++) {
		todayCntArr[i] = 0;
		lastestDayCntArr[i] = 0;
	}
	//주별 배열 정의[12][7]
	var dayCntArr = [];
	for (var i = 0; i < 12; i++) {
		dayCntArr[i] = new Array();
		for (var j = 0; j < 7; j++) {
			dayCntArr[i][j] = 0;
		}
	}

	//시간별 배열 정의[12][8]
	var timeCntArr = [];
	for (var i = 0; i < 12; i++) {
		timeCntArr[i] = new Array();
		for (var j = 0; j < 8; j++) {
			timeCntArr[i][j] = 0;
		}
	}
	$(function() {
		$('#container_month')
				.highcharts(
						{
							title : {
								text : 'KMemo App Month Visit',
								x : -20
							//center
							},
							subtitle : {
								text : 'Source: http://grapegirl.ddns.net:9000/',
								x : -20
							},
							xAxis : {
								categories : [ 'Jan', 'Feb', 'Mar', 'Apr',
										'May', 'Jun', 'Jul', 'Aug', 'Sep',
										'Oct', 'Nov', 'Dec' ]
							},
							yAxis : {
								title : {
									text : 'Visit'
								},
								plotLines : [ {
									value : 0,
									width : 1,
									color : '#808080'
								} ]
							},
							tooltip : {
								valueSuffix : '회 방문'
							},
							legend : {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
								borderWidth : 0
							},
							series : [ {
								name : 'KMemo 2017',
								data : todayCntArr
							} ]
						});
	});

	$(function() {
		$('#container_day').highcharts({
			title : {
				text : 'KMemo App Day Visit',
				x : -20
			//center
			},
			subtitle : {
				text : 'Source: http://grapegirl.ddns.net:9000/',
				x : -20
			},
			xAxis : {
				categories : [ '일', '월', '화', '수', '목', '금', '토' ]
			},
			yAxis : {
				title : {
					text : 'Visit'
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},
			tooltip : {
				valueSuffix : '회 방문'
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
			series : [ {
				name : '2월',
				data : dayCntArr[1]
			}, {
				name : '3월',
				data : dayCntArr[2]
			}, {
				name : '4월',
				data : dayCntArr[3]
			}, {
				name : '5월',
				data : dayCntArr[4]
			}, {
				name : '6월',
				data : dayCntArr[5]
			}, {
				name : '7월',
				data : dayCntArr[6]
			}, {
				name : '8월',
				data : dayCntArr[7]
			}, {
				name : '9월',
				data : dayCntArr[8]
			}, {
				name : '10월',
				data : dayCntArr[9]
			}, {
				name : '11월',
				data : dayCntArr[10]
			}, {
				name : '12월',
				data : dayCntArr[11]
			} ]

		});
	});

	$(function() {
		$('#container_lastest')
				.highcharts(
						{
							title : {
								text : 'KMemo App Lastest Month Visit',
								x : -20
							//center
							},
							subtitle : {
								text : 'Source: http://grapegirl.ddns.net:9000/',
								x : -20
							},
							xAxis : {
								categories : [ 'Jan', 'Feb', 'Mar', 'Apr',
										'May', 'Jun', 'Jul', 'Aug', 'Sep',
										'Oct', 'Nov', 'Dec' ]
							},
							yAxis : {
								title : {
									text : 'Visit'
								},
								plotLines : [ {
									value : 0,
									width : 1,
									color : '#808080'
								} ]
							},
							tooltip : {
								valueSuffix : '회 방문'
							},
							legend : {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
								borderWidth : 0
							},
							series : [ {
								name : 'KMemo 2017',
								data : lastestDayCntArr
							} ]
						});
	});

	$(function() {
		$('#container_lastest_time')
				.highcharts(
						{
							title : {
								text : 'KMemo App Lastest Time Visit',
								x : -20
							//center
							},
							subtitle : {
								text : 'Source: http://grapegirl.ddns.net:9000/',
								x : -20
							},
							xAxis : {
								categories : [ '1-3', '4-6', '7-9', '10-12',
										'13-15', '16-18', '19-21', '22-24' ]
							},
							yAxis : {
								title : {
									text : 'Visit'
								},
								plotLines : [ {
									value : 0,
									width : 1,
									color : '#808080'
								} ]
							},
							tooltip : {
								valueSuffix : '회 방문'
							},
							legend : {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
								borderWidth : 0
							},
							series : [ {
								name : '2월',
								data : timeCntArr[1]
							}, {
								name : '3월',
								data : timeCntArr[2]
							}, {
								name : '4월',
								data : timeCntArr[3]
							}, {
								name : '5월',
								data : timeCntArr[4]
							}, {
								name : '6월',
								data : timeCntArr[5]
							}, {
								name : '7월',
								data : timeCntArr[6]
							}, {
								name : '8월',
								data : timeCntArr[7]
							}, {
								name : '9월',
								data : timeCntArr[8]
							}, {
								name : '10월',
								data : timeCntArr[9]
							}, {
								name : '11월',
								data : timeCntArr[10]
							}, {
								name : '12월',
								data : timeCntArr[11]
							} ]

						});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메모가지 관리자</title>
</head>
<body class="homepage">
	<div class="inner">
		<b>방문자 관리 페이지</b>
		<form name=board method=post>

			<div id="container_month"
				style="min-width: 310px; height: 400px; margin: 0 auto"></div>

			<div id="container_day"
				style="min-width: 310px; height: 400px; margin: 0 auto"></div>

			<div id="container_lastest"
				style="min-width: 310px; height: 400px; margin: 0 auto"></div>

			<div id="container_lastest_time"
				style="min-width: 310px; height: 400px; margin: 0 auto"></div>

			<!-- 
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr height="5">
					<td width="5"></td>
				</tr>
				<tr align="center">
					<td width="80">날짜</td>
					<td width="80">요일</td>
					<td width="80">방문수</td>
				</tr>
				<tr height="1" bgcolor="#82B5DF">
					<td colspan="8" width="752"></td>
				</tr>
				 -->
			<%
				//사용자 정보 불러오기
				ArrayList<TodayCnt> list = (ArrayList<TodayCnt>) TodayCntDao.selecetTodayCnt();
				int[] countList = new int[12];
				int[][] dayCountList = new int[12][7];

				for (int i = 0; i < countList.length; i++) {
					countList[i] = 0;
				}
				for (int i = 0; i < 12; i++) {
					for (int j = 0; j < 7; j++) {
						dayCountList[i][j] = 0;
					}
				}

				for (int i = 0; i < list.size(); i++) {
			%>
			<!-- 
			<tr align="center" height="30">
				<td width="80"><%=list.get(i).getDate()%></td>

				<td width="80">
					<%if (list.get(i).getDay().equals("토")) {%> <font color="blue"><%=list.get(i).getDay()%></font> 
					<%} else if (list.get(i).getDay().equals("일")) {%> <font color="red"><%=list.get(i).getDay()%></font> 
					<%} else {%> <font color="black"><%=list.get(i).getDay()%></font> <%}%>
				</td>
				<td width="80"><%=list.get(i).getTodayCnt()%></td>
					 -->
			<%
				// 달별로 방문수 누적하여 합산한다.
					String month = list.get(i).getDate().substring(5, 7);
					int index = Integer.valueOf(month);
					index = index - 1;
					int count = list.get(i).getTodayCnt();
					countList[index] += count;

					//월별로 주별 방문수를 누적하여 합산한다.
					String[] dayArr = {"일", "월", "화", "수", "목", "금", "토"};

					String day = list.get(i).getDay();
					int dayIndex = 0;
					for (int k = 0; k < dayArr.length; k++) {
						if (dayArr[k].equals(day)) {
							dayIndex = k;
							break;
						}
					}

					dayCountList[index][dayIndex] += count;
				}
			%>
			<%
				int forCount = 0;
			%>

			<script>
				// 월별 카운트 (JSP->Javascript)
			<%for (int i = 0; i < 12; i++) {%>
				todayCntArr[
			<%=i%>
				] = (
			<%=countList[i]%>
				);
			<%}%>
				// 주별 카운트 (JSP->Javascript)
			<%for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 7; j++) {%>
				dayCntArr[
			<%=i%>
				][
			<%=j%>
				] = (
			<%=dayCountList[i][j]%>
				);
			<%}%>
				
			<%}%>
				
			</script>

			<%
				//사용자 정보 불러오기(최근방문수 월별)
				ArrayList<TodayCnt> monthList = (ArrayList<TodayCnt>) StaticDao.selecetMonthCnt();
				int[] monthCountList = new int[12];
				for (int i = 0; i < countList.length; i++) {
					monthCountList[i] = 0;
				}
				int[][] timeCountList = new int[12][8];
				for (int i = 0; i < 12; i++) {
					for (int j = 0; j < 8; j++) {
						timeCountList[i][j] = 0;
					}
				}

				for (int i = 0; i < monthList.size(); i++) {
					// 최근방문일로 방문수 누적하여 합산한다.
					String month = monthList.get(i).getLastDt().substring(5, 7);
					int nMonth = Integer.valueOf(month);
					int index = Integer.valueOf(nMonth) - 1;
					monthCountList[index]++;

					String time = monthList.get(i).getLastDt().substring(11, 13);
					int timeIndex = 0;
					int nTime = Integer.valueOf(time);

					if (nTime >= 1 && nTime <= 3) {
						timeIndex = 0;
					} else if (nTime >= 4 && nTime <= 6) {
						timeIndex = 1;
					} else if (nTime >= 7 && nTime <= 9) {
						timeIndex = 2;
					} else if (nTime >= 10 && nTime <= 12) {
						timeIndex = 3;
					} else if (nTime >= 13 && nTime <= 15) {
						timeIndex = 4;
					} else if (nTime >= 16 && nTime <= 18) {
						timeIndex = 5;
					} else if (nTime >= 19 && nTime <= 21) {
						timeIndex = 6;
					} else {
						timeIndex = 7;
					}

					timeCountList[index][timeIndex]++;
				}
			%>
			<script>
				// 최근 방문수 카운트 (JSP->Javascript)
			<%for (int i = 0; i < 12; i++) {%>
				lastestDayCntArr[
			<%=i%>
				] = (
			<%=monthCountList[i]%>
				);
			<%}%>
				//최근 방문수 시간 카운트 (JSP->Javascript)
			<%for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 8; j++) {%>
				timeCntArr[
			<%=i%>
				][
			<%=j%>
				] = (
			<%=timeCountList[i][j]%>
				);
			<%}%>
				
			<%}%>
				
			</script>

			<!-- 
				</table>
 				-->
			<table width="100%" cellpadding="0" cellspacing="0" border="0">
				<tr>
					<td colspan="4" height="30"></td>
				</tr>
				<tr align="center">
					<td><input type=button value="홈"
						Onclick="javascript:pass('/kikiMain.html')"></td>

				</tr>
				<tr height="100">
					<td colspan="6"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>

