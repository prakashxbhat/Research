"use strict";

$(document).ready(
		function() {
			$('[data-toggle="tooltip"]').tooltip();
			$('.add-row-btn, .table, .edit-row-btn, .delete-row-btn').on('click', function(event) {				
				event.preventDefault();
				var href = $(this).attr('href');
				$('#deleteConfirmationModal #deleteEntity').attr('href', href);
				$('#deleteConfirmationModal').modal();
			});
		});