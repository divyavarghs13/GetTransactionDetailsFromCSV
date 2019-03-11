$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/welcome"
            type: "GET",
            contentType: "application/json",
            dataType: 'json',
    }).then(function(data) {
    	console.log("SUCCESS : ", data);
       $('.transactionID').append(data.transactionID);
       $('.transactionDate').append(data.transactionDate);
       $('.amount').append(data.amount);
       $('.description').append(data.description);
       $('.startDate').append(data.startDate);
       $('.endDate').append(data.endDate);
       $('.fileName').append(data.fileName);
    });
});