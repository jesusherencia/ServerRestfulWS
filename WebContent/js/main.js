// The root URL for the RESTful services
var rootURL = "http://localhost:8080/TestRestfulWS/rest/products";

var currentProduct;

// Retrieve product list when application starts 
findAll();

// Nothing to delete in initial application state
$('#btnDelete').hide();

// Register listeners
$('#btnSearch').click(function() {
	search($('#searchKey').val());
	return false;
});

// Trigger search when pressing 'Return' on search key input field
$('#searchKey').keypress(function(e){
	if(e.which == 13) {
		search($('#searchKey').val());
		e.preventDefault();
		return false;
    }
});

$('#btnAdd').click(function() {
	newProduct();
	return false;
});

$('#btnSave').click(function() {
	if ($('#productId').val() == '')
		addProduct();
	else
		updateProduct();
	return false;
});

$('#btnDelete').click(function() {
	deleteProduct();
	return false;
});

$('#productList a').live('click', function() {
	findById($(this).data('identity'));
});

// Replace broken images with generic product bottle
$("img").error(function(){
  $(this).attr("src", "pics/generic.jpg");

});

function search(searchKey) {
	if (searchKey == '') 
		findAll();
	else
		findByName(searchKey);
}

function newProduct() {
	$('#btnDelete').hide();
	currentProduct = {};
	renderDetails(currentProduct); // Display empty form
}

function findAll() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "xml", // data type of response
		success: renderList
	});
}

function findByName(searchKey) {
	console.log('findByName: ' + searchKey);
	$.ajax({
		type: 'GET',
		url: rootURL + '/search/' + searchKey,
		dataType: "json",
		success: renderList 
	});
}

function findById(id) {
	console.log('findById: ' + id);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + id,
		dataType: "json",
		success: function(data){
			$('#btnDelete').show();
			console.log('findById success: ' + data.name);
			currentProduct = data;
			renderDetails(currentProduct);
		}
	});
}

function addProduct() {
	console.log('addProduct');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Product created successfully');
			$('#btnDelete').show();
			$('#productId').val(data.id);
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addProduct error: ' + textStatus);
		}
	});
}

function updateProduct() {
	console.log('updateProduct');
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#productId').val(),
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('Product updated successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('updateProduct error: ' + textStatus);
		}
	});
}

function deleteProduct() {
	console.log('deleteProduct');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + $('#productId').val(),
		success: function(data, textStatus, jqXHR){
			alert('Product deleted successfully');
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('deleteProduct error');
		}
	});
}

function renderList(data) {
	// JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
	var list = data == null ? [] : (data instanceof Array ? data : [data]);

	$('#productList li').remove();
	$.each(list, function(index, product) {
		$('#productList').append('<li><a href="#" data-identity="' + product.id + '">'+product.name+'</a></li>');
	});
}

function renderDetails(product) {
	$('#productId').val(product.id);
	$('#name').val(product.name);
//	$('#grapes').val(product.grapes);
//	$('#country').val(product.country);
//	$('#region').val(product.region);
//	$('#year').val(product.year);
//	$('#pic').attr('src', 'pics/' + product.picture);
//	$('#description').val(product.description);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	var productId = $('#productId').val();
	return JSON.stringify({
		"id": productId == "" ? null : productId, 
		"name": $('#name').val(), 
//		"grapes": $('#grapes').val(),
//		"country": $('#country').val(),
//		"region": $('#region').val(),
//		"year": $('#year').val(),
//		"picture": currentProduct.picture,
//		"description": $('#description').val()
		});
}
