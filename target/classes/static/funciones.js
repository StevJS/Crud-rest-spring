function eliminar(id){
	swal({
  title: "Está seguro de Eliminar?",
  text: "Una vez eliminado, no podrá recuperar este archivo!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
		$.ajax({
			url:"/eliminar/"+id,
			succes: function(res){
				console.log(res);
			}
		})
    swal("Su archivo se ha eliminado!", {
      icon: "success",
    }).then((ok)=>{
		if(ok){
			location.href="/listar";
		}
});
  } else {
    swal("Tu archivo está seguro!");
  }
});
}