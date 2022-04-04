function stateUpdate(id) {
    console.log("실행");
    console.log(id);

    $.ajax({
        type: "post",
        url: `/todo/${id}/update`,
        contentType: "application/x-www-form-urlencoded; charset=utf-8"
    }).done(res => {
        console.log("상태 변경 성공", res);
        location.reload();
    }).fail(error => {
        console.log("상태 변경 실패", error);
    });
}

function todoDelete(id) {
    console.log("삭제 실행");
    let ans = confirm("이 todo를 삭제하시겠습니까?")
    if (ans) {
        $.ajax({
            type: "delete",
            url: `/todo/${id}/delete`,
            contentType: "application/x-www-form-urlencoded; charset=utf-8"
        }).done(res => {
            console.log("삭제 성공", res);
            location.reload();
        }).fail(error => {
            console.log("삭제 실패", error);

        });
    }
}

function todoEdit(id) {
    // let editModal = document.getElementById('editModal')
    // let todoTitle = editModal.querySelector('#title')
    // let todoName = editModal.querySelector('#name')

    let data = {
        title: $('#title').val(),
        name: $('name').val()
    };
    console.log("edit 실행");

    $.ajax({
        type: "put",
        url: `/todo/${id}/edit`,
        data: JSON.stringify(data),
        contentType: "application/json; charset=utf-8",
        dataType: "json"
    }).done(res => {
        console.log("수정 성공", res);
        location.href = "/";
    }).fail(error => {
        console.log("수정 실패", error);
    });


}