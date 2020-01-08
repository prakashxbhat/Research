"use strict";

$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();
    $('.save-row-btn,.edit-row-btn,.delete-row-btn,.move-up,.move-down,.move-top,.move-bottom').click (function(){
        var row = $(this).parents("tr:first");
        if ($(this).is(".move-up")) {
            var rowSelf = parseInt(row.find("td").eq(0).html());
            var rowPrev = parseInt(row.prev().find("td").eq(0).html());
            if(isNaN(rowPrev)){
                rowPrev = rowSelf;
            }
            changeOrder(rowPrev, rowSelf);
            row.insertBefore(row.prev());

        } else if ($(this).is(".move-down")) {
            var rowSelf = parseInt(row.find("td").eq(0).html());
            var rowNext = parseInt(row.next().find("td").eq(0).html());
            if(isNaN(rowNext)){
                rowNext = rowSelf;
            }
            changeOrder(rowSelf, rowNext);
            row.insertAfter(row.next());
        } else if ($(this).is(".move-top")) {
            row.insertBefore($("table tr:first"));
        }else if ($(this).is(".move-bottom")){
            row.insertAfter($("table tr:last"));
        }
    });
});

function changeOrder(var1, var2){
    $.ajax({
        type: "post",
        url: "/changeOrder",
        data:{
            id1: var1,
            id2: var2,
        },
        dataType: "json"
    })
}