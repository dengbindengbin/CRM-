window.onload =function(){
	interval = setInterval(function(){
		var d = new Date();
		y = d.getFullYear();
		m = (d.getMonth()+1);
		day = d.getDate();
		h = d.getHours();
		min = d.getMinutes();
		s = d.getSeconds();
		var hms =y+"年"+m+"月"+day+"日"+h +":"+min+":"+s
		//修改span中的时间
		var timeEle = document.getElementById("time");
		//获取文本内容
		var time = timeEle.innerHTML;
		timeEle.innerHTML = "北京时间"+":"+hms;
	},1000);
}
