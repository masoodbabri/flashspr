function populateHiddenField(tag){
	$("#award-star").val(tag);
	$("#star-image").attr("href", tag.toLowerCase() + ".jpg");
}


