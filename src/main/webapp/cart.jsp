<%@ page import="java.util.*" %>
<%@ page import="main.java.model.CartItem" %>

<%
ArrayList<CartItem> cart =
(ArrayList<CartItem>)
session.getAttribute("cart");
%>

<table border="1">

<tr>
<th>Food</th>
<th>Qty</th>
<th>Total</th>
</tr>

<%
for(CartItem c : cart)
{
%>

<tr>
<td><%=c.getFoodName()%></td>
<td><%=c.getQuantity()%></td>
<td><%=c.getTotal()%></td>
</tr>

<%
}
%>

</table>

<form action="placeorder"
method="post">

<input type="submit"
value="Place Order">

</form>
