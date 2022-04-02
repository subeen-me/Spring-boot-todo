function stateUpdate(id) {
    console.log("실행");
    console.log(id);

    $.ajax({
        type: "post",
        url: `/todo/${id}/update`,
        contentType: "application/x-www-form-urlencoded; charset=utf-8"
    }).done(res=>{
        console.log("상태 변경 성공", res);
        location.reload();
    }).fail(error=>{
        console.log("상태 변경 실패", error);
    });
}