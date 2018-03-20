$(function() {

	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'All Products':
		$('#listproducts').addClass('active');
		break;

	case 'Home':
		$('#home').addClass('active');
		break;

	default:
		$('#listproducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;

	}

	// code for jquery datatable
	// create a dataset
	var products = [ 
		[ '1', 'ABC' ],
		[ '2', 'ABC' ],
		[ '3', 'ABC' ],
		[ '4', 'ABC' ],
		[ '5', 'ABC' ],
		[ '6', 'ABC' ]
		];

	var $table = $('#productListTable');

	// execute the below code only where we have this table

	if ($table.length) {
		//console.log('Inside the table');
		$table.DataTable(
				{
					lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','ALL']],
					pageLength: 5,
				data:products
				}
				);
	}
});