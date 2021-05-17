<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/checkbox.css">
    <link rel="stylesheet" href="/css/wrapper.css">
    <script src="/js/changeState.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
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
                <span id="task${task?index}">Description: ${task.description}</span>
            </label>
            <button type="button" class="btn btn-danger btn-block">Delete</button>
            <button type="button" class="btn btn-success btn-block">Success</button>
          </li>
        </ul>
        </div>
        </#list>
      </div>
    </body>
</html>