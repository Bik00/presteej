<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<link rel='stylesheet' href='./calendarjs/jquery-ui.min.css'>
<link rel='stylesheet' href='./calendarjs/fullcalendar.css'>
<!-- <link href='./calendarjs/fullcalendar.print.css' rel='stylesheet' media='print' /> -->
<script src='./calendarjs/moment.min.js'></script>
<script src='./calendarjs/jquery.min.js'></script>
<script src='./calendarjs/jquery-ui.min.js'></script>
<script src='./calendarjs/fullcalendar.js'></script>
<!-- 	<link rel="stylesheet" href="./css/material.min.css"> -->

<script>

$(window).on('load', function() {
		setTimeout(function()
		{
			$('#current').trigger('click');
		}, 90);
});

	$(document).ready(function() {

		$('#current').click(function() {
		    $('#calendar').fullCalendar('today');
		});

		$('#calendar').fullCalendar({
/* 			theme: true, */
			header: {
				left: 'prev,next',
				center: 'title',
			},
			defaultDate: '2016-09-12',
			navLinks: false, // can click day/week names to navigate views
			selectable: true,
			selectHelper: true,
			select: function(start, end) {
				var title = prompt('Event Title:');
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
			},
			editable: true,
			eventLimit: true, // allow "more" link when too many events
			events: {
				url: './json/calendar.json',
				error: function() {
					$('#script-warning').show();
				}
			},
			loading: function(bool) {
				$('#loading').toggle(bool);
			}
		});
	});
</script>
<style>

	body {
		margin: 40px 10px;
		padding: 0;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		font-size: 14px;
	}

	#calendar {
		max-width: 900px;
		margin: 0 auto;
	}

	#current {
		visibility:hidden;
	}
</style>
</head>
<body>
	<div id='calendar'></div>
	<div id='current'></div>
</body>
</html>
