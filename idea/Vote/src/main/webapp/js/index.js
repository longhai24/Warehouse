function pageClick(k) {
	$(k).parent().find("div").removeClass("active");
	$(k).addClass("active");
	$("#flTitle").text($(k).text());
	if ($(k).text() == "投票") {
		$(".content").show();
		$(".content1").hide();
		$(".content2").hide();
	}  else if ($(k).text() == "管理投票") {
		$(".content").hide();
		$(".content1").show();
		$(".content2").hide();
	}else if ($(k).text() == "查看投票信息") {
		$(".content2").html('<iframe src="VoteSubAction?method=tolinear" height="1700px" width="100%" scrolling=no></iframe>').show();
		$(".content1").hide();
		$(".content").hide();
	}
}
