"use strict";

$(document).ready(function() {
	$('[data-toggle="tooltip"]').tooltip();
	$('.delete-row-btn').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteConfirmationModal #deleteEntity').attr('href', href);
		$('#deleteConfirmationModal').modal();
	});
});