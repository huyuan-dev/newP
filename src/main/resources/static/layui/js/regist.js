layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;


});
var phoneCode;
//发送短信验证码
function sendMsg() {
    var phone = $("#phone").val();
    console.log("输入的手机号码是：===" + phone)
    $.ajax({
        type: "POST",
        url: "smsverification",
        data: {
            "phone":phone
        },
        dataType: "json",
        async: false,
        success: function (data) {
            if(data.code==200){
                phoneCode=data.codeMsg;
            }else {
                layer.msg("短信发送失败，请稍后再试")
                return;
            }
        },
        error: function () {
            layer.msg("短信接口请求错误");
        }
    });
}