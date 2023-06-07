//获得内置对象xhr
function getXHR(){
    var xhr=null;
    if((typeof XMLHttpRequest)!='undefined'){
         xhr=new XMLHttpRequest();
    }else{
        xhr=new ActiveXObject('Microsoft.XMLHttp');
    }
    return xhr;
}