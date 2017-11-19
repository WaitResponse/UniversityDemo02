<%@page contentType="text/html; charset=utf-8" %>

<form action="upload.action" method="post" enctype="multipart/form-data">
	用户名<input type="text" name="uname"/><br/>
	头像 <input type="file" name="headImg"/><br/>
	<input type="submit" value="上传"/>
</form>
