<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
<form id="actionForm" action="/board/list" method="get">
	<input type="hidden" name="pageNum" value="${!empty param.pageNum? param.pageNum : '1'}" />
			<input type="hidden" name="bno" value="${param.bno }"/>
<%-- 이건왜또빼..?             <input type="hidden" name='action' value="${param.action}"/> --%>
	 <input type='hidden' name='type' value=
	 '<c:out value="${pageCalc.criteria.type }"/>'
	 />
       <input type='hidden' name='keyword' value=
       '<c:out value="${pageCalc.criteria.keyword }"/>'
       />

</form>

    <!-- jQuery 주석처리 -->
<!--     <script src="/resources/vendor/jquery/jquery.min.js"></script> -->

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="/resources/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="/resources/vendor/datatables-responsive/dataTables.responsive.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
  $(document).ready(function() {
    $('#dataTables-example').DataTable({
      responsive: true
    });
    $(".sidebar-nav")
      .attr("class","sidebar-nav navbar-collapse collapse")
      .attr("aria-expanded",'false')
      .attr("style","height:1px");
  });
</script>

</body>

</html>
