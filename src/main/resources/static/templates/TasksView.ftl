<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">    <script src="/js/index.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta charset="utf-8">
    <title> Tasks View </title>
</head>
    <body>
      <div id="wrapper">
        <div class="form-horizontal">
          <div class="form-group">
            <div class="col-xs-10">
              <textarea class="form-control input-sm" rows="3" placeholder="Write your task here!" style="resize: none" ng-model="formData_EventDetails.serviceNowStr" id="serviceNowStr" maxlength="250"></textarea>
            </div>
            <div class="col-xs-2">
              <button class="btn uk-button btn-block btn-secondary" ng-click="openServiceNowPopup(formData_EventDetails)" onclick="sendTask()"> Add </button>
            </div>
          </div>
        </div>
        <#list listOfTasks as task>
        <div class="border border-primary+">
        <ul>
          <li>
            <input type="checkbox" id="cb${task?index}" name="cb${task?index}" <#if task.done>checked<#else>unchecked</#if> onclick="changeState('cb${task?index}', 'uuid${task?index}')">
            <label for="cb${task?index}">
                <span id="uuid${task?index}" style="display:none">${task.uniqueId}</span>
                <span id="task${task?index}">Description: ${task.description} </span>
            </label>
            <div style="display:flex; justify-content: center;">
                <button type="button" class="btn btn-success" style="margin-right: 10px">Complete task</button>
                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalCenter" onclick="createDeleteTaskObject('uuid${task?index}')">Delete</button>
            </div>
          </li>
        </ul>
        </div>
      </#list>
      </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
          <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
                </button>
              </div>
              <div class="modal-body">
                <p> Are u sure u want to permanently remove this task? </p>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-danger" onclick="deleteTask()" data-dismiss="modal">Delete</button>
              </div>
            </div>
          </div>
        </div>
    </body>
</html>
