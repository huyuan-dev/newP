if (window.top !== window.self) {
    window.top.location = window.location
}
;
var inputValue = null;
layui.use(['form', 'layedit', 'laydate'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;

    //日期
    /* laydate.render({
       elem: '#date'
     });
     laydate.render({
       elem: '#date1'
     });

     //创建一个编辑器
     var editIndex = layedit.build('LAY_demo_editor');

     //自定义验证规则
     form.verify({
       title: function(value){
         if(value.length < 5){
           return '标题至少得5个字符啊';
         }
       }
       ,pass: [
         /^[\S]{6,12}$/
         ,'密码必须6到12位，且不能出现空格'
       ]
       ,content: function(value){
         layedit.sync(editIndex);
       }
     });

     //监听指定开关
     form.on('switch(switchTest)', function(data){
       layer.msg('开关checked：'+ (this.checked ? 'true' : 'false'), {
         offset: '6px'
       });
       layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
     });*/

    //监听提交
    form.on('submit(formDemo)', function (data) {
        var show_num = [];
        var val = $(".input-val").val().toLowerCase();
        var num1 = $(" #getvalue ").val()
        console.log(num1+ "===输入框的值3")
        if (val == '') {
            //alert('请输入验证码！');
            layer.msg('请输入验证码');
            return false;
        } else if (val == num1) {
            var name = document.getElementById("userName");
            var password = document.getElementById("userPassword");

        } else {
            layer.msg('验证码错误！请重新输入！');
            //alert('验证码错误！请重新输入！');
            $(".input-val").val('');
            draw(show_num);
            var num = show_num.join("");
            inputValue='';
            inputValue = num;
            document.getElementById("getvalue").value = inputValue;
            console.log($("#getvalue").val() + "===输入框的值2")
            return false;
        }
    });

    $(function () {
        var show_num = [];
        draw(show_num);
        var num = show_num.join("");
        inputValue = num;
        document.getElementById("getvalue").value = inputValue;
        console.log($("#getvalue").val() + "===输入框的值")
        $("#canvas").on('click', function () {
            draw(show_num);
        })
    })

    /* function login() {
         var name=document.getElementById("userName");
         var password=document.getElementById("userPassword");
         $.ajax ({
             url :"http://localhost:8080/login/loginValidate",
             type:"get",
             /!*data:{
                 userName:name,
                 userPassword:password
             },
             dataType:'json',*!/
             success:function (res) {
                 console.log(res);
             }
         })
     };*/
    function draw(show_num) {
        var canvas_width = $('#canvas').width();
        var canvas_height = $('#canvas').height();
        var canvas = document.getElementById("canvas");//获取到canvas的对象，演员
        var context = canvas.getContext("2d");//获取到canvas画图的环境，演员表演的舞台
        canvas.width = canvas_width;
        canvas.height = canvas_height;
        var sCode = "A,B,C,E,F,G,H,J,K,L,M,N,P,Q,R,S,T,W,X,Y,Z,1,2,3,4,5,6,7,8,9,0";
        var aCode = sCode.split(",");
        var aLength = aCode.length;//获取到数组的长度

        for (var i = 0; i <= 3; i++) {
            var j = Math.floor(Math.random() * aLength);//获取到随机的索引值
            var deg = Math.random() * 30 * Math.PI / 180;//产生0~30之间的随机弧度
            var txt = aCode[j];//得到随机的一个内容
            show_num[i] = txt.toLowerCase();
            var x = 10 + i * 20;//文字在canvas上的x坐标
            var y = 20 + Math.random() * 8;//文字在canvas上的y坐标
            context.font = "bold 23px 微软雅黑";

            context.translate(x, y);
            context.rotate(deg);

            context.fillStyle = randomColor();
            context.fillText(txt, 0, 0);

            context.rotate(-deg);
            context.translate(-x, -y);
        }
        for (var i = 0; i <= 5; i++) { //验证码上显示线条
            context.strokeStyle = randomColor();
            context.beginPath();
            context.moveTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.lineTo(Math.random() * canvas_width, Math.random() * canvas_height);
            context.stroke();
        }
        for (var i = 0; i <= 30; i++) { //验证码上显示小点
            context.strokeStyle = randomColor();
            context.beginPath();
            var x = Math.random() * canvas_width;
            var y = Math.random() * canvas_height;
            context.moveTo(x, y);
            context.lineTo(x + 1, y + 1);
            context.stroke();
        }
    }

    function randomColor() {//得到随机的颜色值
        var r = Math.floor(Math.random() * 256);
        var g = Math.floor(Math.random() * 256);
        var b = Math.floor(Math.random() * 256);
        return "rgb(" + r + "," + g + "," + b + ")";
    }

});




