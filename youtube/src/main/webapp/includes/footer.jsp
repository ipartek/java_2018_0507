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
		
		function showModalModificar( idVideo, nombre ){
			
			console.log('showModalModificar id=' + idVideo +  " nombre=" + nombre);
			$('#modalModificar').modal('show');
			document.getElementById('id').value = idVideo;
			document.getElementById('nombre').value = nombre;
						
		}
	
	</script>

  </body>

</html>
