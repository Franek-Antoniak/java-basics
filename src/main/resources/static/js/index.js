var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.4.1.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

function changeState(state, uuid) {
    let taskUpdate = {
        "uniqueId": $("#" + uuid).html(),
        "done": $("#" + state).is(':checked')
    };

    $.ajax({
        type: "PATCH",
        url: "/api/task/update",
        data: JSON.stringify(taskUpdate),
        contentType: 'application/json',
        error: function(xhr, status, err) {
            console.error(xhr, status, err.toString());
        }.bind(this)
    });
}

function sendTask() {
    let taskCreate = {
        "description": $("#serviceNowStr").val(),
    };

    $.ajax({
        type: "POST",
        url: "/api/task/new",
        data: JSON.stringify(taskCreate),
        contentType: 'application/json',
        error: function(xhr, status, err) {
            console.error(xhr, status, err.toString());
        }.bind(this)
    });
}

let taskDelete;

function createDeleteTaskObject(uuid) {
    taskDelete = {
        "uniqueId": $("#" + uuid).html(),
    };
}

function deleteTask() {
    $.ajax({
        type: "DELETE",
        url: "/api/task/delete",
        data: JSON.stringify(taskDelete),
        contentType: 'application/json',
        error: function(xhr, status, err) {
            console.error(xhr, status, err.toString());
        }.bind(this)
    });
}
