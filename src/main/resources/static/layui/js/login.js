if(window.top!==window.self){window.top.location=window.location};

    function login() {
        var name=document.getElementById("userName");
        var password=document.getElementById("userPassword");
        $.ajax ({
            url :"http://localhost:8080/login/loginValidate",
            type:"get",
            /*data:{
                userName:name,
                userPassword:password
            },
            dataType:'json',*/
            success:function (res) {
                console.log(res);
            }
        })
    };



