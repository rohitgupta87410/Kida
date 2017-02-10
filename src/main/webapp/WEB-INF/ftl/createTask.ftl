<#-- @ftlvariable name="_csrf" type="org.springframework.security.web.csrf.CsrfToken" -->
<#-- @ftlvariable name="form" type="com.espark.adarsh.domain.UserCreateForm" -->
<#import "/spring.ftl" as spring>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <title>Create a new user</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<div class="container">
    <div class="jumbotron">
        <center>   <h3>ISSUE CREATION FORM</h3></center>
    </div>
    <form role="form" name="form" action="" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <label for="issue_name">Issue Name</label>
            <input type="issue_name" class="form-control" name="issue_name" id="issue_name" value="test"
                   required autofocus placeholder="Issue Name"/>
        </div>
        <div>
            <label for="issue_status">Issue Status</label>
            <input type="issue_status" name="issue_status" id="issue_status" value="test" placeholder="Issue Status"/>
        </div>
        <div>
            <label for="issue_report_date">Report Date</label>
            <input type="issue_report_date" name="issue_report_date" id="issue_report_date"  value="test" required placeholder="Report Date"/>
        </div>
        <div>
            <label for="issue_update_date">Update Date</label>
            <input type="issue_update_date" name="issue_update_date" id="issue_update_date"  value="test" required
                   autofocus placeholder="Update Date"/>
        </div>

        <div>
            <label for="issue_heading">Heading</label>
            <input type="issue_heading"  name="issue_heading" id="issue_heading" value="test"
                   required  placeholder="issue heading"/>
        </div>
        <div>
            <label for="issue_description">Description</label>
            <input type="issue_description"  name="issue_description" id="issue_description" value="test" required autofocus placeholder="Description"/>
        </div>
        <div>
            <label for="issue_linked_with">Linked Issue</label>
            <input type="issue_linked_with" name="issue_linked_with" id="issue_linked_with" value="test" required autofocus placeholder="Linked Issue"/>
        </div>
		<div>
            <label for="issue_comments">Comments</label>
            <input type="issue_comments"  name="issue_comments" id="issue_comments" value="test"
                   required  placeholder="issue Comments"/>
        </div>
        <div>
            <label for="issue_others">Other details</label>
            <input type="issue_others"  name="issue_others" id="issue_others" value="test"
                   required  placeholder="Other Details"/>
        </div>
        <div>
            <label for="issue_closed">Issue Close date</label>
            <input type="issue_closed"  name="issue_closed" id="issue_closed" value="test"
                   required  placeholder="issue Closed date"/>
        </div>
        <div>
            <label for="issue_type">Issue Type</label>
            <input type="issue_type"  name="issue_type" id="issue_type" value="test"
                   required  placeholder="Issue Type"/>
        </div>

        <button type="submit">Save</button>
    </form>
</div>
<@spring.bind "form" />
<#if spring.status.error>
<ul>
    <#list spring.status.errorMessages as error>
        <li>${error}</li>
    </#list>
</ul>
</#if>

</body>
</html>