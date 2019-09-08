findVp();//渲染桶
//创建桶
$("#gsubmit").click(function() {
	var yes = $("#yes").is(":checked"); //判断是否选中同意条款
		var gname = $("#gname").val();
		var gref = $("#gref").val();
		var action = 0;
		var vstarttime = $("#vstarttime").val(); // 开始时间
		var vdeadline = $("#vdeadline").val(); //截至时间
		var vpa = $("#aselect").val();
		alert(vdeadline)
		if (gname == "" || gref == "" || vstarttime == "" || vdeadline == "" ){
			alert("请填写完整.")
			return false;
		}
		if(yes){
			action = 1;
		}
		var vp = {'vpaction':action,'vpname': gname,'vptrace': gref,"vstarttime": vstarttime,"vdeadline": vdeadline,"vpa":vpa}
		$.ajax({
			url: "vote?src=addGroup",
			data: {'vp':JSON.stringify(vp)},
			type: "post",
			dataType: "text",
			success: function(result) {
				if("ok" == result){
					alert(result)
					findVp();//渲染桶
				}
			}
		});

})
//选项添加 +
$(document).on("click", ".ji1", function() {
	var xuan = $(".xuanliqi");
	if(xuan.length >= 5) {
		alert("最多添5个选项")
		return false;
	}
	var xuan = $('<div class="form-group xuanliqi"><label for="pillInput">请填写选项</label><input type="text" class="form-control input-pill voptionA"  placeholder=" 列:天晴"><span class="badge badge-default ji1">+</span><span class="badge badge-default jia1">-</span></div>')
	$(this).parents(".xuanliqi").after(xuan)
})
//选项删除 -
$(document).on("click", ".jia1", function() {
	var xuan = $(".xuanliqi");
	if(xuan.length >= 3) {
		$(this).parents(".xuanliqi").remove();
	} else {
		alert("至少添加两个选项")
	}
})

//完成
$("#wan").click(function() {
	var inp = $(".voptionA");
	var option = []; //问题选项
	var name = $("#vissue").val(); //问题
	var solidSelect = $("#solidSelect").val(); // 分类id
	$(".voptionA").each(function(i, j) {
		option[i] = $(this).val();
	})
	var voptionA = option[0]; //选项1
	var voptionB= option[1];//选项2
	var voptionC= option[2];//选项3
	var voptionD= option[3];//选项4
	var voptionE= option[4];//选项5
	if(option[0] == "" || option[1] == "" || name == "" || vstarttime == "" || vdeadline == "") {
		alert("请填写完整")
		return false;
	}
	var str = {"vpid": solidSelect,"name": name,"voptionA": voptionA,"voptionB": voptionB,"voptionC": voptionC,"voptionD": voptionD,"voptionE": voptionE}
	$.ajax({
		url: "vote?src=addVote",
		data: {'str':JSON.stringify(str)},
		type: "post",
		dataType: "text",
		success: function(result) {
			if("ok" == result){
				alert("添加成功")
				// $("#formsjik").hide();//添加完成隐藏添加div
			}
		}
	});
})
//完成并创建
$("#wang").click(function() {
	var inp = $(".voptionA");
	var option = []; //问题选项
	var name = $("#vissue").val(); //问题
	var solidSelect = $("#solidSelect").val(); // 分类id
	$(".voptionA").each(function(i, j) {
		option[i] = $(this).val();
	})
	var voptionA = option[0]; //选项1
	var voptionB= option[1];//选项2
	var voptionC= option[2];//选项3
	var voptionD= option[3];//选项4
	var voptionE= option[4];//选项5
	if(option[0] == "" || option[1] == "" || name == "" || vstarttime == "" || vdeadline == "") {
		alert("请填写完整")
		return false;
	}
	var str = {"vpid": solidSelect,"name": name,"voptionA": voptionA,"voptionB": voptionB,"voptionC": voptionC,"voptionD": voptionD,"voptionE": voptionE}
	$.ajax({
		url: "vote?src=addVote",
		data: {'str':JSON.stringify(str)},
		type: "post",
		dataType: "text",
		success: function(result) {
			if("ok" == result){
				option = [];
				$("#vissue").val("");
				$("#vstarttime").val("");
				$("#vdeadline").val("");
				$(".voptionA").each(function(i, j) {
					alert("添加成功!")
					$(this).val("");
				})
			}
		}
	});
})
//渲染桶
function findVp(){
	$.ajax({
		url:"vote?src=findVp",
		data:"",
		dataType:"json",
		type:"post",
		success:function (result) {
			var sele =$("#solidSelect");
			$.each(result,function (i,j) {
				var op = $("<option>")
				op.val(j.vpid);
				op.html(j.vpname);
				sele.append(op)
			})
		}
	})
}
//开始日期
$("#vstarttime").change(function() {
	var a = $("#vstarttime").val()
	var arr = a.split("-");
	var starttime = new Date(arr[0], arr[1] - 1, arr[2]);
	var m = starttime.getTime();
	var myDate = new Date();
	var n = myDate.getTime();
	if(m + 86400000 < n) {
		alert("请选择正确时间")
		$(this).val("")
	}
})

//截至日期
$("#vdeadline").change(function() {
	var op = $("#vstarttime").val() //开始时间
	var po = $("#vdeadline").val() //截至时间
	duibi(op, po)
})

//日期比较
function duibi(a, b) {
	var arr = a.split("-");
	var starttime = new Date(arr[0], arr[1], arr[2]);
	var starttimes = starttime.getTime();

	var arrs = b.split("-");
	var lktime = new Date(arrs[0], arrs[1], arrs[2]);
	var lktimes = lktime.getTime();
	if((lktimes - starttimes) / 86400000 > 30) {
		alert("日期相差不能大于30天")
		$("#vdeadline").val("")
	}
}