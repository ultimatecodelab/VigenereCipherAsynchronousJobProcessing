<%@ include file="includes/header.jsp" %>

<div class="animated bounceInDown" style="font-size:48pt; font-family:arial; color:#990000; font-weight:bold">Vigenere Cypher</div>

</p>&nbsp;</p>&nbsp;</p>

<table width="600" cellspacing="0" cellpadding="7" border="0">
	<tr>
		<td valign="top">

			<form bgcolor="white" method="POST" action="doProcess">
				<fieldset>
					<legend><h3>Vigenere Cipher Breaker - Arjun Kharel (G00298984)</h3></legend>
					<p>
					<b>Enter Length of the Key: <input name="frmMaxKeyLength" required="required" type="text" size="2" value="4">
					<p/>

					<b>Enter Cypher Text:</b><br>
					<textarea name="frmCypherText" rows="10" cols="100"  wrap="soft"></textarea>	
					<p/>
					<center><input type="submit" value="Crack Cypher"></center>
				</fieldset>							
			</form>	

		</td>
	</tr>
</table>

<%@ include file="includes/footer.jsp" %>

