$(document).ready(function(){
    $('#btn').click(function(){
        const query = $('#query').val();
        $.ajax({
            type:"GET",
            url:'http://localhost:8080/api?',
            data:{'query': query},
            contentType: 'text; charset=utf-8',
            success:function(data){
                $('#text1').html(data.title)
                $('#text2').html(data.category)
                $('#text3').html(data.address)
                $('#text4').html(data.roadAddress)
                $('#text5').html(data.homepageLink)
                $('#text6').attr('src',data.imageLink)
            },
            error : function(error){
                alert("제대로 된 값이 넘어오지 않습니다");
            }
        });
    });

    $('#save-btn').click(function(){
        alert($('#text6').attr('src'));
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api",
            data: JSON.stringify({
                'title':$('#text1').html(),
                'category':$('#text2').html(),
                'address':$('#text3').html(),
                'roadAddress':$('#text4').html(),
                'homepageLink':$('#text5').html(),
                'imageLink':$('#text6').attr('src')
            }),
            contentType: 'application/JSON; charset=utf-8',
            success:function (){
                alert("성공")
            },
            error : function (){
                alert('저장실패')
            }
        })
    })

})
// $.ajax({
//     type:"POST",
//     url:'http://localhost:8080/query=${query}',
//     data:JSON.stringify({"test":"test"}),
//     dataType:"json",
//     contentType: 'application/json; charset=utf-8',
//     success:function(data){
//         alert(data)
//     },
//     error : function(error){
//         alert(error);
//     }
// });
