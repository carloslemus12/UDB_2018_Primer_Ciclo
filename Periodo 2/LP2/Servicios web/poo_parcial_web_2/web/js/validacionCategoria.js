/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.getElementById("btnAccion").onclick = function(){
    var id = document.getElementById("id");
    var cat = document.getElementById("nombre");

    var estado = true;

    var errorId = document.getElementById("errorId");
    var errorNombre = document.getElementById("errorNombre");

    if (!Number.isNaN(id.value.toString().trim())) {
        if(id.value <= 0){
            estado = false;
            errorId.classList.remove('d-none');
            errorId.innerHTML = "Error: el id debe de ser mayor que 0";
        } else {
            errorId.classList.add('d-none');
        }
    } else{
        estado = false;
        errorId.classList.remove('d-none');
        errorId.innerHTML = "Error: el id debe de ser numerico";
    }

    if(cat.value.toString().trim() == "") {
        estado = false;
        errorNombre.classList.remove('d-none');
        errorNombre.innerHTML = "Error: el nombre es un campo obligatorio";
    } else
        errorNombre.classList.add('d-none');

    if(!estado)
        return false;
}