$(function(){
    unlogin()
    login()
    release()
    submit()
})
//未登录状态下点击发布按钮
function unlogin() {
    $("#unlogin-fabu").click(function () {
        alert("请先登录后再发布问题！");
        return;
    });
}
//点击登录按钮
function login() {
    $("#login").click(function () {
        // window.location.href="https://github.com/login/oauth/authorize?client_id=d2df38480a2f3f08e6db&redirect_uri=http://localhost:8097/callback&scope=user&state=1";
        window.location.href="http://localhost:8097/login";
    });
}
//发布页登录
function release(){
    $("#login-fabu").click(function () {
        window.location.href="http://localhost:8097/publishs";
    });
}
//发布问题
function submit() {
    $("#submit_tj").click(function () {
        var title = $("#title").val();
        var description = $("#description").val();
        var tag = $("#tag").val();
        if (title==null||title==''){
            alert("请填写问题标题！");
            return;
        }
        if (description==null||description==''){
            alert("请填写问题补充！");
            return;
        }
        if (tag==null||tag==''){
            alert("请填写问题标签！");
            return;
        }
        document.getElementById("myform").submit();
        alert("发布成功！");
    });
}

