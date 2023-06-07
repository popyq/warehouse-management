// 更新
function mydetails(id){
    location.href="modifyGoodsServlet?id="+id;
}
//删除
function myDelete(id,uid){
    let flag=confirm("确认删除么?");
    if(flag){
        location.href="deleteGoodsServlet?id="+id+"&uid="+uid;
    }
}




