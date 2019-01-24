<html>
<head>
    <title>Upload new Images</title>
    <meta charset="UTF-8">
    <link href="styles.css" rel="stylesheet">
</head>
<body>
<header>
    <nav>
        <a href="index.jsp">Home</a>
        <a href="upload.jsp" class="current_page">Upload</a>
        <a href="about.jsp">About</a>
    </nav>
</header>
<div id="content">

    <div id="input_side">
        <form action="upload" method="post"><fieldset>
            <div class="input_form_elem">
                <label for="title_input">Picture Title: </label><input type="text" name="title" id="title_input">
            </div>
            <div class="input_form_elem">
                <label for="image_input">Picture: </label><input type="file" name="image" id="image_input">
            </div>
            <div class="input_form_elem">
                <input type="reset" value="Reset">
                <input type="submit" value="Submit">
            </div>

        </fieldset></form>
    </div>

    <div id="preview_side">

    </div>
</div>
<footer>Copyright by Maurice</footer>
</body>
</html>