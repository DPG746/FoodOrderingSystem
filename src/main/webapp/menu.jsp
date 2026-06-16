<h2>Welcome
<%=session.getAttribute("username")%>
</h2>

<form action="addcart" method="post">

Food:
<select name="food">
<option>Pizza</option>
<option>Burger</option>
<option>Sandwich</option>
</select>

Quantity:
<input type="number" name="qty">

Price:
<input type="text" name="price">

<input type="submit"
value="Add To Cart">

</form>

<a href="cart.jsp">
View Cart
</a>