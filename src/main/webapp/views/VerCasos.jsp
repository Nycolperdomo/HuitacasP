<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">

    <h1>Casos PDF</h1>


    <table class="table table-bordered table-hover" id="dataTable">

        <tr>
            <th>Id</th>
            <!--<th>Descripcion</th>
            <th>Acciones</th>-->
            <th>Documento Caso</th>
        </tr>
        <!-- el member esta request.setAttribute("member", inte);para recibir datos (controller) -->
        <c:forEach items="${caso}" var="p">
            <tr>
                <td>${p.getIDmicaso()}</td>
                <!--TD{p.getDescripcion()}-->
                <Td><!--aqui deberia ir el documento--></Td>

                <!--<td>
                <a class="btn btn-warning" href="MisCasosController?accion=ver&id=pesosss{p.getIDmicaso()}" role="button">Editar</a>
                </td>-->
            </tr>
        </c:forEach>

    </table>

</div>


<!-- datatable  -->

<script>


    var myTable = document.querySelector("#dataTable");
    <!--inicializar el objeto datatable que tiene js -->
    var dataTable = new DataTable("#dataTable", {
        perPage:5,
        labels: {
            placeholder: "Buscar...",
            perPage: "{select} Registros por página",
            noRows: "No se encontraron registros",
            info: "Mostrando {start} al {end} de {rows} registros",
        }

    });

</script>

<%@include file="footer.jsp" %>
