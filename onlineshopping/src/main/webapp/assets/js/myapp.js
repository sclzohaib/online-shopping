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
	$('#a_'+menu).addClass('active');
		break;

	}

});