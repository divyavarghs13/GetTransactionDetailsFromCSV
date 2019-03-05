$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/welcome"
    }).then(function(data, status, jqxhr) {
       $('.transaction-id').append(data.id);
       $('.transaction-date').append(data.content);
       console.log(jqxhr);
    });
});