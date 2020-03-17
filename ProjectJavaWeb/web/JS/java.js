// Show/hide password onClick of button using Javascript only

// https://stackoverflow.com/questions/31224651/show-hide-password-onclick-of-button-using-javascript-only

function show() {
    var p = document.getElementById('pwd');
    p.setAttribute('type', 'text');
}

function hide() {
    var p = document.getElementById('pwd');
    p.setAttribute('type', 'password');
}

var pwShown = 0;

document.getElementById("eye").addEventListener("click", function () {
    if (pwShown == 0) {
        pwShown = 1;
        show();
    } else {
        pwShown = 0;
        hide();
    }
}, false);

//VALIDACIONES
//LOGIN
function ValidacionLogin(){
    var user = document.getElementById('username').value;
	var pass = document.getElementById('password').value;
	var alerta='';
	var respuesta;
    	if(user==''){
    		alerta=alerta+' (Nombre)';
    		showErrors=true;
        }
        if(pass==''){
            alerta=alerta+' (Contraseña)';
            showErrors=true;
        }
        if(showErrors){
            document.getElementById('alerta').innerHTML=alerta+' son obligatiorios';
            respuesta=false;
        }else{
            document.getElementById('alerta').innerHTML='';
            respuesta=true;
        }
        alerta='Errores:<br>';
        showErrors=false;
return respuesta;
}
//INSERTAR PRODUCTOS
function ValidacionInsertProd(){
        var nombre = document.getElementById('nombre').value;
        var descripcion = document.getElementById('descripcion').value;
        var descuento = document.getElementById('descuento').value;
        var precio = document.getElementById('precio').value;
        var cantidad = document.getElementById('cantidad').value;
        var stock_max = document.getElementById('stock_max').value;
        var stock_min = document.getElementById('stock_min').value;
         var foto = document.getElementById('foto').value;
	var num_serie = document.getElementById('num_serie').value;
	var alerta='';
	var respuesta;
    	if(nombre==''){
    		alerta=alerta+' (Nombre)';
    		showErrors=true;
            }
        if(descripcion==''){
    		alerta=alerta+' (Descripcion)';
    		showErrors=true;
        }
        if(num_serie==''){
            alerta=alerta+' (Numero de serie)';
            showErrors=true;
        }
        if(descuento==''){
    		alerta=alerta+' (Descuento)';
    		showErrors=true;
        }
        if(precio=='' || precio==0){
    		alerta=alerta+' (Precio)';
    		showErrors=true;
        }
        if(cantidad==''){
    		alerta=alerta+' (Cantidad)';
    		showErrors=true;
        }
        if(stock_max=='' || stock_max==0){
    		alerta=alerta+' (Stock Maximo)';
    		showErrors=true;
        }
        if(stock_min==''){
    		alerta=alerta+' (Stock Minimo)';
    		showErrors=true;
        }
        if(foto==''){
    		alerta=alerta+' (Foto)';
    		showErrors=true;
        }
        if (stock_max<stock_min) {
                alerta=alerta+' (El Stock Maximo no puede ser menor que el mínimo)';
                showErrors=true;
        }
        if(showErrors){
            document.getElementById('alerta').innerHTML=alerta+' son obligatiorios';
            respuesta=false;
        }else{
            document.getElementById('alerta').innerHTML='';
            respuesta=true;
        }
        alerta='Errores:<br>';
        showErrors=false;
return respuesta;
}
//EDITAR PRODUCTOS
function ValidacionEditProd(){
        var nombre = document.getElementById('nombre').value;
        var descripcion = document.getElementById('descripcion').value;
        var descuento = document.getElementById('descuento').value;
        var precio = document.getElementById('precio').value;
        var cantidad = document.getElementById('cantidad').value;
        var stock_max = document.getElementById('stock_max').value;
        var stock_min = document.getElementById('stock_min').value;
         var foto = document.getElementById('foto').value;
	var num_serie = document.getElementById('num_serie').value;
	var alerta='';
	var respuesta;
    	if(nombre==''){
    		alerta=alerta+' (Nombre)';
    		showErrors=true;
            }
        if(descripcion==''){
    		alerta=alerta+' (Descripcion)';
    		showErrors=true;
        }
        if(num_serie==''){
            alerta=alerta+' (Numero de serie)';
            showErrors=true;
        }
        if(descuento==''){
    		alerta=alerta+' (Descuento)';
    		showErrors=true;
        }
        if(precio=='' || precio==0){
    		alerta=alerta+' (Precio)';
    		showErrors=true;
        }
        if(cantidad==''){
    		alerta=alerta+' (Cantidad)';
    		showErrors=true;
        }
        if(stock_max=='' || stock_max==0){
    		alerta=alerta+' (Stock Maximo)';
    		showErrors=true;
        }
        if(stock_min==''){
    		alerta=alerta+' (Stock Minimo)';
    		showErrors=true;
        }
        if (stock_max<stock_min) {
                alerta=alerta+' (El Stock Maximo no puede ser menor que el mínimo)';
                showErrors=true;
        }
        if(showErrors){
            document.getElementById('alerta').innerHTML=alerta+' son obligatiorios';
            respuesta=false;
        }else{
            document.getElementById('alerta').innerHTML='';
            respuesta=true;
        }
        alerta='Errores:<br>';
        showErrors=false;
return respuesta;
}
//INSERTAR USUARIOS
function ValidacionInsertUsu(){
        var nombre = document.getElementById('nombre').value;
        var usuario = document.getElementById('usuario').value;
	var pass = document.getElementById('num_serie').value;
        var pass2 = document.getElementById('pass2').value;
	var alerta='';
	var respuesta;
    	if(nombre==''){
    		alerta=alerta+' (Nombre)';
    		showErrors=true;
        }
        if(usuario==''){
    		alerta=alerta+' (Usuario)';
    		showErrors=true;
        }
        if(pass==''){
            alerta=alerta+' (Contraseña)';
            showErrors=true;
        }
        if(pass2==''){
            alerta=alerta+' (Confirmar Contraseña)';
            showErrors=true;
        }
        if(pass!=pass2){
            alerta=alerta+' (Las contraseñas no coinciden)';
            showErrors=true;
        }
        if(showErrors){
            document.getElementById('alerta').innerHTML=alerta+' son obligatiorios';
            respuesta=false;
        }else{
            document.getElementById('alerta').innerHTML='';
            respuesta=true;
        }
        alerta='Errores:<br>';
        showErrors=false;
return respuesta;
}
//EDITAR USUARIOS
function ValidacionEditUsu(){
        var nombre = document.getElementById('nombre').value;
        var usuario = document.getElementById('usuario').value;
	var pass = document.getElementById('num_serie').value;
        var pass2 = document.getElementById('pass2').value;
	var alerta='';
	var respuesta;
    	if(nombre==''){
    		alerta=alerta+' (Nombre)';
    		showErrors=true;
        }
        if(usuario==''){
    		alerta=alerta+' (Usuario)';
    		showErrors=true;
        }
        if(pass!=pass2){
            alerta=alerta+' (Las contraseñas no coinciden)';
            showErrors=true;
        }
        if(showErrors){
            document.getElementById('alerta').innerHTML=alerta+' son obligatiorios';
            respuesta=false;
        }else{
            document.getElementById('alerta').innerHTML='';
            respuesta=true;
        }
        alerta='Errores:<br>';
        showErrors=false;
return respuesta;
}

