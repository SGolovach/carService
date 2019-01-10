function checkValue(form, message) {
    var login = form[form.name + ":login"]

    if (login.value() == "") {
        alert(message)
        login.focus();
        return false;
    }

    return true;

}