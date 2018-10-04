   
   
    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/jquery/jquery.min.js"></script>
    <script src="https://blackrockdigital.github.io/startbootstrap-shop-item/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


	<script>
		function reproducir(id) {
			
			console.info('reproducir video ' + id);
			var iframe = document.getElementById('iframe');
			iframe.src = "https://www.youtube.com/embed/" + id;
			
		}	
		
		function showModalModificar(idVideo, nombre, id ){
			
			console.log('showModalModificar idVideo=' + idVideo +  " nombre=" + nombre + " id=" + id);
			$('#modalModificar').modal('show');
			document.getElementById('idVideo').value = idVideo;
			document.getElementById('nombre').value = nombre;
			document.getElementById('id').value = id;
						
		}
	
	</script>

  </body>

</html>
