<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="action?command=service">
                    <fmt:message key="msg.navbar.service"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="action?command=comment">
                    <fmt:message key="msg.navbar.comment"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="action?command=writecomment">
                    <fmt:message key="msg.navbar.createcomment"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">
                    <fmt:message key="msg.navbar.userName"/>:${userName}
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="action?command=logout">
                    <fmt:message key="msg.navbar.logOut"/>
                </a>
            </li>
            <%@include file="changeLocale.jsp"%>
        </ul>
    </div>
</nav>
