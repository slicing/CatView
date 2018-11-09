<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Upload file</title>
</head>
<body>
    <h1>FILE UPLOAD</h1>
    <form method="post" ENCTYPE="multipart/form-data" action="/upload">
        <label>文件:
            <input type="file" name="slowFile"/>
        </label>
        <input type="submit" value="上传"/>
    </form>


    <#if error??>
        <h3>${error}</h3>
    <#elseif file??>
         <img src="/upload/${file}"/>
    </#if>
</body>
</html>