<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/commons/head.jsp"></jsp:include>

<div class="container">
    <div class="row">
        <div class="col-lg-2">
            <div class="panel panel-primary">
                <div class="panel-heading">待办任务</div>
                <div class="panel-body">
                    <a href="#tasklist">待办任务</a>
                </div>
            </div>
        </div>
        <div class="col-lg-10">
            <!-- 待办任务列表-->
            <div id="tasklist">
                <table class="table table-bordered table-hover">
                    <caption><h3><strong>待办任务</strong></h3></caption>
                    <thead>
                    <tr>
                        <th>任务ID</th>
                        <th>任务名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach var="task" items="${tasks}">
                        <tr>
                            <td>${task.id}</td>
                            <td>${task.name}</td>
                            <td><a href="${path}/simple/form.do?taskId=${task.id}">执行</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</div>
<jsp:include page="/WEB-INF/views/commons/foot.jsp"></jsp:include>