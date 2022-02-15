jQuery(document).ready(function() {

	let btnModifCate = document.getElementById('btnModifCate');
	let btnDeleteCate = document.getElementById('btnDeleteCate');
	let inputLibelle = document.getElementById('libelleCommentAdmin');
	
	btnModifCate.addEventListener("click", function(){
		btnModifCate.type = "submit";
	});

	btnDeleteCate.addEventListener("click", function(){
		inputLibelle.disabled = "true";
		btnDeleteCate.type = "submit";
		inputLibelle.disabled = "false";
	});

}); //fin 