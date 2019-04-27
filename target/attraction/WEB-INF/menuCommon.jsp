<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div th:fragment="ManagerCommon">
    <input type="hidden" value="${aimPath}" id="aimPath" />
    <!-- Navbar-->
    <header class="app-header"><a class="app-header__logo" href="/menu"><h4>互联网产业集群反馈系统</h4></a>
        <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="/back/#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>
        <!-- Navbar Right Menu-->
        <ul class="app-nav">

            <%--<li class="app-search">--%>
                <%--<input class="app-search__input" type="search" placeholder="Search">--%>
                <%--<button class="app-search__button"><i class="fa fa-search"></i></button>--%>
            <%--</li>--%>
            <!--Notification Menu-->
            <%--<li class="dropdown"><a class="app-nav__item" href="/back/#" data-toggle="dropdown" aria-label="Show notifications"><i class="fa fa-bell-o fa-lg"></i></a>--%>
                <%--<ul class="app-notification dropdown-menu dropdown-menu-right">--%>
                    <%--<li class="app-notification__title">You have 4 new notifications.</li>--%>
                    <%--<div class="app-notification__content">--%>
                        <%--<li><a class="app-notification__item" href="javascript:;"><span class="app-notification__icon"><span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-primary"></i><i class="fa fa-envelope fa-stack-1x fa-inverse"></i></span></span>--%>
                            <%--<div>--%>
                                <%--<p class="app-notification__message">Lisa sent you a mail</p>--%>
                                <%--<p class="app-notification__meta">2 min ago</p>--%>
                            <%--</div></a></li>--%>
                        <%--<li><a class="app-notification__item" href="javascript:;"><span class="app-notification__icon"><span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-danger"></i><i class="fa fa-hdd-o fa-stack-1x fa-inverse"></i></span></span>--%>
                            <%--<div>--%>
                                <%--<p class="app-notification__message">Mail server not working</p>--%>
                                <%--<p class="app-notification__meta">5 min ago</p>--%>
                            <%--</div></a></li>--%>
                        <%--<li><a class="app-notification__item" href="javascript:;"><span class="app-notification__icon"><span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-success"></i><i class="fa fa-money fa-stack-1x fa-inverse"></i></span></span>--%>
                            <%--<div>--%>
                                <%--<p class="app-notification__message">Transaction complete</p>--%>
                                <%--<p class="app-notification__meta">2 days ago</p>--%>
                            <%--</div></a></li>--%>
                        <%--<div class="app-notification__content">--%>
                            <%--<li><a class="app-notification__item" href="javascript:;"><span class="app-notification__icon"><span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-primary"></i><i class="fa fa-envelope fa-stack-1x fa-inverse"></i></span></span>--%>
                                <%--<div>--%>
                                    <%--<p class="app-notification__message">Lisa sent you a mail</p>--%>
                                    <%--<p class="app-notification__meta">2 min ago</p>--%>
                                <%--</div></a></li>--%>
                            <%--<li><a class="app-notification__item" href="javascript:;"><span class="app-notification__icon"><span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-danger"></i><i class="fa fa-hdd-o fa-stack-1x fa-inverse"></i></span></span>--%>
                                <%--<div>--%>
                                    <%--<p class="app-notification__message">Mail server not working</p>--%>
                                    <%--<p class="app-notification__meta">5 min ago</p>--%>
                                <%--</div></a></li>--%>
                            <%--<li><a class="app-notification__item" href="javascript:;"><span class="app-notification__icon"><span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-success"></i><i class="fa fa-money fa-stack-1x fa-inverse"></i></span></span>--%>
                                <%--<div>--%>
                                    <%--<p class="app-notification__message">Transaction complete</p>--%>
                                    <%--<p class="app-notification__meta">2 days ago</p>--%>
                                <%--</div></a></li>--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<li class="app-notification__footer"><a href="/back/#">See all notifications.</a></li>--%>
                <%--</ul>--%>
            <%--</li>--%>


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
                    <li><a class="treeview-item userList" href="/user/userList"><i class="icon fa fa-circle-o"></i> 已有用户</a></li>
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
            <li class="treeview deptTree"><a class="app-menu__item" href="/back/#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">部门管理</span><i class="treeview-indicator fa fa-angle-right"></i></a>
                <ul class="treeview-menu">
                    <li><a class="treeview-item deptList" href="/dept/deptList"><i class="icon fa fa-circle-o"></i> 部门列表</a></li>
                    <%--<li><a class="treeview-item" href="/error/noPower"><i class="icon fa fa-circle-o"></i> 部门操作</a></li>--%>
                </ul>
            </li>
            <li class="treeview bugTree"><a class="app-menu__item" href="/back/#" data-toggle="treeview"><i class="app-menu__icon fa fa-th-list"></i><span class="app-menu__label">反馈问题</span><i class="treeview-indicator fa fa-angle-right"></i></a>
                <ul class="treeview-menu">
                    <li><a class="treeview-item newBug" href="/feedback/newBug"><i class="icon fa fa-circle-o"></i> 反馈新问题</a></li>
                    <li><a class="treeview-item bugList" href="/feedback/bugList"><i class="icon fa fa-circle-o"></i> 查询已提交问题</a></li>
                </ul>
            </li>
        </ul>
    </aside>

</div>
