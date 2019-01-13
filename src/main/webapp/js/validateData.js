function checkValue(form, message) {
    var login = form.getElementsByName("login");

    if (login.value.length<=0) {
        alert(message)
        return false;
    }

    return true;

}