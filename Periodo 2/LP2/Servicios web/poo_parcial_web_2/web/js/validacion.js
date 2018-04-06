/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

document.getElementById("btnModificar").onclick = function(){
                
    // Obtenemos los valores
    var txtNuevoTitulo = document.getElementById("txtTitulo");
    var txtNuevaCantidad = document.getElementById("txtCantidad");

    var estado = true;

    var errorTitulo = document.getElementById("errorTitulo");
    var errorCantidad = document.getElementById("errorCantidad");

    if (!Number.isNaN(txtNuevaCantidad.value.toString().trim())) {
        if(txtNuevaCantidad.value <= 0){
            estado = false;
            errorCantidad.classList.remove('d-none');
            errorCantidad.innerHTML = "Error: la cantidad debe de ser mayor que 0";
        } else {
            errorCantidad.classList.add('d-none');
        }
    } else{
        estado = false;
        errorCantidad.classList.remove('d-none');
        errorCantidad.innerHTML = "Error: la cantidad debe de ser numerico";
    }

    if(txtNuevoTitulo.value.toString().trim() == "") {
        estado = false;
        errorTitulo.classList.remove('d-none');
        errorTitulo.innerHTML = "Error: el titulo es un campo obligatorio";
    } else
        errorTitulo.classList.add('d-none');

    if(!estado)
        return false;
}
