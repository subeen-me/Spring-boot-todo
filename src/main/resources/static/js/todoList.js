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

function todoEdit() {
    let todo_id = $('#id').val()
    console.log(todo_id);

    let form = {
        title: $('#title').val(),
        name: $('#name').val()
    };

    console.log("edit 실행");

    $.ajax({
        type: "put",
        url: `/todo/`+todo_id+`/edit`,
        data: JSON.stringify(form),
        contentType: "application/json; charset=utf-8"
    }).done(res => {
        console.log("수정 성공", res);
        location.reload();
    }).fail(error => {
        console.log("수정 실패", error);
    });


}

function editModal(todo) {
    console.log("수정 실행");

    let todo_id = $(todo).data("id")
    let todo_title = $(todo).data("title");
    let todo_name = $(todo).data("name");

    console.log(todo_title);
    console.log(todo_name);

    $("#id").val(todo_id);
    $("#title").val(todo_title);
    $("#name").val(todo_name);

  //  $('textarea[name=title]').attr('value',todo_title);
  //  $('input[name=name]').attr('value',todo_name);

}
