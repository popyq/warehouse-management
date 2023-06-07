// 更新
function clientDetails(clientId){
    location.href="modifyClientServlet?clientId="+clientId;
}
// 删除
function clientDelete(clientId,uid){
    let flag=confirm("确认删除么?");
    if (flag){
        location.href="deleteClientServlet?clientId="+clientId+"&uid="+uid;
    }
}

