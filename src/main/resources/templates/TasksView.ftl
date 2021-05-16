<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<meta charset="utf-8">
	<title> Tasks View </title>
</head>
    <body>
      <div id="wrapper" style="display:grid; grid-tempalte-columns: minmax(1fr, 50px); justify-content: center;">
        <#list listOfTasks as task>
        <div class="id border border-primary+">
                    <span > UUID: ${task.uniqueId} </span>
                    <br>
                    <span  id="task">Description: ${task.description}</span>
                    <span class="state_of_work">
                    <br>
                    State of work:
                    <#if task.done == false>"To do"
                    <#else>"Done"
                    </#if>
                    </span>
        </div>

        <br>
        </#list>
      </div>
    </body>
</html>