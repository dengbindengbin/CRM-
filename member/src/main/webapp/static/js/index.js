$(function(){
	/*初始化树组件*/
	$("#index_tree").tree({
		url:"/menu_list.do",
		onClick:function(node){
			//console.log(node);
			//判断选项卡是否存在,如果存在,就选中该选项卡,否则,就添加一个选项卡
			if($("#index_tabs").tabs("exists",node.text)){//存在
				$("#index_tabs").tabs("select",node.text);//选中
			}else{//不存在
				$("#index_tabs").tabs("add",{
					title:node.text,
					closable:true,
//					href:node.attributes.url,
					content:"<iframe frameborder=0 height='100%' width='100%' src="+node.url+"></iframe>"
				})
			}
		}
	})
})