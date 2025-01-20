// Configuración del Datepicker
$(document).ready(function () {
    $('#datepicker').datepicker({
      format: 'yyyy-mm-dd', // Formato de la fecha
      autoclose: true,       // Cerrar automáticamente al seleccionar
      todayHighlight: true   // Resaltar la fecha actual
    }).on('changeDate', function (e) {
      // Obtener la fecha seleccionada
      const selectedDate = e.format(); // Asegúrate de que esta función esté bien configurada
      $('#selected-date').text(selectedDate); // Actualiza el texto con la fecha seleccionada
    });
  });

// Función para mostrar el trámite seleccionado en tiempo real
function mostrarTramiteSeleccionado() {
    var select = document.getElementById('tipoTramite');
    var selectedValue = select.options[select.selectedIndex].text; // Obtenemos el nombre del trámite seleccionado
    var span = document.getElementById('tramiteSeleccionado'); // Cambié el id a 'tramiteSeleccionado'
    span.textContent = selectedValue; // Actualizamos el texto del span con el nombre del trámite
  }