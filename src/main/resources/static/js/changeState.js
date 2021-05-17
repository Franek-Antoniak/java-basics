var script = document.createElement('script');
script.src = 'https://code.jquery.com/jquery-3.4.1.min.js';
script.type = 'text/javascript';
document.getElementsByTagName('head')[0].appendChild(script);

function changeState(state, uuid) {
    let object = {
        "uniqueId": $("#" + uuid).html(),
        "done": $("#" + state).is(':checked')
    };

    $.ajax({
        type: "PATCH",
        url: "/api/task/update",
        data: JSON.stringify(object),
        contentType: 'application/json',
        error: function(xhr, status, err) {
            console.error(xhr, status, err.toString());
        }.bind(this)
    });
}

function sendTask() {
    let object = {
        "description": $("#serviceNowStr").val(),
    };

    $.ajax({
        type: "POST",
        url: "/api/task/new",
        data: JSON.stringify(object),
        contentType: 'application/json',
        error: function(xhr, status, err) {
            console.error(xhr, status, err.toString());
        }.bind(this)
    });
}
