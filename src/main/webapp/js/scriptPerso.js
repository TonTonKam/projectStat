jQuery(document).ready(function() {
    let selecteur = document.getElementById("categorie");

    $("#newCate").attr("class", "hidden");

    selecteur.addEventListener("mouseout", function(){
        
        let idx = selecteur.selectedIndex;
        let content = selecteur.options[idx].innerHTML;
        
        if(content == "personnaliser"){
            $("#newCate").removeClass("hidden");
        }else{
            $("#newCate").attr("class", "hidden");
        }

    });


}); //fin scriptPerso