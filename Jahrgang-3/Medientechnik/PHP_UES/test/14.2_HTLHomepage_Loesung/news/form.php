<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]); ?>" method="post">
        <input type="text" name="name" id="name">
        <input type="text" name="lastname" id="lastname">
        <textarea name="descritption" id="description" cols="30" rows="10"></textarea>
        <input type="date" name="date" id="date">
        <input type="email" name="email" id="email">
        <button type="submit" name="submit">submit</button>
    </form>
