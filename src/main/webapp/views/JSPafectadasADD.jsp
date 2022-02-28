<%@include file="header.jsp"%>
<div class="flex-fill flex-grow-1 ms-3">

    <h1>Registrar Afectada</h1>

    <form method="post" action="AfectadaController?accion=add2">

        <!-- ESTOS DATOS SE MIRAN EN LA BD  -->


        <div class="form-group">
            <label for="nombre">Nombre</label>
            <input class="form-control" type="text" name="nombre" placeholder="Ingrese su nombre" required>
        </div>
        <div class="form-group">
            <label for="apellido">Apellido</label>
            <input class="form-control" type="text" name="apellido" placeholder="Ingrese su Apellido" required>
        </div>
        <div class="form-group">
            <label for="correo">Correo</label>
            <input class="form-control" type="email" name="correo" placeholder="Ingrese su Correo" onchange="verifyCorreo()" required>
        </div>
        <div id="validarC" class="text-danger"></div>
        <div class="form-group">
            <label for="contrasena">Contraseña</label>
            <input class="form-control" type="password" name="contrasena" placeholder="Ingrese su contraseña " required>
        </div>
        <div class="form-group">
            <label for="numeroDocumento">Numero de Documento</label>
            <input class="form-control" type="number" name="numeroDocumento" placeholder="Ingrese su Numero De Documento " required>
        </div>
        <div class="form-group">
            <label for="fechaNa">Fecha Nacimiento</label>
            <input class="form-control" type="date" name="fechaNa" placeholder="Ingrese su Fecha Nacimiento " required>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
            <label class="form-check-label" for="flexCheckChecked">
                Activo
            </label>
        </div>
        <div class="form-group">
            <label for="cargo">Cargo</label>
            <!-- SELECT INDISPENSABLE EL NAME -->
            <select id="cargo" name="cargo" class="form-select">
                <option selected>Rol</option>
                <option value="Cliente">Cliente</option>
            </select>
        </div>

        <!--<div class="form-group">
            <label for="direccion">Direccion</label> <input class="form-control" type="text" name="direccion" placeholder="Ingrese su Direccion">
        </div>-->

        <!--  <div class="form-group">
            <label for="password">Contrase�a</label>
            <input class="form-control" type="password" name="password" placeholder="Ingrese su Contrase�a">
        </div>

        ESTE ES UN EJEMPLO DONDE SE TRAEN DATOS DE ROL (DATOS RELACIONADOS)
        <div class="form-group">
            <label for="carpro">Cargo Profesional</label>
             <select class="form-select" name="carpro">
                <option>Seleccione el cargo del profesional</option>
        </div> -->



        <!-- Remind Passowrd -->

        <div>

            <br>
            <button type="submit" class="btn btn-primary">Guardar</button>
        </div>


    </form>

</div>
<!-- LIBRERIA JQUERY -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
    function verifyCorreo(){
        const correo=document.getElementById("correo").value;

        $.ajax({
            url:"AfectadaController?accion=validarCorreo",
            data:{
                correo:correo
            },
            success: function(result){
                $("#validarC").html(result);
            }
        })
    }

</script>

<%@include file="footer.jsp"%>

