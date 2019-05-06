<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div th:fragment="ManagerCommon">
    <input type="hidden" value="${aimPath}" id="aimPath" />
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="/menu"><h4>畅游管理系统</h4></a>
        <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="/back/#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
        <!-- Navbar Right Menu-->
        <ul class="app-nav">
            <!-- User Menu-->
            <li class="dropdown"><a class="app-nav__item" href="/back/#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
                <ul class="dropdown-menu settings-menu dropdown-menu-right">
                    <li><a class="dropdown-item" href="logout"><i class="fa fa-sign-out fa-lg"></i> 注销</a></li>
                </ul>
            </li>
        </ul>
    </header>
    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
        <div class="app-sidebar__user">
            <%--<img class="app-sidebar__user-avatar" alt="" style="width:50px; height: 50px;">--%>
            <div>
                <p class="app-sidebar__user-name"></p>
                <p class="app-sidebar__user-designation"></p>
            </div>
        </div>
        <ul class="app-menu">
            <li class="treeview userTree"><a class="app-menu__item" href="/back/#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">用户管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>
                <ul class="treeview-menu">
                    <li><a class="treeview-item userList" href="/admin/user/userList"><i class="icon fa fa-circle-o"></i> 后台用户管理</a></li>
                </ul>
            </li>
            <%--<li class="treeview"><a class="app-menu__item" href="/back/#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">角色管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>--%>
                <%--<ul class="treeview-menu">--%>
                    <%--<li><a class="treeview-item" href="/error/noPower"><i class="icon fa fa-circle-o"></i> 角色列表</a></li>--%>
                    <%--&lt;%&ndash;<li><a class="treeview-item" href="/error/noPower"><i class="icon fa fa-circle-o"></i> 角色子节点</a></li>&ndash;%&gt;--%>
                <%--</ul>--%>
            <%--</li>--%>
            <%--<li class="treeview"><a class="app-menu__item" href="/back/#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">菜单管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>--%>
                <%--<ul class="treeview-menu">--%>
                    <%--<li><a class="treeview-item" href="/error/noPower"><i class="icon fa fa-circle-o"></i> 菜单列表</a></li>--%>
                    <%--<li><a class="treeview-item" href="/error/noPower"><i class="icon fa fa-circle-o"></i> 菜单管理</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>
            <li class="treeview attractionTree"><a class="app-menu__item" href="/back/#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">景点管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>
                <ul class="treeview-menu">
                    <li><a class="treeview-item attractionList" href="/admin/attraction/listPage"><i class="icon fa fa-circle-o"></i> 景点列表</a></li>
                    <%--<li><a class="treeview-item attractionDetail" href="/error/noPower"><i class="icon fa fa-circle-o"></i> 部门操作</a></li>--%>
                </ul>
            </li>
        </ul>
    </aside>

</div>
