<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="action?command=login">
                    <fmt:message key="msg.navbar.login"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="action?command=signup">
                    <fmt:message key="msg.navbar.signup"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="action?command=signup">
                    <fmt:message key="msg.navbar.login"/>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">
                    <fmt:message key="msg.navbar.userName"/>:${userName}
                </a>
            </li>
            <%@include file="changeLocale.jsp"%>
        </ul>
    </div>
</nav>
