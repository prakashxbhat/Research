"use strict";

$(document).ready(function(){
	$('[data-toggle="tooltip"]').tooltip();
    $('.save-row-btn,.edit-row-btn,.delete-row-btn,.move-up,.move-down,.move-top,.move-bottom').click (function(){
        var row = $(this).parents("tr:first");
        if ($(this).is(".move-up")) {
            row.insertBefore(row.prev());
        } else if ($(this).is(".move-down")) {
            row.insertAfter(row.next());
        } else if ($(this).is(".move-top")) {
            row.insertBefore($("table tr:first"));
        }else if ($(this).is(".move-bottom")){
            row.insertAfter($("table tr:last"));
        }
    });
});