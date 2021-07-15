<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>

<body>
<c:choose>
    <c:when test="${cars != null && !cars.isEmpty()}">
        <table class="table table-hover">
            <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Price</th>
            </tr>
            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>${car.brand}</td>
                    <td>${car.model}</td>
                    <td>${car.price}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <form action="/local/" method="post">
            <input type="hidden" name="reload" value="true">
            <input type="text" name="cars" class="form-control" placeholder="enter text">
              <input class="form-check-input" type="checkbox" value="" name="flexCheckDefault">
              <label class="form-check-label" for="flexCheckDefault">
                Default checkbox
              </label>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" value="flexRadioDefault1">
                <label class="form-check-label" for="flexRadioDefault1">
                  Default radio
                </label>
              </div>
              <div class="form-check">
                <input class="form-check-input" type="radio" name="flexRadioDefault" value="flexRadioDefault2" checked>
                <label class="form-check-label" for="flexRadioDefault2">
                  Default checked radio
                </label>
              </div>
            <button type="submit" class="btn btn-outline-dark">Reload</button>
        </form>
    </c:otherwise>
</c:choose>

<a href="/local?reload">Reload</a>

</body>
</html>