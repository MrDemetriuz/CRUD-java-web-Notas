/**
 *Validação de formulario
 @author kléberson, dimitri e vinnicius 
 */

 function validar() {
	let nome = frmRegistro.titulo.value
	let data = frmRegistro.data.value
	if(nome===""){
		alert ("preencha o título do registro ")
		frmRegistro.titulo.focus()
		return false
	}else if(data===""){
		alert ("preencha a data de hoje")
				frmRegistro.data.focus()
				return false
	}else{
		document.forms["frmRegistro"].submit()
	}
 }