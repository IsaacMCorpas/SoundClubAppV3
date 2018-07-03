(function () {
    let sugerencias_div = document.getElementById('sugerencias');
    document.getElementById('txtbusqueda').addEventListener('keyup', function (evnt) {
        console.log("Valor del Buscador::",this.value);
       
        let plantillaLista = '';
        if (this.value!="") {
        	//cargar_usuarios(this.value);
        	 let resultadosBusqueda ;
        	let user=this.value;
        	 $.ajax({
        		    url: `./buscador?user=${user}`,
        		    type: "POST",
        			accepts: "application/json"
        		  }).done(function (data) {
        			  if(data){
        				  let resultadosBusqueda=data;
        				  let sugerencias_div = document.getElementById('sugerencias');
        				  let plantillaLista = '';	
        				  //sugerencias_div.innerHTML = this.value;
        				  plantillaLista = ' <ul class="collection">';
        				  console.log("Entro aqui",resultadosBusqueda);
        				  for (let index = 0; index < resultadosBusqueda.length; index++) {
        					  plantillaLista += '<li class="collection-item avatar"><a href="./musuario?id='+resultadosBusqueda[index].id+'"><img src="'+ resultadosBusqueda[index].foto +'" alt="" class="circle"><span class="title">'+ resultadosBusqueda[index].nombre +'  '+resultadosBusqueda[index].apellidos+'</span></a></li>';
        				  }
        				  plantillaLista += '<ul>';        			  
        				  sugerencias_div.innerHTML = plantillaLista;
        			  }
        			 
        }).fail(function (err) {
        		      console.log("Error!!:", err);

        });
        }
        else { }
        sugerencias_div.innerHTML = plantillaLista;


    });

}
)();
