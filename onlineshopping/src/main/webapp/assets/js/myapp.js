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
		
	case 'Manage Products':
		$('#manageProducts').addClass('active');
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

	var $table = $('#productListTable');

	// execute the below code only where we have this table
	$(document).ready(function() {
		$('#productListTable').DataTable();
	});
	if ($table.length) {
		// console.log('Inside the table');
		// create a dataset
		// var products = [
		// [ '1', 'ABC' ],
		// [ '2', 'ABC' ],
		// [ '3', 'ABC' ],
		// [ '4', 'ABC' ],
		// [ '5', 'ABC' ],
		// [ '6', 'ABC' ]
		// ];

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {

			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}

		// table.DataTable(
		// {
		// lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10
		// Records','ALL']],
		// pageLength: 5,
		// data:products
		// }
		// );
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			pageLength : 5,
			processing: true,
			ServerSide: true,
			ajax : {
				"url" : jsonUrl,
				"dataSrc" : ''
			},
			"columns" : [
				    {
					  data: 'code',
					  mRender: function(data, type, row){

					    return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class = "dataTableImg"/>'

					}

					},
				
				
				{
				data : 'name'
			},

			{
				data : 'brand'
			},

			{
				data : 'unitPrice',
					mRender: function(data, type, row){
						return 'Rs. ' + data

						}
			},

			{
				data : 'quantity',
				mRender: function(data, type, row){
				if(data<1){
					return '<span style="color:red">Out of Stock!</span>';
					}
					return data;
				}
			},
			
			{
				   data: 'id',
				   bSortable: false,
				  mRender: function(data, type, row){
				 
				    var str = '';
				    str +='<a href="'+window.contextRoot+ '/show/'+data+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';
				    if(row.quantity<1){
				    	str+= '<a href="javascrip:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
				    	}
				    	else{
				    		str +='<a href="'+window.contextRoot+ '/cart/add/'+data+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';
				    	}		    
				    

				    return str;

				}

				}

			]
		});
	}
	// dismissing alert after 3 sec
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function(){
			$alert.fadeOut('slow')

			},3000
			)
	}
	
	$(document).ready(function() {
		$('#productListTable').DataTable();
	});
	
	$('.switch input[type="checkbox"]').on('change',function(){
		var checkbox=$(this);
		var checked=checkbox.prop('checked');
		var dMsg=(checked)? 'You want to activate the product?':
		'You want to deactivate the product?';
		var value=checkbox.prop('value');
		bootbox.confirm({
		size:'medium',
		title:'Product Activation & Deactivation',
		message:dMsg,
		callback:function(confirmed){
		if(confirmed){
		console.log(value);
		bootbox.alert({
		size='medium',
		title:'Information',
		message:'You are going to perform operation on product' + value
		})
		}
		else{
		checkbox.prop('checked',!checked)
		}
		}
		});
		});
});